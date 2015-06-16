package Testes;

import br.edu.ifsul.modelo.Aditivo;
import br.edu.ifsul.modelo.Contrato;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jorge
 */
public class TestePersistirAditivo {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAditivo() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoFinalSWPULocal");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            Contrato obj = em.find(Contrato.class, 1);
            Aditivo adt = new Aditivo();
            adt.setDescricao("Aditivo de tempo de serviço");
            adt.setDias(365);
            obj.adicionarAditivo(adt);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
