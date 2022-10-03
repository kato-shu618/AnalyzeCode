import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ArrayAccessExpr;
import com.github.javaparser.ast.expr.BooleanLiteralExpr;
import com.github.javaparser.ast.expr.CharLiteralExpr;
import com.github.javaparser.ast.expr.ClassExpr;
import com.github.javaparser.ast.expr.EnclosedExpr;
import com.github.javaparser.ast.expr.IntegerLiteralExpr;
import com.github.javaparser.ast.expr.Name;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.NullLiteralExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.ThisExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.modules.ModuleDeclaration;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

public class ClassCatchTest {

	private static List<String> stringList = new ArrayList();
	private static List<String> intList = new ArrayList();
	private static List<String> booleanList = new ArrayList();
	private static List<String> charList = new ArrayList();
	private static List<String> doubleList = new ArrayList();
	private static List<String> arrayListList = new ArrayList();
	private static List<String> userCreateList = new ArrayList();
	//hashMap (key:String etc , value:list)
	//List = new ArrayList();
	
	public static void main(String[] args) {
			

		
	//path指定
	Path source = Paths.get("src/Test1.java");
		
	//String fileName = 	"C:/Users/katoushu/eclipse-workspace/Research/checkFile/";
	//Path source = Paths.get("C:/Users/katoushu/eclipse-workspace/Research/checkFile/B2_1.java");
	//Path source = Paths.get("C:/Users/katoushu/eclipse-workspace/Research/src/QFile/QNo1.java");
	
	//コマンドラインで実行する用
	//eclipseはeclipse-workspace\Researchで実行されている
	//Path source = Paths.get("FriedFood.java");
	
	//JavaPaserインスタンス作成
	JavaParser jp = new JavaParser();
	
	try {
		ParseResult<CompilationUnit> unit = jp.parse(source);
		
		//構造木取得
		Optional<CompilationUnit> ast = unit.getResult();
		CompilationUnit compilationUnit = ast.get();
		
		/*simpleName
		List<SimpleName> simpleNameList = compilationUnit.findAll(SimpleName.class);
		for(int i = 0; i<simpleNameList.size();i++) {
			System.out.println(simpleNameList.get(i));
		}
		*/
		System.out.println("---");
		List<Parameter> list = compilationUnit.findAll(Parameter.class);
		for(int i = 0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		List<StringLiteralExpr> list1 = compilationUnit.findAll(StringLiteralExpr.class);
		for(int i = 0 ; i< list.size();i++) {
			System.out.println(list1.get(i));
		}
		
		/*
		System.out.println("---");
		List<NameExpr> list2 = compilationUnit.findAll(NameExpr.class);
		for(int i = 0; i< list.size();i++) {
			System.out.println(list2.get(i));
			System.out.println(list2.get(i).getClass());
		}
		*/
		
		
		System.out.println("-----");
		List<VariableDeclarationExpr> list3 = compilationUnit.findAll(VariableDeclarationExpr.class);
		System.out.println(list3.size());
		System.out.println(list3);
		for(int i = 0; i< list3.size();i++) {
			//System.out.println(list3.get(i));	
		}
		createParameterList(list3);
		System.out.println("------");
		List<ObjectCreationExpr> list4 = compilationUnit.findAll(ObjectCreationExpr.class);
		for(int i = 0; i < list4.size();i++) {
			System.out.println(list4.get(i));
		}
		
		System.out.println("コンストラクタ");
		List<ConstructorDeclaration> constList = compilationUnit.findAll(ConstructorDeclaration.class);
		System.out.println(constList.size());
		System.out.println(constList);
		
		System.out.println("\nModule");
		List<MethodDeclaration> methodList = compilationUnit.findAll(MethodDeclaration.class);
		System.out.println(methodList.size());
		System.out.println(methodList);
		
		System.out.println("privateを取りたい");
		List<ThisExpr> enclosedList = compilationUnit.findAll(ThisExpr.class);
		System.out.println(enclosedList);
		
		System.out.println("object取得");
		List<ObjectCreationExpr> objectList = compilationUnit.findAll(ObjectCreationExpr.class);
		System.out.println(objectList);
		
		System.out.println("--------");
		System.out.println("access");
		List<FieldDeclaration> accessList = compilationUnit.findAll(FieldDeclaration.class);
		System.out.println(accessList);
		
		System.out.println("---------------------\n");
		System.out.println("String:" + stringList.size());
		System.out.println(stringList);
		System.out.println("int:" + intList.size());
		System.out.println(intList);
		System.out.println("boolean:" + booleanList.size());
		System.out.println(booleanList);
		System.out.println("char:" + charList.size());
		System.out.println(charList);
		System.out.println("double:" + doubleList.size());
		System.out.println(doubleList);
		System.out.println("ArrayList:" + arrayListList.size());
		System.out.println(arrayListList);
		System.out.println("UserCreateClass:" + userCreateList.size());
		System.out.println(userCreateList);


	}catch(IOException e){
		e.printStackTrace(System.err);
	}	
	}
	public static void createParameterList(List<VariableDeclarationExpr> list) {
		int size = list.size();
		String parameterExpr = "";
		String className = "";
		for(int i = 0; i<size;i++) {
			parameterExpr = list.get(i).toString();
			int spaceIndexOf = parameterExpr.indexOf(" ");
			className = parameterExpr.substring(0,spaceIndexOf);			
			if(className.contains("<")) {
				System.out.println("< is contained");
				spaceIndexOf = parameterExpr.indexOf("<");
				className = parameterExpr.substring(0,spaceIndexOf);
			}
			
			if(className.equals("String")) {
				stringList.add(parameterExpr);
			}else if(className.matches("int")) {
				intList.add(parameterExpr);
			}else if(className.matches("boolean")) {
				booleanList.add(parameterExpr);
			}else if(className.matches("char")) {
				charList.add(parameterExpr);
			}else if(className.matches("double")) {
				doubleList.add(parameterExpr);
			}else if(className.matches("ArrayList")) {
				arrayListList.add(parameterExpr);
			}else {
				userCreateList.add(parameterExpr);
			}
			
			//System.out.println(i + ":" + parameterExpr);
			//System.out.println("space:" + spaceIndexOf);
			//System.out.println("substring:" + className);
		}
	}

}

