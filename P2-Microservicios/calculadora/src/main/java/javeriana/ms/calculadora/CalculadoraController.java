package javeriana.ms.calculadora;

import javeriana.ms.calculadora.model.Operacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@RestController
public class CalculadoraController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/calculadora/suma")
    public String calculadoraSuma(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        return  restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&user={user}", String.class, a, b, user);
    }

    @GetMapping("/calculadora/multiplicacion")
    public String calculadoraMulti(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        return  restTemplate.getForObject("http://multiplicador/multiplicacion?a={a}&b={b}&user={user}", String.class, a, b, user);
    }

    @GetMapping("/calculadora/resta")
    public String calculadoraResta(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        return  restTemplate.getForObject("http://restador/resta?a={a}&b={b}&user={user}", String.class, a, b, user);
    }

    @GetMapping("/calculadora/division")
    public String calculadoraDivision(@RequestParam int a, @RequestParam int b, @RequestParam String user){
        return  restTemplate.getForObject("http://divisor/division?a={a}&b={b}&user={user}", String.class, a, b, user);
    }

    @RequestMapping(
            value = "/calculadora/operaciones",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ArrayList<Operacion> calculadoraDivision(@RequestParam String operacion){
        // operación puede ser: sumador, restador, multiplicador, divisor
        String url = "http://" + operacion + "/operaciones";
        return  restTemplate.getForObject(url, ArrayList.class);
    }
}
