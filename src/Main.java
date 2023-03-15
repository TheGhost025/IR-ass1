import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    static void buildInvertedindex(String files[], HashMap<String, DictEntry> index, HashMap<Integer, String> source) throws IOException {
        int i=0;
        for(String file : files){
            RandomAccessFile f =new RandomAccessFile(file,"r");
            source.put(++i,file);
            String line;
            while((line = f.readLine())!=null){
                String words[]=line.split(" ");
                for(String word: words){
                    word=word.toLowerCase();
                    word=word.replace(",","");
                    word=word.replace(".","");
                    if(!index.containsKey(word)){
                        index.put(word,new DictEntry());
                    }
                    index.get(word).addPosting(new Posting(i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        HashMap<String,DictEntry> index = new HashMap<String,DictEntry>();
        HashMap<Integer,String> source= new HashMap<Integer,String>();
        String files[] = {"Frostbite.txt","Godot.txt","Unity.txt","UnrealEngine.txt"};
        buildInvertedindex(files,index,source);
    }
}