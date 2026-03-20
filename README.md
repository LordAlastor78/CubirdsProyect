"""
# CuBirds — Proyecto AED I (2025–2026)

**Descripción**

CuBirds es un juego de cartas de pájaros para 2–5 jugadores, creado por Stefan Alexander (2018).
El objetivo es conseguir en tu zona de juego una colección con 7 especies distintas (de 8), o bien
tener 2 especies con al menos 3 pájaros cada una.

## Resumen rápido

- Jugadores: 2–5
- Cartas en la baraja: 110
- Cartas en mano al inicio de ronda: 8
- Filas en mesa: 4 filas (vallas), cada una con 3 cartas de especies distintas

## Cartas y especies

La baraja contiene 8 especies con las cantidades totales siguientes:

- Flamenco (2/3): 7 cartas
- Lechuza (3/4): 10 cartas
- Tucán (3/4): 10 cartas
- Pato (4/6): 13 cartas
- Guacamayo (4/6): 13 cartas
- Urraca (5/7): 17 cartas
- Curruca de caña (6/9): 20 cartas
- Petirrojo (6/9): 20 cartas

Cada carta muestra: especie (arriba izquierda), número total de esa especie (abajo izquierda)
y dos umbrales (bandada pequeña / bandada grande) arriba a la derecha. Para este proyecto, solo
se considera el umbral de la bandada pequeña: si un jugador tiene en mano >= ese número, puede
añadir 1 punto (1 carta) de esa especie a su zona de juego (opcional).

## Preparación de la partida

1. Barajar la baraja.
2. Colocar 4 filas en mesa con 3 cartas cada una; cada fila debe contener al menos 2 especies
	 diferentes. Si aparece una especie repetida en la misma fila, descartar esa carta al fondo y
	 robar otra hasta conseguir 3 especies distintas.
3. Repartir 8 cartas a cada jugador (mano oculta).
4. Elegir jugador inicial; el turno sigue en sentido de las agujas del reloj.

## Desarrollo del juego (por turno)

En su turno, cada jugador realiza obligatoriamente la acción de jugar cartas y puede opcionalmente
completar bandadas y/o provocar el rellenado de filas:

- Jugar cartas (acción obligatoria): elegir una especie en mano y bajar todas las cartas de esa
	especie, colocándolas a la izquierda o derecha de una de las 4 filas. Si esa especie ya está
	presente en la fila, todas las cartas que queden entre las cartas iguales (las rodeadas) vuelan
	a la mano del jugador que las baja. Las cartas restantes en la fila se juntan para no dejar huecos.

- Completar una bandada (opcional): si el jugador tiene en mano un número de cartas de una especie
	>= al umbral de bandada pequeña indicado por la carta, puede descartar todas esas cartas y
	aumentar en 1 el contador de esa especie en su zona de juego (las cartas descartadas van al
	montón de descartes). Esta acción es opcional.

- Rellenar mesa: si una fila queda compuesta solo por cartas de la misma especie, se deben robar
	cartas de la baraja hasta encontrar una carta de especie distinta (cada fila debe tener al menos
	2 especies). Si la baraja se agota, barajar el montón de descartes y continuar.

Al terminar su turno, pasa al siguiente jugador.

## Fin de la ronda y reaprovisionamiento

Una ronda termina cuando el jugador activo se queda sin cartas en la mano. En ese momento,
los demás jugadores descartan todas sus cartas al montón de descartes. Se baraja el montón de
descartes para formar la nueva baraja y se reparte de nuevo 8 cartas a cada jugador. Si no es
posible repartir 8 cartas a cada jugador, el juego finaliza y gana el jugador con más cartas en su
zona de juego (empate: cualquiera de los vencedores).

## Fin de la partida

La partida termina cuando, al finalizar su turno, un jugador tiene 7 especies diferentes en su
zona de juego.

## Información adicional

Video ejemplo: https://www.youtube.com/watch?v=9mdsxCs6d40

## Organización del trabajo (para el proyecto)

1. Trabajo en equipo (4–5 estudiantes). Formación de equipos mediante la plataforma Moovi.
2. Implementación en Java y Visual Studio Code siguiendo las reglas descritas.
3. Cada integrante debe conocer todas las partes y ser responsable de su contribución.

### Entregas

- Se exigirán 3 entregas funcionales; las tareas y fechas se indicarán en Moovi.
- Cada entrega se defenderá ante el docente por todos los miembros del equipo.
- Copias entre grupos: suspenso para ambos grupos implicados.

### Evaluación

- Evaluación grupal (tutoría final): 10% de la nota final.
- Evaluación individual (examen práctico en ordenador, previsto 3 de junio de 2026): 20%.


