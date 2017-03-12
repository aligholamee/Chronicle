import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;



class class_main
{
	int symbol_table_size = 100;
	public String [] symbol_table = new String[symbol_table_size];
	int entry_position = 0;
	boolean exists = false;

	public static void main(String args[])
	{
			FileReader fr = null;
	        String input = "C:\Users\Ali Gholami\Desktop\globalTest2.shl";
	        try {
	            fr = new FileReader(input);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Lexeme\tToken\tAttribute");
	        Yylex yylex = new Yylex(fr);
	        try {
	            yylex.yylex();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
%%
/* Declaration Section */
/* Identifier */
%byaccj
/* Tokens */
LETTER = [a-zA-Z]
NONZERO_DIGIT = [1-9]
DIGIT = "0"|{NONZERO_DIGIT}


/* Main & Program Keywords */
PROGRAM_KW = (program)
MAIN_KW = (main)

/* Variable Types Keywords */
INTEGER_KW = (int)
REAL_KW = (real)
CHARACTER_KW = (char)
BOOLEAN_KW = (bool)

PROCEDURE_KW = (procedure)

/* Condition Keywords */
IF_KW = (if)
THEN_KW = (then)
ELSE_KW = (else)
DO_KW = (do)
WHILE_KW = (while)
SWITCH_KW = (switch)
CASE_KW = (case)
DEFAULT_KW = (default)
END_KW = (end)
WHEN_KW = (when)

/* Utility Keywords */
FOR_KW = (for)
RETURN_KW = (return)
EXIT_KW = (exit)
UPTO_KW = (upto)
DOWNTO_KW = (downto)

/* Logical Operations Keywords */
AND_KW = (and)
OR_KW = (or)
NOT_KW = (not)

/* Separator Keywords */
SEMICOLON_KW = [;]
COLON_KW = [:]
ASSIGN_KW = (:=)
OPENBRACKET_KW = "["
CLOSEBRACKET_KW = "]"
OPENACCOLADE_KW = [{]
CLOSEACCOLADE_KW = [}]
OPENPARENTHESIS_KW = [(]
CLOSEPARENTHESIS_KW = [)]
COMMA_KW = [,]

/* Relational Operators */
LT_KW = [<]
GT_KW = [>]
EQ_KW = [=]
NEQ_KW = (<>)
GTE_KW = (>=)
LTE_KW = (<=)

/* Other Keywords */
DOT_KW = "/."
SINGLE_QUOTE_KW = "\u0027"

/* Arithmetic Operators */
ADD_KW = [+]
SUB_KW = [-]
MUL_KW = [*]
DIV_KW = [/]
MOD_KW = [%]


BOOLCONST = (true)|(false)
CHARCONST = {SINGLE_QUOTE_KW} ({LETTER} | {DIGIT}) {SINGLE_QUOTE_KW}
REALCONST = "#"(({DIGIT})|({NONZERO_DIGIT}({DIGIT})*))({DOT_KW})({DIGIT})*{NONZERO_DIGIT}
NUMCONST = "#"{DIGIT}|{NONZERO_DIGIT}{DIGIT}*
ID = {LETTER}+
%%
/* Rules Section */

{PROGRAM_KW} {
	System.out.println(yytext() + "\t" + "PROGRAM_KW\t" + '-');
}

{MAIN_KW} {
	System.out.println(yytext() + "\t" + "MAIN_KW\t" + '-');
}

{PROCEDURE_KW} {
	System.out.println(yytext() + "\t" + "PROCEDURE_KW\t" + '-');
}

{INTEGER_KW} {
	System.out.println(yytext() + "\t" + "INTEGER_KW\t" + '-');
}

{REAL_KW} {
	System.out.println(yytext() + "\t" + "REAL_KW\t" + '-');
}

{CHARACTER_KW} {
	System.out.println(yytext() + "\t" + "CHARACTER_KW\t" + '-');
}

{BOOLEAN_KW} {
	System.out.println(yytext() + "\t" + "BOOLEAN_KW\t" + '-');
}

{IF_KW} {
	System.out.println(yytext() + "\t" + "IF_KW\t" + '-');
}

{THEN_KW} {
	System.out.println(yytext() + "\t" + "THEN_KW\t" + '-');
}

{ELSE_KW} {
	System.out.println(yytext() + "\t" + "ELSE_KW\t" + '-');
}

{DO_KW} {
	System.out.println(yytext() + "\t" + "DO_KW\t" + '-');
}

{WHILE_KW} {
	System.out.println(yytext() + "\t" + "WHILE_KW\t" + '-');
}

{FOR_KW} {
	System.out.println(yytext() + "\t" + "FOR_KW\t" + '-');
}

{SWITCH_KW} {
	System.out.println(yytext() + "\t" + "SWITCH_KW\t" + '-');
}

{CASE_KW} {
	System.out.println(yytext() + "\t" + "CASE_KW\t" + '-');
}

{DEFAULT_KW} {
	System.out.println(yytext() + "\t" + "DEFAULT_KW\t" + '-');
}

{END_KW} {
	System.out.println(yytext() + "\t" + "END_KW\t" + '-');
}

{RETURN_KW} {
	System.out.println(yytext() + "\t" + "RETURN_KW\t" + '-');
}

{EXIT_KW} {
	System.out.println(yytext() + "\t" + "EXIT_KW\t" + '-');
}

{WHEN_KW} {
	System.out.println(yytext() + "\t" + "WHEN_KW\t" + '-');
}

{AND_KW} {
	System.out.println(yytext() + "\t" + "AND_KW\t" + '-');
}

{OR_KW} {
	System.out.println(yytext() + "\t" + "OR_KW\t" + '-');
}

{NOT_KW} {
	System.out.println(yytext() + "\t" + "NOT_KW\t" + '-');
}

{SEMICOLON_KW} {
	System.out.println(yytext() + "\t" + "SEMICOLON_KW\t" + '-');
}

{COLON_KW} {
	System.out.println(yytext() + "\t" + "COLON_KW\t" + '-');
}

{COMMA_KW} {
	System.out.println(yytext() + "\t" + "COMMA_KW\t" + '-');
}

{SINGLE_QUOTE_KW} {
	System.out.println(yytext() + "\t" + "SINGLE_QUOTE_KW\t" + '-');
}
{UPTO_KW} {
	System.out.println(yytext() + "\t" + "UPTO_KW\t" + '-');
}

{DOWNTO_KW} {
	System.out.println(yytext() + "\t" + "DOWNTO_KW\t" + '-');
}

{ASSIGN_KW} {
	System.out.println(yytext() + "\t" + "ASSIGN_KW\t" + '-');
}

{OPENPARENTHESIS_KW} {
	System.out.println(yytext() + "\t" + "OPENPARENTHESIS_KW\t" + '-');
}

{CLOSEPARENTHESIS_KW} {
	System.out.println(yytext() + "\t" + "CLOSEPARENTHESIS_KW\t" + '-');
}

{OPENBRACKET_KW} {
	System.out.println(yytext() + "\t" + "OPENBRACKET_KW\t" + '-');
}

{CLOSEBRACKET_KW} {
	System.out.println(yytext() + "\t" + "CLOSEBRACKET_KW\t" + '-');
}

{OPENACCOLADE_KW} {
	System.out.println(yytext() + "\t" + "OPENACCOLADE_KW\t" + '-');
}

{CLOSEACCOLADE_KW} {
	System.out.println(yytext() + "\t" + "CLOSEACCOLADE_KW\t" + '-');
}

{DOT_KW} {
	System.out.println(yytext() + "\t" + "DOT_KW\t" + '-');
}

{LT_KW} {
	System.out.println(yytext() + "\t" + "LT_KW\t" + '-');
}

{GT_KW} {
	System.out.println(yytext() + "\t" + "GT_KW\t" + '-');
}

{EQ_KW} {
	System.out.println(yytext() + "\t" + "EQ_KW\t" + '-');
}

{NEQ_KW} {
	System.out.println(yytext() + "\t" + "NEQ_KW\t" + '-');
}

{GTE_KW} {
	System.out.println(yytext() + "\t" + "GTE_KW\t" + '-');
}

{LTE_KW} {
	System.out.println(yytext() + "\t" + "LTE_KW\t" + '-');
}

{ADD_KW} {
	System.out.println(yytext() + "\t" + "ADD_KW\t" + '-');
}

{SUB_KW} {
	System.out.println(yytext() + "\t" + "SUB_KW\t" + '-');
}
{MUL_KW} {
	System.out.println(yytext() + "\t" + "MUL_KW\t" + '-');
}

{DIV_KW} {
	System.out.println(yytext() + "\t" + "DIV_KW\t" + '-');
}

{MOD_KW} {
	System.out.println(yytext() + "\t" + "MOD_KW\t" + '-');
}

{BOOLCONST} {
	System.out.println(yytext() + "\t" + "BOOLCONST\t" + '-');
}

{CHARCONST} {
	System.out.println(yytext() + "\t" + "CHARCONST\t" + '-');
}

{REALCONST} {
	System.out.println(yytext() + "\t" + "REALCONST\t" + '-');
}

{NUMCONST} {
	System.out.println(yytext() + "\t" + "NUMCONST\t" + '-');
}

{ID} {
	System.out.println(yytext() + "\t" + "ID\t" + "Symbol Table Entry");
}

"\s"|"\n"|"\r"|"\t" {
}

. {
}