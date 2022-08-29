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
    subject[s, cap] | object[s] | verb[s] | adverb[s, cap]
    ;

subject [Sentence sentnce, Boolean cap] returns [Subject sub]
    :
    WORD {$sentnce.addSubject($WORD.text);}
    ;
object [Sentence sentnce]
    :
    WORD {$sentnce.addObject($WORD.text);}
    ;

verb [Sentence s] returns [Verb ver]
    :
     WORD
     {
        try{
            $ver = new Verb($WORD.text);
            $ver.setLine($s.getLine());
            $s.addVerb($ver);
        }
        catch(IOException e){
            System.err.println("Verbs' data not Found!");
            System.exit(0);
        }
     }
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
