package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.iu.IU;
import java.util.List;
import java.util.LinkedList;

public class Game { // Clase principal

    // Atributos

    private IU iu;
    private DeckOfCards deck;
    private Table table;
    private Player[] players;
    private int currentPlayerIndex; // Índice del jugador actual

    public Game(IU iu) {

        this.iu = iu;
        this.deck = new DeckOfCards();
        this.table = new Table();
        this.players = new Player[5]; // máximo 5 jugadores
        this.currentPlayerIndex = 0; // el primer jugador comienza
    }

    public List<Player> inicializarJugadores() { // Crear los jugadores
        List<Player> listaJugadores = new LinkedList<>();
        int numJugadores = 0;

        // rango de jugadores de 2 a 5
        do {
            numJugadores = iu.readNumber("¿Cuantos van a jugar? (2 a 5): ");
            if (numJugadores < 2 || numJugadores > 5) {
                iu.displayMessage("Por favor, introduce un número entre 2 y 5.");
            }

        } while (numJugadores < 2 || numJugadores > 5);
        // Se introduce el número de jugadores mediante su nombre
        for (int i = 0; i < numJugadores; i++) {
            String nombre = iu.readString("Nombre del jugador " + (i + 1) + ": ");
            listaJugadores.add(new Player(nombre));
        }

        return listaJugadores;

    }

    public void play() { // aun por hacer

        List<Player> listaJugadores = inicializarJugadores();

        this.players = listaJugadores.toArray(new Player[0]);

        for (Player player : this.players) {
            player.generateHand();
        }

        // ya barajamos y hacemos reparto en Deck of cards

        table.inicializarMesa();

        iu.displayMessage("\n=== REPARTO INICIAL ===");
        iu.displayMessage(table.toString());
        for (Player player : this.players) {
            iu.displayMessage(player.toString());
        }
    }

}
