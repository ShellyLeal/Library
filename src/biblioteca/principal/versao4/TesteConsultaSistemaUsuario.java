package biblioteca.principal.versao4;

import junit.framework.TestCase;

public class TesteConsultaSistemaUsuario extends TestCase {
	public void testeUsuarioBloqueadoExtravio (){
		Usuario usuario = new Usuario("Fabio Jr");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		biblioteca.livros.add(livro);
		biblioteca.registrarEmprestimo(usuario, livro);
		biblioteca.registrarExtravio(usuario, livro);
		assertEquals(usuario.getSituacaoBloqueio(),"Bloqueado por extravio");	
	}
	public void testeUsuarioBloqueadoAtraso (){
		Usuario usuario = new Usuario("Fabio Jr");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		biblioteca.livros.add(livro);
		biblioteca.registrarEmprestimo(usuario, livro);
		biblioteca.registrarAtraso(usuario, livro);
		assertEquals(usuario.getSituacaoBloqueio(),"Bloqueado por atraso");	
	}
	public void testePesquisarLivroUsuario (){
		Usuario usuario = new Usuario("Pablo Vitor");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		Livro livro2 = new Livro("Viagem ao centro da Terra");
		Livro livro3 = new Livro("Os Miseráveis");
		biblioteca.livros.add(livro);
		biblioteca.livros.add(livro2);
		biblioteca.livros.add(livro3);
		biblioteca.registrarEmprestimo(usuario, livro);
		biblioteca.registrarEmprestimo(usuario, livro2);
		biblioteca.registrarEmprestimo(usuario, livro3);
		biblioteca.registrarExtravio(usuario, livro2);
		biblioteca.registrarAtraso(usuario, livro3);
		usuario.listarLivrosEmprestados();
	}
}
