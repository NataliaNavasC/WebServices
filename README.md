#Servicios REST y Microservicios
A continuación se detalla la forma en que pueden ser ejecutadas la parte uno y dos del taller

## PARTE 1
Este punto consta de 2 proyectos que pueden ser encontrados en la sub-carpeta P1-ClienteServidorRestMonolito. Este es el orden en que deben ser ejecutados: 
1. Servidor
2. Cliente

### Servidor: 
Puerto 8080 (default)

Para ejecutar el servidor utilice una terminal y ubíquese en la siguiente ruta: 
> WebServices\P1-ClienteServidorRestMonolito\jerseyServer  

Acto seguido ejecute:
> mvn clean install exec:java

Puede verificar que el servidor está funcionando correctamente utilizando la siguiente URL en un navegador o un cliente rest de su preferencia:
> http://localhost:8080/myapp/myresource

### Cliente:
Para ejecutar el cliente utilice una terminal y ubíquese en la siguiente ruta: 
> WebServices\P1-ClienteServidorRestMonolito\RestClient

Acto seguido ejecute:
> mvn clean install exec:java

Utilice las siguientes opciones para consumir los servicios del servidor
> 1. Ver todos los paseos
> 2. Eliminar un paseo 
> 3. Editar origen y destino de un paseo
> 4. Crear paseo
> 5. Salir
> 

## PARTE 2
Este punto consta de 6 proyectos que pueden ser encontrados en la sub-carpeta P2-Microservicios.
A continuación se presenta una tabla que resume el orden en que deben ser ejecutados los procesos y los puertos por defecto de cada uno de ellos:
| Orden | Proceso | Puerto por defecto |
|:--------|:-----------|:-----------|
| 1 | EurekaServer | 8761 |
| 2 | Suma | 9999 |
| 3 | Resta | 4444 |
| 4 | Multiplicación | 7777 |
| 5 | División | 5555 |
| 6 | Calculadora | 8888 |

### Eureka Server:
Para ejecutar el discovery service utilice una terminal y ubíquese en la siguiente ruta: 
> WebServices\P2-Microservicios\eurekaserver

Acto seguido ejecute:
> mvn clean install spring-boot:run

### MicroServicios de las operaciones:
Para ejecutar cualquier microservicio de las operaciones de la calculadora utilice una terminal y ubíquese en la siguiente ruta: 

Nota: el nombre del microservicio puede ser: sumador, restador, divisor o multiplicador.
> WebServices\P2-Microservicios\\[nombre del microservicio]

Acto seguido ejecute:
> mvn clean install spring-boot:run

Cada una de las operaciones puede ser ejecutada múltiples veces en distintas instancias de un microservicio, para ello, debe cambiar el puerto en que se ejecutan por defecto.
Para cambiar los puertos utilice los siguientes comandos:

* IOS: 
> SERVER_PORT=#### mvn spring-boot:run

* Windows:
> SET SERVER_PORT=####
> 
> mvn spring-boot:run

### Servicio calculadora:
Para ejecutar la calculadora utilice una terminal y ubíquese en la siguiente ruta: 
> WebServices\P2-Microservicios\calculadora

Acto seguido ejecute:
> mvn clean spring-boot:run


## Probando la aplicación completa 
Una vez estén corriendo todos los procesos requeridos, utilice las siguientes URLS para consumir los servicios ofrecidos.

============================ Operaciones ============================

Estas URLs permiten consumir los microservicios de las operaciones de forma individual.

| Operación | URL de ejemplo |
|:---------|:-----------|
| Suma | http://localhost:8888/calculadora/suma?a=5&b=3&user=Usuario1 |
| Resta | http://localhost:8888/calculadora/resta?a=5&b=3&user=Usuario2 |
| Multiplicación | http://localhost:8888/calculadora/multiplicacion?a=5&b=3&user=Usuario3 |
| División | http://localhost:8888/calculadora/division?a=10&b=2&user=Usuario4 |



====================== Registro de operaciones ====================== 

Estas URLs permiten consultar el registro de opreaciones realizadas por cada tipo de operación de forma individual.
| Operación | URL de ejemplo |
|:---------|:-----------|
| Suma | http://localhost:8888/calculadora/operaciones?operacion=sumador |
| Resta | http://localhost:8888/calculadora/operaciones?operacion=restador |
| Multiplicación | http://localhost:8888/calculadora/operaciones?operacion=multiplicador |
| División | http://localhost:8888/calculadora/operaciones?operacion=divisor |



