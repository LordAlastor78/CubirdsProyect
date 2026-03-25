# DOC — Documentación del proyecto CuBirds

Este documento resume qué hace el proyecto, cómo está organizado el código y las decisiones de diseño relevantes.

## Resumen del proyecto
- Implementación en Java del juego CuBirds siguiendo el enunciado provisto.
- Objetivo del juego: ser el primer jugador en tener 7 especies distintas en la zona de juego, o 2 especies con al menos 3 cartas cada una.

## Reglas principales (resumen)
- Preparación: se barajan las cartas y se colocan 4 filas (vallas) con 3 cartas cada una (3 especies distintas por fila). Cada jugador recibe 8 cartas y 1 carta en su zona de juego.
- Turno de un jugador (acción obligatoria + opcionales):
  - Jugar cartas: baja todas las cartas de una misma especie de su mano en un extremo (izquierdo/derecho) de una valla.
  - Recoger rodeados: si las cartas colocadas rodean cartas (quedan entre dos cartas de la misma especie), esas cartas pasan a la mano del jugador.
  - Completar bandada (opcional): si tiene suficiente número de cartas de una especie en la mano (umbral de bandada pequeña), puede revelar y descartar esas cartas para incrementar su contador de colección para esa especie.
  - Rellenar fila: si una fila queda con todas cartas de la misma especie, se rellena hasta obtener al menos otra especie.
- Fin de ronda: si el jugador activo se queda sin cartas en la mano, todos los demás descartan su mano; se baraja el montón de descartes como nueva baraja y se reparten 8 cartas a cada jugador (si no es posible, finaliza la partida y gana quien tenga más cartas en su colección).
- Fin de la partida: cuando el jugador activo termina su turno y cumple la condición de victoria (7 especies distintas o 2 especies con ≥3 cartas).

## Estructura del repositorio
- Módulo principal: `gal.uvigo.esei.aed1_cubirds/` (contiene `pom.xml`).
- Código fuente: `gal.uvigo.esei.aed1_cubirds/src/main/java/gal/uvigo/esei/aed1/cubirds/` con dos paquetes principales:
  - `core`: lógica de juego y modelos.
  - `iu`: interfaz de usuario / `Main`.
- Documentación: `docs/` (contiene `build-and-run.md`, ahora `DOC.md`, y otros archivos descriptivos).

## Clases y responsabilidades (claves)
- `Card.java` — representa una carta: especie, información de bandada (pequeña/grande), etc.
- `TypeBird.java` — enumeración/definición de especies y parámetros (número total en baraja, umbrales de bandada).
- `DeckOfCards.java` — baraja y operaciones de robo/barajar; mantiene el mazo y permite rellenar desde descartes.
- `Player.java` — mano del jugador, zona de juego (colección), acciones para jugar cartas y completar bandadas.
- `Table.java` — las 4 vallas/filas; operaciones para colocar cartas en extremos, detectar y recoger cartas rodeadas y rellenar filas.
- `Game.java` — controla el flujo: turnos, detección de fin de ronda, reasignación de descartes, comprobación de victoria.
- `IU.java` / `Main.java` — interfaz de usuario y punto de entrada del programa.

## Estructuras de datos y decisiones (¿usar pilas?)
- `Deck` y `discard` (montón de descartes): se implementan con `Deque<Card>` (p. ej. `ArrayDeque`) — comportamiento de tope para robar y apilar descartes; `Deque` es más moderno y flexible que `Stack`.
- Vallas/filas en la mesa: `List<Card>` (por ejemplo `ArrayList` o `LinkedList`) porque se necesita insertar en ambos extremos y eliminar un rango desde el medio (las cartas rodeadas). `ArrayList` + `subList(...).clear()` es simple y eficiente para el tamaño reducido de cada fila.
- Mano del jugador: `List<Card>`.
- Zona de juego/colección: `Map<TypeBird,Integer>` (contador por especie) para comprobar bandadas y condiciones de victoria.

Decisión práctica: sí usar estructuras tipo «pila» para `Deck` y `discard` (LIFO desde el tope), pero evitar `java.util.Stack` en favor de `Deque`.

## Mapeo de reglas → código (flujo de ejecución)
1. Inicialización: `DeckOfCards` crea y baraja el mazo; `Table` coloca 4 filas con 3 cartas distintas cada una; `Game` reparte 8 cartas por jugador.
2. Turno de jugador: `Game` invoca método para que `Player` escoja especie y `Table` coloque cartas en la fila/ extremo elegido.
3. Tras colocar, `Table` detecta índices donde la misma especie rodea cartas y extrae esas cartas a la mano del jugador.
4. Opcionalmente, `Player` puede completar una bandada: se descartan las cartas correspondientes y se actualiza su `Map<TypeBird,Integer>`.
5. Si una fila queda con una única especie, `Table` pide cartas al `DeckOfCards` hasta introducir otra especie.
6. Fin de ronda y fin de juego: `Game` detecta mano vacía del jugador activo, obliga a descartar manos restantes, mezcla descartes en `Deck` y reparte; `Game` comprueba condición de victoria tras cada turno.

## Cómo compilar y ejecutar
- Proyecto Maven ubicado en `gal.uvigo.esei.aed1_cubirds/`.
- Resumen rápido (desde la raíz del repo):

```powershell
cd gal.uvigo.esei.aed1_cubirds
mvn clean package
# Ejecutar Main desde IDE o con mvn exec (si está configurado):
mvn exec:java -Dexec.mainClass="gal.uvigo.esei.aed1_cubirds.iu.Main"
```

- Para instrucciones más detalladas, ver `docs/build-and-run.md`.

## Notas para desarrollo y pruebas
- Revisar `DeckOfCards` y `Table` si se cambian las reglas de extracción o rellenado de filas.
- Mantener tests unitarios para: robo/barajar, operación de colocar cartas y recogida de cartas rodeadas, lógica de completar bandadas y condiciones de victoria.

## Sugerencias de mejora
- Añadir pruebas unitarias automáticas para las reglas críticas.
- Implementar una UI más amigable o una simulación automática para validar estrategias.

---

