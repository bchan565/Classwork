import java.util.Random;

/**
 * RandomPlayer can be called with a int seed, or with no seed.  
 * 
 * If the constructor that takes an int the play() method generates a random integer 
 * between 1 and 3 inclusive.  
 * 
 * If no seed is sent then the program finds a seed that produces a fixed, predictable
 * sequence of move. In this case {1, 2, 3, 2, 3, 1, 1} which corresponds to
 * {ROCK, PAPER, SCISSORS, PAPER, SCISSORS, ROCK, ROCK}
 *
 * @author (Vallath Nandakumar)
 * @author (Mike Scott)
 * @version (v 2.0, Sept. 24, 2014)
 */
public class RandomPlayer {

    private Random rand;
    private static int roundNumber;
    private int [] plays = {1, 2, 3, 2, 3, 1, 1}; // fixed rotating sequence of plays
    private boolean useFixedSequence;

    /**
     * Construct a RandomPlayer object based on the given seed.
     * @param seed The initial seed for the random number generator
     */
    RandomPlayer (int seed) {
        useFixedSequence = false;
        rand = new Random(seed);
    }

    /**
     * Construct a RandomPlayer object that follows a predictable sequence.
     * The sequence is 1, 2, 3, 2, 3, 1, 1 which represents 
     * the choices ROCK, PAPER, SCISSORS, PAPER, SCISSORS, ROCK, ROCK.
     */
    RandomPlayer () {
        useFixedSequence = true;
        roundNumber = 0;
    }


    /**
     * Return the computer's choice. 1 represents ROCK, 2 represents Paper,
     * and 3 represents Scissors.
     * @return The computer's next choice.
     */
    public int getComputerChoice() {
        int result;
        if(useFixedSequence) {
            result = plays[roundNumber];
            roundNumber = (roundNumber + 1) % plays.length;
        } else {
            result = rand.nextInt(3) + 1;
        }
        return result;
    }
}