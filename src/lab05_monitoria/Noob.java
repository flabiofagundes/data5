package lab05_monitoria;

import exceptions.UsuarioInvalidoException;

public class Noob extends Usuario {

	public Noob(String nome, String login) throws UsuarioInvalidoException {
		super(nome, login);
	}

	@Override
	public void recompensar(String nomeJogo, int scoreObtido, boolean zerou) {
		Jogo jogo = procurarJogo(nomeJogo);
		
		//if (jogo.getJogabilidades().contains(Jogabilidade.OFFLINE))
			
		
	}

	@Override
	public void punir(String nomeJogo, int scoreObtido, boolean zerou) {
		// TODO Auto-generated method stub
		
	}

}
