/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectometodologias;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class Menu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opciones1;
        Scanner menu = new Scanner(System.in);
        do {
            System.out.println("--------Bienvenido al Juego--------");
            System.out.println("1| Numero de jugadores");
            System.out.println("2| Reglas del juego");
            System.out.println("3| SALIR");
            System.out.println("--------Escoja una opcion--------");
            opciones1=menu.nextInt();
           
            
            switch (opciones1) {
                case 1://Modo de juego
                    int opciones2;
                    do {
                        System.out.println("--------Modos de juego---------");
                        System.out.println("1| Jugador vs Maquina");
                        System.out.println("2| Jugador 1 vs Jugador 2");
                        System.out.println("3| Salir");
                        System.out.println("--------¿Como desea Jugar?--------");
                        opciones2=menu.nextInt();
                    
                        switch (opciones2) {
                           
                            case 1: //Jugador vs Maquina
                            break;
                            case 2: //Jugador 1 vs Jugador 2
                            break;
                            
                        }
                        }while(opciones2 <3);
                          break;
                          case 2://Reglas del juego
                              
                          break;
                           
                          
            }
                         }while(opciones1 <3);
                             System.out.println("Fin del programa");
    }
    
}
