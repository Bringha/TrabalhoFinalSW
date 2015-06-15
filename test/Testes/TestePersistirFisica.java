/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.edu.ifsul.modelo.Fisica;
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
public class TestePersistirFisica {

    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirFisica() {
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
            Fisica obj = new Fisica();
            obj.setNome("Fábio Bringhenti");
            obj.setEndereco("Rua Morom, 1299");
            obj.setBairro("Centro");
            obj.setComplemento("apto 303");
            obj.setCep("99562-230");
            obj.setRg("1020304050");
            obj.setCpf("221.258.253-68");
            obj.setEmail("bringha@gmail.com");
            obj.setTelefone("9669-4074");
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
