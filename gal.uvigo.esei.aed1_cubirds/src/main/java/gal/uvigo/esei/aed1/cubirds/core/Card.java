package gal.uvigo.esei.aed1.cubirds.core;

public enum Card { // mejor cardcount que un enum muy largo, cada carta tiene un número de bandada mínima, un número de bandada completa y un tipo de pájaro asociado
  FLAMENCO(2,3, TypeBird.FLAMENCO, 7),
  TUCAN(3,4,TypeBird.TUCAN, 10),
  PATO(4,6,TypeBird.PATO, 13),
  URRACA(5,7,TypeBird.URRACA, 17),
  PETIRROJO(6,9,TypeBird.PETIRROJO, 20),
  LECHUZA(3,4,TypeBird.LECHUZA, 10),
  CURRUCA(6,9,TypeBird.CURRUCA, 20),
  GUACAMAYO(4,6,TypeBird.GUACAMAYO, 13); // esto es el enum de las cartas, cada carta tiene un número de bandada mínima, un número de bandada completa y un tipo de pájaro asociado

  private final int smallFlock; // número de bandada mínima
  private final int largeFlock; // número de bandada completa
  private final TypeBird typeBird;
  private int cardcount; // contador de cartas para cada tipo de pájaro, se usará para generar la baraja ordenada a partir del enumerado

  Card(int smallFlock, int largeFlock, TypeBird typeBird, int cardcount) {
    this.smallFlock = smallFlock;
    this.largeFlock = largeFlock;
    this.typeBird = typeBird;
    this.cardcount = cardcount; 
  }
  //Flamenco fantasma: 2,3 FLAMENCO, 7
  //sacas flamenco 1 --> 2,3 FLAMENCO , 7-7 + i 

  public int getCardcount() {
      return cardcount;
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
}

  /* Implementar las siguientes funcionalidades mínimas:

- Crear la baraja de 110 cartas usando el enumerado `Card` del paquete `core`.
	- Cada carta tiene: `TypeBird` (especie) y dos umbrales (bandada pequeña / bandada grande).

	# Acción a tomar: el constructor de `DeckOfCards` debe generar la baraja ordenada a partir del enumerado.
	- Para ello, haremos :
		- Un constructor en `DeckOfCards` que genere la baraja ordenada a partir del enumerado.

		[] : Hecho el constructor de `DeckOfCards` y el método `shuffle()`.

		- Un método `shuffle()` para barajar la baraja (puede usar `Collections.shuffle()`).

		[] : Hecho el método `shuffle()` en `DeckOfCards`. */


    


