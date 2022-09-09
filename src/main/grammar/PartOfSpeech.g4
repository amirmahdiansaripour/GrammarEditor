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

nounPhrase [Sentence s] returns [String ret]
    :
        ((so = IDENTIFIER {$ret = ($so.text + " ");} SPACE)? WORD { if($ret == null) $ret = $WORD.text; else $ret += $WORD.text;})
        (
            (SPACE conjunction[$s] SPACE {$ret += ( " " + $conjunction.t + " ");} (IDENTIFIER SPACE {$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;})
            |
            ((COMMA SPACE {$ret += ("," + " ");} (IDENTIFIER SPACE{$ret += ($IDENTIFIER.text + " ");})?
            WORD {$ret += $WORD.text;})+
            (COMMA SPACE 'etc' {$ret += ", etc";}) | (COMMA SPACE {$ret += ("," + " ");} conjunction[$s] SPACE {$ret += ($conjunction.t + " ");} (IDENTIFIER SPACE{$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;}))
        )?
    ;

arbitraryParts[Sentence s]
    :
        {String object = "";}
        (
            (SPACE object[$s, false, null] SPACE preposition SPACE {object += ($preposition.ret + " ");}
            (preposition {object += ($preposition.ret + " ");} SPACE)? object[$s, false, object]) // I'll send a letter to him
            |
            (SPACE object[$s, false, null] SPACE object[$s, false, null])
            |  // I'll send him a letter
            (SPACE object[$s, false, null])    // I'll send a letter
        )?
        (SPACE adverb[$s, false])*
    ;

relativeClauseStructure [Sentence s]
    :
        (SPACE RELATIVEPRONOUN SPACE subject[$s, false] SPACE verb[$s] arbitraryParts[$s])
        |
        ((COMMA)? SPACE RELATIVEPRONOUN SPACE subject[$s, false] SPACE verb[$s] arbitraryParts[$s] (COMMA)?)
        |
        (SPACE RELATIVEPRONOUN SPACE verb[$s] arbitraryParts[$s])
        |
        ((COMMA)? SPACE RELATIVEPRONOUN SPACE verb[$s] arbitraryParts[$s] (COMMA)?)
    ;

subject [Sentence s, Boolean cap] returns [Subject sub]
    :
        (sp = 'I' | 'he' | 'she' | 'it' | 'they' | nounPhrase[s])
        {
            String subject;
            if($sp.text == null) subject = $nounPhrase.ret;
            else        subject = $sp.text;
            $sub = new Subject(subject, cap, $s.getLine());
            $s.addSubject($sub);
        }
        (relativeClauseStructure[s])?
    ;

object [Sentence s, Boolean cap, String objecct] returns [OBject obj]
    :
        nounPhrase[s]
        {
            if(objecct != null) objecct += $nounPhrase.ret;
            else objecct = $nounPhrase.ret;
            $obj = new OBject(objecct, cap, $s.getLine());
            $s.addObject($obj);
        }
        (relativeClauseStructure[s])?
    ;

verb [Sentence s] returns [Verb ver]
    :
        {String verbText = "";}
        (
         (t = ('There' | 'there') SPACE TOBE {verbText = $t.text + " " + $TOBE.text;})
         |
         SIMPLENEG SPACE WORD {verbText = $SIMPLENEG.text + " " + $WORD.text;}
         |
         TOBE SPACE WORD {verbText = $TOBE.text + " " + $WORD.text;}
         |
         MODAL SPACE WORD {verbText = $MODAL.text + " " + $WORD.text;}
         |
         PERFECT (SPACE adverb[s, false])? SPACE WORD {verbText = $PERFECT.text + " " + $WORD.text;}
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
        {String adverb = "";}
        (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})? (PREPOSITION SPACE {adverb += ($PREPOSITION.text + " ");})?
        (IDENTIFIER SPACE)? ADV {adverb += $ADV.text;}
        {
            $adv = new Adverb(adverb, capital, $s.getLine());
            $s.addAdverb($adv);
        }
    ;


endpoint: DOT | EXCLAMATION | QUESTION;

conjunction[Sentence s] returns [String t]
    :
        CONJUNCTION {
            $s.checkPreposition($CONJUNCTION.text, false);
            $t = ", " + $CONJUNCTION.text;
        }
        | SEMICOLON
    ;

preposition returns [String ret]
    :
        PREPOSITION {$ret = $PREPOSITION.text;}
    ;

infinitive returns [String ret]
    :
        INFINITIVE {$ret = $INFINITIVE.text;}
    ;
