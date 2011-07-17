grammar T2;

options {
	language	= Java;
	output			= AST;
}

@parser::header {
package org.bambrikii.kbParser.nativeLanguages.grammars;
}

@lexer::header {
package org.bambrikii.kbParser.nativeLanguages.grammars;
}
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/


article :
	paragraph+;

paragraph :
	sentence ( SPACE sentence )* NEW_LINE;

sentence :
	phrase_group ( phrase_group )*
	(
		DOT
		| QUESTION
		| EXCLAIMATION
	);

phrase_group :
	phrase
	(
		(
			COMMA
			| SEMICOLON
			| ( COMMA SEMICOLON )
			| ( SPACE DASH )
		)
		SPACE phrase
	)*;

phrase :
/*
	nominative_phrase
	| infinitive_phrase
	|*/

	basic_phrase;
// Core constructs
// Grammar constructs
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

/*
infinitive_phrase :
	INFINITE_CONJUNCTION ( SPACE word )+;

nominative_phrase :
	grammar_article ( SPACE word )+;
*/
basic_phrase :
	word ( SPACE word )*;

word :
	WORD ( DASH WORD )*;
/*
grammar_article :
	DEFINITE_ARTICLE
	| INDEFINITE_ARTICLE;

INDEFINITE_ARTICLE :
	'A'
	| 'a';

DEFINITE_ARTICLE :
	'The'
	| 'the';

INFINITE_CONJUNCTION :
	'To'
	| 'to';
*/
DIGIT :
	'0'..'9';

WORD :
	(
		'a'..'z'
		| 'A'..'Z'
	)+;

EXCLAIMATION :
	'!';

QUESTION :
	'?';

DOT :
	'.';

COMMA :
	',';

SEMICOLON :
	';';

DASH :
	'-';

SPACE :
	' '
     {
      $channel = HIDDEN;
     };

NEW_LINE :
	(
		| '\r'
		| '\n'
	)

  {
   $channel = HIDDEN;
  };
