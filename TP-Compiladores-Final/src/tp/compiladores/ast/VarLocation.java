package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class VarLocation extends Location {

    private int blockId;
    private int offset;
    private boolean onlyLocation;

    public VarLocation(String id, Type type, int offset, int row, int column, boolean onlyLocation) {
        this.id = id;
        this.setType(type);
        this.blockId = -1;
        this.setIsArrayLocation(false);
        this.setLineNumber(row + 1);
        this.setColumnNumber(column);
        this.onlyLocation = onlyLocation;

        this.offset = offset;

    }

    public VarLocation(String string) {
        this.id = string;
    }

    // Used in I3D
    public VarLocation(String string, int offset) {
        this.offset = offset;
        this.id = string;
    }

    public int getBlockId() {
        return blockId;
    }
    
    public boolean getIsOnlyLocation(){
        return onlyLocation;
    }
    

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

}
