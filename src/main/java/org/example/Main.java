package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la lista de archivos de departamentos desde los argumentos
        if (args.length == 0) {
            System.out.println("Debe proporcionar al menos un archivo de departamento como argumento.");
            return;
        }

        // Obtener la lista de archivos de departamentos desde los argumentos
        String[] archivosDepartamentos = args;

        // Crear un Lanzador y ejecutar el procesamiento
        Lanzador lanzador = new Lanzador();
        lanzador.procesarArchivosDepartamentos(archivosDepartamentos);

        // Interacción con el usuario
        boolean salir = false;
        while (!salir) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Ver resultados globales");
            System.out.println("2. Salir");
            System.out.print("Opción: ");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    // Mostrar resultados globales
                    mostrarResultadosGlobales();
                    break;
                case 2:
                    // Salir de la aplicación
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarResultadosGlobales() {
        // Leer y mostrar el contenido de "Resultado_global.txt" o realizar cualquier otra acción que desees.
        System.out.println("Resultados globales:");
        // Agrega aquí la lógica para mostrar los resultados globales.
    }
}

