lexer grammar Lexer;

PREPOSITION: 'in' | 'In' | 'at' | 'At' | 'on' | 'On' | 'next to' | 'Next to'
| 'to' | 'To' | 'into' | 'Into' | 'by' | 'By' | 'with' | 'With' |
'since' | 'Since';

IDENTIFIER: 'a' | 'the' | 'A' | 'an' | 'An' | 'The' | 'some' | 'Some' | 'Most' | 'most' | 'Few' | 'few' | 'A few' | 'a few' |
'little' | 'Little' | 'A little' | 'a little' | 'More' | 'more' | 'that' | 'That' | 'those' | 'Those' | 'this'
| 'This' | 'these' | 'These' | 'my' | 'My' | 'your' | 'Your' | 'his' | 'His' | 'Her' | 'her' | 'our' | 'Our'
| 'Their' | 'their' | 'mine' | 'Mine' | 'Yours' | 'yours' | 'ours' | 'Ours' | 'theirs' | 'Theirs';

DAYS: 'Sunday' | 'Saturday' | 'Monday' | 'Tuesday' | 'Wednesday' | 'Thursday' | 'Friday';

ADV:
('tomorrow'| 'Tomorrow'  | 'yesterday' | 'Yesterday' | 'very' | 'Very') | 'today' |
('on' SPACE DAYS) |
(('every' | 'next' | 'last' | 'Every' | 'Next' | 'Last' | 'each' | 'Each') SPACE ('day' | 'night' |'morning' |
'evening' | DAYS)) |
('in the' | 'In the') SPACE ('evening' | 'morning') | 'at' SPACE ('park' | 'university' | 'school')
| 'in the ' ('future' | 'past') | 'in future' |
'just' | 'Recently' | 'recently' | 'lately' | 'Lately' | (('since' | 'Since') SPACE NUMBER);

CONJUNCTIONWORD: 'and' | 'And' | 'but' | 'But' | 'or' | 'Or' | 'because' | 'Because' | 'Although' | 'although' |
'even though' | 'Even though';

TOBE: 'am' | 'is' | 'are' | 'was' | 'were';
PERFECT: 'have' | 'Have' | 'Has' | 'has' | 'had' | 'Had';
MODAL: 'will' | 'would' | 'should' | 'must' | 'may' | 'can' | 'could';
NUMBER: [0-9]+;
WORD: [A-Za-z0-9]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: ' ' | '\t';
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
