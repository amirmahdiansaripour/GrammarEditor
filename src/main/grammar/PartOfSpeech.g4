grammar PartOfSpeech;

@header{
    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
    import java.util.*;
    import java.io.*;
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
        try{
            $adv = new Adverb($WORD.text);
            $adv.setLine($s.getLine());
            $s.addAdverb($adv);
        }
        catch(IOException e){
            System.err.println("Adverbs' data not Found!");
            System.exit(0);
        }
    }
    ;

ENDPOINT: (DOT | EXCLAMATION | QUESTION);
CONJUNCTION: (COMMA | SEMICOLON);
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
