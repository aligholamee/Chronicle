/* A Bison parser, made by GNU Bison 2.5.  */

/* Skeleton implementation for Bison LALR(1) parsers in Java
   
      Copyright (C) 2007-2011 Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* First part of user declarations.  */

/* Line 32 of lalr1.java  */
/* Line 2 of "YYParser.y"  */

  package chronicle;
  import java.io.*;


/**
 * A Bison parser, automatically generated from <tt>YYParser.y</tt>.
 *
 * @author LALR (1) parser skeleton written by Paolo Bonzini.
 */
class YYParser
{
    /** Version number for the Bison executable that generated this parser.  */
  public static final String bisonVersion = "2.5";

  /** Name of the skeleton that generated this parser.  */
  public static final String bisonSkeleton = "lalr1.java";


  /** True if verbose error messages are enabled.  */
  public boolean errorVerbose = false;



  /** Token returned by the scanner to signal the end of its input.  */
  public static final int EOF = 0;

/* Tokens.  */
  /** Token number, to be returned by the scanner.  */
  public static final int ID = 258;
  /** Token number, to be returned by the scanner.  */
  public static final int NUMCONST = 259;
  /** Token number, to be returned by the scanner.  */
  public static final int REALCONST = 260;
  /** Token number, to be returned by the scanner.  */
  public static final int CHARCONST = 261;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOLCONST = 262;
  /** Token number, to be returned by the scanner.  */
  public static final int SHARP_KW = 263;
  /** Token number, to be returned by the scanner.  */
  public static final int MOD_KW = 264;
  /** Token number, to be returned by the scanner.  */
  public static final int DIV_KW = 265;
  /** Token number, to be returned by the scanner.  */
  public static final int MUL_KW = 266;
  /** Token number, to be returned by the scanner.  */
  public static final int SUB_KW = 267;
  /** Token number, to be returned by the scanner.  */
  public static final int ADD_KW = 268;
  /** Token number, to be returned by the scanner.  */
  public static final int SINGLE_QUOTE_KW = 269;
  /** Token number, to be returned by the scanner.  */
  public static final int DOT_KW = 270;
  /** Token number, to be returned by the scanner.  */
  public static final int LTE_KW = 271;
  /** Token number, to be returned by the scanner.  */
  public static final int GTE_KW = 272;
  /** Token number, to be returned by the scanner.  */
  public static final int NEQ_KW = 273;
  /** Token number, to be returned by the scanner.  */
  public static final int EQ_KW = 274;
  /** Token number, to be returned by the scanner.  */
  public static final int GT_KW = 275;
  /** Token number, to be returned by the scanner.  */
  public static final int LT_KW = 276;
  /** Token number, to be returned by the scanner.  */
  public static final int COMMA_KW = 277;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEPARENTHESIS_KW = 278;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENPARENTHESIS_KW = 279;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEACCOLADE_KW = 280;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENACCOLADE_KW = 281;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEBRACKET_KW = 282;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENBRACKET_KW = 283;
  /** Token number, to be returned by the scanner.  */
  public static final int ASSIGN_KW = 284;
  /** Token number, to be returned by the scanner.  */
  public static final int COLON_KW = 285;
  /** Token number, to be returned by the scanner.  */
  public static final int SEMICOLON_KW = 286;
  /** Token number, to be returned by the scanner.  */
  public static final int NOT_KW = 287;
  /** Token number, to be returned by the scanner.  */
  public static final int OR_KW = 288;
  /** Token number, to be returned by the scanner.  */
  public static final int AND_KW = 289;
  /** Token number, to be returned by the scanner.  */
  public static final int DOWNTO_KW = 290;
  /** Token number, to be returned by the scanner.  */
  public static final int UPTO_KW = 291;
  /** Token number, to be returned by the scanner.  */
  public static final int EXIT_KW = 292;
  /** Token number, to be returned by the scanner.  */
  public static final int RETURN_KW = 293;
  /** Token number, to be returned by the scanner.  */
  public static final int FOR_KW = 294;
  /** Token number, to be returned by the scanner.  */
  public static final int WHEN_KW = 295;
  /** Token number, to be returned by the scanner.  */
  public static final int END_KW = 296;
  /** Token number, to be returned by the scanner.  */
  public static final int DEFAULT_KW = 297;
  /** Token number, to be returned by the scanner.  */
  public static final int CASE_KW = 298;
  /** Token number, to be returned by the scanner.  */
  public static final int SWITCH_KW = 299;
  /** Token number, to be returned by the scanner.  */
  public static final int WHILE_KW = 300;
  /** Token number, to be returned by the scanner.  */
  public static final int DO_KW = 301;
  /** Token number, to be returned by the scanner.  */
  public static final int ELSE_KW = 302;
  /** Token number, to be returned by the scanner.  */
  public static final int THEN_KW = 303;
  /** Token number, to be returned by the scanner.  */
  public static final int IF_KW = 304;
  /** Token number, to be returned by the scanner.  */
  public static final int PROCEDURE_KW = 305;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOLEAN_KW = 306;
  /** Token number, to be returned by the scanner.  */
  public static final int CHARACTER_KW = 307;
  /** Token number, to be returned by the scanner.  */
  public static final int REAL_KW = 308;
  /** Token number, to be returned by the scanner.  */
  public static final int INTEGER_KW = 309;
  /** Token number, to be returned by the scanner.  */
  public static final int MAIN_KW = 310;
  /** Token number, to be returned by the scanner.  */
  public static final int PROGRAM_KW = 311;
  /** Token number, to be returned by the scanner.  */
  public static final int DIGIT = 312;
  /** Token number, to be returned by the scanner.  */
  public static final int NONZERO_DIGIT = 313;
  /** Token number, to be returned by the scanner.  */
  public static final int LETTER = 314;



  

  /**
   * Communication interface between the scanner and the Bison-generated
   * parser <tt>YYParser</tt>.
   */
  public interface Lexer {
    

    /**
     * Method to retrieve the semantic value of the last scanned token.
     * @return the semantic value of the last scanned token.  */
    Object getLVal ();

    /**
     * Entry point for the scanner.  Returns the token identifier corresponding
     * to the next token and prepares to return the semantic value
     * of the token.
     * @return the token identifier corresponding to the next token. */
    int yylex () throws java.io.IOException;

    /**
     * Entry point for error reporting.  Emits an error
     * in a user-defined way.
     *
     * 
     * @param s The string for the error message.  */
     void yyerror (String s);
  }

  /** The object doing lexical analysis for us.  */
  private Lexer yylexer;
  
  



  /**
   * Instantiates the Bison-generated parser.
   * @param yylexer The scanner that will supply tokens to the parser.
   */
  public YYParser (Lexer yylexer) {
    this.yylexer = yylexer;
    
  }

  private java.io.PrintStream yyDebugStream = System.err;

  /**
   * Return the <tt>PrintStream</tt> on which the debugging output is
   * printed.
   */
  public final java.io.PrintStream getDebugStream () { return yyDebugStream; }

  /**
   * Set the <tt>PrintStream</tt> on which the debug output is printed.
   * @param s The stream that is used for debugging output.
   */
  public final void setDebugStream(java.io.PrintStream s) { yyDebugStream = s; }

  private int yydebug = 0;

  /**
   * Answer the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   */
  public final int getDebugLevel() { return yydebug; }

  /**
   * Set the verbosity of the debugging output; 0 means that all kinds of
   * output from the parser are suppressed.
   * @param level The verbosity level for debugging output.
   */
  public final void setDebugLevel(int level) { yydebug = level; }

  private final int yylex () throws java.io.IOException {
    return yylexer.yylex ();
  }
  protected final void yyerror (String s) {
    yylexer.yyerror (s);
  }

  

  protected final void yycdebug (String s) {
    if (yydebug > 0)
      yyDebugStream.println (s);
  }

  private final class YYStack {
    private int[] stateStack = new int[16];
    
    private Object[] valueStack = new Object[16];

    public int size = 16;
    public int height = -1;

