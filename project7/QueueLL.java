public class QueueLL implements Queue
{
	private class node
	{
		public Object data;
		public node next;
	}
	private int count;
	private node front, back;
	
	public QueueLL()
	{
		count=0;
		back=front=null;
	}
	
	public void enqueue(Object x)
	{
    node newnode=new node();
		newnode.data=x;
		newnode.next=null;
		if(back==null)
			front=newnode;
		else
		  back.next=newnode;
		back=newnode;
		count++;
	}
	public Object dequeue()
	{
		if(isEmpty()) return null;
		Object savetoreturnlater=front.data;
		front=front.next;
		if(front==null) back=null;
		count--;
		return savetoreturnlater;
	}
	
	public Object getFront()
	{ return isEmpty()?null:front.data; }
	public Object getBack()
	{ return isEmpty()?null:back.data; }
	public boolean isEmpty() { return count<=0;}
	public boolean isFull() 
	{ return false; }
	public int size() { return count; }
	public void makeEmpty()
	{
		count=0;
		back=front=null;
	}
}