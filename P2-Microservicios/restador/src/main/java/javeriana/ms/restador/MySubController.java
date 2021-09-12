package javeriana.ms.restador;

import javeriana.ms.restador.model.Operacion;
import javeriana.ms.restador.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MySubController {
    @Autowired
    Environment environment;

    //Ej: http://localhost:4444/resta?a=45&b=38&user=natalia
    @GetMapping("/resta")
    public String Sub(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        String response = "Resultado: " + String.valueOf(a-b) + " - Respuesta desde: " + port;
        String fecha = LocalDateTime.now().toString();
        Operacion op = new Operacion("Resta", fecha, user);
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
