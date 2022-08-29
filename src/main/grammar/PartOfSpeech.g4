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
    subject[s, cap] | object[s, cap] | verb[s] | adverb[s, cap]
    ;

subject [Sentence s, Boolean cap] returns [Subject sub]
    :
    WORD
    {
        try{
            $sub = new Subject($WORD.text, cap);
            $sub.setLine($s.getLine());
            $s.addSubject($sub);
        }
        catch(IOException e){
            System.err.println("Nouns' data not Found!");
            System.exit(0);
        }
    }
    ;

object [Sentence s, Boolean cap] returns [OBject obj]
    :
    WORD {
        try{
            $obj = new OBject($WORD.text, cap);
            $obj.setLine($s.getLine());
            $s.addObject($obj);
        }
        catch(IOException e){
            System.err.println("Nouns' data not Found!");
            System.exit(0);
        }
    }
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
