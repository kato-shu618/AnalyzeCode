public class MainTest {

	public static void main(String[] args) {
		String fileName = "C:/Users/katoushu/eclipse-workspace/Research/checkFile/Test1.java";
		
		JavaParserUnit jpUnit = new JavaParserUnit(fileName);
		jpUnit.setLevel();
		jpUnit.printList();
	}

}
