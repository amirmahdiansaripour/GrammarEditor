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
    {
     String verbText = "";
     String root = "";
    }
     (TOBE SPACE WORD {
      int len = $WORD.text.length();
          if(len > 3 && $WORD.text.substring(len - 3).equals("ing")){
              verbText = $TOBE.text + " " + $WORD.text;
              root = $WORD.text.substring(0, len - 3);
          }
      }
     |
      WORD {verbText = $WORD.text; root = $WORD.text;}
     )
     {
        try{
            $ver = new Verb(verbText, root);
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
    {String adverb = "";}
    (ADV SPACE {adverb += ($ADV.text + " ");})? WORD {adverb += $WORD.text;}
    {
        try{
            $adv = new Adverb(adverb, capital);
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

ADV: ('every' | 'next' | 'last' | 'very' | 'Every' | 'Next' | 'Last' | 'Very');
TOBE: ('am' | 'is' | 'are' | 'was' | 'were');
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
