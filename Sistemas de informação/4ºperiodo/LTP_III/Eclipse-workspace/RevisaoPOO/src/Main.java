public class Main {

	public static void main(String[] args) {
		
		Student maria = new Student(1, 999);
		maria.setNome("Maria");
		maria.setBirthDate("11/05/1999");
		maria.setCourse("Sistemas de informação");
		maria.setSemester((short)4);
		
		
		
		TechnicalAdministrative julia = new TechnicalAdministrative(23, "988");
		julia.setNome("julia");
		julia.setLevel("TI");
		julia.setArea("Tecnica e laboratorio");
		
		printUserData(maria);
		printUserData(julia);
	}
	
	private static void printUserData(User user) {
		System.out.println(user.formatPersonalData());
		System.out.println("\n");
	}

}
