package es.uvigo.esei.aed1.tads.list;

import es.uvigo.esei.aed1.tads.EmptyException;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements List<T>, Iterable<T> {

    private static final class Node<T> {
        private T value;
        private Node<T> previous;
        private Node<T> next;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public LinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean contains(T value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        for (T current : this) {
            if (Objects.equals(current, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T getFirst() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return this.first.value;
    }

    @Override
    public T getLast() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        return this.last.value;
    }

    private Node<T> nodeAt(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current;
        if (index < this.size / 2) {
            current = this.first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = this.last;
            for (int i = this.size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        return nodeAt(index).value;
    }

    @Override
    public T set(int index, T value) throws IndexOutOfBoundsException, NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<T> node = nodeAt(index);
        T previousValue = node.value;
        node.value = value;
        return previousValue;
    }

    @Override
    public void addFirst(T value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<>(value, null, this.first);
        if (this.first != null) {
            this.first.previous = newNode;
        } else {
            this.last = newNode;
        }
        this.first = newNode;
        this.size++;
    }

    @Override
    public void addLast(T value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<>(value, this.last, null);
        if (this.last != null) {
            this.last.next = newNode;
        } else {
            this.first = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    @Override
    public void add(int index, T value) throws IndexOutOfBoundsException, NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(value);
        } else if (index == this.size) {
            addLast(value);
        } else {
            Node<T> current = nodeAt(index);
            Node<T> newNode = new Node<>(value, current.previous, current);
            current.previous.next = newNode;
            current.previous = newNode;
            this.size++;
        }
    }

    @Override
    public T removeFirst() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        T value = this.first.value;
        this.first = this.first.next;
        if (this.first != null) {
            this.first.previous = null;
        } else {
            this.last = null;
        }
        this.size--;
        return value;
    }

    @Override
    public T removeLast() throws EmptyException {
        if (isEmpty()) {
            throw new EmptyException();
        }
        T value = this.last.value;
        this.last = this.last.previous;
        if (this.last != null) {
            this.last.next = null;
        } else {
            this.first = null;
        }
        this.size--;
        return value;
    }

    @Override
    public boolean removeValue(T value) throws NullPointerException {
        if (value == null) {
            throw new NullPointerException();
        }
        Node<T> current = this.first;
        while (current != null) {
            if (Objects.equals(current.value, value)) {
                unlink(current);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        Node<T> node = nodeAt(index);
        T value = node.value;
        unlink(node);
        return value;
    }

    private void unlink(Node<T> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.first = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.last = node.previous;
        }
        this.size--;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public IteratorList<T> iteratorList() {
        return new ListIterator();
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> nextNode = first;
            private Node<T> lastReturned = null;

            @Override
            public boolean hasNext() {
                return this.nextNode != null;
            }

            @Override
            public T next() {
                if (this.nextNode == null) {
                    throw new NoSuchElementException();
                }
                this.lastReturned = this.nextNode;
                this.nextNode = this.nextNode.next;
                return this.lastReturned.value;
            }

            @Override
            public void remove() {
                if (this.lastReturned == null) {
                    throw new IllegalStateException();
                }
                Node<T> nodeToRemove = this.lastReturned;
                this.lastReturned = null;
                LinkedList.this.unlink(nodeToRemove);
            }
        };
    }

    private final class ListIterator implements IteratorList<T> {
        private Node<T> nextNode = first;
        private Node<T> lastReturned = null;

        @Override
        public boolean hasNext() {
            return this.nextNode != null;
        }

        @Override
        public T next() {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.nextNode;
            this.nextNode = this.nextNode.next;
            return this.lastReturned.value;
        }

        @Override
        public void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<T> nodeToRemove = this.lastReturned;
            this.lastReturned = null;
            LinkedList.this.unlink(nodeToRemove);
        }

        @Override
        public boolean hasPrevious() {
            return this.lastReturned != null;
        }

        @Override
        public T previous() throws NoSuchElementException {
            if (this.lastReturned == null) {
                throw new NoSuchElementException();
            }
            this.nextNode = this.lastReturned;
            this.lastReturned = this.lastReturned.previous;
            return this.nextNode.value;
        }

        @Override
        public void setNext(T value) throws NullPointerException, NoSuchElementException {
            if (value == null) {
                throw new NullPointerException();
            }
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            }
            this.nextNode.value = value;
        }

        @Override
        public void setPrevious(T value) throws NullPointerException, NoSuchElementException {
            if (value == null) {
                throw new NullPointerException();
            }
            if (this.lastReturned == null) {
                throw new NoSuchElementException();
            }
            this.lastReturned.value = value;
        }

        @Override
        public void addNext(T value) throws NullPointerException {
            if (value == null) {
                throw new NullPointerException();
            }
            if (this.nextNode == null) {
                LinkedList.this.addLast(value);
                return;
            }
            Node<T> newNode = new Node<>(value, this.nextNode.previous, this.nextNode);
            if (this.nextNode.previous != null) {
                this.nextNode.previous.next = newNode;
            } else {
                LinkedList.this.first = newNode;
            }
            this.nextNode.previous = newNode;
            LinkedList.this.size++;
        }

        @Override
        public void addPrevious(T value) throws NullPointerException {
            if (value == null) {
                throw new NullPointerException();
            }
            if (this.lastReturned == null) {
                LinkedList.this.addFirst(value);
                return;
            }
            Node<T> newNode = new Node<>(value, this.lastReturned, this.lastReturned.next);
            if (this.lastReturned.next != null) {
                this.lastReturned.next.previous = newNode;
            } else {
                LinkedList.this.last = newNode;
            }
            this.lastReturned.next = newNode;
            LinkedList.this.size++;
        }
    }
}