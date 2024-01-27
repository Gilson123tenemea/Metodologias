
package proyectometodologias;


        import java.util.Random;
import java.util.Scanner;

class Jugador {
    String nombre;
    int puntaje;

    Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }
}

class Juego {
    private static final int NUM_ROUNDS = 5;
    private static final int JUGADOR_VS_JUGADOR = 1;
    private static final int JUGADOR_VS_MAQUINA = 2;
    private static final int MOSTRAR_REGLAS = 3;
    private static final int SALIR = 4;

    private Jugador jugador1;
    private Jugador jugador2;
    private Random random;

    Juego() {
        this.random = new Random();
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }

    private void iniciar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al juego");

        System.out.print("Ingrese el nombre del Jugador 1: ");
        jugador1 = new Jugador(scanner.nextLine());

        System.out.print("Ingrese el nombre del Jugador 2: ");
        jugador2 = new Jugador(scanner.nextLine());

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            switch (opcion) {
                case JUGADOR_VS_JUGADOR:
                    jugarModoJugadorVsJugador(scanner);
                    break;
                case JUGADOR_VS_MAQUINA:
                    jugarModoJugadorVsMaquina(scanner);
                    break;
                case MOSTRAR_REGLAS:
                    mostrarReglas();
                    break;
                case SALIR:
                    System.out.println("¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != SALIR);

        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Jugador1 Vs Jugador2");
        System.out.println("2. Jugador Vs Maquina");
        System.out.println("3. Mostrar Reglas");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private void mostrarReglas() {
        System.out.println("Reglas del juego:");
        // Aquí puedes imprimir las reglas del juego
        System.out.println("- Conejo salta muro.");
        System.out.println("- Muro rebota bala de escopeta.");
        // ... (agrega todas las reglas según tus especificaciones)
        System.out.println("- Humano controla escopeta.");
    }

    private void jugarModoJugadorVsJugador(Scanner scanner) {
        System.out.println("¡Modo Jugador Vs Jugador!");

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("Ronda " + round + ":");

            // Lógica del juego (aquí puedes expandir según las reglas)
            String accionJugador1 = seleccionarAccion(scanner, jugador1);
            String accionJugador2 = seleccionarAccion(scanner, jugador2);

            determinarGanador(round, accionJugador1, accionJugador2);

            // Imprime los puntajes actuales
            System.out.println("Puntajes actuales: " + jugador1.nombre + " - " + jugador1.puntaje + ", " +
                    jugador2.nombre + " - " + jugador2.puntaje);
        }

        // Determina al ganador final
        if (jugador1.puntaje > jugador2.puntaje) {
            System.out.println(jugador1.nombre + " es el ganador del juego!");
        } else if (jugador2.puntaje > jugador1.puntaje) {
            System.out.println(jugador2.nombre + " es el ganador del juego!");
        } else {
            System.out.println("¡Empate! Jueguen de nuevo.");
        }
    }

    private void determinarGanador(int round, String accionJugador1, String accionJugador2) {
        // Implementa la lógica de las acciones y determina el ganador del round
        // ...

        // Ejemplo simple: asigna puntos aleatorios para demostración
        int puntajeJugador1 = random.nextInt(2);
        int puntajeJugador2 = random.nextInt(2);

        jugador1.puntaje += puntajeJugador1;
        jugador2.puntaje += puntajeJugador2;

        // Imprime el resultado del round
        System.out.println("Resultado de la ronda: " + jugador1.nombre + " = " + puntajeJugador1 + ", " +
                jugador2.nombre + " = " + puntajeJugador2);
    }

    private String seleccionarAccion(Scanner scanner, Jugador jugador) {
        System.out.print(jugador.nombre + ", elige una acción (conejo, muro, escopeta, zanahoria, humano): ");
        return scanner.next().toLowerCase();
    }

    private void jugarModoJugadorVsMaquina(Scanner scanner) {
        System.out.println("¡Modo Jugador Vs Maquina!");

        // Lógica del juego contra la máquina (puedes implementar la lógica de la máquina aquí)
        // ...

        // Imprime el resultado final
        // ...
    }
}
    
    

