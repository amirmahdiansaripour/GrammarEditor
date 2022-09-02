grammar PartOfSpeech;
@header{
    import main.ast.*;
    import main.ast.partOfSpeech.*;
    import main.error.*;
    import java.util.*;
    import java.io.*;
}
import Lexer;

partOfSpeech [Sentence s, Boolean cap, String role]
    :
    subject[s, cap] | object[s, cap, role] | verb[s] | adverb[s, cap]
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

object [Sentence s, Boolean cap, String objecct] returns [OBject obj]
    :
    (IDENTIFIER{objecct += ($IDENTIFIER.text + " ");} SPACE)? WORD {objecct += $WORD.text;}
    {
        try{
            $obj = new OBject(objecct, cap, $s.getLine());
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
     MODAL SPACE WORD {verbText = $MODAL.text + " " + $WORD.text;}
     |
     PERFECT SPACE WORD {verbText = $PERFECT.text + " " + $WORD.text;}
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
    (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})? (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})?
    (ADV {adverb += $ADV.text;})
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