    public final void push (int state, Object value			    ) {
      height++;
      if (size == height)
        {
	  int[] newStateStack = new int[size * 2];
	  System.arraycopy (stateStack, 0, newStateStack, 0, height);
	  stateStack = newStateStack;
	  

	  Object[] newValueStack = new Object[size * 2];
	  System.arraycopy (valueStack, 0, newValueStack, 0, height);
	  valueStack = newValueStack;

	  size *= 2;
	}

      stateStack[height] = state;
      
      valueStack[height] = value;
    }

    public final void pop () {
      pop (1);
    }

    public final void pop (int num) {
      // Avoid memory leaks... garbage collection is a white lie!
      if (num > 0) {
	java.util.Arrays.fill (valueStack, height - num + 1, height + 1, null);
        
      }
      height -= num;
    }

    public final int stateAt (int i) {
      return stateStack[height - i];
    }

    public final Object valueAt (int i) {
      return valueStack[height - i];
    }

    // Print the state stack on the debug stream.
    public void print (java.io.PrintStream out)
    {
      out.print ("Stack now");

      for (int i = 0; i <= height; i++)
        {
	  out.print (' ');
	  out.print (stateStack[i]);
        }
      out.println ();
    }
  }

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return success (<tt>true</tt>).  */
  public static final int YYACCEPT = 0;

  /**
   * Returned by a Bison action in order to stop the parsing process and
   * return failure (<tt>false</tt>).  */
  public static final int YYABORT = 1;

  /**
   * Returned by a Bison action in order to start error recovery without
   * printing an error message.  */
  public static final int YYERROR = 2;

  // Internal return codes that are not supported for user semantic
  // actions.
  private static final int YYERRLAB = 3;
  private static final int YYNEWSTATE = 4;
  private static final int YYDEFAULT = 5;
  private static final int YYREDUCE = 6;
  private static final int YYERRLAB1 = 7;
  private static final int YYRETURN = 8;

  private int yyerrstatus_ = 0;

  /**
   * Return whether error recovery is being done.  In this state, the parser
   * reads token until it reaches a known state, and then restarts normal
   * operation.  */
  public final boolean recovering ()
  {
    return yyerrstatus_ == 0;
  }

