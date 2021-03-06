
%{
  package chronicle;
  import java.io.*;
%}

%token ID NUMCONST REALCONST CHARCONST BOOLCONST SHARP_KW MOD_KW DIV_KW MUL_KW SUB_KW ADD_KW SINGLE_QUOTE_KW DOT_KW LTE_KW GTE_KW NEQ_KW EQ_KW GT_KW LT_KW COMMA_KW CLOSEPARENTHESIS_KW OPENPARENTHESIS_KW CLOSEACCOLADE_KW OPENACCOLADE_KW CLOSEBRACKET_KW OPENBRACKET_KW ASSIGN_KW COLON_KW SEMICOLON_KW NOT_KW OR_KW AND_KW DOWNTO_KW UPTO_KW EXIT_KW RETURN_KW FOR_KW WHEN_KW END_KW DEFAULT_KW CASE_KW SWITCH_KW WHILE_KW DO_KW ELSE_KW THEN_KW IF_KW PROCEDURE_KW BOOLEAN_KW CHARACTER_KW REAL_KW INTEGER_KW MAIN_KW PROGRAM_KW DIGIT NONZERO_DIGIT LETTER
%type <EVal> pair declarations_list declarations type_specifiers declarator_list declarator dec range initializer initializer_list procedure_list procedure parameters block statement_list statement arguments_list multi_arguments counter case_element expressions constant_expressions bool_expressions arithmetic_expressions

