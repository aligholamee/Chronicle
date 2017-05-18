
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


%code {

    public static String lexIdentifier;
    public static int lexInt;
    public static double lexReal;
    public static boolean lexBoolean;
    public static char lexChar;

    private static final String tempStr = "TempVar";
    public static final String startStr = "StartVar";
    public static final String sizeStr = "SizeVar";
    public static final String indexStr = "IndexVar";
    public static final String condStr = "ConditionVar";

    public int tempCounter = 0;

	public Vector<Quadruple> quadTable = new Vector<>();
    public SymbolTable symbolTable = new SymbolTable();
    private void emit(String operation,String arg0,String arg1,String result)
    {
        quadTable.add(new Quadruple(operation,arg0,arg1,result));
        System.out.println("EMIT:"+operation+":"+arg0+":"+arg1+":"+result);
    }


    /* nextQuad function */
    /* Give us the address of the current(+1 is next) quad in the table which is equal to the size of the quadRuple table */
    private int nextQuad() {
        return quadTable.size();
    }

    /* backpatch Function #1*/
    private void backpatch(Vector<Integer> list, int quadNumber) {
        for (int i:list)
            quadTable.get(i).result = String.valueOf(quadNumber);
    }

    /* backpatch Function #2*/
    private void backpatch(int quadNumber, int destination) {
        quadTable.get(quadNumber).result = String.valueOf(destination);
    }

    private String newTemp(int type, boolean array) {
        String name = tempStr + tempCounter++;
        symbolTable.setSymbol(name, type, array);
        return name;
    }

	private String getTypeString(int typeCode){
		switch(typeCode){
			case 0://Eval.TYPE_CODE_INTEGER:
				return Eval.TYPES.INTEGER.getType();
			case 1://Eval.TYPE_CODE_REAL:
				return Eval.TYPES.REAL.getType();
			case 2://Eval.TYPE_CODE_CHAR:
				return Eval.TYPES.CHAR.getType();
			case 3://Eval.TYPE_CODE_BOOLEAN:
				return Eval.TYPES.BOOLEAN.getType();
			case -1:
			case 4:
			default:
				return null;
		}
	}

    /* Code Exporting Function */
    private void exportIntermediateCode() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("./output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dos.writeBytes("#include <stdio.h>\n\nint main() {\n\t// ////////////////// Symbol Table \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \\\\\n\n");
            dos.writeBytes(symbolTable.print());
            dos.writeBytes("\n\t// ////////////////// Quadruples \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \\\\\n\n");
            // Backpatch of error controllers.
            backpatch(Eval.arrayIndexOutOfBoundList, (quadTable.size() + 1)); // Array index out of bound error.
            backpatch(Eval.invalidArraySizeList, (quadTable.size() + 2)); // Invalid array size error.
            for (int i = 0; i < quadTable.size() && i < 100; i++) {
                dos.writeBytes(Quadruple.LINE_STR + i + ":" + "\t\t" + quadTable.get(i).print() + "\n");
            }
            for (int i = 100; i < quadTable.size(); i++) {
                dos.writeBytes(Quadruple.LINE_STR + i + ":" + "\t\t" + quadTable.get(i).print() + "\n");
            }
            // Normal Finish
            if(quadTable.size() < 100)
                dos.writeBytes(Quadruple.LINE_STR + quadTable.size() + ":" + "\t\tprintf(\"Process is terminated with no error.\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\t\treturn 0;\n");
            else
                dos.writeBytes(Quadruple.LINE_STR + quadTable.size() + ":" + "\t\tprintf(\"Process is terminated with no error.\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\t\treturn 0;\n");

            // Array index out of bound error.
            if(quadTable.size() < 100)
                dos.writeBytes(Quadruple.LINE_STR + (quadTable.size() + 1) + ":" + "\t\tprintf(\"Array Error: Index out of bound!\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\treturn -1;\n");
            else
                dos.writeBytes(Quadruple.LINE_STR + (quadTable.size() + 1) + ":" + "\t\tprintf(\"Array Error: Index out of bound!\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\treturn -1;\n");

            // Invalid array size error.
            if(quadTable.size() < 100)
                dos.writeBytes(Quadruple.LINE_STR + (quadTable.size() + 2) + ":" + "\t\tprintf(\"Array Error: Invalid array size!\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\treturn -2;\n");
            else
                dos.writeBytes(Quadruple.LINE_STR + (quadTable.size() + 2) + ":" + "\t\tprintf(\"Array Error: Invalid array size!\\n\");\n" +
                    "\t\t\t\tgetchar();\n\t\t\treturn -2;\n");

            dos.writeBytes("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static PrintStream writer;

    public static void main(String args[]) throws IOException, FileNotFoundException {
        YYParser yyparser;
        final Yylex lexer;

        writer = new PrintStream(new File("output.txt"));
        lexer = new Yylex(new InputStreamReader(new FileInputStream("java_code.txt")));

        yyparser = new YYParser(new Lexer() {

            @Override
            public int yylex() {
                int yyl_return = -1;
                try {

                    yyl_return = lexer.yylex();
                } catch (IOException e) {
                    System.err.println("IO error :" + e);
                }
                return yyl_return;
            }

            @Override
            public void yyerror(String error) {
                System.err.println("Error : " + error);
            }

            @Override
            public Object getLVal() {
                return null;//lexer.yytext();
            }
        });
        yyparser.parse();

        return;
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

class SymbolTable {

	public static final int NOT_IN_SYMBOL_TABLE = -1;

	public Vector<String> names;
	public Vector<Integer> types;
	public Vector<Boolean> arrays;

	public SymbolTable() {
		names = new Vector<>();
		types = new Vector<>();
		arrays = new Vector<>();
	}

	public int lookUp(String name) {
		return names.indexOf(name);
	}

	public boolean setSymbol(String name, int type, boolean array) {
		if (lookUp(name) == -1) {
			names.add(name);
			types.add(type);
			arrays.add(array);
			return true;
		}
		return false;
	}

    public String print() {
        if(names.size() == 0)
            return null;
        String res = "";
        for(int i = 0; i < names.size(); i++) {
            switch (types.get(i)) {
                case 1://Eval.TYPECODES.INTEGER.getType():
                    res += "\t" + Eval.TYPES.INTEGER.getType();
                    break;
                case 2://Eval.TYPECODES.REAL.getType():
                    res += "\t" + Eval.TYPES.REAL.getType();
                    break;
                case 3://Eval.TYPECODES.CHAR.getType():
                    res += "\t" + Eval.TYPES.CHAR.getType();
                    break;
                case 4://Eval.TYPECODES.BOOLEAN.getType():
                    res += "\t" + Eval.TYPES.BOOLEAN.getType();
                    break;
                case 5://Eval.TYPECODES.RANGE.getType():
                    continue;
            }
            res += (arrays.get(i) ? " *" : " ") + names.get(i) + ";\n";
        }
        return res;
	}

}

class Eval{
    public static Vector<Integer> arrayIndexOutOfBoundList = new Vector<>();
	public static Vector<Integer> invalidArraySizeList = new Vector<>();

	public String place;
	public int type;
	public boolean array;

	public int quad;

	public Eval defaultInit;
	public Vector<Eval> typeInitList = new Vector<>();
	public Vector<Vector<Eval>> initializersList = new Vector<>();
	public Vector<Eval> declareds = new Vector<>();
	public Vector<Eval> initializers = new Vector<>();
    public Vector<Integer> trueList = new Vector<>();
    public Vector<Integer> falseList = new Vector<>();
    public Vector<Integer> nextList = new Vector<>();

    public static Vector<Integer> makeList(int i) {
        Vector<Integer> list = new Vector<>();
        list.add(i);
        return list;
    }

    public static Vector<Integer> merge(Vector i , Vector j) {
        Vector<Integer> list = new Vector<>();
        if(i!=null && i.size()>0) {
            list.addAll(i);
        }
        if(j!=null && j.size()>0) {
            list.addAll(j);
        }
        return list;
    }

	public static enum TYPES {
        INTEGER("int"),
        BOOLEAN("bool"),
        REAL("float"),
        CHAR("char"),
        STRING("string"),
        Func("function"),
        rectype("rectype"),
        unknownType("unknown"),
        constOp("const"),
        assignOp(":="),
        andOp("and"),
        orOp("or"),
        notOp("not"),
        initOp("init"),
        ifOp("if"),
        stackPop("stackPop"),
        stackPush("stackPush"),
        castOP("cast"),
        gotoOp("gotoOp"),
        variableGotoOp("varGotoOp");
        String[] relopOpList = new String[]{".lte",".lt",".gt",".gte",".eq",".ne"};
        String[] mathOpList = new String[]{"+","-","*","/","%"};
        String type;
        TYPES(String type) {
            this.type = type;
        }
        String getType() {
            return type;
        }

    }
    public static enum TYPECODES {
        UNKNOWN(-1),
        INTEGER(0),
        REAL(1),
        CHAR(2),
        BOOLEAN(3),
        RANGE(4);
        int type;
        TYPECODES(int type) {
            this.type = type;
        }
        int getType() {
            return type;
        }
    }

	public static Vector<Vector<Eval>> makeInitializersList(Vector<Eval> initializers) {
		Vector<Vector<Eval>> result = new Vector<>();
		result.add(initializers);
		return result;
	}

	public static Vector<Eval> makeInitializersOrDeclareds(Eval initializerOrdDeclared) {
		Vector<Eval> result = new Vector<>();
		result.add(initializerOrdDeclared);
		return result;
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
