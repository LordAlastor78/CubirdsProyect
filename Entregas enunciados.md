# Proyecto AED I — Primera entrega (Curso 2025–2026)

Se ha realizado un roadmap a partir de lo que se nos pide en la primera entrega, con el objetivo de organizar el trabajo y asegurar que se cumplen todos los requisitos funcionales. A continuación se detallan las acciones a tomar para cada requisito.

## Resumen

Esta primera entrega se centra en el inicio del juego: generación de la baraja, creación de
jugadores y mesa, reparto inicial y representación por pantalla de la mesa y las manos.

Descarga desde Moovi (sección Proyecto) la estructura base y el diagrama de clases. Durante
el desarrollo se debe prestar atención a la visibilidad de atributos y métodos, aplicar buenas
prácticas de diseño y elegir las estructuras y algoritmos adecuados.

## Requisitos funcionales (Primera entrega)

Implementar las siguientes funcionalidades mínimas:

- Crear la baraja de 110 cartas usando el enumerado `Card` del paquete `core`.
	- Cada carta tiene: `TypeBird` (especie) y dos umbrales (bandada pequeña / bandada grande).
	

	# Acción a tomar: el constructor de `DeckOfCards` debe generar la baraja ordenada a partir del enumerado.
	- Para ello, haremos :
		- Un constructor en `DeckOfCards` que genere la baraja ordenada a partir del enumerado.

		[x] : Hecho el constructor de `DeckOfCards`.

		- Un método `shuffle()` para barajar la baraja (puede usar `Collections.shuffle()`).

		[] : Hecho el método `shuffle()` en `DeckOfCards`.




- Preguntar por el número de jugadores (entre 2 y 5) y crear los objetos `Player` con nombre.

	# Acción a tomar: en el método `main` de la clase `Main`, solicitar el número de jugadores y sus nombres, y crear los objetos `Player` correspondientes.

	[ ] : Hecho el método `main` para solicitar el número de jugadores y sus nombres, y crear los objetos `Player`.

- Crear la mesa (`Table`) inicialmente vacía.

	# Acción a tomar: en el método `main`, crear un objeto `Table` vacío.

	[ ] : Hecho el método `main` para crear un objeto `Table` vacío.


- Barajar la baraja y:
	- Repartir 8 cartas a cada jugador (las cartas de la mano deben agruparse por especie).
	- Colocar 3 cartas en cada una de las 4 filas de la mesa.

	# Acción a tomar: en el método `main`, después de crear los jugadores y la mesa, barajar la baraja y repartir las cartas a los jugadores y a la mesa según lo indicado.

	[ ] : Hecho el método `main` para barajar la baraja y repartir las cartas a los jugadores y a la mesa según lo indicado.


- Garantizar que en cada fila no haya pájaros de la misma especie: si aparece una repetida,
	seguir sacando cartas hasta tener 3 especies distintas; las cartas no usadas vuelven al final de la baraja.
- Mostrar por pantalla la disposición de la mesa y, para cada jugador, su nombre y las
	cartas repartidas.

	# Acción a tomar: implementar un método `display()` en la clase `Table` para mostrar la disposición de la mesa, y un método `displayHand()` en la clase `Player` para mostrar el nombre del jugador y las cartas de su mano.

	[ ] : Hecho el método `display()` en la clase `Table` y el método `displayHand()` en la clase `Player` para mostrar la disposición de la mesa y las manos de los jugadores según lo indicado.

> Nota: solo se exige la funcionalidad indicada arriba; la implementación debe compilar y
> ejecutarse según lo solicitado para que la entrega sea válida.

## Entrega

- [ ] Subir el proyecto a Moovi → Sección Proyecto / Primera Entrega.
- [ ] Solo se admitirán proyectos que compilen y se ejecuten conforme a los requisitos.

## Fecha tope

- Martes, 7 de abril de 2026 a las 23:00 h (no se admitirán entregas fuera de plazo).

## Revisión

- Tutoría grupal obligatoria para todos los miembros. Las tutorías se realizarán entre el
	8 y el 10 de abril; la fecha debe acordarse previamente con el docente.
