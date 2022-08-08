import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LetterGuess {
    public static boolean hasLetter (String word, char letter){
        String regex = ".*" + letter + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcherText = pattern.matcher(word);
        Boolean textMatches = matcherText.matches();

        return textMatches;
    }
}
