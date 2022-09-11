grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech, Lexer;

infinitivePhraseStructure [Sentence s] returns [Verb ver]
    :
        infinitive {$ver = new Verb($infinitive.ret, $s.getLine()); $s.setVerb($ver);}
        arbitraryParts[$s]
    ;

relativePronoun: 'whose' | 'who' | 'which' | 'whom' | 'that' | 'where';

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
            (SPACE conjunction[$s] SPACE {$ret += ( " " + $conjunction.t + " ");} (s1 = (IDENTIFIER | 'that') SPACE {$ret += ($s1.text + " ");})? WORD {$ret += $WORD.text;})
            |
            (
                (COMMA SPACE {$ret += ("," + " ");} (s2 = (IDENTIFIER | 'that') SPACE {$ret += ($s2.text + " ");})?
                WORD {$ret += $WORD.text;})+
                (
                    (COMMA SPACE {$ret += ", ";})
                    (
                        ('etc' {$ret += "etc";})
                        |
                        (conjunction[$s] SPACE {$ret += ($conjunction.t + " ");}
                        (s3 = (IDENTIFIER | 'that') SPACE {$ret += ($s3.text + " ");})? WORD {$ret += $WORD.text;})
                    )
                )
            )
        )?
    ;

sentenceStructure [Sentence s]
    :
        (subject[$s, $s.isCapital()] SPACE verb[$s])
         arbitraryParts[$s]
    ;

arbitraryParts[Sentence s]
    :
        {String object = "";}
        (
            (SPACE object[$s, false, null] SPACE preposition SPACE {object += ($preposition.ret + " ");}
            (preposition {object += ($preposition.ret + " ");} SPACE)? object[$s, false, object])
            | // I'll send a letter to him
            (SPACE object[$s, false, null] SPACE object[$s, false, null])
            |  // I'll send him a letter
            (SPACE object[$s, false, null])    // I'll send a letter
        )?
        (SPACE adverb[$s, false])*
    ;
