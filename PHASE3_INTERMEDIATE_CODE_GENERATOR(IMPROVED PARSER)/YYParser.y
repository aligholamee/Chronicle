
%{
  package chronicle;
  import java.io.*;
  import java.util.ArrayList;
%}

%type <Genesis> repeated_id
%type <Genesis> saved_integer
%type <Genesis> saved_boolean
%type <Genesis> saved_character
%type <Genesis> saved_real
%token ID
%token BOOLCONST
%token REALCONST
%token CHARCONST
%token NUMCONST
%token SHARP_KW
%token MOD_KW
%token DIV_KW
%token MUL_KW
%token SUB_KW
%token ADD_KW
%token SINGLE_QUOTE_KW
%token DOT_KW
%token LTE_KW
%token GTE_KW
%token NEQ_KW
%token EQ_KW
%token GT_KW
%token LT_KW
%token COMMA_KW
%token CLOSEPARENTHESIS_KW
%token OPENPARENTHESIS_KW
%token CLOSEACCOLADE_KW
%token OPENACCOLADE_KW
%token CLOSEBRACKET_KW
%token OPENBRACKET_KW
%token ASSIGN_KW
%token COLON_KW
%token SEMICOLON_KW
%token NOT_KW
%token OR_KW
%token AND_KW
%token DOWNTO_KW
%token UPTO_KW
%token EXIT_KW
%token RETURN_KW
%token FOR_KW
%token WHEN_KW
%token END_KW
%token DEFAULT_KW
%token CASE_KW
%token SWITCH_KW
%token WHILE_KW
%token DO_KW
%token ELSE_KW
%token THEN_KW
%token IF_KW
%token PROCEDURE_KW
%token BOOLEAN_KW
%token CHARACTER_KW
%token REAL_KW
%token INTEGER_KW
%token MAIN_KW
%token PROGRAM_KW
%token DIGIT
%token NONZERO_DIGIT
%token LETTER
%type <Genesis> program declarations_list declarations type_specifiers declarator_list declarator dec range initializer initializer_list procedure_list procedure parameters block statement_list statement arguments_list multi_arguments counter case_element default expressions constant_expressions bool_expressions arithmetic_expressions pair
%code {
    /* YYParser class section */
    /* Functions like emit, backpatch, newTemp, nextQuad and etc. will be implemented here */

    /* YYParser variable types list */
    public static final String TYPE_STRING_INTEGER = "int";
    public static final String TYPE_STRING_CHAR = "char";
    public static final String TYPE_STRING_REAL = "float";
    public static final String TYPE_STRING_BOOLEAN = "bool";

    /* Variable declarations and allocations */
    private SymbolTable symbolTable = new SymbolTable();
	  private ArrayList<Quadruple> quadruples = new ArrayList<>();

    public static String lexIdentifier;
    public static int lexInt;
    public static double lexReal;
    public static boolean lexBoolean;
    public static char lexChar;

    /* a character to hold the previous operator for the pair section */
    private char prev_op;
    /* Emit function */
    private void emit(String operation,String arg0,String arg1,String result)
    {
      quadruples.add(new Quadruple(operation,arg0,arg1,result));
      System.out.println("EMIT:"+operation+":"+arg0+":"+arg1+":"+result);
    }

    /* newTemp function */
    /* tempCounter: A variable to see how many temps are created until now */
    private int tempCounter = 0;
    private String newTemp(String type,boolean isArray,int size) {
      String name = "Temp" + (tempCounter++);
      emit(Genesis.initOp,type,"",name);
      symbolTable.addToSymbolTable(name,type,isArray,size);
      return name;
    }

    /* nextQuad function */
    /* Give us the address of the current(+1 is next) quad in the table which is equal to the size of the quadRuple table */
    private int nextQuad() {
      return quadruples.size();
    }

    /* backpatch Function #1*/
    private void backpatch(ArrayList<Integer> list, int quadNumber) {
  		for (int i = 0; i < list.size(); i++)
  			quadruples.get(list.get(i)).result = String.valueOf(quadNumber);
  	}

    /* backpatch Function #2*/
    private void backpatch(int quadNumber, int destination) {
        quadruples.get(quadNumber).result = String.valueOf(destination);
    }

    /* Code Exporting Function */
    private void exportIntermediateCode() {
      /* Print the general include section */
      String result = "";
      result = "#include <stdio.h>";
      System.out.println(result);
      result = "#include <iostream>";
      System.out.println(result);
      result = "#include <string>";
      System.out.println(result);
      result = "using namespace std;";
      System.out.println(result);

      /* Print the Variable types: INT, BOOL, REAL, CHAR */

    }

    static PrintStream writer;
    public static void main(String args[]) throws IOException, FileNotFoundException {
        YYParser yyparser;
        final Yylex lexer;

        writer = new PrintStream(new File("yacc_tool_output.txt"));
        lexer = new Yylex(new InputStreamReader(new FileInputStream("C:\Users\aligholamee\Desktop\Chronicle\PHASE1_LEXICAL_ANALYZER\Global_Test\globalTest2.shl")));

        yyparser = new YYParser(new Lexer() {


            public int yylex() {
                int yyl_return = -1;
                try {

                    yyl_return = lexer.yylex();
                } catch (IOException e) {
                    System.err.println("IO error :" + e);
                }
                return yyl_return;
            }


            public void yyerror(String error) {
                System.err.println("Error : " + error);
            }


            public Object getLVal() {
                return null;
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
    PROGRAM_KW repeated_id MAIN_KW block {
		System.out.println("Rule 1.2: " +
			"program -> PROGRAM_KW ID MAIN_KW block");
      backpatch($4.nextList, nextQuad());
      exportIntermediateCode();
	}
	| PROGRAM_KW repeated_id declarations_list MAIN_KW block {
		System.out.println("Rule 1.3: " +
			"program -> PROGRAM_KW ID declarations_list MAIN_KW block");
      backpatch($5.nextList, nextQuad());
      exportIntermediateCode();
	}
	| PROGRAM_KW repeated_id procedure_list MAIN_KW block {
		System.out.println("Rule 1.4: " +
			"program -> PROGRAM_KW ID procedure_list MAIN_KW block");
      backpatch($5.nextList, nextQuad());
      exportIntermediateCode();
	}
	| PROGRAM_KW repeated_id declarations_list procedure_list MAIN_KW block {
		System.out.println("Rule 1.5: " +
			"program -> PROGRAM_KW ID declarations_list procedure_list MAIN_KW block");
      backpatch($6.nextList, nextQuad());
      exportIntermediateCode();
	}
  | PROGRAM_KW repeated_id MAIN_KW {
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
      $$ = new Genesis();
      ((Genesis)$$).type = Genesis.INT;
	}
	| REAL_KW {
		System.out.println("Rule 4.2: " +
			"type_specifiers -> REAL_KW");
      $$ = new Genesis();
      ((Genesis)$$).type = Genesis.REAL;
	}
	| CHARACTER_KW {
		System.out.println("Rule 4.3: " +
			"type_specifiers -> CHAR_KW");
      $$ = new Genesis();
      ((Genesis)$$).type = Genesis.CHAR;
	}
	| BOOLEAN_KW {
		System.out.println("Rule 4.4: " +
			"type_specifiers -> BOOLEAN_KW");
      $$ = new Genesis();
      ((Genesis)$$).type = Genesis.BOOL;
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
	repeated_id {
		System.out.println("Rule 7.1: " +
			"dec -> ID");
	}
	| repeated_id OPENBRACKET_KW range CLOSEBRACKET_KW {
		System.out.println("Rule 7.2: " +
			"dec -> ID OPENBRACKET_KW range CLOSEBRACKET_KW");
	}
	| repeated_id OPENBRACKET_KW saved_integer CLOSEBRACKET_KW {
		System.out.println("Rule 7.3: " +
			"dec -> ID OPENBRACKET_KW saved_integer CLOSEBRACKET_KW");
	}



range:
	repeated_id DOT_KW repeated_id {
		System.out.println("Rule 8.1: " +
			"range -> ID DOT_KW ID");
      /* Check ID existence */
      int index1 = symbolTable.lookUp($1.place);
      int index2 = symbolTable.lookUp($3.place);
      if (index1 == SymbolTable.NOT_IN_SYMBOL_TABLE) {
        System.err.println("Error! \"" + $1.place + "\" is not declared.");
        return YYABORT;
      }
      if (index2 == SymbolTable.NOT_IN_SYMBOL_TABLE) {
        System.err.println("Error! \"" + $3.place + "\" is not declared.");
        return YYABORT;
      }

      /* Create range code section */
      $$ = new Genesis();
      ((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_RANGE, true);
      ((Genesis)$$).type = Genesis.TYPE_CODE_RANGE;
      ((Genesis)$$).array = true;

      /* Add size and start point to the quadruple table */
      symbolTable.addToSymbolTable(startStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
  		symbolTable.addToSymbolTable(sizeStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
  		emit(":=", $1.place, null , startStr + ((Genesis)$$).place);
  		emit("-", $3.place, $1.place , sizeStr + ((Genesis)$$).place);
  		emit("+", sizeStr + ((Genesis)$$).place, "1", sizeStr + ((Genesis)$$).place);

	}
	| saved_integer DOT_KW saved_integer {
		System.out.println("Rule 8.2: " +
			"range -> saved_integer DOT_KW saved_integer");

      /* Create range code section */
      $$ = new Genesis();
      ((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_RANGE, true);
      ((Genesis)$$).type = Genesis.TYPE_CODE_RANGE;
      ((Genesis)$$).array = true;

      /* Add size and start point to the quadruple table */
      symbolTable.addToSymbolTable(startStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
  		symbolTable.addToSymbolTable(sizeStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
  		emit(":=", $1.place, null , startStr + ((Genesis)$$).place);
  		emit("-", $3.place, $1.place , sizeStr + ((Genesis)$$).place);
  		emit("+", sizeStr + ((Genesis)$$).place, "1", sizeStr + ((Genesis)$$).place);
	}
	| arithmetic_expressions DOT_KW arithmetic_expressions {
		System.out.println("Rule 8.3: " +
			"range -> arithmetic_expressions DOT_KW arithmetic_expressions");

      /* Check the type */
      if ($1.type != Genesis.TYPE_CODE_INTEGER) {
        System.err.println("Error! \"" + $1.place + "\" arg1 type mismatch.");
        return YYABORT;
      }
      if ($3.type != Genesis.TYPE_CODE_INTEGER) {
        System.err.println("Error! \"" + $3.place + "\" arg2 type mismatch.");
        return YYABORT;
      }

      /* Create range code section */
      $$ = new Genesis();
      ((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_RANGE, true);
      ((Genesis)$$).type = Genesis.TYPE_CODE_RANGE;
      ((Genesis)$$).array = true;

      /* Add size and start point to the quadruple table */
      symbolTable.addToSymbolTable(startStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
      symbolTable.addToSymbolTable(sizeStr + ((Genesis)$$).place, Genesis.TYPE_CODE_INTEGER, false);
      emit(":=", $1.place, null , startStr + ((Genesis)$$).place);
      emit("-", $3.place, $1.place , sizeStr + ((Genesis)$$).place);
      emit("+", sizeStr + ((Genesis)$$).place, "1", sizeStr + ((Genesis)$$).place);
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
  PROCEDURE_KW repeated_id parameters OPENACCOLADE_KW block CLOSEACCOLADE_KW SEMICOLON_KW {
   System.out.println("Rule 12.1: " +
     "procedure -> PROCEDURE_KW ID parameters OPENACCOLADE_KW block CLOSEACCOLADE_KW SEMICOLON_KW");
  }
  |PROCEDURE_KW repeated_id parameters OPENACCOLADE_KW declarations_list block CLOSEACCOLADE_KW SEMICOLON_KW {
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
	repeated_id ASSIGN_KW expressions {
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
	| repeated_id OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 16.7: " +
			"statement -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	}
	| repeated_id OPENBRACKET_KW expressions CLOSEBRACKET_KW ASSIGN_KW expressions {
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
	| repeated_id OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW {
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
	saved_integer UPTO_KW saved_integer {
		System.out.println("Rule 19.1: " +
			"counter -> saved_integer UPTO_KW saved_integer");
	}
	| saved_integer DOWNTO_KW saved_integer {
		System.out.println("Rule 19.2: " +
			"counter -> saved_integer DOWNTO_KW saved_integer");
	}

case_element:
	CASE_KW saved_integer COLON_KW block {
		System.out.println("Rule 20.1: " +
			"case_element -> CASE_KW saved_integer COLON_KW block");
	}
	| case_element CASE_KW saved_integer COLON_KW block {
		System.out.println("Rule 20.2: " +
			"case_element -> case_element CASE_KW saved_integer COLON_KW block");
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
      $$ = new Genesis();
      ((Genesis)$$).place = $1.place;
      ((Genesis)$$).type = $1.type;
      ((Genesis)$$).nextList = $1.nextList;
      ((Genesis)$$).trueList = $1.trueList;
      ((Genesis)$$).falseList = $1.falseList;
	}
	| bool_expressions {
		System.out.println("Rule 22.2: " +
			"expressions -> bool_expressions");
      $$ = new Genesis();
      ((Genesis)$$).place = $1.place;
      ((Genesis)$$).type = Genesis.BOOL;
      ((Genesis)$$).nextList = $1.nextList;
      ((Genesis)$$).trueList = $1.trueList;
      ((Genesis)$$).falseList = $1.falseList;
	}
	| arithmetic_expressions {
		System.out.println("Rule 22.3: " +
			"expressions -> arithmetic_expressions");
      $$ = new Genesis();
  		((Genesis)$$).place = $1.place;
  		((Genesis)$$).type = $1.type;
  		((Genesis)$$).nextList = $1.nextList;
  		((Genesis)$$).trueList = $1.trueList;
  		((Genesis)$$).falseList = $1.falseList;
	}
	| repeated_id {
		System.out.println("Rule 22.4: " +
			"expressions -> ID");
	}
	| repeated_id OPENBRACKET_KW expressions CLOSEBRACKET_KW {
		System.out.println("Rule 22.5: " +
			"expressions -> ID OPENBRACKET_KW expressions CLOSEBRACKET_KW");
	}
	| repeated_id OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.6: " +
			"expressions -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	}
	| OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.7: " +
			"expressions -> OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW");
	}
	| repeated_id OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW {
		System.out.println("Rule 22.8: " +
			"expressions -> ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW");
	}

constant_expressions:
	saved_integer {
		System.out.println("Rule 23.1: " +
			"constant_expressions -> saved_integer");
	}
	| saved_real {
		System.out.println("Rule 23.2: " +
			"constant_expressions -> saved_real");
	}
	| saved_character {
		System.out.println("Rule 23.3: " +
			"constant_expressions -> saved_character");
	}
	| saved_boolean {
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
    ADD_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
      System.out.println("Rule 25.1: " +
        "arithmetic_expressions -> ADD_KW pair");
        $$ = new Genesis();
        ((Genesis)$$).place = newTemp($3.type, false);
        ((Genesis)$$).type = $3.type;
        emit('+', $3.place, $5.place, ((Genesis)$$).place);
        //prev_op = '+';
    }
    | SUB_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
      System.out.println("Rule 25.2: " +
        "arithmetic_expressions -> SUB_KW pair");
        $$ = new Genesis();
        ((Genesis)$$).place = newTemp($3.type, false);
        ((Genesis)$$).type = $3.type;
        emit('-', $3.place, $5.place, ((Genesis)$$).place);
        //prev_op = '-';
    }
    | MUL_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
      System.out.println("Rule 25.3: " +
        "arithmetic_expressions -> MUL_KW pair");
        $$ = new Genesis();
        ((Genesis)$$).place = newTemp($3.type, false);
        ((Genesis)$$).type = $3.type;
        emit('*', $3.place, $5.place, ((Genesis)$$).place);
    }
    | DIV_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
      System.out.println("Rule 25.4: " +
        "arithmetic_expressions -> DIV_KW pair");
        $$ = new Genesis();
        ((Genesis)$$).place = newTemp($3.type, false);
        ((Genesis)$$).type = $3.type;
        emit('/', $3.place, $5.place, ((Genesis)$$).place);
        //prev_op = '/';
    }
    | MOD_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
      System.out.println("Rule 25.5: " +
        "arithmetic_expressions -> MOD_KW pair");
        $$ = new Genesis();
        ((Genesis)$$).place = newTemp($3.type, false);
        ((Genesis)$$).type = $3.type;
        emit('%', $3.place, $5.place, ((Genesis)$$).place);
        //prev_op = '%';
    }
  /*| SUB_KW OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
		System.out.println("Rule 25.6: " +
			"arithmetic_expressions -> SUB_KW expressions");
      $$ = new Genesis();
      ((Genesis)$$).place = newTemp($3.type, false);
      ((Genesis)$$).type = $3.type;
      emit('-', $3.place, $5.place, ((Genesis)$$).place);
      //prev_op = '-';
	}*/
  pair:
  	OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW {
  		System.out.println("Rule 26.1: " +
  			"pair: OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW");
         /* Specially implemented for * / + - */
         /* mod will be handled later */
         /* the operation will be grabbed from prev_op and the implementation in c will be straightforward */
         /*   if((($2.type == Genesis.TYPE_CODE_INTEGER || $2.type == Genesis.TYPE_CODE_CHAR || $2.type == Genesis.TYPE_CODE_BOOLEAN)
           && ($4.type == Genesis.TYPE_CODE_INTEGER || $4.type == Genesis.TYPE_CODE_CHAR || $4.type == Genesis.TYPE_CODE_BOOLEAN))
           || ($2.type == Genesis.TYPE_CODE_REAL && $4.type == Genesis.TYPE_CODE_REAL)) {
             $$ = new Genesis();
             ((Genesis)$$).place = newTemp($2.type, false);
             ((Genesis)$$).type = $2.type;
             emit(prev_op, $2.place, $4.place, ((Genesis)$$).place);
           }
           else if(($1.type == Genesis.TYPE_CODE_INTEGER || $1.type == Genesis.TYPE_CODE_CHAR || $1.type == Genesis.TYPE_CODE_BOOLEAN)
           && $3.type == Genesis.TYPE_CODE_REAL) {
             $$ = new Genesis();
             ((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_REAL, false);
             ((Genesis)$$).type = Genesis.TYPE_CODE_REAL;
             String tmp = newTemp(Genesis.TYPE_CODE_REAL, false);
             emit("cast", $1.place, TYPE_STRING_REAL, tmp);
             emit(prev_op, tmp, $3.place, ((Genesis)$$).place);
  	}*/
  }
/* Declared Variables Handling Section */
/* We need to manage if the ID is in the symbol table or not */
repeated_id:
  ID {
    System.out.println("Rule 27.1: " +
      "repeated_id: ID");
      $$ = new Genesis();
      ((Genesis)$$).place = lexIdentifier;
  }

/* We need to manage if the integer is in the symbol table or not */
saved_integer:
	NUMCONST {
		System.out.println("Rule 28.1: " +
  			"saved_integer: saved_integer");
  		$$ = new Genesis();
  		((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_INTEGER, false);
  		((Genesis)$$).type = Genesis.TYPE_CODE_INTEGER;
  		((Genesis)$$).trueList = Genesis.makeList(nextQuad() + 1);
  		((Genesis)$$).falseList = Genesis.makeList(nextQuad() + 2);
  		((Genesis)$$).nextList = Genesis.merge(((Genesis)$$).trueList, ((Genesis)$$).falseList);

  		emit(":=", String.valueOf(lexInt), null, ((Genesis)$$).place);
  		emit("check", ((Genesis)$$).place, null, String.valueOf(nextQuad() + 2));
  		emit("goto", null, null, String.valueOf(nextQuad() + 1));
}

/* We need to manage if the character is in the symbol table or not */
saved_character:
	CHARCONST {
		System.out.println("Rule 29.1: " +
  			"saved_character: saved_character");
  		$$ = new Genesis();
  		((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_CHAR, false);
  		((Genesis)$$).type = Genesis.TYPE_CODE_CHAR;
  		((Genesis)$$).trueList = Genesis.makeList(nextQuad() + 1);
  		((Genesis)$$).falseList = Genesis.makeList(nextQuad() + 2);
  		((Genesis)$$).nextList = Genesis.merge(((Genesis)$$).trueList, ((Genesis)$$).falseList);

  		emit(":=", String.valueOf(lexChar), null, ((Genesis)$$).place);
  		emit("check", ((Genesis)$$).place, null, String.valueOf(nextQuad() + 2));
  		emit("goto", null, null, String.valueOf(nextQuad() + 1));
}

/* We need to manage if the boolean is in the symbol table or not */
saved_boolean:
	BOOLCONST {
		System.out.println("Rule 30.1: " +
  			"saved_boolean: saved_boolean");
  		$$ = new Genesis();
  		((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_BOOLEAN, false);
  		((Genesis)$$).type = Genesis.TYPE_CODE_BOOLEAN;
  		((Genesis)$$).trueList = Genesis.makeList(nextQuad() + 1);
  		((Genesis)$$).falseList = Genesis.makeList(nextQuad() + 2);
  		((Genesis)$$).nextList = Genesis.merge(((Genesis)$$).trueList, ((Genesis)$$).falseList);

  		emit(":=", String.valueOf(lexBool), null, ((Genesis)$$).place);
  		emit("check", ((Genesis)$$).place, null, String.valueOf(nextQuad() + 2));
  		emit("goto", null, null, String.valueOf(nextQuad() + 1));
}

/* We need to manage if the real is in the symbol table or not */
saved_real:
	REALCONST {
		System.out.println("Rule 31.1: " +
  			"saved_real: saved_real");
  		$$ = new Genesis();
  		((Genesis)$$).place = newTemp(Genesis.TYPE_CODE_REAL, false);
  		((Genesis)$$).type = Genesis.TYPE_CODE_REAL;
  		((Genesis)$$).trueList = Genesis.makeList(nextQuad() + 1);
  		((Genesis)$$).falseList = Genesis.makeList(nextQuad() + 2);
  		((Genesis)$$).nextList = Genesis.merge(((Genesis)$$).trueList, ((Genesis)$$).falseList);

  		emit(":=", String.valueOf(lexReal), null, ((Genesis)$$).place);
  		emit("check", ((Genesis)$$).place, null, String.valueOf(nextQuad() + 2));
  		emit("goto", null, null, String.valueOf(nextQuad() + 1));
}

%%
/* Implementation of the classes needed to generate the intermediate code */

/* Class #1: SymbolTable */
class SymbolTable {
  /* Record: Class definition */
  protected class Record {
    public String name;
    public String type;
    public int size;
    public boolean isArray;

    /* Record: Class Constructor */
    public Record(String name, String type, int size, boolean isArray)
    {
      this.name = name;
      this.type = type;
      this.size = size;
      this.isArray = isArray;
    }
  }
  /* Create an list of Records */
  /* Each row of the symbol table will contain a list of records */
  private List<Record> table;

  /* SymbolTable: Class Constructor - No argument */
  public SymbolTable()
  {
    table = new ArrayList<>();
  }

  /* Class Getter: Size getter */
  public getSize()
  {
    return table.size;
  }

  /* Class Getter: symbol getter */
  public Record getSymbol(String fName)
  {
    /* Returning value for the current function */
    Record ret;
    /* Create an integer to get the return value */
    int index = lookUp(fName);

    if(index != NOT_FOUND)
       ret = table.get(index);
    else
      ret = null;

    /* Return ret */
    return ret;
  }

  /* Class Getter: get by index */
  public Record getByIndex(int fIndex)
  {
    return table.get(fIndex);
  }

  /* Function: addToSymbolTable */
  public int addToSymbolTable(String name, String type, boolean isArray, int size)
  {
    boolean existsInSymbolTable = false;
    /* Check the ST for previous insertions */
    for(int i=0; i<table.size(); i++){
      if(table.get(i).name.equals(name)){
        existsInSymbolTable = true;
        break;
      }
    }

    /* If no previous insertions found */
    if(!existsInSymbolTable)
    {
      Record temp = new Record(name, type, isArray, size);
      table.add(temp);
      return table.size()-1;
    }
    return ERROR;
  }

  /* Function: lookUp in the table for an specific name */
  /* Default return value of "indexOf" function is -1 if not found */
  /* Otherwise it will return the index of the found element */
  public int lookUp(String name)
  {
    int ret = table.indexOf(name);
    if(ret == -1)
      /* Not found */
      return NOT_FOUND;
    else
      return ret;
  }

  /* toString override */

  public String toString()
  {
      if(table.size() == 0)
          return null;
      String res = "";
      for(int i = 0; i < table.size(); i++) {
          switch (table.type.get(i)) {
              case Genesis.TYPE_CODE_INTEGER:
                  res += "\t" + YYParser.TYPE_STRING_INTEGER;
                  break;
              case Genesis.TYPE_CODE_REAL:
                  res += "\t" + YYParser.TYPE_STRING_REAL;
                  break;
              case Genesis.TYPE_CODE_CHAR:
                  res += "\t" + YYParser.TYPE_STRING_CHAR;
                  break;
              case Genesis.TYPE_CODE_BOOLEAN:
                  res += "\t" + YYParser.TYPE_STRING_BOOLEAN;
                  break;
              case Genesis.TYPE_CODE_RANGE:
                  continue;
          }
          res += (table.isArray.get(i) ? " *" : " ") + table.name.get(i) + ";\n";
      }
      return res;
  }
}

/* Class #2: Genesis */
class Genesis {

  /* List of possbile definitions for variables and functions */
  public static final String TYPE_CODE_INTEGER ="int";
  public static final String TYPE_CODE_BOOLEAN = "bool";
  public static final String TYPE_CODE_REAL = "float";
  public static final String TYPE_CODE_CHAR = "char";
  public static final String TYPE_CODE_STRING = "string";
  public static final String Func = "function";
  public static final String rectype = "rectype";
  public static final String unknownType = "unknown";
  public static final String constOp = "const";

  /* List of possible operations */
  public static final String assignOp = ":=";
  public static final String andOp = "and";
  public static final String orOp = "or";
  public static final String notOp = "not";
  public static final String initOp = "init";
  public static final String ifOp = "if";
  public static final String stackPop = "stackPop";
  public static final String stackPush = "stackPush";
  public static final String castOP = "cast";
  public static final String gotoOp = "gotoOp";
  public static final String variableGotoOp = "varGotoOp";
  public static final String[] relopOpList = new String[]{".lte",".lt",".gt",".gte",".eq",".ne"};
  public static final String[] mathOpList = new String[]{"+","-","*","/","%"};

  /* Syntax Directed Definition */
  public String place;
  public String type;
  public boolean isArray;


  /* Required attributes for the boolean expressions */
  public Genesis defaultInit;
  public List<Genesis> typeInitList;
  public ArrayList<Integer> trueList;
  public ArrayList<Integer> falseList;
  public ArrayList<Integer> nextList;

  /* Variables to handle declarations and the list that is going to return from them */
  public ArrayList<ArrayList<Genesis>> initializersList;
  public ArrayList<Genesis> declareds;
  public ArrayList<Genesis> initializers;


  /* Genesis Constructor */
  public Genesis() {
    typeInitList = new ArrayList<>();
    trueList = new ArrayList<>();
    falseList = new ArrayList<>();
    nextList = new ArrayList<>();
  }

  /* makeList Function */
  /* A simple function to create a list ;) of number i*/
  public static ArrayList<Integer> makeList(int i) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(i);
    return list;
  }

  /* mergeList Function */
  /* A Simple function to merge two lists */
  public static ArrayList<Integer> merge(List i , List j) {
      ArrayList<Integer> list = new ArrayList<>();
      if(i!=null && i.size()>0) {
          list.addAll(i);
      }
      if(j!=null && j.size()>0) {
          list.addAll(j);
      }
      return list;
  }
  }

/* Class #3: Quadruple */
class Quadruple {
  public String operation;
  public String arg0;
  public String arg1;
  public String result;
  /* Constructor */
  public Quadruple(String operation,String arg0,String arg1,String result) {
    this.operation = operation;
    this.arg0 = arg0;
    this.arg1 = arg1;
    this.result = result;
  }

  /* Quadruple toString Override */

  public String toString()
  {
    switch(operation.toLowerCase())
    {
      case "goto":
        return operation + " " + LINE_STR + result + ";";
      case "conidition":
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
      case ":=":
        return result + " = " + arg0 + ";";
        /* integer */
      case "int_print":
        return "printf(\"%s = %d\\n\", \"" + result + "\", " + result + ");";
        /* real */
      case "real_print":
        return "printf(\"%s = %f\\n\", \"" + result + "\", " + result + ");";
        /* character */
      case "char_print":
        return "printf(\"%s = '%c'\\n\", \"" + result + "\", " + result + ");";
        /* boolean */
      case "bool_print":
        return "printf(\"%s = %s\\n\", \"" + result + "\", " + result + " ? \"true\" : \"false\");";
        /* integer array */
      case "aiprint":
        return "printf(\"%s[%d] = %d\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
         /* real array */
      case "arprint":
        return "printf(\"%s[%d] = %f\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
        /* character array */
      case "acprint":
        return "printf(\"%s[%d] = '%c'\\n\", \"" + result + "\", " + arg0 + ", " + result + "[" + arg1 + "]);";
        /* boolean array */
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
}
}
