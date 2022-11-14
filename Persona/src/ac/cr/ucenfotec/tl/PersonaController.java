package ac.cr.ucenfotec.tl;

import ac.cr.ucenfotec.bl.Persona;
import ac.cr.ucenfotec.bl.PersonaBL;

import java.util.ArrayList;

public class PersonaController {

    private PersonaBL logica = new PersonaBL();

    public void insertarPersona(String cedula, String nombre, String apellido){
        Persona persona = new Persona(cedula,nombre,apellido);
        logica.insertar(persona);
    }

    public void modificarPersona(String cedula, String nombre, String apellido){
        Persona persona = new Persona(cedula,nombre,apellido);
        logica.modificar(persona);
    }

    public void eliminarPersona(String cedula){
        logica.eliminar(cedula);
    }

    public String[] ListarPersonas(){
        ArrayList<Persona> lista = logica.listar();
        String[] listaDatos = new String[lista.size()];

        for(int x =0; x < listaDatos.length ;x++){
            listaDatos[x] = lista.get(x).toString();
        }
        return listaDatos;
    }
}
