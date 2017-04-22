package biblioteca.principal.versao3;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import junit.framework.TestCase;

public class TesteEmprestimoDevolucaoBiblioteca extends TestCase{
	Livro l1, l2, l3;
	Bibliotecaria bibliotecaria;
	public void ListaBiblioteca(){
		bibliotecaria = new Bibliotecaria();
		l1 = new Livro("100 contos");
		l2 = new Livro("Viagem ao centro da Terra");
		l3 = new Livro("Os Miseráveis");
		bibliotecaria.livros.add(l1);
		bibliotecaria.livros.add(l2);
		bibliotecaria.livros.add(l3);
	}
		public void testeListaLivrosBiblioteca(){
			ListaBiblioteca();
			bibliotecaria.listarLivros();	
		}
		public void testaEmprestimoLivroUsuarioNaoCadastrado(){
			ListaBiblioteca();
			Usuario usuario = new Usuario("Joe Jonas");
			bibliotecaria.registrarEmprestimo(usuario , l2);
		}
		public void testaEmprestimoLivroUsuarioCadastrado(){
			ListaBiblioteca();
			Usuario usuario = new Usuario("Tom Marvel");
			bibliotecaria.cadastrarUsuario(usuario);
			bibliotecaria.registrarEmprestimo(usuario , l2);
			assertEquals(l2.getStatus(),"Emprestado");
		}
		public void testaMockEmprestimoLivroUsuarioCadastrado(){
			Bibliotecaria bibliotecaria = mock(Bibliotecaria.class);
			Usuario usuario = new Usuario("Tom Marvel");
			bibliotecaria.cadastrarUsuario(usuario);
			bibliotecaria.registrarEmprestimo(usuario , l2);
			verify(bibliotecaria,times(1)).registrarEmprestimo(usuario,l2);
		}
		public void testaDevolucaoLivroUsuarioCadastrado(){
			ListaBiblioteca();
			Usuario usuario = new Usuario("Tom Marvel");
			bibliotecaria.cadastrarUsuario(usuario);
			bibliotecaria.registrarEmprestimo(usuario , l2);
			bibliotecaria.registrarDevolucao(usuario , l2);
			assertEquals(l2.getStatus(),"Disponível");
		}
}