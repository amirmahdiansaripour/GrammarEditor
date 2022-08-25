grammar PartOfSpeech;
@header{
    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
    import java.util.*;
    import java.io.*;
}
partOfSpeech [Sentence s, Boolean cap]
    :
    subject[s] | object[s] | verb[s] | adverb[s, cap]
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
adverb [Sentence s, Boolean capital] returns [Adverb adv]
    :
    WORD
    {
        try{
            $adv = new Adverb($WORD.text, capital);
            $adv.setLine($s.getLine());
            $s.addAdverb($adv);
        }
        catch(IOException e){
            System.err.println("Adverbs' data not Found!");
            System.exit(0);
        }
    }
    ;
endpoint: (DOT | EXCLAMATION | QUESTION);
conjunction: (COMMA | SEMICOLON);

WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
