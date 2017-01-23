package tp.compiladores.ast;

public enum Type {
	INT,
	INTARRAY,
	VOID,
	UNDEFINED,
        BOOLEAN,
        ERROR,
        FLOAT,
        STRING;
	
	@Override
	public String toString() {
		switch(this) {
			case INT:
				return "int";
			case VOID:
				return "void";
			case UNDEFINED:
				return "undefined";
			case INTARRAY:
				return "int[]";
                        case BOOLEAN: 
                                return "boolean";
                        case FLOAT:
                                return "float";
                        case ERROR:
                                return "error";
                        case STRING:
                                return "string";
                }
		
		return null;
	}
	
	public boolean isArray() {
		if (this == Type.INTARRAY) {
			return true;
		}
		
		return false;
	}
}
