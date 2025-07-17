import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class Nombre {

    // Scanner para entradas por consola
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        // Variable que guarda la elección del usuario en menú
        int opcion;

        while (!salir) {

            // Mostrar menú
            System.out.println("Selecciona una de las opciones");
            System.out.println("1. Escribir nombre");
            System.out.println("2. Leer nombres");
            System.out.println("3. Salir");

            // Validar que el usuario no ingrese letras
            if (input.hasNextInt()) {
                opcion = input.nextInt();
            } else {
                System.out.println("Solo se permiten números en este menú");
                input.nextLine();
                continue;
            }
            input.nextLine(); // Limpia el buffer del scanner

            switch (opcion) {
                case 1:
                    escribir(); // Llama al método para escribir nombres en el archivo
                    break;

                case 2:
                    leer(); // Llama al método para leer los nombres del archivo
                    break;

                case 3:
                    salir = true;
                    System.out.println("Adiós!");
                    break;

                default:
                    System.out.println("Elija una opción correcta");
            }
        }
        input.close(); // Cerrar Scanner
    }

    public static void escribir() {

        // Variable que almacenará el nombre ingresado
        String nombre;

        // Pedimos el nombre al usuario
        System.out.println("Por favor digite un nombre");
        nombre = input.nextLine();

        System.out.println("El nombre ingresado fue: " + nombre);

        try {
            // Crear objeto File se encarga de crear o abrir acceso a un archivo que se
            // especifica en su constructor
            File archivo = new File("Texto.txt");

            // Crear objeto fileWriter ayuda a escribir sobre el archivo
            FileWriter escribir = new FileWriter(archivo, true);

            // Escribiendo en el archivo con el método write
            escribir.write(nombre + "\n");

            // Se cierra la conexión
            escribir.close();
        }

        catch (Exception e) {
            System.out.println("Error al escribir el nombre");
        }
    }

    public static void leer() {

        // Variable que contiene todo el texto del archivo
        String texto;

        try {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector = new FileReader("Texto.txt");

            // El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido = new BufferedReader(lector);

            // Ciclo para mostrar todo el contenido del archivo
            while ((texto = contenido.readLine()) != null) {
                System.out.println(texto);
            }
            contenido.close();
        }

        catch (Exception e) {
            System.out.println("Error al leer");
        }
    }
}