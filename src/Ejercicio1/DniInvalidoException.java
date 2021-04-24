package Ejercicio1;

import java.io.IOException;

public class DniInvalidoException extends IOException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 7140696805745266796L;

	public DniInvalidoException()
	{
		
	}

	@Override
	public String getMessage() {
		
		return "DNI invalido, no es numérico";
	}

}
