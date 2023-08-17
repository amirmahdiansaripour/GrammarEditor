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
            "measles", "physics", "mathematics", "news", "information", "evidence", "equipment", "attention"));

    public String count;
    public Subject(String t, Boolean cap, int line_){
        super(t, cap, line_);
        setCount(text);
        if(t.equals("I")) capital = true;
//        System.out.println(text + ";;count;;" + count);
    }

    public void setCountBasedOnPronouns(String sub){
        if(sub.contains(",") || sub.contains("and")){
            count = "plural";
        }
        if(sub.equals("he") || sub.equals("she") || sub.equals("it") || singularExceptions.contains(sub)){
            count = "third singular";
        }
        else if(sub.equals("i")){
            count = "first singular";
        }
        else if(sub.equals("you") || sub.equals("we") || sub.equals("they") || pluralExceptions.contains(sub)){
            count = "plural";
        }
    }

    public void checkSuffix(String sub, String suffix){
        int lastIndex = sub.lastIndexOf(' ');
        String lastPart = sub;
        if(lastIndex != -1) lastPart = sub.substring(lastIndex + 1);

        if (lastPart.length() - suffix.length() > 0 &&
                lastPart.substring(lastPart.length() - suffix.length()).equals(suffix)) {
            String withoutSuffix = lastPart.substring(0, lastPart.length() - suffix.length());
            if (singularExceptions.contains(withoutSuffix) || pluralExceptions.contains(withoutSuffix)){
                errors.add(new GrammarError.IsntCorrect(line, text));
                count = "wrong";    // words such as informations, peoples, are wrong
            }
            else {
                count = "plural";
            }
        }
    }

    public void setCountBasedOnPrefix(String sub){
        checkSuffix(sub, "s");
        checkSuffix(sub, "es");
    }

    public void setCountBasedOnPrev(String sub){
        int firstSpaceIndex = sub.indexOf(' ');
        int secondSpaceIndex = sub.indexOf(' ', firstSpaceIndex + 1);
        int lastSpaceIndex = sub.lastIndexOf(' ');
        if(firstSpaceIndex != -1) {
            String firstPart = sub.substring(0, firstSpaceIndex);
            if(firstPart.equals("most") || firstPart.equals("more") || firstPart.equals("some") ||
                    firstPart.equals("the") || (secondSpaceIndex != -1 && (sub.substring(0, secondSpaceIndex).equals("some of")))){
                setCount(sub.substring(lastSpaceIndex + 1));
            }
            else if(firstPart.equals("this") || firstPart.equals("that")){
                setCount(sub.substring(lastSpaceIndex + 1));
                if(count.equals("plural"))
                    errors.add(new GrammarError.BeSingular(line, sub.substring(lastSpaceIndex + 1)));
            }
            else if(firstPart.equals("these") || firstPart.equals("those")){
                setCount(sub.substring(lastSpaceIndex + 1));
                if(!count.equals("wrong") && !count.equals("plural"))
                    errors.add(new GrammarError.BePlural(line, sub.substring(lastSpaceIndex + 1)));
            }
            else if(firstPart.equals("few") || (secondSpaceIndex != -1 && (sub.substring(0, secondSpaceIndex).equals("a few")
            || sub.substring(0, secondSpaceIndex).equals("a little")))){
//                System.out.println("Entered a few");
                setCount(sub.substring(lastSpaceIndex + 1));
                if(!count.equals("plural") && !count.equals("wrong")){
                    errors.add(new GrammarError.BePlural(line, sub.substring(lastSpaceIndex + 1)));
                }
            }
            else if (firstPart.equals("a") || firstPart.equals("an")) {
                count = "third singular";
            }
        }

    }

    public void setCount(String t){
        String sub = t.toLowerCase();
        setCountBasedOnPronouns(sub);
        if(count == null){
            setCountBasedOnPrev(sub);
        }
        if(count == null){
            setCountBasedOnPrefix(sub);
        }
        if(count == null){
            count = "third singular";
        }
//        System.out.println(text + " : " + count);
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public void verify(){
        checkCapital();
    }

}
