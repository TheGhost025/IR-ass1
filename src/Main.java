
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class Main {

    private static HashMap<String,DictEntry> index = new HashMap<>();
    private static HashMap<Integer,String> source= new HashMap<>();
    private static String files[] = {"Frostbite.txt","Godot.txt","Unity.txt","UnrealEngine.txt"};
    static void buildInvertedIndex() throws IOException {
        for(int i = 0; i < files.length ; i++){
            RandomAccessFile f =new RandomAccessFile(files[i],"r");
            source.put(i, files[i]);
            String line;
            while((line = f.readLine()) != null){
                String words[] = line.split(" ");
                for(String word: words){
                    word = word.toLowerCase();
                    word=word.replace(",","");
                    word=word.replace(".","");
                    if(!index.containsKey(word))
                        index.put(word, new DictEntry());
                    index.get(word).addPosting(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        buildInvertedIndex();
        System.out.println("source\n___________________________________");
        for(int key : source.keySet()){
            System.out.println(key + " " + source.get(key));
        }
        System.out.println("index\n___________________________________");
        for(String word : index.keySet()){
            System.out.println("Word: " + word);
            index.get(word).print();
        }
    }
}