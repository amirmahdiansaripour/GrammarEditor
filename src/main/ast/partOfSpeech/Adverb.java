package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Adverb extends astNode{
    private String text;
    private ArrayList<String> adverbs;
    public Adverb(String t) throws IOException{
        text = t;
        adverbs = new ArrayList<String>();
        File file = new File("src\\dataset\\adverbs.txt");
        BufferedReader stream = new BufferedReader(new FileReader(file));
        String line;
        while ((line = stream.readLine()) != null)
            adverbs.add(line);
        stream.close();
    }
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public String toString() {
        return text;
    }
    public Boolean verify(){
        if(adverbs.contains(text.toLowerCase(Locale.ROOT))){
            return true;
        }
        return false;
    }
}
