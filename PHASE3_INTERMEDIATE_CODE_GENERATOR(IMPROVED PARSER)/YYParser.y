
%{
  package chronicle;
  import java.io.*;
%}

%token <EVal> DOUBLE_DOT_KW SHARP_KW MOD_KW DIV_KW MUL_KW SUB_KW ADD_KW SINGLE_QUOTE_KW DOT_KW LTE_KW GTE_KW NEQ_KW EQ_KW GT_KW LT_KW COMMA_KW CLOSEPARENTHESIS_KW OPENPARENTHESIS_KW CLOSEACCOLADE_KW OPENACCOLADE_KW CLOSEBRACKET_KW OPENBRACKET_KW ASSIGN_KW COLON_KW SEMICOLON_KW NOT_KW OR_KW AND_KW DOWNTO_KW UPTO_KW EXIT_KW RETURN_KW FOR_KW WHEN_KW END_KW DEFAULT_KW CASE_KW SWITCH_KW WHILE_KW DO_KW ELSE_KW THEN_KW IF_KW PROCEDURE_KW BOOLEAN_KW CHARACTER_KW REAL_KW INTEGER_KW MAIN_KW PROGRAM_KW DIGIT NONZERO_DIGIT LETTER
%token <Eval> ID
%type <Eval> saved_id
%token <Eval> NUMCONSTANT
%type <Eval> saved_integer
%token <Eval> REALCONST
%type <Eval> saved_real
%token <Eval> CHARCONST
%type <Eval> saved_char
%token <Eval> BOOLCONST
%type <Eval> saved_boolean

%type <Eval> type_specifieirs initializer initializer_list declarator declarator_list dec range block statment_list statment case_element default expressions constant_expressions bool_expression arithmetic_expressions

/* Dup Tokens */
%token <Eval> LETTER
%token <Eval> DIGIT
%token <Eval> NON_ZERO_DIGIT
%token <Eval> HASH_KW
%token <Eval> BOOL_KW
%token <Eval> WHITE_SPACE
%token <Eval> LETDIG
%token <Eval> ID_KW
%token <Eval> NUMCONST
%token <Eval> WITHOUT_N
%token <Eval> CHARCONST
%token <Eval> COMMENT
%token <Eval> REALCONST
%token <Eval> OR_KW
%token <Eval> AND_KW
%token <Eval> ELSE_KW
%token <Eval> THEN_KW
%token <Eval> NOT_KW
%token <Eval> IF_KW
%token <Eval> END_KW
%token <Eval> SWITCH_KW
%token <Eval> WHILE_KW
%token <Eval> CASE_KW
%token <Eval> DEFAULT_KW
%token <Eval> BREAK_KW
%token <Eval> REL_OP_KW
%token <Eval> MATH_OP_KW
%token <Eval> UNARY_MATH_OP_KW
%token <Eval> MATH_OP_ASSIGN_KW
%token <Eval> UNARY_OP_KW
%token <Eval> RETURN_KW
%token <Eval> RECORD_KW
%token <Eval> STATIC_KW
%token <Eval> TYPESPECIFIER_KW
%token <Eval> PUNC_KW
%token <Eval> ASSIGN_KW
%token <Eval> SEMI_COLUMN_KW
%token <Eval> LEFTAC RIGHTAC LEFTAR RIGHTAR COLUMN TWO_COLUMN LEFTPA RIGHTPA DOT_KW //"{" "}" "[" "]" "," ":" "(" ")" "."
%type <Eval> Rectype ID TypeSpecifier ScopedTypeSpecifer VarDeclId VarDeclList
%type <Eval> VarDeclInitialize ScopedVarDelaration VarDeclaration Constant
%type <Eval> Immutable Factor UnaryExpression MathLogicExpression ASSIGNED_MATH_OP
%type <Eval> Mutable Expression RelExpression SimpleExpression SelectionStmt
%type <Eval> Statement rightPaQ StatementList IfExpression M ItereationStmt OrElseRel
%type <Eval> AndThenRel N ParamId ParamList ParamIdList ParamTypeList Params FunPart
%type <Eval> FunDeclaration Combo ReturnStmt CompoundStmt CaseElement DefaultElement
%type <Eval> Call ArgList Args SwitchExpression BreakStmt RecDeclaration RecLocalDeclarations RecScopedVarDelaration

