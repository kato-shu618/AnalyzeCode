import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Level {
	
	private List<String> stringList = new ArrayList();
	private List<String> intList = new ArrayList();
	private List<String> booleanList = new ArrayList();
	private List<String> charList = new ArrayList();
	private List<String> doubleList = new ArrayList();
	private List<String> arrayListList = new ArrayList();
	private List<String> forList = new ArrayList();
	private List<String> whileList = new ArrayList();
	private List<String> ifList = new ArrayList();
	private List<String> UserList = new ArrayList();
	private HashMap<String,List<String>> hashMap = new HashMap<>();
	
	public Level() {
		hashMap.put("String" , this.stringList);
		hashMap.put("int" , this.intList);
		hashMap.put("boolean", this.booleanList);
		hashMap.put("char", this.charList);
		hashMap.put("double", this.doubleList);
		hashMap.put("ArrayList", this.arrayListList);
		hashMap.put("for", this.forList);
		hashMap.put("while", this.whileList);
		hashMap.put("if", this.ifList);
		hashMap.put("User", this.UserList);
	}
	public HashMap<String,List<String>> getMap(){
		return this.hashMap;
	}
	public void mapClear() {
		this.hashMap.clear();
	}
	public void setValue(String key , String parameterExpr) {
		this.hashMap.get(key).add(parameterExpr);
	}
}
