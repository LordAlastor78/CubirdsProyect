package gal.uvigo.esei.aed1.cubirds.core;

import java.util.LinkedList;
import java.util.List;
import gal.uvigo.esei.aed1.cubirds.core.Card;

public class DeckOfCards {

    private static List<Card> deckOfCards = new LinkedList<>();

    // Método para crear el mazo de cartas
    public DeckOfCards() {
        List<Card> allCards = new LinkedList<>();

        for (int i = 0; i < Card.values().length; i++) {
            allCards.add(Card.values()[i]);
        }

        while (allCards.size() > 0) {
            int randomCard = (int) (Math.random() * allCards.size());
            deckOfCards.add(allCards.get(randomCard));
            allCards.remove(randomCard);
        }
    }

    // Getter de un clon de la baraja, se hace clon para no quitar
    // accidentalmente de la baraja original y mantener seguridad
    public static List<Card> getDeckOfCards() { //
        List<Card> deckClone = new LinkedList<>();
        deckClone.addAll(deckOfCards);
        return deckClone;
    }

    public static void removeLast() {
        deckOfCards.removeLast();
    }

    public static void removeIndex(int i) {
        deckOfCards.remove(i);
    }

}