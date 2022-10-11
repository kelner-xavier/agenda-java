package br.ufpb.dcx.rodrigor.atividade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class AtividadeTest {

    Agenda app = new Agenda();
    @BeforeEach
    public void setUp() {
    }


    @Test

    void testSomething() {
        assertEquals("teste","teste");
    }
    @Test
    void incluirTest() {
        assertTrue(app.cadastrar(new Contato("kelner","123456789" )));
    }
    @Test
    void excluirTest() {
        assertFalse(app.remover((new Contato("kelner","123456789" ))));
    }
    @Test
    void listarTest() {
        assertEquals("teste","teste");

    }
    @Test
    void pesquisarTest() {
        assertEquals("teste","teste");

    }

}
