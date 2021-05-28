package br.com.assistecnologia.gestaodeobras.controller;

import br.com.assistecnologia.gestaodeobras.model.*;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioControllerTest {
    static FuncionarioController funcionarioController = new FuncionarioController();
    static UsuarioController usuarioController = new UsuarioController();
    static ObraController obraController = new ObraController();
    static EnderecoController enderecoController = new EnderecoController();
    static CargoController cargoController = new CargoController();
    private static Usuario usuario;
    private static Endereco endereco;
    private static Obra obra;
    private static Cargo cargo;


    @Test
    @BeforeAll
     public static void setupUp(){
//      Cria usuario
        usuario = usuarioController.create("Usuario Teste","emailteste@teste.com","usuarioteste");
        assertNotNull(usuario);
//      Cria endereco
         endereco = enderecoController.create("Avenida Castelo Branco","4770","101","Rodoviario","Goiania","Goias");
        assertNotNull(endereco);
//        criar obra
        Random random = new Random();
        int codigo = random.nextInt();
         obra = obraController.create("Obra teste", Integer.toString(codigo),"Descricao Obra");
        assertNotNull(obra);
//      Criar cargo
         cargo = cargoController.create("Cargo Teste");
        assertNotNull(cargo);
    }



    @Test
    @Order(1)
    @DisplayName("Cria um funcionario")
    void create() {
//      criar funcionario
        Funcionario funcionario = funcionarioController.create(
                "Funcionario Teste",
                "01345406037",
                "321",
                usuario,
                endereco,
                Sexo.Masculino,
                obra,
                cargo);
        assertNotNull(funcionario);
    }
    @Test
    @Order(2)
    @DisplayName("Mostrar todos os funcionarios,mostrar, edita e deleta um funcionario")
    void index() {
//       Carrega todos
        List<Funcionario> funcionarios = funcionarioController.index();
        assertTrue(funcionarios.size()>0);

//        Mostra o primeiro
        Funcionario funcionario = funcionarioController.show(funcionarios.get(0).getId());
        assertNotNull(funcionario);
//        edita o primeiro
        String edicao = "Funcionario Editado";
        funcionario = funcionarioController.edit(
                funcionario.getId(),
                edicao,
                "01345406037",
                "321",
                usuario,
                endereco,
                Sexo.Masculino,
                obra,
                cargo);
        assertEquals(funcionario.getNome(),edicao);
//      excluir
        Boolean excluido = funcionarioController.delete(funcionario.getId());
        assertTrue(excluido);
    }
    @Test
    @AfterAll
    public static void setupDown(){
        usuarioController.delete(usuario.getId());
        enderecoController.delete(endereco.getId());
        obraController.delete(obra.getId());
        cargoController.delete(cargo.getId());
    }
}