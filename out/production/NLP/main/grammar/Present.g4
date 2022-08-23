grammar Present;
@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}
import PartOfSpeech;

present [Sentence s]
    :
        subject[$s] SPACE verb[$s] (SPACE object[$s])? (SPACE adverb[$s])?
        | adverb[$s] COMMA SPACE subject[$s] SPACE verb[$s] SPACE object[$s]
    ;