%code {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static final String Arrstart = "start";
  public static final String Arrsize = "size";
  public static final String Arrindex = "index";

  public static String idVal,intVal,realVal,charVal,boolVal,mathOpVal,typeVal,unaryMathOpVal,unaryOpVal,mathOpAssignVal,relOpVal;
  private List<Quad> quadTable = new ArrayList();
  private SymbolTable symbolTable = new SymbolTable();
  private ScopeTable scopeTable = new ScopeTable(symbolTable);
  private CallTable callTable = new CallTable();
  private StructTable structTable = new StructTable();
  //emitMethod
  private void emit(String operation,String arg0,String arg1,String result)
  {
    quadTable.add(new Quad(operation,arg0,arg1,result));
    System.out.println(ANSI_PURPLE+"EMIT:"+operation+":"+arg0+":"+arg1+":"+result+ANSI_RESET);
  }

  private int tempCounter = 0;//newTempMethod
  private String newTemp(String type,boolean isArray,int size)
  {
    String name = "Temp"+(tempCounter++);
    emit(Eval.initOp,type,"",name);
    symbolTable.addToSymbolTable(name,type,isArray,size);
    return name;
  }

  private String newFunc(String funcName,String type)
  {
    String name = "Func"+funcName;
    symbolTable.addToSymbolTable(name,type,false,0);
    return name;
  }
  //backpatchMethod
  private void backpatch(ArrayList<Integer> list, int quadNumber) {
    for (int i = 0; i < list.size(); i++){
      if(quadTable.get(list.get(i)).operation.equals(Eval.assignOp)){
        quadTable.get(list.get(i)).arg0 = String.valueOf(quadNumber);
      }else{
        quadTable.get(list.get(i)).result = String.valueOf(quadNumber);
      }
    }
 }

 private void backpatch(ArrayList<Integer> list, String quadValue) {
   for (int i = 0; i < list.size(); i++){
     if(quadTable.get(list.get(i)).operation.equals(Eval.assignOp)){
       quadTable.get(list.get(i)).arg0 = quadValue;
     }else{
       quadTable.get(list.get(i)).result = quadValue;
     }
   }
}

 private void backpatch(int index, int quadNumber) {
    if(quadTable.get(index).operation.equals(Eval.assignOp)){
      quadTable.get(index).arg0 = String.valueOf(quadNumber);
    }else{
      quadTable.get(index).result = String.valueOf(quadNumber);
    }
 }

 private void setReturn(List<Integer>list,String result){
   for (int i = 0; i < list.size(); i++){
     quadTable.get(list.get(i)).result = result;
   }
 }
 //newQuadMethod
 private int nextQuad(){
   return quadTable.size();
 }
 //convertToTrueFalseIfPossibleMethod
 private String convertToTrueFalseIfPossible(String value)
 {
   if(value.equals(1+"")){
     value = "true";
   }else if(value.equals(0+"")) {
     value = "false";
   }
   return value;
 }

 private void writeFinalCode(String message)
 {
   message=message.replaceAll("#","");
   System.out.println(ANSI_YELLOW+message+ANSI_RESET);
 }
//generateCodeMethod
 private void generateCode()
 {
  String result = "";
  result = "#include<stdio.h>";
  System.out.println(ANSI_YELLOW+result+ANSI_RESET);
  result = "#include<iostream>";
  System.out.println(ANSI_YELLOW+result+ANSI_RESET);
  result = "#include<string>";
  System.out.println(ANSI_YELLOW+result+ANSI_RESET);
  result = "using namespace std;";
  System.out.println(ANSI_YELLOW+result+ANSI_RESET);
  List<StructTable.Record> structRecords = structTable.getAll();
  for(int i=0; i<structRecords.size();i++){
    result="struct "+ symbolTable.getByIndex(structRecords.get(i).symbolTableIndex).name+"{";
    writeFinalCode(result);
    StructTable.Record currentStruct= structRecords.get(i);
    for(int j=0 ; j < currentStruct.params.size(); j++){
      Quad current= currentStruct.params.get(j);
      if (current.operation.equals(Eval.constOp)) {
           result = "const "+current.arg0+" "+current.result+"="+current.arg1;

         }else if (current.operation.equals(Eval.initOp)) {
           SymbolTable.Record record=symbolTable.getSymbol(current.result);
           if(record.isArray==true){
            result = current.arg0+" "+current.result+"["+record.size+"]"+";";
            if(!current.arg1.equals("")){
                for(int p=0;p<record.size;p++){
                    result += "\n"+current.result+"["+p+"]"+"="+current.arg1+";";
                }
            }

            }else {
            result = current.arg0+" "+current.result+";";
            if(!current.arg1.equals("")){
              result += "\n"+current.result+"="+current.arg1+";";
            }
        }
       }
      writeFinalCode(result);
       }
       result = "};";
       writeFinalCode(result);
    }
   result = "int top = 0;";
   writeFinalCode(result);
   result = "string globalStack[1024];";
   writeFinalCode(result);
   List<ScopeRecord> scopeRecords = scopeTable.getAll();
   for(int i=0;i<scopeRecords.size();i++){
      if(scopeRecords.get(i).returnType!=Eval.unknownType){
        result = scopeRecords.get(i).returnType+" "+scopeRecords.get(i).returnValue+";";
        writeFinalCode(result);
      }
      String funcName = symbolTable.getByIndex(scopeRecords.get(i).symbolTableIndex).name;
      for(int j=scopeRecords.get(i).scopeStart;j<scopeRecords.get(i).scopeEnd;j++){
        if(j<0){
          continue;
        }
        SymbolTable.Record r=symbolTable.getByIndex(j);
        if(r.scope.equals("GLOBAL")||r.name.contains("Temp")){
          continue;
        }
        String newName = "L"+funcName+r.name;
        //for(int k=scopeRecords.get(i).emitStart;k<scopeRecords.get(i).emitEnd;k++){
        for(int k=scopeRecords.get(i).emitStart;k<scopeRecords.get(i).emitEnd;k++){
          Quad q = quadTable.get(k);
          // if(q.arg0.contains(funcName)
          //   ||q.arg1.contains(funcName)
          //   ||q.result.contains(funcName)
          //   // ||q.arg0.contains("Temp")
          //   // ||q.arg1.contains("Temp")
          //   // ||q.result.contains("Temp")
          //   )
          // {
          //   continue;
          // }
          if(q.arg0.contains(r.name) && !q.arg0.contains("Temp") && !q.arg0.contains(funcName)){
            q.arg0=q.arg0.replace(r.name,newName);
          }
          if(q.arg1.contains(r.name) && !q.arg1.contains("Temp") && !q.arg1.contains(funcName)){
            q.arg1=q.arg1.replace(r.name,newName);
          }
          if(q.result.contains(r.name)&& !q.result.contains("Temp") && !q.result.contains(funcName)){
            q.result=q.result.replace(r.name,newName);
          }
        }
        r.name = newName;
      }
   }

   result = "int targetLine=0;";
   writeFinalCode(result);
   result = "int main(){";
   writeFinalCode(result);
   result = "goto Line0;";
   writeFinalCode(result);
   List<CallTable.Record> callRecords = callTable.getAll();
   for(int i=0;i<callRecords.size();i++){
      result = "Call"+i;
      result += ": if("+callRecords.get(i).name+"==targetLine) goto "+callRecords.get(i).value+";";
      writeFinalCode(result);
   }
    for (int i=0;i<quadTable.size();i++) {
       result = "Line"+i+":";
       Quad current = quadTable.get(i);
       if(current.operation.equals(Eval.castOP))
       {
         String type = "";
         if(current.arg1.equals(Eval.INT)){
           type = "int";
         }else if(current.arg1.equals(Eval.REAL)){
           type = "float";
         }else if (current.arg1.equals(Eval.CHAR)) {
           type = "char";
         }
         result += current.result+"="+"("+"("+type+")"+current.arg0+");";
       }else if(current.operation.equals(Eval.assignOp)){
         result += current.result+"="+current.arg0+";";
       }else if (current.operation.equals(Eval.assignOp)) {
         result += "const "+current.arg0+" "+current.result+"="+current.arg1;
       }else if(current.operation.equals(Eval.andOp)){
         result += current.result+"="+current.arg0+"&&"+current.arg1+";";
       }else if(current.operation.equals(Eval.orOp)){
         result += current.result+"="+current.arg0+"||"+current.arg1+";";
       }else if(current.operation.equals(Eval.notOp)){
         result += current.result+"="+"!"+current.arg0+";";
      //  }else if (current.operation.equals(Eval.returnOp)) {
      //    result += "return "+current.result+";";
       }else if (current.operation.equals(Eval.initOp)) {
         SymbolTable.Record record=symbolTable.getSymbol(current.result);
         // if(record.isArray==true){
         //   if(current.arg1.equals("")){
         //      result += current.arg0+" "+current.result+"["+record.size+"]"+";";
         //    }else{
         //      result += current.arg0+" "+current.result+"["+record.size+"]"+"="+current.arg1+";";
         //    }
         // }else {
         //  if(current.arg1.equals("")){
         //   result += current.arg0+" "+current.result+";";
         //  }else {
         //   result += current.arg0+" "+current.result+"="+current.arg1+";";
         //  }
         // }
         if(record.isArray==true){
            result += current.arg0+" "+current.result+"["+record.size+"]"+";";
            if(!current.arg1.equals("")){
                for(int k=0;k<record.size;k++){
                    result += "\n"+current.result+"["+k+"]"+"="+current.arg1+";";
                }
            }
        }else {
          result += current.arg0+" "+current.result+";";
          if(!current.arg1.equals("")){
            result += "\n"+current.result+"="+current.arg1+";";
          }
        }
       }else if (current.operation.equals(Eval.ifOp)) {
          result += "if("+current.arg0+")"+"goto Line"+current.result+";";
       }else if (current.operation.equals(Eval.gotoOp)) {
          result += "goto "+"Line"+current.result+";";
       }else if(current.operation.equals(Eval.variableGotoOp)){
         result += "goto "+current.result+";";
       }else if (current.operation.equals(Eval.stackPop)) {
          result+="top = top -1;\n";
          result += current.result;
         //result+="=globalStack.pop();";
          if(current.arg0==Eval.INT){
            result+="=stoi(globalStack[top]);";
          }else if(current.arg0==Eval.CHAR){
            result+="=stoc(globalStack[top]);";
          }else if(current.arg0==Eval.REAL){
            result+="stof(globalStack[top]);";
          }else if(current.arg0==Eval.BOOL){
            result+="=stoi(globalStack[top]);";
          }
       }else if (current.operation.equals(Eval.stackPush)) {
       //  result+="globalStack.push("+current.result+");";
          result+="globalStack[top]="+current.result+";\ntop = top+1;";
       }else{
         boolean isUsed = false;
         for (int k=0;k<Eval.mathOpList.length;k++) {
            if(current.operation.equals(Eval.mathOpList[k])){
              isUsed = true;
              result += current.result+"="+current.arg0+current.operation+current.arg1+";";
              break;
            }
         }
         if(isUsed){
           writeFinalCode(result);
           continue;
         }
         for (int k=0;k<Eval.unaryMathOPList.length;k++) {
            if(current.operation.equals(Eval.unaryMathOPList[k])){
              isUsed = true;
              result += current.result+"="+current.result+current.operation+";";
              break;
            }
         }
         if(isUsed){
           writeFinalCode(result);
           continue;
         }
         for (int k=0;k<Eval.mathOpAssignList.length;k++) {
            if(current.operation.equals(Eval.mathOpAssignList[k])){
              isUsed = true;
              result += current.result+current.operation+current.arg0+";";
              break;
            }
         }
         if(isUsed){
           writeFinalCode(result);
           continue;
         }
         for (int k=0;k<Eval.uniryOpList.length;k++) {
            if(current.operation.equals(Eval.uniryOpList[k])){
              isUsed = true;
              result += current.result+"="+current.operation+current.arg0+";";
              break;
            }
         }
         for (int k=0;k<Eval.relopOpList.length;k++) {
            if(current.operation.equals(Eval.relopOpList[k])){
              isUsed = true;
              String operation = "";
              if(Eval.relopOpList[k].equals(".le")){
                operation = "<=";
              }else if(Eval.relopOpList[k].equals(".lt")) {
                operation = "<";
              }else if (Eval.relopOpList[k].equals(".gt")) {
                operation = ">";
              }else if (Eval.relopOpList[k].equals(".ge")) {
                operation = ">=";
              }else if (Eval.relopOpList[k].equals(".eq")) {
                operation = "==";
              }else if (Eval.relopOpList[k].equals(".ne")) {
                operation = "!=";
              }else {
                System.out.println(ANSI_RED+"Error:Relop not found for "+current.operation+ANSI_RESET);
               }
              result += "if("+current.arg0+operation+current.arg1+")"+current.result+"=true;\n";
              result += "else "+current.result+"=false;";
              break;
            }
         }
         if(!isUsed)
         {
           System.out.println(ANSI_RED+"Error:OpCode not found for "+current.operation+ANSI_RESET);
         }
      }
     writeFinalCode(result);
   }
    result = "Line"+quadTable.size()+":return 0;\n}";
    writeFinalCode(result);
 }
}
// Precedences go increasing, so "then" < "else".
%left OR_KW
%left AND_KW
%left ADD_KW SUB_KW
%right NOT_KW usub
%nonassoc THEN_KW
%nonassoc ELSE_KW
%nonassoc DOT_KW

