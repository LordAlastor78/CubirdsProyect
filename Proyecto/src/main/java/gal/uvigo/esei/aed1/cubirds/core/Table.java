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

    public void inicializar(DeckOfCards barajas) {
        // Ejemplo: rellenar cada una de las 4 filas con 3 cartas

        for (int i = 0; i < 4; i++) { // Para cada una de las 4 filas
            for (int j = 0; j < 3; j++) { // columnas
                this.filas[i].addAll(barajas.getDeckOfCards());

                // for para ver que no haya cartas iguales
                for (int k = 0; k < j; k++) {
                    if (this.filas[i].get(j).getTypeBird().equals(this.filas[i].get(k).getTypeBird())) {

                        this.filas[i].set(j, barajas.getDeckOfCards().remove(0));
                        k = -1;
                    }
                }

            }

        }

    }

}
