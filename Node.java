package Calculator;

/**
 * @author Jefferson Vivanco
 * @class This is the generic node class which means that we can create a Node of any reference type. 
 * @param <T> This is the generic variable that is used to create a generic Node object
 */
public class Node <T> {
	//--------------------------//data fields
	private Node<T> next; 	
	private T data; 
	//--------------------------//constructors 
	/**
	 * This constructor creates a null node object 
	 */
	public Node()
	{
		this.next = null; 
		this.data = null; 		
	}	
	/**
	 * @param data This is the data used when a new node is created 
	 */
	public Node(T data)
	{
		if(data!=null)this.data = data; 
		
	}
	/**
	 * @param data This is the data used when a new node is created 
	 * @param next This is the node the node created will point to 
	 */
	public Node(T data, Node<T> next)
	{
		if(data!=null)this.data = data; 
		if(next!=null)this.next = next; 
	}
	//--------------------------//getters and setters 
	/**
	 * @return This returns the node the current node is pointing to
	 */
	public Node<T> getNext()
	{
		return this.next; 
	}	
	/**
	 * @param next This is the node that the current node will point to
	 */
	public void setNext(Node<T> next)
	{
		this.next = next; 
	}
	/**
	 * @return The data of the current node 
	 */
	public T getData()
	{
		return this.data; 
	}
	/**
	 * @param data Sets the data of the current node 
	 */
	public void setData(T data)
	{
		this.data=data; 
	}
	//--------------------------//toString method
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return this.data.toString(); 
	}
}
