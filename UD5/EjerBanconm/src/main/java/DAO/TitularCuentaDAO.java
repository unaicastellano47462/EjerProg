package DAO;

import Modelo.Cuenta;
import Modelo.Titular;
import Modelo.CuentasTitulare;
import Modelo.CuentasTitulareId;
import Utilidades.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TitularCuentaDAO {
    private EntityManagerFactory emf;

    public TitularCuentaDAO() {
        this.emf = DBConnection.getEntityManagerFactory();
    }

    public void asociarTitularACuenta(String ibanStr, String dniStr) throws Exception {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Cuenta cuenta = em.find(Cuenta.class, ibanStr);
            Titular titular = em.find(Titular.class, dniStr);

            if (cuenta != null && titular != null) {
                CuentasTitulareId ctId = new CuentasTitulareId();
                ctId.setDni(dniStr);
                ctId.setIban(ibanStr);

                CuentasTitulare ct = new CuentasTitulare();
                ct.setId(ctId);
                ct.setIban(cuenta);
                ct.setDni(titular);

                em.persist(ct);
                em.getTransaction().commit();
            } else {
                throw new Exception("Cuenta o Titular no encontrados.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }
}