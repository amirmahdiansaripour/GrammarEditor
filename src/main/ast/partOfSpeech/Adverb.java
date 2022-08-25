package main.ast.partOfSpeech;
import main.ast.*;
import main.visitor.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import main.error.*;

public class Adverb extends Word{
    public Adverb(String t, Boolean capital_) throws IOException{
        super(t, capital_);
        File file = new File("src\\dataset\\adverbs.txt");
        BufferedReader stream = new BufferedReader(new FileReader(file));
        String line;
        while ((line = stream.readLine()) != null)
            dataset.add(line);
        stream.close();
    }
    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
    @Override
    public GrammarError verify(){
        GrammarError capError = checkCapital();
        if(capError != null){
            return capError;
        }
        if(!dataset.contains(text.toLowerCase(Locale.ROOT))){
            return new GrammarError.WrongAdverb(line, text);
        }
        return null;
    }
}
