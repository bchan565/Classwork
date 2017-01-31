
public class GuitarHero {
    public static void main(String[] args) {

    final double TEXT_POS_X = .5;
    final double TEXT_POS_Y = .9;
    GuitarString[] strings = new GuitarString[37];
    StdDraw.text(TEXT_POS_X-.07, TEXT_POS_Y + .05, "Black  2   4 5   7 8 9   - =   d f g   j k   ; '");
    StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "White q w e r t y u i o p [ z x c v b n m , . / space");
    StdDraw.text(TEXT_POS_X-.03,  TEXT_POS_Y-.05,  "Musical Note Layout");
    initializeStrings(strings);
    play(strings);

    }
    public static void initializeStrings(GuitarString[] strings){
    	for(int i = 0; i < strings.length; i++){
    		double frequency = 440 * Math.pow(1.05956, i-24);
    		strings[i] = new GuitarString(frequency);
    	}
    }
    public static void play(GuitarString[]strings){
    	String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' "; // String ends with a space
    	while(true){
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {
 
                // the user types this character
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                strings[index].pluck();
            }

            // compute the superposition of the samples
            double sample =0;
            for(int i = 0; i < strings.length; i++){
            	sample += strings[i].sample();
            }
            // send the result to standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < strings.length; i++){
            	strings[i].tic();
            }
        
    	}
    }
}