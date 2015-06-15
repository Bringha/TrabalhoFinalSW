/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.edu.ifsul.modelo.Fisica;
import br.edu.ifsul.modelo.Juridica;
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
public class TestePersistirJuridica {

    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirJuridica() {
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
            Juridica obj = new Juridica();
            obj.setNome("Rinaldi Obras ME");
            obj.setEndereco("Rua Polidoro Albuquerque, 521");
            obj.setBairro("Centro");
            obj.setComplemento("apto 102");
            obj.setCep("91245-780");
            obj.setEmail("rianldi@gmail.com");
            obj.setTelefone("9784-2544");
            obj.setCnpj("42.498.091/0001-87");
            obj.setNomeFantasia("Raio Valecano Empreiteira");
            obj.setRepresentante("Gerson Rinaldi");
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
