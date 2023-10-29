package procesadoJFL;

public enum variablesFL {
	time("time"),help("help"),mistakes("mistakes"), checkLevel("checkLevel");
	String valor;
	private variablesFL(String valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return this.valor;
	}

}
