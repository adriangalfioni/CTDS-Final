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
public class FieldStmt extends Statement {
    private Field field;
    
    
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
