// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g 2011-07-10 00:14:32

  package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class TParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "WS", "'int'", "'='", "';'", "'public'", "'static'"
    };
    public static final int EOF=-1;
    public static final int T__7=7;
    public static final int T__8=8;
    public static final int T__9=9;
    public static final int T__10=10;
    public static final int T__11=11;
    public static final int ID=4;
    public static final int INT=5;
    public static final int WS=6;

    // delegates
    // delegators


        public TParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public TParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return TParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g"; }



    // $ANTLR start "def"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:10:1: def : ( ( modifier )+ 'int' ID '=' INT ';' | ( modifier )+ 'int' ID ';' );
    public final void def() throws RecognitionException {
        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:10:5: ( ( modifier )+ 'int' ID '=' INT ';' | ( modifier )+ 'int' ID ';' )
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:10:7: ( modifier )+ 'int' ID '=' INT ';'
                    {
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:10:7: ( modifier )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0>=10 && LA1_0<=11)) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:10:7: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_def27);
                    	    modifier();

                    	    state._fsp--;


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

                    match(input,7,FOLLOW_7_in_def30); 
                    match(input,ID,FOLLOW_ID_in_def32); 
                    match(input,8,FOLLOW_8_in_def34); 
                    match(input,INT,FOLLOW_INT_in_def36); 
                    match(input,9,FOLLOW_9_in_def38); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:11:7: ( modifier )+ 'int' ID ';'
                    {
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:11:7: ( modifier )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0>=10 && LA2_0<=11)) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:11:7: modifier
                    	    {
                    	    pushFollow(FOLLOW_modifier_in_def46);
                    	    modifier();

                    	    state._fsp--;


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

                    match(input,7,FOLLOW_7_in_def49); 
                    match(input,ID,FOLLOW_ID_in_def51); 
                    match(input,9,FOLLOW_9_in_def53); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "def"


    // $ANTLR start "modifier"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:13:1: modifier : ( 'public' | 'static' );
    public final void modifier() throws RecognitionException {
        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:13:10: ( 'public' | 'static' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T.g:
            {
            if ( (input.LA(1)>=10 && input.LA(1)<=11) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "modifier"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\6\uffff";
    static final String DFA3_eofS =
        "\6\uffff";
    static final String DFA3_minS =
        "\1\12\1\7\1\4\1\10\2\uffff";
    static final String DFA3_maxS =
        "\2\13\1\4\1\11\2\uffff";
    static final String DFA3_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA3_specialS =
        "\6\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\1",
            "\1\2\2\uffff\2\1",
            "\1\3",
            "\1\4\1\5",
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
            return "10:1: def : ( ( modifier )+ 'int' ID '=' INT ';' | ( modifier )+ 'int' ID ';' );";
        }
    }
 

    public static final BitSet FOLLOW_modifier_in_def27 = new BitSet(new long[]{0x0000000000000C80L});
    public static final BitSet FOLLOW_7_in_def30 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_def32 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_8_in_def34 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_INT_in_def36 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_def38 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_modifier_in_def46 = new BitSet(new long[]{0x0000000000000C80L});
    public static final BitSet FOLLOW_7_in_def49 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ID_in_def51 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_9_in_def53 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_modifier0 = new BitSet(new long[]{0x0000000000000002L});

}