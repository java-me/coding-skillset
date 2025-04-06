import java.util.EmptyStackException;

class Node<T> {
	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
	}
}

public class MyStack<T> {

	private Node<T> top;
	private int size = 0;
	
	public void push(T t) {
		Node<T> node = new Node<>(t);
		node.next = top;
		top = node;

		this.size++;
	}

	public boolean isEmpty() {
		return this.top == null;
	}

	public T pop() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}

		T data = top.data;

		top = top.next;

		this.size--;
		return data;
	}

	public T peek() {
		if (this.isEmpty()) {
			throw new EmptyStackException();
		}

		return top.data;
	}

	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		MyStack<Integer> myStack = new MyStack<>();

		System.out.println("myStack.size()" + myStack.size());

		System.out.println("myStack.isEmpty()" + myStack.isEmpty());		
		myStack.push(100);
		myStack.push(200);
		myStack.push(300);
		System.out.println("myStack.isEmpty()" + myStack.isEmpty());

		System.out.println("myStack.size()" + myStack.size());

		System.out.println("myStack.peek()" + myStack.peek());
		System.out.println("myStack.pop()" + myStack.pop());
		System.out.println("myStack.size()" + myStack.size());

		System.out.println("myStack.peek()" + myStack.peek());
		System.out.println("myStack.pop()" + myStack.pop());
		System.out.println("myStack.size()" + myStack.size());

		System.out.println("myStack.peek()" + myStack.peek());
		System.out.println("myStack.pop()" + myStack.pop());
		System.out.println("myStack.size()" + myStack.size());

		System.out.println("myStack.peek()" + myStack.peek());
		System.out.println("myStack.pop()" + myStack.pop());
		System.out.println("myStack.size()" + myStack.size());
	}
}