%%
program:
	PROGRAM_KW saved_id MAIN_KW block {
		System.out.println("Rule 1.2: " +
			"program -> PROGRAM_KW saved_id MAIN_KW block");
		backpatch($4.nextList, nextQuad());
      	exportIntermediateCode();
	}
	| PROGRAM_KW saved_id declarations_list MAIN_KW block {
		System.out.println("Rule 1.3: " +
			"program -> PROGRAM_KW saved_id declarations_list MAIN_KW block");
		backpatch($5.nextList, nextQuad());
      	exportIntermediateCode();
	}
	| PROGRAM_KW saved_id procedure_list MAIN_KW block {
		System.out.println("Rule 1.4: " +
			"program -> PROGRAM_KW saved_id procedure_list MAIN_KW block");
		backpatch($5.nextList, nextQuad());
      	exportIntermediateCode();
	}
	| PROGRAM_KW saved_id declarations_list procedure_list MAIN_KW block {
		System.out.println("Rule 1.5: " +
			"program -> PROGRAM_KW saved_id declarations_list procedure_list MAIN_KW block");

		backpatch($6.nextList, nextQuad());
      	exportIntermediateCode();
	}
  	| PROGRAM_KW saved_id MAIN_KW {
		System.out.println("Rule 1.1: " +
			"program -> PROGRAM_KW saved_id MAIN_KW");
		exportIntermediateCode();
	}

