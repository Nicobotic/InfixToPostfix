public class ArrayStack <T> {
	private T[] stack;
	private int top;
	
	public ArrayStack() {
		this(5);
	}
	
	public ArrayStack(int size) {
		stack = (T[]) new Object[size];
		top = 0;
	}
	
//	public ArrayStack(ArrayStack other) {
//		T[] temp = (T[]) new Object[other.size()];
////		System.out.println(other.size());
//		int size = other.size();
//		for(int i=0; i<size; i++)
//			temp[i] = (T) other.pop();
//		stack = temp;	
//		top = other.size();
//	}
	
	public int size() {
		return top;
	}
	
	public void push(T data) {
		if(top >= stack.length) {
			T[] temp = (T[]) new Object[stack.length * 2];
			for(int i=0; i<stack.length; i++)
				temp[i] = stack[i];
			stack = temp;
		}
		stack[top] = data;
		top ++;
	}
	
	public T pop() {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		top --;
		return stack[top];
	}
	
	public T peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException();
		return stack[top-1];
	}
	
	public boolean isEmpty() {
		if(top <= 0)
			return true;
		else
			return false;
	}
	
	public int search(T data) {
		for(int i=0; i<top; i++)
			if(stack[i].equals(data))
				return i;
		return -1;
	}
	
	public String toString() {
		if(isEmpty())
			return "[]";
		String str = "[";
		for(int i=top-1; i>0; i--)
			str = str + stack[i] + ", ";
		str = str + stack[0] + "]";
		return str;
	}
}
