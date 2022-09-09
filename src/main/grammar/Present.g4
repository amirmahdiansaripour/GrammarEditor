grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech, Lexer;

sentenceStructure [Sentence s]
    :
        ((subject[$s, $s.isCapital()] SPACE verb[$s]))    // There was a ...
         arbitraryParts[$s]
//        | adverb[$s, true] COMMA SPACE subject[$s, false] SPACE verb[$s] (SPACE object[$s, false])?
//        (SPACE object[$s, false])? (SPACE adverb[$s, false])?
    ;

infinitivePhraseStructure [Sentence s] returns [Verb ver]
    :
        infinitive {$ver = new Verb($infinitive.ret.substring(3), $s.getLine()); $s.addVerb($ver);}
        arbitraryParts[$s]
    ;

relativePronoun: 'whose' | 'who' | 'which' | 'whom' | 'that';

relativeClauseStructure [Sentence s]
    :
        (SPACE relativePronoun SPACE subject[$s, false] SPACE verb[$s] arbitraryParts[$s])
        |
        ((COMMA)? SPACE relativePronoun SPACE subject[$s, false] SPACE verb[$s] arbitraryParts[$s] (COMMA)?)
        |
        (SPACE relativePronoun SPACE verb[$s] arbitraryParts[$s])
        |
        ((COMMA)? SPACE relativePronoun SPACE verb[$s] arbitraryParts[$s] (COMMA)?)
    ;

nounPhrase [Sentence s] returns [String ret]
    :
        ((so = (IDENTIFIER | 'that') {$ret = ($so.text + " ");} SPACE)? WORD { if($ret == null) $ret = $WORD.text; else $ret += $WORD.text;})
        (
            (SPACE conjunction[$s] SPACE {$ret += ( " " + $conjunction.t + " ");} ((IDENTIFIER | 'that') SPACE {$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;})
            |
            ((COMMA SPACE {$ret += ("," + " ");} ((IDENTIFIER | 'that') SPACE {$ret += ($IDENTIFIER.text + " ");})?
            WORD {$ret += $WORD.text;})+
            ((COMMA SPACE 'etc' {$ret += ", etc";}) | (COMMA SPACE {$ret += ("," + " ");} conjunction[$s] SPACE {$ret += ($conjunction.t + " ");} ((IDENTIFIER | 'that') SPACE{$ret += ($IDENTIFIER.text + " ");})? WORD {$ret += $WORD.text;})))
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
