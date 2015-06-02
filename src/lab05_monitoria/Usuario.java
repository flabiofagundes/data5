package lab05_monitoria;

import java.util.ArrayList;

import exceptions.LoginInvalidoException;
import exceptions.NomeUsuarioInvalidoException;
import exceptions.UsuarioInvalidoException;
import exceptions.ValorDinheiroInvalidoException;

public abstract class Usuario {
	
	private String nome;
	private String login;
	private ArrayList<Jogo> jogos;
	private double dinheiro;
	private int x2p;
	
	public Usuario(String nome, String login) throws UsuarioInvalidoException {
		validarUsuario(nome, login);
		
		this.nome = nome;
		this.login = login;
		x2p = 0;
		dinheiro = 0;
	}
	
	public void adicionarDinheiro(double valor) throws ValorDinheiroInvalidoException{
		if (valor < 0)
			throw new ValorDinheiroInvalidoException();
		
		dinheiro += valor;
	}
	
	public Jogo procurarJogo(String nome){
		for (Jogo jogo : jogos) 
			if (jogo.equals(nome))
				return jogo;
		
		return null;
	}
	
	public void adicionarJogo(Jogo jogo){
		if (jogo != null)
			jogos.add(jogo);
		
		x2p += 10 * jogo.getPreco();
	}
	
	public void jogar(String nomeJogo, int score, boolean zerou){
		Jogo jogo = procurarJogo(nomeJogo);
		
		jogo.jogar(score, zerou);
		
		if (jogo instanceof Rpg)
			x2p += 10;
		else if (jogo instanceof Luta){
			if (score > jogo.getMaiorScore())
				if ((score % 1000) == 0)
					x2p += score/1000;
		}
		else if (jogo instanceof Plataforma){
			if (zerou)
				x2p += 20;
		}
			
	}
	
	private void validarUsuario(String nome, String login) throws UsuarioInvalidoException {
		if (nome.trim().equals("") || nome == null)
			throw new NomeUsuarioInvalidoException();
		if (login.trim().equals("") || login == null)
			throw new LoginInvalidoException();
	}
	
	public String getLogin(){
		return login;
	}
	
	public abstract void recompensar(String nomeJogo, int scoreObtido, boolean zerou);
	
	public abstract void punir(String nomeJogo, int scoreObtido, boolean zerou);
}
