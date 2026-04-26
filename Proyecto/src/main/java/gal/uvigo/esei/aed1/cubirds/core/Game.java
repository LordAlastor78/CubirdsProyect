package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.iu.IU;
import es.uvigo.esei.aed1.tads.list.List;
import es.uvigo.esei.aed1.tads.list.LinkedList;

public class Game {

    // Atributos
    private IU iu;
    private DeckOfCards deck;
    private Table table;
    private Player[] players;
    private int currentPlayerIndex;

    public Game(IU iu) {
        this.iu = iu;
        this.deck = new DeckOfCards();
        this.table = new Table();
        this.players = new Player[5];
        this.currentPlayerIndex = 0;
    }

    /** brief
     * Inicializa los jugadores preguntando cantidad y nombres.
     * Los jugadores se almacenan directamente en this.players.
     */
    private void inicializarJugadores() {
        int numJugadores;

        // Pedir número válido de jugadores (2-5)
        do {
            numJugadores = iu.readNumber("¿Cuántos van a jugar? (2 a 5): ");
            if (numJugadores < 2 || numJugadores > 5) {
                iu.displayMessage("Número inválido. Debe estar entre 2 y 5.");
            }
        } while (numJugadores < 2 || numJugadores > 5);

        // Crear array con tamaño exacto
        this.players = new Player[numJugadores];

        // Pedir nombre para cada jugador
        for (int i = 0; i < numJugadores; i++) {
            String nombre;
            do {
                nombre = iu.readString("Nombre del jugador " + (i + 1) + ": ");
                if (nombre.trim().isEmpty()) {
                    iu.displayMessage("El nombre no puede estar vacío.");
                }
            } while (nombre.trim().isEmpty());

            this.players[i] = new Player(nombre.trim());
        }

        iu.displayMessage(numJugadores + " jugador(es) creado(s).");
    }

    /**
     * Reparte 8 cartas a cada jugador desde el mazo y ordena sus manos por especie.
     */
    private void repartirCartas() {
        iu.displayMessage("Repartiendo cartas...");

        for (Player jugador : this.players) {
            // Dar exactamente 8 cartas
            for (int i = 0; i < 8; i++) {
                Card carta = deck.takeFirstCard();

                if (carta != null) {
                    jugador.addCardToHand(carta);
                }
            }
        }

        iu.displayMessage("Reparto completado. Cada jugador tiene 8 cartas.");
    }

    /**
     * Muestra el estado inicial: mesa y manos de todos los jugadores.
     */
    private void mostrarEstadoInicial() {
        iu.displayMessage("\n========================================");
        iu.displayMessage("ESTADO INICIAL DEL JUEGO");
        iu.displayMessage("========================================\n");

        // Mostrar mesa
        iu.displayMessage(table.toString());

        // Mostrar mano de cada jugador
        for (Player jugador : this.players) {
            iu.displayMessage(jugador.toString());
            iu.displayMessage("");
        }

        iu.displayMessage("========================================\n");
    }

    public void play() {

        inicializarJugadores();

        repartirCartas();

        this.table.inicializarMesa();

        mostrarEstadoInicial();
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public Table getTable() {
        return this.table;
    }

    public DeckOfCards getDeck() {
        return this.deck;
    }
}