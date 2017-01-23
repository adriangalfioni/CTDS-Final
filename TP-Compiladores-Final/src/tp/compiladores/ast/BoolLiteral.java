package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class BoolLiteral extends Literal {
	private String rawValue;
	private Boolean value;
	
	/*
	 * Constructor for bool literal that takes a string as an input
	 * @param: String boolean
	 */
	public BoolLiteral(String val){
		rawValue = val; // Will convert to bool value in semantic check
		value = Boolean.valueOf(val);
	}

	@Override
	public Type getType() {
		return Type.BOOLEAN;
	}

	public String getStringValue() {
		return rawValue;
	}

	public void setStringValue(String stringValue) {
		this.rawValue = stringValue;
	}

	public Boolean getValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public String getRawValue() {
		return rawValue;
	}

	public void setRawValue(String rawValue) {
		this.rawValue = rawValue;
	}

	@Override
	public String toString() {
		return rawValue;
	}

	@Override
	public <T> T accept(ASTVisitor<T> v) {
		return v.visit(this);
	}
}
