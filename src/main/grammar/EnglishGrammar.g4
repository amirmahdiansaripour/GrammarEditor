grammar EnglishGrammar;

@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}

import PartOfSpeech, Present, Lexer;

englishGrammar returns [Text whole]
    :
        NEWLINE* t = text {$whole = $t.textReturn;} (endpoint NEWLINE* EOF)
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
    $s = new Sentence($line);
    $s.setIndex($index);
    $s.capitalize();
    }
    structure[$s]
    ;

sentence [int line, int index] returns [Sentence s, int indexRet]
    :
        {
        $s = new Sentence($line);
        $s.setIndex($index);
        }
        (endpoint {$s.capitalize();} | conjunction)
        (NEWLINE {$indexRet = $line + 1;}| SPACE {$indexRet = $line;})+
        {$s.changeLine($indexRet);}
        structure[$s]
    ;

structure [Sentence s]
    :
    (
    present[$s]
    )
    ;