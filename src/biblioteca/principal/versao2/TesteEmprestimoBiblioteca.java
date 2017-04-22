package biblioteca.principal.versao2;

import junit.framework.TestCase;

public class TesteEmprestimoBiblioteca extends TestCase{
	Livro l1, l2, l3;
	Bibliotecaria bibliotecaria;
	public void ListaBiblioteca(){
		bibliotecaria = new Bibliotecaria();
		l1 = new Livro("100 contos");
		l2 = new Livro("Viagem ao centro da Terra");
		l3 = new Livro("Os Miser�veis");
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
}