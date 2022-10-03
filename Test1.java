import java.util.ArrayList;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		ArrayList<String> testList = new ArrayList<String>();
		Student student1 = new Student();
		student1.setName("yamada tarou");
		student1.setId("00aj001");
		String name1 = "tanaka";
		String name2 = "satoshi";
		System.out.println(student1.getId() + "\n" + student1.getName());
		
		Student student2 = new Student();
		student2.setName(name1 + name2);
		student2.setId("00aj001");
		studentList.add(student1);
		studentList.add(student2);
		
		
	}
	public static void sum(int num) {
		int i = 0;
	}

}
