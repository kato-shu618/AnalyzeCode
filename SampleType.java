import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SampleType {
	public static void main(String[] args) {
		
		String s = getString();
		int i = 0;
		T01 t01 = new T01(s, i);
		t01.setString(s);
		i = t01.getInt();
		
		boolean b = false;
		char c = 0;
		long l = 0;
		double d = 0.0;
		ArrayList<String> list = new ArrayList<String>();
		List list2 = new ArrayList<>();
		int[] j = {0, 1, 2, 4}; 
		System.out.println(Integer.MIN_VALUE);
		
		Path source = Paths.get("src/Test_2.java");
	}
	protected enum Enum1{
		SPADE, HATO, CLOVER, DIAMOND
	};
	protected enum Enum2{
		FLAME, WATER, GROUND, WOOD
	};
	public static String getString() {
		return "LIVE";
	};
}
