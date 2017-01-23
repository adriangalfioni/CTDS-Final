package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class ForStmt extends Statement {
        private Location id;
        private Expression initial;
	private Expression end;
	private Block forBlock;
	
	public ForStmt(Location i, Expression initVal, Expression finalVal, Block block, int row, int column){
            this.id = i;
            this.initial = initVal;
            this.end = finalVal;
            this.forBlock = block;
            this.setLineNumber(row+1);
            this.setColumnNumber(column);
        }
	
        
	
	
	@Override
	public String toString() {
		String rtn = "for (" + id + ","+initial.toString()+","+end.toString()+")\n"+ forBlock.toString();
		return rtn;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    /**
     * @return the id
     */
    public Location getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Location id) {
        this.id = id;
    }

    /**
     * @return the initial
     */
    public Expression getInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(Expression initial) {
        this.initial = initial;
    }

    /**
     * @return the end
     */
    public Expression getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Expression end) {
        this.end = end;
    }

    /**
     * @return the forBlock
     */
    public Block getForBlock() {
        return forBlock;
    }

    /**
     * @param forBlock the forBlock to set
     */
    public void setForBlock(Block forBlock) {
        this.forBlock = forBlock;
    }


}
