package gal.uvigo.esei.aed1.cubirds.core;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class Player {
    private String name;
    private List<Card> hand; // lista de listas de cada tipo de carta, donde cada "sublista" incluye cada
                             // carta de su tipo.
    private List<Card> collection;
    // hand se debe inicializar vacío.

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = hand;
        this.collection = new LinkedList<>();
    }

    public void generateHand() {

        for (int i = 0; i < 8; i++) { // 8 cartas por jugador
            hand.add(i, DeckOfCards.getDeckOfCards().get(0));
            DeckOfCards.removeIndex(0); // eliminamos el primero en cada ronda
        }

        orderCards(hand);

    }

    private void orderCards(List<Card> hand) { // creamos grupos y metemos las cartas en ellos

        List<Card> groupFLAMENCO = new LinkedList<>();
        List<Card> groupTUCAN = new LinkedList<>();
        List<Card> groupPATO = new LinkedList<>();
        List<Card> groupURRACA = new LinkedList<>();
        List<Card> groupPETIRROJO = new LinkedList<>();
        List<Card> groupLECHUZA = new LinkedList<>();
        List<Card> groupCURRUCA = new LinkedList<>();
        List<Card> groupGUACAMAYO = new LinkedList<>();

        int initialCardCounter = hand.size();

        for (int i = 0; i < initialCardCounter; i++) {
            switch (hand.get(i).getTypeBird()) {
                case FLAMENCO:
                    groupFLAMENCO.add(hand.get(i));
                case TUCAN:
                    groupTUCAN.add(hand.get(i));
                case PATO:
                    groupPATO.add(hand.get(i));
                case URRACA:
                    groupURRACA.add(hand.get(i));
                case PETIRROJO:
                    groupPETIRROJO.add(hand.get(i));
                case LECHUZA:
                    groupLECHUZA.add(hand.get(i));
                case CURRUCA:
                    groupCURRUCA.add(hand.get(i));
                case GUACAMAYO:
                    groupGUACAMAYO.add(hand.get(i));
            }
        }
    }

    // Getters
    public List<Card> getHand() {
        return hand;
    }

    public List<Card> getCollection() {
        return collection;
    }

    // Añadir carta a la mano
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // Borrar carta de la mano
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    // Añadir carta a la colección (en la zona de juego)
    public void addToCollection(Card card) {
        collection.add(card);
    }

    public boolean HasNoCards() {
        return hand.isEmpty();
    }

    // Método toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : hand) {
        }

        return sb.toString();
    }

}

// faltan excepciones
