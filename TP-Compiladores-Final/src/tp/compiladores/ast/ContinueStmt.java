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
public class ContinueStmt extends Statement {

    public ContinueStmt(){
        this.setIsContinueStmt(true);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
