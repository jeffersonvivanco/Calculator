package Calculator;

/**
 * @author Jefferson Vivanco
 * @class This is the stack class used by the ExpressionTools class. This class represents a stack using a linklist. 
 * @param <T> This is the generic variable used to create a generic stack. Since we use the stack to store different types of objects, 
 * 			  we make it generic
 */
public class MyStack<T> {
	
	private Node<T> head;
	
	//--------------------------//constructors
	/**
	 * This is the constructor to create an empty stack 
	 */
	public MyStack()
	{
		this.head = null;
		//creates an empty stack 
	}
	//--------------------------//stack methods: empty, peek, pop, push, search
	/**
	 * @return true if the stack is empty, false otherwise 
	 */
	public boolean empty()
	{
		if(head==null)return true;
		else return false;
	}
	/**
	 * @return Returns the object at the top of the stack without removing it from the stack 
	 */
	public Node<T> peek()
	{
		if(!this.empty())
		{
			Node<T> temp = head;
			return temp;
		}
		else return null;
	}
	/**
	 * @return Removes the object at the top of the stack and returns it
	 */
	public Node<T> pop()
	{
		if(!this.empty())
		{		
		Node<T> temp = head; 
		head=head.getNext();	
		return temp;	
		}
		else return null;

	}
	/**
	 * @param item Pushes item onto the top of the stack 
	 */
	public void push(Node<T> item)
	{
		if(this.empty())
			this.head = item;
		else{
			item.setNext(head);
			head=item;
		}
	}
	/**
	 * @param o This is the object it is searching for 
	 * @return The 1 - based position where the object is on the stack 
	 */
	public int search(Node<T> o)
	{
		int location = 1;
		Node<T> current = head;
		while(current!=null)
		{
			if(current.getData().equals(o.getData()))
				return location;
			current = current.getNext();
			location++;
		}
		return -1; 
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		if(this.empty())
			return "EMPTY";
		else{
			String result = ""; 
			Node<T> curr = head; 
			while(curr!=null)
			{
				result = result+curr.getData()+",";
				curr = curr.getNext();
			}
			return result; 
		}
	}
}
