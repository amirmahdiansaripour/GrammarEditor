lexer grammar Lexer;
CONJUNCTION: 'and' | 'And' | 'but' | 'But' | 'or' | 'Or' | 'because' | 'Because' | 'Although' | 'although' |
'even though' | 'Even though';

PREPOSITION: 'in' | 'In' | 'at' | 'At' | 'on' | 'On' | 'next to' | 'Next to'
| 'to' | 'To' | 'into' | 'Into' | 'by' | 'By' | 'with' | 'With' | 'of' |
'since' | 'Since';

IDENTIFIER: 'a' | 'the' | 'A' | 'an' | 'An' | 'The' | 'some' | 'Some' | 'Most' | 'most' | 'Few' | 'few' | 'A few' | 'a few' |
'little' | 'Little' | 'A little' | 'a little' | 'More' | 'more' | 'That' | 'that' | 'those' | 'Those' | 'this'
| 'This' | 'these' | 'These' | 'my' | 'My' | 'your' | 'Your' | 'his' | 'His' | 'Her' | 'her' | 'our' | 'Our'
| 'Their' | 'their' | 'mine' | 'Mine' | 'Yours' | 'yours' | 'ours' | 'Ours' | 'theirs' | 'Theirs' | 'one' | 'two';

DAYS: 'Sunday' | 'Saturday' | 'Monday' | 'Tuesday' | 'Wednesday' | 'Thursday' | 'Friday';

ADV:
('tomorrow'| 'Tomorrow'  | 'yesterday' | 'Yesterday' | 'very' | 'Very') | 'today' | 'class' | 'farm' | 'before' |
('on' SPACE DAYS) |
(('every' | 'next' | 'last' | 'Every' | 'Next' | 'Last' | 'each' | 'Each') SPACE ('day' | 'night' |'morning' |
'evening' | 'year' | DAYS)) |
('in the' | 'In the') SPACE ('evening' | 'morning') | 'at' SPACE ('park' | 'university' | 'school')
| 'in the ' ('future' | 'past') | 'in future' |
'just' | 'Recently' | 'recently' | 'lately' | 'Lately' | (('since' | 'Since') SPACE NUMBER);

INFINITIVE: 'to' SPACE (
'append' | 'add' | 'put' | 'decode' | 'write' | 'get' | 'access' | 'create' | 'read' | 'value' | 'size' | 'remove'|
'fill' | 'check' | 'draw' | 'do' | 'char' | 'print' | 'close' | 'paint' | 'start' | 'parse' | 'clone' | 'trace' |
'equal' | 'update' | 'index' | 'contain' | 'position' | 'debug' | 'handle' | 'reset' | 'type' | 'report' | 'end'|
'find' | 'clear' | 'load' | 'line' | 'log' | 'format' | 'make' | 'class' | 'encode' | 'fire' | 'insert' | 'visit' |
'dispose' | 'translate' | 'compare' | 'process' | 'copy' | 'send' | 'tell' | 'set' | 'intern' | 'register' | 'match' | 'default' |
'install' | 'invoke' | 'flush' | 'ensure' | 'wash' | 'replace' | 'skip' | 'repaint' | 'last' | 'notify' | 'convert' |
'limit' | 'trim' | 'pop' | 'peek' | 'send' | 'unlock' | 'throw' | 'push' | 'fine'
);
TOBE: ('am' | 'is' | 'are' | 'was' | 'were') (SPACE 'not')?;
PERFECT: (('have' | 'Have' | 'Has' | 'has' | 'had' | 'Had') (SPACE 'not')?) | 'has been' | 'have been' |
'has not been' | 'have not been';
SIMPLENEG: ('did' | 'do' | 'does') (SPACE 'not')?;
MODAL: ('will' | 'would' | 'should' | 'must' | 'may' | 'can' | 'could')(SPACE 'not')?;
NUMBER: [0-9]+;
WORD: [A-Za-z]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: ' ' | '\t';
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
