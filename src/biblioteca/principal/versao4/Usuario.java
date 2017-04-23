package biblioteca.principal.versao4;

import java.util.ArrayList;

public class Usuario {
	private String nome;
	private boolean autorizacao; // autorização do usuário
	private boolean verifica;
	private ArrayList<Livro> livrosemprestados = new ArrayList<Livro>();
    public Usuario(String nome) {
		setNome(nome);
		setVerificaCadastrado(false);
		setAutorizacaoEmprestimo(false);
	}

	// para realizar empréstimos
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean getAutorizacaoEmprestimo() {
		return autorizacao;
	}
	public void setAutorizacaoEmprestimo(boolean autorizacao) {
		this.autorizacao = autorizacao;
	}
	public boolean getVerificaCadastrado() {
		return verifica;
	}
	public void setVerificaCadastrado(boolean verifica) {
		this.verifica = verifica;
	}
	public ArrayList<Livro> getLivrosEmprestados() {
		return livrosemprestados;
	}
	public void setLivrosEmprestado(ArrayList<Livro> livrosemprestados) {
		this.livrosemprestados = livrosemprestados;
	}
	
	public void devolverLivroEmprestado(Livro livro){
		for(int i = 0;i<livrosemprestados.size();i++)
			if(livro.getNome().equals(livrosemprestados.get(i).getNome()))
				getLivrosEmprestados().remove(i);
	}
	public void pegarLivroEmprestado(Livro livro){
		getLivrosEmprestados().add(livro);
	}
	public Livro pesquisarLivroNoSistema(Bibliotecaria biblioteca, Livro livro){
		for(int i = 0;i<biblioteca.livros.size();i++)
			if(livro.getNome().equals(biblioteca.livros.get(i).getNome()))
				return livro;
		return null;
	}

	public boolean buscarLivro(Livro livro) {
		for(int i = 0;i<livrosemprestados.size();i++)
			if(livro.getNome().equals(livrosemprestados.get(i).getNome()))
				return true;
		return false;
	}

	public void setSituacaoBloqueio(String string) {
		// TODO Auto-generated method stub
		
	};
}
