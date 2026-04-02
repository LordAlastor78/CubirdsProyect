package gal.uvigo.esei.aed1.cubirds.core;

import java.util.Scanner;
import gal.uvigo.esei.aed1.cubirds.iu.IU;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

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
        Scanner sc = new Scanner(System.in);
        List<Player> listaJugadores = new LinkedList<>();
        int numJugadores = 0;

        // rango de jugadores de 2 a 5
        do {
            System.out.println("¿Cuantos van a jugar? (2 a 5): ");
            if (sc.hasNextInt()) {
                numJugadores = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Porfavor, introduce un número válido");
            }

        } while (numJugadores < 2 || numJugadores > 5);
        // Se introduce el número de jugadores mediante su nombre
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Nombre del jugador " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            listaJugadores.add(new Player(nombre));

            Player playerp = new Player(nombre); // se repite
            listaJugadores.add(playerp); // player = playerp Uwu

        }

        return listaJugadores;

    }

    public void play() { // aun por hacer

        List<Player> listaJugadores = inicializarJugadores();

        this.players = inicializarJugadores().toArray(new Player[0]);

        // ya barajamos y hacemos reparto en Deck of cards

        table.inicializarMesa();

        // ahora bucle del juego

        while (true) {

            Player actual = players[currentPlayerIndex];

            System.out.println("""
                    ========================
                    Turno de: """ + actual.getName() + """
                    ========================
                    """);

            System.out.println(actual);

            System.out.println("/TODO");

            currentPlayerIndex = (currentPlayerIndex + 1) % players.length; // pasa al siguiente jugador
        }
    }

}
