import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class JavaExtractor {

    static String identifiers = "";

    public static void main(String[] args) {
        try {
            File input = new File(args[0]);
            parse(input);
        } catch (IOException e) {
            System.out.println("Something is wrong with the parsing");
        }
    }

    public static void parse(File file) throws IOException {

        CharStream in = CharStreams.fromFileName(file.getPath());

        // Tokenize the input file
        Java8Lexer lexer = new Java8Lexer(in);

        // Build a parse tree
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Java8Parser parser = new Java8Parser(tokens);
        ParserRuleContext tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();// create standard walker
        IdentifierListener extractor = new IdentifierListener();
        walker.walk(extractor,tree);// initiatewalkof treewithlistener
    }
}
