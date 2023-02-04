// LLNode.java
//
//This class contains the basic structure of the linked list, it has the head, info, link and count variable
//It has two constructor, one with a parameter
//This class has the methods: setInfo(), setLink(), setCount(), getInfo(), getLink(), getCount()



public class LLNode<T>
{
	LLNode <T> head;
	protected T info;
	protected LLNode<T> link;
	public int count;
	
	public LLNode() // constructor: empty list, link set to null
	{
		link = null;
	}
	
	public LLNode(T info) // constructor: empty list, updates info, link set to null
	{
		this.info = info;
		link = null;
	}
	
	public void setInfo(T info) // updates info to new info
	{
		this.info = info;
	}
	
	public T getInfo() // returns info
	{
		return info;
	}
	
	public void setLink(LLNode<T> link) // updates link to the new link
	{
		this.link = link;
	}
	
	public LLNode<T> getLink() // return link
	{
		return link;
	}
	
	
	public void setCount(int count) // updates the count to the new count
	{
		this.count = count;
	}
	
	public int getCount() // returns count
	{
		return count;
	}
}