# Estructura del proyecto

Raíz del repositorio:

- `gal.uvigo.esei.aed1_cubirds/` — módulo principal Java con `pom.xml`.
  - `src/main/java/gal/uvigo/esei/aed1/cubirds/core/` — lógica del juego (modelo):
    - `Card.java` — representación de una carta.
    - `DeckOfCards.java` — baraja y operaciones de robo.
    - `Game.java` — control de la partida y reglas.
    - `Player.java` — datos del jugador y su zona de juego.
    - `Table.java` — representación de las filas en mesa.
    - `TypeBird.java` — enumeración de especies.
  - `src/main/java/gal/uvigo/esei/aed1/cubirds/iu/` — interfaz de usuario / clases de ejecución:
    - `IU.java` — interfaz de usuario (console / pruebas).
    - `Main.java` — punto de entrada.

Carpeta `docs/` (esta documentación):

- `index.md` — índice.
- `overview.md`, `build-and-run.md`, `project-structure.md`, `api.md`.
