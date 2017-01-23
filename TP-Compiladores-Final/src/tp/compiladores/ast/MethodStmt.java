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
public class MethodStmt extends Statement{
    private MethodExpr methodExpr;
    private LinkedList<Expression> expression;
    private String methodId;
    private Type methodType;
    
    public MethodStmt(Expression expr, int row, int column){
        methodExpr = (MethodExpr) expr;
        expression =  methodExpr.getExpression();
        methodId = methodExpr.getMethodId();
        methodType = methodExpr.getMethodType();
        
        this.setIsMethodStmt(true);
        
        this.setLineNumber(row+1);
        this.setColumnNumber(column);
    }

    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
    
    @Override
    public String toString() {
            return methodId + " " + expression.toString() + ":" + methodType.toString();
    }

    /**
     * @return the expression
     */
    public LinkedList<Expression> getExpression() {
        return expression;
    }

    /**
     * @param expression the expression to set
     */
    public void setExpression(LinkedList<Expression> expression) {
        this.expression = expression;
    }

    /**
     * @return the methodId
     */
    public String getMethodId() {
        return methodId;
    }

    /**
     * @param methodId the methodId to set
     */
    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    /**
     * @return the methodType
     */
    public Type getMethodType() {
        return methodType;
    }

    /**
     * @param methodType the methodType to set
     */
    public void setMethodType(Type methodType) {
        this.methodType = methodType;
    }

    /**
     * @return the methodExpr
     */
    public MethodExpr getMethodExpr() {
        return methodExpr;
    }

    /**
     * @param methodExpr the methodExpr to set
     */
    public void setMethodExpr(MethodExpr methodExpr) {
        this.methodExpr = methodExpr;
    }
    
}
