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
//////////////////////
    {String ret = "";}
    ((IDENTIFIER {ret = ($IDENTIFIER.text + " ");} SPACE)? WORD { if(ret == null) ret = $WORD.text; else ret += $WORD.text;})
    (
    (SPACE CONJUNCTION SPACE {ret += ( " " + $CONJUNCTION.text + " ");} (IDENTIFIER SPACE {ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})
    |((COMMA SPACE {ret += ("," + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})+
    (conjunction[s] SPACE {ret += ($conjunction.t + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;}))
    )?
////////////////////
    {
        String subject = ret;
        $sub = new Subject(subject, cap, $s.getLine());
        $s.addSubject($sub);
    }
    ;

object [Sentence s, Boolean cap, String objecct] returns [OBject obj]
    :
//////////////////////
    {String ret = "";}
    ((IDENTIFIER {ret = ($IDENTIFIER.text + " ");} SPACE)? WORD { if(ret == null) ret = $WORD.text; else ret += $WORD.text;})
    (
    (SPACE CONJUNCTION SPACE {ret += ( " " + $CONJUNCTION.text + " ");} (IDENTIFIER SPACE {ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})
    |((COMMA SPACE {ret += ("," + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})+
    (conjunction[s] SPACE {ret += ($conjunction.t + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;}))
    )?
////////////////////
    {
        if(objecct != null) objecct += ret;
        else objecct = ret;
        $obj = new OBject(objecct, cap, $s.getLine());
        $s.addObject($obj);
    }
    ;

verb [Sentence s] returns [Verb ver]
    :
    {String verbText = "";}
    (
     tobe SPACE WORD {verbText = $tobe.ret + " " + $WORD.text;}
     |
     modal SPACE WORD {verbText = $modal.ret + " " + $WORD.text;}
     |
     perfect (SPACE adverb[s, false])? SPACE WORD {verbText = $perfect.ret + " " + $WORD.text;}
     |
     WORD {verbText = $WORD.text;}
    )
    {
        $ver = new Verb(verbText, $s.getLine());
        $s.addVerb($ver);
    }
    ;

adverb [Sentence s, Boolean capital] returns [Adverb adv]
    :
//    (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})? (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})?
//    (WORD {adverb += $WORD.text;})
    {String ret = "";}
    ((IDENTIFIER {ret = ($IDENTIFIER.text + " ");} SPACE)? WORD { if(ret == null) ret = $WORD.text; else ret += $WORD.text;})
    (
    (SPACE CONJUNCTION SPACE {ret += ( " " + $CONJUNCTION.text + " ");} (IDENTIFIER SPACE {ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})
    |((COMMA SPACE {ret += ("," + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;})+
    (conjunction[s] SPACE {ret += ($conjunction.t + " ");} (IDENTIFIER SPACE{ret += ($IDENTIFIER.text + " ");})? WORD {ret += $WORD.text;}))
    )?
/////////////
    {
        $adv = new Adverb(ret, capital, $s.getLine());
        $s.addAdverb($adv);
    }
    ;


endpoint: DOT | EXCLAMATION | QUESTION;
conjunction[Sentence s] returns [String t]:
COMMA SPACE CONJUNCTION {
    $s.checkPreposition($CONJUNCTION.text, false);
    $t = ", " + $CONJUNCTION.text;
}
| SEMICOLON;

tobe returns [String ret]
    :
    TOBE {$ret = $TOBE.text;}
    ;
modal returns [String ret]
    :
    MODAL {$ret = $MODAL.text;}
    ;
perfect returns [String ret]
    :
    PERFECT {$ret = $PERFECT.text;}
    ;