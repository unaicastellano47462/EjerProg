package Utilidades;

import jakarta.persistence.EntityManagerFactory;

public class DBConnection {

    private static EntityManagerFactory emf;

    public static void crearEMF() {
        emf = jakarta.persistence.Persistence.createEntityManagerFactory("appTitulares");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
