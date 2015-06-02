package exceptions;

public class UsuarioInvalidoException extends IllegalArgumentException {
	
	public UsuarioInvalidoException(String mensagem) {
		super(mensagem);
	}

}
