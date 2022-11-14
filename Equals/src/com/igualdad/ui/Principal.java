package com.igualdad.ui;

import com.igualdad.bl.Medico;
import com.igualdad.bl.Paciente;
import com.igualdad.bl.Persona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    static Scanner read = new Scanner(System.in);
    private static ArrayList<Persona> personas = new ArrayList<>();
    public static void main(String[] args) {
        Medico medico1 = new Medico(123, "Fer", "Solano", 145, "Infecciologo");
        Medico medico2 = new Medico(1, "Fer", "Solano", 145, "Infecciologo");

        objIgual(medico1,medico2);

        medico1 = new Medico(123, "Fer", "Solano", 145, "Infecciologo");
        medico2 = new Medico(123, "Fer", "Solano", 2, "Infecciologo");

        objIgual(medico1,medico2);

        medico1 = new Medico(123, "Fer", "Solano", 145, "Infecciologo");
        medico2 = new Medico(2, "Fer", "Solano", 2, "Infecciologo");

        objIgual(medico1,medico2);


        Paciente paciente1 = new Paciente(123, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");
        Paciente paciente2 = new Paciente(2, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");

        objIgual(paciente1,paciente2);

        paciente1 = new Paciente(123, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");
        paciente2 = new Paciente(122, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");

        objIgual(paciente1,paciente2);

        paciente1 = new Paciente(123, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");
        paciente2 = new Paciente(123, "Fer", "Solano", LocalDate.of(2019,2,10), "Fer");

        objIgual(paciente1,paciente2);

    }

    public static void objIgual(Persona p1, Persona p2){
        if (p1.equals(p2)){
            System.out.println("Si");
        }
        else {
            System.out.println("No");
        }
    }
}
