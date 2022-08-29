grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech;

present [Sentence s]
    :
        (subject[$s, true] SPACE verb[$s] (SPACE object[$s, false])? (SPACE adverb[$s, false])?
        | adverb[$s, true] COMMA SPACE subject[$s, false] SPACE verb[$s] (SPACE object[$s, false])?
        )
    ;
