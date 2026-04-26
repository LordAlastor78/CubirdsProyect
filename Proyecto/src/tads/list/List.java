package es.uvigo.esei.aed1.tads.list;

import es.uvigo.esei.aed1.tads.EmptyException;
import java.util.Iterator;

public interface List<T> extends Iterable<T> {

    public boolean isEmpty();

    public int size();

    public boolean contains(T value) throws NullPointerException;

    public T getFirst() throws EmptyException;

    public T getLast() throws EmptyException;

    public T get(int index) throws IndexOutOfBoundsException;

    public T set(int index, T value) throws IndexOutOfBoundsException, NullPointerException;

    public void addFirst(T value) throws NullPointerException;

    public void addLast(T value) throws NullPointerException;

    public void add(int index, T value) throws IndexOutOfBoundsException, NullPointerException;

    public T removeFirst() throws EmptyException;

    public T removeLast() throws EmptyException;

    public boolean removeValue(T value) throws NullPointerException;

    public T remove(int index) throws IndexOutOfBoundsException;

    public void clear();

    public IteratorList<T> iteratorList();

    @Override
    public Iterator<T> iterator();
}