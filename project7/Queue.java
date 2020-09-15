public interface Queue
{
	public void enqueue(Object x);
	public Object dequeue();
	public Object getFront();
	public Object getBack();
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public void makeEmpty();
}