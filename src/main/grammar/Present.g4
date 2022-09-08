grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech, Lexer;

sentenceStructure [Sentence s]
    :
        ((subject[$s, $s.isCapital()] SPACE verb[$s]) | (verb[$s] SPACE subject[$s, false]))    // There was a ...
         arbitraryParts[$s]
//        | adverb[$s, true] COMMA SPACE subject[$s, false] SPACE verb[$s] (SPACE object[$s, false])?
//        (SPACE object[$s, false])? (SPACE adverb[$s, false])?
    ;

infinitivePhraseStructure [Sentence s] returns [Verb ver]
    :
        infinitive {$ver = new Verb($infinitive.ret.substring(3), $s.getLine()); $s.addVerb($ver);}
        arbitraryParts[$s]
    ;

relativeClauseStructure [Sentence s]
    :
        RELATIVEPRONOUN SPACE (subject[$s, false] SPACE)? verb[$s] arbitraryParts[$s]
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
