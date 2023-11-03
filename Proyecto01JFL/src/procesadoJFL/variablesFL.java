package procesadoJFL;

public enum variablesFL {
	time(40),help(3),mistakes(3), checkLevel(10);
	
	int valorMaximo;
	
	
	private variablesFL(int valor) {
		this.valorMaximo = valor;
	}
	
	public int getValorMaximo() {
		return this.valorMaximo;
	}
}
