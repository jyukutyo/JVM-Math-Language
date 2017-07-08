grammar Math;

prog
    : expr (EOF | NEWLINE)
    ;


expr
    : '(' expr ')'                                   #parensExpr
    | functionName '('argument? (',' argument)* ')'  #invoke
    | '->' expr                                      #asyncExpr
    | left=expr op=('*'|'/') right=expr              #infixExpr
    | left=expr op=('+'|'-') right=expr              #infixExpr
    | value=NUM                                      #numberExpr
    ;

functionName: ID;
argument: expr;

ID
    : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*
    ;


OP_ADD: '+';
OP_SUB: '-';
OP_MUL: '*';
OP_DIV: '/';

NUM: [0-9]+ ('.' [0-9]+)?;
WS: [ \t]+ -> skip;
COMMA: ',';

NEWLINE: '\r'? '\n';