package javeriana.ms.restador.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javeriana.ms.restador.model.Operacion;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    static final String filename = "RestaOperaciones.json";

    public static void persist(List<Operacion> operaciones){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter(filename);
            gson.toJson(operaciones,writer);
            writer.close();
        }
        catch (Exception e){
            System.err.println("No pudo abrir el archivo " + filename);
            e.printStackTrace();
        }
    }

    public static List<Operacion> loadData(){
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader(filename);
            List<Operacion> operaciones = new ArrayList<>(Arrays.asList(gson.fromJson(reader,Operacion[].class)));
            reader.close();
            return operaciones;
        }
        catch (Exception e){
            System.err.println("No pudo abrir el archivo " + filename);
            return null;
        }
    }

}

