grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech, Lexer;

completeSentence [Sentence s]
    :
        (subject[$s, $s.isCapital()] SPACE verb[$s])
         rest[$s]
//        | adverb[$s, true] COMMA SPACE subject[$s, false] SPACE verb[$s] (SPACE object[$s, false])?
//        (SPACE object[$s, false])? (SPACE adverb[$s, false])?
    ;

incompleteSentence [Sentence s] returns [Verb ver]
    :
    SIMPLEFORM {$ver = new Verb($SIMPLEFORM.text.substring(3), $s.getLine()); $s.addVerb($ver);}
    rest[$s]
    ;

rest[Sentence s]
    :
        {String object = "";}
        (
        (SPACE object[$s, false, null] SPACE PREPOSITION SPACE {object += ($PREPOSITION.text + " ");}
        (PREPOSITION {object += ($PREPOSITION.text + " ");} SPACE)? object[$s, false, object]) // I'll send a letter to him
        |
        (SPACE object[$s, false, null] SPACE object[$s, false, null])
        |  // I'll send him a letter
        (SPACE object[$s, false, null])    // I'll send a letter
        )?
        (SPACE adverb[$s, false])*
    ;