declarations_list:
	declarations {
		System.out.println("Rule 2 :  declarations_list -> declarations ") ;
	}
	|  declarations_list declarations {
		System.out.println("Rule 3 :  declarations_list ->  declarations_list declarations") ;
	}
declarations:
	type_specifieirs declarator_list SEMICOLON_KW {
		System.out.println("Rule 4.1 :  declarations ->  type_specifieirs declarator_list") ;
		if($2.type == Eval.TYPECODES.UNKNOWN.getType() || $1.type == $2.type) {
			for(int i = 0; i < $2.initializersList.size(); i++) {
				if(symbolTable.lookUp(sizeStr + $2.declareds.get(i).place) == SymbolTable.NOT_IN_SYMBOL_TABLE) {
					symbolTable.setSymbol($2.declareds.get(i).place, $1.type, false);
					if($2.initializersList.get(i) != null && $2.initializersList.get(i).size() == 1) {
						emit(":=", $2.initializersList.get(i).get(0).place, null, $2.declareds.get(i).place);
						switch ($1.type) {
							case 0://Eval.TYPECODES.INTEGER.getType():
								emit("iprint", null, null, $2.declareds.get(i).place);
								break;
							case 1://Eval.TYPECODES.REAL.getType():
								emit("rprint", null, null, $2.declareds.get(i).place);
								break;
							case 2://Eval.TYPECODES.CHAR.getType():
								emit("cprint", null, null, $2.declareds.get(i).place);
								break;
						}
					} else if($2.initializersList.get(i) != null) {
						System.err.println("Error! Initializer number mismatch. (Expected: 1" + ", Number: " + $2.initializersList.get(i).size() + ")");
						return YYABORT;
					}
				} else {
					symbolTable.setSymbol($2.declareds.get(i).place, $1.type, true);
					emit("malloc", getTypeString($1.type), sizeStr + $2.declareds.get(i).place, $2.declareds.get(i).place);
					if($2.initializersList.get(i) != null) {
						for(int j = 0; j < $2.initializersList.get(i).size(); j++) {
							Eval.arrayIndexOutOfBoundList.add(nextQuad() + 1);
							emit(">=", String.valueOf(j), sizeStr + $2.declareds.get(i).place, condStr + $2.declareds.get(i).place);
							emit("check", condStr + $2.declareds.get(i).place, null, String.valueOf(nextQuad() + 2)); // Result will be backpatched.
							emit("[]=", $2.initializersList.get(i).get(j).place, String.valueOf(j), $2.declareds.get(i).place);
							emit("+", startStr + $2.declareds.get(i).place, String.valueOf(j), condStr + $2.declareds.get(i).place);
							switch ($1.type) {
								case 0://Eval.TYPECODES.INTEGER.getType():
									emit("aiprint", condStr + $2.declareds.get(i).place, String.valueOf(j), $2.declareds.get(i).place);
									break;
								case 1://Eval.TYPECODES.REAL.getType():
									emit("arprint", condStr + $2.declareds.get(i).place, String.valueOf(j), $2.declareds.get(i).place);
									break;
								case 2://Eval.TYPECODES.CHAR.getType():
									emit("acprint", condStr + $2.declareds.get(i).place, String.valueOf(j), $2.declareds.get(i).place);
									break;
							}
						}
					}
				}
			}
		} else {
			System.err.println("Error! Type specifier type mismatch. (" + $1.type + ", " + $2.type + ")");
			return YYABORT;
		}
	}
