lexer grammar Lexer;

PREPOSITION: ('in' | 'In' | 'at' | 'At' | 'on' | 'On' | 'next to' | 'Next to'
| 'to' | 'To' | 'into' | 'Into' | 'by' | 'By' | 'this' | 'This' | 'that' | 'That' | 'with' | 'With');

IDENTIFIER: ('a' | 'the' | 'A' | 'an' | 'An' | 'The' | 'some' | 'Some' | 'Most' | 'most' | 'Few' | 'few' | 'A few' | 'a few' |
'little' | 'Little' | 'A little' | 'a little' | 'More' | 'more');

DAYS: 'Sunday' | 'Saturday' | 'Monday' | 'Tuesday' | 'Wednesday' | 'Thursday' | 'Friday';

ADV:
('every' | 'next' | 'last' | 'Every' | 'Next' | 'Last' | 'each' | 'Each') SPACE ('day' | 'night' |'morning' |
'evening' | DAYS)
| 'on' SPACE DAYS
| 'tomorrow'| 'very' | 'Very';

TOBE: ('am' | 'is' | 'are' | 'was' | 'were');
MODAL: ('will' | 'would' | 'should' | 'must' | 'may' | 'can' | 'could');

WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
