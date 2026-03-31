package gal.uvigo.esei.aed1.cubirds.core;

import gal.uvigo.esei.aed1.cubirds.iu.IU;

public class Game { // Clase principal

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
        this.players = new Player[5]; // máximo 5 jugadores
        this.currentPlayerIndex = 0; // el primer jugador comienza
    }


    /**
     * Metodo principal para jugar:
     * 
     * 1. Mostrar estado actual (mesa, mano del jugador, colección).
     * 2. Pedir al jugador que elija una carta de su mano para jugar
     * 3. Validar la jugada (si es válida, colocar la carta en la mesa; si no,
     * mostrar error y pedir otra carta).
     * 4. Comprobar si se ha completado alguna bandada (pequeña o grande) tras
     * colocar la carta. Si se completa una bandada, mover las cartas de esa bandada
     * a la colección del jugador.
     * 5. Pasar el turno al siguiente jugador (actualizar currentPlayerIndex).
     * 6. Repetir el proceso hasta que un jugador se quede sin cartas en la mano,
     * momento en el que se declara el ganador (el jugador con más cartas en su
     * colección
     * al finalizar el juego).
     * 
     */
    public void play() {

        // Aquí se implementaría la lógica del juego siguiendo los pasos descritos en el
        // comentario anterior. Se utilizarían los métodos de las clases Player, Table
        // y DeckOfCards para gestionar las cartas, la mesa y las colecciones de los
        // jugadores, así como la interfaz de usuario (IU) para interactuar con el
        // jugador y mostrar el estado del juego.
        // aqui es donde se agrega lo de UI.
    }

    /*public static void main(String[] args) {
        IU iu = new IU(); // Crear instancia de la interfaz de usuario
        Game game = new Game(iu); // Crear instancia del juego
        game.play(); // Iniciar el juego
    }*/
}
