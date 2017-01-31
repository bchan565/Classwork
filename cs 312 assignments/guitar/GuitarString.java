import java.util.Random;

public class GuitarString {
	private int capacity;
	private final int sample = 44100;
	private RingBuffer buffer;
	private Random random = new Random();
	private double karplus = .994 * .5;
	private int count;
	public GuitarString(double frequency){
		capacity = (int) Math.ceil(sample/frequency);
		buffer = new RingBuffer(capacity);
		for(int i = 0; i < capacity; i++){
		buffer.enqueue(0);
		count = 0;
		}
	}
	public GuitarString(double[] init){
		capacity = init.length;
		buffer = new RingBuffer(capacity);
		for(int i = 0; i < capacity; i ++){
			buffer.enqueue(init[i]);
		}
		count = 0;
	}
	public void pluck(){
		double r;
		for(int i = 0; i < capacity; i++){
			r = random.nextDouble() - 0.5;
			buffer.dequeue();
			buffer.enqueue(r);
		}
	}
	public void tic(){
		double dequeued = buffer.dequeue();
		double front = buffer.peek();
		buffer.enqueue(karplus*(front+dequeued));
		count++;
	}
	public double sample(){
		return buffer.peek();
	}
	public int time(){
		return count;
	}
}
