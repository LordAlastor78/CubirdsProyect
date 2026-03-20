package gal.uvigo.esei.aed1.cubirds.core;

/**
 * tipos de pájaros , simplemente porque ya lo tenemos en Card.java.
 */
public enum TypeBird {
    CURRUCA, 
    FLAMENCO, 
    PETIRROJO, 
    TUCAN, 
    PATO, 
    URRACA, 
    LECHUZA, 
    GUACAMAYO;

    public static TypeBird getBirdIndex(int i) { //devuelve el tipo de pájaro según el índice
        switch (i) {
            case 0:
                return CURRUCA;
            case 1:
                return FLAMENCO;
            case 2:
                return PETIRROJO;
            case 3:
                return TUCAN;
            case 4:
                return PATO;
            case 5:
                return URRACA;
            case 6:
                return LECHUZA;
            case 7:
                return GUACAMAYO;
            default:
                throw new IllegalArgumentException("Invalid index for TypeBird: " + i);
        }
    }
}
