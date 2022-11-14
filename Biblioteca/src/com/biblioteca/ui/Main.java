package com.biblioteca.ui;

import com.biblioteca.tl.Controller;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner read = new Scanner(System.in);
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu(){
        int opc = 0;
        do{
            System.out.println("Digite lo que deseea");
            System.out.println("1- Registrar Textos");
            System.out.println("2- Listar Textos");
            System.out.println("3- Registrar Material de Video");
            System.out.println("4- Listar Material de Video");
            System.out.println("5- Registrar Material de Audio");
            System.out.println("6- Listar Material de Audio");
            System.out.println("7- Registrar Otros");
            System.out.println("8- Listar Otros");
            System.out.println("9- Listar Director de material de video");
            System.out.println("10- Salir");
            opc = read.nextInt();
            procesarOpcion(opc);
        }while (opc != 10);
    }

    private static void procesarOpcion(int opc){
        String mensaje = "";
        switch (opc){
            case 1:
            case 3:
            case 5:
            case 7:
                mensaje = obtenerInformacionMaterial(opc);
                break;

            case 2:
                listarTexto();
                break;

            case 4:
                listarMaterialVideo();
                break;

            case 6:
                listarMaterialAudio();
                break;

            case 8:
                listarOtros();
                break;

            case 9:
                listarDirector();
                break;

            case 10:
                mensaje = "Salir";
                break;

            default:
                mensaje = "Opcion no valida";
                break;
        }
        System.out.println(mensaje);
    }

    private static String obtenerInformacionMaterial(int opc){
        System.out.println("Digite la signatura");
        int signatura = read.nextInt();

        System.out.println("Digite la dia de compra");
        int dia = read.nextInt();

        System.out.println("Digite la mes de compra");
        int mes = read.nextInt();

        System.out.println("Digite la año de compra");
        int year = read.nextInt();

        int restrin;
        do{
            System.out.println("Es restringido");
            System.out.println("1- Si");
            System.out.println("2- No");
            restrin = read.nextInt();
        }while (restrin != 1 && restrin != 2);

        boolean restringido = restrin == 1;

        System.out.println("Digite el tema");
        String tema = read.next();

        return registrarListarMateriales(opc,signatura,dia,mes,year,restringido,tema);
    }

    private static String registrarListarMateriales(int opc, int signatura, int dia, int mes, int year, boolean restringido, String tema){
        String mensaje = "";
        switch (opc){
            case 1:
                mensaje = registrarTexto(signatura,dia,mes,year,restringido,tema);
                break;

            case 3:
                mensaje = registrarMultimedia(opc,signatura,dia,mes,year,restringido,tema);
                break;

            case 5:
                mensaje = registrarMultimedia(opc,signatura,dia,mes,year,restringido,tema);
                break;

            case 7:
                mensaje = registrarOtros(signatura,dia,mes,year,restringido,tema);
                break;
        }
        return mensaje;
    }

    private static String registrarTexto(int signatura, int dia, int mes, int year, boolean restringido, String tema){
        System.out.println("Digite el titulo");
        String titulo = read.next();

        System.out.println("Digite el autor");
        String autor = read.next();

        System.out.println("Digite la dia de compra");
        int diaPublica = read.nextInt();

        System.out.println("Digite la mes de compra");
        int mesPublica = read.nextInt();

        System.out.println("Digite la año de compra");
        int yearPublica = read.nextInt();

        System.out.println("Digite el numero de paginas");
        int numeroPaginas = read.nextInt();

        System.out.println("Digite el idioma");
        String idioma = read.next();

        return controller.registrarTexto(signatura,dia,mes,year,restringido,tema,titulo,autor,diaPublica,mesPublica,yearPublica,numeroPaginas,idioma);
    }

    private static void listarTexto(){
        impirmir(controller.listarTexto());
    }

    private static String registrarMultimedia(int opc, int signatura, int dia, int mes, int year, boolean restringido, String tema){
        int form = 0;
        do {
            System.out.println("Seleccione formato");
            System.out.println("1- Casete");
            System.out.println("2- CD");
            System.out.println("3- DVD");
            form = read.nextInt();
        }while (!(form >= 1 && form <= 3));

        String formato = form == 1 ? "Casete" : form == 2 ? "CD" : "DVD";

        System.out.println("Digite la duracion");
        int duracion = read.nextInt();

        System.out.println("Digite el idioma");
        String idioma = read.next();

        if (opc == 3){
            return registrarMaterialVideo(signatura,dia,mes,year,restringido,tema,formato,duracion,idioma);
        }
        else {
            return registrarMaterialAudio(signatura,dia,mes,year,restringido,tema,formato,duracion,idioma);
        }
    }

    private static String registrarMaterialVideo(int signatura, int dia, int mes, int year, boolean restringido, String tema, String formato, int duracion, String idioma){
        System.out.println("Digite el director");
        String director = read.next();

        return controller.registrarMaterialVideo(signatura,dia,mes,year,restringido,tema,formato,duracion,idioma,director);
    }

    private static void listarMaterialVideo(){
        impirmir(controller.listarMaterialVideo());
    }

    private static String registrarMaterialAudio(int signatura, int dia, int mes, int year, boolean restringido, String tema, String formato, int duracion, String idioma){
        return controller.registrarMaterialAudio(signatura,dia,mes,year,restringido,tema,formato,duracion,idioma);
    }

    private static void listarMaterialAudio(){
        impirmir(controller.listarMaterialAudio());
    }

    private static String registrarOtros(int signatura, int dia, int mes, int year, boolean restringido, String tema){
        System.out.println("Digite la descripcion");
        String descripcion = read.next();

        return controller.registrarOtros(signatura,dia,mes,year,restringido,tema,descripcion);
    }

    private static void listarOtros(){
        impirmir(controller.listarOtros());
    }

    private static void impirmir(List<String> list){
        for (String item:list) {
            System.out.println(item);
        }
    }

    private static void listarDirector(){
        System.out.println("Digite la signatura de material video");
        int signatura = read.nextInt();
        System.out.println((controller.buscarPorId(signatura)));
    }
}
