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
  public static final int DOUBLE_DOT_KW = 258;
  /** Token number, to be returned by the scanner.  */
  public static final int SHARP_KW = 259;
  /** Token number, to be returned by the scanner.  */
  public static final int MOD_KW = 260;
  /** Token number, to be returned by the scanner.  */
  public static final int DIV_KW = 261;
  /** Token number, to be returned by the scanner.  */
  public static final int MUL_KW = 262;
  /** Token number, to be returned by the scanner.  */
  public static final int SUB_KW = 263;
  /** Token number, to be returned by the scanner.  */
  public static final int ADD_KW = 264;
  /** Token number, to be returned by the scanner.  */
  public static final int SINGLE_QUOTE_KW = 265;
  /** Token number, to be returned by the scanner.  */
  public static final int DOT_KW = 266;
  /** Token number, to be returned by the scanner.  */
  public static final int LTE_KW = 267;
  /** Token number, to be returned by the scanner.  */
  public static final int GTE_KW = 268;
  /** Token number, to be returned by the scanner.  */
  public static final int NEQ_KW = 269;
  /** Token number, to be returned by the scanner.  */
  public static final int EQ_KW = 270;
  /** Token number, to be returned by the scanner.  */
  public static final int GT_KW = 271;
  /** Token number, to be returned by the scanner.  */
  public static final int LT_KW = 272;
  /** Token number, to be returned by the scanner.  */
  public static final int COMMA_KW = 273;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEPARENTHESIS_KW = 274;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENPARENTHESIS_KW = 275;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEACCOLADE_KW = 276;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENACCOLADE_KW = 277;
  /** Token number, to be returned by the scanner.  */
  public static final int CLOSEBRACKET_KW = 278;
  /** Token number, to be returned by the scanner.  */
  public static final int OPENBRACKET_KW = 279;
  /** Token number, to be returned by the scanner.  */
  public static final int ASSIGN_KW = 280;
  /** Token number, to be returned by the scanner.  */
  public static final int COLON_KW = 281;
  /** Token number, to be returned by the scanner.  */
  public static final int SEMICOLON_KW = 282;
  /** Token number, to be returned by the scanner.  */
  public static final int NOT_KW = 283;
  /** Token number, to be returned by the scanner.  */
  public static final int OR_KW = 284;
  /** Token number, to be returned by the scanner.  */
  public static final int AND_KW = 285;
  /** Token number, to be returned by the scanner.  */
  public static final int DOWNTO_KW = 286;
  /** Token number, to be returned by the scanner.  */
  public static final int UPTO_KW = 287;
  /** Token number, to be returned by the scanner.  */
  public static final int EXIT_KW = 288;
  /** Token number, to be returned by the scanner.  */
  public static final int RETURN_KW = 289;
  /** Token number, to be returned by the scanner.  */
  public static final int FOR_KW = 290;
  /** Token number, to be returned by the scanner.  */
  public static final int WHEN_KW = 291;
  /** Token number, to be returned by the scanner.  */
  public static final int END_KW = 292;
  /** Token number, to be returned by the scanner.  */
  public static final int DEFAULT_KW = 293;
  /** Token number, to be returned by the scanner.  */
  public static final int CASE_KW = 294;
  /** Token number, to be returned by the scanner.  */
  public static final int SWITCH_KW = 295;
  /** Token number, to be returned by the scanner.  */
  public static final int WHILE_KW = 296;
  /** Token number, to be returned by the scanner.  */
  public static final int DO_KW = 297;
  /** Token number, to be returned by the scanner.  */
  public static final int ELSE_KW = 298;
  /** Token number, to be returned by the scanner.  */
  public static final int THEN_KW = 299;
  /** Token number, to be returned by the scanner.  */
  public static final int IF_KW = 300;
  /** Token number, to be returned by the scanner.  */
  public static final int PROCEDURE_KW = 301;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOLEAN_KW = 302;
  /** Token number, to be returned by the scanner.  */
  public static final int CHARACTER_KW = 303;
  /** Token number, to be returned by the scanner.  */
  public static final int REAL_KW = 304;
  /** Token number, to be returned by the scanner.  */
  public static final int INTEGER_KW = 305;
  /** Token number, to be returned by the scanner.  */
  public static final int MAIN_KW = 306;
  /** Token number, to be returned by the scanner.  */
  public static final int PROGRAM_KW = 307;
  /** Token number, to be returned by the scanner.  */
  public static final int DIGIT = 308;
  /** Token number, to be returned by the scanner.  */
  public static final int NONZERO_DIGIT = 309;
  /** Token number, to be returned by the scanner.  */
  public static final int LETTER = 310;
  /** Token number, to be returned by the scanner.  */
  public static final int ID = 311;
  /** Token number, to be returned by the scanner.  */
  public static final int NUMCONSTANT = 312;
  /** Token number, to be returned by the scanner.  */
  public static final int REALCONST = 313;
  /** Token number, to be returned by the scanner.  */
  public static final int CHARCONST = 314;
  /** Token number, to be returned by the scanner.  */
  public static final int BOOLCONST = 315;
  /** Token number, to be returned by the scanner.  */
  public static final int usub = 316;



  

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
/* Line 189 of "YYParser.y"  */
    {
		System.out.println("Rule 1.2: " +
			"program -> PROGRAM_KW saved_id MAIN_KW block");
		backpatch(((Eval)(yystack.valueAt (4-(4)))).nextList, nextQuad());
      	exportIntermediateCode();
	};
  break;
    

  case 3:
  if (yyn == 3)
    
/* Line 351 of lalr1.java  */
/* Line 195 of "YYParser.y"  */
    {
		System.out.println("Rule 1.3: " +
			"program -> PROGRAM_KW saved_id declarations_list MAIN_KW block");
		backpatch(((Eval)(yystack.valueAt (5-(5)))).nextList, nextQuad());
      	exportIntermediateCode();
	};
  break;
    

  case 4:
  if (yyn == 4)
    
/* Line 351 of lalr1.java  */
/* Line 201 of "YYParser.y"  */
    {
		System.out.println("Rule 1.4: " +
			"program -> PROGRAM_KW saved_id procedure_list MAIN_KW block");
		backpatch(((Eval)(yystack.valueAt (5-(5)))).nextList, nextQuad());
      	exportIntermediateCode();
	};
  break;
    

  case 5:
  if (yyn == 5)
    
/* Line 351 of lalr1.java  */
/* Line 207 of "YYParser.y"  */
    {
		System.out.println("Rule 1.5: " +
			"program -> PROGRAM_KW saved_id declarations_list procedure_list MAIN_KW block");

		backpatch(((Eval)(yystack.valueAt (6-(6)))).nextList, nextQuad());
      	exportIntermediateCode();
	};
  break;
    

  case 6:
  if (yyn == 6)
    
/* Line 351 of lalr1.java  */
/* Line 214 of "YYParser.y"  */
    {
		System.out.println("Rule 1.1: " +
			"program -> PROGRAM_KW saved_id MAIN_KW");
		exportIntermediateCode();
	};
  break;
    

  case 7:
  if (yyn == 7)
    
/* Line 351 of lalr1.java  */
/* Line 221 of "YYParser.y"  */
    {
		System.out.println("Rule 2 :  declarations_list -> declarations ") ;
	};
  break;
    

  case 8:
  if (yyn == 8)
    
/* Line 351 of lalr1.java  */
/* Line 224 of "YYParser.y"  */
    {
		System.out.println("Rule 3 :  declarations_list ->  declarations_list declarations") ;
	};
  break;
    

  case 9:
  if (yyn == 9)
    
