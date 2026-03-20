# Proyecto AED I — Primera entrega (Curso 2025–2026)

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
- Preguntar por el número de jugadores (entre 2 y 5) y crear los objetos `Player` con nombre.
- Crear la mesa (`Table`) inicialmente vacía.
- Barajar la baraja y:
	- Repartir 8 cartas a cada jugador (las cartas de la mano deben agruparse por especie).
	- Colocar 3 cartas en cada una de las 4 filas de la mesa.
- Garantizar que en cada fila no haya pájaros de la misma especie: si aparece una repetida,
	seguir sacando cartas hasta tener 3 especies distintas; las cartas no usadas vuelven al final de la baraja.
- Mostrar por pantalla la disposición de la mesa y, para cada jugador, su nombre y las
	cartas repartidas.

> Nota: solo se exige la funcionalidad indicada arriba; la implementación debe compilar y
> ejecutarse según lo solicitado para que la entrega sea válida.

## Entrega

- Subir el proyecto a Moovi → Sección Proyecto / Primera Entrega.
- Solo se admitirán proyectos que compilen y se ejecuten conforme a los requisitos.

## Fecha tope

- Martes, 7 de abril de 2026 a las 23:00 h (no se admitirán entregas fuera de plazo).

## Revisión

- Tutoría grupal obligatoria para todos los miembros. Las tutorías se realizarán entre el
	8 y el 10 de abril; la fecha debe acordarse previamente con el docente.
