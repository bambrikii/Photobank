// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g 2011-07-10 00:14:32

package org.bambrikii.kbParser.nativeLanguages.grammars;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class T2Parser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SPACE", "NEW_LINE", "DOT", "QUESTION", "EXCLAIMATION", "COMMA", "SEMICOLON", "DASH", "WORD", "DIGIT"
    };
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


        public T2Parser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public T2Parser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return T2Parser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g"; }


    public static class article_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "article"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:20:1: article : ( paragraph )+ ;
    public final T2Parser.article_return article() throws RecognitionException {
        T2Parser.article_return retval = new T2Parser.article_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        T2Parser.paragraph_return paragraph1 = null;



        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:20:9: ( ( paragraph )+ )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:21:2: ( paragraph )+
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:21:2: ( paragraph )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WORD) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:21:2: paragraph
            	    {
            	    pushFollow(FOLLOW_paragraph_in_article55);
            	    paragraph1=paragraph();

            	    state._fsp--;

            	    adaptor.addChild(root_0, paragraph1.getTree());

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
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:23:1: paragraph : sentence ( SPACE sentence )* NEW_LINE ;
    public final T2Parser.paragraph_return paragraph() throws RecognitionException {
        T2Parser.paragraph_return retval = new T2Parser.paragraph_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SPACE3=null;
        Token NEW_LINE5=null;
        T2Parser.sentence_return sentence2 = null;

        T2Parser.sentence_return sentence4 = null;


        Object SPACE3_tree=null;
        Object NEW_LINE5_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:23:11: ( sentence ( SPACE sentence )* NEW_LINE )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:24:2: sentence ( SPACE sentence )* NEW_LINE
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_sentence_in_paragraph65);
            sentence2=sentence();

            state._fsp--;

            adaptor.addChild(root_0, sentence2.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:24:11: ( SPACE sentence )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==SPACE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:24:13: SPACE sentence
            	    {
            	    SPACE3=(Token)match(input,SPACE,FOLLOW_SPACE_in_paragraph69); 
            	    SPACE3_tree = (Object)adaptor.create(SPACE3);
            	    adaptor.addChild(root_0, SPACE3_tree);

            	    pushFollow(FOLLOW_sentence_in_paragraph71);
            	    sentence4=sentence();

            	    state._fsp--;

            	    adaptor.addChild(root_0, sentence4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            NEW_LINE5=(Token)match(input,NEW_LINE,FOLLOW_NEW_LINE_in_paragraph76); 
            NEW_LINE5_tree = (Object)adaptor.create(NEW_LINE5);
            adaptor.addChild(root_0, NEW_LINE5_tree);


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

    public static class sentence_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sentence"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:26:1: sentence : phrase_group ( phrase_group )* ( DOT | QUESTION | EXCLAIMATION ) ;
    public final T2Parser.sentence_return sentence() throws RecognitionException {
        T2Parser.sentence_return retval = new T2Parser.sentence_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token set8=null;
        T2Parser.phrase_group_return phrase_group6 = null;

        T2Parser.phrase_group_return phrase_group7 = null;


        Object set8_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:26:10: ( phrase_group ( phrase_group )* ( DOT | QUESTION | EXCLAIMATION ) )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:27:2: phrase_group ( phrase_group )* ( DOT | QUESTION | EXCLAIMATION )
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_phrase_group_in_sentence85);
            phrase_group6=phrase_group();

            state._fsp--;

            adaptor.addChild(root_0, phrase_group6.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:27:15: ( phrase_group )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WORD) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:27:17: phrase_group
            	    {
            	    pushFollow(FOLLOW_phrase_group_in_sentence89);
            	    phrase_group7=phrase_group();

            	    state._fsp--;

            	    adaptor.addChild(root_0, phrase_group7.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            set8=(Token)input.LT(1);
            if ( (input.LA(1)>=DOT && input.LA(1)<=EXCLAIMATION) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set8));
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
    // $ANTLR end "sentence"

    public static class phrase_group_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "phrase_group"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:34:1: phrase_group : phrase ( ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) ) SPACE phrase )* ;
    public final T2Parser.phrase_group_return phrase_group() throws RecognitionException {
        T2Parser.phrase_group_return retval = new T2Parser.phrase_group_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token COMMA10=null;
        Token SEMICOLON11=null;
        Token COMMA12=null;
        Token SEMICOLON13=null;
        Token SPACE14=null;
        Token DASH15=null;
        Token SPACE16=null;
        T2Parser.phrase_return phrase9 = null;

        T2Parser.phrase_return phrase17 = null;


        Object COMMA10_tree=null;
        Object SEMICOLON11_tree=null;
        Object COMMA12_tree=null;
        Object SEMICOLON13_tree=null;
        Object SPACE14_tree=null;
        Object DASH15_tree=null;
        Object SPACE16_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:34:14: ( phrase ( ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) ) SPACE phrase )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:35:2: phrase ( ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) ) SPACE phrase )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_phrase_in_phrase_group123);
            phrase9=phrase();

            state._fsp--;

            adaptor.addChild(root_0, phrase9.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:36:2: ( ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) ) SPACE phrase )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==SPACE||(LA5_0>=COMMA && LA5_0<=SEMICOLON)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:37:3: ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) ) SPACE phrase
            	    {
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:37:3: ( COMMA | SEMICOLON | ( COMMA SEMICOLON ) | ( SPACE DASH ) )
            	    int alt4=4;
            	    switch ( input.LA(1) ) {
            	    case COMMA:
            	        {
            	        int LA4_1 = input.LA(2);

            	        if ( (LA4_1==SEMICOLON) ) {
            	            alt4=3;
            	        }
            	        else if ( (LA4_1==SPACE) ) {
            	            alt4=1;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 4, 1, input);

            	            throw nvae;
            	        }
            	        }
            	        break;
            	    case SEMICOLON:
            	        {
            	        alt4=2;
            	        }
            	        break;
            	    case SPACE:
            	        {
            	        alt4=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt4) {
            	        case 1 :
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:38:4: COMMA
            	            {
            	            COMMA10=(Token)match(input,COMMA,FOLLOW_COMMA_in_phrase_group135); 
            	            COMMA10_tree = (Object)adaptor.create(COMMA10);
            	            adaptor.addChild(root_0, COMMA10_tree);


            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:39:6: SEMICOLON
            	            {
            	            SEMICOLON11=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_phrase_group142); 
            	            SEMICOLON11_tree = (Object)adaptor.create(SEMICOLON11);
            	            adaptor.addChild(root_0, SEMICOLON11_tree);


            	            }
            	            break;
            	        case 3 :
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:40:6: ( COMMA SEMICOLON )
            	            {
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:40:6: ( COMMA SEMICOLON )
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:40:8: COMMA SEMICOLON
            	            {
            	            COMMA12=(Token)match(input,COMMA,FOLLOW_COMMA_in_phrase_group151); 
            	            COMMA12_tree = (Object)adaptor.create(COMMA12);
            	            adaptor.addChild(root_0, COMMA12_tree);

            	            SEMICOLON13=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_phrase_group153); 
            	            SEMICOLON13_tree = (Object)adaptor.create(SEMICOLON13);
            	            adaptor.addChild(root_0, SEMICOLON13_tree);


            	            }


            	            }
            	            break;
            	        case 4 :
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:41:6: ( SPACE DASH )
            	            {
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:41:6: ( SPACE DASH )
            	            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:41:8: SPACE DASH
            	            {
            	            SPACE14=(Token)match(input,SPACE,FOLLOW_SPACE_in_phrase_group164); 
            	            SPACE14_tree = (Object)adaptor.create(SPACE14);
            	            adaptor.addChild(root_0, SPACE14_tree);

            	            DASH15=(Token)match(input,DASH,FOLLOW_DASH_in_phrase_group166); 
            	            DASH15_tree = (Object)adaptor.create(DASH15);
            	            adaptor.addChild(root_0, DASH15_tree);


            	            }


            	            }
            	            break;

            	    }

            	    SPACE16=(Token)match(input,SPACE,FOLLOW_SPACE_in_phrase_group176); 
            	    SPACE16_tree = (Object)adaptor.create(SPACE16);
            	    adaptor.addChild(root_0, SPACE16_tree);

            	    pushFollow(FOLLOW_phrase_in_phrase_group178);
            	    phrase17=phrase();

            	    state._fsp--;

            	    adaptor.addChild(root_0, phrase17.getTree());

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
    // $ANTLR end "phrase_group"

    public static class phrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "phrase"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:46:1: phrase : basic_phrase ;
    public final T2Parser.phrase_return phrase() throws RecognitionException {
        T2Parser.phrase_return retval = new T2Parser.phrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        T2Parser.basic_phrase_return basic_phrase18 = null;



        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:46:8: ( basic_phrase )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:52:2: basic_phrase
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_basic_phrase_in_phrase194);
            basic_phrase18=basic_phrase();

            state._fsp--;

            adaptor.addChild(root_0, basic_phrase18.getTree());

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

    public static class basic_phrase_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "basic_phrase"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:66:1: basic_phrase : word ( SPACE word )* ;
    public final T2Parser.basic_phrase_return basic_phrase() throws RecognitionException {
        T2Parser.basic_phrase_return retval = new T2Parser.basic_phrase_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token SPACE20=null;
        T2Parser.word_return word19 = null;

        T2Parser.word_return word21 = null;


        Object SPACE20_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:66:14: ( word ( SPACE word )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:67:2: word ( SPACE word )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_word_in_basic_phrase209);
            word19=word();

            state._fsp--;

            adaptor.addChild(root_0, word19.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:67:7: ( SPACE word )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==SPACE) ) {
                    int LA6_2 = input.LA(2);

                    if ( (LA6_2==WORD) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:67:9: SPACE word
            	    {
            	    SPACE20=(Token)match(input,SPACE,FOLLOW_SPACE_in_basic_phrase213); 
            	    SPACE20_tree = (Object)adaptor.create(SPACE20);
            	    adaptor.addChild(root_0, SPACE20_tree);

            	    pushFollow(FOLLOW_word_in_basic_phrase215);
            	    word21=word();

            	    state._fsp--;

            	    adaptor.addChild(root_0, word21.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "basic_phrase"

    public static class word_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "word"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:69:1: word : WORD ( DASH WORD )* ;
    public final T2Parser.word_return word() throws RecognitionException {
        T2Parser.word_return retval = new T2Parser.word_return();
        retval.start = input.LT(1);

        Object root_0 = null;

        Token WORD22=null;
        Token DASH23=null;
        Token WORD24=null;

        Object WORD22_tree=null;
        Object DASH23_tree=null;
        Object WORD24_tree=null;

        try {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:69:6: ( WORD ( DASH WORD )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:70:2: WORD ( DASH WORD )*
            {
            root_0 = (Object)adaptor.nil();

            WORD22=(Token)match(input,WORD,FOLLOW_WORD_in_word227); 
            WORD22_tree = (Object)adaptor.create(WORD22);
            adaptor.addChild(root_0, WORD22_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:70:7: ( DASH WORD )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==DASH) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\main\\java\\org\\bambrikii\\kbParser\\nativeLanguages\\grammars\\T2.g:70:9: DASH WORD
            	    {
            	    DASH23=(Token)match(input,DASH,FOLLOW_DASH_in_word231); 
            	    DASH23_tree = (Object)adaptor.create(DASH23);
            	    adaptor.addChild(root_0, DASH23_tree);

            	    WORD24=(Token)match(input,WORD,FOLLOW_WORD_in_word233); 
            	    WORD24_tree = (Object)adaptor.create(WORD24);
            	    adaptor.addChild(root_0, WORD24_tree);


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // $ANTLR end "word"

    // Delegated rules


 

    public static final BitSet FOLLOW_paragraph_in_article55 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_sentence_in_paragraph65 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_SPACE_in_paragraph69 = new BitSet(new long[]{0x0000000000001030L});
    public static final BitSet FOLLOW_sentence_in_paragraph71 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_NEW_LINE_in_paragraph76 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_phrase_group_in_sentence85 = new BitSet(new long[]{0x00000000000011C0L});
    public static final BitSet FOLLOW_phrase_group_in_sentence89 = new BitSet(new long[]{0x00000000000011C0L});
    public static final BitSet FOLLOW_set_in_sentence95 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_phrase_in_phrase_group123 = new BitSet(new long[]{0x0000000000000612L});
    public static final BitSet FOLLOW_COMMA_in_phrase_group135 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SEMICOLON_in_phrase_group142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_COMMA_in_phrase_group151 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_SEMICOLON_in_phrase_group153 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SPACE_in_phrase_group164 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_DASH_in_phrase_group166 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_SPACE_in_phrase_group176 = new BitSet(new long[]{0x0000000000001610L});
    public static final BitSet FOLLOW_phrase_in_phrase_group178 = new BitSet(new long[]{0x0000000000000612L});
    public static final BitSet FOLLOW_basic_phrase_in_phrase194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_word_in_basic_phrase209 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_SPACE_in_basic_phrase213 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_word_in_basic_phrase215 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WORD_in_word227 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_DASH_in_word231 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_WORD_in_word233 = new BitSet(new long[]{0x0000000000000802L});

}