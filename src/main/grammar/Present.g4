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
