/* The following code was generated by JFlex 1.6.0 */

package tp.compiladores;

import java_cup.runtime.Symbol; 


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.6.0
 * from the specification file <tt>/home/adrian/NetBeansProjects/CTDS/TP-Compiladores-Final/src/tp/compiladores/CTDS.l</tt>
 */
public class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  public static final int CHARLITERAL = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  6, 48, 49,  5,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0, 13,  9,  0,  0, 14, 19, 10, 27, 28,  8, 15, 22, 12,  4,  7, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0, 21, 16, 18, 17,  0, 
     0,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 
     2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  2, 25, 11, 26,  0,  3, 
     0, 41, 44, 46, 38, 36, 30,  2, 43, 29,  2, 45, 39,  2, 33, 31, 
     2,  2, 32, 40, 34, 35, 37, 42, 47,  2,  2, 23, 20, 24,  0,  0, 
     0,  0,  0,  0,  0, 48,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\2\1\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\11\3\1\30\1\31\1\1\1\0\1\32\1\0"+
    "\1\33\1\34\1\35\16\3\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\2\32\2\0"+
    "\1\50\1\51\14\3\1\0\3\3\1\52\1\53\1\3"+
    "\1\54\5\3\1\55\1\56\2\3\1\57\1\3\1\60"+
    "\1\3\1\61\1\62\4\3\1\63\2\3\1\64\1\3"+
    "\1\65";

  private static int [] zzUnpackAction() {
    int [] result = new int[121];
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
    "\0\0\0\62\0\144\0\226\0\310\0\372\0\226\0\u012c"+
    "\0\226\0\226\0\226\0\226\0\226\0\226\0\226\0\226"+
    "\0\226\0\226\0\u015e\0\u0190\0\226\0\226\0\226\0\226"+
    "\0\226\0\226\0\226\0\226\0\u01c2\0\u01f4\0\u0226\0\u0258"+
    "\0\u028a\0\u02bc\0\u02ee\0\u0320\0\u0352\0\u0384\0\226\0\u03b6"+
    "\0\u03e8\0\u041a\0\u044c\0\226\0\226\0\372\0\u047e\0\u04b0"+
    "\0\u04e2\0\u0514\0\u0546\0\u0578\0\u05aa\0\u05dc\0\u060e\0\u0640"+
    "\0\u0672\0\u06a4\0\u06d6\0\u0708\0\226\0\226\0\226\0\226"+
    "\0\226\0\226\0\226\0\226\0\226\0\u03e8\0\u073a\0\226"+
    "\0\u076c\0\u079e\0\372\0\372\0\u07d0\0\u0802\0\u0834\0\u0866"+
    "\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\u0992\0\u09c4\0\u09f6"+
    "\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\372\0\372\0\u0af0\0\372"+
    "\0\u0b22\0\u0b54\0\u0b86\0\u0bb8\0\u0bea\0\372\0\372\0\u0c1c"+
    "\0\u0c4e\0\372\0\u0c80\0\372\0\u0cb2\0\372\0\372\0\u0ce4"+
    "\0\u0d16\0\u0d48\0\u0d7a\0\372\0\u0dac\0\u0dde\0\372\0\u0e10"+
    "\0\372";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[121];
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
    "\1\4\1\5\1\6\2\4\2\7\1\10\1\11\1\12"+
    "\1\13\1\4\1\14\1\15\1\16\1\17\1\20\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\6\1\37\1\6"+
    "\1\40\1\6\1\41\1\42\4\6\1\43\1\6\1\44"+
    "\1\6\1\45\1\6\1\7\1\4\5\46\2\7\2\46"+
    "\1\47\1\46\1\50\46\46\5\4\2\7\51\4\2\7"+
    "\63\0\1\5\2\0\1\51\56\0\3\6\31\0\23\6"+
    "\11\0\1\52\1\53\74\0\1\54\62\0\1\55\36\0"+
    "\3\6\31\0\1\6\1\56\2\6\1\57\16\6\3\0"+
    "\3\6\31\0\2\6\1\60\7\6\1\61\1\6\1\62"+
    "\6\6\3\0\3\6\31\0\7\6\1\63\13\6\3\0"+
    "\3\6\31\0\3\6\1\64\17\6\3\0\3\6\31\0"+
    "\12\6\1\65\7\6\1\66\3\0\3\6\31\0\2\6"+
    "\1\67\20\6\3\0\3\6\31\0\16\6\1\70\4\6"+
    "\3\0\3\6\31\0\2\6\1\71\1\72\17\6\3\0"+
    "\3\6\31\0\2\6\1\73\7\6\1\74\10\6\2\0"+
    "\5\46\2\0\2\46\1\0\1\46\1\0\46\46\5\75"+
    "\2\0\2\75\1\76\1\77\1\100\22\75\1\101\1\75"+
    "\1\102\1\103\1\104\11\75\1\105\3\75\3\0\1\106"+
    "\60\0\5\52\1\107\1\110\53\52\10\111\1\112\51\111"+
    "\1\0\3\6\31\0\5\6\1\113\15\6\3\0\3\6"+
    "\31\0\3\6\1\114\17\6\3\0\3\6\31\0\2\6"+
    "\1\115\20\6\3\0\3\6\31\0\12\6\1\116\10\6"+
    "\3\0\3\6\31\0\5\6\1\117\15\6\3\0\3\6"+
    "\31\0\6\6\1\120\14\6\3\0\3\6\31\0\13\6"+
    "\1\121\7\6\3\0\3\6\31\0\5\6\1\122\15\6"+
    "\3\0\3\6\31\0\1\123\22\6\3\0\3\6\31\0"+
    "\1\124\22\6\3\0\3\6\31\0\2\6\1\125\20\6"+
    "\3\0\3\6\31\0\7\6\1\126\13\6\3\0\3\6"+
    "\31\0\4\6\1\127\16\6\3\0\3\6\31\0\14\6"+
    "\1\130\6\6\10\0\1\110\53\0\10\111\1\131\51\111"+
    "\7\0\1\110\1\112\52\0\3\6\31\0\14\6\1\132"+
    "\6\6\3\0\3\6\31\0\13\6\1\133\7\6\3\0"+
    "\3\6\31\0\6\6\1\134\14\6\3\0\3\6\31\0"+
    "\7\6\1\135\13\6\3\0\3\6\31\0\7\6\1\136"+
    "\13\6\3\0\3\6\31\0\7\6\1\137\13\6\3\0"+
    "\3\6\31\0\11\6\1\140\11\6\3\0\3\6\31\0"+
    "\12\6\1\141\10\6\3\0\3\6\31\0\12\6\1\142"+
    "\10\6\3\0\3\6\31\0\14\6\1\143\6\6\3\0"+
    "\3\6\31\0\5\6\1\144\15\6\3\0\3\6\31\0"+
    "\13\6\1\145\7\6\2\0\7\111\1\110\1\131\51\111"+
    "\1\0\3\6\31\0\5\6\1\146\15\6\3\0\3\6"+
    "\31\0\7\6\1\147\13\6\3\0\3\6\31\0\3\6"+
    "\1\150\17\6\3\0\3\6\31\0\3\6\1\151\17\6"+
    "\3\0\3\6\31\0\7\6\1\152\13\6\3\0\3\6"+
    "\31\0\7\6\1\153\13\6\3\0\3\6\31\0\20\6"+
    "\1\154\2\6\3\0\3\6\31\0\1\155\22\6\3\0"+
    "\3\6\31\0\13\6\1\156\7\6\3\0\3\6\31\0"+
    "\4\6\1\157\16\6\3\0\3\6\31\0\4\6\1\160"+
    "\16\6\3\0\3\6\31\0\14\6\1\161\6\6\3\0"+
    "\3\6\31\0\4\6\1\162\16\6\3\0\3\6\31\0"+
    "\1\163\22\6\3\0\3\6\31\0\4\6\1\164\16\6"+
    "\3\0\3\6\31\0\6\6\1\165\14\6\3\0\3\6"+
    "\31\0\4\6\1\166\16\6\3\0\3\6\31\0\7\6"+
    "\1\167\13\6\3\0\3\6\31\0\10\6\1\170\12\6"+
    "\3\0\3\6\31\0\20\6\1\171\2\6\2\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3650];
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
    "\3\0\1\11\2\1\1\11\1\1\12\11\2\1\10\11"+
    "\12\1\1\11\1\1\1\0\1\1\1\0\2\11\17\1"+
    "\11\11\2\1\1\11\2\0\16\1\1\0\40\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[121];
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

  /* user code: */
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
   private void symbol(String s) {
    System.out.println(s);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Yylex(java.io.Reader in) {
    this.zzReader = in;
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
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
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

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
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
          { /*Ignore*/
          }
        case 54: break;
        case 2: 
          { return symbol(sym.INTEGER, new Integer(yytext()));
          }
        case 55: break;
        case 3: 
          { return symbol(sym.ID,new String(yytext()));
          }
        case 56: break;
        case 4: 
          { System.out.print(yytext());
          }
        case 57: break;
        case 5: 
          { return symbol(sym.DIVISION);
          }
        case 58: break;
        case 6: 
          { return symbol(sym.MULTIPLICACION);
          }
        case 59: break;
        case 7: 
          { yybegin(STRING); string.setLength(0);
          }
        case 60: break;
        case 8: 
          { yybegin(CHARLITERAL);
          }
        case 61: break;
        case 9: 
          { return symbol(sym.MENOS);
          }
        case 62: break;
        case 10: 
          { return symbol(sym.ADMIRACION);
          }
        case 63: break;
        case 11: 
          { return symbol(sym.DIVENTERA);
          }
        case 64: break;
        case 12: 
          { return symbol(sym.SUMA);
          }
        case 65: break;
        case 13: 
          { return symbol(sym.MENOR);
          }
        case 66: break;
        case 14: 
          { return symbol(sym.MAYOR);
          }
        case 67: break;
        case 15: 
          { return symbol(sym.IGUAL);
          }
        case 68: break;
        case 16: 
          { return symbol(sym.PUNTOYCOMA);
          }
        case 69: break;
        case 17: 
          { return symbol(sym.COMA);
          }
        case 70: break;
        case 18: 
          { return symbol(sym.LLLAVE);
          }
        case 71: break;
        case 19: 
          { return symbol(sym.RLLAVE);
          }
        case 72: break;
        case 20: 
          { return symbol(sym.LCORCHETE);
          }
        case 73: break;
        case 21: 
          { return symbol(sym.RCORCHETE);
          }
        case 74: break;
        case 22: 
          { return symbol(sym.LPARENTESIS);
          }
        case 75: break;
        case 23: 
          { return symbol(sym.RPARENTESIS);
          }
        case 76: break;
        case 24: 
          { string.append( yytext() );
          }
        case 77: break;
        case 25: 
          { yybegin(YYINITIAL); return symbol(sym.STRING, new String(string.toString()));
          }
        case 78: break;
        case 26: 
          { /*Ignore*/;
          }
        case 79: break;
        case 27: 
          { return symbol(sym.CONJUNCION);
          }
        case 80: break;
        case 28: 
          { return symbol(sym.DISYUNCION);
          }
        case 81: break;
        case 29: 
          { return symbol(sym.IF);
          }
        case 82: break;
        case 30: 
          { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\"");
          }
        case 83: break;
        case 31: 
          { string.append( '\"' );
          }
        case 84: break;
        case 32: 
          { string.append( '\'' );
          }
        case 85: break;
        case 33: 
          { string.append( '\\' );
          }
        case 86: break;
        case 34: 
          { string.append( '\f' );
          }
        case 87: break;
        case 35: 
          { string.append( '\r' );
          }
        case 88: break;
        case 36: 
          { string.append( '\n' );
          }
        case 89: break;
        case 37: 
          { string.append( '\t' );
          }
        case 90: break;
        case 38: 
          { string.append( '\b' );
          }
        case 91: break;
        case 39: 
          { return symbol(sym.FLOAT, new Float(yytext()));
          }
        case 92: break;
        case 40: 
          { return symbol(sym.INT);
          }
        case 93: break;
        case 41: 
          { return symbol(sym.FOR);
          }
        case 94: break;
        case 42: 
          { return symbol(sym.TRUE);
          }
        case 95: break;
        case 43: 
          { return symbol(sym.ELSE);
          }
        case 96: break;
        case 44: 
          { return symbol(sym.VOID);
          }
        case 97: break;
        case 45: 
          { return symbol(sym.FLT);
          }
        case 98: break;
        case 46: 
          { return symbol(sym.FALSE);
          }
        case 99: break;
        case 47: 
          { return symbol(sym.WHILE);
          }
        case 100: break;
        case 48: 
          { return symbol(sym.BREAK);
          }
        case 101: break;
        case 49: 
          { return symbol(sym.CLASS);
          }
        case 102: break;
        case 50: 
          { return symbol(sym.RETURN);
          }
        case 103: break;
        case 51: 
          { return symbol(sym.BOOLEAN);
          }
        case 104: break;
        case 52: 
          { return symbol(sym.CONTINUE);
          }
        case 105: break;
        case 53: 
          { return symbol(sym.EXTERNINVK);
          }
        case 106: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java Yylex [ --encoding <name> ] <inputfile(s)>");
    }
    else {
      int firstFilePos = 0;
      String encodingName = "UTF-8";
      if (argv[0].equals("--encoding")) {
        firstFilePos = 2;
        encodingName = argv[1];
        try {
          java.nio.charset.Charset.forName(encodingName); // Side-effect: is encodingName valid? 
        } catch (Exception e) {
          System.out.println("Invalid encoding '" + encodingName + "'");
          return;
        }
      }
      for (int i = firstFilePos; i < argv.length; i++) {
        Yylex scanner = null;
        try {
          java.io.FileInputStream stream = new java.io.FileInputStream(argv[i]);
          java.io.Reader reader = new java.io.InputStreamReader(stream, encodingName);
          scanner = new Yylex(reader);
          while ( !scanner.zzAtEOF ) scanner.next_token();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}
