/** @author CS248 */
public interface queue {
    public void enqueue(Object x);
    public Object dequeue();
    public Object getFront();
    public int sizeOf();
    public boolean isEmpty();
    public boolean isFull();
    public void makeEmpty();
}
