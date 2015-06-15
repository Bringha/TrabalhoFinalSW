/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.edu.ifsul.modelo.Fisica;
import br.edu.ifsul.modelo.Juridica;
import br.edu.ifsul.modelo.Objeto;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bringha
 */
public class TestePersistirObjeto {

    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirObjeto() {
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
    public void test(){
        boolean exception = false;
        try{
            Objeto obj = new Objeto();
            obj.setDescricao("Serviços de Limpeza Interna de ambientes");
            obj.setValor(4500.00);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
