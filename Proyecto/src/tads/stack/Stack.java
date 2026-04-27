package stack;

public interface Stack<T> {

    public boolean isEmpty();

    public int size();

    public void push(T value) throws NullPointerException;

    public T pop();

    public void clear();

    public boolean contains(char character);
}