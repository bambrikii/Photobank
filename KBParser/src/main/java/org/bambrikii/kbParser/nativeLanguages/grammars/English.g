grammar English;

options {
  language = Java;
  output = AST;
}
@parser::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}
@lexer::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}
/*
noun: ;
adjective:;
*/


article: header paragraph+;
paragraph:  '\n' sentence+;
header : (phrase | any_word )+ (',' (phrase | any_word)+)*;

phrase: (any_word) (WS any_word)+ ;
any_word : (WORD | NUMBER);

sentence: assertion | question | exclamation;

assertion: sentence_body DOT;
question: sentence_body QUESTION;
exclamation: sentence_body EXCLAMATION;

sentence_body: (phrase | any_word )+ ((COMMA | COLON) (phrase | any_word | elaboration)+)*;

elaboration: '(' elaboration_body ')';
elaboration_body: phrase | any_word;



NUMBER : '0'..'9'+;
SEMICOLON: ';';
COLON: ':';
DOT: '.';
EXCLAMATION: '!';
QUESTION: '?';
COMMA: ',';
WORD : LETTER (LETTER | DASH) LETTER+ (APOSTROPHE LETTER*)*;
APOSTROPHE : '\'';
LETTER : 'a'..'z' | 'A'..'Z';
DASH: '-';
WS : ' '+ { $channel = HIDDEN; };
