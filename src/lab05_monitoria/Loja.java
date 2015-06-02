package lab05_monitoria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import exceptions.JogoInvalidoException;

public class Loja {
	
	private ArrayList<Usuario> usuarios;
	private Usuario usuario;
	private HashMap<String, Jogo> tabelaJogos;
	
	public void criarJogo(String nome, double preco, String tipo, HashSet<Jogabilidade> jogabilidades) throws JogoInvalidoException {
		Jogo jogo;
		
		switch (tipo){
			case "Rpg":
				jogo = new Rpg(nome, preco, jogabilidades);
				break;
			case "Plataforma":
				jogo = new Plataforma(nome, preco, jogabilidades);
				break;
			case "Luta":
				jogo = new Luta(nome, preco, jogabilidades);
				break;
			default:
				throw new JogoInvalidoException("Tipo de jogo invalido!");
		}
		
		tabelaJogos.put(nome, jogo);
	}
	
	public void adicionarJogo(String nomeJogo, String login){
		Usuario usuario = procurarUsuario(login);
		
		Jogo jogo = tabelaJogos.get(nomeJogo);
		usuario.adicionarJogo(jogo);
	}
	
	public void criarUsuario(String nome, String login){
		try {
			usuario = new Noob(nome, login);
			usuarios.add(usuario);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void adicionarDinheiro(String login, double valor){
		usuario = procurarUsuario(login);
		
		usuario.adicionarDinheiro(valor);
	}
	
	public void imprimirUsuarios(){
		
	}
	
	public Usuario procurarUsuario(String login){
		for (Usuario usuario : usuarios) 
			if (usuario.getLogin().equals(login))
				return usuario;
		
		return null;
	}
	
	public static void main(String[] args) {
		HashSet<Jogabilidade> jogabilidades = new HashSet();
		jogabilidades.add(Jogabilidade.COMPETITIVO);
		Loja loja = new Loja();
		loja.criarJogo("sdasds", 15, "Rpg", null);
	}
}
