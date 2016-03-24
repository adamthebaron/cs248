/** @author CS248 */
public class QueueArray implements queue {
    Object[] items;
    int front;
    int back;
    int count;

    public QueueArray(int maxsizeOf) {
        count = 0;
        back = 0;
        front = 1;
        items = new Object[maxsizeOf];
    }

    public void enqueue(Object obj) {
        if (isFull())
            return;
        
        count++;
        back++;
        
        if (back >= items.length)
            back = 0;

        items[back] = obj;
    }

    public Object dequeue() {
        if (isEmpty())
            return null;
        
        count--;
        Object obj = items[front];
        front++;
        
        if (front >= items.length)
            front = 0;

        return obj;
    }

    public Object getFront() {
        if (isEmpty())
            return null;
        else
            return items[front];
    }

    public int sizeOf() {
        return count;
    }

    public boolean isEmpty() {
        return count <= 0;
    }

    public boolean isFull() {
        return count >= items.length;
    }

    public void makeEmpty() {
        count = 0;
        back = 0;
        front = 1;
    }
}
