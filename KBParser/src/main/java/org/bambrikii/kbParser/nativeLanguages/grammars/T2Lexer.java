// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g 2011-07-10 00:14:33

package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class T2Lexer extends Lexer {
    public static final int EOF=-1;
    public static final int SPACE=4;
    public static final int NEW_LINE=5;
    public static final int DOT=6;
    public static final int QUESTION=7;
    public static final int EXCLAIMATION=8;
    public static final int COMMA=9;
    public static final int SEMICOLON=10;
    public static final int DASH=11;
    public static final int WORD=12;
    public static final int DIGIT=13;

    // delegates
    // delegators

    public T2Lexer() {;} 
    public T2Lexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public T2Lexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g"; }

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:88:7: ( '0' .. '9' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:89:2: '0' .. '9'
            {
            matchRange('0','9'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:91:6: ( ( 'a' .. 'z' | 'A' .. 'Z' )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:92:2: ( 'a' .. 'z' | 'A' .. 'Z' )+
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:92:2: ( 'a' .. 'z' | 'A' .. 'Z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='A' && LA1_0<='Z')||(LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:
            	    {
            	    if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "EXCLAIMATION"
    public final void mEXCLAIMATION() throws RecognitionException {
        try {
            int _type = EXCLAIMATION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:97:14: ( '!' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:98:2: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCLAIMATION"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:100:10: ( '?' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:101:2: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:103:5: ( '.' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:104:2: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:106:7: ( ',' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:107:2: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMICOLON"
    public final void mSEMICOLON() throws RecognitionException {
        try {
            int _type = SEMICOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:109:11: ( ';' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:110:2: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SEMICOLON"

    // $ANTLR start "DASH"
    public final void mDASH() throws RecognitionException {
        try {
            int _type = DASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:112:6: ( '-' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:113:2: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DASH"

    // $ANTLR start "SPACE"
    public final void mSPACE() throws RecognitionException {
        try {
            int _type = SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:115:7: ( ' ' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:116:2: ' '
            {
            match(' '); 

                  _channel = HIDDEN;
                 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SPACE"

    // $ANTLR start "NEW_LINE"
    public final void mNEW_LINE() throws RecognitionException {
        try {
            int _type = NEW_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:121:10: ( ( | '\\r' | '\\n' ) )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:122:2: ( | '\\r' | '\\n' )
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:122:2: ( | '\\r' | '\\n' )
            int alt2=3;
            switch ( input.LA(1) ) {
            case '\r':
                {
                alt2=2;
                }
                break;
            case '\n':
                {
                alt2=3;
                }
                break;
            default:
                alt2=1;}

            switch (alt2) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:123:3: 
                    {
                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:123:5: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:124:5: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


               _channel = HIDDEN;
              

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEW_LINE"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:8: ( DIGIT | WORD | EXCLAIMATION | QUESTION | DOT | COMMA | SEMICOLON | DASH | SPACE | NEW_LINE )
        int alt3=10;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:10: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 2 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:16: WORD
                {
                mWORD(); 

                }
                break;
            case 3 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:21: EXCLAIMATION
                {
                mEXCLAIMATION(); 

                }
                break;
            case 4 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:34: QUESTION
                {
                mQUESTION(); 

                }
                break;
            case 5 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:43: DOT
                {
                mDOT(); 

                }
                break;
            case 6 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:47: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 7 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:53: SEMICOLON
                {
                mSEMICOLON(); 

                }
                break;
            case 8 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:63: DASH
                {
                mDASH(); 

                }
                break;
            case 9 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:68: SPACE
                {
                mSPACE(); 

                }
                break;
            case 10 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:1:74: NEW_LINE
                {
                mNEW_LINE(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\1\12\12\uffff";
    static final String DFA3_eofS =
        "\13\uffff";
    static final String DFA3_minS =
        "\1\40\12\uffff";
    static final String DFA3_maxS =
        "\1\172\12\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String DFA3_specialS =
        "\13\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\11\1\3\12\uffff\1\6\1\10\1\5\1\uffff\12\1\1\uffff\1\7\3"+
            "\uffff\1\4\1\uffff\32\2\6\uffff\32\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( DIGIT | WORD | EXCLAIMATION | QUESTION | DOT | COMMA | SEMICOLON | DASH | SPACE | NEW_LINE );";
        }
    }
 

}