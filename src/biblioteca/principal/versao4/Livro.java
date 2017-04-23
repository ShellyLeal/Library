package biblioteca.principal.versao4;

public class Livro {
	private String nome;
	private String status;
	public Livro(String nome) {
		setNome(nome);
		setStatus("Disponível");
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