type_specifieirs:
	INTEGER_KW {
		System.out.println("Rule 5 :  type_specifieirs ->  INTEGER_KW") ;
		$$ = new Eval();
      	((Eval)$$).type = Eval.TYPECODES.INTEGER.getType();
	}
	| REAL_KW {
		System.out.println("Rule 6 :  type_specifieirs ->  REAL_KW") ;
		$$ = new Eval();
      	((Eval)$$).type = Eval.TYPECODES.REAL.getType();
	}
	| CHARACTER_KW {
		System.out.println("Rule 7 :  type_specifieirs ->  CHARACTER_KW") ;
		$$ = new Eval();
      	((Eval)$$).type = Eval.TYPECODES.CHAR.getType();
	}
	| BOOLEAN_KW {
		System.out.println("Rule 8 :  type_specifieirs ->  BOOLEAN_KW") ;
		$$ = new Eval();
      	((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
	}
declarator_list:
	declarator {
		System.out.println("Rule 9 :  declarator_list ->  declarator") ;
		$$ = new Eval();
		((Eval)$$).type = $1.type;
		((Eval)$$).declareds = Eval.makeInitializersOrDeclareds($1);
		((Eval)$$).initializersList = Eval.makeInitializersList($1.initializers);
	}
	| declarator_list COLON_KW declarator {
		System.out.println("Rule 10 :  type_specifieirs ->  declarator_list ->  declarator_list,declarator") ;
		if($1.type == Eval.TYPECODES.UNKNOWN.getType()
			|| $1.type == $3.type) {
			$$ = new Eval();
			((Eval)$$).type = $3.type;
			((Eval)$$).declareds = $1.declareds;
			((Eval)$$).declareds.add($3);
			((Eval)$$).initializersList = $1.initializersList;
			((Eval)$$).initializersList.add($3.initializers);
		} else {
			System.err.println("Error! Declarator type mismatch.");
			return YYABORT;
		}
	}
declarator:
	dec {
		System.out.println("Rule 11 :  declarator -> dec") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = Eval.TYPECODES.UNKNOWN.getType();
		((Eval)$$).array = $1.array;
		((Eval)$$).initializers = null;
	}
	| dec ASSIGN_KW initializer {
		System.out.println("Rule 12 :  declarator -> dec := initializer") ;
		if($1.array != $3.array) {
			System.err.println("Error! Array mismatch: " + $1.place + " and " + $3.place + " are not the same.");
			return YYABORT;
		}
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $3.type;
		((Eval)$$).array = $1.array;
		((Eval)$$).initializers = $3.initializers;
	}
dec:
	saved_id {
		System.out.println("Rule 13 :  dec -> saved_id ") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).array = false;
	}
	| saved_id OPENBRACKET_KW range CLOSEBRACKET_KW {
		System.out.println("Rule 14 :  dec -> saved_id[range] ") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).array = true;

		symbolTable.setSymbol(startStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", startStr + $3.place, null , startStr + ((Eval)$$).place);

		symbolTable.setSymbol(sizeStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", sizeStr + $3.place, null , sizeStr + ((Eval)$$).place);

		symbolTable.setSymbol(indexStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		symbolTable.setSymbol(condStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
	}
	| saved_id OPENBRACKET_KW saved_integer CLOSEBRACKET_KW {
		System.out.println("Rule 15 :  dec -> saved_id[saved_integer] ") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).array = true;

		symbolTable.setSymbol(startStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", "0", null , startStr + ((Eval)$$).place);

		symbolTable.setSymbol(sizeStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", $3.place, null , sizeStr + ((Eval)$$).place);

		symbolTable.setSymbol(indexStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
		symbolTable.setSymbol(condStr + ((Eval)$$).place, Eval.TYPECODES.INTEGER.getType(), false);
	}
range:
	saved_id DOT_KW DOT_KW  saved_id {
		System.out.println("Rule 16 :  range -> saved_id .. saved_id ") ;
	}
	| saved_integer DOT_KW DOT_KW saved_integer {
		System.out.println("Rule 17 :  range -> saved_integer .. saved_integer ") ;
	}
	| arithmetic_expressions DOT_KW DOT_KW arithmetic_expressions {
		System.out.println("Rule 18 : range -> arithmetic_expressions .. arithmetic_expressions") ;
	}
initializer:
	constant_expressions {
		System.out.println("Rule 19 :  initializer -> constant_expressions ") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).nextList = $1.nextList;
		((Eval)$$).initializers.add($1);
	}
	| OPENACCOLADE_KW initializer_list CLOSEACCOLADE_KW {
		System.out.println("Rule 19 :  initializer -> {initializer_list} ") ;
		$$ = new Eval();
		((Eval)$$).type = $2.type;
		((Eval)$$).array = $2.array;
		((Eval)$$).initializers = $2.initializers;
	}
initializer_list:
	constant_expressions COLON_KW initializer_list {
		System.out.println("Rule 20 :  initializer_list -> constant_expressions, initializer_list ") ;
		if($1.type == $3.type) {
			$$ = new Eval();
			((Eval)$$).type = $1.type;
			((Eval)$$).array = true;
			((Eval)$$).initializers = $3.initializers;
			((Eval)$$).initializers.add($1);
		} else {
			System.err.println("Error! Initializer type mismatch.");
			return YYABORT;
		}
	}
	| constant_expressions {
		System.out.println("Rule 21 :  initializer_list -> constant_expressions ") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).nextList = $1.nextList;
		((Eval)$$).initializers.add($1);
	}
procedure_list:
	procedure_list procedure  {
		System.out.println("Rule 22.1 : procedure_list -> procedure_list procedure") ;
	}
	| procedure  {
		System.out.println("Rule 22.2 : procedure_list -> procedure") ;
	}
procedure:
	PROCEDURE_KW saved_id parameters OPENACCOLADE_KW declarations_list block CLOSEACCOLADE_KW SEMICOLON_KW {
		System.out.println("Rule 23 :  procedure -> PROCEDURE_KW saved_id parameters {declarations_list block} ") ;
	}
parameters:
	OPENPARENTHESIS_KW declarations_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 24 :  parameters -> ( declarations_list ) ") ;
	}
block:
	OPENACCOLADE_KW statment_list CLOSEACCOLADE_KW {
		System.out.println("Rule 25 :  block -> {statment_list} ") ;
		$$ = new Eval();
		((Eval)$$).nextList = $2.nextList;
	}
	| OPENACCOLADE_KW CLOSEACCOLADE_KW {
		$$ = new Eval();
		((Eval)$$).nextList = Eval.makeList(nextQuad());
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	}
statment_list:
	statment SEMICOLON_KW {
		System.out.println("Rule 26 :  statment_list -> statment ") ;
	}
	| statment_list statment SEMICOLON_KW {
		System.out.println("Rule 27 :  statment_list -> statment_list statment; ") ;
	}
statment:
	saved_id ASSIGN_KW expressions {
		System.out.println("Rule 28 :  statment -> saved_id := expressions ") ;
	}
	| IF_KW bool_expression THEN_KW statment ELSE_KW statment {
		System.out.println("Rule 29 :  statment -> IF bool_expression THEN statment ELSE_KW statment") ;
	}
	| IF_KW bool_expression THEN_KW statment {
		System.out.println("Rule 29 :  statment -> IF bool_expression THEN statment ") ;
	}
	| DO_KW statment WHILE_KW bool_expression {
		System.out.println("Rule 30 :  statment -> DO statment WHILE bool_expression ") ;
	}
	| FOR_KW saved_id ASSIGN_KW counter DO_KW statment {
		System.out.println("Rule 31 :  statment -> FOR saved_id := counter DO statment ") ;
	}
	| SWITCH_KW expressions case_element default END_KW {
		System.out.println("Rule 31.1 :  statment -> SWITCH_KW expressions case_element default END_KW ") ;
	}
	| saved_id OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 32 :  statment ->  saved_id (arguments_list)") ;
	}
	| saved_id OPENBRACKET_KW expressions CLOSEBRACKET_KW ASSIGN_KW expressions {
		System.out.println("Rule 33 :  statment ->  saved_id [ expressions ] := expressions") ;
	}
	| RETURN_KW expressions {
		System.out.println("Rule 34 :  statment -> RETURN expressions ") ;
	}
	| EXIT_KW WHEN_KW bool_expression {
		System.out.println("Rule 35 :  statment ->  EXIT WHEN_KW bool_expression") ;
	}
	| block {
		System.out.println("Rule 36.1 :  statment ->  block") ;
	}

arguments_list:
	multi_arguments {
		System.out.println("Rule 37 :  arguments_list -> multi_arguments") ;
	}

multi_arguments:
	multi_arguments "," expressions {
		System.out.println("Rule 39 :  multi_arguments -> multi_arguments,expressions") ;
	}
	| expressions {
		System.out.println("Rule 40 :  multi_arguments -> expressions") ;
	}
counter:
	saved_integer UPTO_KW saved_integer {
		System.out.println("Rule 41 :  counter -> saved_integer UPTO_KW saved_integer") ;
	}
	| saved_integer DOWNTO_KW saved_integer {
		System.out.println("Rule 42 :  counter -> saved_integer DOWNTO_KW saved_integer") ;
	}
case_element:
	CASE_KW saved_integer DOUBLE_DOT_KW block {
		System.out.println("Rule 43 :  case_element -> CASE_KW saved_integer : block") ;
	}
	| case_element CASE_KW saved_integer DOUBLE_DOT_KW block {
		System.out.println("Rule 44 :  case_element -> case_element CASE_KW saved_integer : block") ;
	}
default:
	DEFAULT_KW DOUBLE_DOT_KW block {
		System.out.println("Rule 45 :  default -> DEFAULT_KW ':' block") ;
	}

expressions:
	constant_expressions {
		System.out.println("Rule 47 :  expressions -> constant_expressions") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).nextList = $1.nextList;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
	}
	| bool_expression {
		System.out.println("Rule 48 :  expressions -> bool_expression") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)$$).nextList = $1.nextList;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
	}
	| arithmetic_expressions {
		System.out.println("Rule 49 :  expressions -> arithmetic_expressions") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).nextList = $1.nextList;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
	}
	| saved_id OPENBRACKET_KW expressions CLOSEBRACKET_KW {
		System.out.println("Rule 51 :  expressions -> saved_id [expressions]") ;
		int index = symbolTable.lookUp($1.place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (!symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not an array, it can not be used with index.");
			return YYABORT;
		}
		$$ = new Eval();
		((Eval)$$).place = newTemp(symbolTable.types.get(index), false);
		((Eval)$$).type = symbolTable.types.get(index);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 2);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 4);
		emit("-", $3.place, startStr + $1.place, indexStr + $1.place);
		emit(">=", indexStr + $1.place, sizeStr + $1.place, condStr + $1.place);
		emit("check", condStr + $1.place, null, String.valueOf(nextQuad() + 3));
		emit("<", indexStr + $1.place, "0", condStr + $1.place);
		emit("check", condStr + $1.place, null, String.valueOf(nextQuad() + 1));

		emit("=[]", $1.place, indexStr + $1.place, ((Eval)$$).place);

		((Eval)$$).trueList = Eval.makeList(nextQuad());
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));

	}
	| saved_id OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 52 :  expressions -> saved_id (arguments_list)") ;
		int index = symbolTable.lookUp($1.place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (!symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not an array, it can not be used with index.");
			return YYABORT;
		}
		$$ = new Eval();
		((Eval)$$).place = newTemp(symbolTable.types.get(index), false);
		((Eval)$$).type = symbolTable.types.get(index);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 2);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 4);
		emit("-", $3.place, startStr + $1.place, indexStr + $1.place);
		emit(">=", indexStr + $1.place, sizeStr + $1.place, condStr + $1.place);
		emit("check", condStr + $1.place, null, String.valueOf(nextQuad() + 3));
		emit("<", indexStr + $1.place, "0", condStr + $1.place);
		emit("check", condStr + $1.place, null, String.valueOf(nextQuad() + 1));

		emit("=()", $1.place, indexStr + $1.place, ((Eval)$$).place);

		((Eval)$$).trueList = Eval.makeList(nextQuad());
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	}
	| saved_id {
		System.out.println("Rule 50 :  expressions -> saved_id") ;
		int index = symbolTable.lookUp($1.place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is an array, it can not be used without index.");
			return YYABORT;
		}
		$$ = new Eval();
		((Eval)$$).place = symbolTable.names.get(index);
		((Eval)$$).type = symbolTable.types.get(index);

		((Eval)$$).trueList = Eval.makeList(nextQuad());
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	}
	| OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 53 :  expressions -> (expressions)") ;
		$$ = new Eval();
		((Eval)$$).place = $2.place;
		((Eval)$$).type = $2.type;
		((Eval)$$).nextList = $2.nextList;
		((Eval)$$).trueList = $2.trueList;
		((Eval)$$).falseList = $2.falseList;
	}
