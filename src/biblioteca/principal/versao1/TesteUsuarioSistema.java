package biblioteca.principal.versao1;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

public class TesteUsuarioSistema extends TestCase{
	Usuario u1, u2, u3, u4;
	public void testecadastrarUsuario (){
		Bibliotecaria bibliotecaria = mock(Bibliotecaria.class);
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.cadastrarUsuario(u2);
		verify(bibliotecaria,times(1)).cadastrarUsuario(u1);
		verify(bibliotecaria,times(2)).cadastrarUsuario(u2);
	}
	public void testeErroCadastrarUsuarioDuasVezes (){
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.cadastrarUsuario(u2);
		assertEquals(bibliotecaria.cadastrados.size(),2);
	}
	public void testeListarUsuariosCadastrados (){
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		u3 = new Usuario("João Carlos");
		u4 = new Usuario("Paulo Silva");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.cadastrarUsuario(u3);
		bibliotecaria.cadastrarUsuario(u4);
		bibliotecaria.listarUsuarios();
	}
	public void testeExcluirUsuarioCadastrado (){
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.excluirUsuario(u2);
		assertEquals(bibliotecaria.cadastrados.size(),1);
	}
	public void testeBloquearUsuarioCadastrado (){
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.bloquearUsuario(u2);
		assertEquals(u2.getAutorizacaoEmprestimo(),false);
	}
	public void testeDesbloquearUsuarioCadastrado (){
		Bibliotecaria bibliotecaria = new Bibliotecaria();
		u1 = new Usuario("Maria Joana");
		u2 = new Usuario("Marcos André");
		bibliotecaria.cadastrarUsuario(u1);
		bibliotecaria.cadastrarUsuario(u2);
		bibliotecaria.bloquearUsuario(u2);
		bibliotecaria.desbloquearUsuario(u2);
		assertEquals(u2.getAutorizacaoEmprestimo(),true);
	}
	
}
