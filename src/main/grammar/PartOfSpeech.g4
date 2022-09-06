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
    word[s]
    {
        String subject = $word.ret;
        $sub = new Subject(subject, cap, $s.getLine());
        $s.addSubject($sub);
    }
    ;

object [Sentence s, Boolean cap, String objecct] returns [OBject obj]
    :
    word[s]
    {
        if(objecct != null) objecct += $word.ret;
        else objecct = $word.ret;
        $obj = new OBject(objecct, cap, $s.getLine());
        $s.addObject($obj);
    }
    ;

word [Sentence s] returns [String ret]:
    ((IDENTIFIER {$ret = ($IDENTIFIER.text + " ");} SPACE)? WORD { if($ret == null) $ret = $WORD.text; else $ret += $WORD.text;})
    (
    (SPACE CONJUNCTION SPACE {$ret += ( " " + $CONJUNCTION.text + " ");} (IDENTIFIER SPACE {$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;})
    |((COMMA SPACE {$ret += ("," + " ");} (IDENTIFIER SPACE{$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;})+
    (conjunction[s] SPACE {$ret += ($conjunction.t + " ");} (IDENTIFIER SPACE{$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;}))
    )?
;

verb [Sentence s] returns [Verb ver]
    :
    {String verbText = "";}
    (
     tobe SPACE word[s] {verbText = $tobe.ret + " " + $word.ret;}
     |
     modal SPACE word[s] {verbText = $modal.ret + " " + $word.ret;}
     |
     perfect (SPACE adverb[s, false])? SPACE word[s] {verbText = $perfect.ret + " " + $word.ret;}
     |
     word[s] {verbText = $word.ret;}
    )
    {
        $ver = new Verb(verbText, $s.getLine());
        $s.addVerb($ver);
    }
    ;

adverb [Sentence s, Boolean capital] returns [Adverb adv]
    :
    {String adverb = "";}
    (preposition SPACE {adverb += ($preposition.ret + " ");})? (preposition SPACE {adverb += ($preposition.ret + " ");})?
    (ADV {adverb += $ADV.text;})
    {
        $adv = new Adverb(adverb, capital, $s.getLine());
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

preposition returns [String ret]
    :
    PREPOSITION {$ret = $PREPOSITION.text;}
    ;

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