%code {
  public static final String TYPE_STRING_INTEGER = "int";
	public static final String TYPE_STRING_REAL = "double";
	public static final String TYPE_STRING_CHAR = "char";
	public static final String TYPE_STRING_BOOLEAN = "int";

	private static final String tempStr = "TempVar";
	public static final String startStr = "StartVar";
	public static final String sizeStr = "SizeVar";
	public static final String indexStr = "IndexVar";
	public static final String condStr = "ConditionVar";

	public static String lexIdentifier;
	public static int lexInt;
	public static double lexReal;
	public static boolean lexBoolean;
	public static char lexChar;

	private ArrayList<Quadruple> quadruples = new ArrayList<>();
	private SymbolTable symbolTable = new SymbolTable();
	public static PrintStream writer;

	private int tempCounter = 0;
	public String fileAddress;
  
  public static void main(String args[]) throws IOException {
        YYParser yyparser;
        final Yylex lexer;

        String inputCode = ".\\files\\Code.shl";
        String outputCode = "E:\\Dev C++\\TEMP - Programs\\compiler.c";
        String output = "output.txt";

        if (args.length == 1) {
            inputCode = args[0];
            outputCode = args[0] + ".c";
            output = args[0] + ".txt";
        }
        if (args.length == 2) {
            inputCode = args[0];
            outputCode = args[1];
            output = args[0] + ".txt";
        }
        if (args.length == 3) {
            inputCode = args[0];
            outputCode = args[1];
            output = args[2];
        }

        writer = new PrintStream(new File(output));
        lexer = new Yylex(new InputStreamReader(new FileInputStream(inputCode)));

        yyparser = new YYParser(new Lexer() {

            @Override
            public int yylex() {
                int yyl_return = -1;
                try {
                    yyl_return = lexer.yylex();
                } catch (IOException e) {
                    System.err.println("IO error: " + e);
                }
                return yyl_return;
            }

            @Override
            public void yyerror(String error) {
                System.err.println("Error! " + error);
            }

            @Override
            public Object getLVal() {
                return null;
            }
        });
        yyparser.fileAddress = outputCode;
        yyparser.parse();

        return;
	}

  private void emit(String operation, String arg0, String arg1, String result) {
  		quadruples.add(new Quadruple(operation, arg0, arg1, result));
  	}


  		private void backpatch(ArrayList<Integer> list, int quadNumber) {
  		for (int i = 0; i < list.size(); i++)
  			quadruples.get(list.get(i)).result = String.valueOf(quadNumber);
  	}

  		private void backpatch(int quadNumber, int destination) {
  		quadruples.get(quadNumber).result = String.valueOf(destination);
  	}

  		private String newTemp(int type, boolean array) {
  		String name = tempStr + tempCounter++;
  		symbolTable.addToSymbolTable(name, type, array);
  		return name;
  	}


  		private int nextQuad() {
  		return quadruples.size();
  	}


  		private String getTypeString(int typeCode){
  		switch(typeCode){
  			case EVal.TYPE_CODE_INTEGER:
  				return TYPE_STRING_INTEGER;
  			case EVal.TYPE_CODE_REAL:
  				return TYPE_STRING_REAL;
  			case EVal.TYPE_CODE_CHAR:
  				return TYPE_STRING_CHAR;
  			case EVal.TYPE_CODE_BOOLEAN:
  				return TYPE_STRING_BOOLEAN;
  			case EVal.TYPE_CODE_UNKNOWN:
  			case EVal.TYPE_CODE_RANGE:
  			default:
  				return null;
  		}
  	}



  		private void exportIntermediateCode() {
  		DataOutputStream dos = null;
  		try {
  			dos = new DataOutputStream(new FileOutputStream(fileAddress));
  		} catch (FileNotFoundException e) {
  			e.printStackTrace();
  		}

  		try {
  			dos.writeBytes("#include <stdio.h>\n\nint main() {\n\t// ////////////////// Symbol Table \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \\\\\n\n");
  			dos.writeBytes(symbolTable.toString());
  			dos.writeBytes("\n\t// ////////////////// Quadruples \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \\\\\n\n");
  			// Backpatch of error controllers.
  			backpatch(EVal.arrayIndexOutOfBoundList, (quadruples.size() + 1)); // Array index out of bound error.
  			backpatch(EVal.invalidArraySizeList, (quadruples.size() + 2)); // Invalid array size error.
  			for (int i = 0; i < quadruples.size() && i < 100; i++) {
  				dos.writeBytes(Quadruple.LINE_STR + i + ":" + "\t\t" + quadruples.get(i) + "\n");
  			}
  			for (int i = 100; i < quadruples.size(); i++) {
  				dos.writeBytes(Quadruple.LINE_STR + i + ":" + "\t\t" + quadruples.get(i) + "\n");
  			}
  			// Normal Finish
  			if(quadruples.size() < 100)
  				dos.writeBytes(Quadruple.LINE_STR + quadruples.size() + ":" + "\t\tprintf(\"Process is terminated with no error.\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\t\treturn 0;\n");
  			else
  				dos.writeBytes(Quadruple.LINE_STR + quadruples.size() + ":" + "\t\tprintf(\"Process is terminated with no error.\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\t\treturn 0;\n");

  			// Array index out of bound error.
  			if(quadruples.size() < 100)
  				dos.writeBytes(Quadruple.LINE_STR + (quadruples.size() + 1) + ":" + "\t\tprintf(\"Array Error: Index out of bound!\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\treturn -1;\n");
  			else
  				dos.writeBytes(Quadruple.LINE_STR + (quadruples.size() + 1) + ":" + "\t\tprintf(\"Array Error: Index out of bound!\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\treturn -1;\n");

  			// Invalid array size error.
  			if(quadruples.size() < 100)
  				dos.writeBytes(Quadruple.LINE_STR + (quadruples.size() + 2) + ":" + "\t\tprintf(\"Array Error: Invalid array size!\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\treturn -2;\n");
  			else
  				dos.writeBytes(Quadruple.LINE_STR + (quadruples.size() + 2) + ":" + "\t\tprintf(\"Array Error: Invalid array size!\\n\");\n" +
  					"\t\t\t\tgetchar();\n\t\t\treturn -2;\n");

  			dos.writeBytes("}\n");
  		} catch (IOException e) {
  			e.printStackTrace();
  		}

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
    PROGRAM_KW ID MAIN_KW block {
		System.out.println("Rule 1.2: " +
			"program -> PROGRAM_KW ID MAIN_KW block");
		exportIntermediateCode();
	}
	| PROGRAM_KW ID declarations_list MAIN_KW block {
		System.out.println("Rule 1.3: " +
			"program -> PROGRAM_KW ID declarations_list MAIN_KW block");
		exportIntermediateCode();
	}
	| PROGRAM_KW ID procedure_list MAIN_KW block {
		System.out.println("Rule 1.4: " +
			"program -> PROGRAM_KW ID procedure_list MAIN_KW block");
		exportIntermediateCode();
	}
	| PROGRAM_KW ID declarations_list procedure_list MAIN_KW block {
		System.out.println("Rule 1.5: " +
			"program -> PROGRAM_KW ID declarations_list procedure_list MAIN_KW block");
		exportIntermediateCode();
	}
  | PROGRAM_KW ID MAIN_KW {
  System.out.println("Rule 1.1: " +
    "program -> PROGRAM_KW ID MAIN_KW");
		exportIntermediateCode();
}

declarations_list:
	 declarations_list declarations {
		System.out.println("Rule 2.1: " +
			"declarations_list -> declarations_list declarations");
	}

	| declarations {
		System.out.println("Rule 2.2: " +
			"declarations_list -> declarations");
	}


declarations:
	type_specifiers declarator_list SEMICOLON_KW {
		System.out.println("Rule 3.1: " +
			"declarations -> type_specifiers declarator_list SEMICOLON_KW");
	}



type_specifiers:
	INTEGER_KW {
		System.out.println("Rule 4.1: " +
			"type_specifiers -> INTEGER_KW");
	}
	| REAL_KW {
		System.out.println("Rule 4.2: " +
			"type_specifiers -> REAL_KW");
	}
	| CHARACTER_KW {
		System.out.println("Rule 4.3: " +
			"type_specifiers -> CHAR_KW");
	}
	| BOOLEAN_KW {
		System.out.println("Rule 4.4: " +
			"type_specifiers -> BOOLEAN_KW");
	}

declarator_list:
	declarator {
		System.out.println("Rule 5.1: " +
			"declarator_list -> declarator");
	}
	| declarator_list COMMA_KW declarator {
		System.out.println("Rule 5.2: " +
			"declarator_list -> declarator_list COMMA_KW declarator");
	}



declarator:
	 dec {
		System.out.println("Rule 6.1: " +
			"declarator -> dec");
	}
	| dec ASSIGN_KW initializer {
		System.out.println("Rule 6.2: " +
			"declarator -> dec ASSIGN_KW initializer");
	}


dec:
	ID {
		System.out.println("Rule 7.1: " +
			"dec -> ID");
	}
	| ID OPENBRACKET_KW range CLOSEBRACKET_KW {
		System.out.println("Rule 7.2: " +
			"dec -> ID OPENBRACKET_KW range CLOSEBRACKET_KW");
	}
	| ID OPENBRACKET_KW NUMCONST CLOSEBRACKET_KW {
		System.out.println("Rule 7.3: " +
			"dec -> ID OPENBRACKET_KW NUMCONST CLOSEBRACKET_KW");
	}



range:
	ID DOT_KW ID {
		System.out.println("Rule 8.1: " +
			"range -> ID DOT_KW ID");
	}
	| NUMCONST DOT_KW NUMCONST {
		System.out.println("Rule 8.2: " +
			"range -> NUMCONST DOT_KW NUMCONST");
	}
	| arithmetic_expressions DOT_KW arithmetic_expressions {
		System.out.println("Rule 8.3: " +
			"range -> arithmetic_expressions DOT_KW arithmetic_expressions");
	}

initializer:
	constant_expressions {
		System.out.println("Rule 9.1: " +
			"initializer -> constant_expressions");
	}
	| OPENACCOLADE_KW initializer_list CLOSEACCOLADE_KW {
		System.out.println("Rule 9.2: " +
			"initializer -> OPENACCOLADE_KW initializer CLOSEACCOLADE_KW");
	}



initializer_list:
	constant_expressions COMMA_KW initializer_list {
		System.out.println("Rule 10.1: " +
			"initializer_list -> constant_expressions COMMA_KW initializer_list");
	}
	| constant_expressions {
		System.out.println("Rule 10.2: " +
			"initializer_list -> constant_expressions");
	}

procedure_list:
	procedure_list procedure {
		System.out.println("Rule 11.1: " +
			"procedure_list -> procedure_list procedure");
	}
	| procedure {
		System.out.println("Rule 11.2: " +
			"procedure_list -> procedure");
	}

procedure:
  PROCEDURE_KW ID parameters OPENACCOLADE_KW block CLOSEACCOLADE_KW SEMICOLON_KW {
   System.out.println("Rule 12.1: " +
     "procedure -> PROCEDURE_KW ID parameters OPENACCOLADE_KW block CLOSEACCOLADE_KW SEMICOLON_KW");
  }
  |PROCEDURE_KW ID parameters OPENACCOLADE_KW declarations_list block CLOSEACCOLADE_KW SEMICOLON_KW {
		System.out.println("Rule 12.2: " +
			"procedure -> PROCEDURE_KW ID parameters OPENACCOLADE_KW declarations_list block CLOSEACCOLADE_KW SEMICOLON_KW");
	}

parameters:
	OPENPARENTHESIS_KW declarations_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 13.1: " +
			"parameters -> OPENPARENTHESIS_KW declarations_list CLOSEPARENTHESIS_KW");
	}

