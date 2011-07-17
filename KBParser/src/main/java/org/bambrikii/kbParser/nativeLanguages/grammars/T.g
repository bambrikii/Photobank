grammar T;

@parser::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}
@lexer::header {
  package org.bambrikii.kbParser.nativeLanguages.grammars;
}

def : modifier+ 'int' ID '=' INT ';'
    | modifier+ 'int' ID ';'
    ;
modifier : 'public' | 'static' ;
INT : '0'..'9'+ ;
ID  : 'a'..'z'+ ;
WS  : (' '|'\r'|'\n')+ {$channel = HIDDEN;} ;