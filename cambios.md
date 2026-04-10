# Cambios realizados (Primera Entrega CuBirds)

## 1) Objetivo de la entrega
Se documentan los cambios mínimos aplicados para cumplir la Primera Entrega:

- Crear baraja y preparar partida inicial.
- Pedir jugadores (2 a 5) y crear sus objetos.
- Repartir 8 cartas por jugador.
- Inicializar mesa con 4 filas y 3 cartas por fila.
- Evitar especies repetidas en una misma fila.
- Devolver cartas no validas al final de la baraja.
- Mostrar por pantalla mesa y manos de jugadores.

## 2) Resumen global de decisiones
Se priorizo **funcionar y cumplir enunciado** sobre refactorizaciones grandes.

- Cambios pequenos y localizados.
- Mantener estilo del codigo existente.
- Evitar introducir complejidad innecesaria.

## 3) Cambios en core/Player.java
Archivo: `Proyecto/src/main/java/gal/uvigo/esei/aed1/cubirds/core/Player.java`

### 3.1 Constructor
Se corrigio la inicializacion de estructuras para evitar errores en tiempo de ejecucion.

Funcion afectada:
- `public Player(String name)`

Codigo aplicado:
```java
this.name = name;
this.hand = new LinkedList<>();
this.collection = new LinkedList<>();
```

Motivo:
- Garantizar que `hand` y `collection` nunca sean `null`.

### 3.2 Encapsulacion de getters
Funciones afectadas:
- `public List<Card> getHand()`
- `public List<Card> getCollection()`

Codigo aplicado:
```java
public List<Card> getHand() {
    return new LinkedList<>(this.hand);
}

public List<Card> getCollection() {
    return new LinkedList<>(this.collection);
}
```

Motivo:
- Evitar modificaciones externas directas sobre listas internas del jugador.

### 3.3 Reparto y agrupacion de mano
Funciones usadas:
- `public void generateHand()`
- `private void orderCards(List<Card> hand)`

Se mantuvo vuestra logica y se verifico que:
- Se reparten 8 cartas por jugador.
- La mano queda agrupada por especie.

## 4) Cambios en core/Game.java
Archivo: `Proyecto/src/main/java/gal/uvigo/esei/aed1/cubirds/core/Game.java`

### 4.1 Inicializacion correcta de jugadores
Funcion afectada:
- `public List<Player> inicializarJugadores()`

Cambio principal:
- Se elimina duplicidad de creacion de jugadores y se usa lectura por `IU`.

Codigo clave:
```java
numJugadores = iu.readNumber("¿Cuantos van a jugar? (2 a 5): ");
...
String nombre = iu.readString("Nombre del jugador " + (i + 1) + ": ");
listaJugadores.add(new Player(nombre));
```

Motivo:
- Pedir y crear exactamente los jugadores requeridos por enunciado.

### 4.2 Flujo de `play()` para primera entrega
Funcion afectada:
- `public void play()`

Flujo final implementado:
1. Crear lista de jugadores.
2. Convertir a array interno.
3. Repartir 8 cartas a cada jugador (`generateHand`).
4. Inicializar mesa (`table.inicializarMesa`).
5. Mostrar mesa y manos.

Codigo clave:
```java
List<Player> listaJugadores = inicializarJugadores();
this.players = listaJugadores.toArray(new Player[0]);

for (Player player : this.players) {
    player.generateHand();
}

table.inicializarMesa();

iu.displayMessage("\n=== REPARTO INICIAL ===");
iu.displayMessage(table.toString());
for (Player player : this.players) {
    iu.displayMessage(player.toString());
}
```

Motivo:
- Ajustar exactamente al alcance de la primera entrega.

## 5) Cambios en core/Table.java
Archivo: `Proyecto/src/main/java/gal/uvigo/esei/aed1/cubirds/core/Table.java`

### 5.1 Inicializacion segura de mesa
Funcion afectada:
- `public void inicializarMesa()`

