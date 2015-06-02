package lab05_monitoria;

import java.util.HashSet;

import exceptions.JogabilidadesInvalidaException;
import exceptions.JogoInvalidoException;
import exceptions.LoginInvalidoException;
import exceptions.NomeJogoInvalidoException;
import exceptions.NomeUsuarioInvalidoException;
import exceptions.PrecoInvalidoException;

public abstract class Jogo {
	
	protected String nome;
	private double preco;
	private int maior_score;
	private int jogadas;
	private int zeradas;
	private HashSet<Jogabilidade> jogabilidades;
	
	public Jogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws JogoInvalidoException{
		validarJogo(nome, preco, jogabilidades);
		
		this.nome = nome;
		this.preco = preco;
		this.jogabilidades = jogabilidades;
		maior_score = 0;
		jogadas = 0;
	}
	
	public void jogar(int score, boolean zerou){
		if (score > maior_score)
			maior_score = score;
		if (zerou)
			zeradas++;
		
		jogadas++;
		
	}
	
	public double getPreco(){
		return preco;
	}
	
	public double getMaiorScore(){
		return maior_score;
	}
	
	public HashSet<Jogabilidade> getJogabilidades(){
		return jogabilidades;
	}
	
	private void validarJogo(String nome, double preco, HashSet<Jogabilidade> jogabilidades) throws JogoInvalidoException {
		if (nome.trim().equals("") || nome == null)
			throw new NomeJogoInvalidoException();
		if (preco <= 0)
			throw new PrecoInvalidoException();
		if (jogabilidades == null)
			throw new JogabilidadesInvalidaException();
	}
}
