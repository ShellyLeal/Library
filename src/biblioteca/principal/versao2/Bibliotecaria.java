package biblioteca.principal.versao2;
import java.util.ArrayList;

public class Bibliotecaria {
	public ArrayList<Usuario> cadastrados = new ArrayList<Usuario>();
	public ArrayList<Livro> livros = new ArrayList<Livro>();
	public void cadastrarUsuario(Usuario usuario) {
		if(usuario.getVerificaCadastrado())
			System.out.println("Usu�rio "+ usuario.getNome() +" j� possui cadastro");
		else
			{
			cadastrados.add(usuario);
			usuario.setAutorizacaoEmprestimo(true);
			usuario.setVerificaCadastrado(true);
			}
	}


	public void excluirUsuario(Usuario usuario) {
		if(usuario.getVerificaCadastrado())
		   for(int i = 0;i<cadastrados.size();i++)
		   {
			 if(usuario.getNome().equals(cadastrados.get(i).getNome())){
			  cadastrados.remove(i);
			  usuario.setAutorizacaoEmprestimo(false);
			  usuario.setVerificaCadastrado(false);
			  }
		   }
		else
			System.out.println("Usuario "+ usuario.getNome() +" nao consta no sistema");
	}
	
	public void bloquearUsuario(Usuario usuario) {
		if(usuario.getVerificaCadastrado())
			usuario.setAutorizacaoEmprestimo(false);
		
		else
			System.out.println("Usuario "+ usuario.getNome() +" nao consta no sistema");
	}
	
	public void desbloquearUsuario(Usuario usuario) {
		if(usuario.getVerificaCadastrado())
			usuario.setAutorizacaoEmprestimo(true);
		
		else
			System.out.println("Usuario "+ usuario.getNome() +" nao consta no sistema");
	}
	public void listarUsuarios() {
		System.out.println("Usu�rios cadastrados:");
		for(int i = 0;i<cadastrados.size();i++)
			System.out.println(cadastrados.get(i).getNome());
	}
	public void listarLivros() {
		System.out.println("Livros cadastrados:");
		for(int i = 0;i<livros.size();i++)
			System.out.println("livro: "+livros.get(i).getNome()+" "+"|status: "+livros.get(i).getStatus());
	}
	public void registrarEmprestimo(Usuario usuario, Livro livro){
		if(!usuario.getVerificaCadastrado()){System.out.println("Usu�rio "+ usuario.getNome() + " n�o cadastrado.");}
		else if(!usuario.getAutorizacaoEmprestimo()){System.out.println("Usu�rio "+ usuario.getNome() + " bloqueado.");}
		else {
			if(livro.getStatus().equals("Dispon�vel"))
			{
				usuario.getLivrosEmprestados().add(livro);
				livro.setStatus("Emprestado");
			}
			else
				System.out.println("Livro "+livro.getNome()+" indispon�vel. Status: "+livro.getStatus());
		}
	}
}
