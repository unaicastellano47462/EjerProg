package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

public class TitularDAO {

    private EntityManagerFactory emf;

    public TitularDAO()
    {
            this.emf = DBConnection.getEntityManagerFactory();
    }

    public void insertar(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(titular);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public int borrar(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.find(Titular.class, id);
            if (titular != null) {
                em.remove(titular);
                em.getTransaction().commit();
                return 1; // Éxito
            } else {
                em.getTransaction().rollback();
                return 0; // No encontrado
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Titular buscarPorId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Titular.class, id);
        } finally {
            em.close();
        }
    }

    public Titular buscarPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Titular t WHERE t.dni = :dni", Titular.class)
                    .setParameter("dni", dni)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public ArrayList<Titular> buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            return new ArrayList<>(em.createQuery("SELECT t FROM Titular t WHERE t.nombre = :nombre", Titular.class)
                    .setParameter("nombre", nombre)
                    .getResultList());
        } finally {
            em.close();
        }
    }

    public void modificar(Titular titular) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(titular);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public List<Titular> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT t FROM Titular t", Titular.class).getResultList();
        } finally {
            em.close();
        }
    }
}

