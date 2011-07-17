grammar Armenian;

options {
  language = Java;
}

@parser::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}

@lexer::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}

sentence: (phrase | WORD )+ (',' (phrase | WORD)+)? '.';

phrase: WORD (WS WORD)+ ;

WORD : 'a'..'z'+ ;
WS : ' '+ { $channel = HIDDEN; };