block:
	OPENACCOLADE_KW statement_list CLOSEACCOLADE_KW {
		System.out.println("Rule 14.1: " +
			"block -> OPENACCOLADE_KW statement_list CLOSEACCOLADE_KW");
	}

statement_list:
	statement SEMICOLON_KW {
		System.out.println("Rule 15.1: " +
			"statement_list -> statement SEMICOLON_KW");
	}
	| statement_list statement SEMICOLON_KW {
		System.out.println("Rule 15.2: " +
			"statement_list -> statement_list statement SEMICOLON_KW");
	}
	| SEMICOLON_KW {
		System.out.println("Rule 15.3: " +
			"statement_list -> SEMICOLON_KW");
	}
	| statement_list SEMICOLON_KW {
		System.out.println("Rule 15.4: " +
			"statement_list -> statement_list SEMICOLON_KW");
	}

statement:
	ID ASSIGN_KW expressions {
		System.out.println("Rule 16.1: " +
			"statement -> ID ASSIGN_KW expressions");
	}
	| IF_KW bool_expressions THEN_KW statement {
		System.out.println("Rule 16.2: " +
			"statement -> IF_KW bool_expressions THEN_KW statement");
	}
	| IF_KW bool_expressions THEN_KW statement ELSE_KW statement {
		System.out.println("Rule 16.3: " +
			"statement -> IF_KW bool_expressions THEN_KW statement ELSE_KW statement");
	}
	| DO_KW statement WHILE_KW bool_expressions {
		System.out.println("Rule 16.4: " +
			"statement -> DO_KW statement WHILE_KW bool_expressions");
	}
	| FOR_KW ID ASSIGN_KW counter DO_KW statement {
		System.out.println("Rule 16.5: " +
			"statement -> FOR_KW ID ASSIGN_KW counter DO_KW statement");
	}
	| SWITCH_KW expressions case_element default END_KW {
		System.out.println("Rule 16.6: " +
			"statement -> SWITCH_KW expressions case_element default END_KW");
	}
	| ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 16.7: " +
			"statement -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	}
	| ID OPENBRACKET_KW expressions CLOSEBRACKET_KW ASSIGN_KW expressions {
		System.out.println("Rule 16.8: " +
			"statement -> IDENTIFIER OPENBRACKET_KW expressions CLOSEBRACKET_KW ASSIGN_KW expressions");
	}
	| RETURN_KW expressions {
		System.out.println("Rule 16.9: " +
			"statement -> RETURN_KW expressions");
	}
	| EXIT_KW WHEN_KW bool_expressions {
		System.out.println("Rule 16.10: " +
			"statement -> EXIT_KW WHEN_KW bool_expressions");
	}
	| block {
		System.out.println("Rule 16.11: " +
			"statement -> block");
	}
	| ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW {
		System.out.println("Rule 16.12: " +
			"statement -> ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW");
	}
	| SWITCH_KW expressions case_element END_KW {
		System.out.println("Rule 16.13: " +
			"statement -> SWITCH_KW expressions case_element END_KW");
	}

