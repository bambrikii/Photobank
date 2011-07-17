// $ANTLR 3.3 Nov 30, 2010 12:46:29 C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g 2011-07-10 00:14:31

package org.bambrikii.kbParser.dql.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class DqlGrammarLexer extends Lexer {
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

    public DqlGrammarLexer() {;} 
    public DqlGrammarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public DqlGrammarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g"; }

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:11:7: ( '(' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:11:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:12:7: ( ')' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:12:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:13:7: ( '\\'' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:13:9: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "CONDITION_OPERATOR"
    public final void mCONDITION_OPERATOR() throws RecognitionException {
        try {
            int _type = CONDITION_OPERATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:90:20: ( 'and' | 'or' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='a') ) {
                alt1=1;
            }
            else if ( (LA1_0=='o') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:91:2: 'and'
                    {
                    match("and"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:92:4: 'or'
                    {
                    match("or"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONDITION_OPERATOR"

    // $ANTLR start "ORDER_DIRECTION"
    public final void mORDER_DIRECTION() throws RecognitionException {
        try {
            int _type = ORDER_DIRECTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:94:17: ( ( 'desc' | 'asc' ) )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:95:2: ( 'desc' | 'asc' )
            {
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:95:2: ( 'desc' | 'asc' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='d') ) {
                alt2=1;
            }
            else if ( (LA2_0=='a') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:96:3: 'desc'
                    {
                    match("desc"); 


                    }
                    break;
                case 2 :
                    // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:97:5: 'asc'
                    {
                    match("asc"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER_DIRECTION"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:100:5: ( '.' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:101:2: '.'
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

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:103:6: ( '+' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:104:2: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:106:7: ( '-' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:107:2: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "NOT_EQ"
    public final void mNOT_EQ() throws RecognitionException {
        try {
            int _type = NOT_EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:109:8: ( '<>' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:110:2: '<>'
            {
            match("<>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT_EQ"

    // $ANTLR start "MORE"
    public final void mMORE() throws RecognitionException {
        try {
            int _type = MORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:112:6: ( '>' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:113:2: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MORE"

    // $ANTLR start "LESS"
    public final void mLESS() throws RecognitionException {
        try {
            int _type = LESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:115:6: ( '<' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:116:2: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LESS"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:118:4: ( '=' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:119:2: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "LIKE"
    public final void mLIKE() throws RecognitionException {
        try {
            int _type = LIKE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:121:6: ( 'like' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:122:2: 'like'
            {
            match("like"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LIKE"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:124:8: ( 'select' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:125:2: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:127:6: ( 'from' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:128:2: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:130:7: ( 'where' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:131:2: 'where'
            {
            match("where"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "ORDER_BY"
    public final void mORDER_BY() throws RecognitionException {
        try {
            int _type = ORDER_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:133:10: ( 'order by' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:134:2: 'order by'
            {
            match("order by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER_BY"

    // $ANTLR start "GROUP_BY"
    public final void mGROUP_BY() throws RecognitionException {
        try {
            int _type = GROUP_BY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:136:10: ( 'group by' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:137:2: 'group by'
            {
            match("group by"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GROUP_BY"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            int _type = DIGIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:139:7: ( '0' .. '9' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:140:2: '0' .. '9'
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

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            int _type = LETTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:142:8: ( 'A' .. 'Z' | 'a' .. 'z' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:146:7: ( ',' )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:147:2: ','
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:149:4: ( ( ' ' | '\\t' | '\\n' | '\\r' ) )
            // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:150:2: ( ' ' | '\\t' | '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:8: ( T__23 | T__24 | T__25 | CONDITION_OPERATOR | ORDER_DIRECTION | DOT | PLUS | MINUS | NOT_EQ | MORE | LESS | EQ | LIKE | SELECT | FROM | WHERE | ORDER_BY | GROUP_BY | DIGIT | LETTER | COMMA | WS )
        int alt3=22;
        alt3 = dfa3.predict(input);
        switch (alt3) {
            case 1 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:10: T__23
                {
                mT__23(); 

                }
                break;
            case 2 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:16: T__24
                {
                mT__24(); 

                }
                break;
            case 3 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:22: T__25
                {
                mT__25(); 

                }
                break;
            case 4 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:28: CONDITION_OPERATOR
                {
                mCONDITION_OPERATOR(); 

                }
                break;
            case 5 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:47: ORDER_DIRECTION
                {
                mORDER_DIRECTION(); 

                }
                break;
            case 6 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:63: DOT
                {
                mDOT(); 

                }
                break;
            case 7 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:67: PLUS
                {
                mPLUS(); 

                }
                break;
            case 8 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:72: MINUS
                {
                mMINUS(); 

                }
                break;
            case 9 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:78: NOT_EQ
                {
                mNOT_EQ(); 

                }
                break;
            case 10 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:85: MORE
                {
                mMORE(); 

                }
                break;
            case 11 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:90: LESS
                {
                mLESS(); 

                }
                break;
            case 12 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:95: EQ
                {
                mEQ(); 

                }
                break;
            case 13 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:98: LIKE
                {
                mLIKE(); 

                }
                break;
            case 14 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:103: SELECT
                {
                mSELECT(); 

                }
                break;
            case 15 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:110: FROM
                {
                mFROM(); 

                }
                break;
            case 16 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:115: WHERE
                {
                mWHERE(); 

                }
                break;
            case 17 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:121: ORDER_BY
                {
                mORDER_BY(); 

                }
                break;
            case 18 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:130: GROUP_BY
                {
                mGROUP_BY(); 

                }
                break;
            case 19 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:139: DIGIT
                {
                mDIGIT(); 

                }
                break;
            case 20 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:145: LETTER
                {
                mLETTER(); 

                }
                break;
            case 21 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:152: COMMA
                {
                mCOMMA(); 

                }
                break;
            case 22 :
                // C:\\Users\\asd\\workspaceBambrikii\\KBParser\\src\\test\\java\\org\\bambrikii\\kbParser\\dql\\grammar\\DqlGrammar.g:1:158: WS
                {
                mWS(); 

                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\4\uffff\3\23\3\uffff\1\32\2\uffff\5\23\6\uffff\1\26\10\uffff";
    static final String DFA3_eofS =
        "\41\uffff";
    static final String DFA3_minS =
        "\1\11\3\uffff\1\156\1\162\1\145\3\uffff\1\76\2\uffff\1\151\1\145"+
        "\1\162\1\150\1\162\6\uffff\1\144\10\uffff";
    static final String DFA3_maxS =
        "\1\172\3\uffff\1\163\1\162\1\145\3\uffff\1\76\2\uffff\1\151\1\145"+
        "\1\162\1\150\1\162\6\uffff\1\144\10\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\3\uffff\1\6\1\7\1\10\1\uffff\1\12\1\14\5\uffff"+
        "\1\23\1\24\1\25\1\26\1\4\1\5\1\uffff\1\11\1\13\1\15\1\16\1\17\1"+
        "\20\1\22\1\21";
    static final String DFA3_specialS =
        "\41\uffff}>";
    static final String[] DFA3_transitionS = {
            "\2\25\2\uffff\1\25\22\uffff\1\25\6\uffff\1\3\1\1\1\2\1\uffff"+
            "\1\10\1\24\1\11\1\7\1\uffff\12\22\2\uffff\1\12\1\14\1\13\2\uffff"+
            "\32\23\6\uffff\1\4\2\23\1\6\1\23\1\17\1\21\4\23\1\15\2\23\1"+
            "\5\3\23\1\16\3\23\1\20\3\23",
            "",
            "",
            "",
            "\1\26\4\uffff\1\27",
            "\1\30",
            "\1\27",
            "",
            "",
            "",
            "\1\31",
            "",
            "",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\40",
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
            return "1:1: Tokens : ( T__23 | T__24 | T__25 | CONDITION_OPERATOR | ORDER_DIRECTION | DOT | PLUS | MINUS | NOT_EQ | MORE | LESS | EQ | LIKE | SELECT | FROM | WHERE | ORDER_BY | GROUP_BY | DIGIT | LETTER | COMMA | WS );";
        }
    }
 

}