package biblioteca.principal.versao2;

import junit.framework.TestCase;

public class TesteEmprestimoBiblioteca extends TestCase{
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
}
