package procesadoJFL;



public enum Dificultad {
	facil("facil"),normal("normal"),dificil("dificil");
	
	
	private String dificultad;
	
	private Dificultad(String dificultad) {
		this.dificultad = dificultad;
	}
	
	public String toString() {
		return dificultad;
	}
	
	
	
}
