grammar EnglishGrammar;

@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}

import PartOfSpeech;

englishGrammar returns [Text whole]
    :
        NEWLINE* t = text {$whole = $t.textReturn;} NEWLINE* EOF
    ;
text returns [Text textReturn]
    :
        {
        int line = 1;
        int senIndex = 1;
        $textReturn = new Text();
        }
        (s = sentence[line, senIndex] {$textReturn.addSentence($s.s); senIndex++;} (NEWLINE {line++;}| SPACE)+)+
    ;

sentence [int line, int index] returns [Sentence s]
    :
        {
        $s = new Sentence();
        $s.setLine($line);
        $s.setIndex($index);
        }
        (
        subject[$s] SPACE verb[$s] (SPACE object[$s])? (SPACE adverb[$s])?
        | adverb[$s] COMMA SPACE subject[$s] SPACE verb[$s] SPACE object[$s]
        )
        ENDPOINT

//        (word = WORD SPACE {$s.addSubject($word.text);})*
//
//
//        endWord = WORD{$s.addSubject($endWord.text);}
    ;