constant_expressions:
	saved_integer {
		System.out.println("Rule 54 :  constant_expressions -> saved_integer") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
		((Eval)$$).nextList = $1.nextList;
	}
	| saved_real {
		System.out.println("Rule 55 :  constant_expressions -> saved_real") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
		((Eval)$$).nextList = $1.nextList;
	}
	| saved_char {
		System.out.println("Rule 56 :  constant_expressions -> saved_char") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
		((Eval)$$).nextList = $1.nextList;
	}
	| saved_boolean {
		System.out.println("Rule 57 :  constant_expressions -> saved_boolean") ;
		$$ = new Eval();
		((Eval)$$).place = $1.place;
		((Eval)$$).type = $1.type;
		((Eval)$$).trueList = $1.trueList;
		((Eval)$$).falseList = $1.falseList;
		((Eval)$$).nextList = $1.nextList;
	}
bool_expression:
	NEQ_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 58 :  bool_expression -> <> pair") ;
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);

		emit("<>", $1.place, $3.place, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	}
	| LTE_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 59 :  bool_expression -> <= pair") ;
	}
	| LT_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 60 :  bool_expression -> < pair") ;
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);

		emit("<", $1.place, $3.place, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	}
	| GTE_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 61 :  bool_expression -> >= pair") ;
	}
	| GT_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 62 :  bool_expression -> > pair") ;
	}
	| EQ_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 63 :  bool_expression -> = pair") ;
	}
	| AND_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 64 :  bool_expression -> AND pair") ;
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		backpatch($1.trueList, $5.quad);
		((Eval)$$).trueList = $6.trueList;
		((Eval)$$).falseList = Eval.merge($1.falseList, $6.falseList);
	}
	| OR_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 65 :  bool_expression -> OR pair") ;
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		backpatch($1.trueList, $5.quad);
		((Eval)$$).trueList = $6.trueList;
		((Eval)$$).falseList = Eval.merge($1.falseList, $6.falseList);
	}
	| AND_KW THEN_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 66 :  bool_expression -> AND THEN pair") ;
	}
	| OR_KW ELSE_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 67 :  bool_expression -> OR ELSE pair") ;
	}
	| NOT_KW expressions {
		System.out.println("Rule 68 :  bool_expression -> NOT expressions") ;
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)$$).trueList = $2.falseList;
		((Eval)$$).falseList = $2.trueList;
	}