arguments_list:
  multi_arguments {
		System.out.println("Rule 17.1: " +
			"arguments_list -> multi_arguments");
	}

multi_arguments:
	multi_arguments COMMA_KW expressions {
		System.out.println("Rule 18.1: " +
			"multi_arguments -> multi_arguments COMMA_KW expressions");
	}
	| expressions {
		System.out.println("Rule 18.2: " +
			"multi_arguments -> expressions");
	}

counter:
	NUMCONST UPTO_KW NUMCONST {
		System.out.println("Rule 19.1: " +
			"counter -> NUMCONST UPTO_KW NUMCONST");
	}
	| NUMCONST DOWNTO_KW NUMCONST {
		System.out.println("Rule 19.2: " +
			"counter -> NUMCONST DOWNTO_KW NUMCONST");
	}

case_element:
	CASE_KW NUMCONST COLON_KW block {
		System.out.println("Rule 20.1: " +
			"case_element -> CASE_KW NUMCONST COLON_KW block");
	}
	| case_element CASE_KW NUMCONST COLON_KW block {
		System.out.println("Rule 20.2: " +
			"case_element -> case_element CASE_KW NUMCONST COLON_KW block");
	}

default:
	DEFAULT_KW COLON_KW block {
		System.out.println("Rule 21.1: " +
			"default -> DEFAULT_KW COLON_KW block");
	}

