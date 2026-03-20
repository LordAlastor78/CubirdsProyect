package gal.uvigo.esei.aed1.cubirds.core;

public enum Card { // mejor cardCount que un enum muy largo, cada carta tiene un número de bandada
                   // mínima, un número de bandada completa y un tipo de pájaro asociado
  FLAMENCO(2, 3, TypeBird.FLAMENCO, 7),
  TUCAN(3, 4, TypeBird.TUCAN, 10),
  PATO(4, 6, TypeBird.PATO, 13),
  URRACA(5, 7, TypeBird.URRACA, 17),
  PETIRROJO(6, 9, TypeBird.PETIRROJO, 20),
  LECHUZA(3, 4, TypeBird.LECHUZA, 10),
  CURRUCA(6, 9, TypeBird.CURRUCA, 20),
  GUACAMAYO(4, 6, TypeBird.GUACAMAYO, 13); // esto es el enum de las cartas, cada carta tiene un número de bandada
                                           // mínima, un número de bandada completa y un tipo de pájaro asociado
  //llamar a esto CardData
  private final int smallFlock; // número de bandada mínima
  private final int largeFlock; // número de bandada completa
  private final TypeBird typeBird;
  private int cardCount; // contador de cartas para cada tipo de pájaro, se usará para generar la baraja
                         // ordenada a partir del enumerado

  Card(int smallFlock, int largeFlock, TypeBird typeBird, int cardCount) {
    this.smallFlock = smallFlock;
    this.largeFlock = largeFlock;
    this.typeBird = typeBird;
    this.cardCount = cardCount;
  }


  
  // Flamenco fantasma: 2,3 FLAMENCO, 7
  // sacas flamenco 1 --> 2,3 FLAMENCO , 7-7 + i

  public int getcardCount() {
    return cardCount;
  }

  public int getSmallFlock() {
    return smallFlock;
  }

  public int getLargeFlock() {
    return largeFlock;
  }

  public TypeBird getTypeBird() {
    return typeBird;
  }

  

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" [").append(typeBird)
        .append("  ").append(smallFlock)
        .append("/").append(largeFlock)
        .append("] ");

    return sb.toString();
  }

  // un metodo para generar la baraja ordenada a partir del enumerado, se usará en
  // el constructor de DeckOfCards

  public static void DeckFactory() { // genera la baraja ordenada a partir del enumerado, se usará en el constructor de DeckOfCards
    
    for (int i = 0; i < TypeBird.values().length; i++) {
      TypeBird currentBirdType = TypeBird.getBirdIndex(i); //según el índice retorna cierto pájaro
      Card currentCard = Card.getCardData(currentBirdType); //según el pájaro, retorna la carta correspondiente con sus datos
      for (int j=0; j < currentCard.getcardCount(); j++) {
      
      //currentCard = new Card (currentBird.getSmallFlock(), (currentBird.getLargeFlock(), currentBird, 0); //crea una carta con el tipo de pájaro y los umbrales correspondientes, el contador de cartas se inicializa a 0
      //Funcion a la que le pasas un TAD (cada "grupo"/tipo de carta con sus propios datos, y luego guardamos todas en un array90)
      
      
    }
    
    //despues de los fors, llamaria a un metodo que coge todas las listas y las mete en un array de cartas, que es la baraja ordenada a partir del enumerado

  }

  }

  public static Card getCardData(TypeBird typeBird) {
    // devuelve la constante enum correspondiente al TypeBird
    switch (typeBird) {
      case FLAMENCO:
        return FLAMENCO;
      case TUCAN:
        return TUCAN;
      case PATO:
        return PATO;
      case URRACA:
        return URRACA;
      case PETIRROJO:
        return PETIRROJO;
      case LECHUZA:
        return LECHUZA;
      case CURRUCA:
        return CURRUCA;
      case GUACAMAYO:
        return GUACAMAYO;
      default:
        throw new IllegalArgumentException("Invalid TypeBird: " + typeBird);
    }
  }

  

}