  private int yyaction (int yyn, YYStack yystack, int yylen) 
  {
    Object yyval;
    

    /* If YYLEN is nonzero, implement the default value of the action:
       `$$ = $1'.  Otherwise, use the top of the stack.

       Otherwise, the following line sets YYVAL to garbage.
       This behavior is undocumented and Bison
       users should not rely upon it.  */
    if (yylen > 0)
      yyval = yystack.valueAt (yylen - 1);
    else
      yyval = yystack.valueAt (0);

    yy_reduce_print (yyn, yystack);

    switch (yyn)
      {
	  case 2:
  if (yyn == 2)
    
/* Line 351 of lalr1.java  */
/* Line 55 of "YYParser.y"  */
    {
    System.out.println("Rule 1.1: " +
      "program -> PROGRAM_KW ID MAIN_KW");
  };
  break;
    

  case 3:
  if (yyn == 3)
    
/* Line 351 of lalr1.java  */
/* Line 59 of "YYParser.y"  */
    {
		System.out.println("Rule 1.2: " +
			"program -> PROGRAM_KW ID MAIN_KW block");
	};
  break;
    

  case 4:
  if (yyn == 4)
    
/* Line 351 of lalr1.java  */
/* Line 63 of "YYParser.y"  */
    {
		System.out.println("Rule 1.3: " +
			"program -> PROGRAM_KW ID declarations_list MAIN_KW block");
	};
  break;
    

  case 5:
  if (yyn == 5)
    
/* Line 351 of lalr1.java  */
/* Line 67 of "YYParser.y"  */
    {
		System.out.println("Rule 1.4: " +
			"program -> PROGRAM_KW ID procedure_list MAIN_KW block");
	};
  break;
    

  case 6:
  if (yyn == 6)
    
/* Line 351 of lalr1.java  */
/* Line 71 of "YYParser.y"  */
    {
		System.out.println("Rule 1.5: " +
			"program -> PROGRAM_KW ID declarations_list procedure_list MAIN_KW block");
	};
  break;
    

  case 7:
  if (yyn == 7)
    
/* Line 351 of lalr1.java  */
/* Line 77 of "YYParser.y"  */
    {
		System.out.println("Rule 2.1: " +
			"declarations_list -> declarations_list declarations");
	};
  break;
    

  case 8:
  if (yyn == 8)
    
/* Line 351 of lalr1.java  */
/* Line 82 of "YYParser.y"  */
    {
		System.out.println("Rule 2.2: " +
			"declarations_list -> declarations");
	};
  break;
    

  case 9:
  if (yyn == 9)
    
/* Line 351 of lalr1.java  */
/* Line 89 of "YYParser.y"  */
    {
		System.out.println("Rule 3.1: " +
			"declarations -> type_specifiers declarator_list SEMICOLON_KW");
	};
  break;
    

  case 10:
  if (yyn == 10)
    
/* Line 351 of lalr1.java  */
/* Line 97 of "YYParser.y"  */
    {
		System.out.println("Rule 4.1: " +
			"type_specifiers -> INTEGER_KW");
	};
  break;
    

  case 11:
  if (yyn == 11)
    
/* Line 351 of lalr1.java  */
/* Line 101 of "YYParser.y"  */
    {
		System.out.println("Rule 4.2: " +
			"type_specifiers -> REAL_KW");
	};
  break;
    

  case 12:
  if (yyn == 12)
    
/* Line 351 of lalr1.java  */
/* Line 105 of "YYParser.y"  */
    {
		System.out.println("Rule 4.3: " +
			"type_specifiers -> CHAR_KW");
	};
  break;
    

  case 13:
  if (yyn == 13)
    
/* Line 351 of lalr1.java  */
/* Line 109 of "YYParser.y"  */
    {
		System.out.println("Rule 4.4: " +
			"type_specifiers -> BOOLEAN_KW");
	};
  break;
    

  case 14:
  if (yyn == 14)
    
/* Line 351 of lalr1.java  */
/* Line 115 of "YYParser.y"  */
    {
		System.out.println("Rule 5.1: " +
			"declarator_list -> declarator");
	};
  break;
    

  case 15:
  if (yyn == 15)
    
/* Line 351 of lalr1.java  */
/* Line 119 of "YYParser.y"  */
    {
		System.out.println("Rule 5.2: " +
			"declarator_list -> declarator_list COMMA_KW declarator");
	};
  break;
    

  case 16:
  if (yyn == 16)
    
/* Line 351 of lalr1.java  */
/* Line 127 of "YYParser.y"  */
    {
		System.out.println("Rule 6.1: " +
			"declarator -> dec");
	};
  break;
    

  case 17:
  if (yyn == 17)
    
/* Line 351 of lalr1.java  */
/* Line 131 of "YYParser.y"  */
    {
		System.out.println("Rule 6.2: " +
			"declarator -> dec ASSIGN_KW initializer");
	};
  break;
    

  case 18:
  if (yyn == 18)
    
/* Line 351 of lalr1.java  */
/* Line 138 of "YYParser.y"  */
    {
		System.out.println("Rule 7.1: " +
			"dec -> ID");
	};
  break;
    

  case 19:
  if (yyn == 19)
    
/* Line 351 of lalr1.java  */
/* Line 142 of "YYParser.y"  */
    {
		System.out.println("Rule 7.2: " +
			"dec -> ID OPENBRACKET_KW range CLOSEBRACKET_KW");
	};
  break;
    

  case 20:
  if (yyn == 20)
    
/* Line 351 of lalr1.java  */
/* Line 146 of "YYParser.y"  */
    {
		System.out.println("Rule 7.3: " +
			"dec -> ID OPENBRACKET_KW NUMCONST CLOSEBRACKET_KW");
	};
  break;
    

  case 21:
  if (yyn == 21)
    
/* Line 351 of lalr1.java  */
/* Line 154 of "YYParser.y"  */
    {
		System.out.println("Rule 8.1: " +
			"range -> ID DOT_KW ID");
	};
  break;
    

  case 22:
  if (yyn == 22)
    
/* Line 351 of lalr1.java  */
/* Line 158 of "YYParser.y"  */
    {
		System.out.println("Rule 8.2: " +
			"range -> NUMCONST DOT_KW NUMCONST");
	};
  break;
    

  case 23:
  if (yyn == 23)
    
/* Line 351 of lalr1.java  */
/* Line 162 of "YYParser.y"  */
    {
		System.out.println("Rule 8.3: " +
			"range -> arithmetic_expressions DOT_KW arithmetic_expressions");
	};
  break;
    

  case 24:
  if (yyn == 24)
    
/* Line 351 of lalr1.java  */
/* Line 168 of "YYParser.y"  */
    {
		System.out.println("Rule 9.1: " +
			"initializer -> constant_expressions");
	};
  break;
    

  case 25:
  if (yyn == 25)
    
/* Line 351 of lalr1.java  */
/* Line 172 of "YYParser.y"  */
    {
		System.out.println("Rule 9.2: " +
			"initializer -> OPENACCOLADE_KW initializer CLOSEACCOLADE_KW");
	};
  break;
    

  case 26:
  if (yyn == 26)
    
/* Line 351 of lalr1.java  */
/* Line 180 of "YYParser.y"  */
    {
		System.out.println("Rule 10.1: " +
			"initializer_list -> constant_expressions COMMA_KW initializer_list");
	};
  break;
    

  case 27:
  if (yyn == 27)
    
/* Line 351 of lalr1.java  */
/* Line 184 of "YYParser.y"  */
    {
		System.out.println("Rule 10.2: " +
			"initializer_list -> constant_expressions");
	};
  break;
    

  case 28:
  if (yyn == 28)
    
/* Line 351 of lalr1.java  */
/* Line 190 of "YYParser.y"  */
    {
		System.out.println("Rule 11.1: " +
			"procedure_list -> procedure_list procedure");
	};
  break;
    

  case 29:
  if (yyn == 29)
    
/* Line 351 of lalr1.java  */
/* Line 194 of "YYParser.y"  */
    {
		System.out.println("Rule 11.2: " +
			"procedure_list -> procedure");
	};
  break;
    

  case 30:
  if (yyn == 30)
    
/* Line 351 of lalr1.java  */
/* Line 200 of "YYParser.y"  */
    {
   System.out.println("Rule 12.1: " +
     "procedure -> PROCEDURE_KW ID parameters OPENACCOLADE_KW block CLOSEACCOLADE_KW SEMICOLON_KW");
  };
  break;
    

  case 31:
  if (yyn == 31)
    
/* Line 351 of lalr1.java  */
/* Line 204 of "YYParser.y"  */
    {
		System.out.println("Rule 12.2: " +
			"procedure -> PROCEDURE_KW ID parameters OPENACCOLADE_KW declarations_list block CLOSEACCOLADE_KW SEMICOLON_KW");
	};
  break;
    

  case 32:
  if (yyn == 32)
    
/* Line 351 of lalr1.java  */
/* Line 210 of "YYParser.y"  */
    {
		System.out.println("Rule 13.1: " +
			"parameters -> OPENPARENTHESIS_KW declarations_list CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 33:
  if (yyn == 33)
    
/* Line 351 of lalr1.java  */
/* Line 216 of "YYParser.y"  */
    {
		System.out.println("Rule 14.1: " +
			"block -> OPENACCOLADE_KW statement_list CLOSEACCOLADE_KW");
	};
  break;
    

  case 34:
  if (yyn == 34)
    
/* Line 351 of lalr1.java  */
/* Line 222 of "YYParser.y"  */
    {
		System.out.println("Rule 15.1: " +
			"statement_list -> statement SEMICOLON_KW");
	};
  break;
    

  case 35:
  if (yyn == 35)
    
/* Line 351 of lalr1.java  */
/* Line 226 of "YYParser.y"  */
    {
		System.out.println("Rule 15.2: " +
			"statement_list -> statement_list statement SEMICOLON_KW");
	};
  break;
    

  case 36:
  if (yyn == 36)
    
/* Line 351 of lalr1.java  */
/* Line 230 of "YYParser.y"  */
    {
		System.out.println("Rule 15.3: " +
			"statement_list -> SEMICOLON_KW");
	};
  break;
    

  case 37:
  if (yyn == 37)
    
/* Line 351 of lalr1.java  */
/* Line 234 of "YYParser.y"  */
    {
		System.out.println("Rule 15.4: " +
			"statement_list -> statement_list SEMICOLON_KW");
	};
  break;
    

  case 38:
  if (yyn == 38)
    
/* Line 351 of lalr1.java  */
/* Line 240 of "YYParser.y"  */
    {
		System.out.println("Rule 16.1: " +
			"statement -> ID ASSIGN_KW expressions");
	};
  break;
    

  case 39:
  if (yyn == 39)
    
/* Line 351 of lalr1.java  */
/* Line 244 of "YYParser.y"  */
    {
		System.out.println("Rule 16.2: " +
			"statement -> IF_KW bool_expressions THEN_KW statement");
	};
  break;
    

  case 40:
  if (yyn == 40)
    
/* Line 351 of lalr1.java  */
/* Line 248 of "YYParser.y"  */
    {
		System.out.println("Rule 16.3: " +
			"statement -> IF_KW bool_expressions THEN_KW statement ELSE_KW statement");
	};
  break;
    

  case 41:
  if (yyn == 41)
    
/* Line 351 of lalr1.java  */
/* Line 252 of "YYParser.y"  */
    {
		System.out.println("Rule 16.4: " +
			"statement -> DO_KW statement WHILE_KW bool_expressions");
	};
  break;
    

  case 42:
  if (yyn == 42)
    
/* Line 351 of lalr1.java  */
/* Line 256 of "YYParser.y"  */
    {
		System.out.println("Rule 16.5: " +
			"statement -> FOR_KW ID ASSIGN_KW counter DO_KW statement");
	};
  break;
    

  case 43:
  if (yyn == 43)
    
/* Line 351 of lalr1.java  */
/* Line 260 of "YYParser.y"  */
    {
		System.out.println("Rule 16.6: " +
			"statement -> SWITCH_KW expressions case_element default END_KW");
	};
  break;
    

  case 44:
  if (yyn == 44)
    
/* Line 351 of lalr1.java  */
/* Line 264 of "YYParser.y"  */
    {
		System.out.println("Rule 16.7: " +
			"statement -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 45:
  if (yyn == 45)
    
/* Line 351 of lalr1.java  */
/* Line 268 of "YYParser.y"  */
    {
		System.out.println("Rule 16.8: " +
			"statement -> IDENTIFIER OPENBRACKET_KW expressions CLOSEBRACKET_KW ASSIGN_KW expressions");
	};
  break;
    

  case 46:
  if (yyn == 46)
    
/* Line 351 of lalr1.java  */
/* Line 272 of "YYParser.y"  */
    {
		System.out.println("Rule 16.9: " +
			"statement -> RETURN_KW expressions");
	};
  break;
    

  case 47:
  if (yyn == 47)
    
/* Line 351 of lalr1.java  */
/* Line 276 of "YYParser.y"  */
    {
		System.out.println("Rule 16.10: " +
			"statement -> EXIT_KW WHEN_KW bool_expressions");
	};
  break;
    

  case 48:
  if (yyn == 48)
    
/* Line 351 of lalr1.java  */
/* Line 280 of "YYParser.y"  */
    {
		System.out.println("Rule 16.11: " +
			"statement -> block");
	};
  break;
    

  case 49:
  if (yyn == 49)
    
/* Line 351 of lalr1.java  */
/* Line 284 of "YYParser.y"  */
    {
		System.out.println("Rule 16.12: " +
			"statement -> ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 50:
  if (yyn == 50)
    
/* Line 351 of lalr1.java  */
/* Line 288 of "YYParser.y"  */
    {
		System.out.println("Rule 16.13: " +
			"statement -> SWITCH_KW expressions case_element END_KW");
	};
  break;
    

  case 51:
  if (yyn == 51)
    
/* Line 351 of lalr1.java  */
/* Line 294 of "YYParser.y"  */
    {
		System.out.println("Rule 17.1: " +
			"arguments_list -> multi_arguments");
	};
  break;
    

  case 52:
  if (yyn == 52)
    
/* Line 351 of lalr1.java  */
/* Line 300 of "YYParser.y"  */
    {
		System.out.println("Rule 18.1: " +
			"multi_arguments -> multi_arguments COMMA_KW expressions");
	};
  break;
    

  case 53:
  if (yyn == 53)
    
/* Line 351 of lalr1.java  */
/* Line 304 of "YYParser.y"  */
    {
		System.out.println("Rule 18.2: " +
			"multi_arguments -> expressions");
	};
  break;
    

  case 54:
  if (yyn == 54)
    
/* Line 351 of lalr1.java  */
/* Line 310 of "YYParser.y"  */
    {
		System.out.println("Rule 19.1: " +
			"counter -> NUMCONST UPTO_KW NUMCONST");
	};
  break;
    

  case 55:
  if (yyn == 55)
    
/* Line 351 of lalr1.java  */
/* Line 314 of "YYParser.y"  */
    {
		System.out.println("Rule 19.2: " +
			"counter -> NUMCONST DOWNTO_KW NUMCONST");
	};
  break;
    

  case 56:
  if (yyn == 56)
    
/* Line 351 of lalr1.java  */
/* Line 320 of "YYParser.y"  */
    {
		System.out.println("Rule 20.1: " +
			"case_element -> CASE_KW NUMCONST COLON_KW block");
	};
  break;
    

  case 57:
  if (yyn == 57)
    
/* Line 351 of lalr1.java  */
/* Line 324 of "YYParser.y"  */
    {
		System.out.println("Rule 20.2: " +
			"case_element -> case_element CASE_KW NUMCONST COLON_KW block");
	};
  break;
    

  case 58:
  if (yyn == 58)
    
/* Line 351 of lalr1.java  */
/* Line 330 of "YYParser.y"  */
    {
		System.out.println("Rule 21.1: " +
			"default -> DEFAULT_KW COLON_KW block");
	};
  break;
    

  case 59:
  if (yyn == 59)
    
/* Line 351 of lalr1.java  */
/* Line 336 of "YYParser.y"  */
    {
		System.out.println("Rule 22.1: " +
			"expressions -> constant_expressions");
	};
  break;
    

  case 60:
  if (yyn == 60)
    
/* Line 351 of lalr1.java  */
/* Line 340 of "YYParser.y"  */
    {
		System.out.println("Rule 22.2: " +
			"expressions -> bool_expressions");
	};
  break;
    

  case 61:
  if (yyn == 61)
    
/* Line 351 of lalr1.java  */
/* Line 344 of "YYParser.y"  */
    {
		System.out.println("Rule 22.3: " +
			"expressions -> arithmetic_expressions");
	};
  break;
    

  case 62:
  if (yyn == 62)
    
/* Line 351 of lalr1.java  */
/* Line 348 of "YYParser.y"  */
    {
		System.out.println("Rule 22.4: " +
			"expressions -> ID");
	};
  break;
    

  case 63:
  if (yyn == 63)
    
/* Line 351 of lalr1.java  */
/* Line 352 of "YYParser.y"  */
    {
		System.out.println("Rule 22.5: " +
			"expressions -> ID OPENBRACKET_KW expressions CLOSEBRACKET_KW");
	};
  break;
    

  case 64:
  if (yyn == 64)
    
/* Line 351 of lalr1.java  */
/* Line 356 of "YYParser.y"  */
    {
		System.out.println("Rule 22.6: " +
			"expressions -> ID OPENPARENTHESIS_KW arguments_list CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 65:
  if (yyn == 65)
    
/* Line 351 of lalr1.java  */
/* Line 360 of "YYParser.y"  */
    {
		System.out.println("Rule 22.7: " +
			"expressions -> OPENPARENTHESIS_KW expressions CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 66:
  if (yyn == 66)
    
/* Line 351 of lalr1.java  */
/* Line 364 of "YYParser.y"  */
    {
		System.out.println("Rule 22.8: " +
			"expressions -> ID OPENPARENTHESIS_KW CLOSEPARENTHESIS_KW");
	};
  break;
    

  case 67:
  if (yyn == 67)
    
/* Line 351 of lalr1.java  */
/* Line 370 of "YYParser.y"  */
    {
		System.out.println("Rule 23.1: " +
			"constant_expressions -> NUMCONST");
	};
  break;
    

  case 68:
  if (yyn == 68)
    
/* Line 351 of lalr1.java  */
/* Line 374 of "YYParser.y"  */
    {
		System.out.println("Rule 23.2: " +
			"constant_expressions -> REALCONST");
	};
  break;
    

  case 69:
  if (yyn == 69)
    
/* Line 351 of lalr1.java  */
/* Line 378 of "YYParser.y"  */
    {
		System.out.println("Rule 23.3: " +
			"constant_expressions -> CHARCONST");
	};
  break;
    

  case 70:
  if (yyn == 70)
    
/* Line 351 of lalr1.java  */
/* Line 382 of "YYParser.y"  */
    {
		System.out.println("Rule 23.4: " +
			"constant_expressions -> BOOLEAN_KW");
	};
  break;
    

  case 71:
  if (yyn == 71)
    
/* Line 351 of lalr1.java  */
/* Line 388 of "YYParser.y"  */
    {
		System.out.println("Rule 24.1: " +
			"bool_expressions -> LT_KW pair");
	};
  break;
    

  case 72:
  if (yyn == 72)
    
/* Line 351 of lalr1.java  */
/* Line 392 of "YYParser.y"  */
    {
		System.out.println("Rule 24.2: " +
			"bool_expressions -> LTE_KW pair");
	};
  break;
    

  case 73:
  if (yyn == 73)
    
/* Line 351 of lalr1.java  */
/* Line 396 of "YYParser.y"  */
    {
    System.out.println("Rule 24.3: " +
      "bool_expressions -> GT_KW pair");
  };
  break;
    

  case 74:
  if (yyn == 74)
    
/* Line 351 of lalr1.java  */
/* Line 400 of "YYParser.y"  */
    {
    System.out.println("Rule 24.4: " +
      "bool_expressions -> GTE_KW pair");
  };
  break;
    

  case 75:
  if (yyn == 75)
    
/* Line 351 of lalr1.java  */
/* Line 404 of "YYParser.y"  */
    {
    System.out.println("Rule 24.5: " +
      "bool_expressions -> EQ_KW pair");
  };
  break;
    

  case 76:
  if (yyn == 76)
    
/* Line 351 of lalr1.java  */
/* Line 408 of "YYParser.y"  */
    {
    System.out.println("Rule 24.6: " +
      "bool_expressions -> NEQ_KW pair");
  };
  break;
    

  case 77:
  if (yyn == 77)
    
/* Line 351 of lalr1.java  */
/* Line 412 of "YYParser.y"  */
    {
		System.out.println("Rule 24.7: " +
			"bool_expressions -> AND_KW THEN_KW pair");
	};
  break;
    

  case 78:
  if (yyn == 78)
    
/* Line 351 of lalr1.java  */
/* Line 416 of "YYParser.y"  */
    {
		System.out.println("Rule 24.8: " +
			"bool_expressions -> OR_KW ELSE_KW pair");
	};
  break;
    

  case 79:
  if (yyn == 79)
    
/* Line 351 of lalr1.java  */
/* Line 422 of "YYParser.y"  */
    {
		System.out.println("Rule 25.1: " +
			"arithmetic_expressions -> ADD_KW pair");
	};
  break;
    

  case 80:
  if (yyn == 80)
    
/* Line 351 of lalr1.java  */
/* Line 426 of "YYParser.y"  */
    {
		System.out.println("Rule 25.2: " +
			"arithmetic_expressions -> SUB_KW pair");
	};
  break;
    

  case 81:
  if (yyn == 81)
    
/* Line 351 of lalr1.java  */
/* Line 430 of "YYParser.y"  */
    {
		System.out.println("Rule 25.3: " +
			"arithmetic_expressions -> MUL_KW pair");
	};
  break;
    

  case 82:
  if (yyn == 82)
    
/* Line 351 of lalr1.java  */
/* Line 434 of "YYParser.y"  */
    {
		System.out.println("Rule 25.4: " +
			"arithmetic_expressions -> DIV_KW pair");
	};
  break;
    

  case 83:
  if (yyn == 83)
    
/* Line 351 of lalr1.java  */
/* Line 438 of "YYParser.y"  */
    {
		System.out.println("Rule 25.5: " +
			"arithmetic_expressions -> MOD_KW pair");
	};
  break;
    

  case 84:
  if (yyn == 84)
    
/* Line 351 of lalr1.java  */
/* Line 442 of "YYParser.y"  */
    {
		System.out.println("Rule 25.6: " +
			"arithmetic_expressions -> SUB_KW expressions");
	};
  break;
    

  case 85:
  if (yyn == 85)
    
/* Line 351 of lalr1.java  */
/* Line 448 of "YYParser.y"  */
    {
		System.out.println("Rule 26.1: " +
			"pair: OPENPARENTHESIS_KW expressions COMMA_KW expressions CLOSEPARENTHESIS_KW");
	};
  break;
    



/* Line 351 of lalr1.java  */
/* Line 1402 of "YYParser.java"  */
	default: break;
      }

    yy_symbol_print ("-> $$ =", yyr1_[yyn], yyval);

    yystack.pop (yylen);
    yylen = 0;

    /* Shift the result of the reduction.  */
    yyn = yyr1_[yyn];
    int yystate = yypgoto_[yyn - yyntokens_] + yystack.stateAt (0);
    if (0 <= yystate && yystate <= yylast_
	&& yycheck_[yystate] == yystack.stateAt (0))
      yystate = yytable_[yystate];
    else
      yystate = yydefgoto_[yyn - yyntokens_];

    yystack.push (yystate, yyval);
    return YYNEWSTATE;
  }

  /* Return YYSTR after stripping away unnecessary quotes and
     backslashes, so that it's suitable for yyerror.  The heuristic is
     that double-quoting is unnecessary unless the string contains an
     apostrophe, a comma, or backslash (other than backslash-backslash).
     YYSTR is taken from yytname.  */
  private final String yytnamerr_ (String yystr)
  {
    if (yystr.charAt (0) == '"')
      {
        StringBuffer yyr = new StringBuffer ();
        strip_quotes: for (int i = 1; i < yystr.length (); i++)
          switch (yystr.charAt (i))
            {
            case '\'':
            case ',':
              break strip_quotes;

            case '\\':
	      if (yystr.charAt(++i) != '\\')
                break strip_quotes;
              /* Fall through.  */
            default:
              yyr.append (yystr.charAt (i));
              break;

            case '"':
              return yyr.toString ();
            }
      }
    else if (yystr.equals ("$end"))
      return "end of input";

    return yystr;
  }

  /*--------------------------------.
  | Print this symbol on YYOUTPUT.  |
  `--------------------------------*/

  private void yy_symbol_print (String s, int yytype,
			         Object yyvaluep				 )
  {
    if (yydebug > 0)
    yycdebug (s + (yytype < yyntokens_ ? " token " : " nterm ")
	      + yytname_[yytype] + " ("
	      + (yyvaluep == null ? "(null)" : yyvaluep.toString ()) + ")");
  }

  /**
   * Parse input from the scanner that was specified at object construction
   * time.  Return whether the end of the input was reached successfully.
   *
   * @return <tt>true</tt> if the parsing succeeds.  Note that this does not
   *          imply that there were no syntax errors.
   */
  public boolean parse () throws java.io.IOException
  {
    /// Lookahead and lookahead in internal form.
    int yychar = yyempty_;
    int yytoken = 0;

    /* State.  */
    int yyn = 0;
    int yylen = 0;
    int yystate = 0;

    YYStack yystack = new YYStack ();

    /* Error handling.  */
    int yynerrs_ = 0;
    

    /// Semantic value of the lookahead.
    Object yylval = null;

    int yyresult;

    yycdebug ("Starting parse\n");
    yyerrstatus_ = 0;


    /* Initialize the stack.  */
    yystack.push (yystate, yylval);

    int label = YYNEWSTATE;
    for (;;)
      switch (label)
      {
        /* New state.  Unlike in the C/C++ skeletons, the state is already
	   pushed when we come here.  */
      case YYNEWSTATE:
        yycdebug ("Entering state " + yystate + "\n");
        if (yydebug > 0)
          yystack.print (yyDebugStream);

        /* Accept?  */
        if (yystate == yyfinal_)
          return true;

        /* Take a decision.  First try without lookahead.  */
        yyn = yypact_[yystate];
        if (yy_pact_value_is_default_ (yyn))
          {
            label = YYDEFAULT;
	    break;
          }

        /* Read a lookahead token.  */
        if (yychar == yyempty_)
          {
	    yycdebug ("Reading a token: ");
	    yychar = yylex ();
            
            yylval = yylexer.getLVal ();
          }

        /* Convert token to internal form.  */
        if (yychar <= EOF)
          {
	    yychar = yytoken = EOF;
	    yycdebug ("Now at end of input.\n");
          }
        else
          {
	    yytoken = yytranslate_ (yychar);
	    yy_symbol_print ("Next token is", yytoken,
			     yylval);
          }

        /* If the proper action on seeing token YYTOKEN is to reduce or to
           detect an error, take that action.  */
        yyn += yytoken;
        if (yyn < 0 || yylast_ < yyn || yycheck_[yyn] != yytoken)
          label = YYDEFAULT;

        /* <= 0 means reduce or error.  */
        else if ((yyn = yytable_[yyn]) <= 0)
          {
	    if (yy_table_value_is_error_ (yyn))
	      label = YYERRLAB;
	    else
	      {
	        yyn = -yyn;
	        label = YYREDUCE;
	      }
          }

        else
          {
            /* Shift the lookahead token.  */
	    yy_symbol_print ("Shifting", yytoken,
			     yylval);

            /* Discard the token being shifted.  */
            yychar = yyempty_;

            /* Count tokens shifted since error; after three, turn off error
               status.  */
            if (yyerrstatus_ > 0)
              --yyerrstatus_;

            yystate = yyn;
            yystack.push (yystate, yylval);
            label = YYNEWSTATE;
          }
        break;

      /*-----------------------------------------------------------.
      | yydefault -- do the default action for the current state.  |
      `-----------------------------------------------------------*/
      case YYDEFAULT:
        yyn = yydefact_[yystate];
        if (yyn == 0)
          label = YYERRLAB;
        else
          label = YYREDUCE;
        break;

      /*-----------------------------.
      | yyreduce -- Do a reduction.  |
      `-----------------------------*/
      case YYREDUCE:
        yylen = yyr2_[yyn];
        label = yyaction (yyn, yystack, yylen);
	yystate = yystack.stateAt (0);
        break;

      /*------------------------------------.
      | yyerrlab -- here on detecting error |
      `------------------------------------*/
      case YYERRLAB:
        /* If not already recovering from an error, report this error.  */
        if (yyerrstatus_ == 0)
          {
            ++yynerrs_;
            if (yychar == yyempty_)
              yytoken = yyempty_;
            yyerror (yysyntax_error (yystate, yytoken));
          }

        
        if (yyerrstatus_ == 3)
          {
	    /* If just tried and failed to reuse lookahead token after an
	     error, discard it.  */

	    if (yychar <= EOF)
	      {
	      /* Return failure if at end of input.  */
	      if (yychar == EOF)
	        return false;
	      }
	    else
	      yychar = yyempty_;
          }

        /* Else will try to reuse lookahead token after shifting the error
           token.  */
        label = YYERRLAB1;
        break;

      /*---------------------------------------------------.
      | errorlab -- error raised explicitly by YYERROR.  |
      `---------------------------------------------------*/
      case YYERROR:

        
        /* Do not reclaim the symbols of the rule which action triggered
           this YYERROR.  */
        yystack.pop (yylen);
        yylen = 0;
        yystate = yystack.stateAt (0);
        label = YYERRLAB1;
        break;

      /*-------------------------------------------------------------.
      | yyerrlab1 -- common code for both syntax error and YYERROR.  |
      `-------------------------------------------------------------*/
      case YYERRLAB1:
        yyerrstatus_ = 3;	/* Each real token shifted decrements this.  */

        for (;;)
          {
	    yyn = yypact_[yystate];
	    if (!yy_pact_value_is_default_ (yyn))
	      {
	        yyn += yyterror_;
	        if (0 <= yyn && yyn <= yylast_ && yycheck_[yyn] == yyterror_)
	          {
	            yyn = yytable_[yyn];
	            if (0 < yyn)
		      break;
	          }
	      }

	    /* Pop the current state because it cannot handle the error token.  */
	    if (yystack.height == 1)
	      return false;

	    
	    yystack.pop ();
	    yystate = yystack.stateAt (0);
	    if (yydebug > 0)
	      yystack.print (yyDebugStream);
          }

	

        /* Shift the error token.  */
        yy_symbol_print ("Shifting", yystos_[yyn],
			 yylval);

        yystate = yyn;
	yystack.push (yyn, yylval);
        label = YYNEWSTATE;
        break;

        /* Accept.  */
      case YYACCEPT:
        return true;

        /* Abort.  */
      case YYABORT:
        return false;
      }
  }

  // Generate an error message.
  private String yysyntax_error (int yystate, int tok)
  {
    if (errorVerbose)
      {
        /* There are many possibilities here to consider:
           - Assume YYFAIL is not used.  It's too flawed to consider.
             See
             <http://lists.gnu.org/archive/html/bison-patches/2009-12/msg00024.html>
             for details.  YYERROR is fine as it does not invoke this
             function.
           - If this state is a consistent state with a default action,
             then the only way this function was invoked is if the
             default action is an error action.  In that case, don't
             check for expected tokens because there are none.
           - The only way there can be no lookahead present (in tok) is
             if this state is a consistent state with a default action.
             Thus, detecting the absence of a lookahead is sufficient to
             determine that there is no unexpected or expected token to
             report.  In that case, just report a simple "syntax error".
           - Don't assume there isn't a lookahead just because this
             state is a consistent state with a default action.  There
             might have been a previous inconsistent state, consistent
             state with a non-default action, or user semantic action
             that manipulated yychar.  (However, yychar is currently out
             of scope during semantic actions.)
           - Of course, the expected token list depends on states to
             have correct lookahead information, and it depends on the
             parser not to perform extra reductions after fetching a
             lookahead from the scanner and before detecting a syntax
             error.  Thus, state merging (from LALR or IELR) and default
             reductions corrupt the expected token list.  However, the
             list is correct for canonical LR with one exception: it
             will still contain any token that will not be accepted due
             to an error action in a later state.
        */
        if (tok != yyempty_)
          {
            // FIXME: This method of building the message is not compatible
            // with internationalization.
            StringBuffer res =
              new StringBuffer ("syntax error, unexpected ");
            res.append (yytnamerr_ (yytname_[tok]));
            int yyn = yypact_[yystate];
            if (!yy_pact_value_is_default_ (yyn))
              {
                /* Start YYX at -YYN if negative to avoid negative
                   indexes in YYCHECK.  In other words, skip the first
                   -YYN actions for this state because they are default
                   actions.  */
                int yyxbegin = yyn < 0 ? -yyn : 0;
                /* Stay within bounds of both yycheck and yytname.  */
                int yychecklim = yylast_ - yyn + 1;
                int yyxend = yychecklim < yyntokens_ ? yychecklim : yyntokens_;
                int count = 0;
                for (int x = yyxbegin; x < yyxend; ++x)
                  if (yycheck_[x + yyn] == x && x != yyterror_
                      && !yy_table_value_is_error_ (yytable_[x + yyn]))
                    ++count;
                if (count < 5)
                  {
                    count = 0;
                    for (int x = yyxbegin; x < yyxend; ++x)
                      if (yycheck_[x + yyn] == x && x != yyterror_
                          && !yy_table_value_is_error_ (yytable_[x + yyn]))
                        {
                          res.append (count++ == 0 ? ", expecting " : " or ");
                          res.append (yytnamerr_ (yytname_[x]));
                        }
                  }
              }
            return res.toString ();
          }
      }

    return "syntax error";
  }

  /**
   * Whether the given <code>yypact_</code> value indicates a defaulted state.
   * @param yyvalue   the value to check
   */
  private static boolean yy_pact_value_is_default_ (int yyvalue)
  {
    return yyvalue == yypact_ninf_;
  }

  /**
   * Whether the given <code>yytable_</code> value indicates a syntax error.
   * @param yyvalue   the value to check
   */
  private static boolean yy_table_value_is_error_ (int yyvalue)
  {
    return yyvalue == yytable_ninf_;
  }

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
  private static final short yypact_ninf_ = -47;
  private static final short yypact_[] =
  {
       -30,    10,    29,   113,   -47,    36,   -47,   -47,   -47,   -47,
     -47,   247,   -47,    49,    40,   -47,    33,    24,    38,   -47,
      42,    61,    -3,   -47,    62,    38,   -47,   146,    67,    95,
     225,   -47,    38,   283,    49,   -47,     5,   -47,   -11,     9,
      46,    30,   -47,    68,   172,    99,   172,   239,    66,   -47,
     209,    76,   -47,   107,     0,   101,   101,   101,   198,   101,
     102,   115,   -47,   -47,   -47,   -47,    19,   -47,   -47,   -47,
     -47,     9,   103,    38,   100,   172,   172,    66,     8,   101,
     101,   101,   101,   101,   101,   172,    89,    90,   -47,   -47,
     -47,   -47,   114,   128,   105,    96,   -47,   -47,   127,   -47,
     169,   170,   -47,   172,   -47,   -47,   -47,   172,   -47,   -47,
     -47,   -47,   294,   154,   158,   161,   163,   -47,   -47,   190,
     173,   -47,   193,   -47,   -47,   136,   172,   -47,   -47,   -47,
     -47,   -47,   -47,   201,   101,   101,   217,   221,    25,    66,
     239,   -47,   -47,   -47,   204,    23,   -47,   -47,    19,   196,
     -47,   -47,   172,   200,   -47,   207,   206,   -47,   -47,   -47,
      43,   191,   208,   -47,   211,   232,   202,   -47,   192,   172,
     -47,   -47,   -47,   172,   -47,   -47,   240,   241,   239,    38,
      38,   220,   -47,   239,   229,   -47,   -47,   -47,   -47,   -47,
     -47,    38,   -47,   -47,   -47
  };

  /* YYDEFACT[S] -- default reduction number in state S.  Performed when
     YYTABLE doesn't specify something else to do.  Zero means the
     default is an error.  */
  private static final byte yydefact_[] =
  {
         0,     0,     0,     0,     1,     0,    13,    12,    11,    10,
       2,     0,     8,     0,     0,    29,     0,     0,     0,     7,
       0,    18,     0,    14,    16,     0,    28,     0,     0,     0,
       0,     4,     0,     0,     0,     9,     0,     5,     0,     0,
       0,     0,    36,     0,     0,     0,     0,     0,     0,    48,
       0,     0,     6,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    15,    67,    68,    69,     0,    70,    17,    24,
      32,     0,     0,     0,     0,     0,     0,     0,    62,     0,
       0,     0,     0,     0,     0,     0,     0,     0,    46,    59,
      60,    61,     0,     0,     0,     0,    33,    37,     0,    34,
       0,     0,    20,     0,    83,    82,    81,     0,    84,    80,
      79,    19,     0,     0,    27,     0,     0,     3,    49,     0,
      51,    53,     0,    38,    47,     0,     0,    72,    74,    76,
      75,    73,    71,     0,     0,     0,     0,     0,     0,     0,
       0,    35,    21,    22,     0,     0,    23,    25,     0,     0,
      30,    44,     0,     0,    66,     0,     0,    65,    78,    77,
       0,     0,     0,    50,     0,     0,     0,    41,    39,     0,
      26,    31,    52,     0,    64,    63,     0,     0,     0,     0,
       0,     0,    43,     0,     0,    45,    55,    54,    42,    56,
      58,     0,    40,    85,    57
  };

  /* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] =
  {
       -47,   -47,   -47,    -9,     6,   -47,   -47,   223,   -47,   -47,
     -47,   106,   248,     2,   -47,   -18,   -47,   -46,   135,   -47,
     -47,   -47,   -47,   -38,   -33,   -43,   -31,    -8
  };

  /* YYDEFGOTO[NTERM-NUM].  */
  private static final short
  yydefgoto_[] =
  {
        -1,     2,    17,    11,    12,    13,    22,    23,    24,    60,
      68,   113,    14,    15,    28,    49,    50,    51,   119,   120,
     161,   138,   166,   121,    89,    90,    91,   104
  };

  /* YYTABLE[YYPACT[STATE-NUM]].  What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule which
     number is the opposite.  If YYTABLE_NINF_, syntax error.  */
  private static final short yytable_ninf_ = -1;
  private static final short
  yytable_[] =
  {
        31,    94,    61,    69,    98,    95,    88,    37,    93,    63,
      64,    65,    70,     3,    52,   101,    26,    19,    38,    34,
     108,    72,    26,    63,    64,    65,     1,   102,    35,     4,
      71,    66,   125,   114,   124,    30,   126,   122,   123,    16,
       6,     7,     8,     9,    19,   169,   157,   133,   105,   106,
     109,   110,    21,   115,    74,   117,    67,    27,    75,    76,
       6,     7,     8,     9,    30,   144,   163,   164,   165,   145,
      67,   127,   128,   129,   130,   131,   132,    19,   176,   177,
      29,   146,    79,    80,    81,    82,    83,    84,   156,    33,
       5,    36,     5,    39,   168,    25,   167,    32,    40,    86,
      87,    73,    92,    78,    63,    64,    65,    99,    77,    55,
      56,    57,    58,    59,   172,   114,    79,    80,    81,    82,
      83,    84,   100,   118,    85,   103,   158,   159,   116,   111,
     112,   184,   188,    86,    87,   185,   134,   192,   135,    78,
      63,    64,    65,   136,   140,    55,    56,    57,    58,    59,
     139,    67,    79,    80,    81,    82,    83,    84,   141,   154,
      85,   189,   190,     5,     6,     7,     8,     9,    10,    86,
      87,   137,   142,   194,   143,    78,    63,    64,    65,   147,
     148,    55,    56,    57,    58,    59,   149,    67,    79,    80,
      81,    82,    83,    84,   150,   152,    85,     6,     7,     8,
       9,    78,    63,    64,    65,    86,    87,    55,    56,    57,
      58,    59,    41,   151,    79,    80,    81,    82,    83,    84,
     153,   160,   107,    67,   157,   162,   169,   171,    41,   173,
     174,    86,    87,   175,    96,    30,   181,   178,   179,   183,
      97,   180,    41,   182,   186,   187,    43,    44,    45,    67,
     191,    30,   193,    46,   170,    47,    42,    62,    48,    20,
     155,     0,    43,    44,    45,    30,     0,     0,     0,    46,
       0,    47,     0,     0,    48,     0,    43,    44,    45,     0,
       0,     0,     0,    46,     0,    47,    53,    54,    48,     0,
       0,     0,    55,    56,    57,    58,    59,     5,     6,     7,
       8,     9,    18,    55,    56,    57,    58,    59
  };

  /* YYCHECK.  */
  private static final short
  yycheck_[] =
  {
        18,    47,    33,    36,    50,    48,    44,    25,    46,     4,
       5,     6,    23,     3,    32,    15,    14,    11,    27,    22,
      58,    39,    20,     4,     5,     6,    56,    27,    31,     0,
      39,    26,    24,    66,    77,    26,    28,    75,    76,     3,
      51,    52,    53,    54,    38,    22,    23,    85,    56,    57,
      58,    59,     3,    71,    24,    73,    51,    24,    28,    29,
      51,    52,    53,    54,    26,   103,    41,    42,    43,   107,
      51,    79,    80,    81,    82,    83,    84,    71,    35,    36,
      56,   112,    16,    17,    18,    19,    20,    21,   126,    28,
      50,    29,    50,    26,   140,    55,   139,    55,     3,    33,
      34,    55,     3,     3,     4,     5,     6,    31,    40,     9,
      10,    11,    12,    13,   152,   148,    16,    17,    18,    19,
      20,    21,    15,    23,    24,    24,   134,   135,    25,    27,
      15,   169,   178,    33,    34,   173,    47,   183,    48,     3,
       4,     5,     6,    29,    48,     9,    10,    11,    12,    13,
      45,    51,    16,    17,    18,    19,    20,    21,    31,    23,
      24,   179,   180,    50,    51,    52,    53,    54,    55,    33,
      34,    43,     3,   191,     4,     3,     4,     5,     6,    25,
      22,     9,    10,    11,    12,    13,    25,    51,    16,    17,
      18,    19,    20,    21,    31,    22,    24,    51,    52,    53,
      54,     3,     4,     5,     6,    33,    34,     9,    10,    11,
      12,    13,     3,    23,    16,    17,    18,    19,    20,    21,
      27,     4,    24,    51,    23,     4,    22,    31,     3,    29,
      23,    33,    34,    27,    25,    26,     4,    46,    30,    47,
      31,    30,     3,    41,     4,     4,    37,    38,    39,    51,
      30,    26,    23,    44,   148,    46,    31,    34,    49,    11,
     125,    -1,    37,    38,    39,    26,    -1,    -1,    -1,    44,
      -1,    46,    -1,    -1,    49,    -1,    37,    38,    39,    -1,
      -1,    -1,    -1,    44,    -1,    46,     3,     4,    49,    -1,
      -1,    -1,     9,    10,    11,    12,    13,    50,    51,    52,
      53,    54,    55,     9,    10,    11,    12,    13
  };

  /* STOS_[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
  private static final byte
  yystos_[] =
  {
         0,    56,    61,     3,     0,    50,    51,    52,    53,    54,
      55,    63,    64,    65,    72,    73,     3,    62,    55,    64,
      72,     3,    66,    67,    68,    55,    73,    24,    74,    56,
      26,    75,    55,    28,    22,    31,    29,    75,    63,    26,
       3,     3,    31,    37,    38,    39,    44,    46,    49,    75,
      76,    77,    75,     3,     4,     9,    10,    11,    12,    13,
      69,    86,    67,     4,     5,     6,    26,    51,    70,    84,
      23,    63,    75,    55,    24,    28,    29,    40,     3,    16,
      17,    18,    19,    20,    21,    24,    33,    34,    83,    84,
      85,    86,     3,    83,    77,    85,    25,    31,    77,    31,
      15,    15,    27,    24,    87,    87,    87,    24,    83,    87,
      87,    27,    15,    71,    84,    75,    25,    75,    23,    78,
      79,    83,    83,    83,    85,    24,    28,    87,    87,    87,
      87,    87,    87,    83,    47,    48,    29,    43,    81,    45,
      48,    31,     3,     4,    83,    83,    86,    25,    22,    25,
      31,    23,    22,    27,    23,    78,    83,    23,    87,    87,
       4,    80,     4,    41,    42,    43,    82,    85,    77,    22,
      71,    31,    83,    29,    23,    27,    35,    36,    46,    30,
      30,     4,    41,    47,    83,    83,     4,     4,    77,    75,
      75,    30,    77,    23,    75
  };

  /* TOKEN_NUMBER_[YYLEX-NUM] -- Internal symbol number corresponding
     to YYLEX-NUM.  */
  private static final short
  yytoken_number_[] =
  {
         0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310,   311,   312,   313,   314
  };

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte
  yyr1_[] =
  {
         0,    60,    62,    61,    61,    61,    61,    63,    63,    64,
      65,    65,    65,    65,    66,    66,    67,    67,    68,    68,
      68,    69,    69,    69,    70,    70,    71,    71,    72,    72,
      73,    73,    74,    75,    76,    76,    76,    76,    77,    77,
      77,    77,    77,    77,    77,    77,    77,    77,    77,    77,
      77,    78,    79,    79,    80,    80,    81,    81,    82,    83,
      83,    83,    83,    83,    83,    83,    83,    84,    84,    84,
      84,    85,    85,    85,    85,    85,    85,    85,    85,    86,
      86,    86,    86,    86,    86,    87
  };

  /* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN.  */
  private static final byte
  yyr2_[] =
  {
         0,     2,     0,     8,     5,     5,     6,     2,     1,     3,
       1,     1,     1,     1,     1,     3,     1,     3,     1,     4,
       4,     3,     3,     3,     1,     3,     3,     1,     2,     1,
       7,     8,     3,     3,     2,     3,     1,     2,     3,     4,
       6,     4,     6,     5,     4,     6,     2,     3,     1,     3,
       4,     1,     3,     1,     3,     3,     4,     5,     3,     1,
       1,     1,     1,     4,     4,     3,     3,     1,     1,     1,
       1,     2,     2,     2,     2,     2,     2,     3,     3,     2,
       2,     2,     2,     2,     2,     5
  };

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] =
  {
    "$end", "error", "$undefined", "ID", "NUMCONST", "REALCONST",
  "CHARCONST", "BOOLCONST", "SHARP_KW", "MOD_KW", "DIV_KW", "MUL_KW",
  "SUB_KW", "ADD_KW", "SINGLE_QUOTE_KW", "DOT_KW", "LTE_KW", "GTE_KW",
  "NEQ_KW", "EQ_KW", "GT_KW", "LT_KW", "COMMA_KW", "CLOSEPARENTHESIS_KW",
  "OPENPARENTHESIS_KW", "CLOSEACCOLADE_KW", "OPENACCOLADE_KW",
  "CLOSEBRACKET_KW", "OPENBRACKET_KW", "ASSIGN_KW", "COLON_KW",
  "SEMICOLON_KW", "NOT_KW", "OR_KW", "AND_KW", "DOWNTO_KW", "UPTO_KW",
  "EXIT_KW", "RETURN_KW", "FOR_KW", "WHEN_KW", "END_KW", "DEFAULT_KW",
  "CASE_KW", "SWITCH_KW", "WHILE_KW", "DO_KW", "ELSE_KW", "THEN_KW",
  "IF_KW", "PROCEDURE_KW", "BOOLEAN_KW", "CHARACTER_KW", "REAL_KW",
  "INTEGER_KW", "MAIN_KW", "PROGRAM_KW", "DIGIT", "NONZERO_DIGIT",
  "LETTER", "$accept", "program", "$@1", "declarations_list",
  "declarations", "type_specifiers", "declarator_list", "declarator",
  "dec", "range", "initializer", "initializer_list", "procedure_list",
  "procedure", "parameters", "block", "statement_list", "statement",
  "arguments_list", "multi_arguments", "counter", "case_element",
  "default", "expressions", "constant_expressions", "bool_expressions",
  "arithmetic_expressions", "pair", null
  };

  /* YYRHS -- A `-1'-separated list of the rules' RHS.  */
  private static final byte yyrhs_[] =
  {
        61,     0,    -1,    -1,    56,     3,    55,    62,    56,     3,
      55,    75,    -1,    56,     3,    63,    55,    75,    -1,    56,
       3,    72,    55,    75,    -1,    56,     3,    63,    72,    55,
      75,    -1,    63,    64,    -1,    64,    -1,    65,    66,    31,
      -1,    54,    -1,    53,    -1,    52,    -1,    51,    -1,    67,
      -1,    66,    22,    67,    -1,    68,    -1,    68,    29,    70,
      -1,     3,    -1,     3,    28,    69,    27,    -1,     3,    28,
       4,    27,    -1,     3,    15,     3,    -1,     4,    15,     4,
      -1,    86,    15,    86,    -1,    84,    -1,    26,    71,    25,
      -1,    84,    22,    71,    -1,    84,    -1,    72,    73,    -1,
      73,    -1,    50,     3,    74,    26,    75,    25,    31,    -1,
      50,     3,    74,    26,    63,    75,    25,    31,    -1,    24,
      63,    23,    -1,    26,    76,    25,    -1,    77,    31,    -1,
      76,    77,    31,    -1,    31,    -1,    76,    31,    -1,     3,
      29,    83,    -1,    49,    85,    48,    77,    -1,    49,    85,
      48,    77,    47,    77,    -1,    46,    77,    45,    85,    -1,
      39,     3,    29,    80,    46,    77,    -1,    44,    83,    81,
      82,    41,    -1,     3,    24,    78,    23,    -1,     3,    28,
      83,    27,    29,    83,    -1,    38,    83,    -1,    37,    40,
      85,    -1,    75,    -1,     3,    24,    23,    -1,    44,    83,
      81,    41,    -1,    79,    -1,    79,    22,    83,    -1,    83,
      -1,     4,    36,     4,    -1,     4,    35,     4,    -1,    43,
       4,    30,    75,    -1,    81,    43,     4,    30,    75,    -1,
      42,    30,    75,    -1,    84,    -1,    85,    -1,    86,    -1,
       3,    -1,     3,    28,    83,    27,    -1,     3,    24,    78,
      23,    -1,    24,    83,    23,    -1,     3,    24,    23,    -1,
       4,    -1,     5,    -1,     6,    -1,    51,    -1,    21,    87,
      -1,    16,    87,    -1,    20,    87,    -1,    17,    87,    -1,
      19,    87,    -1,    18,    87,    -1,    34,    48,    87,    -1,
      33,    47,    87,    -1,    13,    87,    -1,    12,    87,    -1,
      11,    87,    -1,    10,    87,    -1,     9,    87,    -1,    12,
      83,    -1,    24,    83,    22,    83,    23,    -1
  };

  /* YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in
     YYRHS.  */
  private static final short yyprhs_[] =
  {
         0,     0,     3,     4,    13,    19,    25,    32,    35,    37,
      41,    43,    45,    47,    49,    51,    55,    57,    61,    63,
      68,    73,    77,    81,    85,    87,    91,    95,    97,   100,
     102,   110,   119,   123,   127,   130,   134,   136,   139,   143,
     148,   155,   160,   167,   173,   178,   185,   188,   192,   194,
     198,   203,   205,   209,   211,   215,   219,   224,   230,   234,
     236,   238,   240,   242,   247,   252,   256,   260,   262,   264,
     266,   268,   271,   274,   277,   280,   283,   286,   290,   294,
     297,   300,   303,   306,   309,   312
  };

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] =
  {
         0,    55,    55,    55,    63,    67,    71,    77,    82,    89,
      97,   101,   105,   109,   115,   119,   127,   131,   138,   142,
     146,   154,   158,   162,   168,   172,   180,   184,   190,   194,
     200,   204,   210,   216,   222,   226,   230,   234,   240,   244,
     248,   252,   256,   260,   264,   268,   272,   276,   280,   284,
     288,   294,   300,   304,   310,   314,   320,   324,   330,   336,
     340,   344,   348,   352,   356,   360,   364,   370,   374,   378,
     382,   388,   392,   396,   400,   404,   408,   412,   416,   422,
     426,   430,   434,   438,   442,   448
  };

  // Report on the debug stream that the rule yyrule is going to be reduced.
  private void yy_reduce_print (int yyrule, YYStack yystack)
  {
    if (yydebug == 0)
      return;

    int yylno = yyrline_[yyrule];
    int yynrhs = yyr2_[yyrule];
    /* Print the symbols being reduced, and their result.  */
    yycdebug ("Reducing stack by rule " + (yyrule - 1)
	      + " (line " + yylno + "), ");

    /* The symbols being reduced.  */
    for (int yyi = 0; yyi < yynrhs; yyi++)
      yy_symbol_print ("   $" + (yyi + 1) + " =",
		       yyrhs_[yyprhs_[yyrule] + yyi],
		       ((yystack.valueAt (yynrhs-(yyi + 1)))));
  }

  /* YYTRANSLATE(YYLEX) -- Bison symbol number corresponding to YYLEX.  */
  private static final byte yytranslate_table_[] =
  {
         0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59
  };

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 307;
  private static final int yynnts_ = 28;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 4;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 60;

  private static final int yyuser_token_number_max_ = 314;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */
/* Unqualified %code blocks.  */

/* Line 927 of lalr1.java  */
/* Line 9 of "YYParser.y"  */

    static PrintStream writer;

    public static void main(String args[]) throws IOException, FileNotFoundException {
        YYParser yyparser;
        final Yylex lexer;

        writer = new PrintStream(new File("yacc_tool_output.txt"));
        lexer = new Yylex(new InputStreamReader(new FileInputStream(".\\Global_Test\\globalTest2.shl")));

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
                return null;
            }
        });
        yyparser.parse();

        return;
    }



/* Line 927 of lalr1.java  */
/* Line 2237 of "YYParser.java"  */

}


