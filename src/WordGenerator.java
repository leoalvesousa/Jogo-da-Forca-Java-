import java.util.ArrayList;
import java.util.Random;

public class WordGenerator {

    private static final String FILE_PATH = "words.txt";

    ArrayList<String> wordList = new ArrayList<>();

    public  WordGenerator(){
        addWord();
    }

    private void addWord(){

        wordList = FileReader.read(FILE_PATH);
    }

    public String getWord(){

        int wordIndex = new Random().nextInt(wordList.size());
        return wordList.get(wordIndex);

    }
}
