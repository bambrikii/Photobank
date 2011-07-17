// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g 2011-07-10 00:14:31

  package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ArmenianParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WORD", "WS", "','", "'.'"
    };
    public static final int EOF=-1;
    public static final int T__6=6;
    public static final int T__7=7;
    public static final int WORD=4;
    public static final int WS=5;

    // delegates
    // delegators


        public ArmenianParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ArmenianParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ArmenianParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g"; }



    // $ANTLR start "sentence"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:1: sentence : ( phrase | WORD )+ ( ',' ( phrase | WORD )+ )? '.' ;
    public final void sentence() throws RecognitionException {
        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:9: ( ( phrase | WORD )+ ( ',' ( phrase | WORD )+ )? '.' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:11: ( phrase | WORD )+ ( ',' ( phrase | WORD )+ )? '.'
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:11: ( phrase | WORD )+
            int cnt1=0;
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WORD) ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2==WS) ) {
                        alt1=1;
                    }
                    else if ( (LA1_2==WORD||(LA1_2>=6 && LA1_2<=7)) ) {
                        alt1=2;
                    }


                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:12: phrase
            	    {
            	    pushFollow(FOLLOW_phrase_in_sentence42);
            	    phrase();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:21: WORD
            	    {
            	    match(input,WORD,FOLLOW_WORD_in_sentence46); 

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

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:29: ( ',' ( phrase | WORD )+ )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==6) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:30: ',' ( phrase | WORD )+
                    {
                    match(input,6,FOLLOW_6_in_sentence52); 
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:34: ( phrase | WORD )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=3;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WORD) ) {
                            int LA2_2 = input.LA(2);

                            if ( (LA2_2==WS) ) {
                                alt2=1;
                            }
                            else if ( (LA2_2==WORD||LA2_2==7) ) {
                                alt2=2;
                            }


                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:35: phrase
                    	    {
                    	    pushFollow(FOLLOW_phrase_in_sentence55);
                    	    phrase();

                    	    state._fsp--;


                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:15:44: WORD
                    	    {
                    	    match(input,WORD,FOLLOW_WORD_in_sentence59); 

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


                    }
                    break;

            }

            match(input,7,FOLLOW_7_in_sentence65); 

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
    // $ANTLR end "sentence"


    // $ANTLR start "phrase"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:17:1: phrase : WORD ( WS WORD )+ ;
    public final void phrase() throws RecognitionException {
        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:17:7: ( WORD ( WS WORD )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:17:9: WORD ( WS WORD )+
            {
            match(input,WORD,FOLLOW_WORD_in_phrase72); 
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:17:14: ( WS WORD )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==WS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\Armenian.g:17:15: WS WORD
            	    {
            	    match(input,WS,FOLLOW_WS_in_phrase75); 
            	    match(input,WORD,FOLLOW_WORD_in_phrase77); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


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
    // $ANTLR end "phrase"

    // Delegated rules


 

    public static final BitSet FOLLOW_phrase_in_sentence42 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_WORD_in_sentence46 = new BitSet(new long[]{0x00000000000000D0L});
    public static final BitSet FOLLOW_6_in_sentence52 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_phrase_in_sentence55 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_WORD_in_sentence59 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_7_in_sentence65 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WORD_in_phrase72 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_WS_in_phrase75 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WORD_in_phrase77 = new BitSet(new long[]{0x0000000000000022L});

}