Implementacion final:
```java
for (int i = 0; i < 4; i++) {
    while (this.filas[i].size() < 3) {
        Card lastCard = DeckOfCards.getDeckOfCards().getLast();
        DeckOfCards.removeLast();

        if (compareAndMove(i, lastCard)) {
            this.filas[i].addFirst(lastCard);
        } else {
            DeckOfCards.addLast(lastCard);
        }
    }
}
```

Motivo:
- Garantizar 3 cartas por fila.
- Evitar especies repetidas en fila.
- Devolver descartes al final de la baraja.

### 5.2 Validacion por especie en fila
Funcion afectada:
- `private boolean compareAndMove(int i, Card lastCard)`

Codigo:
```java
for (Card card : this.filas[i]) {
    if (card.getTypeBird().equals(lastCard.getTypeBird())) {
        return false;
    }
}
return true;
```

Motivo:
- Comprobacion simple y clara de repeticion de especie.

### 5.3 Representacion de mesa
Funcion agregada:
- `public String toString()`

Motivo:
- Poder mostrar en consola el estado real de las 4 filas para la entrega.

## 6) Cambio en pom.xml
Archivo: `Proyecto/pom.xml`

Cambio aplicado:
```xml
<exec.mainClass>gal.uvigo.esei.aed1.cubirds.iu.Main</exec.mainClass>
```

Motivo:
- Alinear el punto de entrada Maven con la clase `Main` real del proyecto.

## 7) Validacion funcional observada
En ejecucion manual se comprobo:

- Solicitud de numero de jugadores y nombres.
- Reparto inicial de 8 cartas por jugador.
- Mesa con 4 filas y 3 cartas por fila.
- Cartas de la mesa mostradas por pantalla.
- Cartas de cada jugador mostradas por pantalla.
- Agrupacion de mano por especie en salida.

## 8) Fallos detectados en el codigo original y viabilidad

### 8.1 Fallos en `core/Player.java`
1. `hand` podia quedar sin inicializar correctamente.
    - Riesgo: error en tiempo de ejecucion al usar `isEmpty`, `add`, etc.
    - Viabilidad original: **no viable** si se daba ese flujo.

2. Getters exponian listas internas mutables.
    - Riesgo: modificaciones externas no controladas.
    - Viabilidad original: **viable con riesgo medio** (no siempre rompe, pero puede introducir errores de estado).

### 8.2 Fallos en `core/Game.java`
1. Duplicacion de jugadores en alta (mismo nombre agregado dos veces).
    - Riesgo: numero de jugadores incorrecto y reparto inconsistente.
    - Viabilidad original: **no viable** para cumplir enunciado.

2. Inicializacion de jugadores invocada dos veces en `play()`.
    - Riesgo: doble entrada de datos y estado incoherente.
    - Viabilidad original: **no viable** funcionalmente.

3. No se mostraban cartas reales de mesa (solo texto generico).
    - Riesgo: incumplimiento parcial del requisito de salida.
    - Viabilidad original: **viable parcial** (funciona, pero no cumple completamente la entrega).

### 8.3 Fallos en `core/Table.java`
1. Logica original de colocacion/validacion podia mezclar insercion y chequeo.
    - Riesgo: filas contaminadas o comportamiento dificil de razonar.
    - Viabilidad original: **viable con riesgo alto**.

2. Gestion de repetidas no garantizaba siempre una salida clara del bucle.
    - Riesgo: bloqueo o repeticion indefinida en escenarios de conflicto.
    - Viabilidad original: **no viable** en casos limite.

### 8.4 Fallo en `pom.xml`
1. `exec.mainClass` no apuntaba a la clase `Main` real del proyecto.
    - Riesgo: fallos al ejecutar con Maven exec.
    - Viabilidad original: **viable en IDE, no viable en algunos flujos Maven**.

### 8.5 Conclusión de viabilidad inicial
Antes de los cambios, el proyecto estaba **cerca pero no plenamente viable** para la Primera Entrega por errores de flujo y de logica de inicializacion.

Tras los cambios aplicados, el estado pasa a **viable para entrega** en el alcance solicitado (inicio de juego, reparto y visualizacion inicial).

