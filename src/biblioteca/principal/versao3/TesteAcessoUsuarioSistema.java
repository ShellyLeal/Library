package biblioteca.principal.versao3;

import junit.framework.TestCase;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TesteAcessoUsuarioSistema extends TestCase {
	public void testeMockPesquisarLivroUsuario (){
		Usuario usuario = mock(Usuario.class);
		Bibliotecaria biblioteca = mock(Bibliotecaria.class);
		Livro livro = mock(Livro.class);
		usuario.pesquisarLivroNoSistema(biblioteca, livro);
		verify(usuario,times(1)).pesquisarLivroNoSistema(biblioteca, livro);

	}
	public void testePesquisarLivroUsuario (){
		Usuario usuario = new Usuario("Fabio Jr");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		biblioteca.livros.add(livro);
		assertEquals(usuario.pesquisarLivroNoSistema(biblioteca, livro).getNome(),"100 contos");
	}
	public void testePesquisarStatusLivroUsuario (){
		Usuario usuario = new Usuario("Fabio Jr");
		Bibliotecaria biblioteca = new Bibliotecaria();
		biblioteca.cadastrarUsuario(usuario);
		Livro livro = new Livro("100 contos");
		biblioteca.livros.add(livro);
		assertEquals(usuario.pesquisarLivroNoSistema(biblioteca, livro).getStatus(),"Disponível");
	}
	
}
