
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
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

public class ClassCatch {

	//hashMap (key:String etc , value:list)
	private HashMap<String , List<String>> hashMap = new HashMap<String , List<String>>();
	private List<String> stringList = new ArrayList();
	private List<String> intList = new ArrayList();
	private List<String> booleanList = new ArrayList();
	private List<String> charList = new ArrayList();
	private List<String> doubleList = new ArrayList();
	private List<String> arrayLists = new ArrayList();
	private List<String> userCreateList = new ArrayList();
	
	public static void main(String[] args) {
		
		
		Path source = Paths.get("C:/Users/katoushu/eclipse-workspace/Research/src/QFile/QNo1.java");
		//Path source = Paths.get("C:/Users/katoushu/eclipse-workspace/Research/src/Test1.java");
		JavaParser jp = new JavaParser();
		
		try {
			ParseResult<CompilationUnit> unit = jp.parse(source);
			Optional<CompilationUnit> ast = unit.getResult();
			CompilationUnit cUnit = ast.get();
			
			List<VariableDeclarationExpr> list1 = cUnit.findAll(VariableDeclarationExpr.class);
			System.out.println(list1);
			System.out.println();
			for(int i = 0;i < list1.size();i++) {
				System.out.println(list1.get(i));
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void createParameterMap(List<VariableDeclarationExpr> list) {
		String parameterExpr = "";
		String className = "";
		for(int i = 0; i<list.size();i++) {
			parameterExpr = list.get(i).toString();
			int spaceIndex = parameterExpr.indexOf(" ");
			className = parameterExpr.substring(0,spaceIndex);			
			if(className.contains("<")) {
				spaceIndex = parameterExpr.indexOf("<");
				className = parameterExpr.substring(0,spaceIndex);
			}
			
			if(className.equals("String")) {
				
			}
		}
	}
}