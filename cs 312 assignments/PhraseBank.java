import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Store a list of phrases. Generally for use with a Hangman program.
 * @author scottm
 *
 */
public class PhraseBank {

    private static final String DEFAULT_FILE_NAME = "HangmanMovies.txt";

    // simple phrase bank if we can't find the right file
    private static final String[] EMERGENCY_PHRASES = {"THE_POLICE", "THE_ROLLING_STONES", "THE_WHO", "REM", "NATHANIEL_RATELIFF_AND_THE_NIGHT_SWEATS"};
    private static final String EMERGENCY_TOPIC = "Band";

    private static final int RANDOM_SEED = 6;

    private ArrayList<String> phrases;
    private int currentIndex;
    private String topic;

    /**
     * Create a PhraseBank from the default file.
     */
    public PhraseBank(){
        this(DEFAULT_FILE_NAME);
    }

    /**
     * Create a PhraseBank from the given file name. If the file cannot be
     * found then use the default file. if that cannot be found use
     * the emergency phrase bank of bands.
     * @param fileName The name of the file that has the phrase bank.
     */
    public PhraseBank(String fileName) {
        phrases = new ArrayList<String>();
        currentIndex = -1;
        loadWords(fileName);
       // Collections.shuffle(phrases, new Random(RANDOM_SEED)); // use this line for non random behavior
        Collections.shuffle(phrases); // use this line for random behavior
    }

    /**
     * Call this method to get the next phrase.
     * The returned String will contain uppercase
     * letters and underscores for spaces.
     */
    public String getNextPhrase(){
        currentIndex = (currentIndex + 1) % phrases.size();
        return phrases.get(currentIndex);
    }

    /**
     * Return the topic of this phrase bank.
     * @return The topic of this phrase bank.
     */
    public String getTopic(){
        return topic;
    }


    // Read the topic and phrases from the file.
    // If there is any problem then use the Emergency topic and phrases.
    private void loadWords(String fileName) {
        File f = new File(fileName);
        try{
            Scanner s = new Scanner(f);
            topic = s.nextLine();
            while(s.hasNextLine()){
                String phrase = trim(s.nextLine().trim());
                phrases.add(phrase.toUpperCase());
            }
            s.close();
        }
        catch(IOException e){
            // problem with reading file, use the emergency topic and phrases
            constructFromEmergencyData();
        }
        // if no values construct from emergency data
        if(phrases.size() == 0)
            constructFromEmergencyData();
    }


    private void constructFromEmergencyData() {
        topic = EMERGENCY_TOPIC;
        for(String phrase : EMERGENCY_PHRASES)
            phrases.add(phrase);

    }

    // I assume nextLine is not null.
    // Return a String with only characters and spaces.
    // All other characters in org are removed.
    private static String trim(String org) {
        String result = "";
        for(int i = 0; i < org.length(); i++){
            char ch = org.charAt(i);
            if( Character.isLetter(ch))
                result += ch;
            else if(ch == ' ')
                result += '_';
        }
        return result;
    }
}