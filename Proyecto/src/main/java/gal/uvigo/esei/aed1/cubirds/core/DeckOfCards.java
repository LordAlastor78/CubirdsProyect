package gal.uvigo.esei.aed1.cubirds.core;

import java.util.LinkedList;
import java.util.List;
import gal.uvigo.esei.aed1.cubirds.core.Card;

/*
    Clase DeckOfCards
    - Poner atributos y métodos no static. El programa funcionará igual dejando el atributo como estático o no estático, 
        ya que solo habrá un mazo en toda la ejecución. Sin embargo, lo más recomendable y limpio es NO usar 
        static si solo vas a crear una instancia
        • Dejamos todos los métodos en static porque, personalmente, vemos mucho más fácil implementar la baraja siendo 
            estos métodos estáticos. En caso contrario, la mejor manera que se nos ocurre sería crear un objeto de clase 
            DeckOfCards en cada otra clase que la utilize, lo cuál, en nuestra opinión, sería un poco raro.
        
    - El resto de los métodos, ¿los utilizas? 
        • Quitar en la última revisión si es necesario.
*/

public class DeckOfCards {

    private static List<Card> deckOfCards = new LinkedList<>();

    // Constructor de la baraja de cartas
    public DeckOfCards() {
        // Hacemos .clear() por si se hacen dos o más partidas seguidas, para que
        // siempre se empiece desde cero.
        deckOfCards.clear();
        List<Card> allCards = new LinkedList<>();

        for (int i = 0; i < Card.values().length; i++) {
            allCards.add(Card.values()[i]);
        }

        // Barajamos las cartas
        while (allCards.size() > 0) {
            int randomCard = (int) (Math.random() * allCards.size());
            deckOfCards.add(allCards.remove(randomCard));
        }
    }

    public static Card takeFirstCard() { //
        Card toReturn = deckOfCards.getFirst();
        deckOfCards.removeFirst();
        return toReturn;
    }

    public static Card removeFirst() {
        return deckOfCards.removeFirst();
    }

    public static Card removeLast() {
        return deckOfCards.removeLast();
    }

    public static Card removeIndex(int i) {
        return deckOfCards.remove(i);
    }

    public static void addFirst(Card card) {
        deckOfCards.addFirst(card);
    }

    public static void addLast(Card card) {
        deckOfCards.addLast(card);
    }

    public static Card getFirstCard() {
        return deckOfCards.get(0);
    }

    public static Card getLastCard() {
        return deckOfCards.get(deckOfCards.size() - 1);
    }

}