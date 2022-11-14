package com.personas.ui;

import java.util.Scanner;

public class Main {
    private static Scanner read = new Scanner(System.in);
    public static void main(String[] args) {
        int opc = 0;
        do{
            mostrarMenu();
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 7);
    }

    private static void procesarOpcion(int opc) {
        switch (opc){
            case 1:

                break;

            case 2:

                break;

            case 3:

                break;

            case 4:

                break;

            case 5:

                break;

            case 6:

                break;

            case 7:

                break;

            default:

                break;
        }
    }

    private static void mostrarMenu() {
        System.out.println("1.Registrar Estudiante \n" +
                "2.Listar Estudiantes \n" +
                "3.Registrar Profesor \n" +
                "4.Listar Profesores  \n" +
                "5.Registrar Administrativo \n" +
                "6.Listar Administrativos \n" +
                "7.Salir \n");
    }
}
