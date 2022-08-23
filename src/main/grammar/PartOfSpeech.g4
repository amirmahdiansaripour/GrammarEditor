grammar PartOfSpeech;

@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
partOfSpeech [Sentence s]
    :
    subject[s] | object[s] | verb[s] | adverb[s]
    ;

subject [Sentence sentnce]
    :
    WORD {$sentnce.addSubject($WORD.text);}
    ;
object [Sentence sentnce]
    :
    WORD {$sentnce.addObject($WORD.text);}
    ;
verb [Sentence sentnce]
    :
     WORD {$sentnce.addVerb($WORD.text);}
    ;
adverb [Sentence sentnce]
    :
    WORD {$sentnce.addAdverb($WORD.text);}
    ;

ENDPOINT: (DOT | EXCLAMATION | QUESTION)(NEWLINE)?;
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
