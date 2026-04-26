package es.uvigo.esei.aed1.tads;

public class EmptyException extends RuntimeException {

    public EmptyException() {
        super();
    }

    public EmptyException(String message) {
        super(message);
    }
}