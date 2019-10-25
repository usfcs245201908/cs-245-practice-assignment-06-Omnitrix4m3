import java.util.*;

public class ArrayStack<T> implements Stack<T>
{
	//Instance Data
	int top = -1;

	T stack[] = (T[]) new Object[10];
	
	//Adds an item to the Stack
	public void push(T item)
	{
		if (stack.length - 1 == top)
		{
			grow_array();
		}

		stack[++top] = item;
	}

	//Doubles the array size when called
	private void grow_array()
	{
		T newStack[] = Arrays.copyOf(stack, stack.length * 2);
		stack = newStack;
	}

	//Removes the top element from the Stack and returns it
	public T pop()
	{
		return stack[top--];
	}

	//Returns the top element of the Stack
	public T peek()
	{
		return stack[top];
	}

	//Checks to see if the Stack is empty
	public boolean empty()
	{
		return (top == -1);
	}
}