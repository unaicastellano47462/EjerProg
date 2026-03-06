package Utilidades;

import java.util.Date;
import java.util.Scanner;

public class EntradaDatos {

    // Forma parte de la vista, pero es tan común que la pongo aquí para no repetir código.
    public static int leerEntero(Scanner sc, String mensaje) {
        int num = 0;
        boolean error = true;
        try {
            num = 0;
            do
            {
                System.out.print(mensaje);
                try {
                    num = Integer.parseInt(sc.nextLine());
                    // También se puede con nextInt, pero así me ahorro el limpiar el buffer después.
                    error = false;
                } catch (NumberFormatException e) {
                    System.out.println("Error: introduce un número entero válido.");
                }
            }
            while (error);
            return num;
        }
        catch (Exception e) {
            System.out.println("Error leyendo el número: " + e.getMessage());
            return -1;
        }
    }

    public static String leerTexto(Scanner sc, String mensaje,String expresionRegular) {
        try
        {
            String texto;
            do
            {
                System.out.print(mensaje);
                texto = sc.nextLine();
                if (!texto.matches(expresionRegular))
                {
                    System.out.println("Error: formato no válido. Inténtalo de nuevo.");
                }
            } while (!texto.matches(expresionRegular));
            return texto;
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo el texto: " + e.getMessage());
            return "";
        }
    }

    public static Date leerFecha(Scanner sc, String mensaje) {
        try
        {
            Date fecha;
            boolean error = true;
            do
            {
                System.out.print(mensaje);
                String fechaStr = sc.nextLine();
                try {
                    fecha = java.sql.Date.valueOf(fechaStr);
                    error = false;
                    return fecha;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: formato de fecha no válido. Usa YYYY-MM-DD.");
                }
            }
            while (error);
        }
        catch (Exception e)
        {
            System.out.println("Error leyendo la fecha: " + e.getMessage());
            return null;
        }
        return null;
    }
}