arithmetic_expressions:
	ADD_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 69 :  arithmetic_expressions -> + pair") ;

	}
	| SUB_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 70 :  arithmetic_expressions -> - pair") ;
	}
	| MUL_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 71 :  arithmetic_expressions -> * pair") ;
	}
	| DIV_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 72 :  arithmetic_expressions -> / pair") ;
	}
	| MOD_KW OPENPARENTHESIS_KW expressions COLON_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 73 :  arithmetic_expressions -> % pair") ;
	}
	| SUB_KW expressions {
		System.out.println("Rule 74 :  arithmetic_expressions -> - expressions") ;
	}

saved_id:
	ID {
		System.out.println("Rule 76: " +
			"saved_identifier: IDENTIFIER");
		$$ = new Eval();
		((Eval)$$).place = lexIdentifier;
	}

saved_integer:
	NUMCONSTANT {
		System.out.println("Rule 77: " +
			"saved_integer: NUMCONSTANT");
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.INTEGER.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.INTEGER.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit(":=", String.valueOf(lexInt), null, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.

	}

saved_real:
	REALCONST {
		System.out.println("Rule 78: " +
			"saved_real: REAL_CONSTANT");
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.REAL.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.REAL.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit(":=", String.valueOf(lexReal), null, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	}

saved_char:
	CHARCONST {
		System.out.println("Rule 79: " +
			"saved_char: CHAR_CONSTANT");
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.CHAR.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.CHAR.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		emit(":=", "'" + String.valueOf(lexChar) + "'", null, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	}

saved_boolean:
	BOOLCONST {
		System.out.println("Rule 80: " +
			"saved_boolean: BOOLEAN_CONSTANT");
		$$ = new Eval();
		((Eval)$$).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)$$).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)$$).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)$$).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)$$).nextList = Eval.merge(((Eval)$$).trueList, ((Eval)$$).falseList);

		if(lexBoolean)
			emit(":=", "1", null, ((Eval)$$).place);
		else
			emit(":=", "0", null, ((Eval)$$).place);
		emit("check", ((Eval)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	}

%%

/* Eval class */
/* The ghost of anything :D */

class Eval
{
  public static final String INT ="int";
  public static final String BOOL = "bool";
  public static final String REAL = "real";
  public static final String CHAR = "char";
  public static final String STRING = "string";
  public static final String Func = "function";
  public static final String rectype = "rectype";
  public static final String unknownType = "unknown";

  public static final String castOP = "cast";
  public static final String constOp = "const";
  public static final String assignOp = "=";
  public static final String andOp = "and";
  public static final String orOp = "or";
  public static final String notOp = "not";
  public static final String initOp = "init";
  public static final String ifOp = "if";
  public static final String stackPop = "stackPop";
  public static final String stackPush = "stackPush";
  public static final String gotoOp = "gotoOp";
  public static final String variableGotoOp = "varGotoOp";

  public static final String[] relopOpList = new String[]{".le",".lt",".gt",".ge",".eq",".ne"};
  public static final String[] mathOpList = new String[]{"+","-","*","/","%"};
  public static final String[] unaryMathOPList = new String[]{"++","--"};
  public static final String[] mathOpAssignList = new String[]{"+=","-=","*=","/="};
  public static final String[] uniryOpList = new String[]{"-","*","?"};

  public String place;
  public String type;
  public boolean isArray;
  public int size;
  public int quad;
  public int symbolTableQuad;
  public int endOfFuncWaitingGoto;
  public String place2;
  public String returnName;
  public int endOfBreakGoto=-1;

  public Eval defaultInit;

  public List<Eval> typeInitList;
  public ArrayList<Integer> trueList;
  public ArrayList<Integer> falseList;
  public ArrayList<Integer> breakList;
  public ArrayList<Integer> nextList;
  public List<Integer> returnList;
  public List<Eval> argsList;
  public ArrayList<Quad> structList;

  public int quadIndex;
  public ArrayList<Integer> caseStartPoint;
  public ArrayList<Eval> declaredCases;

  public Eval()
  {
    typeInitList = new ArrayList<>();
    falseList = new ArrayList<>();
    nextList = new ArrayList<>();
    returnList = new ArrayList<>();
    argsList = new ArrayList<>();
    breakList= new ArrayList<>();
    structList= new ArrayList<>();
  }
  public static ArrayList<Integer> makeList(int i) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(i);
    return list;
  }
  public static ArrayList<Integer> merge(List i , List j){
      ArrayList<Integer> list = new ArrayList<>();
      if(i!=null && i.size()>0){
          list.addAll(i);
      }
      if(j!=null && j.size()>0){
          list.addAll(j);
      }
      return list;
  }
}


/* Scoping classes */
class ScopeRecord {
  public int symbolTableIndex;
  public int scopeStart;
  public int scopeEnd;
  public int emitStart;
  public int emitEnd;
  public boolean isFunction;
  public List<Integer>params;
  public String returnValue;
  public String returnType;
  public String startLine;
  public ScopeRecord(int symbolTableIndex,int scopeStart,int scopeEnd,int emitStart,int emitEnd,boolean isFunction,List<Integer>params,String returnValue,String returnType,String startLine)
  {
    this.symbolTableIndex = symbolTableIndex;
    this.scopeStart = scopeStart;
    this.scopeEnd = scopeEnd;
    this.emitStart = emitStart;
    this.emitEnd = emitEnd;
    this.isFunction = isFunction;
    this.params = params;
    this.returnValue = returnValue;
    this.returnType = returnType;
    this.startLine = startLine;
  }
}
//ScopeTableClass
class ScopeTable {
  private List<ScopeRecord> table;
  private SymbolTable symbolTable;
  public ScopeTable(SymbolTable symbolTable)
  {
    table = new ArrayList<>();
    this.symbolTable = symbolTable;
  }
  //It's symbolTable index not it's index
  public ScopeRecord getByIndex(int index){
    for(int i=0;i<table.size();i++){
      if(table.get(i).symbolTableIndex==index){
        return table.get(i);
      }
    }
    return null;
  }

