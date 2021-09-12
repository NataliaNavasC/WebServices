package javeriana.ms.sumador;

import javeriana.ms.sumador.model.Operacion;
import javeriana.ms.sumador.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MySumController {

    @Autowired
    Environment environment;

    //Ej: http://localhost:9999/suma?a=45&b=38&user=natalia
    @GetMapping("/suma")
    public String sum(@RequestParam int a,@RequestParam int b, @RequestParam String user)
    {
        String port = environment.getProperty("local.server.port");
        String response = "Resultado: " + String.valueOf(a+b) + " - Respuesta desde: " + port;
        String fecha = LocalDateTime.now().toString();
        Operacion op = new Operacion("Suma", fecha, user);
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
