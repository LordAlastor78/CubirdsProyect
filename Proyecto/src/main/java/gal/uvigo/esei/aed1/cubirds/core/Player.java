package gal.uvigo.esei.aed1.cubirds.core;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import gal.uvigo.esei.aed1.auxiliaryClasses.Pair;

public class Player {
    private String name;
    private LinkedList<Pair<TypeBird, LinkedList<Card>>> hand; // lista de listas de cada tipo de carta, donde cada
                                                               // "sublista" incluye cada
    // carta de su tipo.

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = new LinkedList<Pair<TypeBird, LinkedList<Card>>>();

        for (TypeBird tipo : TypeBird.values()) {
            hand.addLast(new Pair<>(tipo, new LinkedList<>()));
        }
    }

    public void addDeckCardToHand() {

        Card cardToAdd = DeckOfCards.takeFirstCard();

        for (Pair<TypeBird, LinkedList<Card>> par : hand) {
            if (par.getKey() == cardToAdd.getTypeBird()) {
                LinkedList<Card> checkedCardList = par.getValue();
                checkedCardList.addLast(cardToAdd);
                par.setValue(checkedCardList);
                break;
            }
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public LinkedList<Pair<TypeBird, LinkedList<Card>>> getHand() {
        return hand;
    }

    public int getHandSize() {
        int total = 0;
        for (Pair<TypeBird, LinkedList<Card>> par : hand) {
            total += par.getValue().size();
        }
        return total;
    }

    // Añadir carta a la mano
    public void addCardToHand(Card card) { 
        for (Pair<TypeBird, LinkedList<Card>> par : hand) {
            if (par.getKey() == card.getTypeBird()) {
                // checkedCardList es necesario para tranformar el tipo de Object a List<Card>
                LinkedList<Card> checkedCardList = par.getValue();
                checkedCardList.addLast(card);
                par.setValue(checkedCardList);
                break;
            }
        }
    }

    public void removeCardFromHand(Card card) {
        for (Pair<TypeBird, LinkedList<Card>> par : hand) {
            if (par.getKey() == card.getTypeBird()) {

                LinkedList<Card> checkedCardList = par.getValue();

                checkedCardList.removeValue(card);

                return;
            }
        }
    }

    public boolean hasNoCards() {

        for (Pair<TypeBird, LinkedList<Card>> par : hand) {
            // checkedCardList es necesario para tranformar el tipo de Object a List<Card>
            LinkedList<Card> checkedCardList = par.getValue();
            if (!checkedCardList.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    // Método toString
    public String toString() {

        StringBuilder sb = new StringBuilder();
        if (this.hasNoCards()) {
            return "\nBaraja de " + this.getName() + ": Sin cartas!";
        } else {
            sb.append("\nBaraja de ").append(this.getName()).append(": ");

            for (int i = 0; i < hand.size(); i++) { // Por cada tipo de carta...

                for (int j = 0; j < hand.get(i).getValue().size(); j++) {

                    Card card = hand.get(i).getValue().get(j); // Me da una carta

                    sb.append("\n").append(card.getTypeBird()).append(": Bandada pequeña - ")
                            .append(card.getSmallFlock()).append("; Bandada grande - ").append(card.getLargeFlock());
                }
            }
        }

        return sb.toString();

        // Otra manera de los fors:
        /*
         * int index = 0;
         * for (Pair par : hand) {
         * int handSize = hand.get(index).getValue().size();
         * for (int i=0; i<handSize; i++) {
         * Card card = hand.get(index).getValue().get(i); //me da una carta
         * sb.append("\n").append(card.getTypeBird()).append(": Bandada pequeña - ").
         * append(card.getSmallFlock())
         * .append("; Bandada grande - ").append(card.getLargeFlock());
         * }
         * index++;
         * }
         */
    }

}

// Métodos que fueron usados en algun punto:

/*
 * public void generateHand() {
 * 
 * orderCards(getHand());
 * }
 * 
 * private void orderCards(List<Card> hand) { // creamos grupos y metemos las
 * cartas en ellos
 * 
 * // List<Pair(typeBird, List<Card>)>
 * //
 * 
 * List<Card> groupFLAMENCO = new LinkedList<>();
 * List<Card> groupTUCAN = new LinkedList<>();
 * List<Card> groupPATO = new LinkedList<>();
 * List<Card> groupURRACA = new LinkedList<>();
 * List<Card> groupPETIRROJO = new LinkedList<>();
 * List<Card> groupLECHUZA = new LinkedList<>();
 * List<Card> groupCURRUCA = new LinkedList<>();
 * List<Card> groupGUACAMAYO = new LinkedList<>();
 * 
 * int initialCardCounter = this.hand.size();
 * 
 * for (int i = 0; i < initialCardCounter; i++) {
 * switch (this.hand.get(i).getTypeBird()) {
 * case FLAMENCO:
 * groupFLAMENCO.addLast(this.hand.get(i));
 * break;
 * case TUCAN:
 * groupTUCAN.addLast(this.hand.get(i));
 * break;
 * case PATO:
 * groupPATO.addLast(this.hand.get(i));
 * break;
 * case URRACA:
 * groupURRACA.addLast(this.hand.get(i));
 * break;
 * case PETIRROJO:
 * groupPETIRROJO.addLast(this.hand.get(i));
 * break;
 * case LECHUZA:
 * groupLECHUZA.addLast(this.hand.get(i));
 * break;
 * case CURRUCA:
 * groupCURRUCA.addLast(this.hand.get(i));
 * break;
 * case GUACAMAYO:
 * groupGUACAMAYO.addLast(this.hand.get(i));
 * break;
 * }
 * }
 * 
 * this.hand.clear(); // eliminar lo que había en la mano porque tiene el orden
 * raro
 * 
 * for (Card card : groupFLAMENCO)
 * this.hand.addLast(card);
 * for (Card card : groupTUCAN)
 * this.hand.addLast(card);
 * for (Card card : groupCURRUCA)
 * this.hand.addLast(card);
 * for (Card card : groupPATO)
 * this.hand.addLast(card);
 * for (Card card : groupURRACA)
 * this.hand.addLast(card);
 * for (Card card : groupPETIRROJO)
 * this.hand.addLast(card);
 * for (Card card : groupLECHUZA)
 * this.hand.addLast(card);
 * for (Card card : groupGUACAMAYO)
 * this.hand.addLast(card);
 * }
 * 
 * 
 */
