package model;

public class Departaments {

	private int id;
	private String name, description, phone;
	private int employeeCount;
	private User departmentHead;
	
	public Departaments() {
		this(0);
	}
	
	
	public Departaments(int id) {
		this.id = id;
		setName("");
		setDescription("");
		setPhone("");
		setEmployeeCount(0);
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
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getEmployeeCount() {
		return employeeCount;
	}
	public void setEmployeeCount(int employee_count) {
		this.employeeCount = employee_count;
	}
	public User getDepartmentHead() {
		return departmentHead;
	}
	public void setDepartmentHead(User department_head) {
		this.departmentHead = department_head;
	}
		
}
