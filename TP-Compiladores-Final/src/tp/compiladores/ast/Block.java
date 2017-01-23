package tp.compiladores.ast;

import java.util.ArrayList;
import java.util.List;
import tp.compiladores.ASTVisitor;

public class Block extends Statement {
	private List<Statement> statements;
	private List<String> fields;
        private int blockId;
        private boolean inCycleB = false;
	
	public Block(int bId) {
		statements = new ArrayList<Statement>();
                fields = new ArrayList<String>();
		blockId = bId;
	}
        
        	
	public Block(int bId, List<Statement> s, List<String> f) {
		blockId = bId;
		statements = s;
                fields = f;
	}
	
	public void addStatement(Statement s) {
		this.statements.add(s);
	}
		
	public List<Statement> getStatements() {
		return this.statements;
	} 
		
	public int getBlockId() {
		return blockId;
	}

	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	@Override
	public String toString() {
		String rtn = "";
	    for (Statement s: statements) {
			rtn += s.toString() + '\n';
		}
		
		if (rtn.length() > 0) return rtn.substring(0, rtn.length() - 1); // remove last new line char
		
		return rtn; 
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}

    /**
     * @return the fields
     */
    public List<String> getFields() {
        return fields;
    }

    /**
     * @return the inCycleB
     */
    public boolean isInCycleB() {
        return inCycleB;
    }

    /**
     * @param inCycleB the inCycleB to set
     */
    public void setInCycleB(boolean inCycleB) {
        this.inCycleB = inCycleB;
    }
	
}
