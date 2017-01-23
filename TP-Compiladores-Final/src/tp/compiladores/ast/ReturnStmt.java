package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class ReturnStmt extends Statement {
	private Expression expression; // the return expression
	
	public ReturnStmt(Expression e) {
		this.expression = e;
                this.setIsReturnStmt(true);
	}
	
	public ReturnStmt() {
		this.expression = null;
                this.setIsReturnStmt(true);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString() {
		if (expression == null) {
			return "return";
		}
		else {
			return "return " + expression;
		}
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
