grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech, Lexer;

structure [Sentence s]
    :
//        (PREPOSITION SPACE {object += ($PREPOSITION.text + " ");})? (PREPOSITION SPACE {object += ($PREPOSITION.text + " ");})?
        (
        subject[$s, $s.isCapital()] SPACE verb[$s]
        {String object = "";}
        (
        SPACE object[$s, false, null] SPACE PREPOSITION {object += ($PREPOSITION.text + " ");} SPACE
        (PREPOSITION {object += ($PREPOSITION.text + " ");} SPACE)? object[$s, false, object] | // I'll send a letter to him
        SPACE object[$s, false, null] SPACE object[$s, false, null]  |  // I'll send him a letter
        SPACE object[$s, false, null]    // I'll send a letter
        )?
         (SPACE adverb[$s, false])*
//        | adverb[$s, true] COMMA SPACE subject[$s, false] SPACE verb[$s] (SPACE object[$s, false])?
//        (SPACE object[$s, false])? (SPACE adverb[$s, false])?
        )
    ;
