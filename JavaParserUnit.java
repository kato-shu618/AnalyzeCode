/**
 * JavaParserを使用し，Levelのmapに困難度の採点要素を抽出するためプログラム
 */

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

public class JavaParserUnit {
	
	private JavaParser jp = new JavaParser();
	private ParseResult<CompilationUnit> unit;
	private Optional<CompilationUnit> ast;
	private CompilationUnit cUnit;
	private Level level = new Level();
	
	private final String[] searchArray = {"String","int","boolean","char","double","ArrayList","User","for","while","if","Other"};
	
	public JavaParserUnit(String fileName){	
		try {
			Path source = Paths.get(fileName);
			this.unit = this.jp.parse(source);
			this.ast = this.unit.getResult();
			this.cUnit = this.ast.get();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public Level getLevel() {
		return this.level;
	}
	public void setLevel() {
		List<VariableDeclarationExpr> list = this.cUnit.findAll(VariableDeclarationExpr.class);
		System.out.println(list);
		for(int i = 0; i < list.size();i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("--------------------");
		setLevelList(list);

	}
	public void setLevelList(List<VariableDeclarationExpr> list) {
		int size = list.size();
		String parameterExpr = "";
		String className = "";
		for(int i = 0; i<size;i++) {
			parameterExpr = list.get(i).toString();
			int spaceIndexOf = parameterExpr.indexOf(" ");
			className = parameterExpr.substring(0,spaceIndexOf);			
			if(className.contains("<")) {
				spaceIndexOf = parameterExpr.indexOf("<");
				className = parameterExpr.substring(0,spaceIndexOf);
			}
			
			//出来ればこうしたい
//			for(String match : searchArray) {
//				if(className.equals(match)) {
//					this.level.setValue(match, parameterExpr);
//				}
//				//userに入れたい
//			}
			if(className.equals("String")) {
				this.level.setValue("String", parameterExpr);
			}else if(className.matches("int")) {
				this.level.setValue("int", parameterExpr);
			}else if(className.matches("boolean")) {
				this.level.setValue("boolean", parameterExpr);
			}else if(className.matches("char")) {
				this.level.setValue("char", parameterExpr);
			}else if(className.matches("double")) {
				this.level.setValue("double", parameterExpr);
			}else if(className.matches("ArrayList")) {
				this.level.setValue("ArrayList", parameterExpr);
			}else {
				this.level.setValue("User", parameterExpr);
			}
			
		}
		List<ForStmt> forList = this.cUnit.findAll(ForStmt.class);
		for(ForStmt forContent : forList) {
			this.level.setValue("for", forContent.toString());
		}
		List<WhileStmt> whileList = this.cUnit.findAll(WhileStmt.class);
		for(WhileStmt whileContent : whileList) {
			this.level.setValue("while", whileContent.toString());
		}
		List<IfStmt> ifList = this.cUnit.findAll(IfStmt.class);
		for(IfStmt ifContent : ifList) {
			this.level.setValue("if", ifContent.toString());
		}
	}
	
	public void printList() {	
		for(String key : this.searchArray) {
			System.out.println(key + " : " + this.level.getMap().get(key));
		}
	}
}
