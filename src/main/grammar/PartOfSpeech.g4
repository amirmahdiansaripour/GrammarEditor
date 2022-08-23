grammar PartOfSpeech;

@header{
    import main.ast.*;
    import main.ast.partOfSpeech.*;
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
adverb [Sentence s] returns [Adverb adv]
    :
    WORD
    {
    $adv = new Adverb($WORD.text);
    $adv.setLine($s.getLine());
    $adv.setIndex($s.getIndex());
    $s.addAdverb($adv);
    }
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
