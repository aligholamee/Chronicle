/* The following code was generated by JFlex 1.6.0 */

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
	        String input = "C:\\Users\\Ali Gholami\\Documents\\Amirkabir\\COMPILER\\Chronicle\\PHASE1_LEXICAL_ANALYZER\Global_Test\\globalTest2.shl";
	        try {
	            fr = new FileReader(input);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        // System.out.println("Lexeme\tToken\tAttribute");
	        Yylex yylex = new Yylex(fr);
	        try {
	            yylex.yylex();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>C:/Users/aligholamee/Desktop/dESKTOP/Chronicle/PHASE1_LEXICAL_ANALYZER/Yylex.flex</tt>
 */
class Yylex {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\1\1\55\1\55\1\1\22\0\1\1\2\0\1\54"+
    "\1\0\1\53\1\0\1\46\1\40\1\41\1\51\1\47\1\42\1\50"+
    "\1\45\1\52\1\4\11\3\1\32\1\31\1\43\1\33\1\44\2\0"+
    "\32\2\1\34\1\0\1\35\3\0\1\11\1\22\1\20\1\23\1\16"+
    "\1\25\1\10\1\21\1\13\2\2\1\17\1\12\1\14\1\7\1\5"+
    "\1\2\1\6\1\26\1\15\1\24\1\2\1\27\1\30\2\2\1\36"+
    "\1\0\1\37\7\0\1\55\u1fa2\0\1\55\1\55\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\udfe6\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\2\1\21\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\2\2"+
    "\1\27\3\2\1\30\11\2\1\31\6\2\1\32\1\33"+
    "\1\34\1\35\1\36\1\0\2\37\3\2\1\40\1\2"+
    "\1\41\1\42\2\2\1\43\10\2\1\44\4\2\1\45"+
    "\1\0\2\2\1\46\1\2\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\2\2\1\57\2\2\1\60"+
    "\1\61\6\2\1\62\2\2\1\63\1\64\1\2\1\65"+
    "\1\66\1\2\1\67\1\2\1\70";

  private static int [] zzUnpackAction() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\56\0\134\0\212\0\270\0\346\0\u0114\0\u0142"+
    "\0\u0170\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2"+
    "\0\u02e0\0\u030e\0\u033c\0\u036a\0\56\0\u0398\0\56\0\56"+
    "\0\56\0\56\0\56\0\56\0\56\0\56\0\u03c6\0\u03f4"+
    "\0\u0422\0\u0450\0\56\0\56\0\56\0\56\0\56\0\u047e"+
    "\0\u04ac\0\u04da\0\212\0\u0508\0\u0536\0\u0564\0\212\0\u0592"+
    "\0\u05c0\0\u05ee\0\u061c\0\u064a\0\u0678\0\u06a6\0\u06d4\0\u0702"+
    "\0\u0730\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844\0\56"+
    "\0\56\0\56\0\56\0\56\0\u0872\0\u08a0\0\u08ce\0\u08fc"+
    "\0\u092a\0\u0958\0\212\0\u0986\0\212\0\212\0\u09b4\0\u09e2"+
    "\0\212\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0af6\0\u0b24"+
    "\0\u0b52\0\212\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a\0\56\0\u0c38"+
    "\0\u0c66\0\u0c94\0\212\0\u0cc2\0\212\0\212\0\212\0\212"+
    "\0\212\0\212\0\212\0\212\0\u0cf0\0\u0d1e\0\212\0\u0d4c"+
    "\0\u0d7a\0\212\0\u0c38\0\u0da8\0\u0dd6\0\u0e04\0\u0e32\0\u0e60"+
    "\0\u0e8e\0\212\0\u0ebc\0\u0eea\0\212\0\212\0\u0f18\0\212"+
    "\0\212\0\u0f46\0\212\0\u0f74\0\212";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\2\2\1\5\1\6\1\7\1\4"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\4\1\16"+
    "\1\4\1\17\1\20\1\21\1\22\1\23\1\24\1\4"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\47\1\50\60\0\1\3\56\0\1\4"+
    "\2\0\24\4\27\0\1\4\2\0\1\4\1\51\22\4"+
    "\27\0\1\4\2\0\11\4\1\52\12\4\27\0\1\4"+
    "\2\0\1\4\1\53\22\4\27\0\1\4\2\0\7\4"+
    "\1\54\14\4\27\0\1\4\2\0\4\4\1\55\17\4"+
    "\27\0\1\4\2\0\7\4\1\56\10\4\1\57\3\4"+
    "\27\0\1\4\2\0\2\4\1\60\21\4\27\0\1\4"+
    "\2\0\1\4\1\61\12\4\1\62\7\4\27\0\1\4"+
    "\2\0\7\4\1\63\2\4\1\64\10\4\1\65\27\0"+
    "\1\4\2\0\4\4\1\66\7\4\1\67\7\4\27\0"+
    "\1\4\2\0\2\4\1\70\21\4\27\0\1\4\2\0"+
    "\2\4\1\71\6\4\1\72\12\4\27\0\1\4\2\0"+
    "\1\73\23\4\27\0\1\4\2\0\2\4\1\74\1\4"+
    "\1\75\17\4\27\0\1\4\2\0\22\4\1\76\1\4"+
    "\27\0\1\4\2\0\14\4\1\77\7\4\60\0\1\100"+
    "\55\0\1\101\10\0\1\102\44\0\1\103\67\0\1\104"+
    "\12\0\27\105\30\0\1\106\1\107\53\0\1\4\2\0"+
    "\2\4\1\110\21\4\27\0\1\4\2\0\4\4\1\111"+
    "\3\4\1\112\13\4\27\0\1\4\2\0\16\4\1\113"+
    "\5\4\27\0\1\4\2\0\6\4\1\114\15\4\27\0"+
    "\1\4\2\0\10\4\1\115\13\4\27\0\1\4\2\0"+
    "\10\4\1\116\13\4\27\0\1\4\2\0\17\4\1\117"+
    "\4\4\27\0\1\4\2\0\11\4\1\120\12\4\27\0"+
    "\1\4\2\0\16\4\1\121\5\4\27\0\1\4\2\0"+
    "\21\4\1\122\2\4\27\0\1\4\2\0\6\4\1\123"+
    "\15\4\27\0\1\4\2\0\21\4\1\124\2\4\27\0"+
    "\1\4\2\0\4\4\1\125\17\4\27\0\1\4\2\0"+
    "\2\4\1\126\21\4\27\0\1\4\2\0\22\4\1\127"+
    "\1\4\27\0\1\4\2\0\20\4\1\130\3\4\27\0"+
    "\1\4\2\0\10\4\1\131\13\4\27\0\1\4\2\0"+
    "\1\4\1\132\22\4\27\0\1\4\2\0\12\4\1\133"+
    "\11\4\27\0\1\4\2\0\6\4\1\134\15\4\27\0"+
    "\1\4\2\0\6\4\1\135\2\4\1\136\12\4\73\0"+
    "\1\137\12\0\2\106\40\0\1\140\55\0\1\140\12\0"+
    "\1\4\2\0\3\4\1\141\7\4\1\142\10\4\27\0"+
    "\1\4\2\0\12\4\1\143\11\4\27\0\1\4\2\0"+
    "\17\4\1\144\4\4\27\0\1\4\2\0\7\4\1\145"+
    "\14\4\27\0\1\4\2\0\11\4\1\146\12\4\27\0"+
    "\1\4\2\0\7\4\1\147\14\4\27\0\1\4\2\0"+
    "\11\4\1\150\12\4\27\0\1\4\2\0\10\4\1\151"+
    "\13\4\27\0\1\4\2\0\11\4\1\152\12\4\27\0"+
    "\1\4\2\0\1\4\1\153\22\4\27\0\1\4\2\0"+
    "\12\4\1\154\11\4\27\0\1\4\2\0\7\4\1\155"+
    "\14\4\27\0\1\4\2\0\4\4\1\156\17\4\27\0"+
    "\1\4\2\0\2\4\1\157\21\4\27\0\1\4\2\0"+
    "\21\4\1\117\2\4\27\0\1\4\2\0\10\4\1\160"+
    "\13\4\27\0\1\4\2\0\12\4\1\161\11\4\27\0"+
    "\1\4\2\0\7\4\1\162\14\4\30\0\1\163\1\140"+
    "\53\0\1\4\2\0\1\4\1\164\22\4\27\0\1\4"+
    "\2\0\11\4\1\165\12\4\27\0\1\4\2\0\1\4"+
    "\1\166\22\4\27\0\1\4\2\0\10\4\1\167\13\4"+
    "\27\0\1\4\2\0\17\4\1\170\4\4\27\0\1\4"+
    "\2\0\13\4\1\171\10\4\27\0\1\4\2\0\11\4"+
    "\1\172\12\4\27\0\1\4\2\0\4\4\1\173\17\4"+
    "\27\0\1\4\2\0\16\4\1\174\5\4\27\0\1\4"+
    "\2\0\7\4\1\175\14\4\27\0\1\4\2\0\2\4"+
    "\1\176\21\4\27\0\1\4\2\0\12\4\1\177\11\4"+
    "\27\0\1\4\2\0\14\4\1\200\7\4\27\0\1\4"+
    "\2\0\5\4\1\201\16\4\27\0\1\4\2\0\17\4"+
    "\1\202\4\4\27\0\1\4\2\0\10\4\1\203\13\4"+
    "\27\0\1\4\2\0\1\4\1\204\22\4\27\0\1\4"+
    "\2\0\11\4\1\205\12\4\25\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4002];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\22\1\1\11\1\1\10\11\4\1\5\11"+
    "\30\1\5\11\1\0\31\1\1\11\1\0\45\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[133];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 168) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;           
    int totalRead = 0;
    while (totalRead < requested) {
      int numRead = zzReader.read(zzBuffer, zzEndRead + totalRead, requested - totalRead);
      if (numRead == -1) {
        break;
      }
      totalRead += numRead;
    }

    if (totalRead > 0) {
      zzEndRead += totalRead;
      if (totalRead == requested) { /* possibly more input available */
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      return false;
    }

    // totalRead = 0: End of stream
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 1: 
          { 
          }
        case 57: break;
        case 2: 
          { // System.out.println(yytext() + "\t" + "ID\t" + "Symbol Table Entry");
	return YYParser.ID;
          }
        case 58: break;
        case 3: 
          { // System.out.println(yytext() + "\t" + "SEMICOLON_KW\t" + '-');
	return YYParser.SEMICOLON_KW;
          }
        case 59: break;
        case 4: 
          { // System.out.println(yytext() + "\t" + "COLON_KW\t" + '-');
	return YYParser.COLON_KW;
          }
        case 60: break;
        case 5: 
          { // System.out.println(yytext() + "\t" + "EQ_KW\t" + '-');
	return YYParser.EQ_KW;
          }
        case 61: break;
        case 6: 
          { // System.out.println(yytext() + "\t" + "OPENBRACKET_KW\t" + '-');
	return YYParser.OPENBRACKET_KW;
          }
        case 62: break;
        case 7: 
          { // System.out.println(yytext() + "\t" + "CLOSEBRACKET_KW\t" + '-');
	return YYParser.CLOSEBRACKET_KW;
          }
        case 63: break;
        case 8: 
          { // System.out.println(yytext() + "\t" + "OPENACCOLADE_KW\t" + '-');
	return YYParser.OPENACCOLADE_KW;
          }
        case 64: break;
        case 9: 
          { // System.out.println(yytext() + "\t" + "CLOSEACCOLADE_KW\t" + '-');
	return YYParser.CLOSEACCOLADE_KW;
          }
        case 65: break;
        case 10: 
          { // System.out.println(yytext() + "\t" + "OPENPARENTHESIS_KW\t" + '-');
	return YYParser.OPENPARENTHESIS_KW;
          }
        case 66: break;
        case 11: 
          { // System.out.println(yytext() + "\t" + "CLOSEPARENTHESIS_KW\t" + '-');
	return YYParser.CLOSEPARENTHESIS_KW;
          }
        case 67: break;
        case 12: 
          { // System.out.println(yytext() + "\t" + "COMMA_KW\t" + '-');
	return YYParser.COMMA_KW;
          }
        case 68: break;
        case 13: 
          { // System.out.println(yytext() + "\t" + "LT_KW\t" + '-');
	return YYParser.LT_KW;
          }
        case 69: break;
        case 14: 
          { // System.out.println(yytext() + "\t" + "GT_KW\t" + '-');
	return YYParser.GT_KW;
          }
        case 70: break;
        case 15: 
          { // System.out.println(yytext() + "\t" + "DOT_KW\t" + '-');
	return YYParser.DOT_KW;
          }
        case 71: break;
        case 16: 
          { // System.out.println(yytext() + "\t" + "SINGLE_QUOTE_KW\t" + '-');
	return YYParser.SINGLE_QUOTE_KW;
          }
        case 72: break;
        case 17: 
          { // System.out.println(yytext() + "\t" + "ADD_KW\t" + '-');
	return YYParser.ADD_KW;
          }
        case 73: break;
        case 18: 
          { // System.out.println(yytext() + "\t" + "SUB_KW\t" + '-');
	return YYParser.SUB_KW;
          }
        case 74: break;
        case 19: 
          { // System.out.println(yytext() + "\t" + "MUL_KW\t" + '-');
	return YYParser.MUL_KW;
          }
        case 75: break;
        case 20: 
          { // System.out.println(yytext() + "\t" + "DIV_KW\t" + '-');
	return YYParser.DIV_KW;
          }
        case 76: break;
        case 21: 
          { // System.out.println(yytext() + "\t" + "MOD_KW\t" + '-');
	return YYParser.MOD_KW;
          }
        case 77: break;
        case 22: 
          { // System.out.println(yytext() + "\t" + "SHARP_KW\t" + '-');
	return YYParser.SHARP_KW;
          }
        case 78: break;
        case 23: 
          { // System.out.println(yytext() + "\t" + "OR_KW\t" + '-');
	return YYParser.OR_KW;
          }
        case 79: break;
        case 24: 
          { // System.out.println(yytext() + "\t" + "IF_KW\t" + '-');
	return YYParser.IF_KW;
          }
        case 80: break;
        case 25: 
          { // System.out.println(yytext() + "\t" + "DO_KW\t" + '-');
	return YYParser.DO_KW;
          }
        case 81: break;
        case 26: 
          { // System.out.println(yytext() + "\t" + "ASSIGN_KW\t" + '-');
	return YYParser.ASSIGN_KW;
          }
        case 82: break;
        case 27: 
          { // System.out.println(yytext() + "\t" + "LTE_KW\t" + '-');
	return YYParser.LTE_KW;
          }
        case 83: break;
        case 28: 
          { // System.out.println(yytext() + "\t" + "NEQ_KW\t" + '-');
	return YYParser.NEQ_KW;
          }
        case 84: break;
        case 29: 
          { // System.out.println(yytext() + "\t" + "GTE_KW\t" + '-');
	return YYParser.GTE_KW;
          }
        case 85: break;
        case 30: 
          { // System.out.println(yytext() + "\t" + "DOUBLE_DOT_KW\t" + '-');
	return YYParser.DOUBLE_DOT_KW;
          }
        case 86: break;
        case 31: 
          { // System.out.println(yytext() + "\t" + "NUMCONSTANT\t" + '-');
	return YYParser.NUMCONSTANT;
          }
        case 87: break;
        case 32: 
          { // System.out.println(yytext() + "\t" + "AND_KW\t" + '-');
	return YYParser.AND_KW;
          }
        case 88: break;
        case 33: 
          { // System.out.println(yytext() + "\t" + "INTEGER_KW\t" + '-');
	return YYParser.INTEGER_KW;
          }
        case 89: break;
        case 34: 
          { // System.out.println(yytext() + "\t" + "NOT_KW\t" + '-');
	return YYParser.NOT_KW;
          }
        case 90: break;
        case 35: 
          { // System.out.println(yytext() + "\t" + "END_KW\t" + '-');
	return YYParser.END_KW;
          }
        case 91: break;
        case 36: 
          { // System.out.println(yytext() + "\t" + "FOR_KW\t" + '-');
	return YYParser.FOR_KW;
          }
        case 92: break;
        case 37: 
          { // System.out.println(yytext() + "\t" + "CHARCONST\t" + '-');
	return YYParser.CHARCONST;
          }
        case 93: break;
        case 38: 
          { // System.out.println(yytext() + "\t" + "REAL_KW\t" + '-');
	return YYParser.REAL_KW;
          }
        case 94: break;
        case 39: 
          { // System.out.println(yytext() + "\t" + "MAIN_KW\t" + '-');
	return YYParser.MAIN_KW;
          }
        case 95: break;
        case 40: 
          { // System.out.println(yytext() + "\t" + "BOOLCONST\t" + '-');
	return YYParser.BOOLCONST;
          }
        case 96: break;
        case 41: 
          { // System.out.println(yytext() + "\t" + "THEN_KW\t" + '-');
	return YYParser.THEN_KW;
          }
        case 97: break;
        case 42: 
          { // System.out.println(yytext() + "\t" + "ELSE_KW\t" + '-');
	return YYParser.ELSE_KW;
          }
        case 98: break;
        case 43: 
          { // System.out.println(yytext() + "\t" + "EXIT_KW\t" + '-');
	return YYParser.EXIT_KW;
          }
        case 99: break;
        case 44: 
          { // System.out.println(yytext() + "\t" + "CASE_KW\t" + '-');
	return YYParser.CASE_KW;
          }
        case 100: break;
        case 45: 
          { // System.out.println(yytext() + "\t" + "CHARACTER_KW\t" + '-');
	return YYParser.CHARACTER_KW;
          }
        case 101: break;
        case 46: 
          { // System.out.println(yytext() + "\t" + "BOOLEAN_KW\t" + '-');
	return YYParser.BOOLEAN_KW;
          }
        case 102: break;
        case 47: 
          { // System.out.println(yytext() + "\t" + "UPTO_KW\t" + '-');
	return YYParser.UPTO_KW;
          }
        case 103: break;
        case 48: 
          { // System.out.println(yytext() + "\t" + "WHEN_KW\t" + '-');
	return YYParser.WHEN_KW;
          }
        case 104: break;
        case 49: 
          { // System.out.println(yytext() + "\t" + "REALCONST\t" + '-');
	return YYParser.REALCONST;
          }
        case 105: break;
        case 50: 
          { // System.out.println(yytext() + "\t" + "WHILE_KW\t" + '-');
	return YYParser.WHILE_KW;
          }
        case 106: break;
        case 51: 
          { // System.out.println(yytext() + "\t" + "RETURN_KW\t" + '-');
	return YYParser.RETURN_KW;
          }
        case 107: break;
        case 52: 
          { // System.out.println(yytext() + "\t" + "DOWNTO_KW\t" + '-');
	return YYParser.DOWNTO_KW;
          }
        case 108: break;
        case 53: 
          { // System.out.println(yytext() + "\t" + "SWITCH_KW\t" + '-');
	return YYParser.SWITCH_KW;
          }
        case 109: break;
        case 54: 
          { // System.out.println(yytext() + "\t" + "PROGRAM_KW\t" + '-');
	return YYParser.PROGRAM_KW;
          }
        case 110: break;
        case 55: 
          { // System.out.println(yytext() + "\t" + "DEFAULT_KW\t" + '-');
	return YYParser.DEFAULT_KW;
          }
        case 111: break;
        case 56: 
          { // System.out.println(yytext() + "\t" + "PROCEDURE_KW\t" + '-');
	return YYParser.PROCEDURE_KW;
          }
        case 112: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return 0; }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