expressions:
	constant_expressions {
		System.out.println("Rule 22.1: " +
			"expressions -> constant_expressions");
      $$ = new EVal();
  		((EVal)$$).place = $1.place;
  		((EVal)$$).type = $1.type;
  		((EVal)$$).nextList = $1.nextList;
  		((EVal)$$).trueList = $1.trueList;
  		((EVal)$$).falseList = $1.falseList;
	}
	| bool_expressions {
		System.out.println("Rule 22.2: " +
			"expressions -> bool_expressions");
	}
	| arithmetic_expressions {
		System.out.println("Rule 22.3: " +
			"expressions -> arithmetic_expressions");
	}
	| ID {
		System.out.println("Rule 22.4: " +
			"expressions -> ID");
	}
	| ID OPENBRACKET_KW expressions CLOSEBRACKET_KW {
		System.out.println("Rule 22.5: " +
			"expressions -> ID OPENBRACKET_KW expressions CLOSEBRACKET_KW");
	}
	| ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.6: " +
			"expressions -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	}
	| OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.7: " +
			"expressions -> OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW");
	}
	| ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.8: " +
			"expressions -> ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW");
	}

constant_expressions:
	NUMCONST {
		System.out.println("Rule 23.1: " +
			"constant_expressions -> NUMCONST");
      $$ = new EVal();
  		((EVal)$$).place = newTemp(EVal.TYPE_CODE_INTEGER, false);
  		((EVal)$$).type = EVal.TYPE_CODE_INTEGER;
  		((EVal)$$).trueList = EVal.makeList(nextQuad() + 1);
  		((EVal)$$).falseList = EVal.makeList(nextQuad() + 2);
  		((EVal)$$).nextList = EVal.merge(((EVal)$$).trueList, ((EVal)$$).falseList);

  		emit(":=", String.valueOf(lexInt), null, ((EVal)$$).place);
  		emit("check", ((EVal)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
  		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.

	}
	| REALCONST {
		System.out.println("Rule 23.2: " +
			"constant_expressions -> REALCONST");
      $$ = new EVal();
  		((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  		((EVal)$$).type = EVal.TYPE_CODE_REAL;
  		((EVal)$$).trueList = EVal.makeList(nextQuad() + 1);
  		((EVal)$$).falseList = EVal.makeList(nextQuad() + 2);
  		((EVal)$$).nextList = EVal.merge(((EVal)$$).trueList, ((EVal)$$).falseList);

  		emit(":=", String.valueOf(lexReal), null, ((EVal)$$).place);
  		emit("check", ((EVal)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
  		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.

	}
	| CHARCONST {
		System.out.println("Rule 23.3: " +
			"constant_expressions -> CHARCONST");
      $$ = new EVal();
  		((EVal)$$).place = newTemp(EVal.TYPE_CODE_CHAR, false);
  		((EVal)$$).type = EVal.TYPE_CODE_CHAR;
  		((EVal)$$).trueList = EVal.makeList(nextQuad() + 1);
  		((EVal)$$).falseList = EVal.makeList(nextQuad() + 2);
  		((EVal)$$).nextList = EVal.merge(((EVal)$$).trueList, ((EVal)$$).falseList);

  		emit(":=", "'" + String.valueOf(lexChar) + "'", null, ((EVal)$$).place);
  		emit("check", ((EVal)$$).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
  		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.

	}
	| BOOLEAN_KW {
		System.out.println("Rule 23.4: " +
			"constant_expressions -> BOOLEAN_KW");
	}

bool_expressions:
	LT_KW pair {
		System.out.println("Rule 24.1: " +
			"bool_expressions -> LT_KW pair");
	}
	| LTE_KW pair {
		System.out.println("Rule 24.2: " +
			"bool_expressions -> LTE_KW pair");
	}
  | GT_KW pair {
    System.out.println("Rule 24.3: " +
      "bool_expressions -> GT_KW pair");
  }
  | GTE_KW pair {
    System.out.println("Rule 24.4: " +
      "bool_expressions -> GTE_KW pair");
  }
  | EQ_KW pair {
    System.out.println("Rule 24.5: " +
      "bool_expressions -> EQ_KW pair");
  }
  | NEQ_KW pair {
    System.out.println("Rule 24.6: " +
      "bool_expressions -> NEQ_KW pair");
  }
	| AND_KW THEN_KW pair {
		System.out.println("Rule 24.7: " +
			"bool_expressions -> AND_KW THEN_KW pair");
	}
	| OR_KW ELSE_KW pair {
		System.out.println("Rule 24.8: " +
			"bool_expressions -> OR_KW ELSE_KW pair");
	}

arithmetic_expressions:
	ADD_KW pair {
		System.out.println("Rule 25.1: " +
			"arithmetic_expressions -> ADD_KW pair");
      if((($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  				&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN))
  			|| ($2.type == EVal.TYPE_CODE_REAL && $2.type1 == EVal.TYPE_CODE_REAL)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp($2.type, false);
  			((EVal)$$).type = $2.type;
  			emit("+", $2.place, $2.place1, ((EVal)$$).place);
  		} else if(($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  			&& $2.type1 == EVal.TYPE_CODE_REAL) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place, TYPE_STRING_REAL, tmp);
  			emit("+", tmp, $2.place1, ((EVal)$$).place);
  		} else if($2.type == EVal.TYPE_CODE_REAL
  			&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place1, TYPE_STRING_REAL, tmp);
  			emit("+", $2.place, tmp, ((EVal)$$).place);
  		} else {
  			System.err.println("Error! Invalid type for \"+\" operation.");
  			return YYABORT;
  		}
	}
	| SUB_KW pair {
		System.out.println("Rule 25.2: " +
			"arithmetic_expressions -> SUB_KW pair");
      if((($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  				&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN))
  			|| ($2.type == EVal.TYPE_CODE_REAL && $2.type1 == EVal.TYPE_CODE_REAL)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp($2.type, false);
  			((EVal)$$).type = $2.type;
  			emit("-", $2.place, $2.place1, ((EVal)$$).place);
  		} else if(($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  			&& $2.type1 == EVal.TYPE_CODE_REAL) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place, TYPE_STRING_REAL, tmp);
  			emit("-", tmp, $2.place1, ((EVal)$$).place);
  		} else if($2.type == EVal.TYPE_CODE_REAL
  			&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place1, TYPE_STRING_REAL, tmp);
  			emit("-", $2.place, tmp, ((EVal)$$).place);
  		} else {
  			System.err.println("Error! Invalid type for \"+\" operation.");
  			return YYABORT;
  		}
	}
	| MUL_KW pair {
		System.out.println("Rule 25.3: " +
			"arithmetic_expressions -> MUL_KW pair");
      if((($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  		&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN))
  			|| ($2.type == EVal.TYPE_CODE_REAL && $2.type1 == EVal.TYPE_CODE_REAL)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp($2.type, false);
  			((EVal)$$).type = $2.type;
  			emit("*", $2.place, $2.place1, ((EVal)$$).place);
  		} else if(($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  			&& $2.type1 == EVal.TYPE_CODE_REAL) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place, TYPE_STRING_REAL, tmp);
  			emit("*", tmp, $2.place1, ((EVal)$$).place);
  		} else if($2.type == EVal.TYPE_CODE_REAL
  			&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place1, TYPE_STRING_REAL, tmp);
  			emit("*", $2.place, tmp, ((EVal)$$).place);
  		} else {
  			System.err.println("Error! Invalid type for \"+\" operation.");
  			return YYABORT;
  		}
	}
	| DIV_KW pair {
		System.out.println("Rule 25.4: " +
			"arithmetic_expressions -> DIV_KW pair");

  		if((($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  				&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN))
  			|| ($2.type == EVal.TYPE_CODE_REAL && $2.type1 == EVal.TYPE_CODE_REAL)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp($2.type, false);
  			((EVal)$$).type = $2.type;
  			emit("/", $2.place, $2.place1, ((EVal)$$).place);
  		} else if(($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  			&& $2.type1 == EVal.TYPE_CODE_REAL) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place, TYPE_STRING_REAL, tmp);
  			emit("/", tmp, $2.place1, ((EVal)$$).place);
  		} else if($2.type == EVal.TYPE_CODE_REAL
  			&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place1, TYPE_STRING_REAL, tmp);
  			emit("/", $2.place, tmp, ((EVal)$$).place);
  		} else {
  			System.err.println("Error! Invalid type for \"+\" operation.");
  			return YYABORT;
  		}
	}
	| MOD_KW pair {
		System.out.println("Rule 25.5: " +
			"arithmetic_expressions -> MOD_KW pair");



  		if((($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  				&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN))
  			|| ($2.type == EVal.TYPE_CODE_REAL && $2.type1 == EVal.TYPE_CODE_REAL)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp($2.type, false);
  			((EVal)$$).type = $2.type;
  			emit("%", $2.place, $2.place1, ((EVal)$$).place);
  		} else if(($2.type == EVal.TYPE_CODE_INTEGER || $2.type == EVal.TYPE_CODE_CHAR || $2.type == EVal.TYPE_CODE_BOOLEAN)
  			&& $2.type1 == EVal.TYPE_CODE_REAL) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place, TYPE_STRING_REAL, tmp);
  			emit("%", tmp, $2.place1, ((EVal)$$).place);
  		} else if($2.type == EVal.TYPE_CODE_REAL
  			&& ($2.type1 == EVal.TYPE_CODE_INTEGER || $2.type1 == EVal.TYPE_CODE_CHAR || $2.type1 == EVal.TYPE_CODE_BOOLEAN)) {
  			$$ = new EVal();
  			((EVal)$$).place = newTemp(EVal.TYPE_CODE_REAL, false);
  			((EVal)$$).type = EVal.TYPE_CODE_REAL;
  			String tmp = newTemp(EVal.TYPE_CODE_REAL, false);
  			emit("cast", $2.place1, TYPE_STRING_REAL, tmp);
  			emit("%", $2.place, tmp, ((EVal)$$).place);
  		} else {
  			System.err.println("Error! Invalid type for \"+\" operation.");
  			return YYABORT;
  		}
	}
	| SUB_KW expressions {
		System.out.println("Rule 25.6: " +
			"arithmetic_expressions -> SUB_KW expressions");
      $$ = new EVal();
  		((EVal)$$).place = newTemp($2.type, false);
  		((EVal)$$).type = $2.type;
  		emit("usub", $2.place, null, ((EVal)$$).place);
	}

