lexer grammar Lexer;

PREPOSITION: ('in' | 'In' | 'at' | 'At' | 'on' | 'On' | 'next to' | 'Next to'
| 'to' | 'To' | 'into' | 'Into' | 'by' | 'By' | 'this' | 'This' | 'that' | 'That' | 'with' | 'With');

IDENTIFIER: ('a' | 'the' | 'A' | 'an' | 'An' | 'The' | 'some' | 'Some' | 'Most' | 'most' | 'Few' | 'few' | 'A few' | 'a few' |
'little' | 'Little' | 'A little' | 'a little' | 'More' | 'more');

ADV: ('every' | 'next' | 'last' | 'very' | 'Every' | 'Next' | 'Last' | 'Very' | 'each' | 'Each');

TOBE: ('am' | 'is' | 'are' | 'was' | 'were');

WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: (' ' | '\t');
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
