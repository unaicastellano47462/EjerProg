package DAO;

import Modelo.Cuenta;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class CuentaDAO {
    private EntityManagerFactory emf;

    public CuentaDAO() {
        this.emf = DBConnection.getEntityManagerFactory();
    }

    public void insertar(Cuenta cuenta) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(cuenta);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Cuenta buscarPorIban(String iban) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Cuenta.class, iban);
        } finally {
            em.close();
        }
    }

    public List<Cuenta> listarTodas() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Cuenta> query = em.createQuery("SELECT c FROM Cuenta c", Cuenta.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Cuenta> buscarCuentasPorDniTitular(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Cuenta> query = em.createQuery(
                    "SELECT ct.iban FROM CuentasTitulare ct WHERE ct.dni.dni = :dni", Cuenta.class);
            query.setParameter("dni", dni);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}