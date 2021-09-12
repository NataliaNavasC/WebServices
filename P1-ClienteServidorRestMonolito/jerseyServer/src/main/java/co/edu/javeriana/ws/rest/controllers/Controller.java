package co.edu.javeriana.ws.rest.controllers;

import co.edu.javeriana.ws.rest.model.Paseo;
import co.edu.javeriana.ws.rest.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Controller {
    private int IDsequence;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();;

    public Controller() {
        this.IDsequence = getMaxID()+1;
    }

    public Paseo createPaseo(Paseo nuevoPaseo){
        try {
            nuevoPaseo.setID(this.IDsequence);
            this.IDsequence++;
            List<Paseo> paseos = Utils.loadJsonFile();
            paseos.add(nuevoPaseo);
            Utils.updateJsonFile(paseos);
            return nuevoPaseo;
        }
        catch (Exception e){
            System.err.println("El paseo no pudo ser creado correctamente");
            e.printStackTrace();
            return  null;
        }
    }

    public boolean deletePaseo(int id){
        boolean deleted = false;
        List<Paseo> paseos = Utils.loadJsonFile();
        Paseo p = findPaseo(id, paseos);
        if(p != null){
            paseos.remove(p);
            Utils.updateJsonFile(paseos);
            deleted = true;
        }
        else
        {
            System.err.println("El paso con id " + id + "no existe");
        }
        return deleted;
    }

    public Paseo updatePaseo(Paseo paseo){
        List<Paseo> paseos = Utils.loadJsonFile();
        Paseo p = findPaseo(paseo.getID(), paseos);
        if(p != null){
            //p.setNombre(paseo.getNombre());
            p.setLugarSalida(paseo.getLugarSalida());
            p.setLugarLlegada(paseo.getLugarLlegada());
            //p.setFecha(paseo.getFecha());
            Utils.updateJsonFile(paseos);
        }
        else
        {
            System.err.println("El paso con id " + paseo.getID() + "no existe");
        }
        return p;
    }


    public Paseo findPaseo(int id, List<Paseo> paseos){
        for (Paseo p: paseos) {
            if(p.getID() == id){
                return  p;
            }
        }
        return null;
    }

    public int getMaxID(){
        List<Paseo> paseos = Utils.loadJsonFile();
        int maxID = -1;
        for (Paseo p:paseos) {
            if(p.getID()>maxID)
            {
                maxID = p.getID();
            }
        }
        return maxID;
    }


}
