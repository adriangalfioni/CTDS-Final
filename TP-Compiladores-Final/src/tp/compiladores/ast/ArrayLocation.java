package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class ArrayLocation extends Location {
	private int blockId;
        private Expression expr;
        private Type type;
        private String id;
        private int offset;

	public ArrayLocation(String id, Expression expr, Type t, int row, int column) {
		this.id = id;
                this.expr = expr;
		this.blockId = -1;
                this.type=t;
                this.setIsArrayLocation(true);
                this.setLineNumber(row+1);
                this.setColumnNumber(column);
                int length = ((IntLiteral) expr).getValue();
                count += length;
                this.offset = count*4;
	}
	
	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}
	
	@Override
	public String toString() {
		return getId()+"["+getExpr()+"]";
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the expr
     */
    public Expression getExpr() {
        return expr;
    }

    /**
     * @param expr the expr to set
     */
    public void setExpr(Expression expr) {
        this.expr = expr;
    }

    /**
     * @return the type
     */
        @Override
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
        @Override
    public void setType(Type type) {
        this.type = type;
    }
}
