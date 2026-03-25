package gal.uvigo.esei.aed1.cubirds.core;
import gal.uvigo.esei.aed1.cubirds.core.Card;
import java.util.LinkedList;
import java.util.List;



public class Table {


    private List<Card>[] filas;
    
    // Constructor
    public Table() {
        this.filas = new LinkedList[4];

        for (int i = 0; i < 4; i++) {
            this.filas[i] = new LinkedList<>(); // Creamos cada fila individual
        }
    }

    public void inicializar(DeckOfCards barajas) {
        //Ejemplo: rellenar cada una de las 4 filas con 3 cartas 
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                this.filas[i].add(baraja.extraerCarta());
            }

        }

    
    }
        

    }

    


