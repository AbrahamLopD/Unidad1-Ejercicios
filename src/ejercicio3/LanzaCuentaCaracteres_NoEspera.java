package ejercicio3;

import java.io.File;
import java.io.IOException;

public class LanzaCuentaCaracteres_NoEspera {
    public static void main(String[] args) {
        //  creaFicheros();
        long inicio = System.currentTimeMillis();
        String vocales [] = {"a", "e", "i", "o", "u"};
        for(int i = 0; i < vocales.length; i++)  {  //  El proceso se lanzará 5 veces. Una por vocal.
            ProcessBuilder pb = new ProcessBuilder("java",
                    "C:\\Users\\alopezdelgado\\Documents\\ProgramacionDeServicios\\Unidad1-Ejercicios\\src\\ejercicio3\\CuentaCaracteres.java",
                    vocales[i]);
            pb.redirectInput(new File("C:\\Users\\alopezdelgado\\Documents\\ProgramacionDeServicios\\Unidad1-Ejercicios\\src\\ejercicio3\\texto_largo.txt"));
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            try {
                pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        long fin = System.currentTimeMillis();
        System.out.println("Tiempo que tarda en ejecutarse: " + (fin - inicio));   // Tiempo que tarda la aplicación en ejecutarse
    }

    public static void creaFicheros() {
        for (int i = 0; i < 10; i++) {
            ProcessBuilder pb = new ProcessBuilder("java", "C:\\Users\\alopezdelgado\\Documents\\ProgramacionDeServicios\\Unidad1-Ejercicios\\src\\ejercicio3\\GeneraIPs.java");
            pb.directory(new File("C:\\Users\\alopezdelgado\\Documents\\ProgramacionDeServicios\\Unidad1-Ejercicios\\src\\ejercicio3"));
            pb.redirectOutput(new File("C:\\Users\\alopezdelgado\\Documents\\ProgramacionDeServicios\\Unidad1-Ejercicios\\src\\ejercicio3\\vocal" + i + ".txt"));
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);

            try {
                Process p = pb.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}