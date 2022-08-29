grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech;

present [Sentence s]
    :
        (subject[$s, true] SPACE verb[$s] (SPACE object[$s])? (SPACE adverb[$s, false])?
        | adverb[$s, true] COMMA SPACE subject[$s, true] SPACE verb[$s] (SPACE object[$s])?


        )
    ;
