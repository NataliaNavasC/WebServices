package co.edu.javeriana.ws.rest.utils;

import co.edu.javeriana.ws.rest.model.Paseo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static void updateJsonFile(List<Paseo> paseos) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("Paseos.json");
            writer.write(gson.toJson(paseos));
            writer.close();
        } catch (Exception e) {
            System.err.println("No pudo abrir el archivo 'Paseos.json'");
            e.printStackTrace();
        }
    }

    public static List<Paseo> loadJsonFile() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileReader reader = new FileReader("Paseos.json");
            List<Paseo> paseos = new ArrayList<>(Arrays.asList(gson.fromJson(reader, Paseo[].class)));
            reader.close();
            return paseos;
        } catch (Exception e) {
            System.err.println("No pudo abrir el archivo 'Paseos.json'");
            return null;
        }
    }

}
