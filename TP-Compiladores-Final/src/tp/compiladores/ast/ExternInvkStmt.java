/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.ast;

import java.util.LinkedList;
import tp.compiladores.ASTVisitor;

/**
 *
 * @author adrian
 */
public class ExternInvkStmt extends Statement {
    private String name;
    private Type type;
    private LinkedList<Object> params;
    private LinkedList<Expression> paramExp;
    
    public ExternInvkStmt(String name, Type type, LinkedList<Expression> params){
        this.name=name;
        this.type=type;
        paramExp=params;
    }
    
    public ExternInvkStmt(String name, Type type, LinkedList<Expression> params, int row, int column){
        this.name=name;
        this.type=type;
        paramExp=params;
        this.setLineNumber(row+1);
        this.setColumnNumber(column);
    }

    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the params
     */
    public LinkedList<Expression> getParams() {
        return paramExp;
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
}
