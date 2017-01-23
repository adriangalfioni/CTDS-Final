package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class WhileStmt extends Statement {
	private Expression condition;
	private Block whileBlock;
	
	public WhileStmt(Expression cond, Block whBlock, int row, int column) {
		this.condition = cond;
		this.whileBlock = whBlock;
                this.setLineNumber(row+1);
                this.setColumnNumber(column);
	}
	

	public Expression getCondition() {
		return condition;
	}

	public void setCondition(Expression condition) {
		this.condition = condition;
	}
        
            /**
     * @return the whileBlock
     */
    public Block getWhileBlock() {
        return whileBlock;
    }

    /**
     * @param whileBlock the whileBlock to set
     */
    public void setWhileBlock(Block whileBlock) {
        this.whileBlock = whileBlock;
    }
	
	@Override
	public String toString() {
		String rtn = "while " + condition + '\n' + whileBlock.toString();
		return rtn;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}


}