/* Line 351 of lalr1.java  */
/* Line 228 of "YYParser.y"  */
    {
		System.out.println("Rule 4.1 :  declarations ->  type_specifieirs declarator_list") ;
		if(((Eval)(yystack.valueAt (3-(2)))).type == Eval.TYPECODES.UNKNOWN.getType() || ((Eval)(yystack.valueAt (3-(1)))).type == ((Eval)(yystack.valueAt (3-(2)))).type) {
			for(int i = 0; i < ((Eval)(yystack.valueAt (3-(2)))).initializersList.size(); i++) {
				if(symbolTable.lookUp(sizeStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place) == SymbolTable.NOT_IN_SYMBOL_TABLE) {
					symbolTable.setSymbol(((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, ((Eval)(yystack.valueAt (3-(1)))).type, false);
					if(((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i) != null && ((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i).size() == 1) {
						emit(":=", ((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i).get(0).place, null, ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
						switch (((Eval)(yystack.valueAt (3-(1)))).type) {
							case 0://Eval.TYPECODES.INTEGER.getType():
								emit("iprint", null, null, ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
								break;
							case 1://Eval.TYPECODES.REAL.getType():
								emit("rprint", null, null, ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
								break;
							case 2://Eval.TYPECODES.CHAR.getType():
								emit("cprint", null, null, ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
								break;
						}
					} else if(((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i) != null) {
						System.err.println("Error! Initializer number mismatch. (Expected: 1" + ", Number: " + ((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i).size() + ")");
						return YYABORT;
					}
				} else {
					symbolTable.setSymbol(((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, ((Eval)(yystack.valueAt (3-(1)))).type, true);
					emit("malloc", getTypeString(((Eval)(yystack.valueAt (3-(1)))).type), sizeStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
					if(((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i) != null) {
						for(int j = 0; j < ((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i).size(); j++) {
							Eval.arrayIndexOutOfBoundList.add(nextQuad() + 1);
							emit(">=", String.valueOf(j), sizeStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
							emit("check", condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, null, String.valueOf(nextQuad() + 2)); // Result will be backpatched.
							emit("[]=", ((Eval)(yystack.valueAt (3-(2)))).initializersList.get(i).get(j).place, String.valueOf(j), ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
							emit("+", startStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, String.valueOf(j), condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
							switch (((Eval)(yystack.valueAt (3-(1)))).type) {
								case 0://Eval.TYPECODES.INTEGER.getType():
									emit("aiprint", condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, String.valueOf(j), ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
									break;
								case 1://Eval.TYPECODES.REAL.getType():
									emit("arprint", condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, String.valueOf(j), ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
									break;
								case 2://Eval.TYPECODES.CHAR.getType():
									emit("acprint", condStr + ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place, String.valueOf(j), ((Eval)(yystack.valueAt (3-(2)))).declareds.get(i).place);
									break;
							}
						}
					}
				}
			}
		} else {
			System.err.println("Error! Type specifier type mismatch. (" + ((Eval)(yystack.valueAt (3-(1)))).type + ", " + ((Eval)(yystack.valueAt (3-(2)))).type + ")");
			return YYABORT;
		}
	};
  break;
    

  case 10:
  if (yyn == 10)
    
/* Line 351 of lalr1.java  */
/* Line 282 of "YYParser.y"  */
    {
		System.out.println("Rule 5 :  type_specifieirs ->  INTEGER_KW") ;
		yyval = new Eval();
      	((Eval)yyval).type = Eval.TYPECODES.INTEGER.getType();
	};
  break;
    

  case 11:
  if (yyn == 11)
    
/* Line 351 of lalr1.java  */
/* Line 287 of "YYParser.y"  */
    {
		System.out.println("Rule 6 :  type_specifieirs ->  REAL_KW") ;
		yyval = new Eval();
      	((Eval)yyval).type = Eval.TYPECODES.REAL.getType();
	};
  break;
    

  case 12:
  if (yyn == 12)
    
/* Line 351 of lalr1.java  */
/* Line 292 of "YYParser.y"  */
    {
		System.out.println("Rule 7 :  type_specifieirs ->  CHARACTER_KW") ;
		yyval = new Eval();
      	((Eval)yyval).type = Eval.TYPECODES.CHAR.getType();
	};
  break;
    

  case 13:
  if (yyn == 13)
    
/* Line 351 of lalr1.java  */
/* Line 297 of "YYParser.y"  */
    {
		System.out.println("Rule 8 :  type_specifieirs ->  BOOLEAN_KW") ;
		yyval = new Eval();
      	((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
	};
  break;
    

  case 14:
  if (yyn == 14)
    
/* Line 351 of lalr1.java  */
/* Line 303 of "YYParser.y"  */
    {
		System.out.println("Rule 9 :  declarator_list ->  declarator") ;
		yyval = new Eval();
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).declareds = Eval.makeInitializersOrDeclareds(((Eval)(yystack.valueAt (1-(1)))));
		((Eval)yyval).initializersList = Eval.makeInitializersList(((Eval)(yystack.valueAt (1-(1)))).initializers);
	};
  break;
    

  case 15:
  if (yyn == 15)
    
/* Line 351 of lalr1.java  */
/* Line 310 of "YYParser.y"  */
    {
		System.out.println("Rule 10 :  type_specifieirs ->  declarator_list ->  declarator_list,declarator") ;
		if(((Eval)(yystack.valueAt (3-(1)))).type == Eval.TYPECODES.UNKNOWN.getType()
			|| ((Eval)(yystack.valueAt (3-(1)))).type == ((Eval)(yystack.valueAt (3-(3)))).type) {
			yyval = new Eval();
			((Eval)yyval).type = ((Eval)(yystack.valueAt (3-(3)))).type;
			((Eval)yyval).declareds = ((Eval)(yystack.valueAt (3-(1)))).declareds;
			((Eval)yyval).declareds.add(((Eval)(yystack.valueAt (3-(3)))));
			((Eval)yyval).initializersList = ((Eval)(yystack.valueAt (3-(1)))).initializersList;
			((Eval)yyval).initializersList.add(((Eval)(yystack.valueAt (3-(3)))).initializers);
		} else {
			System.err.println("Error! Declarator type mismatch.");
			return YYABORT;
		}
	};
  break;
    

  case 16:
  if (yyn == 16)
    
/* Line 351 of lalr1.java  */
/* Line 326 of "YYParser.y"  */
    {
		System.out.println("Rule 11 :  declarator -> dec") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = Eval.TYPECODES.UNKNOWN.getType();
		((Eval)yyval).array = ((Eval)(yystack.valueAt (1-(1)))).array;
		((Eval)yyval).initializers = null;
	};
  break;
    

  case 17:
  if (yyn == 17)
    
/* Line 351 of lalr1.java  */
/* Line 334 of "YYParser.y"  */
    {
		System.out.println("Rule 12 :  declarator -> dec := initializer") ;
		if(((Eval)(yystack.valueAt (3-(1)))).array != ((Eval)(yystack.valueAt (3-(3)))).array) {
			System.err.println("Error! Array mismatch: " + ((Eval)(yystack.valueAt (3-(1)))).place + " and " + ((Eval)(yystack.valueAt (3-(3)))).place + " are not the same.");
			return YYABORT;
		}
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (3-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (3-(3)))).type;
		((Eval)yyval).array = ((Eval)(yystack.valueAt (3-(1)))).array;
		((Eval)yyval).initializers = ((Eval)(yystack.valueAt (3-(3)))).initializers;
	};
  break;
    

  case 18:
  if (yyn == 18)
    
/* Line 351 of lalr1.java  */
/* Line 347 of "YYParser.y"  */
    {
		System.out.println("Rule 13 :  dec -> saved_id ") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).array = false;
	};
  break;
    

  case 19:
  if (yyn == 19)
    
/* Line 351 of lalr1.java  */
/* Line 353 of "YYParser.y"  */
    {
		System.out.println("Rule 14 :  dec -> saved_id[range] ") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (4-(1)))).place;
		((Eval)yyval).array = true;

		symbolTable.setSymbol(startStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", startStr + ((Eval)(yystack.valueAt (4-(3)))).place, null , startStr + ((Eval)yyval).place);

		symbolTable.setSymbol(sizeStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", sizeStr + ((Eval)(yystack.valueAt (4-(3)))).place, null , sizeStr + ((Eval)yyval).place);

		symbolTable.setSymbol(indexStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		symbolTable.setSymbol(condStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
	};
  break;
    

  case 20:
  if (yyn == 20)
    
/* Line 351 of lalr1.java  */
/* Line 368 of "YYParser.y"  */
    {
		System.out.println("Rule 15 :  dec -> saved_id[saved_integer] ") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (4-(1)))).place;
		((Eval)yyval).array = true;

		symbolTable.setSymbol(startStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", "0", null , startStr + ((Eval)yyval).place);

		symbolTable.setSymbol(sizeStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		emit(":=", ((Eval)(yystack.valueAt (4-(3)))).place, null , sizeStr + ((Eval)yyval).place);

		symbolTable.setSymbol(indexStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
		symbolTable.setSymbol(condStr + ((Eval)yyval).place, Eval.TYPECODES.INTEGER.getType(), false);
	};
  break;
    

  case 21:
  if (yyn == 21)
    
/* Line 351 of lalr1.java  */
/* Line 384 of "YYParser.y"  */
    {
		System.out.println("Rule 16 :  range -> saved_id .. saved_id ") ;
	};
  break;
    

  case 22:
  if (yyn == 22)
    
/* Line 351 of lalr1.java  */
/* Line 387 of "YYParser.y"  */
    {
		System.out.println("Rule 17 :  range -> saved_integer .. saved_integer ") ;
	};
  break;
    

  case 23:
  if (yyn == 23)
    
/* Line 351 of lalr1.java  */
/* Line 390 of "YYParser.y"  */
    {
		System.out.println("Rule 18 : range -> arithmetic_expressions .. arithmetic_expressions") ;
	};
  break;
    

  case 24:
  if (yyn == 24)
    
/* Line 351 of lalr1.java  */
/* Line 394 of "YYParser.y"  */
    {
		System.out.println("Rule 19 :  initializer -> constant_expressions ") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
		((Eval)yyval).initializers.add(((Eval)(yystack.valueAt (1-(1)))));
	};
  break;
    

  case 25:
  if (yyn == 25)
    
/* Line 351 of lalr1.java  */
/* Line 402 of "YYParser.y"  */
    {
		System.out.println("Rule 19 :  initializer -> {initializer_list} ") ;
		yyval = new Eval();
		((Eval)yyval).type = ((Eval)(yystack.valueAt (3-(2)))).type;
		((Eval)yyval).array = ((Eval)(yystack.valueAt (3-(2)))).array;
		((Eval)yyval).initializers = ((Eval)(yystack.valueAt (3-(2)))).initializers;
	};
  break;
    

  case 26:
  if (yyn == 26)
    
/* Line 351 of lalr1.java  */
/* Line 410 of "YYParser.y"  */
    {
		System.out.println("Rule 20 :  initializer_list -> constant_expressions, initializer_list ") ;
		if(((Eval)(yystack.valueAt (3-(1)))).type == ((Eval)(yystack.valueAt (3-(3)))).type) {
			yyval = new Eval();
			((Eval)yyval).type = ((Eval)(yystack.valueAt (3-(1)))).type;
			((Eval)yyval).array = true;
			((Eval)yyval).initializers = ((Eval)(yystack.valueAt (3-(3)))).initializers;
			((Eval)yyval).initializers.add(((Eval)(yystack.valueAt (3-(1)))));
		} else {
			System.err.println("Error! Initializer type mismatch.");
			return YYABORT;
		}
	};
  break;
    

  case 27:
  if (yyn == 27)
    
/* Line 351 of lalr1.java  */
/* Line 423 of "YYParser.y"  */
    {
		System.out.println("Rule 21 :  initializer_list -> constant_expressions ") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
		((Eval)yyval).initializers.add(((Eval)(yystack.valueAt (1-(1)))));
	};
  break;
    

  case 28:
  if (yyn == 28)
    
/* Line 351 of lalr1.java  */
/* Line 432 of "YYParser.y"  */
    {
		System.out.println("Rule 22.1 : procedure_list -> procedure_list procedure") ;
	};
  break;
    

  case 29:
  if (yyn == 29)
    
/* Line 351 of lalr1.java  */
/* Line 435 of "YYParser.y"  */
    {
		System.out.println("Rule 22.2 : procedure_list -> procedure") ;
	};
  break;
    

  case 30:
  if (yyn == 30)
    
/* Line 351 of lalr1.java  */
/* Line 439 of "YYParser.y"  */
    {
		System.out.println("Rule 23 :  procedure -> PROCEDURE_KW saved_id parameters {declarations_list block} ") ;
	};
  break;
    

  case 31:
  if (yyn == 31)
    
/* Line 351 of lalr1.java  */
/* Line 443 of "YYParser.y"  */
    {
		System.out.println("Rule 24 :  parameters -> ( declarations_list ) ") ;
	};
  break;
    

  case 32:
  if (yyn == 32)
    
/* Line 351 of lalr1.java  */
/* Line 447 of "YYParser.y"  */
    {
		System.out.println("Rule 25 :  block -> {statment_list} ") ;
		yyval = new Eval();
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (3-(2)))).nextList;
	};
  break;
    

  case 33:
  if (yyn == 33)
    
/* Line 351 of lalr1.java  */
/* Line 452 of "YYParser.y"  */
    {
		yyval = new Eval();
		((Eval)yyval).nextList = Eval.makeList(nextQuad());
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	};
  break;
    

  case 34:
  if (yyn == 34)
    
/* Line 351 of lalr1.java  */
/* Line 458 of "YYParser.y"  */
    {
		System.out.println("Rule 26 :  statment_list -> statment ") ;
	};
  break;
    

  case 35:
  if (yyn == 35)
    
/* Line 351 of lalr1.java  */
/* Line 461 of "YYParser.y"  */
    {
		System.out.println("Rule 27 :  statment_list -> statment_list statment; ") ;
	};
  break;
    

  case 36:
  if (yyn == 36)
    
/* Line 351 of lalr1.java  */
/* Line 465 of "YYParser.y"  */
    {
		System.out.println("Rule 28 :  statment -> saved_id := expressions ") ;
	};
  break;
    

  case 37:
  if (yyn == 37)
    
/* Line 351 of lalr1.java  */
/* Line 468 of "YYParser.y"  */
    {
		System.out.println("Rule 29 :  statment -> IF bool_expression THEN statment ELSE_KW statment") ;
	};
  break;
    

  case 38:
  if (yyn == 38)
    
/* Line 351 of lalr1.java  */
/* Line 471 of "YYParser.y"  */
    {
		System.out.println("Rule 29 :  statment -> IF bool_expression THEN statment ") ;
	};
  break;
    

  case 39:
  if (yyn == 39)
    
/* Line 351 of lalr1.java  */
/* Line 474 of "YYParser.y"  */
    {
		System.out.println("Rule 30 :  statment -> DO statment WHILE bool_expression ") ;
	};
  break;
    

  case 40:
  if (yyn == 40)
    
/* Line 351 of lalr1.java  */
/* Line 477 of "YYParser.y"  */
    {
		System.out.println("Rule 31 :  statment -> FOR saved_id := counter DO statment ") ;
	};
  break;
    

  case 41:
  if (yyn == 41)
    
/* Line 351 of lalr1.java  */
/* Line 480 of "YYParser.y"  */
    {
		System.out.println("Rule 31.1 :  statment -> SWITCH_KW expressions case_element default END_KW ") ;
	};
  break;
    

  case 42:
  if (yyn == 42)
    
/* Line 351 of lalr1.java  */
/* Line 483 of "YYParser.y"  */
    {
		System.out.println("Rule 32 :  statment ->  saved_id (arguments_list)") ;
	};
  break;
    

  case 43:
  if (yyn == 43)
    
/* Line 351 of lalr1.java  */
/* Line 486 of "YYParser.y"  */
    {
		System.out.println("Rule 33 :  statment ->  saved_id [ expressions ] := expressions") ;
	};
  break;
    

  case 44:
  if (yyn == 44)
    
/* Line 351 of lalr1.java  */
/* Line 489 of "YYParser.y"  */
    {
		System.out.println("Rule 34 :  statment -> RETURN expressions ") ;
	};
  break;
    

  case 45:
  if (yyn == 45)
    
/* Line 351 of lalr1.java  */
/* Line 492 of "YYParser.y"  */
    {
		System.out.println("Rule 35 :  statment ->  EXIT WHEN_KW bool_expression") ;
	};
  break;
    

  case 46:
  if (yyn == 46)
    
/* Line 351 of lalr1.java  */
/* Line 495 of "YYParser.y"  */
    {
		System.out.println("Rule 36.1 :  statment ->  block") ;
	};
  break;
    

  case 47:
  if (yyn == 47)
    
/* Line 351 of lalr1.java  */
/* Line 500 of "YYParser.y"  */
    {
		System.out.println("Rule 37 :  arguments_list -> multi_arguments") ;
	};
  break;
    

  case 48:
  if (yyn == 48)
    
/* Line 351 of lalr1.java  */
/* Line 505 of "YYParser.y"  */
    {
		System.out.println("Rule 39 :  multi_arguments -> multi_arguments,expressions") ;
	};
  break;
    

  case 49:
  if (yyn == 49)
    
/* Line 351 of lalr1.java  */
/* Line 508 of "YYParser.y"  */
    {
		System.out.println("Rule 40 :  multi_arguments -> expressions") ;
	};
  break;
    

  case 50:
  if (yyn == 50)
    
/* Line 351 of lalr1.java  */
/* Line 512 of "YYParser.y"  */
    {
		System.out.println("Rule 41 :  counter -> saved_integer UPTO_KW saved_integer") ;
	};
  break;
    

  case 51:
  if (yyn == 51)
    
/* Line 351 of lalr1.java  */
/* Line 515 of "YYParser.y"  */
    {
		System.out.println("Rule 42 :  counter -> saved_integer DOWNTO_KW saved_integer") ;
	};
  break;
    

  case 52:
  if (yyn == 52)
    
/* Line 351 of lalr1.java  */
/* Line 519 of "YYParser.y"  */
    {
		System.out.println("Rule 43 :  case_element -> CASE_KW saved_integer : block") ;
	};
  break;
    

  case 53:
  if (yyn == 53)
    
/* Line 351 of lalr1.java  */
/* Line 522 of "YYParser.y"  */
    {
		System.out.println("Rule 44 :  case_element -> case_element CASE_KW saved_integer : block") ;
	};
  break;
    

  case 54:
  if (yyn == 54)
    
/* Line 351 of lalr1.java  */
/* Line 526 of "YYParser.y"  */
    {
		System.out.println("Rule 45 :  default -> DEFAULT_KW ':' block") ;
	};
  break;
    

  case 55:
  if (yyn == 55)
    
/* Line 351 of lalr1.java  */
/* Line 531 of "YYParser.y"  */
    {
		System.out.println("Rule 47 :  expressions -> constant_expressions") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
	};
  break;
    

  case 56:
  if (yyn == 56)
    
/* Line 351 of lalr1.java  */
/* Line 540 of "YYParser.y"  */
    {
		System.out.println("Rule 48 :  expressions -> bool_expression") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
	};
  break;
    

  case 57:
  if (yyn == 57)
    
/* Line 351 of lalr1.java  */
/* Line 549 of "YYParser.y"  */
    {
		System.out.println("Rule 49 :  expressions -> arithmetic_expressions") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
	};
  break;
    

  case 58:
  if (yyn == 58)
    
/* Line 351 of lalr1.java  */
/* Line 558 of "YYParser.y"  */
    {
		System.out.println("Rule 51 :  expressions -> saved_id [expressions]") ;
		int index = symbolTable.lookUp(((Eval)(yystack.valueAt (4-(1)))).place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (!symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not an array, it can not be used with index.");
			return YYABORT;
		}
		yyval = new Eval();
		((Eval)yyval).place = newTemp(symbolTable.types.get(index), false);
		((Eval)yyval).type = symbolTable.types.get(index);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 2);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 4);
		emit("-", ((Eval)(yystack.valueAt (4-(3)))).place, startStr + ((Eval)(yystack.valueAt (4-(1)))).place, indexStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit(">=", indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, sizeStr + ((Eval)(yystack.valueAt (4-(1)))).place, condStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit("check", condStr + ((Eval)(yystack.valueAt (4-(1)))).place, null, String.valueOf(nextQuad() + 3));
		emit("<", indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, "0", condStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit("check", condStr + ((Eval)(yystack.valueAt (4-(1)))).place, null, String.valueOf(nextQuad() + 1));

		emit("=[]", ((Eval)(yystack.valueAt (4-(1)))).place, indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, ((Eval)yyval).place);

		((Eval)yyval).trueList = Eval.makeList(nextQuad());
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));

	};
  break;
    

  case 59:
  if (yyn == 59)
    
/* Line 351 of lalr1.java  */
/* Line 590 of "YYParser.y"  */
    {
		System.out.println("Rule 52 :  expressions -> saved_id (arguments_list)") ;
		int index = symbolTable.lookUp(((Eval)(yystack.valueAt (4-(1)))).place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (!symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not an array, it can not be used with index.");
			return YYABORT;
		}
		yyval = new Eval();
		((Eval)yyval).place = newTemp(symbolTable.types.get(index), false);
		((Eval)yyval).type = symbolTable.types.get(index);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 2);
		Eval.arrayIndexOutOfBoundList.add(nextQuad() + 4);
		emit("-", ((Eval)(yystack.valueAt (4-(3)))).place, startStr + ((Eval)(yystack.valueAt (4-(1)))).place, indexStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit(">=", indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, sizeStr + ((Eval)(yystack.valueAt (4-(1)))).place, condStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit("check", condStr + ((Eval)(yystack.valueAt (4-(1)))).place, null, String.valueOf(nextQuad() + 3));
		emit("<", indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, "0", condStr + ((Eval)(yystack.valueAt (4-(1)))).place);
		emit("check", condStr + ((Eval)(yystack.valueAt (4-(1)))).place, null, String.valueOf(nextQuad() + 1));

		emit("=()", ((Eval)(yystack.valueAt (4-(1)))).place, indexStr + ((Eval)(yystack.valueAt (4-(1)))).place, ((Eval)yyval).place);

		((Eval)yyval).trueList = Eval.makeList(nextQuad());
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	};
  break;
    

  case 60:
  if (yyn == 60)
    
/* Line 351 of lalr1.java  */
/* Line 621 of "YYParser.y"  */
    {
		System.out.println("Rule 50 :  expressions -> saved_id") ;
		int index = symbolTable.lookUp(((Eval)(yystack.valueAt (1-(1)))).place);
		if (index == SymbolTable.NOT_IN_SYMBOL_TABLE) {
			System.err.println("Error! \"" + lexIdentifier + "\" is not declared.");
			return YYABORT;
		}
		if (symbolTable.arrays.get(index)) {
			System.err.println("Error! \"" + lexIdentifier + "\" is an array, it can not be used without index.");
			return YYABORT;
		}
		yyval = new Eval();
		((Eval)yyval).place = symbolTable.names.get(index);
		((Eval)yyval).type = symbolTable.types.get(index);

		((Eval)yyval).trueList = Eval.makeList(nextQuad());
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	};
  break;
    

  case 61:
  if (yyn == 61)
    
/* Line 351 of lalr1.java  */
/* Line 643 of "YYParser.y"  */
    {
		System.out.println("Rule 53 :  expressions -> (expressions)") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (3-(2)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (3-(2)))).type;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (3-(2)))).nextList;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (3-(2)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (3-(2)))).falseList;
	};
  break;
    

  case 62:
  if (yyn == 62)
    
/* Line 351 of lalr1.java  */
/* Line 653 of "YYParser.y"  */
    {
		System.out.println("Rule 54 :  constant_expressions -> saved_integer") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
	};
  break;
    

  case 63:
  if (yyn == 63)
    
/* Line 351 of lalr1.java  */
/* Line 662 of "YYParser.y"  */
    {
		System.out.println("Rule 55 :  constant_expressions -> saved_real") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
	};
  break;
    

  case 64:
  if (yyn == 64)
    
/* Line 351 of lalr1.java  */
/* Line 671 of "YYParser.y"  */
    {
		System.out.println("Rule 56 :  constant_expressions -> saved_char") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
	};
  break;
    

  case 65:
  if (yyn == 65)
    
/* Line 351 of lalr1.java  */
/* Line 680 of "YYParser.y"  */
    {
		System.out.println("Rule 57 :  constant_expressions -> saved_boolean") ;
		yyval = new Eval();
		((Eval)yyval).place = ((Eval)(yystack.valueAt (1-(1)))).place;
		((Eval)yyval).type = ((Eval)(yystack.valueAt (1-(1)))).type;
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (1-(1)))).trueList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (1-(1)))).falseList;
		((Eval)yyval).nextList = ((Eval)(yystack.valueAt (1-(1)))).nextList;
	};
  break;
    

  case 66:
  if (yyn == 66)
    
/* Line 351 of lalr1.java  */
/* Line 690 of "YYParser.y"  */
    {
		System.out.println("Rule 58 :  bool_expression -> <> pair") ;
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);

		emit("<>", ((EVal)(yystack.valueAt (6-(1)))).place, ((Eval)(yystack.valueAt (6-(3)))).place, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	};
  break;
    

  case 67:
  if (yyn == 67)
    
/* Line 351 of lalr1.java  */
/* Line 702 of "YYParser.y"  */
    {
		System.out.println("Rule 59 :  bool_expression -> <= pair") ;
	};
  break;
    

  case 68:
  if (yyn == 68)
    
/* Line 351 of lalr1.java  */
/* Line 705 of "YYParser.y"  */
    {
		System.out.println("Rule 60 :  bool_expression -> < pair") ;
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);

		emit("<", ((EVal)(yystack.valueAt (6-(1)))).place, ((Eval)(yystack.valueAt (6-(3)))).place, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2));
		emit("goto", null, null, String.valueOf(nextQuad() + 1));
	};
  break;
    

  case 69:
  if (yyn == 69)
    
/* Line 351 of lalr1.java  */
/* Line 717 of "YYParser.y"  */
    {
		System.out.println("Rule 61 :  bool_expression -> >= pair") ;
	};
  break;
    

  case 70:
  if (yyn == 70)
    
/* Line 351 of lalr1.java  */
/* Line 720 of "YYParser.y"  */
    {
		System.out.println("Rule 62 :  bool_expression -> > pair") ;
	};
  break;
    

  case 71:
  if (yyn == 71)
    
/* Line 351 of lalr1.java  */
/* Line 723 of "YYParser.y"  */
    {
		System.out.println("Rule 63 :  bool_expression -> = pair") ;
	};
  break;
    

  case 72:
  if (yyn == 72)
    
/* Line 351 of lalr1.java  */
/* Line 726 of "YYParser.y"  */
    {
		System.out.println("Rule 64 :  bool_expression -> AND pair") ;
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		backpatch(((EVal)(yystack.valueAt (6-(1)))).trueList, ((Eval)(yystack.valueAt (6-(5)))).quad);
		((Eval)yyval).trueList = ((EVal)(yystack.valueAt (6-(6)))).trueList;
		((Eval)yyval).falseList = Eval.merge(((EVal)(yystack.valueAt (6-(1)))).falseList, ((EVal)(yystack.valueAt (6-(6)))).falseList);
	};
  break;
    

  case 73:
  if (yyn == 73)
    
/* Line 351 of lalr1.java  */
/* Line 735 of "YYParser.y"  */
    {
		System.out.println("Rule 65 :  bool_expression -> OR pair") ;
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		backpatch(((EVal)(yystack.valueAt (6-(1)))).trueList, ((Eval)(yystack.valueAt (6-(5)))).quad);
		((Eval)yyval).trueList = ((EVal)(yystack.valueAt (6-(6)))).trueList;
		((Eval)yyval).falseList = Eval.merge(((EVal)(yystack.valueAt (6-(1)))).falseList, ((EVal)(yystack.valueAt (6-(6)))).falseList);
	};
  break;
    

  case 74:
  if (yyn == 74)
    
/* Line 351 of lalr1.java  */
/* Line 744 of "YYParser.y"  */
    {
		System.out.println("Rule 66 :  bool_expression -> AND THEN pair") ;
	};
  break;
    

  case 75:
  if (yyn == 75)
    
/* Line 351 of lalr1.java  */
/* Line 747 of "YYParser.y"  */
    {
		System.out.println("Rule 67 :  bool_expression -> OR ELSE pair") ;
	};
  break;
    

  case 76:
  if (yyn == 76)
    
/* Line 351 of lalr1.java  */
/* Line 750 of "YYParser.y"  */
    {
		System.out.println("Rule 68 :  bool_expression -> NOT expressions") ;
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)yyval).trueList = ((Eval)(yystack.valueAt (2-(2)))).falseList;
		((Eval)yyval).falseList = ((Eval)(yystack.valueAt (2-(2)))).trueList;
	};
  break;
    

  case 77:
  if (yyn == 77)
    
/* Line 351 of lalr1.java  */
/* Line 759 of "YYParser.y"  */
    {
		System.out.println("Rule 69 :  arithmetic_expressions -> + pair") ;

	};
  break;
    

  case 78:
  if (yyn == 78)
    
/* Line 351 of lalr1.java  */
/* Line 763 of "YYParser.y"  */
    {
		System.out.println("Rule 70 :  arithmetic_expressions -> - pair") ;
	};
  break;
    

  case 79:
  if (yyn == 79)
    
/* Line 351 of lalr1.java  */
/* Line 766 of "YYParser.y"  */
    {
		System.out.println("Rule 71 :  arithmetic_expressions -> * pair") ;
	};
  break;
    

  case 80:
  if (yyn == 80)
    
/* Line 351 of lalr1.java  */
/* Line 769 of "YYParser.y"  */
    {
		System.out.println("Rule 72 :  arithmetic_expressions -> / pair") ;
	};
  break;
    

  case 81:
  if (yyn == 81)
    
/* Line 351 of lalr1.java  */
/* Line 772 of "YYParser.y"  */
    {
		System.out.println("Rule 73 :  arithmetic_expressions -> % pair") ;
	};
  break;
    

  case 82:
  if (yyn == 82)
    
/* Line 351 of lalr1.java  */
/* Line 775 of "YYParser.y"  */
    {
		System.out.println("Rule 74 :  arithmetic_expressions -> - expressions") ;
	};
  break;
    

  case 83:
  if (yyn == 83)
    
/* Line 351 of lalr1.java  */
/* Line 780 of "YYParser.y"  */
    {
		System.out.println("Rule 76: " +
			"saved_identifier: IDENTIFIER");
		yyval = new Eval();
		((Eval)yyval).place = lexIdentifier;
	};
  break;
    

  case 84:
  if (yyn == 84)
    
/* Line 351 of lalr1.java  */
/* Line 788 of "YYParser.y"  */
    {
		System.out.println("Rule 77: " +
			"saved_integer: NUMCONSTANT");
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.INTEGER.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.INTEGER.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit(":=", String.valueOf(lexInt), null, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.

	};
  break;
    

  case 85:
  if (yyn == 85)
    
/* Line 351 of lalr1.java  */
/* Line 805 of "YYParser.y"  */
    {
		System.out.println("Rule 78: " +
			"saved_real: REAL_CONSTANT");
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.REAL.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.REAL.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit(":=", String.valueOf(lexReal), null, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	};
  break;
    

  case 86:
  if (yyn == 86)
    
/* Line 351 of lalr1.java  */
/* Line 821 of "YYParser.y"  */
    {
		System.out.println("Rule 79: " +
			"saved_char: CHAR_CONSTANT");
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.CHAR.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.CHAR.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		emit(":=", "'" + String.valueOf(lexChar) + "'", null, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	};
  break;
    

  case 87:
  if (yyn == 87)
    
/* Line 351 of lalr1.java  */
/* Line 837 of "YYParser.y"  */
    {
		System.out.println("Rule 80: " +
			"saved_boolean: BOOLEAN_CONSTANT");
		yyval = new Eval();
		((Eval)yyval).place = newTemp(Eval.TYPECODES.BOOLEAN.getType(), false);
		((Eval)yyval).type = Eval.TYPECODES.BOOLEAN.getType();
		((Eval)yyval).trueList = Eval.makeList(nextQuad() + 1);
		((Eval)yyval).falseList = Eval.makeList(nextQuad() + 2);
		((Eval)yyval).nextList = Eval.merge(((Eval)yyval).trueList, ((Eval)yyval).falseList);

		if(lexBoolean)
			emit(":=", "1", null, ((Eval)yyval).place);
		else
			emit(":=", "0", null, ((Eval)yyval).place);
		emit("check", ((Eval)yyval).place, null, String.valueOf(nextQuad() + 2)); // result may be backpatched.
		emit("goto", null, null, String.valueOf(nextQuad() + 1)); // result may be backpatched.
	};
  break;
    



/* Line 351 of lalr1.java  */
/* Line 1713 of "YYParser.java"  */
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
  private static final short yypact_ninf_ = -44;
  private static final short yypact_[] =
  {
       -40,   -35,    28,   -44,   165,   -44,   -35,   -44,   -44,   -44,
     -44,    20,   175,   -44,   -35,    -6,   -44,    42,    71,   -44,
      20,   -44,    22,    64,   -44,    56,    43,    20,   -44,    53,
      75,   -44,    48,   190,   -35,   190,   252,   150,   -44,   233,
      80,    13,   -44,    20,   -35,   -44,    -7,    52,   -44,    16,
      53,   150,    97,   100,   102,   223,   104,   105,   109,   116,
     121,   122,   135,   190,   190,     3,    -3,   -44,   -44,   -44,
     -44,   -44,   -44,   -44,   -44,    62,   -44,   -44,   -44,   -44,
      85,   118,   117,   127,   -44,   133,   -44,   190,   190,   190,
     -44,   -44,    74,   -44,   -44,   149,   163,   164,     2,   -44,
      90,   -44,   190,   190,   190,   190,   -44,   190,   190,   190,
     190,   190,   190,   190,   157,   -44,   190,   161,   190,   162,
     190,   190,   120,   120,    57,   150,   252,   -44,   169,   130,
     -44,   160,   -44,   173,   158,   -44,   197,   198,   216,   -44,
     180,   207,   208,   215,     1,   218,   219,   235,   236,   237,
     238,   239,   -44,   243,   190,   244,   190,   253,   248,   200,
      83,   273,   274,   120,   247,   -44,   245,   -44,   190,   265,
     -44,    74,   251,   -35,   120,   264,   190,   190,   190,   190,
     190,   190,   190,   190,   190,   190,   190,   190,   267,   190,
     269,   -44,   -44,   252,   120,   120,    20,    20,   293,   -44,
     252,   -44,   190,   -44,   -44,   -44,   -44,   -44,   279,   280,
     281,   282,   283,   284,   285,   286,   287,   288,   290,   291,
     190,   292,   190,   -44,   -44,   -44,   -44,   -44,    20,   -44,
     -44,   -44,   -44,   -44,   -44,   -44,   -44,   -44,   -44,   -44,
     -44,   -44,   -44,   294,   -44,   295,   -44,   -44,   -44
  };

  /* YYDEFACT[S] -- default reduction number in state S.  Performed when
     YYTABLE doesn't specify something else to do.  Zero means the
     default is an error.  */
  private static final byte yydefact_[] =
  {
         0,     0,     0,    83,     0,     1,     0,    13,    12,    11,
      10,     6,     0,     7,     0,     0,    29,     0,     0,     2,
       0,     8,     0,     0,    14,    16,    18,     0,    28,     0,
       0,    33,     0,     0,     0,     0,     0,     0,    46,     0,
       0,     0,     3,     0,     0,     9,     0,     0,     4,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    84,    85,    86,
      87,    44,    55,    56,    57,    60,    62,    63,    64,    65,
       0,     0,     0,     0,    32,     0,    34,     0,     0,     0,
       5,    15,     0,    17,    24,     0,     0,     0,     0,    31,
       0,    45,     0,     0,     0,     0,    82,     0,     0,     0,
       0,     0,     0,     0,     0,    76,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    35,     0,    47,
      49,     0,    36,     0,    27,    19,     0,     0,     0,    20,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,    61,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    39,    38,    42,     0,     0,
      25,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,    59,    58,     0,     0,     0,     0,     0,     0,    41,
       0,    48,     0,    26,    23,    21,    22,    30,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,    40,    51,    50,    52,    54,     0,    37,
      43,    81,    80,    79,    78,    77,    67,    69,    66,    71,
      70,    68,    73,     0,    72,     0,    53,    75,    74
  };

  /* YYPGOTO[NTERM-NUM].  */
  private static final short yypgoto_[] =
  {
       -44,   -44,   -21,    -1,   -44,   -44,   268,   -44,   -44,   -44,
     144,   304,     4,   -44,   -11,   -44,   -32,   -44,   -44,   -44,
     -44,   -44,   -33,   -43,   -27,   -42,     0,    -4,   -44,   -44,
     -44
  };

  /* YYDEFGOTO[NTERM-NUM].  */
  private static final short
  yydefgoto_[] =
  {
        -1,     2,    12,    13,    14,    23,    24,    25,    95,    93,
     133,    15,    16,    30,    38,    39,    40,   128,   129,   159,
     124,   164,    71,    72,    73,    74,    75,    76,    77,    78,
      79
  };

  /* YYTABLE[YYPACT[STATE-NUM]].  What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule which
     number is the opposite.  If YYTABLE_NINF_, syntax error.  */
  private static final short yytable_ninf_ = -1;
  private static final short
  yytable_[] =
  {
        19,     4,    81,    94,    82,    96,    17,    85,    49,    42,
      83,    21,     1,   138,    26,    92,    48,   118,    41,    28,
     152,     3,   106,   116,   101,   139,    28,   179,     5,   100,
     114,   115,    90,    87,    80,    99,    41,    88,    89,    41,
       6,   119,    18,    98,    26,    27,   117,    97,    21,   134,
      67,    68,    69,    70,   130,   131,   132,    52,    53,    54,
      55,    56,    29,     7,     8,     9,    10,    47,     6,   141,
     142,   143,   144,    43,   145,   146,   147,   148,   149,   150,
     151,    46,   120,   153,    51,   155,   121,   157,   158,   140,
      44,    45,    31,    18,   166,   162,   163,    50,   165,    21,
       7,     8,     9,    10,    32,    33,    34,    86,     3,    67,
     122,    35,    18,    36,   194,   195,    37,   102,   160,   161,
     103,   188,   104,   190,   107,   108,    41,     3,   134,   109,
     204,    67,    68,    69,    70,   201,   110,     7,     8,     9,
      10,   111,   112,   208,   209,   210,   211,   212,   213,   214,
     215,   216,   217,   218,   219,   113,   221,   123,   125,   198,
     127,   223,    57,    58,    59,    60,    61,    62,   229,   230,
     206,   126,   135,   205,   136,   137,   152,    67,    64,    65,
      66,   154,   156,   169,   171,   226,   227,   243,   167,   245,
     224,   225,   168,    41,   170,    52,    53,    54,    55,    56,
      41,   175,    57,    58,    59,    60,    61,    62,   172,   173,
      63,     6,     7,     8,     9,    10,    11,   246,    64,    65,
      66,     6,     7,     8,     9,    10,    20,   174,    52,    53,
      54,    55,    56,   176,   177,    57,    58,    59,    60,    61,
      62,   178,   193,   105,   180,   181,     3,    67,    68,    69,
      70,    64,    65,    66,    84,    18,    52,    53,    54,    55,
      56,   182,   183,   184,   185,   186,    32,    33,    34,   187,
     189,   192,   191,    35,    18,    36,   196,   197,    37,     3,
      67,    68,    69,    70,   199,    32,    33,    34,   200,     3,
     202,   207,    35,   220,    36,   222,   228,    37,   231,   232,
     233,   234,   235,   236,   237,   238,   239,   240,     3,   241,
     242,   244,    91,   247,   248,   203,    22
  };

  /* YYCHECK.  */
  private static final short
  yycheck_[] =
  {
        11,     1,    35,    46,    36,    47,     6,    39,    29,    20,
      37,    12,    52,    11,    14,    22,    27,    20,    18,    15,
      19,    56,    55,    20,    51,    23,    22,    26,     0,    50,
      63,    64,    43,    20,    34,    19,    36,    24,    25,    39,
      46,    44,    22,    47,    44,    51,    43,    47,    49,    92,
      57,    58,    59,    60,    87,    88,    89,     5,     6,     7,
       8,     9,    20,    47,    48,    49,    50,    24,    46,   102,
     103,   104,   105,    51,   107,   108,   109,   110,   111,   112,
     113,    25,    20,   116,    36,   118,    24,   120,   121,   100,
      26,    27,    21,    22,   126,    38,    39,    22,   125,   100,
      47,    48,    49,    50,    33,    34,    35,    27,    56,    57,
      25,    40,    22,    42,    31,    32,    45,    20,   122,   123,
      20,   154,    20,   156,    20,    20,   126,    56,   171,    20,
     172,    57,    58,    59,    60,   168,    20,    47,    48,    49,
      50,    20,    20,   176,   177,   178,   179,   180,   181,   182,
     183,   184,   185,   186,   187,    20,   189,    39,    41,   163,
      27,   193,    12,    13,    14,    15,    16,    17,   200,   202,
     174,    44,    23,   173,    11,    11,    19,    57,    28,    29,
      30,    20,    20,    23,    26,   196,   197,   220,    19,   222,
     194,   195,    62,   193,    21,     5,     6,     7,     8,     9,
     200,    21,    12,    13,    14,    15,    16,    17,    11,    11,
      20,    46,    47,    48,    49,    50,    51,   228,    28,    29,
      30,    46,    47,    48,    49,    50,    51,    11,     5,     6,
       7,     8,     9,    26,    26,    12,    13,    14,    15,    16,
      17,    26,    42,    20,    26,    26,    56,    57,    58,    59,
      60,    28,    29,    30,    21,    22,     5,     6,     7,     8,
       9,    26,    26,    26,    26,    26,    33,    34,    35,    26,
      26,    23,    19,    40,    22,    42,     3,     3,    45,    56,
      57,    58,    59,    60,    37,    33,    34,    35,    43,    56,
      25,    27,    40,    26,    42,    26,     3,    45,    19,    19,
      19,    19,    19,    19,    19,    19,    19,    19,    56,    19,
      19,    19,    44,    19,    19,   171,    12
  };

  /* STOS_[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
  private static final byte
  yystos_[] =
  {
         0,    52,    64,    56,    89,     0,    46,    47,    48,    49,
      50,    51,    65,    66,    67,    74,    75,    89,    22,    77,
      51,    66,    74,    68,    69,    70,    89,    51,    75,    20,
      76,    21,    33,    34,    35,    40,    42,    45,    77,    78,
      79,    89,    77,    51,    26,    27,    25,    24,    77,    65,
      22,    36,     5,     6,     7,     8,     9,    12,    13,    14,
      15,    16,    17,    20,    28,    29,    30,    57,    58,    59,
      60,    85,    86,    87,    88,    89,    90,    91,    92,    93,
      89,    85,    79,    87,    21,    79,    27,    20,    24,    25,
      77,    69,    22,    72,    86,    71,    88,    89,    90,    19,
      65,    87,    20,    20,    20,    20,    85,    20,    20,    20,
      20,    20,    20,    20,    85,    85,    20,    43,    20,    44,
      20,    24,    25,    39,    83,    41,    44,    27,    80,    81,
      85,    85,    85,    73,    86,    23,    11,    11,    11,    23,
      77,    85,    85,    85,    85,    85,    85,    85,    85,    85,
      85,    85,    19,    85,    20,    85,    20,    85,    85,    82,
      90,    90,    38,    39,    84,    87,    79,    19,    62,    23,
      21,    26,    11,    11,    11,    21,    26,    26,    26,    26,
      26,    26,    26,    26,    26,    26,    26,    26,    85,    26,
      85,    19,    23,    42,    31,    32,     3,     3,    90,    37,
      43,    85,    25,    73,    88,    89,    90,    27,    85,    85,
      85,    85,    85,    85,    85,    85,    85,    85,    85,    85,
      26,    85,    26,    79,    90,    90,    77,    77,     3,    79,
      85,    19,    19,    19,    19,    19,    19,    19,    19,    19,
      19,    19,    19,    85,    19,    85,    77,    19,    19
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
     305,   306,   307,   308,   309,   310,   311,   312,   313,   314,
     315,   316,   317
  };

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
  private static final byte
  yyr1_[] =
  {
         0,    63,    64,    64,    64,    64,    64,    65,    65,    66,
      67,    67,    67,    67,    68,    68,    69,    69,    70,    70,
      70,    71,    71,    71,    72,    72,    73,    73,    74,    74,
      75,    76,    77,    77,    78,    78,    79,    79,    79,    79,
      79,    79,    79,    79,    79,    79,    79,    80,    81,    81,
      82,    82,    83,    83,    84,    85,    85,    85,    85,    85,
      85,    85,    86,    86,    86,    86,    87,    87,    87,    87,
      87,    87,    87,    87,    87,    87,    87,    88,    88,    88,
      88,    88,    88,    89,    90,    91,    92,    93
  };

  /* YYR2[YYN] -- Number of symbols composing right hand side of rule YYN.  */
  private static final byte
  yyr2_[] =
  {
         0,     2,     4,     5,     5,     6,     3,     1,     2,     3,
       1,     1,     1,     1,     1,     3,     1,     3,     1,     4,
       4,     4,     4,     4,     1,     3,     3,     1,     2,     1,
       8,     3,     3,     2,     2,     3,     3,     6,     4,     4,
       6,     5,     4,     6,     2,     3,     1,     1,     3,     1,
       3,     3,     4,     5,     3,     1,     1,     1,     4,     4,
       1,     3,     1,     1,     1,     1,     6,     6,     6,     6,
       6,     6,     6,     6,     7,     7,     2,     6,     6,     6,
       6,     6,     2,     1,     1,     1,     1,     1
  };

  /* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
     First, the terminals, then, starting at \a yyntokens_, nonterminals.  */
  private static final String yytname_[] =
  {
    "$end", "error", "$undefined", "DOUBLE_DOT_KW", "SHARP_KW", "MOD_KW",
  "DIV_KW", "MUL_KW", "SUB_KW", "ADD_KW", "SINGLE_QUOTE_KW", "DOT_KW",
  "LTE_KW", "GTE_KW", "NEQ_KW", "EQ_KW", "GT_KW", "LT_KW", "COMMA_KW",
  "CLOSEPARENTHESIS_KW", "OPENPARENTHESIS_KW", "CLOSEACCOLADE_KW",
  "OPENACCOLADE_KW", "CLOSEBRACKET_KW", "OPENBRACKET_KW", "ASSIGN_KW",
  "COLON_KW", "SEMICOLON_KW", "NOT_KW", "OR_KW", "AND_KW", "DOWNTO_KW",
  "UPTO_KW", "EXIT_KW", "RETURN_KW", "FOR_KW", "WHEN_KW", "END_KW",
  "DEFAULT_KW", "CASE_KW", "SWITCH_KW", "WHILE_KW", "DO_KW", "ELSE_KW",
  "THEN_KW", "IF_KW", "PROCEDURE_KW", "BOOLEAN_KW", "CHARACTER_KW",
  "REAL_KW", "INTEGER_KW", "MAIN_KW", "PROGRAM_KW", "DIGIT",
  "NONZERO_DIGIT", "LETTER", "ID", "NUMCONSTANT", "REALCONST", "CHARCONST",
  "BOOLCONST", "usub", "\",\"", "$accept", "program", "declarations_list",
  "declarations", "type_specifieirs", "declarator_list", "declarator",
  "dec", "range", "initializer", "initializer_list", "procedure_list",
  "procedure", "parameters", "block", "statment_list", "statment",
  "arguments_list", "multi_arguments", "counter", "case_element",
  "default", "expressions", "constant_expressions", "bool_expression",
  "arithmetic_expressions", "saved_id", "saved_integer", "saved_real",
  "saved_char", "saved_boolean", null
  };

  /* YYRHS -- A `-1'-separated list of the rules' RHS.  */
  private static final byte yyrhs_[] =
  {
        64,     0,    -1,    52,    89,    51,    77,    -1,    52,    89,
      65,    51,    77,    -1,    52,    89,    74,    51,    77,    -1,
      52,    89,    65,    74,    51,    77,    -1,    52,    89,    51,
      -1,    66,    -1,    65,    66,    -1,    67,    68,    27,    -1,
      50,    -1,    49,    -1,    48,    -1,    47,    -1,    69,    -1,
      68,    26,    69,    -1,    70,    -1,    70,    25,    72,    -1,
      89,    -1,    89,    24,    71,    23,    -1,    89,    24,    90,
      23,    -1,    89,    11,    11,    89,    -1,    90,    11,    11,
      90,    -1,    88,    11,    11,    88,    -1,    86,    -1,    22,
      73,    21,    -1,    86,    26,    73,    -1,    86,    -1,    74,
      75,    -1,    75,    -1,    46,    89,    76,    22,    65,    77,
      21,    27,    -1,    20,    65,    19,    -1,    22,    78,    21,
      -1,    22,    21,    -1,    79,    27,    -1,    78,    79,    27,
      -1,    89,    25,    85,    -1,    45,    87,    44,    79,    43,
      79,    -1,    45,    87,    44,    79,    -1,    42,    79,    41,
      87,    -1,    35,    89,    25,    82,    42,    79,    -1,    40,
      85,    83,    84,    37,    -1,    89,    20,    80,    19,    -1,
      89,    24,    85,    23,    25,    85,    -1,    34,    85,    -1,
      33,    36,    87,    -1,    77,    -1,    81,    -1,    81,    62,
      85,    -1,    85,    -1,    90,    32,    90,    -1,    90,    31,
      90,    -1,    39,    90,     3,    77,    -1,    83,    39,    90,
       3,    77,    -1,    38,     3,    77,    -1,    86,    -1,    87,
      -1,    88,    -1,    89,    24,    85,    23,    -1,    89,    20,
      85,    19,    -1,    89,    -1,    20,    85,    19,    -1,    90,
      -1,    91,    -1,    92,    -1,    93,    -1,    14,    20,    85,
      26,    85,    19,    -1,    12,    20,    85,    26,    85,    19,
      -1,    17,    20,    85,    26,    85,    19,    -1,    13,    20,
      85,    26,    85,    19,    -1,    16,    20,    85,    26,    85,
      19,    -1,    15,    20,    85,    26,    85,    19,    -1,    30,
      20,    85,    26,    85,    19,    -1,    29,    20,    85,    26,
      85,    19,    -1,    30,    44,    20,    85,    26,    85,    19,
      -1,    29,    43,    20,    85,    26,    85,    19,    -1,    28,
      85,    -1,     9,    20,    85,    26,    85,    19,    -1,     8,
      20,    85,    26,    85,    19,    -1,     7,    20,    85,    26,
      85,    19,    -1,     6,    20,    85,    26,    85,    19,    -1,
       5,    20,    85,    26,    85,    19,    -1,     8,    85,    -1,
      56,    -1,    57,    -1,    58,    -1,    59,    -1,    60,    -1
  };

  /* YYPRHS[YYN] -- Index of the first RHS symbol of rule number YYN in
     YYRHS.  */
  private static final short yyprhs_[] =
  {
         0,     0,     3,     8,    14,    20,    27,    31,    33,    36,
      40,    42,    44,    46,    48,    50,    54,    56,    60,    62,
      67,    72,    77,    82,    87,    89,    93,    97,    99,   102,
     104,   113,   117,   121,   124,   127,   131,   135,   142,   147,
     152,   159,   165,   170,   177,   180,   184,   186,   188,   192,
     194,   198,   202,   207,   213,   217,   219,   221,   223,   228,
     233,   235,   239,   241,   243,   245,   247,   254,   261,   268,
     275,   282,   289,   296,   303,   311,   319,   322,   329,   336,
     343,   350,   357,   360,   362,   364,   366,   368
  };

  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
  private static final short yyrline_[] =
  {
         0,   189,   189,   195,   201,   207,   214,   221,   224,   228,
     282,   287,   292,   297,   303,   310,   326,   334,   347,   353,
     368,   384,   387,   390,   394,   402,   410,   423,   432,   435,
     439,   443,   447,   452,   458,   461,   465,   468,   471,   474,
     477,   480,   483,   486,   489,   492,   495,   500,   505,   508,
     512,   515,   519,   522,   526,   531,   540,   549,   558,   590,
     621,   643,   653,   662,   671,   680,   690,   702,   705,   717,
     720,   723,   726,   735,   744,   747,   750,   759,   763,   766,
     769,   772,   775,   780,   788,   805,   821,   837
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
      55,    56,    57,    58,    59,    60,    61,    62
  };

  private static final byte yytranslate_ (int t)
  {
    if (t >= 0 && t <= yyuser_token_number_max_)
      return yytranslate_table_[t];
    else
      return yyundef_token_;
  }

  private static final int yylast_ = 316;
  private static final int yynnts_ = 31;
  private static final int yyempty_ = -2;
  private static final int yyfinal_ = 5;
  private static final int yyterror_ = 1;
  private static final int yyerrcode_ = 256;
  private static final int yyntokens_ = 63;

  private static final int yyuser_token_number_max_ = 317;
  private static final int yyundef_token_ = 2;

/* User implementation code.  */
/* Unqualified %code blocks.  */

/* Line 927 of lalr1.java  */
/* Line 22 of "YYParser.y"  */


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



/* Line 927 of lalr1.java  */
/* Line 2691 of "YYParser.java"  */

}


/* Line 931 of lalr1.java  */
/* Line 855 of "YYParser.y"  */


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

