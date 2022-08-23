grammar EnglishGrammar;

@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}

import PartOfSpeech, Present;

englishGrammar returns [Text whole]
    :
        NEWLINE* t = text {$whole = $t.textReturn;} (ENDPOINT NEWLINE* EOF)
    ;
text returns [Text textReturn]
    :
        {
        int line = 1;
        int senIndex = 1;
        $textReturn = new Text();
        }
        (fs = firstSentence[line, senIndex] {$textReturn.addSentence($fs.s); senIndex++;})
        (s = sentence[line, senIndex] {$textReturn.addSentence($s.s); senIndex++; line = $s.indexRet;})*
    ;

firstSentence[int line, int index] returns [Sentence s]
    :
    {
    $s = new Sentence();
    $s.setLine($line);
    $s.setIndex($index);
    $s.capitalize();
    }
    structure[$s]
    ;

sentence [int line, int index] returns [Sentence s, int indexRet]
    :
        {
        $s = new Sentence();
        $s.setIndex($index);
        }
        (ENDPOINT {$s.capitalize();} | CONJUNCTION)
        (NEWLINE {$indexRet = $line + 1;}| SPACE {$indexRet = $line;})+
        {$s.setLine($indexRet);}
        structure[$s]
    ;

structure [Sentence s]
    :
    (
    present[$s]
    )
    ;