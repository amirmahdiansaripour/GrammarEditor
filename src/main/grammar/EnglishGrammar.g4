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
        (
        s = sentence[line, senIndex]{line = $s.indexRet; $textReturn.addSentence($s.s); senIndex++;}
        |
        c = infinitivePhrase[line, senIndex]{$textReturn.addSentence($c.s); senIndex++;}
        )*
    ;

firstSentence[int line, int index] returns [Sentence s]
    :
    {
    $s = new Sentence($line);
    $s.setIndex($index);
    $s.capitalize();
    }
    sentenceStructure[$s]
    ;

sentence [int line, int index] returns [Sentence s, int indexRet]
    :
    {
    $s = new Sentence($line);
    $s.setIndex($index);
    }
    (endpoint {$s.capitalize();} | COMMA SPACE conjunction[$s])
    (NEWLINE {$indexRet = $line + 1;}| SPACE {$indexRet = $line;})+
    {$s.changeLine($indexRet);}
    sentenceStructure[$s]
    ;

infinitivePhrase [int line, int index] returns [Sentence s]
    :
    {
    $s = new Sentence($line);
    $s.setIndex($index);
    }
    SPACE
    infinitivePhraseStructure[$s]
    ;


relativeClause [int line, int index] returns [Sentence s]
    :
    {
    $s = new Sentence($line);
    $s.setIndex($index);
    }
    relativeClauseStructure[$s]
    ;