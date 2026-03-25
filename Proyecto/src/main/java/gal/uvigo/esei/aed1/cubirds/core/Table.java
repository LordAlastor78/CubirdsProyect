package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.core.Card;
import java.util.LinkedList;
import java.util.List;

public class Table {
    // La mesa de juego, donde se colocan las cartas que los jugadores van a ir
    // jugando.

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
            for (int j = 0; j < 3; j++) { // Rellenar cada fila con 3 cartas
                this.filas[i].add(barajas.extraerCarta()); // Extraer una carta de la baraja y añadirla a la fila

            }

        }

    }

}
