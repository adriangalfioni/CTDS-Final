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
public class UnaryOpExpr extends Expression{
    private UnaryOpType operator; //operator in the expr = expr operator expr
    private Expression operand; //expression
    
    public UnaryOpExpr(Expression e, UnaryOpType op, int row, int column){
        operator = op;
        operand = e;
        
        this.setLineNumber(row+1);
        this.setColumnNumber(column);
    }


    /**
     * @return the operator
     */
    public UnaryOpType getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(UnaryOpType operator) {
        this.operator = operator;
    }

    /**
     * @return the operand
     */
    public Expression getOperand() {
        return operand;
    }

    /**
     * @param operand the operand to set
     */
    public void setOperand(Expression operand) {
        this.operand = operand;
    }
    
    @Override
    public String toString() {
            return operand + " " + operator;
    }
        
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
}
