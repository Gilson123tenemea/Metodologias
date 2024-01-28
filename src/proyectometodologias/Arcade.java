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

        System.out.println("+----------Bienvenido al juego-------------+");
        System.out.println("\033[34m+________(ERES EQUIPO AZUL)________+\033[0m");
        System.out.print("| \033[34mIngrese el nombre del Jugador l\n"
                + "| Nombre:\033[0m ");
        jugador1 = new Jugador(scanner.nextLine());
        System.out.println("\033[34m+----------------------------------+\033[0m");
        System.out.println("\033[31m+________(ERES EQUIPO ROJO)________+\033[0m");
        System.out.print("| \033[31mIngrese el nombre del Jugador 2\n"
                + "| Nombre:\033[0m ");
        jugador2 = new Jugador(scanner.nextLine());
        System.out.println("\033[31m+-----------------------------+\033[0m");

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
        System.out.println("\033[1m\n\033[1m+\033[0m\033[1m-----------Menú------------\033[1m+\033[0m");
        System.out.println("\033[1m|\033[0m 1. Jugador1 Vs Jugador2   \033[1m|\033[0m");
        System.out.println("\033[1m|\033[0m 2. Jugador Vs Maquina     \033[1m|\033[0m");
        System.out.println("\033[1m|\033[0m 3. Mostrar Reglas         \033[1m|\033[0m");
        System.out.println("\033[1m|\033[0m 4. Salir                  \033[1m|\033[0m");
        System.out.println("\033[1m+\033[0m---------------------------\033[1m+\033[0m");

        System.out.print("Elige una opción: ");
    }

    private void mostrarReglas() {
        System.out.println("\n------------Reglas del juego:----------");
        System.out.println("- Conejo salta muro.");
        System.out.println("- Muro rebota bala de escopeta.");
        System.out.println("- Humano controla escopeta.");
    }

    private void jugarModoJugadorVsJugador(Scanner scanner) {
        System.out.println("\n--------¡Modo Jugador Vs Jugador!-----------");

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("\nRonda " + round + ":");

            String accionJugador1 = seleccionarAccion(scanner, jugador1);
            String accionJugador2 = seleccionarAccion(scanner, jugador2);

            determinarGanador(round, accionJugador1, accionJugador2);

            System.out.println("Puntajes actuales: \033[34m" + jugador1.nombre + " - " + jugador1.puntaje + "\033[0m, "
                    + "\033[32m" + jugador2.nombre + " - " + jugador2.puntaje + "\033[0m");
        }

        // Determina al ganador final
        if (jugador1.puntaje > jugador2.puntaje) {
            System.out.println("\n\033[34m" + jugador1.nombre + " es el ganador del juego!\033[0m");
        } else if (jugador2.puntaje > jugador1.puntaje) {
            System.out.println("\n\033[32m" + jugador2.nombre + " es el ganador del juego!\033[0m");
        } else {
            System.out.println("\n¡Empate! Jueguen de nuevo.");
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
        System.out.println("Resultado de la ronda: \033[34m" + jugador1.nombre + " = " + puntajeJugador1 + "\033[0m, "
                + "\033[32m" + jugador2.nombre + " = " + puntajeJugador2 + "\033[0m");
    }

    private String seleccionarAccion(Scanner scanner, Jugador jugador) {
        System.out.print("\033[34m" + jugador.nombre + "\033[0m, elige una acción (conejo, muro, escopeta, zanahoria, humano): ");
        return scanner.next().toLowerCase();
    }

    private void jugarModoJugadorVsMaquina(Scanner scanner) {
        System.out.println("\n¡Modo Jugador Vs Maquina!");

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("\nRonda " + round + ":");

            String accionJugador = seleccionarAccion(scanner, jugador1);
            String accionMaquina = seleccionarAccionMaquina();

            determinarGanador(round, accionJugador, accionMaquina);

            System.out.println("Puntajes actuales: \033[34m" + jugador1.nombre + " - " + jugador1.puntaje + "\033[0m, "
                    + "\033[32m" + "Máquina - " + jugador2.puntaje + "\033[0m");
        }

        // Determina al ganador final
        if (jugador1.puntaje > jugador2.puntaje) {
            System.out.println("\n\033[34m" + jugador1.nombre + " es el ganador del juego!\033[0m");
        } else if (jugador2.puntaje > jugador1.puntaje) {
            System.out.println("\n\033[32m" + "La Máquina es el ganador del juego!\033[0m");
        } else {
            System.out.println("\n¡Empate! Jueguen de nuevo.");
        }
    }

    private String seleccionarAccionMaquina() {
        // La máquina elige una acción de manera aleatoria
        String[] acciones = {"\n1.) conejo", "\n2.)muro", "\n3.)escopeta", "\n4.)zanahoria", "\n5.)humano"};
        int indiceAccion = random.nextInt(acciones.length);
        return acciones[indiceAccion];
    }
}

    

