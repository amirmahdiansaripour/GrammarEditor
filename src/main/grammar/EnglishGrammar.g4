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
        int line = 1;
        $textReturn = new Text();
        }
        (s = sentence[line] (NEWLINE {line = line + 1;} | SPACE)+ {$textReturn.addSentence($s.s);})+
    ;

sentence [int line] returns [Sentence s]
    :
        {
        $s = new Sentence();
        $s.setLine($line);
        }

        (subject SPACE{$s.addSubject($subject.text);} verb SPACE object SPACE adverb | adverb COMMA SPACE subject verb object) ENDPOINT


//        (word = WORD SPACE {$sentenceReturn.addSubject($word.text);})*
//
//
//        endWord = WORD{$sentenceReturn.addSubject($endWord.text);}
    ;

subject: WORD;
object: WORD;
verb: WORD;
adverb: WORD;

ENDPOINT: DOT | EXCLAMATION | QUESTION;
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: ('\n' | '\r');
