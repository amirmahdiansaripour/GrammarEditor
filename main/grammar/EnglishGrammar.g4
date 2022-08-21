grammar EnglishGrammar;

@header{
    import main.ast.*;
    imort main.error.*;
    import java.util.*;
}

englishGrammar returns [Text text]
    :
    ;
IDENTIFIER
    :
    [0-9]+
    ;

