package exceptions;

public class NomeUsuarioInvalidoException extends UsuarioInvalidoException {
	
	public NomeUsuarioInvalidoException() {
		super("Nome invalido!");
	}

}
