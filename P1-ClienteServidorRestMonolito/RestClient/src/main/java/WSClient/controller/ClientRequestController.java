package WSClient.controller;

import WSClient.model.Paseo;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class ClientRequestController {

    private static final String MY_SERVER_URL = "http://localhost:8080/myapp/myresource";
    private static Client client = ClientBuilder.newClient();
    private static WebTarget webTarget = client.target(MY_SERVER_URL);
    private static Scanner scanner = new Scanner(System.in);

    public void findAll()
    {
        WebTarget helloWebTarget= webTarget.path("paseos");
        Invocation.Builder invocationBuilder= helloWebTarget.request(MediaType.APPLICATION_JSON);
        Response response= invocationBuilder.get();
        System.out.println("RESPONSE FROM SERVER code: "+response.getStatus());
        System.out.println("Media type: "+response.getMediaType().toString());
        List<Paseo> paseos= response.readEntity(new GenericType<List<Paseo>>() {});
        System.out.println("\n-- Paseos --");
        for (Paseo p: paseos) {
            printPaseo(p);
        }
    }

    public void deletePaseo()
    {
        System.out.print("Ingrese id: ");
        int id = scanner.nextInt();
        System.out.println();

        WebTarget helloWebTarget= webTarget.path("paseos/"+id);
        Invocation.Builder invocationBuilder= helloWebTarget.request(MediaType.TEXT_PLAIN);
        Response response= invocationBuilder.delete();
        System.out.println("RESPONSE FROM SERVER code: "+response.getStatus());
        System.out.println("Media type: "+response.getMediaType().toString());
        String respuestaTexto= response.readEntity(String.class);
        System.out.println("Content: "+respuestaTexto);
    }

    public void updatePaseo()
    {
        System.out.print("Ingrese id: ");
        int id = scanner.nextInt();
        try{
            Paseo paseo = new Paseo();
            paseo.setID(id);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Ingrese nuevo origen: ");
            paseo.setLugarSalida(input.readLine());
            System.out.print("Ingrese nuevo destino: ");
            paseo.setLugarLlegada(input.readLine());
            System.out.println();

            WebTarget helloWebTarget= webTarget.path("paseos");
            Invocation.Builder invocationBuilder= helloWebTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.json(paseo));
            System.out.println("RESPONSE FROM SERVER code: "+response.getStatus());
            System.out.println("Media type: "+response.getMediaType().toString());
            System.out.println("\n-- Paseo actualizado --");
            printPaseo(response.readEntity(Paseo.class));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createPaseo()
    {
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            Paseo paseo = new Paseo();
            paseo.setID(0);
            System.out.print("Ingrese el nombre del paseo: ");
            paseo.setNombre(input.readLine());
            System.out.print("Ingrese el origen: ");
            paseo.setLugarSalida(input.readLine());
            System.out.print("Ingrese el destino: ");
            paseo.setLugarLlegada(input.readLine());
            System.out.print("Ingrese la fecha: ");
            paseo.setFecha(input.readLine());
            System.out.println();

            WebTarget helloWebTarget= webTarget.path("paseos");
            Invocation.Builder invocationBuilder= helloWebTarget.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.post(Entity.json(paseo));
            System.out.println("RESPONSE FROM SERVER code: "+response.getStatus());
            System.out.println("Media type: "+response.getMediaType().toString());
            System.out.println("\n-- Paseo creado --");
            printPaseo(response.readEntity(Paseo.class));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printPaseo(Paseo p){
        System.out.println(
                "\nID: " + p.getID() +
                "\nNombre: " + p.getNombre() +
                "\nOrigen: " + p.getLugarSalida() +
                "\nDestino: " + p.getLugarLlegada() +
                "\nFecha: " + p.getFecha()
        );
        System.out.print("=============================");
    }
}
