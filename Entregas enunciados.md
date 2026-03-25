AED I. Proyecto 2025-2026 1
PROYECTO DE
ALGORITMOS Y ESTRUCTURAS DE DATOS I



El objetivo del juego es conseguir una colección de cartas de pájaros de 7 especies diferentes (de las
8 existentes) o 2 especies con al menos 3 pájaros en cada una.
Los jugadores comienzan cada ronda de CuBirds con 8 cartas de pájaro en su mano y 1 carta en su
zona de juego (que ya formará parte de su colección). Sobre la mesa habrá también 4 filas (vallas)
con 3 pájaros de diferente especie en cada una. En su turno, el jugador colocará todos los pájaros de
la misma especie en cualquier extremo de una de las vallas con el objetivo de rodear a pájaros de
otra especie (se rodean aquellas cartas que quedan en el medio de dos cartas de la misma especie).
Los pájaros rodeados vuelan hacia la mano del jugador y los restantes se mantendrán en la valla sin
dejar ningún hueco entre ellos. Cuando un jugador tenga un número suficiente de pájaros de la
misma especie en la mano, si lo desea podrá bajar 1 o 2 a su zona de juego formando parte de su
colección.
El objetivo final es lograr ser el primer jugador en acumular en su zona de juego 7 especies de
pájaros distintas, o 2 especies con 3 pájaros en cada una. Ten cuidado, ya que, si algún jugador se
queda sin cartas en la mano, ¡todos deberán descartar sus cartas y robar nuevas, desbaratando así los
planes que tuvieran preparados!
Cartas
La baraja consta de un total de 110 cartas. Las 8 especies de pájaros que forman parte del juego son
las siguientes:

• Flamenco (2/3): 7 cartas
• Lechuza (3/4): 10 cartas
• Tucán (3/4): 10 cartas
• Pato (4/6): 13 cartas

Bandada pequeña / Bandada grandeEspecie

Número total de pájaros de esta especie en la baraja

AEDI. Proyecto 2025-2026 2

