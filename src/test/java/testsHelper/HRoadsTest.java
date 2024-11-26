package testsHelper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import metodoshelper.metodosHelper;

public class HRoadsTest {

    @Test
    public void validarAdicaoDeEntregador() {
        metodosHelper sistema = new metodosHelper();
        sistema.registrarEntregador("Miguel");
        List<String> entregadores = sistema.obterEntregadores();
        assertEquals(1, entregadores.size());
        assertTrue(entregadores.contains("Miguel"));
    }

    @Test
    public void validarCadastroDeOficinaRepetida() {
        metodosHelper sistema = new metodosHelper();
        sistema.registrarOficina("Auto Center Y");
//        Esta linha a baixo
        sistema.registrarOficina("Auto Center Y");
        List<String> oficinas = sistema.obterOficinas();
        assertEquals(2, oficinas.size());
    }

    @Test
    public void verificarFalhaAoRegistrarEntregadorSemNome() {
        metodosHelper sistema = new metodosHelper();
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            sistema.registrarEntregador("");
        });
        assertEquals("O nome do entregador não pode ser vazio ou nulo.", excecao.getMessage());
    }

    @Test
    public void verificarFalhaAoRegistrarOficinaSemNome() {
        metodosHelper sistema = new metodosHelper();
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            sistema.registrarOficina("");
        });
        assertEquals("O nome da oficina não pode ser vazio ou nulo.", excecao.getMessage());
    }

    @Test
    public void selecionarOficinaInexistente() {
        metodosHelper sistema = new metodosHelper();
        sistema.registrarOficina("Auto Center X");
        Exception excecao = assertThrows(IllegalArgumentException.class, () -> {
            sistema.escolherOficina("Oficina Fantasma");
        });
        assertEquals("A oficina solicitada não foi encontrada.", excecao.getMessage());
    }

    @Test
    public void verificarAssociacaoEntreEntregadorEOficina() {
        metodosHelper sistema = new metodosHelper();
        sistema.registrarEntregador("Ana");
        sistema.registrarOficina("Oficina Ideal");
        String resultado = sistema.escolherOficina("Oficina Ideal");
        assertEquals("Oficina escolhida: Oficina Ideal", resultado);
        assertTrue(sistema.obterEntregadores().contains("Ana"));
    }
}
