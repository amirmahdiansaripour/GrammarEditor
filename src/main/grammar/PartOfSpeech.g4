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
    {String subject = "";}
    (IDENTIFIER{subject += ($IDENTIFIER.text + " ");} SPACE)? WORD {subject += $WORD.text;}
    {
        try{
            $sub = new Subject(subject, cap, $s.getLine());
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
    {String object = "";}
    (PREPOSITION SPACE {object += ($PREPOSITION.text + " ");})? (IDENTIFIER{object += ($IDENTIFIER.text + " ");} SPACE)? WORD {object += $WORD.text;}
    {
        try{
            $obj = new OBject(object, cap, $s.getLine());
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
    {String verbText = "";}
    (
     TOBE SPACE WORD {verbText = $TOBE.text + " " + $WORD.text;}
     |
     WORD {verbText = $WORD.text;}
    )
    {
     try{
        $ver = new Verb(verbText, $s.getLine());
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
    {String adverb = "";}
    (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})? (ADV SPACE {adverb += ($ADV.text + " ");})? WORD {adverb += $WORD.text;}
    {
        try{
            $adv = new Adverb(adverb, capital, $s.getLine());
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

PREPOSITION: ('in' | 'at' | 'on' | 'next to' | 'to' | 'into' | 'by');
IDENTIFIER: ('a' | 'the' | 'A' | 'The');
ADV: ('every' | 'next' | 'last' | 'very' | 'Every' | 'Next' | 'Last' | 'Very' | 'each' | 'Each');
TOBE: ('am' | 'is' | 'are' | 'was' | 'were');
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
