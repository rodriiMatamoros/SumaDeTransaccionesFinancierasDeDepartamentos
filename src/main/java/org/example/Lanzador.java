package org.example;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    public void procesarArchivosDepartamentos(String[] archivosDepartamentos) {
        // Crear un ExecutorService para gestionar los hilos
        ExecutorService executorService = Executors.newFixedThreadPool(archivosDepartamentos.length);

        // Crear una lista para almacenar los resultados globales de cada departamento
        List<Long> resultadosDepartamentos = new ArrayList<>();

        // Procesar cada archivo de departamento en paralelo
        for (String archivoDepartamento : archivosDepartamentos) {
            executorService.submit(new ProcesadorContabilidad(archivoDepartamento, resultadosDepartamentos));
        }

        // Apagar el ExecutorService una vez que se completen todos los procesamientos
        executorService.shutdown();

        try {
            // Esperar a que todos los hilos terminen
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            // Manejar la interrupción
            e.printStackTrace();
        }

        // Sumar los resultados de cada departamento
        long sumaTotal = resultadosDepartamentos.stream().mapToLong(Long::longValue).sum();

        try {
            // Guardar el resultado global en "Resultado_global.txt"
            UtilidadesFicheros.escribirResultado("Resultado_global.txt", sumaTotal);
        } catch (IOException e) {
            // Manejar excepciones de E/S aquí
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Puedes agregar un método main aquí si necesitas ejecutar la clase Lanzador de manera independiente.

    }
}
