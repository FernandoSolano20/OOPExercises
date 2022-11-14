package com.carrear.ui;

import com.carrear.tl.Controller;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static Controller controller = new Controller();
    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        int opc = 0;
        do {
            System.out.println("1- Registar curso");
            System.out.println("2- Listar cursos");
            System.out.println("3- Registar carrera");
            System.out.println("4- Listar carrera");
            System.out.println("5- Asosiar curso a carrera");
            System.out.println("6- Salir");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 6);
    }

    private static void procesarOpcion(int opc) {
        switch (opc){
            case 1:
                registrarCurso();
                break;

            case 2:
                listarCurso();
                break;

            case 3:
                registrarCarrera();
                break;

            case 4:
                listarCarrera();
                break;

            case 5:
                asosiar();
                break;

            case 6:

                break;

            default:
                System.out.println("No valido");
                break;

        }
    }

    private static void registrarCurso() {
        try {
            System.out.println("Digite el codigo");
            int codigo = read.nextInt();

            System.out.println("Nombre");
            String nombre = read.next();

            System.out.println("Creditos");
            int creditos = read.nextInt();

            System.out.println(controller.registrarCurso(codigo,nombre,creditos));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarCurso() {
        try {
            imprimirArrayList(controller.listarCursos());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void registrarCarrera()  {
        try {
            System.out.println("Digite el codigo");
            int codigo = read.nextInt();

            System.out.println("Nombre");
            String nombre = read.next();

            System.out.println(controller.registrarCarrera(codigo,nombre));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarCarrera() {
        try {
            imprimirArrayList(controller.listarCarreras());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void asosiar() {
        System.out.println("Digite el codigo Carrera");
        int codigoCarrera = read.nextInt();

        System.out.println("Digite el codigo Curso");
        int codigoCurso = read.nextInt();
        try {
            System.out.println(controller.agregarCursoCarrera(codigoCarrera,codigoCurso));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void imprimirArrayList(List<String> list) {
        for (String item:list) {
            System.out.println(item);
        }
    }
}
