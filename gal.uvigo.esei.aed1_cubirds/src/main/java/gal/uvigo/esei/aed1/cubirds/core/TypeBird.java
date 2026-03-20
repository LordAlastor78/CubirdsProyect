package gal.uvigo.esei.aed1.cubirds.core;

/**
 * tipos de pájaros
 */
public enum TypeBird {
    CURRUCA(2, 3), 
    FLAMENCO(2, 3), 
    PETIRROJO(3, 4), 
    TUCAN(3, 4), 
    PATO(4, 6), 
    URRACA(5, 7), 
    LECHUZA(7, 9), 
    GUACAMAYO(7, 9);



    private final int numBandadaMinima;
    private final int numBandadaCompleta;
    public int getNumBandadaMinima() { // getter
        return numBandadaMinima;
    }

    public int getNumBandadaCompleta() { // getter
        return numBandadaCompleta;
    }

    

    TypeBird(int numBandadaMinima, int numBandadaCompleta) {
        this.numBandadaMinima = numBandadaMinima;
        this.numBandadaCompleta = numBandadaCompleta;
    }


}
