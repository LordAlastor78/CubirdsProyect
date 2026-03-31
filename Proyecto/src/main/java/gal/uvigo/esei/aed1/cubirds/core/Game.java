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


    public void play() {

      /*   
        initializeGame();

        
        while (!isGameOver()) {
            Player currentPlayer = players[currentPlayerIndex];
            iu.displayGameState(table, players, currentPlayer);

           
            currentPlayer.takeTurn(deck, table, iu);

            
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        }

        
        iu.displayFinalResults(players);
 */
    }

   
}
