// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g 2011-07-10 00:14:31

  package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ArmenianLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int WORD=4;
    public static final int WS=5;

    // delegates
    // delegators

    public ArmenianLexer() {;} 
    public ArmenianLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ArmenianLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g"; }

    // $ANTLR start "T__6"
    public final void mT__6() throws RecognitionException {
        try {
            int _type = T__6;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:11:6: ( ',' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:11:8: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__6"

    // $ANTLR start "T__7"
    public final void mT__7() throws RecognitionException {
        try {
            int _type = T__7;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:12:6: ( '.' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:12:8: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__7"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            int _type = WORD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:19:6: ( ( 'a' .. 'z' )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:19:8: ( 'a' .. 'z' )+
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:19:8: ( 'a' .. 'z' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='a' && LA1_0<='z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:19:8: 'a' .. 'z'
            	    {
            	    matchRange('a','z'); 

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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:20:4: ( ( ' ' )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:20:6: ( ' ' )+
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:20:6: ( ' ' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:20:6: ' '
            	    {
            	    match(' '); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:1:8: ( T__6 | T__7 | WORD | WS )
        int alt3=4;
        switch ( input.LA(1) ) {
        case ',':
            {
            alt3=1;
            }
            break;
        case '.':
            {
            alt3=2;
            }
            break;
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':
            {
            alt3=3;
            }
            break;
        case ' ':
            {
            alt3=4;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 3, 0, input);

            throw nvae;
        }

        switch (alt3) {
            case 1 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:1:10: T__6
                {
                mT__6(); 

                }
                break;
            case 2 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:1:15: T__7
                {
                mT__7(); 

                }
                break;
            case 3 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:1:20: WORD
                {
                mWORD(); 

                }
                break;
            case 4 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:1:25: WS
                {
                mWS(); 

                }
                break;

        }

    }


 

}