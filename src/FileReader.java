import java.io.BufferedReader;
import java.util.ArrayList;



    public class FileReader {

        public static ArrayList<String> read(String fileName) {

            ArrayList<String> wordList = new ArrayList<String>();
            String localdir = System.getProperty("user.dir");

            try {
                java.io.FileReader fileReader = new java.io.FileReader(localdir + "\\" + fileName); // Java.io.Filereader é um objeto nativo do Java, para não haver conflito no nomes das classes usamos ele ao invés do import.
                BufferedReader bufferedReader = new BufferedReader(fileReader);


                String line = null;
                while((line = bufferedReader.readLine()) != null){
                    wordList.add(line);
                }
                bufferedReader.close();
            } catch (Exception e) {
                System.out.print(e.getStackTrace());
            }
            return wordList;
        }
    }

