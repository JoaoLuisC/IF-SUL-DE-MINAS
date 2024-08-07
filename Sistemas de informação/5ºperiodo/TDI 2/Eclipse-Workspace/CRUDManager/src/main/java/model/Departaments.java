package model;

public class Departaments {

	private int id;
	private String name, email, fone, gender;
	private Company company;

	public Departaments() {
		this(0);
	}

	public Departaments(int id) {
		this.id = id;
		setName("");
		setEmail("");
		setGender("");
		setFone("");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String nome) {
		this.name = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "ChiefExecutiveOfficer [id=" + id + ", name=" + name + ", email=" + email + ", fone=" + fone
				+ ", gender=" + gender + ", company=" + company + "]";
	}
		
}
