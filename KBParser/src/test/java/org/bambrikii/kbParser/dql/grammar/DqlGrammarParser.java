// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g 2011-07-10 00:14:31

package org.bambrikii.kbParser.dql.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class DqlGrammarParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "WS", "SELECT", "FROM", "WHERE", "ORDER_BY", "GROUP_BY", "CONDITION_OPERATOR", "NOT_EQ", "MORE", "LESS", "EQ", "LIKE", "PLUS", "MINUS", "DIGIT", "DOT", "LETTER", "ORDER_DIRECTION", "COMMA", "'('", "')'", "'\\''"
    };
    public static final int EOF=-1;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int WS=4;
    public static final int SELECT=5;
    public static final int FROM=6;
    public static final int WHERE=7;
    public static final int ORDER_BY=8;
    public static final int GROUP_BY=9;
    public static final int CONDITION_OPERATOR=10;
    public static final int NOT_EQ=11;
    public static final int MORE=12;
    public static final int LESS=13;
    public static final int EQ=14;
    public static final int LIKE=15;
    public static final int PLUS=16;
    public static final int MINUS=17;
    public static final int DIGIT=18;
    public static final int DOT=19;
    public static final int LETTER=20;
    public static final int ORDER_DIRECTION=21;
    public static final int COMMA=22;

    // delegates
    // delegators


        public DqlGrammarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public DqlGrammarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return DqlGrammarParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g"; }


    public static class query_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "query"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:20:1: query : select ( WS )+ from ( ( WS )+ where )? ( ( WS )+ group_by )? ;
    public final DqlGrammarParser.query_return query() throws RecognitionException {
        DqlGrammarParser.query_return retval = new DqlGrammarParser.query_return();
        retval.start = input.LT(1);
        int query_StartIndex = input.index();
        Object root_0 = null;

        Token WS2=null;
        Token WS4=null;
        Token WS6=null;
        DqlGrammarParser.select_return select1 = null;

        DqlGrammarParser.from_return from3 = null;

        DqlGrammarParser.where_return where5 = null;

        DqlGrammarParser.group_by_return group_by7 = null;


        Object WS2_tree=null;
        Object WS4_tree=null;
        Object WS6_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:20:7: ( select ( WS )+ from ( ( WS )+ where )? ( ( WS )+ group_by )? )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:2: select ( WS )+ from ( ( WS )+ where )? ( ( WS )+ group_by )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_select_in_query67);
            select1=select();

            state._fsp--;

            adaptor.addChild(root_0, select1.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:11: ( WS )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==WS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:11: WS
            	    {
            	    WS2=(Token)match(input,WS,FOLLOW_WS_in_query69); 

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

            pushFollow(FOLLOW_from_in_query73);
            from3=from();

            state._fsp--;

            adaptor.addChild(root_0, from3.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:19: ( ( WS )+ where )?
            int alt3=2;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:21: ( WS )+ where
                    {
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:23: ( WS )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==WS) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:23: WS
                    	    {
                    	    WS4=(Token)match(input,WS,FOLLOW_WS_in_query77); 

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

                    pushFollow(FOLLOW_where_in_query81);
                    where5=where();

                    state._fsp--;

                    adaptor.addChild(root_0, where5.getTree());

                    }
                    break;

            }

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:35: ( ( WS )+ group_by )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==WS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:37: ( WS )+ group_by
                    {
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:39: ( WS )+
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
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:21:39: WS
                    	    {
                    	    WS6=(Token)match(input,WS,FOLLOW_WS_in_query88); 

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

                    pushFollow(FOLLOW_group_by_in_query92);
                    group_by7=group_by();

                    state._fsp--;

                    adaptor.addChild(root_0, group_by7.getTree());

                    }
                    break;

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
    // $ANTLR end "query"

    public static class select_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "select"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:23:1: select : SELECT ( WS )+ column ( elements_delimiter column )* ;
    public final DqlGrammarParser.select_return select() throws RecognitionException {
        DqlGrammarParser.select_return retval = new DqlGrammarParser.select_return();
        retval.start = input.LT(1);
        int select_StartIndex = input.index();
        Object root_0 = null;

        Token SELECT8=null;
        Token WS9=null;
        DqlGrammarParser.column_return column10 = null;

        DqlGrammarParser.elements_delimiter_return elements_delimiter11 = null;

        DqlGrammarParser.column_return column12 = null;


        Object SELECT8_tree=null;
        Object WS9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:23:8: ( SELECT ( WS )+ column ( elements_delimiter column )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:24:2: SELECT ( WS )+ column ( elements_delimiter column )*
            {
            root_0 = (Object)adaptor.nil();

            SELECT8=(Token)match(input,SELECT,FOLLOW_SELECT_in_select104); 
            SELECT8_tree = (Object)adaptor.create(SELECT8);
            root_0 = (Object)adaptor.becomeRoot(SELECT8_tree, root_0);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:24:12: ( WS )+
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
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:24:12: WS
            	    {
            	    WS9=(Token)match(input,WS,FOLLOW_WS_in_select107); 

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

            pushFollow(FOLLOW_column_in_select111);
            column10=column();

            state._fsp--;

            adaptor.addChild(root_0, column10.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:24:22: ( elements_delimiter column )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:24:24: elements_delimiter column
            	    {
            	    pushFollow(FOLLOW_elements_delimiter_in_select115);
            	    elements_delimiter11=elements_delimiter();

            	    state._fsp--;

            	    pushFollow(FOLLOW_column_in_select118);
            	    column12=column();

            	    state._fsp--;

            	    adaptor.addChild(root_0, column12.getTree());

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
    // $ANTLR end "select"

    public static class from_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "from"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:26:1: from : FROM ( WS )+ table ( elements_delimiter table )* ;
    public final DqlGrammarParser.from_return from() throws RecognitionException {
        DqlGrammarParser.from_return retval = new DqlGrammarParser.from_return();
        retval.start = input.LT(1);
        int from_StartIndex = input.index();
        Object root_0 = null;

        Token FROM13=null;
        Token WS14=null;
        DqlGrammarParser.table_return table15 = null;

        DqlGrammarParser.elements_delimiter_return elements_delimiter16 = null;

        DqlGrammarParser.table_return table17 = null;


        Object FROM13_tree=null;
        Object WS14_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:26:6: ( FROM ( WS )+ table ( elements_delimiter table )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:27:2: FROM ( WS )+ table ( elements_delimiter table )*
            {
            root_0 = (Object)adaptor.nil();

            FROM13=(Token)match(input,FROM,FOLLOW_FROM_in_from130); 
            FROM13_tree = (Object)adaptor.create(FROM13);
            root_0 = (Object)adaptor.becomeRoot(FROM13_tree, root_0);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:27:10: ( WS )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:27:10: WS
            	    {
            	    WS14=(Token)match(input,WS,FOLLOW_WS_in_from133); 

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

            pushFollow(FOLLOW_table_in_from137);
            table15=table();

            state._fsp--;

            adaptor.addChild(root_0, table15.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:27:19: ( elements_delimiter table )*
            loop9:
            do {
                int alt9=2;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:27:21: elements_delimiter table
            	    {
            	    pushFollow(FOLLOW_elements_delimiter_in_from141);
            	    elements_delimiter16=elements_delimiter();

            	    state._fsp--;

            	    pushFollow(FOLLOW_table_in_from144);
            	    table17=table();

            	    state._fsp--;

            	    adaptor.addChild(root_0, table17.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // $ANTLR end "from"

    public static class where_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "where"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:29:1: where : WHERE ( WS )+ condition_expr_aggr ( elements_delimiter condition_expr_aggr )* ;
    public final DqlGrammarParser.where_return where() throws RecognitionException {
        DqlGrammarParser.where_return retval = new DqlGrammarParser.where_return();
        retval.start = input.LT(1);
        int where_StartIndex = input.index();
        Object root_0 = null;

        Token WHERE18=null;
        Token WS19=null;
        DqlGrammarParser.condition_expr_aggr_return condition_expr_aggr20 = null;

        DqlGrammarParser.elements_delimiter_return elements_delimiter21 = null;

        DqlGrammarParser.condition_expr_aggr_return condition_expr_aggr22 = null;


        Object WHERE18_tree=null;
        Object WS19_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:29:7: ( WHERE ( WS )+ condition_expr_aggr ( elements_delimiter condition_expr_aggr )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:30:2: WHERE ( WS )+ condition_expr_aggr ( elements_delimiter condition_expr_aggr )*
            {
            root_0 = (Object)adaptor.nil();

            WHERE18=(Token)match(input,WHERE,FOLLOW_WHERE_in_where156); 
            WHERE18_tree = (Object)adaptor.create(WHERE18);
            root_0 = (Object)adaptor.becomeRoot(WHERE18_tree, root_0);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:30:11: ( WS )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==WS) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:30:11: WS
            	    {
            	    WS19=(Token)match(input,WS,FOLLOW_WS_in_where159); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            pushFollow(FOLLOW_condition_expr_aggr_in_where163);
            condition_expr_aggr20=condition_expr_aggr();

            state._fsp--;

            adaptor.addChild(root_0, condition_expr_aggr20.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:30:34: ( elements_delimiter condition_expr_aggr )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:30:36: elements_delimiter condition_expr_aggr
            	    {
            	    pushFollow(FOLLOW_elements_delimiter_in_where167);
            	    elements_delimiter21=elements_delimiter();

            	    state._fsp--;

            	    pushFollow(FOLLOW_condition_expr_aggr_in_where170);
            	    condition_expr_aggr22=condition_expr_aggr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, condition_expr_aggr22.getTree());

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // $ANTLR end "where"

    public static class order_by_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "order_by"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:32:1: order_by : ORDER_BY order_expr ( elements_delimiter order_expr )* ;
    public final DqlGrammarParser.order_by_return order_by() throws RecognitionException {
        DqlGrammarParser.order_by_return retval = new DqlGrammarParser.order_by_return();
        retval.start = input.LT(1);
        int order_by_StartIndex = input.index();
        Object root_0 = null;

        Token ORDER_BY23=null;
        DqlGrammarParser.order_expr_return order_expr24 = null;

        DqlGrammarParser.elements_delimiter_return elements_delimiter25 = null;

        DqlGrammarParser.order_expr_return order_expr26 = null;


        Object ORDER_BY23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:32:10: ( ORDER_BY order_expr ( elements_delimiter order_expr )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:33:2: ORDER_BY order_expr ( elements_delimiter order_expr )*
            {
            root_0 = (Object)adaptor.nil();

            ORDER_BY23=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_order_by182); 
            ORDER_BY23_tree = (Object)adaptor.create(ORDER_BY23);
            root_0 = (Object)adaptor.becomeRoot(ORDER_BY23_tree, root_0);

            pushFollow(FOLLOW_order_expr_in_order_by185);
            order_expr24=order_expr();

            state._fsp--;

            adaptor.addChild(root_0, order_expr24.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:33:23: ( elements_delimiter order_expr )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==WS||LA12_0==COMMA) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:33:25: elements_delimiter order_expr
            	    {
            	    pushFollow(FOLLOW_elements_delimiter_in_order_by189);
            	    elements_delimiter25=elements_delimiter();

            	    state._fsp--;

            	    pushFollow(FOLLOW_order_expr_in_order_by192);
            	    order_expr26=order_expr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, order_expr26.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // $ANTLR end "order_by"

    public static class group_by_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "group_by"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:35:1: group_by : GROUP_BY ( WS )+ column ( elements_delimiter column )* ;
    public final DqlGrammarParser.group_by_return group_by() throws RecognitionException {
        DqlGrammarParser.group_by_return retval = new DqlGrammarParser.group_by_return();
        retval.start = input.LT(1);
        int group_by_StartIndex = input.index();
        Object root_0 = null;

        Token GROUP_BY27=null;
        Token WS28=null;
        DqlGrammarParser.column_return column29 = null;

        DqlGrammarParser.elements_delimiter_return elements_delimiter30 = null;

        DqlGrammarParser.column_return column31 = null;


        Object GROUP_BY27_tree=null;
        Object WS28_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:35:10: ( GROUP_BY ( WS )+ column ( elements_delimiter column )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:36:2: GROUP_BY ( WS )+ column ( elements_delimiter column )*
            {
            root_0 = (Object)adaptor.nil();

            GROUP_BY27=(Token)match(input,GROUP_BY,FOLLOW_GROUP_BY_in_group_by204); 
            GROUP_BY27_tree = (Object)adaptor.create(GROUP_BY27);
            adaptor.addChild(root_0, GROUP_BY27_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:36:13: ( WS )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==WS) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:36:13: WS
            	    {
            	    WS28=(Token)match(input,WS,FOLLOW_WS_in_group_by206); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            pushFollow(FOLLOW_column_in_group_by210);
            column29=column();

            state._fsp--;

            adaptor.addChild(root_0, column29.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:36:23: ( elements_delimiter column )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==WS||LA14_0==COMMA) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:36:25: elements_delimiter column
            	    {
            	    pushFollow(FOLLOW_elements_delimiter_in_group_by214);
            	    elements_delimiter30=elements_delimiter();

            	    state._fsp--;

            	    pushFollow(FOLLOW_column_in_group_by217);
            	    column31=column();

            	    state._fsp--;

            	    adaptor.addChild(root_0, column31.getTree());

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // $ANTLR end "group_by"

    public static class condition_expr_aggr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition_expr_aggr"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:38:1: condition_expr_aggr : '(' ( WS )* condition_expr ( ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr )* ( WS )* ')' ;
    public final DqlGrammarParser.condition_expr_aggr_return condition_expr_aggr() throws RecognitionException {
        DqlGrammarParser.condition_expr_aggr_return retval = new DqlGrammarParser.condition_expr_aggr_return();
        retval.start = input.LT(1);
        int condition_expr_aggr_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal32=null;
        Token WS33=null;
        Token WS35=null;
        Token CONDITION_OPERATOR36=null;
        Token WS37=null;
        Token WS39=null;
        Token char_literal40=null;
        DqlGrammarParser.condition_expr_return condition_expr34 = null;

        DqlGrammarParser.condition_expr_aggr_return condition_expr_aggr38 = null;


        Object char_literal32_tree=null;
        Object WS33_tree=null;
        Object WS35_tree=null;
        Object CONDITION_OPERATOR36_tree=null;
        Object WS37_tree=null;
        Object WS39_tree=null;
        Object char_literal40_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:38:21: ( '(' ( WS )* condition_expr ( ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr )* ( WS )* ')' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:2: '(' ( WS )* condition_expr ( ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr )* ( WS )* ')'
            {
            root_0 = (Object)adaptor.nil();

            char_literal32=(Token)match(input,23,FOLLOW_23_in_condition_expr_aggr229); 
            char_literal32_tree = (Object)adaptor.create(char_literal32);
            adaptor.addChild(root_0, char_literal32_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:8: ( WS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==WS) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:8: WS
            	    {
            	    WS33=(Token)match(input,WS,FOLLOW_WS_in_condition_expr_aggr231); 

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            pushFollow(FOLLOW_condition_expr_in_condition_expr_aggr235);
            condition_expr34=condition_expr();

            state._fsp--;

            adaptor.addChild(root_0, condition_expr34.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:26: ( ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr )*
            loop18:
            do {
                int alt18=2;
                alt18 = dfa18.predict(input);
                switch (alt18) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:28: ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr
            	    {
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:30: ( WS )+
            	    int cnt16=0;
            	    loop16:
            	    do {
            	        int alt16=2;
            	        int LA16_0 = input.LA(1);

            	        if ( (LA16_0==WS) ) {
            	            alt16=1;
            	        }


            	        switch (alt16) {
            	    	case 1 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:30: WS
            	    	    {
            	    	    WS35=(Token)match(input,WS,FOLLOW_WS_in_condition_expr_aggr239); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt16 >= 1 ) break loop16;
            	                EarlyExitException eee =
            	                    new EarlyExitException(16, input);
            	                throw eee;
            	        }
            	        cnt16++;
            	    } while (true);

            	    CONDITION_OPERATOR36=(Token)match(input,CONDITION_OPERATOR,FOLLOW_CONDITION_OPERATOR_in_condition_expr_aggr243); 
            	    CONDITION_OPERATOR36_tree = (Object)adaptor.create(CONDITION_OPERATOR36);
            	    root_0 = (Object)adaptor.becomeRoot(CONDITION_OPERATOR36_tree, root_0);

            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:55: ( WS )+
            	    int cnt17=0;
            	    loop17:
            	    do {
            	        int alt17=2;
            	        int LA17_0 = input.LA(1);

            	        if ( (LA17_0==WS) ) {
            	            alt17=1;
            	        }


            	        switch (alt17) {
            	    	case 1 :
            	    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:55: WS
            	    	    {
            	    	    WS37=(Token)match(input,WS,FOLLOW_WS_in_condition_expr_aggr246); 

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt17 >= 1 ) break loop17;
            	                EarlyExitException eee =
            	                    new EarlyExitException(17, input);
            	                throw eee;
            	        }
            	        cnt17++;
            	    } while (true);

            	    pushFollow(FOLLOW_condition_expr_aggr_in_condition_expr_aggr250);
            	    condition_expr_aggr38=condition_expr_aggr();

            	    state._fsp--;

            	    adaptor.addChild(root_0, condition_expr_aggr38.getTree());

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:83: ( WS )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==WS) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:39:83: WS
            	    {
            	    WS39=(Token)match(input,WS,FOLLOW_WS_in_condition_expr_aggr255); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            char_literal40=(Token)match(input,24,FOLLOW_24_in_condition_expr_aggr259); 
            char_literal40_tree = (Object)adaptor.create(char_literal40);
            adaptor.addChild(root_0, char_literal40_tree);


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
    // $ANTLR end "condition_expr_aggr"

    public static class condition_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition_expr"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:41:1: condition_expr : column ( WS )* condition_func ( WS )* expression ;
    public final DqlGrammarParser.condition_expr_return condition_expr() throws RecognitionException {
        DqlGrammarParser.condition_expr_return retval = new DqlGrammarParser.condition_expr_return();
        retval.start = input.LT(1);
        int condition_expr_StartIndex = input.index();
        Object root_0 = null;

        Token WS42=null;
        Token WS44=null;
        DqlGrammarParser.column_return column41 = null;

        DqlGrammarParser.condition_func_return condition_func43 = null;

        DqlGrammarParser.expression_return expression45 = null;


        Object WS42_tree=null;
        Object WS44_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:41:16: ( column ( WS )* condition_func ( WS )* expression )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:42:2: column ( WS )* condition_func ( WS )* expression
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_in_condition_expr268);
            column41=column();

            state._fsp--;

            adaptor.addChild(root_0, column41.getTree());
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:42:11: ( WS )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==WS) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:42:11: WS
            	    {
            	    WS42=(Token)match(input,WS,FOLLOW_WS_in_condition_expr270); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            pushFollow(FOLLOW_condition_func_in_condition_expr274);
            condition_func43=condition_func();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(condition_func43.getTree(), root_0);
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:42:32: ( WS )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:42:32: WS
            	    {
            	    WS44=(Token)match(input,WS,FOLLOW_WS_in_condition_expr277); 

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            pushFollow(FOLLOW_expression_in_condition_expr281);
            expression45=expression();

            state._fsp--;

            adaptor.addChild(root_0, expression45.getTree());

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
    // $ANTLR end "condition_expr"

    public static class condition_func_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "condition_func"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:44:1: condition_func : ( NOT_EQ | MORE | LESS | EQ | LIKE );
    public final DqlGrammarParser.condition_func_return condition_func() throws RecognitionException {
        DqlGrammarParser.condition_func_return retval = new DqlGrammarParser.condition_func_return();
        retval.start = input.LT(1);
        int condition_func_StartIndex = input.index();
        Object root_0 = null;

        Token set46=null;

        Object set46_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:44:16: ( NOT_EQ | MORE | LESS | EQ | LIKE )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:
            {
            root_0 = (Object)adaptor.nil();

            set46=(Token)input.LT(1);
            if ( (input.LA(1)>=NOT_EQ && input.LA(1)<=LIKE) ) {
                input.consume();
                adaptor.addChild(root_0, (Object)adaptor.create(set46));
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
    // $ANTLR end "condition_func"

    public static class expression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:51:1: expression : ( number_expr | string_expr );
    public final DqlGrammarParser.expression_return expression() throws RecognitionException {
        DqlGrammarParser.expression_return retval = new DqlGrammarParser.expression_return();
        retval.start = input.LT(1);
        int expression_StartIndex = input.index();
        Object root_0 = null;

        DqlGrammarParser.number_expr_return number_expr47 = null;

        DqlGrammarParser.string_expr_return string_expr48 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:51:12: ( number_expr | string_expr )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=PLUS && LA22_0<=DIGIT)) ) {
                alt22=1;
            }
            else if ( (LA22_0==25) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:52:2: number_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_number_expr_in_expression319);
                    number_expr47=number_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, number_expr47.getTree());

                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:53:4: string_expr
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_string_expr_in_expression324);
                    string_expr48=string_expr();

                    state._fsp--;

                    adaptor.addChild(root_0, string_expr48.getTree());

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
    // $ANTLR end "expression"

    public static class number_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "number_expr"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:55:1: number_expr : ( PLUS | MINUS )? ( DIGIT )+ ( DOT ( DIGIT )+ )? ;
    public final DqlGrammarParser.number_expr_return number_expr() throws RecognitionException {
        DqlGrammarParser.number_expr_return retval = new DqlGrammarParser.number_expr_return();
        retval.start = input.LT(1);
        int number_expr_StartIndex = input.index();
        Object root_0 = null;

        Token PLUS49=null;
        Token MINUS50=null;
        Token DIGIT51=null;
        Token DOT52=null;
        Token DIGIT53=null;

        Object PLUS49_tree=null;
        Object MINUS50_tree=null;
        Object DIGIT51_tree=null;
        Object DOT52_tree=null;
        Object DIGIT53_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:55:13: ( ( PLUS | MINUS )? ( DIGIT )+ ( DOT ( DIGIT )+ )? )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:56:2: ( PLUS | MINUS )? ( DIGIT )+ ( DOT ( DIGIT )+ )?
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:56:2: ( PLUS | MINUS )?
            int alt23=3;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==PLUS) ) {
                alt23=1;
            }
            else if ( (LA23_0==MINUS) ) {
                alt23=2;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:57:3: PLUS
                    {
                    PLUS49=(Token)match(input,PLUS,FOLLOW_PLUS_in_number_expr337); 
                    PLUS49_tree = (Object)adaptor.create(PLUS49);
                    adaptor.addChild(root_0, PLUS49_tree);


                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:58:5: MINUS
                    {
                    MINUS50=(Token)match(input,MINUS,FOLLOW_MINUS_in_number_expr343); 
                    MINUS50_tree = (Object)adaptor.create(MINUS50);
                    root_0 = (Object)adaptor.becomeRoot(MINUS50_tree, root_0);


                    }
                    break;

            }

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:2: ( DIGIT )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==DIGIT) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:2: DIGIT
            	    {
            	    DIGIT51=(Token)match(input,DIGIT,FOLLOW_DIGIT_in_number_expr351); 
            	    DIGIT51_tree = (Object)adaptor.create(DIGIT51);
            	    adaptor.addChild(root_0, DIGIT51_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:9: ( DOT ( DIGIT )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==DOT) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:11: DOT ( DIGIT )+
                    {
                    DOT52=(Token)match(input,DOT,FOLLOW_DOT_in_number_expr356); 
                    DOT52_tree = (Object)adaptor.create(DOT52);
                    adaptor.addChild(root_0, DOT52_tree);

                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:15: ( DIGIT )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==DIGIT) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:60:15: DIGIT
                    	    {
                    	    DIGIT53=(Token)match(input,DIGIT,FOLLOW_DIGIT_in_number_expr358); 
                    	    DIGIT53_tree = (Object)adaptor.create(DIGIT53);
                    	    adaptor.addChild(root_0, DIGIT53_tree);


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    }
                    break;

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
    // $ANTLR end "number_expr"

    public static class string_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "string_expr"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:62:1: string_expr : '\\'' ( DIGIT | LETTER )* '\\'' ;
    public final DqlGrammarParser.string_expr_return string_expr() throws RecognitionException {
        DqlGrammarParser.string_expr_return retval = new DqlGrammarParser.string_expr_return();
        retval.start = input.LT(1);
        int string_expr_StartIndex = input.index();
        Object root_0 = null;

        Token char_literal54=null;
        Token set55=null;
        Token char_literal56=null;

        Object char_literal54_tree=null;
        Object set55_tree=null;
        Object char_literal56_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:62:13: ( '\\'' ( DIGIT | LETTER )* '\\'' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:63:2: '\\'' ( DIGIT | LETTER )* '\\''
            {
            root_0 = (Object)adaptor.nil();

            char_literal54=(Token)match(input,25,FOLLOW_25_in_string_expr371); 
            char_literal54_tree = (Object)adaptor.create(char_literal54);
            adaptor.addChild(root_0, char_literal54_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:64:2: ( DIGIT | LETTER )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==DIGIT||LA27_0==LETTER) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:
            	    {
            	    set55=(Token)input.LT(1);
            	    if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set55));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            char_literal56=(Token)match(input,25,FOLLOW_25_in_string_expr391); 
            char_literal56_tree = (Object)adaptor.create(char_literal56);
            adaptor.addChild(root_0, char_literal56_tree);


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
    // $ANTLR end "string_expr"

    public static class order_expr_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "order_expr"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:70:1: order_expr : column ( ( WS )+ ORDER_DIRECTION )? ;
    public final DqlGrammarParser.order_expr_return order_expr() throws RecognitionException {
        DqlGrammarParser.order_expr_return retval = new DqlGrammarParser.order_expr_return();
        retval.start = input.LT(1);
        int order_expr_StartIndex = input.index();
        Object root_0 = null;

        Token WS58=null;
        Token ORDER_DIRECTION59=null;
        DqlGrammarParser.column_return column57 = null;


        Object WS58_tree=null;
        Object ORDER_DIRECTION59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:70:12: ( column ( ( WS )+ ORDER_DIRECTION )? )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:71:2: column ( ( WS )+ ORDER_DIRECTION )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_column_in_order_expr400);
            column57=column();

            state._fsp--;

            root_0 = (Object)adaptor.becomeRoot(column57.getTree(), root_0);
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:71:10: ( ( WS )+ ORDER_DIRECTION )?
            int alt29=2;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:71:12: ( WS )+ ORDER_DIRECTION
                    {
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:71:14: ( WS )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==WS) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:71:14: WS
                    	    {
                    	    WS58=(Token)match(input,WS,FOLLOW_WS_in_order_expr405); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);

                    ORDER_DIRECTION59=(Token)match(input,ORDER_DIRECTION,FOLLOW_ORDER_DIRECTION_in_order_expr409); 
                    ORDER_DIRECTION59_tree = (Object)adaptor.create(ORDER_DIRECTION59);
                    adaptor.addChild(root_0, ORDER_DIRECTION59_tree);


                    }
                    break;

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
    // $ANTLR end "order_expr"

    public static class column_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "column"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:73:1: column : LETTER ( LETTER | DIGIT )* ;
    public final DqlGrammarParser.column_return column() throws RecognitionException {
        DqlGrammarParser.column_return retval = new DqlGrammarParser.column_return();
        retval.start = input.LT(1);
        int column_StartIndex = input.index();
        Object root_0 = null;

        Token LETTER60=null;
        Token set61=null;

        Object LETTER60_tree=null;
        Object set61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:73:8: ( LETTER ( LETTER | DIGIT )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:74:2: LETTER ( LETTER | DIGIT )*
            {
            root_0 = (Object)adaptor.nil();

            LETTER60=(Token)match(input,LETTER,FOLLOW_LETTER_in_column421); 
            LETTER60_tree = (Object)adaptor.create(LETTER60);
            adaptor.addChild(root_0, LETTER60_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:75:2: ( LETTER | DIGIT )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==DIGIT||LA30_0==LETTER) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:
            	    {
            	    set61=(Token)input.LT(1);
            	    if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set61));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // $ANTLR end "column"

    public static class table_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "table"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:80:1: table : LETTER ( LETTER | DIGIT )* ;
    public final DqlGrammarParser.table_return table() throws RecognitionException {
        DqlGrammarParser.table_return retval = new DqlGrammarParser.table_return();
        retval.start = input.LT(1);
        int table_StartIndex = input.index();
        Object root_0 = null;

        Token LETTER62=null;
        Token set63=null;

        Object LETTER62_tree=null;
        Object set63_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:80:7: ( LETTER ( LETTER | DIGIT )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:81:2: LETTER ( LETTER | DIGIT )*
            {
            root_0 = (Object)adaptor.nil();

            LETTER62=(Token)match(input,LETTER,FOLLOW_LETTER_in_table447); 
            LETTER62_tree = (Object)adaptor.create(LETTER62);
            adaptor.addChild(root_0, LETTER62_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:82:2: ( LETTER | DIGIT )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==DIGIT||LA31_0==LETTER) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:
            	    {
            	    set63=(Token)input.LT(1);
            	    if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (Object)adaptor.create(set63));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // $ANTLR end "table"

    public static class elements_delimiter_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "elements_delimiter"
    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:87:1: elements_delimiter : ( WS )* COMMA ( WS )* ;
    public final DqlGrammarParser.elements_delimiter_return elements_delimiter() throws RecognitionException {
        DqlGrammarParser.elements_delimiter_return retval = new DqlGrammarParser.elements_delimiter_return();
        retval.start = input.LT(1);
        int elements_delimiter_StartIndex = input.index();
        Object root_0 = null;

        Token WS64=null;
        Token COMMA65=null;
        Token WS66=null;

        Object WS64_tree=null;
        Object COMMA65_tree=null;
        Object WS66_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:87:20: ( ( WS )* COMMA ( WS )* )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:88:2: ( WS )* COMMA ( WS )*
            {
            root_0 = (Object)adaptor.nil();

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:88:2: ( WS )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==WS) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:88:2: WS
            	    {
            	    WS64=(Token)match(input,WS,FOLLOW_WS_in_elements_delimiter473); 
            	    WS64_tree = (Object)adaptor.create(WS64);
            	    adaptor.addChild(root_0, WS64_tree);


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            COMMA65=(Token)match(input,COMMA,FOLLOW_COMMA_in_elements_delimiter476); 
            COMMA65_tree = (Object)adaptor.create(COMMA65);
            adaptor.addChild(root_0, COMMA65_tree);

            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:88:12: ( WS )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==WS) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:88:12: WS
            	    {
            	    WS66=(Token)match(input,WS,FOLLOW_WS_in_elements_delimiter478); 
            	    WS66_tree = (Object)adaptor.create(WS66);
            	    adaptor.addChild(root_0, WS66_tree);


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // $ANTLR end "elements_delimiter"

    // Delegated rules


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA9 dfa9 = new DFA9(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA18 dfa18 = new DFA18(this);
    protected DFA29 dfa29 = new DFA29(this);
    static final String DFA3_eotS =
        "\4\uffff";
    static final String DFA3_eofS =
        "\1\2\3\uffff";
    static final String DFA3_minS =
        "\2\4\2\uffff";
    static final String DFA3_maxS =
        "\1\4\1\11\2\uffff";
    static final String DFA3_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA3_specialS =
        "\4\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\1",
            "\1\1\2\uffff\1\3\1\uffff\1\2",
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
            return "21:19: ( ( WS )+ where )?";
        }
    }
    static final String DFA7_eotS =
        "\4\uffff";
    static final String DFA7_eofS =
        "\4\uffff";
    static final String DFA7_minS =
        "\2\4\2\uffff";
    static final String DFA7_maxS =
        "\2\26\2\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\4\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\21\uffff\1\2",
            "\1\1\1\uffff\1\3\17\uffff\1\2",
            "",
            ""
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
            return "()* loopback of 24:22: ( elements_delimiter column )*";
        }
    }
    static final String DFA9_eotS =
        "\4\uffff";
    static final String DFA9_eofS =
        "\1\2\3\uffff";
    static final String DFA9_minS =
        "\2\4\2\uffff";
    static final String DFA9_maxS =
        "\2\26\2\uffff";
    static final String DFA9_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA9_specialS =
        "\4\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\21\uffff\1\3",
            "\1\1\2\uffff\1\2\1\uffff\1\2\14\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "()* loopback of 27:19: ( elements_delimiter table )*";
        }
    }
    static final String DFA11_eotS =
        "\4\uffff";
    static final String DFA11_eofS =
        "\1\2\3\uffff";
    static final String DFA11_minS =
        "\2\4\2\uffff";
    static final String DFA11_maxS =
        "\2\26\2\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA11_specialS =
        "\4\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\21\uffff\1\3",
            "\1\1\4\uffff\1\2\14\uffff\1\3",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "()* loopback of 30:34: ( elements_delimiter condition_expr_aggr )*";
        }
    }
    static final String DFA18_eotS =
        "\4\uffff";
    static final String DFA18_eofS =
        "\4\uffff";
    static final String DFA18_minS =
        "\2\4\2\uffff";
    static final String DFA18_maxS =
        "\2\30\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA18_specialS =
        "\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\1\23\uffff\1\2",
            "\1\1\5\uffff\1\3\15\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 39:26: ( ( WS )+ CONDITION_OPERATOR ( WS )+ condition_expr_aggr )*";
        }
    }
    static final String DFA29_eotS =
        "\4\uffff";
    static final String DFA29_eofS =
        "\1\2\3\uffff";
    static final String DFA29_minS =
        "\2\4\2\uffff";
    static final String DFA29_maxS =
        "\2\26\2\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA29_specialS =
        "\4\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\1\21\uffff\1\2",
            "\1\1\20\uffff\1\3\1\2",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "71:10: ( ( WS )+ ORDER_DIRECTION )?";
        }
    }
 

    public static final BitSet FOLLOW_select_in_query67 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_query69 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_from_in_query73 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_query77 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_where_in_query81 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_query88 = new BitSet(new long[]{0x0000000000000210L});
    public static final BitSet FOLLOW_group_by_in_query92 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select104 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_select107 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_column_in_select111 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_elements_delimiter_in_select115 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_column_in_select118 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_FROM_in_from130 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_from133 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_table_in_from137 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_elements_delimiter_in_from141 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_table_in_from144 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_WHERE_in_where156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_where159 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_condition_expr_aggr_in_where163 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_elements_delimiter_in_where167 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_condition_expr_aggr_in_where170 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_ORDER_BY_in_order_by182 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_order_expr_in_order_by185 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_elements_delimiter_in_order_by189 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_order_expr_in_order_by192 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_GROUP_BY_in_group_by204 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_group_by206 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_column_in_group_by210 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_elements_delimiter_in_group_by214 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_column_in_group_by217 = new BitSet(new long[]{0x0000000000400012L});
    public static final BitSet FOLLOW_23_in_condition_expr_aggr229 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_WS_in_condition_expr_aggr231 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_condition_expr_in_condition_expr_aggr235 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_WS_in_condition_expr_aggr239 = new BitSet(new long[]{0x0000000000000410L});
    public static final BitSet FOLLOW_CONDITION_OPERATOR_in_condition_expr_aggr243 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_WS_in_condition_expr_aggr246 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_condition_expr_aggr_in_condition_expr_aggr250 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_WS_in_condition_expr_aggr255 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_24_in_condition_expr_aggr259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_condition_expr268 = new BitSet(new long[]{0x000000000000F810L});
    public static final BitSet FOLLOW_WS_in_condition_expr270 = new BitSet(new long[]{0x000000000000F810L});
    public static final BitSet FOLLOW_condition_func_in_condition_expr274 = new BitSet(new long[]{0x0000000002070010L});
    public static final BitSet FOLLOW_WS_in_condition_expr277 = new BitSet(new long[]{0x0000000002070010L});
    public static final BitSet FOLLOW_expression_in_condition_expr281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_condition_func0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_number_expr_in_expression319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_string_expr_in_expression324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_number_expr337 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_MINUS_in_number_expr343 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DIGIT_in_number_expr351 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_DOT_in_number_expr356 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DIGIT_in_number_expr358 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_25_in_string_expr371 = new BitSet(new long[]{0x0000000002140000L});
    public static final BitSet FOLLOW_set_in_string_expr374 = new BitSet(new long[]{0x0000000002140000L});
    public static final BitSet FOLLOW_25_in_string_expr391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_column_in_order_expr400 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_order_expr405 = new BitSet(new long[]{0x0000000000200010L});
    public static final BitSet FOLLOW_ORDER_DIRECTION_in_order_expr409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LETTER_in_column421 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_set_in_column424 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_LETTER_in_table447 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_set_in_table450 = new BitSet(new long[]{0x0000000000140002L});
    public static final BitSet FOLLOW_WS_in_elements_delimiter473 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_COMMA_in_elements_delimiter476 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_WS_in_elements_delimiter478 = new BitSet(new long[]{0x0000000000000012L});

}