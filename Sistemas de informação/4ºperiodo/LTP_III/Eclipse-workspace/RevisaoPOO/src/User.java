public abstract class User {
	private String nome;
	private int id; 
	private String birthDate;
	
	protected User(int id) {
		this.id = id;		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String formatPersonalData (){
		//return "ID: " + this.id + " Nome: " + this.nome;
		//Mesmo metodo de formas diferentes
		return String.format("ID: %d\nNome: %s", this.id, this.nome);
	}
	
	
	
	
	
}
