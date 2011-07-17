grammar DqlGrammar;

options {
	language	= Java;
	output			= AST;
 //ASTLabelType			= CommonTree;
 //TokenLabelType	= Token;
 //backtrack	= true;
	memoize		= true;
}

@parser::header {
package org.bambrikii.kbParser.dql.grammar;
}

@lexer::header {
package org.bambrikii.kbParser.dql.grammar;
}

query :
	select WS!+ from ( WS!+ where )? ( WS!+ group_by )?;

select :
	SELECT^ WS!+ column ( elements_delimiter! column )*;

from :
	FROM^ WS!+ table ( elements_delimiter! table )*;

where :
	WHERE^ WS!+ condition_expr_aggr ( elements_delimiter! condition_expr_aggr )*;

order_by :
	ORDER_BY^ order_expr ( elements_delimiter! order_expr )*;

group_by :
	GROUP_BY WS!+ column ( elements_delimiter! column )*;

condition_expr_aggr :
	'(' WS!* condition_expr ( WS!+ CONDITION_OPERATOR^ WS!+ condition_expr_aggr )* WS!* ')';

condition_expr :
	column WS!* condition_func^ WS!* expression;

condition_func :
	NOT_EQ
	| MORE
	| LESS
	| EQ
	| LIKE;

expression :
	number_expr
	| string_expr;

number_expr :
	(
		PLUS
		| MINUS^
	)?
	DIGIT+ ( DOT DIGIT+ )?;

string_expr :
	'\''
	(
		DIGIT
		| LETTER
	)*
	'\'';

order_expr :
	column^ ( WS!+ ORDER_DIRECTION )?;

column :
	LETTER
	(
		LETTER
		| DIGIT
	)*;

table :
	LETTER
	(
		LETTER
		| DIGIT
	)*;

elements_delimiter :
	WS* COMMA WS*;

CONDITION_OPERATOR :
	'and'
	| 'or';

ORDER_DIRECTION :
	(
		'desc'
		| 'asc'
	);

DOT :
	'.';

PLUS :
	'+';

MINUS :
	'-';

NOT_EQ :
	'<>';

MORE :
	'>';

LESS :
	'<';

EQ :
	'=';

LIKE :
	'like';

SELECT :
	'select';

FROM :
	'from';

WHERE :
	'where';

ORDER_BY :
	'order by';

GROUP_BY :
	'group by';

DIGIT :
	'0'..'9';

LETTER :
	'A'..'Z'
	| 'a'..'z';

COMMA :
	',';

WS :
	(
		' '
		| '\t'
		| '\n'
		| '\r'
	);