pair:
	OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 26.1: " +
			"pair: OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW");

      $$ = new EVal();


  		((EVal)$$).place = $2.place;
  		((EVal)$$).type = $2.type;


  		((EVal)$$).place1 = $4.place;
  		((EVal)$$).type1 = $4.type;
	}
%%
class EVal {

	public static final int TYPE_CODE_UNKNOWN = -1;
	public static final int TYPE_CODE_INTEGER = 0;
	public static final int TYPE_CODE_REAL = 1;
	public static final int TYPE_CODE_CHAR = 2;
	public static final int TYPE_CODE_BOOLEAN = 3;
	public static final int TYPE_CODE_RANGE = 4;


	public String place;

	public String place1;



	public int type;

	public int type1;



	public boolean array;

	public boolean array1;



	public int quad;

	public int quad1;





	public static ArrayList<Integer> arrayIndexOutOfBoundList = new ArrayList<>();
	public static ArrayList<Integer> invalidArraySizeList = new ArrayList<>();
	public ArrayList<Integer> initList;
	public ArrayList<Integer> nextList;
	public ArrayList<Integer> trueList;
	public ArrayList<Integer> falseList;

	public ArrayList<ArrayList<EVal>> initializersList;
	public ArrayList<EVal> declareds;

	public ArrayList<EVal> initializers;

