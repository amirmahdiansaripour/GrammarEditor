package main.ast.partOfSpeech;

import main.ast.Word;
import main.error.GrammarError;
import main.visitor.IVisitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Subject extends Word {
    protected static ArrayList<String> pluralExceptions = new ArrayList<String>(Arrays.asList("the police",
            "people", "the blind", "the poor", "the rich"));
    protected static ArrayList<String> singularExceptions = new ArrayList<String>(Arrays.asList("mumps",
            "measles", "physics", "mathematics", "news", "information", "evidence", "equipment"));
    private ArrayList<String> count;
    public Subject(String t, Boolean cap, int line_){
        super(t, cap, line_);
        count = new ArrayList<String>();
        setCount();
//        System.out.println(text + " " + count);
//        nounDataset = makeDataSet("", nounDataset);
    }

    public Boolean checkSuffix(String sub, String suffix){
        if(sub.length() > suffix.length() && sub.substring(sub.length() - suffix.length()).equals(suffix)){
            String withoutSuffix = sub.substring(0, sub.length() - suffix.length());
            if(singularExceptions.contains(withoutSuffix) || pluralExceptions.contains(withoutSuffix)){
                return false;
            }
        }
        return true;
    }

    public void setCountBasedOnPronouns(String sub, int firstIndex){
        if(sub.equals("he") || sub.equals("she") || sub.equals("it") || singularExceptions.contains(sub)){
            count.add("has"); count.add("was"); count.add("is"); count.add("does");
        }
        else if(sub.equals("i")){
            count.add("have"); count.add("was"); count.add("am"); count.add("do");
        }
        else if(sub.equals("you") || sub.equals("we") || sub.equals("they") || pluralExceptions.contains(sub)){
            count.add("have"); count.add("were"); count.add("are"); count.add("do");
        }
        else if(sub.contains("a ") || sub.contains("an ")){
            count.add("has"); count.add("was"); count.add("is"); count.add("does");
        }
        else if(firstIndex != -1){
            String first = sub.substring(0, firstIndex);

        }
    }

    public void setCount(){
        String sub = text.toLowerCase();
        int firstSpaceIndex = text.indexOf(' ');
        int lastSpaceIndex = text.lastIndexOf(' ');
        setCountBasedOnPronouns(sub, firstSpaceIndex);

//        else{ // s and es for plurals
//            Boolean sSuffix = checkSuffix(sub, "s");
//            Boolean esSuffix = checkSuffix(sub, "es");
//            if(!(sSuffix && esSuffix)){
//                errors.add(new GrammarError.IsntCorrect(line, text));
//            }
//            else{
//                if(Character.isUpperCase(text.charAt(0))){   //Proper nouns that end in s or es
//                    count.add("has"); count.add("was"); count.add("is"); count.add("does");
//                }
//                else{
//                   count.add("have"); count.add("were"); count.add("are"); count.add("do");
//                }
//            }
//        }


    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
//        checkValidWord(adverbDataset, " isn't an adverb.");
    }

}
