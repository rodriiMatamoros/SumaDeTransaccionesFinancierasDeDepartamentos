package org.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UtilidadesFicheros {
    public static long sumarTransacciones(String nombreArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            long suma = 0;
            while ((linea = br.readLine()) != null) {
                suma += Long.parseLong(linea);
            }
            return suma;
        }
    }

    public static void escribirResultado(String nombreArchivo, long suma) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(String.valueOf(suma));
        }
    }
}
