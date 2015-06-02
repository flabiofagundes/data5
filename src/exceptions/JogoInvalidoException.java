package exceptions;

public class JogoInvalidoException extends IllegalArgumentException {
	
	public JogoInvalidoException(String mensagem) {
		super(mensagem);
	}

}
