import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class IdentifierListener extends Java8BaseListener {

    private List<String> className = new ArrayList<String>();

    @Override
    public void enterMethodDeclarator(Java8Parser.MethodDeclaratorContext ctx) {
        System.out.println("method: " + ctx.Identifier());
    }


    @Override
    public void enterNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        className.add(ctx.Identifier().toString());
        String c = className.stream().map(Object::toString).collect(Collectors.joining("$")).toString();
        System.out.println("class: " + c);
    }

    @Override
    public void exitNormalClassDeclaration(Java8Parser.NormalClassDeclarationContext ctx) {
        // System.out.println("class: " + ctx.Identifier());
        className.remove(className.size() - 1);
    }


}
