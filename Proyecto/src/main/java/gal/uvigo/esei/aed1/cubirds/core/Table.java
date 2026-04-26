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

        for (int i = 0; i < 4; i++) { // 4 filas
            while (this.filas[i].size() < 3) { // 3 cartas por fila
                // Obtener la última carta de una copia de la baraja para no romper la encapsulación
                List<Card> deckClone = DeckOfCards.getDeckOfCards();
                Card lastCard = deckClone.get(deckClone.size() - 1);
                DeckOfCards.removeLast();

                if (compareAndMove(i, lastCard)) {
                    this.filas[i].addFirst(lastCard);
                } else {
                    DeckOfCards.addLast(lastCard); // carta repetida vuelve al final
                }
            }
        }
    }

    private boolean compareAndMove (int i, Card lastCard) {
        for (Card card : this.filas[i]) {
            if (card.getTypeBird().equals(lastCard.getTypeBird())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mesa:\n");
        for (int i = 0; i < this.filas.length; i++) {
            sb.append("Fila ").append(i + 1).append(": ");
            for (Card card : this.filas[i]) {
                sb.append(card.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    }
