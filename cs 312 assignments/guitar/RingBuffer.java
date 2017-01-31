import java.util.NoSuchElementException;

public class RingBuffer {
	private double[] buffer;
	private int size;
	private int front;
	private int last;
	public RingBuffer(int capacity){
		buffer = new double[capacity];
		size = 0;
		front = 0;
		last = 1;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public boolean isFull(){
		if(size == buffer.length){
			return true;
		}
		else{
			return false;
		}
	}
	public void enqueue(double x){
		if(isFull()){
			throw new IllegalStateException();
		}
		if(isEmpty()){
			last = 0;
			front = 0;
		}
		buffer[last] = x;
		last++;
		if(last >= buffer.length){
			last = 0;
		}
		size++;
	}
	public double dequeue(){
		double save = buffer[front];
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		front++;
		if(front >= buffer.length){
			front = 0;
		}
		size--;
		return save;
	}
	public double peek(){
		return buffer[front];
	}
	public String toString(){
		String bufferReturner = "[";
		if(!isEmpty()){
			int i = front;
			boolean start = true;
			while(i != last || start){
				start = false;
				bufferReturner += buffer[i] + ", ";
				i++;
				if(i >= buffer.length){
					i = 0;
				}
			}
			bufferReturner = bufferReturner.substring(0, bufferReturner.length()-2);
			bufferReturner += "]";
			return bufferReturner;
		}
		else{
			bufferReturner += "]";
			return bufferReturner;
		}
	}
}
