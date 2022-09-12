lexer grammar Lexer;
CONJUNCTION: 'and' | 'And' | 'but' | 'But' | 'or' | 'Or' | 'because' | 'Because' | 'Although' | 'although' |
'even though' | 'Even though';

PREPOSITION: 'in' | 'In' | 'at' | 'At' | 'on' | 'On' | 'next to' | 'Next to'
| 'to' | 'To' | 'into' | 'Into' | 'by' | 'By' | 'with' | 'With' | 'of' | 'for' |
'since' | 'Since';

IDENTIFIER: 'a' | 'the' | 'A' | 'an' | 'An' | 'The' | 'some' | 'Some' | 'Most' | 'most' | 'Few' | 'few' | 'A few' | 'a few' |
'little' | 'Little' | 'A little' | 'a little' | 'a lot of' | 'More' | 'more' | 'That' | 'that' | 'those' | 'Those' | 'this'
| 'This' | 'these' | 'These' | 'my' | 'My' | 'your' | 'Your' | 'his' | 'His' | 'Her' | 'her' | 'our' | 'Our' | 'other'
| 'Their' | 'their' | 'mine' | 'Mine' | 'Yours' | 'yours' | 'ours' | 'Ours' | 'theirs' | 'Theirs' | 'one' | 'two';

DAYS: 'Sunday' | 'Saturday' | 'Monday' | 'Tuesday' | 'Wednesday' | 'Thursday' | 'Friday';

INFINITIVE: 'to' SPACE (
'append' | 'add' | 'put' | 'decode' | 'write' | 'get' | 'access' | 'create' | 'read' | 'value' | 'size' | 'remove'|
'fill' | 'check' | 'draw' | 'do' | 'char' | 'print' | 'close' | 'paint' | 'start' | 'parse' | 'clone' | 'trace' |
'equal' | 'update' | 'index' | 'contain' | 'position' | 'debug' | 'handle' | 'reset' | 'type' | 'report' | 'end'|
'find' | 'clear' | 'load' | 'line' | 'log' | 'format' | 'make' | 'class' | 'encode' | 'fire' | 'insert' | 'visit' |
'dispose' | 'translate' | 'compare' | 'process' | 'copy' | 'send' | 'tell' | 'set' | 'intern' | 'register' | 'match' | 'default' |
'install' | 'invoke' | 'flush' | 'ensure' | 'wash' | 'replace' | 'skip' | 'repaint' | 'last' | 'notify' | 'convert' |
'limit' | 'trim' | 'pop' | 'peek' | 'send' | 'unlock' | 'throw' | 'push' | 'fine'
);

ADVERB: 'tomorrow'| 'Tomorrow'  | 'yesterday' | 'Yesterday' | 'very' | 'Very' | 'today' | 'class' | 'farm' | 'before' |
('on' SPACE (DAYS | 'the weekend')) | ('in' SPACE NUMBER) | ('in' SPACE MONTH) | 'probably' | 'actually' | 'indeed' | 'perhaps' |
(('every' | 'next' | 'last' | 'Every' | 'Next' | 'Last' | 'each' | 'Each') SPACE ('day' | 'night' |'morning' | MONTH |
'evening' | 'year' | 'month' | DAYS)) | 'daily' | 'monthly' | 'yearly' | 'interestingly' | 'Interestingly' | 'finally' | 'Finally' |
'lastly' | 'Lastly' | ('in the' | 'In the') SPACE ('evening' | 'morning' | 'ceremony' | 'glass') |
('at' | 'to' | 'in') SPACE (IDENTIFIER SPACE)? ('park' | 'university' | 'school' | 'coffee')
| 'in the ' ('future' | 'past') | 'in future' | 'particularly' | 'simply' | 'clearly' | 'instead' | 'certainly' | 'obviously' |
'just' | 'Recently' | 'recently' | 'lately' | 'Lately' | (('since' | 'Since') SPACE NUMBER) | 'easily' | 'immediately'
| 'never' | 'often' | 'usually' | 'seldom' | 'sometimes' | 'again' | 'hours' | 'tonight' | 'away'
;

MONTH:
'January' | 'February' | 'March' | 'April' | 'June' | 'July' |'August' | 'September' | 'October'
| 'November' | 'December'
;
SEASON:
'spring' | 'summer' | 'fall' | 'winter'
;
WORD: [A-Za-z]+;

TOBE:
(('am' | 'is' | 'are' | 'was' | 'were') (SPACE 'not')?) |
('have to' | 'has to' | 'had to' | 'had not to' | 'have not to' | 'has not to')
;

PERFECT: (('have' | 'Have' | 'Has' | 'has' | 'had' | 'Had') (SPACE 'not')?) | 'has been' | 'have been' |
'has not been' | 'have not been';
SIMPLENEG: ('did' | 'do' | 'does') (SPACE 'not')?;
MODAL: ('will' | 'would' | 'should' | 'must' | 'may' | 'can' | 'could')(SPACE 'not')?;
NUMBER: [0-9]+;
DOT: '.';
COMMA: ',';
SEMICOLON: ';';
SPACE: ' ' | '\t';
EXCLAMATION: '!';
QUESTION: '?';
NEWLINE: '\n' | '\r';
