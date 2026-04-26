package gal.uvigo.esei.aed1.cubirds.core;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import 

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
            this.hand.add(i, DeckOfCards.getDeckOfCards().get(0));
            DeckOfCards.removeIndex(0); // eliminamos el primero en cada ronda
        }

        orderCards(this.hand);

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

        int initialCardCounter = this.hand.size();

        for (int i = 0; i < initialCardCounter; i++) {
            switch (this.hand.get(i).getTypeBird()) {
                case FLAMENCO:
                    groupFLAMENCO.add(this.hand.get(i));
                    break;
                case TUCAN:
                    groupTUCAN.add(this.hand.get(i));
                    break;
                case PATO:
                    groupPATO.add(this.hand.get(i));
                    break;
                case URRACA:
                    groupURRACA.add(this.hand.get(i));
                    break;
                case PETIRROJO:
                    groupPETIRROJO.add(this.hand.get(i));
                    break;
                case LECHUZA:
                    groupLECHUZA.add(this.hand.get(i));
                    break;
                case CURRUCA:
                    groupCURRUCA.add(this.hand.get(i));
                    break;
                case GUACAMAYO:
                    groupGUACAMAYO.add(this.hand.get(i));
                    break;
            }
        } 
        
        this.hand.clear(); //eliminar lo que había en la mano porque tiene el orden raro

        this.hand.addAll(groupFLAMENCO);
        this.hand.addAll(groupTUCAN);
        this.hand.addAll(groupPATO);
        this.hand.addAll(groupURRACA);
        this.hand.addAll(groupPETIRROJO);
        this.hand.addAll(groupLECHUZA);
        this.hand.addAll(groupCURRUCA);
        this.hand.addAll(groupGUACAMAYO);
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

    public boolean hasNoCards() {
        return hand.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    // Método toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.hasNoCards()) {
            System.out.println("Sin cartas!");
        }
        else {
            sb.append("\nBaraja de ").append(this.getName()).append(": ");
            for (Card card : hand) {
                sb.append("\n").append(card.getTypeBird()).append(": Bandada pequeña - ").append(card.getSmallFlock()).append("; Bandada grande - ").append(card.getLargeFlock());
            }
        }

        return sb.toString();
    }

}


