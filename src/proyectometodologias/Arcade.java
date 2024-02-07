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
    Scanner leerNum = new Scanner(System.in);
    Scanner leerCad = new Scanner(System.in);

    int opcion;
    do {
        mostrarMenu();
        // Verificar si el siguiente token es un entero
        while (!leerNum.hasNextInt()) {
            System.out.println("Error: Debes ingresar un número.");
            System.out.print("Intenta nuevamente: ");
            leerNum.next(); // Limpiar el buffer del scanner
        }
        opcion = leerNum.nextInt();

        switch (opcion) {
            case JUGADOR_VS_JUGADOR:
                jugarModoJugadorVsJugador(leerCad, leerCad);
                break;
            case JUGADOR_VS_MAQUINA:
                jugarModoJugadorVsMaquina(leerCad);
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
        leerCad.nextLine();
    } while (opcion != SALIR);
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
        System.out.println("- Se abrira el menu en donde la 1 opcion van a aparecer los modos de juego ");
        System.out.println("- Si aplasta la 1 opcion se debe agregar los nombres a cada uno de los jugadores, en maquina ya esta definido ");
        System.out.println("- Aparecera un submenu en donde los modos de juego son Jugador1 vs Jugador2 y Jugador vs Maquina");
        System.out.println("- Si escoje la opcion 1 jugaran entre 2 personas con los nombres asignados que an escrito");
        System.out.println("- Si escoje la opcion 2 jugara contra la maquina en donde tendra asignado el nombre del jugador1");
        System.out.println("- El jugador 1 va empezar la partida");
        System.out.println("- El juego tendra los siguientes objetos:conejo, muro, escopeta, zanahoria, humano en dode tendra el siguiente mecanismo");
        System.out.println("- Conejo salta muro");
        System.out.println("- Conejo come zanahoria");
        System.out.println("- Muro Aplasta zanahoria");
        System.out.println("- Muro rebota bala de escopeta");
        System.out.println("- Muro aplasta humano");
        System.out.println("- Humano controla escopeta");
        System.out.println("- Humano come conejo");
        System.out.println("- Humano come zanahoria");
        System.out.println("- Escopeta dispara conejo");
        System.out.println("- Zanahoria tapa escopeta");
    }

    private void determinarGanador(int round, String accionJugador1, String accionJugador2) {
        System.out.println(jugador1.nombre + " elige: " + accionJugador1);
        System.out.println(jugador2.nombre + " elige: " + accionJugador2);

        // Lógica de determinación del ganador (personaliza según tus reglas)
        if (accionJugador1.equals(accionJugador2)) {
            System.out.println("Empate en esta ronda.");
        } else if ((accionJugador1.equals("conejo") && accionJugador2.equals("muro"))
                || (accionJugador1.equals("conejo") && accionJugador2.equals("zanahoria"))
                || (accionJugador1.equals("muro") && accionJugador2.equals("escopeta"))
                || (accionJugador1.equals("muro") && accionJugador2.equals("zanahoria"))
                || (accionJugador1.equals("muro") && accionJugador2.equals("humano"))
                || (accionJugador1.equals("humano") && accionJugador2.equals("escopeta"))
                || (accionJugador1.equals("humano") && accionJugador2.equals("conejo"))
                || (accionJugador1.equals("humano") && accionJugador2.equals("zanahoria"))
                || (accionJugador1.equals("escopeta") && accionJugador2.equals("conejo"))
                || (accionJugador1.equals("zanahoria") && accionJugador2.equals("escopeta"))) {
            System.out.println(jugador1.nombre + " gana la ronda.");
            jugador1.puntaje++;
        } else {
            System.out.println(jugador2.nombre + " gana la ronda.");
            jugador2.puntaje++;
        }
    }

    private void jugarModoJugadorVsJugador(Scanner leerCad, Scanner LeerNum) {
        System.out.println("\n--------¡Modo Jugador Vs Jugador!-----------");
        System.out.println("\033[34m+________(ERES EQUIPO AZUL)________+\033[0m");
        System.out.print("| \033[34mIngrese el nombre del Jugador l\n"
                + "| Nombre:\033[0m ");
        jugador1 = new Jugador(leerCad.nextLine());
        System.out.println("\033[34m+----------------------------------+\033[0m");
        System.out.println("\033[31m+________(ERES EQUIPO ROJO)________+\033[0m");
        System.out.print("| \033[31mIngrese el nombre del Jugador 2\n"
                + "| Nombre:\033[0m ");
        jugador2 = new Jugador(leerCad.nextLine());
        System.out.println("\033[31m+-----------------------------+\033[0m");

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("\nRonda " + round + ":");

            String accionJugador1 = seleccionarAccion(leerCad, jugador1);
            String accionJugador2 = seleccionarAccion(leerCad, jugador2);

            determinarGanador(round, accionJugador1, accionJugador2);

            System.out.println("Puntajes actuales: \033[34m" + jugador1.nombre + ":--->" + jugador1.puntaje + "\033[0m, "
                    + "\033[31m" + jugador2.nombre + ":--->" + jugador2.puntaje + "\033[31m");
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

    private String seleccionarAccion(Scanner leerNum, Jugador jugador) {
    System.out.print("\033[34m" + jugador.nombre + "\033[0m, elige una acción (1 - conejo, 2 - muro, 3 - escopeta, 4 - zanahoria, 5 - humano): ");

    // Verificar si el siguiente token es un entero
    while (!leerNum.hasNextInt()) {
        System.out.println("Error: Debes ingresar un número.");
        System.out.print("Intenta nuevamente: ");
        leerNum.next(); // Limpiar el buffer del scanner
    }

    int opcion = leerNum.nextInt();

    // Validar que la opción esté en el rango correcto
    while (opcion < 1 || opcion > 5) {
        System.out.println("Error: Debes ingresar un número entre 1 y 5.");
        System.out.print("Intenta nuevamente: ");

        // Verificar si el siguiente token es un entero
        while (!leerNum.hasNextInt()) {
            System.out.println("Error: Debes ingresar un número.");
            System.out.print("Intenta nuevamente: ");
            leerNum.next(); // Limpiar el buffer del scanner
        }

        opcion = leerNum.nextInt();
    }

    switch (opcion) {
        case 1:
            return "conejo";
        case 2:
            return "muro";
        case 3:
            return "escopeta";
        case 4:
            return "zanahoria";
        case 5:
            return "humano";
        default:
            // Esto nunca debería ocurrir, pero en caso de algún error, regresamos "conejo" por defecto
            System.out.println("Error: Opción inválida. Seleccionando 'conejo' por defecto.");
            return "conejo";
    }
}

    private void jugarModoJugadorVsMaquina(Scanner LeerCad) {
        System.out.println("\n¡Modo Jugador Vs Maquina!");
        System.out.println("\n--------¡Modo Jugador Vs Jugador!-----------");
        System.out.println("\033[34m+________(ERES EQUIPO AZUL)________+\033[0m");
        System.out.print("| \033[34mIngrese el nombre del Jugador l\n"
                + "| Nombre:\033[0m ");
        jugador1 = new Jugador(LeerCad.nextLine());
        // Inicializa el jugador ficticio "Máquina"
        jugador2 = new Jugador("Máquina");

        for (int round = 1; round <= NUM_ROUNDS; round++) {
            System.out.println("\nRonda " + round + ":");

            String accionJugador = seleccionarAccion(LeerCad, jugador1);
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
        int opcion = random.nextInt(5) + 1;

        switch (opcion) {
            case 1:
                System.out.println("Máquina elige: conejo");
                return "conejo";
            case 2:
                System.out.println("Máquina elige: muro");
                return "muro";
            case 3:
                System.out.println("Máquina elige: escopeta");
                return "escopeta";
            case 4:
                System.out.println("Máquina elige: zanahoria");
                return "zanahoria";
            case 5:
                System.out.println("Máquina elige: humano");
                return "humano";
            default:
                System.out.println("Error en la selección de la máquina. Se elige conejo por defecto.");
                return "conejo";
        }

    }
}