  public ScopeRecord getByName(String name)
  {
    int index = symbolTable.lookUp(name);
    if(index==-1){
      return null;
    }
    return getByIndex(index);
  }

  public List<ScopeRecord> getAll(){
    return table;
  }

  public void addNewScope(int symbolTableIndex,int scopeStart,int scopeEnd,int emitStart,int emitEnd)
  {
    table.add(new ScopeRecord(symbolTableIndex,scopeStart,scopeEnd,emitStart,emitEnd,false,null,"",Eval.unknownType,""));
  }
  public void addNewScope(int symbolTableIndex,int scopeStart,int scopeEnd,int emitStart,int emitEnd,List<Integer>params,String funcName,String returnType,String startLine)
  {
    table.add(new ScopeRecord(symbolTableIndex,scopeStart,scopeEnd,emitStart,emitEnd,true,params,funcName,returnType,startLine));
  }
}

/* Call table material */

class CallTable{
  private List<Record> callRecords;
  protected class Record{
    public int name;
    public String value;
    public Record(int name,String value){
      this.name = name;
      this.value = value;
    }
  }
  public CallTable()
  {
    callRecords = new ArrayList<>();
  }
  public void addNewCall(int name,String value)
  {
    callRecords.add(new Record(name,value));
  }
  public List<Record> getAll()
  {
    return callRecords;
  }
}

/* Quad class */
class Quad
{
  public String operation;
  public String arg0;
  public String arg1;
  public String result;
  public Quad(String operation,String arg0,String arg1,String result)
  {
    this.operation = operation;
    this.arg0 = arg0;
    this.arg1 = arg1;
    this.result = result;
  }
}
/* Symbol Table */
class SymbolTable
{
  public static final int NOT_FOUND = -1;
  public static final int ERROR = -2;
  protected class Record
  {
      public String name;
      public String type;
      public boolean isArray;
      public int size;
      public String scope="";
      public Record(String name,String type,boolean isArray,int size)
      {
          this.name = name;
          this.type = type;
          this.isArray = isArray;
          this.size = size;
      }
  }

  private List<Record> table;

  public SymbolTable()
  {
      table = new ArrayList<>();
  }

  public Record getSymbol(String name)
  {
    int index = lookUp(name);
    if(lookUp(name)!=NOT_FOUND){
      return table.get(index);
    }else {
      return null;
    }
  }

  public Record getByIndex(int index){
    return table.get(index);
  }

  public int lookUp(String name)
  {
    for(int i=0;i<table.size();i++){
      if(table.get(i).name.equals(name)){
        return i;
      }
    }
    return NOT_FOUND;
  }

  public int getSize()
  {
    return table.size();
  }

  public int addToSymbolTable(String name,String type,boolean isArray,int size)
  {
    boolean found = false;
    for(int i=0;i<table.size();i++){
      if(table.get(i).name.equals(name) && table.get(i).scope.equals("")){
        found = true;
        break;
      }
    }
    if(!found)
    {
      Record p = new Record(name,type,isArray,size);
      table.add(p);
      return table.size()-1;
    }
    return ERROR;
  }
}

/* Struct Table Class */

class StructTable{
  private List<Record> structRecords;
  protected class Record{
      public int symbolTableIndex;
      public List<Quad>params;
      public Record(int symbolTableIndex, List<Quad>params){
            this.symbolTableIndex = symbolTableIndex;
          this.params = params;
      }
    }
    public StructTable(){
      structRecords = new ArrayList<>();
    }
    // private void emit(String operation,String arg0,String arg1,String result)
    public void addnewStruct(int symbolTableIndex,List<Quad>params){
      structRecords.add(new Record(symbolTableIndex,params));
    }

    public List<Record> getAll()
    {
      return structRecords;
    }

}

class Quadruple {
    public static final String LINE_STR = "Line";
    public String operation;
    public String arg0;
    public String arg1;
    public String result;

    public Quadruple(String operation, String arg0, String arg1, String result){
        this.operation = operation;
        this.arg0 = arg0;
        this.arg1 = arg1;
        this.result = result;
    }

    public String print() {
        switch(operation.toLowerCase()){
            case "goto":
                return operation + " " + LINE_STR + result + ";";
            case "check":
                return "if (" + arg0 + ") goto " + LINE_STR + result + ";";
            case "<":
            case "<=":
            case ">":
            case ">=":
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                return result + " = " + arg0 + " " + operation + " " + arg1 + ";";
            case "=":
                return result + " = " + arg0 + " " + "==" + " " + arg1 + ";";
            case "<>":
                return result + " != " + arg0 + " " + "==" + " " + arg1 + ";";
            case "usub":
                return result + " = -" + arg0 + ";";
            case ":=":
                return result + " = " + arg0 + ";";
            case "cast":
                return result + " = (" + arg1 + ") " + arg0 + ";";
            case "init":
                return arg1 + " " + result + ";";
            case "iprint":
                return "printf(\"%s = %d\\n\", \"" + result + "\", " + result + ");";
            case "rprint":
                return "printf(\"%s = %f\\n\", \"" + result + "\", " + result + ");";
            case "cprint":
                return "printf(\"%s = '%c'\\n\", \"" + result + "\", " + result + ");";
            case "bprint":
                return "printf(\"%s = %s\\n\", \"" + result + "\", " + result + " ? \"true\" : \"false\");";
            case "aiprint":
                return "printf(\"%s[%d] = %d\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
            case "arprint":
                return "printf(\"%s[%d] = %f\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
            case "acprint":
                return "printf(\"%s[%d] = '%c'\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
            case "abprint":
                return "printf(\"%s[%d] = %s\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "] ? \"true\" : \"false\");";
            case "[]=":
                return "*(" + result + " + " + arg1 + ") = " + arg0 + ";";
            case "=[]":
                return result + " = *(" + arg0 + " + " + arg1 + ");";
            case "malloc":
                return result + " = " + "malloc(sizeof(" + arg0 + ") * " + arg1+ ");";
            default:
                return null;
        }
    }

}
