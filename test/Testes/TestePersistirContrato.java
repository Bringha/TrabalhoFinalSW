/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testes;

import br.edu.ifsul.modelo.Contratado;
import br.edu.ifsul.modelo.Contratante;
import br.edu.ifsul.modelo.Contrato;
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
public class TestePersistirContrato {

    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirContrato() {
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
            Contrato obj = new Contrato();
            obj.setNumero("201500001");
            obj.setDataInicio(Calendar.getInstance());
            obj.setDataAssinatura(Calendar.getInstance());
            obj.setDataFim(Calendar.getInstance());
            obj.setContratado(em.find(Contratado.class, 1));
            obj.setContratante(em.find(Contratante.class, 1));
            obj.setObjeto(em.find(Objeto.class, 1));
            obj.setValorTotal(obj.getObjeto().getValor() * 12);
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
