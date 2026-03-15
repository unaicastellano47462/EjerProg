package DAO;

import Modelo.Titular;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class TitularDAO {
    private EntityManagerFactory emf;

    public TitularDAO() {
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

    public Titular buscarPorDni(String dni) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Titular.class, dni);
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

    public void borrar(String dni) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Titular titular = em.find(Titular.class, dni);
            if (titular != null) {
                em.remove(titular);
                em.getTransaction().commit();
            } else {
                throw new Exception("No se encontró ningún titular con el DNI proporcionado.");
            }
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
            TypedQuery<Titular> query = em.createQuery("SELECT t FROM Titular t ORDER BY t.dni", Titular.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Titular> buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Titular> query = em.createQuery(
                    "SELECT t FROM Titular t WHERE t.nombre LIKE :nombre", Titular.class);
            query.setParameter("nombre", "%" + nombre + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}