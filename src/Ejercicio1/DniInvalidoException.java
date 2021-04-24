package Ejercicio1;

public class DniInvalidoException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DniInvalidoException()
	{
		
	}

	@Override
	public String getMessage() {
		
		return "DNI invalido, no es numérico";
	}

}
