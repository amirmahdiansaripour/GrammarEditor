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
        (firstSentence[line, senIndex] {$textReturn.addSentence($firstSentence.ret); senIndex++;})
        (
            sentence[line, senIndex]{line = $sentence.indexRet; $textReturn.addSentence($sentence.ret); senIndex++;}
            |
//            question[line, senIndex]{line = $question.indexRet; $textReturn.addSentence($question.ret); senIndex++;}
//            |
            infinitivePhrase[line, senIndex]{$textReturn.addSentence($infinitivePhrase.ret); senIndex++;}
        )*
    ;


firstSentence[int line, int index] returns [Sentence ret]
    :
    {
        $ret = new Sentence($line);
        $ret.setIndex($index);
        $ret.capitalize();
    }
    sentenceStructure[$ret]
    ;

sentence [int line, int index] returns [Sentence ret, int indexRet]
    :
    {
        $ret = new Sentence($line);
        $ret.setIndex($index);
    }
    (endpoint {$ret.capitalize();} | COMMA SPACE conjunction[$ret])
    (NEWLINE {$indexRet = $line + 1;}| SPACE {$indexRet = $line;})+
    {$ret.changeLine($indexRet);}
    sentenceStructure[$ret]
    ;

//question [int line, int index] returns [Sentence ret, int indexRet]
//    :
//    {
//        $ret = new Sentence($line);
//        $ret.setIndex($index);
//    }
//    (endpoint {$ret.capitalize();})
//    (NEWLINE {$indexRet = $line + 1;}| SPACE {$indexRet = $line;})+
//    {$ret.changeLine($indexRet);}
//    questionStructure[$ret]
//    ;

infinitivePhrase [int line, int index] returns [Sentence ret]
    :
    {
        $ret = new Sentence($line);
        $ret.setIndex($index);
    }
    SPACE
    infinitivePhraseStructure[$ret]
    ;


relativeClause [int line, int index] returns [Sentence ret]
    :
    {
        $ret = new Sentence($line);
        $ret.setIndex($index);
    }
    relativeClauseStructure[$ret]
    ;