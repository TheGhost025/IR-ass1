import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static HashMap<String,DictEntry> index = new HashMap<>();
    public static HashMap<Integer,String> source= new HashMap<>();
    private static String files[] = {"Frostbite.txt","Godot.txt","Unity.txt","UnrealEngine.txt","CyberSecurity.txt","Flutter.txt","GameDevelopment.txt","SoftwareEngneering.txt","Vim.txt","WebDevelopment.txt"};
    static void buildInvertedIndex() throws IOException {
        for(int i = 1; i <= files.length ; i++){
            RandomAccessFile f =new RandomAccessFile(files[i-1],"r");
            source.put(i, files[i-1]);
            String line;
            while((line = f.readLine()) != null){
                String words[] = line.split(" ");
                for(String word: words){
                    word = word.toLowerCase();
                    word=word.replace(",","");
                    word=word.replace(".","");
                    word=word.replace("'s","");
                    if(!index.containsKey(word))
                        index.put(word, new DictEntry());
                    index.get(word).addPosting(i);
                }
            }
        }
    }

    static void searchWord(String word){
        List<String> result =new ArrayList<String>();
        if(index.containsKey(word)){
            index.get(word).print();
        }
    }
    public static void main(String[] args) throws IOException {
        buildInvertedIndex();
//        System.out.println("source\n___________________________________");
//        for(int key : source.keySet()){
//            System.out.println(key + " " + source.get(key));
//        }
//        System.out.println("index\n___________________________________");
//        for(String word : index.keySet()){
//            System.out.println("Word: " + word);
//            index.get(word).print();
//        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to search: ");
        String word = scanner.nextLine();
        searchWord(word);
    }
}