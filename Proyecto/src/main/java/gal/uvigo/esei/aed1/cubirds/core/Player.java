package gal.uvigo.esei.aed1.cubirds.core;

public class Player {

    private String name;
    private List<Card> hand; // lista de listas de cada tipo de carta, donde cada "sublista" incluye cada carta de su tipo.
    private List<Card> collection; 
    //hand se debe inicializar vacío.

    // Constructor
    public Player(String name) {
        this.name = name;
        this.hand = hand;
        this.collection = new ArrayList<>();
    }

    // Getters
    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getCollection() {
        return collection;
    }

    // añadir carta a la mano

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // Borrar carta ( del juego )

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    // Pillar carta a la colección (en la zona de juego)
    public void addToCollection(Card card) {
        collection.add(card);
    }

    // Jugador se queda sin cartas

    public boolean HasNoCards() {
        return hand.isEmpty();
    }

    // Saber mano 

    public String toString() {
        StringBuilder <sb> ...
        for (Card c : hand) {
        }
    }
    return string del stringbuilder.
}


// faltan excepciones