	public EVal() {
	}

	public static ArrayList<Integer> makeList(int number) {
		ArrayList<Integer> result = new ArrayList<>();
		result.add(number);
		return result;
	}

	public static ArrayList<Integer> merge(ArrayList<Integer> al1, ArrayList<Integer> al2) {
		ArrayList<Integer> result = new ArrayList<>();
		result.addAll(al1);
		result.addAll(al2);
		return result;
	}

	public static ArrayList<ArrayList<EVal>> makeInitializersList(ArrayList<EVal> initializers) {
		ArrayList<ArrayList<EVal>> result = new ArrayList<>();
		result.add(initializers);
		return result;
	}

	public static ArrayList<EVal> makeInitializersOrDeclareds(EVal initializerOrdDeclared) {
		ArrayList<EVal> result = new ArrayList<>();
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

	public Quadruple(String operation, String arg0, String arg1, String result) {
		this.operation = operation;
		this.arg0 = arg0;
		this.arg1 = arg1;
		this.result = result;
	}

	@Override
	public String toString() {
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


//SymbolTable
class SymbolTable {

	public static final int NOT_IN_SYMBOL_TABLE = -1;

	public ArrayList<String> names;
	public ArrayList<Integer> types;
	public ArrayList<Boolean> arrays;

	public SymbolTable() {
		names = new ArrayList<>();
		types = new ArrayList<>();
		arrays = new ArrayList<>();
	}

	public int lookUp(String name) {
		return names.indexOf(name);
	}

	public boolean addToSymbolTable(String name, int type, boolean array) {
		if (lookUp(name) == -1) {
			names.add(name);
			types.add(type);
			arrays.add(array);
			return true;
		}
		return false;
	}

	@Override
    public String toString() {
        if(names.size() == 0)
            return null;
        String res = "";
        for(int i = 0; i < names.size(); i++) {
            switch (types.get(i)) {
                case EVal.TYPE_CODE_INTEGER:
                    res += "\t" + YYParser.TYPE_STRING_INTEGER;
                    break;
                case EVal.TYPE_CODE_REAL:
                    res += "\t" + YYParser.TYPE_STRING_REAL;
                    break;
                case EVal.TYPE_CODE_CHAR:
                    res += "\t" + YYParser.TYPE_STRING_CHAR;
                    break;
                case EVal.TYPE_CODE_BOOLEAN:
                    res += "\t" + YYParser.TYPE_STRING_BOOLEAN;
                    break;
                case EVal.TYPE_CODE_RANGE:
                    continue;
            }
            res += (arrays.get(i) ? " *" : " ") + names.get(i) + ";\n";
        }
        return res;
	}

}
