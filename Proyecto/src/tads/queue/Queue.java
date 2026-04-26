package es.uvigo.esei.aed1.tads.queue;

import es.uvigo.esei.aed1.tads.EmptyException;

public interface Queue<T> {

    public boolean isEmpty();

    public int size();

    public T first() throws EmptyException;

    public void add(T value) throws NullPointerException;

    public T remove() throws EmptyException;

    public void clear();
}