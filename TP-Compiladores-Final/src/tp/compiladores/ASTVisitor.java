package tp.compiladores;

import tp.compiladores.ast.*;

// Abstract visitor
public interface ASTVisitor<T> {
// visit statements
	T visit(AssignStmt stmt);
	T visit(ReturnStmt stmt);
	T visit(IfStmt stmt);
        T visit(WhileStmt stmt);
        T visit(ForStmt stmt);
        T visit(BreakStmt stmt);
        T visit(ContinueStmt stmt);
        T visit(PuntoYComaStmt stmt);
        T visit(MethodStmt methStmt);
        T visit(ExternInvkStmt extInvStmt);
       // T visit(ExternInvkStmt extStmt);
	
// visit block       
        T visit(Block block);
        
// visit expressions
	T visit(BinOpExpr expr);
        T visit(UnaryOpExpr unaryExpr);
        T visit(MethodExpr methExpr);
	
// visit literals	
	T visit(IntLiteral lit);
        T visit(BoolLiteral lit);
        T visit(FloatLiteral lit);
        T visit(StringLiteral lit);
// visit locations	
	T visit(VarLocation loc);
        T visit(ArrayLocation arrLoc);
// visit methodDecl
        T visit(MethodDecl methD);
}
