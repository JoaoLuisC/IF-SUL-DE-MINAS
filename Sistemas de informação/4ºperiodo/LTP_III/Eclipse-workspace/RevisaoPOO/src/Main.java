

public class Main {

	public static void main(String[] args) {
		
		Student maria = new Student(1, 999);
		maria.setNome("Maria");
		maria.setBirthDate("11/05/1999");
		maria.setCourse("Sistemas de informação");
		maria.setSemester((short)4);
		
		Student jose = new Student(2, 888);
		jose.setNome("Jose");
		jose.setBirthDate("21/02/2001");
		jose.setCourse("Agronomia");
		jose.setSemester((short)8);
		
		System.out.println(maria.toString() + "\n" + maria.formatPersonalData());
		System.out.println("\n");
		System.out.println(jose.toString() + "\n" + jose.formatPersonalData());
		
	}

}
