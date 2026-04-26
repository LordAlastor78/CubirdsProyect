package es.uvigo.esei.aed1.tads.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface IteratorList<T> extends Iterator<T> {

    public boolean hasPrevious();

    public T previous() throws NoSuchElementException;

    public void setNext(T value) throws NullPointerException, NoSuchElementException;

    public void setPrevious(T value) throws NullPointerException, NoSuchElementException;

    public void addNext(T value) throws NullPointerException;

    public void addPrevious(T value) throws NullPointerException;
}