package com.bancolavadores.ui;

import com.bancolavadores.tl.Controller;

import java.util.Scanner;

public class Main {
    private static Scanner read = new Scanner(System.in);
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        int opc;
        do{
            System.out.println("1- Crear Cliente");
            System.out.println("2- Listar Cliente");
            System.out.println("3- Registrar cuenta a cliente");
            System.out.println("4- Listar Cuenta cliente de cliente");
            System.out.println("5- Registar deposito");
            System.out.println("6- Registar retiro");
            System.out.println("7- Listar movimientos de cuenta");
            System.out.println("8- Salir");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 8);
    }

    public static void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                registroCliente();
                break;

            case 2:
                listarCliente();
                break;

            case 3:
                registroCuenta();
                break;

            case 4:
                listarCuenta();
                break;

            case 5:
                registroDeposito();
                break;

            case 6:
                registroRetiro();
                break;

            case 7:
                listarMovimientos();
                break;

            case 8:
                System.out.println("Salir");
                break;

                default:
                    System.out.println("Gracias");
                    break;
        }
    }

    private static void listarMovimientos() {
        int idClient = idCliente();

        int numCuenta = idCuenta();

        imprimirArray(controller.listarMovimientos(idClient,numCuenta));
    }

    private static void registroRetiro() {
        int idClient = idCliente();

        int numCuenta = idCuenta();

        System.out.println("Digite descripcion");
        String descripcion = read.next();

        System.out.println("Digite el monto");
        double monto = read.nextDouble();

        System.out.println("Digite la dia de compra");
        int dia = read.nextInt();

        System.out.println("Digite la mes de compra");
        int mes = read.nextInt();

        System.out.println("Digite la a;o de compra");
        int year = read.nextInt();

        System.out.println(controller.registroRetiro(idClient,numCuenta,descripcion,monto,dia,mes,year));
    }

    private static void registroDeposito() {
        int idClient = idCliente();

        int numCuenta = idCuenta();

        System.out.println("Digite descripcion");
        String descripcion = read.next();

        System.out.println("Digite el monto");
        double monto = read.nextDouble();

        System.out.println("Digite la dia de compra");
        int dia = read.nextInt();

        System.out.println("Digite la mes de compra");
        int mes = read.nextInt();

        System.out.println("Digite la a;o de compra");
        int year = read.nextInt();

        System.out.println(controller.registroDeposito(idClient,numCuenta,descripcion,monto,dia,mes,year));
    }

    private static void listarCuenta() {
        int idClient = idCliente();
        imprimirArray(controller.listarCuenta(idClient));

    }

    private static void registroCuenta() {

        System.out.println("Digite tipo cuenta");
        System.out.println("1- Corriente");
        System.out.println("2- Ahorro");
        System.out.println("3- Ahorro programado");
        int type =  read.nextInt();
        int idClient = idCliente();

        int numCuenta = idCuenta();

        System.out.println("Digite saldo");
        double saldo =  read.nextDouble();
        if(type == 3){
            int numCuentaAso = idCuenta();
            System.out.println(controller.registroCuentaProgramdas(idClient,numCuenta,saldo,type,numCuentaAso));
        }
        System.out.println(controller.registroCuenta(idClient,numCuenta,saldo,type));


    }

    private static int idCliente(){
        System.out.println("Digite id cliente");
        return read.nextInt();
    }

    private static int idCuenta(){
        System.out.println("Digite numero cuenta");
        return read.nextInt();
    }

    private static void registroCliente() {

        int id = idCliente();

        System.out.println("Digite nombre");
        String nombre = read.next();

        System.out.println("Digite direccion");
        String direccion = read.next();

        controller.registroCliente(id,nombre,direccion);
    }

    private static void listarCliente() {

        imprimirArray(controller.listarCliente());
    }

    public static void imprimirArray(String arr[]){
        for (String array:arr) {
            System.out.println(array);
        }
    }
}
