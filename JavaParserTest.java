import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.ArrayCreationLevel;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.SimpleName;
import com.github.javaparser.ast.stmt.CatchClause;
import com.github.javaparser.ast.type.VarType;
import com.github.javaparser.metamodel.SimpleNameMetaModel;
import com.github.javaparser.resolution.MethodUsage;

public class JavaParserTest {

	public static void main(String[] args) {
		Path path = Paths.get("src/Example2.java");
		JavaParser jp = new JavaParser();
		try {
			ParseResult<CompilationUnit> unit = jp.parse(path);
			Optional<CompilationUnit> ast = unit.getResult();
			CompilationUnit compilationUnit = ast.get();
			
			List<SimpleName> list = compilationUnit.findAll(SimpleName.class);
			System.out.println(list.toString());
			for(int i = 0; i< list.size();i++) {
				System.out.println(list.get(i).getClass().getSimpleName());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
