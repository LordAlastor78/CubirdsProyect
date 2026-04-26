package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.core.Card;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Table {

    /*
     * Se barajarán las cartas y se colocarán en la mesa 4 filas con 3 cartas de
     * pájaro cada una, no puede
     * haber pájaros de la misma especie en la misma fila. En tal caso, se siguen
     * sacando cartas hasta
     * conseguir 3 especies distintas, las cartas no utilizadas se devuelven de
     * nuevo al final de la baraja.
     */

    private List<Card>[] filas; // para filas y columnas en el inicializar()

    // Constructor
    public Table() {
        this.filas = new LinkedList[4];

        for (int i = 0; i < 4; i++) { // Crear cada fila de la mesa :D
            this.filas[i] = new LinkedList<>(); // Creamos cada fila individual
        }
    }

    public void inicializarMesa() {

        for (int i = 0; i < 4; i++) { // Por cada una de las 4 filas, le añadimos 3 cartas

            this.filas[i].clear();

            while (this.filas[i].size() < 3) { // Se pone 3 porque hay que añadir 3 cartas a cada fila.

                Card candidate = DeckOfCards.takeFirstCard();

                if (!tipoRepetidoEnFila(i, candidate)) {
                    this.filas[i].add(DeckOfCards.takeFirstCard());
                } else {
                    DeckOfCards.addLast(DeckOfCards.removeFirst()); // Movemos candidate al otro lado de la baraja
                }
            }

        }
    }

    private boolean tipoRepetidoEnFila(int numFila, Card candidate) {
        for (Card c : this.filas[numFila]) {
            if (c.getTypeBird() == candidate.getTypeBird()) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nMesa: \n");
        for (int i = 0; i < filas.length; i++) {    // Para todas las filas
            sb.append("Fila ").append(i).append(": ");
            for (int j = 0; j < filas[i].size(); j++) {     // En cada fila, todas las cartas
                sb.append(filas[i].get(j).getTypeBird()).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}

// Manera inicial de inicializar la mesa:
/*
 *
 * this.filas[i].clear();
 * 
 * this.filas[i].addFirst(DeckOfCards.takeFirstCard()); // Añadimos la primera
 * carta de la columna
 * 
 * while (!(compareAndMove(i, 0) == true)) {
 * // Se repite el bucle hasta que se encuentre una carta válida (que no se
 * repita
 * // el tipo de pájaro)
 * }
 * 
 * this.filas[i].addFirst(DeckOfCards.takeFirstCard()); // Añadimos la siguiente
 * carta
 * 
 * while (!(compareAndMove(i, 0) == true) && !(compareAndMove(i, 1) == true)) {
 * // Se repite el bucle hasta que se encuentre una carta válida
 * }
 * 
 * this.filas[i].addFirst(DeckOfCards.takeFirstCard()); // Añadimos la última
 * carta
 * 
 * 
 * 
 * private boolean compareAndMove(int i, int checkIndex) {
 * 
 * boolean wasOk = true;
 * 
 * if
 * (DeckOfCards.getLastCard().getTypeBird().equals(this.filas[i].get(checkIndex)
 * .getTypeBird())) {
 * 
 * wasOk = false;
 * 
 * this.filas[i].addFirst(DeckOfCards.getLastCard()); // añadimos la primera
 * carta de la columna
 * DeckOfCards.removeLast();
 * 
 * return false;
 * 
 * } else {
 * return true;
 * }
 * }
 */


// toString alternativo: 
/*
    @Override
    public String toString() {
        return new StringBuilder()
                .append("""
                        Table {
                          filas=""")
                .append(Arrays.toString(filas))
                .append("""
                        }
                        """)
                .toString();
    }
*/