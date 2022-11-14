package ac.cr.ucenfotec.dl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Conector {

    private static AccesoBD conectorBD = null;
    private static final String NOMBRE_ARCHIVO = "Configuracion.txt";
    private static String urlMysql;
    private static String driver;
    private static String user;
    private static String password;


    public static  AccesoBD getConnector() throws Exception{
        if(conectorBD == null) {
            leerArchivoConexion();
            conectorBD = new AccesoBD(driver,urlMysql,user,password);
        }
        return conectorBD;
    }

    private static void leerArchivoConexion(){
        try
        {
            FileReader reader = new FileReader(NOMBRE_ARCHIVO);
            BufferedReader buffer = new BufferedReader(reader);
            String datos;
            String[] data;
            int i = 0;
            while((datos = buffer.readLine()) != null)
            {
                data = datos.split(";");
                driver = data[0];
                urlMysql = data[1];
                user = data[2];
                password = data[3];
            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
