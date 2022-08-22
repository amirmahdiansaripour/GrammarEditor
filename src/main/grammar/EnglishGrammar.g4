grammar EnglishGrammar;

@header{
    import main.ast.*;
    import main.error.*;
    import java.util.*;
}

englishGrammar returns [Text whole]
    :
        NEWLINE* t = text {$whole = $t.textReturn;} NEWLINE* EOF
    ;
text returns [Text textReturn]
    :
        {
        $textReturn = new Text();
        $textReturn.setLine(1);
        }
        (s = sentence NEWLINE* {$textReturn.addSentence($s.sentenceReturn);})+
    ;

sentence returns [Sentence sentenceReturn]
    :
        (word = WORD
        {
        $sentenceReturn = new Sentence();
        $sentenceReturn.addSubject($word.text);
        }
        )+
        (DOT | EXCLAMATION | QUESTION)
    ;

WORD: [A-Za-z]+;
DOT: '.';
COLON: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t')->skip;
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: ('\n' | '\r')->skip;
