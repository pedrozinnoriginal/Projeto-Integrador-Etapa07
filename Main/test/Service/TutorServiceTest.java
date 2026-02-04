package Service;

import Model.Tutor;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TutorServiceTest {

    private TutorService service;

    // Executa antes de cada método de teste
    @Before
    public void setup() {
        service = new TutorService();
    }

    @Test
    public void testValidarDadosTutorCaminhoFeliz() {
        System.out.println("Executando: testValidarDadosTutor - resultado OK!");
        
        Tutor tutor = new Tutor();
        tutor.setNomeTutor("Pedro Silva");
        tutor.setCpf("123456789010");
        
        try {
            service.validarDadosTutor(tutor);
            // Se não lançar exceção, o teste passa
        } catch (Exception e) {
            fail("Deveria aceitar dados válidos, mas lançou: " + e.getMessage());
        }
    }

    @Test
    public void testValidarDadosTutorNomeVazio() {
        System.out.println("Executando: testValidarDadosTutor Nome Vazio");
        
        Tutor tutor = new Tutor();
        tutor.setNomeTutor(""); // Nome vazio para forçar erro
        tutor.setCpf("12345678901");
        
        try {
            service.validarDadosTutor(tutor);
            fail("Deveria ter lançado erro por nome vazio, mas passou.");
        } catch (IllegalArgumentException e) {
            // Verificamos mensagem de erro 
            assertEquals("Nome do tutor é obrigatório.", e.getMessage());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarDadosTutorCpfCurto() {
        System.out.println("Executando: testValidarDadosTutorCpfCurto");
        
        Tutor tutor = new Tutor();
        tutor.setNomeTutor("Pedro Silva");
        tutor.setCpf("123"); // CPF muito curto
        
        // Esta forma simplificada espera que o método lance a exceção automaticamente
        service.validarDadosTutor(tutor);
    }
}