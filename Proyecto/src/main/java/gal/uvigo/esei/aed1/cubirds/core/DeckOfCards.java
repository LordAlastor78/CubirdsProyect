package gal.uvigo.esei.aed1.cubirds.core;

import java.util.LinkedList;
import java.util.List;
import gal.uvigo.esei.aed1.cubirds.core.Card;

public static class DeckOfCards {
    /*
     * Tiene que ser static para poder ser accedida desde la clase Game, que es la
     * clase principal del proyecto, y desde la que se va a iniciar el juego. Si no
     * fuera static, no se podría acceder a ella desde Game sin crear una instancia
     * de DeckOfCards, lo cual no es necesario ni deseable en este caso, ya que
     * DeckOfCards es una clase que representa un concepto general (la baraja de
     * cartas) y no necesita mantener estado específico de una instancia para
     * funcionar correctamente. Al ser static, DeckOfCards puede ser utilizada
     * directamente sin necesidad de instanciarla, lo que simplifica su uso en el
     * contexto del juego.
     * 
     */

    // Lista de listas
    // las listas pequeñas son todas las listas de un tipo de carta concreto

    /**
     * Constructor: crea una baraja de cartas ordenada a partir del enumerado
     * DeckOfCards se encargará de crear la baraja a partir del enumerado Card,
     * organizando las cartas en listas según su tipo. Cada tipo de carta (FLAMENCO,
     * TUCAN, etc.) tendrá su propia lista dentro de la baraja. Esto permitirá
     * gestionar fácilmente las cartas por tipo durante el juego.
     */

    LinkedList<LinkedList> groupFather; // declaramos la lista de listas, es decir, la baraja de cartas

    public DeckOfCards() {

        LinkedList<Card> group = new LinkedList<>(); // Lista temporal para agrupar cartas del mismo tipo

        for (Card card : Card.values()) { // querido andres qe
            if (card.getTypeBird().equals(group.getFirst().getTypeBird())) {
                group.add(card);
            } else {
                // Si el tipo de carta actual no coincide con el tipo de la primera carta del
                // grupo, se crea un nuevo grupo y se agrega a la baraja.
                groupFather.add(group);
                group = new LinkedList<>(); // el grupo original se ve sustituído
                group.add(card);

            }
        }

    }

}// Aqui aqui aqui no hay quien viva, aqui no, aqui no :)