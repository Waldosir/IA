package procesadoJFL;



public enum dificultades {
	facil("facil"),normal("normal"),dificil("dificil");
	
	
	private String dificultad;
	
	private dificultades(String dificultad) {
		this.dificultad = dificultad;
	}
	
	public String toString() {
		return dificultad;
	}
	
	
	
}
