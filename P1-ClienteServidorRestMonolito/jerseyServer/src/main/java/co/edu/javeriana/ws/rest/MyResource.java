package co.edu.javeriana.ws.rest;

import co.edu.javeriana.ws.rest.controllers.Controller;
import co.edu.javeriana.ws.rest.model.Paseo;
import co.edu.javeriana.ws.rest.utils.Utils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    private Controller controller = new Controller();


    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    // ------ CreatePaseo ------
    @POST
    @Path("paseos")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Paseo createPaseo(Paseo paseo){
        Paseo nuevo = this.controller.createPaseo(paseo);
        if(nuevo!=null)
        {
            System.out.println("Paseo creado satisfactoriamente");
        }
        return paseo;
    }

    // ------ DeletePaseo ------
    @DELETE
    @Path("paseos/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deletePaseo(@PathParam("id") int id){
        String deletedMessage = "";
        boolean deleted = controller.deletePaseo(id);
        if(deleted) {
            deletedMessage = "El Paseo con ID "+id+" fue eliminado satisfactoriamente";
        }
        return deletedMessage;
    }

    // ------ UpdatePaseo ------
    @PUT
    @Path("paseos")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Paseo updatePaseo(Paseo paseo) {
        Paseo paseoUpdated = controller.updatePaseo(paseo);
        if (paseoUpdated != null) {
            System.out.println("Paseo actualizado satisfactoriamente");
        }
        return paseoUpdated;
    }

        // ------ FindAll ------
    @GET
    @Path("paseos")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<Paseo> findAll(){
        return Utils.loadJsonFile();
    }




}
