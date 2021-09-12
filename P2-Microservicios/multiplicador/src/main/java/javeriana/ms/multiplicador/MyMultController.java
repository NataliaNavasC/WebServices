package javeriana.ms.multiplicador;

import javeriana.ms.multiplicador.model.Operacion;
import javeriana.ms.multiplicador.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyMultController {

    @Autowired
    Environment environment;

    //Ej: http://localhost:7777/multiplicacion?a=45&b=38&user=Crijpy
    @GetMapping("/multiplicacion")
    public String mult(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        String response = "Resultado: " + String.valueOf(a*b) + " - Respuesta desde: " + port;
        String fecha = LocalDateTime.now().toString();
        Operacion op = new Operacion("Multiplicacion", fecha, user);
        List<Operacion> operaciones = Utils.loadData();
        if(operaciones==null)
        {
            operaciones = new ArrayList<Operacion>();
        }
        operaciones.add(op);
        Utils.persist(operaciones);
        return response;
    }

    @RequestMapping(
            value = "/operaciones",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<Operacion> getOperaciones() {
        return  Utils.loadData();
    }
}
