package org.example;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ProcesadorContabilidad implements Runnable {
    private String nombreArchivo;
    private List<Long> resultadosDepartamentos;

    public ProcesadorContabilidad(String nombreArchivo, List<Long> resultadosDepartamentos) {
        this.nombreArchivo = nombreArchivo;
        this.resultadosDepartamentos = resultadosDepartamentos;
    }

    @Override
    public void run() {
        try {
            long suma = UtilidadesFicheros.sumarTransacciones(nombreArchivo);
            synchronized (resultadosDepartamentos) {
                resultadosDepartamentos.add(suma);
            }
            UtilidadesFicheros.escribirResultado(nombreArchivo + ".res", suma);
        } catch (IOException e) {
            // Manejar excepciones de E/S aquí
            e.printStackTrace();
        }
    }
}
