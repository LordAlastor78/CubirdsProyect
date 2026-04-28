package gal.uvigo.esei.aed1.cubirds.core;

//por fin arreglamos los imports :D
import gal.uvigo.esei.aed1.auxiliaryClasses.Pair;
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
        this.table.inicializarMesa();
        this.players = null; // Se inicializa como null porque ya se convierte en un array en
                             // inicializarJugadores()
        this.currentPlayerIndex = 0;
    }

    /**
     * brief
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
                if (nombre.isBlank() || nombre == null) {
                    iu.displayMessage("El nombre no puede estar vacío o ser nulo.");
                }
            } while (nombre.isBlank() || nombre == null);

            this.players[i] = new Player(nombre.trim());
        }

        iu.displayMessage(numJugadores + " jugadores creados. ");
    }

    /**
     * Reparte 8 cartas a cada jugador desde el mazo y ordena sus manos por especie.
     */
    private void repartirCartas() {
        iu.displayMessage("Repartiendo cartas...");

        for (Player jugador : this.players) {
            // Dar exactamente 8 cartas
            for (int i = 0; i < 8; i++) {
                /*
                 * Card carta = deck.takeFirstCard();
                 * 
                 * if (carta != null) {
                 * jugador.addCardToHand(carta);
                 * }
                 */

                jugador.addDeckCardToHand();
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

    public void playCardsOnRow(Player player, Pair<TypeBird, List<Card>> pair, int rowIndex, boolean placeLeft) {
        TypeBird species = pair.getKey();
        List<Card> cardsToPlay = pair.getValue();

        List<Card> capturedCards = new LinkedList<>();
        List<Card> row = table.getFilas()[rowIndex]; // Obtenemos la fila de la mesa donde se van a colocar las cartas

        // Verifica si hay cartas de la misma especie ya en la fila
        boolean hasSameTypeBird = false;
        int index = 0;

        while (index < row.size() && hasSameTypeBird == false) {
            if (row.get(index).getTypeBird() == species) {
                hasSameTypeBird = true;
            }
            index++;
        }

        // Colocar las cartas en el lado especificado
        if (placeLeft) { // Las cartas se colocan a la izquierda o derecha según el booleano placeLeft

            for (int i = 0; i < cardsToPlay.size(); i++) {
                row.addFirst(cardsToPlay.get(i));
            }
        } else {
            for (int i = 0; i < cardsToPlay.size(); i++) {

                row.addLast(cardsToPlay.get(i)); // :p

            } // Añade cada carta individualmente a la derecha

        }

        // Guarda las posiciones donde están los pájaros de la especie insertada
        List<Integer> speciesPositions = new LinkedList<>();
        for (int i = 0; i < row.size(); i++) {
            if (row.get(i).getTypeBird() == species) {
                speciesPositions.addLast(i);
            }
        }

        // Si hay al menos 2 cartas de la especie, capturar las del medio
        if (hasSameTypeBird == true) {

            int firstPos = speciesPositions.get(0); // Aquí utilice get para no crear mas getters :P

            int lastPos = speciesPositions.get(speciesPositions.size() - 1);

            // Captura cartas entre la primera y última aparición de la especie (SIN incluir
            // los pájaros :D) 
            // Solo captura si hay cartas en el medio (firstPos + 1 < lastPos)
            if (firstPos + 1 < lastPos) {
                for (int i = firstPos + 1; i < lastPos; i++) {
                    capturedCards.addLast(row.get(i));
                }
            }

            // Elimina las cartas capturadas y los pájaros rodeados de la fila (de atrás
            // hacia adelante para no desindexar)
            for (int i = lastPos; i >= firstPos; i--) {
                row.remove(i);
            }
        }

        // Se añaden las cartas de capturedCards a la mano del jugador
        for (int i = 0; i < capturedCards.size(); i++) {
            player.addCardToHand(capturedCards.get(i));
        }
    }

    public void executePlayerTurn(Player player) {
        iu.displayMessage("Turno del jugador " + player.getName() + ": ");
        // Mostrar baraja del jugador
        iu.displayMessage(player.toString()); // :D

        iu.displayMessage(table.toString());

        int eleccion = -1;
        // lista de los pares que puede coger como la mano
        List<Pair<TypeBird, List<Card>>> validPairs = new LinkedList();

        Pair<TypeBird, List<Card>> parEscogido = null;

        do {
            iu.displayMessage("Escoge un tipo de pájaro válido que tengas en tu baraja: ");

            int i = 1;

            validPairs.clear(); // Limpiar la lista de tipos válidos antes de llenarla nuevamente

            for (Pair par : player.getHand()) {
                // Solo mostrar tipos de pájaro que tengan al menos una carta
                LinkedList<Card> cardList = (LinkedList<Card>) par.getValue();
                if (!cardList.isEmpty()) {
                    validPairs.addLast(par);

                    TypeBird tipoSiendoMostrado = (TypeBird) par.getKey();

                    iu.displayMessage(i + ". " + tipoSiendoMostrado.toString());
                    i++;
                }
            }
            eleccion = iu.readNumber("");
        } while (eleccion < 1 || eleccion > validPairs.size());

        // TypeBird tipoElegido = (TypeBird) validPairs.get(eleccion - 1).getKey(); //
        // Restamos 1 porque la lista se muestra a partir de 1 pero
        // // los índices empiezan en 0

        parEscogido = validPairs.get(eleccion - 1);

        // Preguntar fila
        int filaElegida = -1;
        do {
            iu.displayMessage("¿En qué fila deseas colocar tu(s) carta(s)? (De 1 a " + table.getFilas().length + "): ");

            filaElegida = iu.readNumber("");
        } while (filaElegida < 1 || filaElegida > table.getFilas().length);

        boolean colocarIzquierda = false;
        do {

            eleccion = iu.readNumber("En que lado quieres colocar las cartas? 1 para izquierda, 2 para derecha. ");
            if (eleccion == 1) {
                colocarIzquierda = true;
                iu.displayMessage("Has elegido colocar las cartas a la izquierda.");

            } else if (eleccion == 2) {
                colocarIzquierda = false;
                iu.displayMessage("Has elegido colocar las cartas a la derecha.");
            }

        } while (eleccion < 1 || eleccion > 2);

        playCardsOnRow(player, parEscogido, filaElegida - 1, colocarIzquierda);

        // Eliminar las cartas jugadas de la mano del jugador
        LinkedList<Card> cardsToRemove = (LinkedList<Card>) parEscogido.getValue();
        for (Card card : cardsToRemove) {
            player.removeCardFromHand(card);
        }

        // Mostrar la mano del jugador después de la acción
        iu.displayMessage("\n--- Estado después de jugar cartas ---");
        iu.displayMessage(player.toString());

        // Mostrar la mesa actualizada
        iu.displayMessage(table.toString());

    }

    public void play() {

        // Inicializar el juego
        inicializarJugadores();
        repartirCartas();
        mostrarEstadoInicial();

        // Bucle principal
        boolean gameFinished = false;

        while (!gameFinished) {
            Player currentPlayer = players[currentPlayerIndex];

            // Ejecutar turno del jugador actual

            executePlayerTurn(currentPlayer);

            // Verificar condición de fin de juego (ej: un jugador se queda sin sus oniichan
            // cartas)
            if (currentPlayer.hasNoCards()) {
                iu.displayMessage(currentPlayer.getName() + " Ha ganado la partida!");
                gameFinished = true;
            }

            if (!gameFinished) {
                // El cálculo del siguiente índice funciona igual con .size() ,
                currentPlayerIndex = (currentPlayerIndex + 1) % players.length;

                // Pausa para que el jugador pueda ver el resultado de su turno antes de que el
                // siguiente jugador comience
                iu.readString("\nPresiona cualquiera tecla para continuar...");
            }
        }

        // Resultados
        iu.displayMessage("\n=== RESULTADOS FINALES ===");
        for (Player p : players) {
            iu.displayMessage(p.getName() + ": " + p.getHandSize() + " cartas.");
        }

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