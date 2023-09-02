# GrammarEditor

Detection of part of speech and some grammatical mistakes in English sentences through using parsing rules.

How to run: 

You should download the ANTLR tool for running the project. Please read 'Guidance for How to Run GrammarEditor.pdf' and install ANTLR.jar file included in the installation folder.

Brief explanation:

This project is mainly about how some sentence structures in English can be detected using parsing rules and trees, which I have been taught in the Theory of Computation and Compiler Design courses. When a sentence (more generally, a string) is matched with a pursing rule, the words in that string will receive their parts of speech. Consider the following compound sentence as an example:

`
I went to the park yesterday, but my brother did not come.
`

The structure of the above sentence is:

`
subject + verb + adverb + adverb + conjunction + subject + verb
`

(Pay attention that the main sentence itself is made up of two simple sentences connected by ', but' which is a conjunction). The output of GrammarEditor is:

![31](https://github.com/amirmahdiansaripour/SRAM/assets/92050925/e3b98b0c-2c66-4cdd-b4f4-3eb90bd50ec4)

GrammarEditor can also detect some grammatical mistakes when the parts of speech of all words in a sentence are determined. Please read the report included in the repository for more details about how GrammarEditor works.
