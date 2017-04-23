package biblioteca.principal.versao4;

import junit.framework.TestCase;

public class TesteConsultaSistemaUsuario extends TestCase {
	public void testeUsuarioBloqueadoExtravio (){
		Usuario usuario = new Usuario("Fabio Jr");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		biblioteca.livros.add(livro);
		usuario.pegarLivroEmprestado(livro);
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
		usuario.pegarLivroEmprestado(livro);
		biblioteca.registrarEmprestimo(usuario, livro);
		biblioteca.registrarAtraso(usuario, livro);
		assertEquals(usuario.getSituacaoBloqueio(),"Bloqueado por atraso");	
	}
}
