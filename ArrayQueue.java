import java.util.*;

public class ArrayQueue<T> implements Queue<T>
{	
	//Instance data
	int head = 0, tail = 0;
	
	T queue[] = (T[]) new Object[10];
	
	//Takes an item out of the Queue and returns it
	public T dequeue()
	{
		T item = queue[head];
		head = (head + 1) % queue.length;

		return item;
	}

	//Adds an item to the end of the Queue
	public void enqueue(T item)
	{
		if ((tail + 1) % queue.length == head)
        {
            grow_array();
        }

        queue[tail++] = item;
        tail = tail % queue.length;
	}

	//Doubles the array size when called
	private void grow_array()
    {
        T newQueue[] = (T[]) new Object[queue.length * 2];
        
		if (head < tail)
        {
            System.arraycopy(queue, head, newQueue, 0, queue.length - head);
        }

        else
        {
            System.arraycopy(queue, head, newQueue, head, queue.length - head);
            System.arraycopy(queue, 0, newQueue, queue.length - head, tail);
        }

        head = 0;
        tail = queue.length - 1;
        queue = newQueue;
    }

	//Checks to see if the Queue is empty
	public boolean empty()
	{
		return head == tail;
	}
}