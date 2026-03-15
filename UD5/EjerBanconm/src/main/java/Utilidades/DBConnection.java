package Utilidades;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("appTitulares");
            } catch (Exception e) {
                System.out.println("Error al conectar con la base de datos: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return emf;
    }

    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}