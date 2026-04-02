package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.core.Card;
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

    public void inicializarMesa () {

        for (int i = 0; i < 4; i++) { // Se añaden 4 columnas
            this.filas[i].addFirst(DeckOfCards.getDeckOfCards().getLast()); // Añadimos la primera carta de la columna
            DeckOfCards.removeLast();

            while (!(compareAndMove(i, 0) == true)) {
                // Se repite el bucle hasta que se encuentre una carta válida (que no se repita el tipo de pájaro)
            }

            this.filas[i].addFirst(DeckOfCards.getDeckOfCards().getLast()); // Añadimos la siguiente carta
            DeckOfCards.removeLast();

            while (!(compareAndMove(i, 0) == true) && !(compareAndMove(i, 1) == true)) {
                // Se repite el bucle hasta que se encuentre una carta válida
            }

            this.filas[i].addFirst(DeckOfCards.getDeckOfCards().getLast()); // Añadimos la última carta
            DeckOfCards.removeLast();

        }
    }

    private boolean compareAndMove (int i, int checkIndex) {

        boolean wasOk = true;
        
        if (DeckOfCards.getDeckOfCards().getLast().getTypeBird().equals(this.filas[i].get(checkIndex).getTypeBird())) { //si el tipo de pájaro de la ultima carta de deckOfCards ahora es igual al de la ultima que metimos (la primera de la fila i)...

            wasOk = false;

            this.filas[i].addFirst(DeckOfCards.getDeckOfCards().getLast()); //añadimos la primera carta de la columna
            DeckOfCards.removeLast();
            
            return false;
                
        } else {
            return true;
        }
    }

    }
