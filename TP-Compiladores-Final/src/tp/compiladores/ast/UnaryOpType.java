/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.ast;

/**
 *
 * @author adrian
 */
public enum UnaryOpType {
    MINUS,
    NOT;
    
    @Override
	public String toString() {
		switch(this) {
			case NOT:
				return "!";
			case MINUS:
				return "-";
                }
                return null;
        }
}
