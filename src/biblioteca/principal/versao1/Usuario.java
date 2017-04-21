package biblioteca.principal.versao1;


public class Usuario {
	private String nome;
	private boolean autorizacao; // autorização do usuário
	private boolean verifica;
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
	
}
