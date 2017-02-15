# lcddisplay

Objetivo: Crear un programa que imprime números en estilo de una pantalla LCD
Entrada: La entrada contiene varias líneas. Cada línea contiene 2 números separados por coma. El primer número representa el tamaño de la impresión (entre 1 y 10 – esta variable se llama “size”). El segundo número es el número a mostrar en la pantalla. Para terminar, se debe digitar 0,0. Esto terminará la aplicación.
Salida: Imprimir los números especificados usando el carácter “-“ para los caracteres horizontales, y “|” para los verticales. Cada dígito debe ocupar exactamente size+2 columnas y 2*size + 3 filas.
Entre cada impresión debe haber una línea blanca.

Ejemplo:
Entrada:
2,12345
3,67890
0,0

##Ejecutar el programa

Para ver funcionando el programa sin necesidad de configurar el ambiente se puede instalar el cliente de docker ejecutar los siguientes comandos

```sh
docker pull camiloahm/psllcddisplay
```

```sh
docker run -it --rm camiloahm/psllcddisplay
```

## Configuración del ambiente

El proyecto fue desarrollaro con JDK 8, y el build esta configurado para realizarse con Maven cuando el ambiente tenga instalado los componentes anteriores se debe de ejecutar el siguiente comando

```sh
mvn clean install
```