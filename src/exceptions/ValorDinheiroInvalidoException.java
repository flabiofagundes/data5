package exceptions;

public class ValorDinheiroInvalidoException extends IllegalArgumentException {

	public ValorDinheiroInvalidoException() {
		super("Valor nao pode ser negativo");
	}
}
