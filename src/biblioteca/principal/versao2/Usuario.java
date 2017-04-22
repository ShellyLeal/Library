package biblioteca.principal.versao2;

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
	
}
