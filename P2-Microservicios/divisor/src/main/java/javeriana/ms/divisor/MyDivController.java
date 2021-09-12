package javeriana.ms.divisor;

import javeriana.ms.divisor.model.Operacion;
import javeriana.ms.divisor.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyDivController {
    @Autowired
    Environment environment;

    //Ej: http://localhost:5555/division?a=45&b=38&user=holamundo
    @GetMapping("/division")
    public String Sub(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        String port = environment.getProperty("local.server.port");
        double d = (double)a/(double)b;
        String response = "Resultado: " + String.valueOf(d) + " - Respuesta desde: " + port;
        String fecha = LocalDateTime.now().toString();
        Operacion op = new Operacion("Division", fecha, user);
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
