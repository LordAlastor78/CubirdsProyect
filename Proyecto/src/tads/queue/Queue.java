package queue;

public interface Queue<T> {

    public boolean isEmpty();

    public int size();

    public T first() throws EmptyException;

    public void add(T value) throws NullPointerException;

    public T remove() throws EmptyException;

    public void clear();
}