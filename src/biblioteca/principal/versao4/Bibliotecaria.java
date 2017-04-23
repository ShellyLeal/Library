package biblioteca.principal.versao4;
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
			usuario.setSituacaoBloqueio("N�o bloqueado");
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
				usuario.pegarLivroEmprestado(livro);
				livro.setStatus("Emprestado");
			}
			else
				System.out.println("Livro "+livro.getNome()+" indispon�vel. Status: "+livro.getStatus());
		}
	}
	public void registrarExtravio(Usuario usuario, Livro livro){
		if(!usuario.getVerificaCadastrado()){System.out.println("Usu�rio "+ usuario.getNome() + " n�o cadastrado.");}
		else {
			if(livro.getStatus().equals("Emprestado")&& usuario.buscarLivro(livro))
			{	bloquearUsuario(usuario);
				usuario.setAutorizacaoEmprestimo(false);
				usuario.setSituacaoBloqueio("Bloqueado por extravio");
				livro.setStatus("Extraviado");
			}
			else
				System.out.println("Livro "+livro.getNome()+" n�o foi emprestado para esse usu�rio. Status: "+livro.getStatus());
		}
	}
	public void registrarAtraso(Usuario usuario, Livro livro){
		if(!usuario.getVerificaCadastrado()){System.out.println("Usu�rio "+ usuario.getNome() + " n�o cadastrado.");}
		else {
			if(livro.getStatus().equals("Emprestado")&& usuario.buscarLivro(livro))
			{	bloquearUsuario(usuario);
				usuario.setAutorizacaoEmprestimo(false);
				usuario.setSituacaoBloqueio("Bloqueado por atraso");
				livro.setStatus("Atraso na devolu��o");
			}
			else
				System.out.println("Livro "+livro.getNome()+" n�o foi emprestado para esse usu�rio. Status: "+livro.getStatus());
		}
	}
	public void registrarDevolucao(Usuario usuario, Livro livro){
		if(!usuario.getVerificaCadastrado()){System.out.println("Usu�rio "+ usuario.getNome() + " n�o cadastrado.");}
		else {
			if(!livro.getStatus().equals("Dispon�vel"))
			{ 
				usuario.devolverLivroEmprestado(livro);
				livro.setStatus("Dispon�vel");
				usuario.setSituacaoBloqueio("N�o bloqueado");
			}
			else
				System.out.println("Livro "+livro.getNome()+" indispon�vel. Status: "+livro.getStatus());
		}
	}
}
