package tp.compiladores.ast;


public abstract class Field extends AST {
	protected Field field;
	protected Type type;
	
        
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type t) {
		this.type = t;
	}
}