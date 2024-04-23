import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        // scanner nos permite utilizar informacon ingresada por el ususario
        Scanner scanner = new Scanner(System.in);

        // declaraciones y asignaciones de variables
        String palabraSecreta = "obertura";
        int intentosMaximos = 10;
        int intentos = 0;
        boolean palabraAdivinada = false; // variable para poder iniciar el juego

        // Arreglos - este arreglo tendra la longitud de la palabra a adivinar
        char[] letrasAdivinadas = new char [palabraSecreta.length()];

        // Estructura de control iterativa (bucle) - se recorre el arreglo y se asignan _ inicialmente
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';   
        }

        // Estructura de control iterativa - 
        while(!palabraAdivinada && intentos < intentosMaximos) {
                                                // usado cuando se tiene palabras en chars no es strings
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introduce una letra, por favor");

            // se usa la clase scanner para tomar la letra 
            char letra = Character.toLowerCase(scanner.next().charAt(0));
            boolean letraCorrecta = false; // Evalua el juego

            // inicio el juego y se recorre la palbra secreta
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra; // dejara de verse con _ y se pondra la letra en la posicion i (que corresponda)
                    letraCorrecta = true;
                }
            }

            if (!letraCorrecta){
                intentos++;
                System.out.println("¡Incorrecto! Te quedan " + (intentosMaximos - intentos) + " intentos.");
            }

            if (String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("¡Felicidades! Has adivinado la palabra secreta: " + palabraSecreta);
            }
        }

        if (!palabraAdivinada) {
            System.out.println("¡Te has quedado sin intentos! JUEGO TERMINADO");
        }
        scanner.close();
    }
}
