import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;

public class Main {
	public static void main(String[] args) {
			
		//path指定
		Path source = Paths.get("src/Example1.java");
		
		//JavaPaserインスタンス作成
		JavaParser jp = new JavaParser();
		
		try {
			ParseResult<CompilationUnit> unit = jp.parse(source);
			/*
			System.out.println("*****");
			System.out.println(unit);
			System.out.println("*****");
			*/
			
			//構造木取得
			Optional<CompilationUnit> ast = unit.getResult();
			CompilationUnit compilationUnit = ast.get();
									
			List<ForStmt> forList = compilationUnit.findAll(ForStmt.class);
			int forCount = forList.size();
			System.out.println(forList);
			
			List<IfStmt> ifList = compilationUnit.findAll(IfStmt.class);
			int ifCount = ifList.size();
			
			List<WhileStmt> whileList = compilationUnit.findAll(WhileStmt.class);
			int whileCount = whileList.size();
			
			System.out.println(forCount);
			//System.out.println(forList.get(1));		
			System.out.println(ifCount);
			System.out.println(whileCount);
			

		}catch(IOException e){
			e.printStackTrace(System.err);
		}
		
	}
}
