package ui;

import bl.Estudiante;
import com.sun.deploy.security.WIExplorerSigningCertStore;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Declaracin e inicializacin de las variables de entrada y salida de datos.
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static Scanner read = new Scanner(System.in);
    static PrintStream out = System.out;
    static final String NOMBRE_ARCHIVO = "Archivo.txt";

    //Mtodo principal de la aplicacin. Muestra el men con las diferentes opciones.
    public static void main(String[] args) throws IOException
    {
        int opcion = -1; //variable que almacena la opcin que selecciona el usuario del men.
        do {
            out.println("1.Crear archivo");
            out.println("2.Guardar");
            out.println("3.Imprimir");
            out.println("4.Crear estudiante");
            out.println("5.Listar estudiante");
            out.println("6.Buscar");
            out.println("7. Salir");
            out.println("Digite la opcion");
            opcion = Integer.parseInt(in.readLine());
            procesarOpcion(opcion);

        }while(opcion !=7);
    }

    /*
     Funcin que se encarga de crear el archivo. Si existe indica que ya existe
    */
    public static void crearArchivo() throws IOException{
        File f=new File(NOMBRE_ARCHIVO);

        if (f.createNewFile())
        {
            System.out.println("Archivo creado exitosamente!");
        } else {
            System.out.println("El archivo ya existe!.");
        }

    }

    /*
      Funcin que se encarga de administrar la opcin seleccionada por el usuario.
      Recibe como parmetro dicha oopcin, y ejecuta las acciones necesarias segn el valor del parmetro.
     */
    public static void procesarOpcion(int pOpcion) throws java.io.IOException
    {
        switch (pOpcion)
        {
            case 1:
                crearArchivo();
                break;
            case 2:
                guardar();
                break;
            case 3:
                imprimir();
                break;

            case 4:
                guardar(crearEstudiante().toStringCSV());
                break;

            case 5:
                imprimirEstudiante(listar());
                break;

            case 6:
                buscarEstudainte();
                break;

            case 7://el usuario selecciona la opcin de salir.
                out.println( "Fin !!");
                break;
            default: // el usuario ingresa un valor que no est dentro de las opciones del men
                out.println("Opcion invlida");
                break;

        }
    }

    private static void buscarEstudainte() {
        System.out.println("Digite identificacion");
        int id = read.nextInt();
        ArrayList<Estudiante> estudiantes = listar();
        for (Estudiante estudiante:estudiantes) {
            if(estudiante.getId() == id){
                System.out.println(estudiante.toString());
            }
        }
    }

    /*
     Mtodo que muestra cmo imprimir el contenido de un archivo de texto, lnea por lnea.
     La clase BufferedReader lee texto de un grupo de caracteres de forma eficiente y brinda un mtodo para leer el texto
     lnea por lnea.
     Variables:
      reader, de tipo FileReader.  Reader es una clase abstracta que se usa para leer texto (Streams).
      buffer, de tipo BufferedReader.
      datos, de tipo String, que almacena cada una de las lneas, que luego se imprimien una por una.
      Este mtodo tiene un try and catc que valida si hay un IOException, e imprime la pila de llamadas, en caso de que
      ocurra un error.
     */
    public static void imprimir()
    {
        try
        {
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            //el bufferedReader extrae cada lnea, y verrifica si el resultado es nulo. Si es nulo es que ya lleg al final del texto.
            //De ahi la condicin del ciclo while.
            while((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                System.out.println(datos);
            }
            reader.close();//se cierra el reader.
        }
        catch(IOException e)
        {
            e.printStackTrace();//se imprime la pila de llamadas para ver dnde est el error.
        }
    }
/*
    Funcin que se encarga de almacenar la informacin en un archivo de texto. Este mtodo actualiza el contenido del archivo.
    La clase Writer es una clase abstracta para escribir grupos de caracteres.  Implementa los siguientes mtodos
    write(int) que imprimi un solo caracter.
    write(char[]) que imprime un arreglo de carateres.
    write(String) que imprime un String.
    close(), que cierra el stream.
    La clase OutputStreamWriter es un puente que convierte streams de caracteres en streams de bytes.
    Los careactes son codificados usando el charset especificado. El charset puede ser el del Sistema Operativo o ser indicado
    (para espaol es UTF-8.)
    FileWriter es una clase para escribir archivos de texto usando el charset del sistema operativo.
    BufferedWriter  escribe texto  en un stream de caracteres de forma eficiente y provee un mtodo para  escribir un separador de lneas (newLine)
    Variables
    stream, de tipo FileOutputStream.
    output, de tipo OutputSteamWriter.
    buffer, de tipo BufferedWriter.
    ESte mtodo usa un try and catch, en el que se maneja la excepcin IOException, imprimiento la pilla de llamadas.
     */

    public static void guardar()
    {
        try {
            FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            String info;
            out.println("Digite el nombre del estudiante");
            info = in.readLine();
            /*buffer.write("\nVilma Picapiedra");
            buffer.newLine();
            buffer.write("Betty Mrmol");
*/
            buffer.write(info);
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardar(String string)
    {
        try {
            FileWriter writer = new FileWriter(NOMBRE_ARCHIVO, true);
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write(string);
            buffer.newLine();
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Estudiante crearEstudiante(){
        System.out.println("Digite nombre");
        String nombre = read.next();

        System.out.println("Digite apellidos");
        String apellidos = read.next();

        System.out.println("Digite edad");
        int edad = read.nextInt();

        System.out.println("Digite identificacion");
        int id = read.nextInt();

        return new Estudiante(nombre,apellidos,edad,id);
    }

    public static ArrayList<Estudiante> listar(){
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        try
        {
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            //el bufferedReader extrae cada lnea, y verrifica si el resultado es nulo. Si es nulo es que ya lleg al final del texto.
            //De ahi la condicin del ciclo while.
            while((datos = buffer.readLine()) != null) // Ciclo que imprime cada una de las lineas, que se almacenan en la variable datos.
            {
                String[] data = datos.split(",");
                Estudiante estudiante = new Estudiante(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                estudiantes.add(estudiante);
            }
            reader.close();//se cierra el reader.
        }
        catch(IOException e)
        {
            e.printStackTrace();//se imprime la pila de llamadas para ver dnde est el error.
        }
        return estudiantes;
    }

    public static void imprimirEstudiante(ArrayList<Estudiante> estudiantes){
        for (Estudiante estudiante:estudiantes) {
            System.out.println(estudiante.toString());
        }
    }
}
