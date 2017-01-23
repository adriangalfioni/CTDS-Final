package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

public class FloatLiteral extends Literal {
	private String rawValue;
	private Float value;
	
	/*
	 * Constructor for float literal that takes a string as an input
	 * @param: String integer
	 */
	public FloatLiteral(String val){
		rawValue = val; // Will convert to float value in semantic check
		value = new Float(val);
	}

	@Override
	public Type getType() {
		return Type.FLOAT;
	}

	public String getStringValue() {
		return rawValue;
	}

	public void setStringValue(String stringValue) {
		this.rawValue = stringValue;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(float value) {
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