• Guacamayo (4/6): 13 cartas
• Urraca (5/7): 17 cartas
• Curruca de caña (6/9): 20 cartas
• Petirrojo (6/9): 20 cartas
Cada carta tiene la especie a la que pertenece (arriba a la izquierda), el número total de elementos
de esa especie en la baraja (abajo a la izquierda) y dos números separados por una barra inclinada
(arriba a la derecha) que representa el número de cartas iguales que se necesitan para poder formar
una bandada (pequeña o grande). Por ejemplo, el petirrojo tiene asignado 6/9, lo que quiere decir
que se necesitan un mínimo de 6 cartas de esa especie para crear una bandada. Si un jugador tiene
en su mano un número de cartas igual o mayor que 6 y menor que 9 (se forma una bandada
pequeña) puede añadir UNA carta de petirrojo a su zona de juego, mientras que si tiene un número
mayor o igual a 9 (se forma una bandada grande) puede añadir DOS cartas de petirrojo a su zona
de juego.
Bases del juego específicas para este proyecto
Preparación de la Partida
Se barajarán las cartas y se colocarán en la mesa 4 filas con 3 cartas de pájaro cada una, no puede
haber pájaros de la misma especie en la misma fila. En tal caso, se siguen sacando cartas hasta
conseguir 3 especies distintas, las cartas no utilizadas se devuelven de nuevo al final de la baraja.
Cada jugador toma 8 cartas de la baraja que mantendrá ocultas en su mano. Comienza el juego un
jugador cualquiera, después continuará el turno en el sentido de las agujas del reloj.
Desarrollo del Juego
En cada ronda, cada jugador por turnos puede realizar alguna de estas acciones:
i. Jugar cartas (acción obligatoria)
◦ El jugador escoge qué especie de pájaro de su mano quiere colocar y baja todos los
pájaros de esa especie, situándolos a la derecha o a la izquierda de una de las 4 filas que
hay en la mesa.
◦ Si el jugador baja una especie de pájaro que ya se encuentra en la fila, se lleva a la mano
todas las cartas situadas entre los pájaros de esa especie y los que acaba de colocar
(cartas rodeadas). Después junta los pájaros que han quedado en la fila para que no
queden huecos.
◦ Puede suceder que al bajar las cartas a la mesa no se rodee ningún pájaro.
ii. Completar una bandada (opcional)
◦ La forma de añadir cartas de una especie a la colección de cada jugador (zona de juego)
es completando una bandada de una especie de pájaros. Para ello, tendrá que revelar y
descartar todos los pájaros de la misma especie que se tenga en la mano, siempre que se
AED I. Proyecto 2025-2026 3
cumpla la siguiente restricción:
▪ Cada carta dispone de 2 números (bandada pequeña/bandada grande) que indican la
cantidad mínima de cartas de esa especie que hay que tener para crear una bandada
pequeña o grande. En la versión específica del juego a implementar en este proyecto,
para formar una bandada sólo se tiene en cuenta la siguiente restricción: en caso de
que se disponga en la mano un número de cartas de la misma especie igual o
superior al indicado por la bandada pequeña se incrementará en UNO el contador
de la especie de esa bandada (el contador representa la zona de juego de un jugador).
Todas las cartas que forman la bandada se quitan de la mano del jugador y se
introducen en el montón de descartes.
◦ Completar bandadas no es obligatorio, por lo que un jugador aun pudiendo bajar una
bandada puede decidir no hacerlo.
iii. Rellenar mesa
◦ Si todas las cartas que quedan en la fila son de la misma especie, hay que añadir cartas
de la baraja hasta conseguir que salga un pájaro de una especie diferente (es obligatorio
que en cada fila existan como mínimo 2 especies). En caso de que la baraja se quede sin
cartas, se añaden las del montón de descartes, se barajan y de nuevo se va rellenando la
fila hasta obtener una carta de una especie diferente.
Pasa el turno al siguiente jugador.
Fin de la ronda
Una ronda termina cuando el jugador que está en su turno se queda sin cartas en la mano. En ese
momento los demás jugadores se verán obligados a descartarse por completo de su mano,
añadiendo todas sus cartas al montón de descartes.
Se vacía el montón de descartes pasando todas las cartas a la baraja, se barajan y cada jugador toma
8 cartas nuevas para continuar el juego. Si no es posible repartir 8 cartas a cada jugador, finaliza el
juego y el jugador con el mayor número de cartas en su colección (zona de juego) gana la partida. Si
hubiera un empate, ganaría cualquier jugador de los vencedores.
Fin del Juego
La partida termina cuando el jugador activo finaliza su turno y tiene 7 especies diferentes en su
colección (zona de juego).
Información Adicional
Un video ejemplo de cómo jugar se puede consultar en:
https://www.youtube.com/watch?v=9mdsxCs6d40
AED I. Proyecto 2025-2026 4
ORGANIZACIÓN DEL TRABAJO a REALIZAR:
1. El trabajo será colaborativo, es decir, se realizará en grupos de 4/5 estudiantes. La formación de
los equipos corre por cuenta de los/as estudiantes, anotándose a los grupos disponibles en
Moovi.
2. El trabajo consiste en desarrollar un proyecto que implemente el juego del Cubirds siguiendo
las reglas anteriormente expuestas, utilizando el lenguaje de programación Java y el entorno
Visual Studio Code.
3. Cada miembro del grupo debe ser responsable de su trabajo, de comunicarse con otros
miembros del grupo y de conocer todas las partes del proyecto.
ENTREGAS A REALIZAR:
El proyecto a realizar será tutorizado por el/la docente asignado/a, para lo cual se exigirán 3
entregas completamente funcionales. La descripción de las tareas/funciones a realizar en cada una
de las entregas, así como la fecha tope de subida de cada entrega se irá indicando en la plataforma
Moovi. Cada entrega será presentada al docente de forma obligatoria por todos los integrantes del
grupo. La no participación en dicha defensa implica la expulsión del grupo. El/La docente acordará
con cada grupo cuándo se realizará la defensa, siempre en los dos/tres días siguientes a cada fecha
tope de subida. El objetivo de cada presentación es conocer el grado de implicación de cada
componente del grupo en la entrega y realizar las correcciones oportunas que garanticen el
adecuado desarrollo del proyecto hasta conseguir el juego final.
La existencia de copias de entregas supondrá el suspenso de la parte práctica, tanto para el
grupo con código original, como para el grupo con código copiado.
EVALUACIÓN:
La evaluación del proyecto consta de 2 partes: (i) evaluación grupal, correspondiendo con la
última entrega, en forma de tutoría obligatoria y (ii) evaluación individual en forma de examen
práctico delante del ordenador.
1. Evaluación grupal: tutoría obligatoria para todos los miembros del grupo en la que se
mostrará el proyecto finalizado y donde el/la docente pondrá preguntar a cada miembro del
grupo sobre su trabajo o sobre el de sus compañeros/as. Esta evaluación supondrá el 10% de la
calificación final de la asignatura.
2. Evaluación individual: se llevará a cabo en ordenador el 3 de junio de 2026. Supondrá el 20%
de la calificación final de la asignatura.