/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.ast;

import tp.compiladores.ASTVisitor;

/**
 *
 * @author adrian
 */
public class StringLiteral extends Literal {
    private String value;
    private String rawValue;
    public StringLiteral(String val){
		rawValue = val; // Will convert to string value in semantic check
		value = val;
	}
    
    @Override
    public Type getType() {
        return Type.STRING;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @return the rawValue
     */
    public String getRawValue() {
        return rawValue;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @param rawValue the rawValue to set
     */
    public void setRawValue(String rawValue) {
        this.rawValue = rawValue;
    }
    
    @Override
    public String toString(){
        return this.value.toString();
        
    }
}
