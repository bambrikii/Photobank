// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g 2011-07-10 00:14:33

  package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class EnglishParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "WORD", "NUMBER", "DOT", "QUESTION", "EXCLAMATION", "COMMA", "COLON", "SEMICOLON", "LETTER", "DASH", "APOSTROPHE", "'\\n'", "'('", "')'"
    };
    public static final int EOF=-1;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int WS=4;
    public static final int WORD=5;
    public static final int NUMBER=6;
    public static final int DOT=7;
    public static final int QUESTION=8;
    public static final int EXCLAMATION=9;
    public static final int COMMA=10;
    public static final int COLON=11;
    public static final int SEMICOLON=12;
    public static final int LETTER=13;
    public static final int DASH=14;
    public static final int APOSTROPHE=15;

    // delegates
    // delegators


        public EnglishParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EnglishParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EnglishParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g"; }


    public static class article_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "article"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:19:1: article : header ( paragraph )+ ;
    public final EnglishParser.article_return article() throws RecognitionException {
        EnglishParser.article_return retval = new EnglishParser.article_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        EnglishParser.header_return header1 = null;

        EnglishParser.paragraph_return paragraph2 = null;



        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:19:8: ( header ( paragraph )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:19:10: header ( paragraph )+
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_header_in_article51);
            header1=header();

            state._fsp--;

            adaptor.addChild(root_0, header1.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:19:17: ( paragraph )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==16) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:19:17: paragraph
            	    {
            	    pushFollow(FOLLOW_paragraph_in_article53);
            	    paragraph2=paragraph();

            	    state._fsp--;

            	    adaptor.addChild(root_0, paragraph2.getTree());

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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "article"

    public static class paragraph_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "paragraph"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:20:1: paragraph : '\\n' ( sentence )+ ;
    public final EnglishParser.paragraph_return paragraph() throws RecognitionException {
        EnglishParser.paragraph_return retval = new EnglishParser.paragraph_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal3=null;
        EnglishParser.sentence_return sentence4 = null;


        Object char_literal3_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:20:10: ( '\\n' ( sentence )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:20:13: '\\n' ( sentence )+
            {
            root_0 = (Object)adaptor.nil();

            char_literal3=(Token)match(input,16,FOLLOW_16_in_paragraph61); 
            char_literal3_tree = (Object)adaptor.create(char_literal3);
            adaptor.addChild(root_0, char_literal3_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:20:18: ( sentence )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=WORD && LA2_0<=NUMBER)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:20:18: sentence
            	    {
            	    pushFollow(FOLLOW_sentence_in_paragraph63);
            	    sentence4=sentence();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sentence4.getTree());

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

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "paragraph"

    public static class header_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "header"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:1: header : ( phrase | any_word )+ ( ',' ( phrase | any_word )+ )* ;
    public final EnglishParser.header_return header() throws RecognitionException {
        EnglishParser.header_return retval = new EnglishParser.header_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal7=null;
        EnglishParser.phrase_return phrase5 = null;

        EnglishParser.any_word_return any_word6 = null;

        EnglishParser.phrase_return phrase8 = null;

        EnglishParser.any_word_return any_word9 = null;


        Object char_literal7_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:8: ( ( phrase | any_word )+ ( ',' ( phrase | any_word )+ )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:10: ( phrase | any_word )+ ( ',' ( phrase | any_word )+ )*
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:10: ( phrase | any_word )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=WORD && LA3_0<=NUMBER)) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==WS) ) {
                        alt3=1;
                    }
                    else if ( ((LA3_2>=WORD && LA3_2<=NUMBER)||LA3_2==COMMA||LA3_2==16) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:11: phrase
            	    {
            	    pushFollow(FOLLOW_phrase_in_header72);
            	    phrase5=phrase();

            	    state._fsp--;

            	    adaptor.addChild(root_0, phrase5.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:20: any_word
            	    {
            	    pushFollow(FOLLOW_any_word_in_header76);
            	    any_word6=any_word();

            	    state._fsp--;

            	    adaptor.addChild(root_0, any_word6.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:32: ( ',' ( phrase | any_word )+ )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==COMMA) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:33: ',' ( phrase | any_word )+
            	    {
            	    char_literal7=(Token)match(input,COMMA,FOLLOW_COMMA_in_header82); 
            	    char_literal7_tree = (Object)adaptor.create(char_literal7);
            	    adaptor.addChild(root_0, char_literal7_tree);

            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:37: ( phrase | any_word )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=3;
            	        int LA4_0 = input.LA(1);

            	        if ( ((LA4_0>=WORD && LA4_0<=NUMBER)) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( (LA4_2==WS) ) {
            	                alt4=1;
            	            }
            	            else if ( ((LA4_2>=WORD && LA4_2<=NUMBER)||LA4_2==COMMA||LA4_2==16) ) {
            	                alt4=2;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:38: phrase
            	    	    {
            	    	    pushFollow(FOLLOW_phrase_in_header85);
            	    	    phrase8=phrase();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, phrase8.getTree());

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:21:47: any_word
            	    	    {
            	    	    pushFollow(FOLLOW_any_word_in_header89);
            	    	    any_word9=any_word();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, any_word9.getTree());

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
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "header"

    public static class phrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "phrase"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:1: phrase : ( any_word ) ( WS any_word )+ ;
    public final EnglishParser.phrase_return phrase() throws RecognitionException {
        EnglishParser.phrase_return retval = new EnglishParser.phrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WS11=null;
        EnglishParser.any_word_return any_word10 = null;

        EnglishParser.any_word_return any_word12 = null;


        Object WS11_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:7: ( ( any_word ) ( WS any_word )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:9: ( any_word ) ( WS any_word )+
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:9: ( any_word )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:10: any_word
            {
            pushFollow(FOLLOW_any_word_in_phrase101);
            any_word10=any_word();

            state._fsp--;

            adaptor.addChild(root_0, any_word10.getTree());

            }

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:20: ( WS any_word )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==WS) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:23:21: WS any_word
            	    {
            	    WS11=(Token)match(input,WS,FOLLOW_WS_in_phrase105); 
            	    WS11_tree = (Object)adaptor.create(WS11);
            	    adaptor.addChild(root_0, WS11_tree);

            	    pushFollow(FOLLOW_any_word_in_phrase107);
            	    any_word12=any_word();

            	    state._fsp--;

            	    adaptor.addChild(root_0, any_word12.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "phrase"

    public static class any_word_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "any_word"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:24:1: any_word : ( WORD | NUMBER ) ;
    public final EnglishParser.any_word_return any_word() throws RecognitionException {
        EnglishParser.any_word_return retval = new EnglishParser.any_word_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set13=null;

        Object set13_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:24:10: ( ( WORD | NUMBER ) )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:24:12: ( WORD | NUMBER )
            {
            root_0 = (Object)adaptor.nil();

            set13=(Token)input.LT(1);
            if ( (input.LA(1)>=WORD && input.LA(1)<=NUMBER) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set13));
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "any_word"

    public static class sentence_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentence"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:26:1: sentence : ( assertion | question | exclamation );
    public final EnglishParser.sentence_return sentence() throws RecognitionException {
        EnglishParser.sentence_return retval = new EnglishParser.sentence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        EnglishParser.assertion_return assertion14 = null;

        EnglishParser.question_return question15 = null;

        EnglishParser.exclamation_return exclamation16 = null;



        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:26:9: ( assertion | question | exclamation )
            int alt7=3;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:26:11: assertion
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_assertion_in_sentence130);
                    assertion14=assertion();

                    state._fsp--;

                    adaptor.addChild(root_0, assertion14.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:26:23: question
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_question_in_sentence134);
                    question15=question();

                    state._fsp--;

                    adaptor.addChild(root_0, question15.getTree());

                    }
                    break;
                case 3 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:26:34: exclamation
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_exclamation_in_sentence138);
                    exclamation16=exclamation();

                    state._fsp--;

                    adaptor.addChild(root_0, exclamation16.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentence"

    public static class assertion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assertion"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:28:1: assertion : sentence_body DOT ;
    public final EnglishParser.assertion_return assertion() throws RecognitionException {
        EnglishParser.assertion_return retval = new EnglishParser.assertion_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token DOT18=null;
        EnglishParser.sentence_body_return sentence_body17 = null;


        Object DOT18_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:28:10: ( sentence_body DOT )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:28:12: sentence_body DOT
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sentence_body_in_assertion145);
            sentence_body17=sentence_body();

            state._fsp--;

            adaptor.addChild(root_0, sentence_body17.getTree());
            DOT18=(Token)match(input,DOT,FOLLOW_DOT_in_assertion147); 
            DOT18_tree = (Object)adaptor.create(DOT18);
            adaptor.addChild(root_0, DOT18_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assertion"

    public static class question_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "question"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:29:1: question : sentence_body QUESTION ;
    public final EnglishParser.question_return question() throws RecognitionException {
        EnglishParser.question_return retval = new EnglishParser.question_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token QUESTION20=null;
        EnglishParser.sentence_body_return sentence_body19 = null;


        Object QUESTION20_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:29:9: ( sentence_body QUESTION )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:29:11: sentence_body QUESTION
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sentence_body_in_question153);
            sentence_body19=sentence_body();

            state._fsp--;

            adaptor.addChild(root_0, sentence_body19.getTree());
            QUESTION20=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_question155); 
            QUESTION20_tree = (Object)adaptor.create(QUESTION20);
            adaptor.addChild(root_0, QUESTION20_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "question"

    public static class exclamation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exclamation"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:30:1: exclamation : sentence_body EXCLAMATION ;
    public final EnglishParser.exclamation_return exclamation() throws RecognitionException {
        EnglishParser.exclamation_return retval = new EnglishParser.exclamation_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token EXCLAMATION22=null;
        EnglishParser.sentence_body_return sentence_body21 = null;


        Object EXCLAMATION22_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:30:12: ( sentence_body EXCLAMATION )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:30:14: sentence_body EXCLAMATION
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sentence_body_in_exclamation161);
            sentence_body21=sentence_body();

            state._fsp--;

            adaptor.addChild(root_0, sentence_body21.getTree());
            EXCLAMATION22=(Token)match(input,EXCLAMATION,FOLLOW_EXCLAMATION_in_exclamation163); 
            EXCLAMATION22_tree = (Object)adaptor.create(EXCLAMATION22);
            adaptor.addChild(root_0, EXCLAMATION22_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exclamation"

    public static class sentence_body_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentence_body"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:1: sentence_body : ( phrase | any_word )+ ( ( COMMA | COLON ) ( phrase | any_word | elaboration )+ )* ;
    public final EnglishParser.sentence_body_return sentence_body() throws RecognitionException {
        EnglishParser.sentence_body_return retval = new EnglishParser.sentence_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set25=null;
        EnglishParser.phrase_return phrase23 = null;

        EnglishParser.any_word_return any_word24 = null;

        EnglishParser.phrase_return phrase26 = null;

        EnglishParser.any_word_return any_word27 = null;

        EnglishParser.elaboration_return elaboration28 = null;


        Object set25_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:14: ( ( phrase | any_word )+ ( ( COMMA | COLON ) ( phrase | any_word | elaboration )+ )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:16: ( phrase | any_word )+ ( ( COMMA | COLON ) ( phrase | any_word | elaboration )+ )*
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:16: ( phrase | any_word )+
            int cnt8=0;
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=WORD && LA8_0<=NUMBER)) ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==WS) ) {
                        alt8=1;
                    }
                    else if ( ((LA8_2>=WORD && LA8_2<=COLON)) ) {
                        alt8=2;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:17: phrase
            	    {
            	    pushFollow(FOLLOW_phrase_in_sentence_body171);
            	    phrase23=phrase();

            	    state._fsp--;

            	    adaptor.addChild(root_0, phrase23.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:26: any_word
            	    {
            	    pushFollow(FOLLOW_any_word_in_sentence_body175);
            	    any_word24=any_word();

            	    state._fsp--;

            	    adaptor.addChild(root_0, any_word24.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:38: ( ( COMMA | COLON ) ( phrase | any_word | elaboration )+ )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=COMMA && LA10_0<=COLON)) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:39: ( COMMA | COLON ) ( phrase | any_word | elaboration )+
            	    {
            	    set25=(Token)input.LT(1);
            	    if ( (input.LA(1)>=COMMA && input.LA(1)<=COLON) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set25));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:55: ( phrase | any_word | elaboration )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=4;
            	        int LA9_0 = input.LA(1);

            	        if ( ((LA9_0>=WORD && LA9_0<=NUMBER)) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( (LA9_2==WS) ) {
            	                alt9=1;
            	            }
            	            else if ( ((LA9_2>=WORD && LA9_2<=COLON)||LA9_2==17) ) {
            	                alt9=2;
            	            }


            	        }
            	        else if ( (LA9_0==17) ) {
            	            alt9=3;
            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:56: phrase
            	    	    {
            	    	    pushFollow(FOLLOW_phrase_in_sentence_body190);
            	    	    phrase26=phrase();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, phrase26.getTree());

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:65: any_word
            	    	    {
            	    	    pushFollow(FOLLOW_any_word_in_sentence_body194);
            	    	    any_word27=any_word();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, any_word27.getTree());

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:32:76: elaboration
            	    	    {
            	    	    pushFollow(FOLLOW_elaboration_in_sentence_body198);
            	    	    elaboration28=elaboration();

            	    	    state._fsp--;

            	    	    adaptor.addChild(root_0, elaboration28.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "sentence_body"

    public static class elaboration_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elaboration"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:34:1: elaboration : '(' elaboration_body ')' ;
    public final EnglishParser.elaboration_return elaboration() throws RecognitionException {
        EnglishParser.elaboration_return retval = new EnglishParser.elaboration_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token char_literal29=null;
        Token char_literal31=null;
        EnglishParser.elaboration_body_return elaboration_body30 = null;


        Object char_literal29_tree=null;
        Object char_literal31_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:34:12: ( '(' elaboration_body ')' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:34:14: '(' elaboration_body ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal29=(Token)match(input,17,FOLLOW_17_in_elaboration209); 
            char_literal29_tree = (Object)adaptor.create(char_literal29);
            adaptor.addChild(root_0, char_literal29_tree);

            pushFollow(FOLLOW_elaboration_body_in_elaboration211);
            elaboration_body30=elaboration_body();

            state._fsp--;

            adaptor.addChild(root_0, elaboration_body30.getTree());
            char_literal31=(Token)match(input,18,FOLLOW_18_in_elaboration213); 
            char_literal31_tree = (Object)adaptor.create(char_literal31);
            adaptor.addChild(root_0, char_literal31_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elaboration"

    public static class elaboration_body_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elaboration_body"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:35:1: elaboration_body : ( phrase | any_word );
    public final EnglishParser.elaboration_body_return elaboration_body() throws RecognitionException {
        EnglishParser.elaboration_body_return retval = new EnglishParser.elaboration_body_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        EnglishParser.phrase_return phrase32 = null;

        EnglishParser.any_word_return any_word33 = null;



        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:35:17: ( phrase | any_word )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=WORD && LA11_0<=NUMBER)) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==WS) ) {
                    alt11=1;
                }
                else if ( (LA11_1==18) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:35:19: phrase
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_phrase_in_elaboration_body219);
                    phrase32=phrase();

                    state._fsp--;

                    adaptor.addChild(root_0, phrase32.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\English.g:35:28: any_word
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_any_word_in_elaboration_body223);
                    any_word33=any_word();

                    state._fsp--;

                    adaptor.addChild(root_0, any_word33.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "elaboration_body"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\20\uffff";
    static final String DFA7_eofS =
        "\20\uffff";
    static final String DFA7_minS =
        "\1\5\1\4\2\5\3\uffff\2\4\2\5\2\4\2\5\1\4";
    static final String DFA7_maxS =
        "\1\6\1\13\1\6\1\21\3\uffff\1\13\1\21\2\6\1\22\1\21\1\6\1\21\1\22";
    static final String DFA7_acceptS =
        "\4\uffff\1\1\1\2\1\3\11\uffff";
    static final String DFA7_specialS =
        "\20\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\1",
            "\1\2\2\1\1\4\1\5\1\6\2\3",
            "\2\7",
            "\2\10\12\uffff\1\11",
            "",
            "",
            "",
            "\1\2\2\1\1\4\1\5\1\6\2\3",
            "\1\12\2\10\1\4\1\5\1\6\2\3\5\uffff\1\11",
            "\2\13",
            "\2\14",
            "\1\15\15\uffff\1\16",
            "\1\12\2\10\1\4\1\5\1\6\2\3\5\uffff\1\11",
            "\2\17",
            "\2\10\1\4\1\5\1\6\2\3\5\uffff\1\11",
            "\1\15\15\uffff\1\16"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "26:1: sentence : ( assertion | question | exclamation );";
        }
    }
 

    public static final BitSet FOLLOW_header_in_article51 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_paragraph_in_article53 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_paragraph61 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_sentence_in_paragraph63 = new BitSet(new long[]{0x0000000000000062L});
    public static final BitSet FOLLOW_phrase_in_header72 = new BitSet(new long[]{0x0000000000000462L});
    public static final BitSet FOLLOW_any_word_in_header76 = new BitSet(new long[]{0x0000000000000462L});
    public static final BitSet FOLLOW_COMMA_in_header82 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_phrase_in_header85 = new BitSet(new long[]{0x0000000000000462L});
    public static final BitSet FOLLOW_any_word_in_header89 = new BitSet(new long[]{0x0000000000000462L});
    public static final BitSet FOLLOW_any_word_in_phrase101 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_phrase105 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_any_word_in_phrase107 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_set_in_any_word117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assertion_in_sentence130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_question_in_sentence134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exclamation_in_sentence138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentence_body_in_assertion145 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_DOT_in_assertion147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentence_body_in_question153 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_QUESTION_in_question155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sentence_body_in_exclamation161 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EXCLAMATION_in_exclamation163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_phrase_in_sentence_body171 = new BitSet(new long[]{0x0000000000000C62L});
    public static final BitSet FOLLOW_any_word_in_sentence_body175 = new BitSet(new long[]{0x0000000000000C62L});
    public static final BitSet FOLLOW_set_in_sentence_body181 = new BitSet(new long[]{0x0000000000020060L});
    public static final BitSet FOLLOW_phrase_in_sentence_body190 = new BitSet(new long[]{0x0000000000020C62L});
    public static final BitSet FOLLOW_any_word_in_sentence_body194 = new BitSet(new long[]{0x0000000000020C62L});
    public static final BitSet FOLLOW_elaboration_in_sentence_body198 = new BitSet(new long[]{0x0000000000020C62L});
    public static final BitSet FOLLOW_17_in_elaboration209 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_elaboration_body_in_elaboration211 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_elaboration213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_phrase_in_elaboration_body219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_any_word_in_elaboration_body223 = new BitSet(new long[]{0x0000000000000002L});

}