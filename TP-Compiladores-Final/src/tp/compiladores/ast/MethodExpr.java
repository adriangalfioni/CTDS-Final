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
public class MethodExpr extends Expression {
    private LinkedList<Expression> expression = new LinkedList<>();
    private String methodId;
    private Type methodType;
    private LinkedList<Type> tableSymParamsType;

    // MethodExpr contructor
    public MethodExpr(String id, Type type, LinkedList<Expression> expr, LinkedList<Type> listTableParam,int row, int column){
        methodType = type;
        methodId = id;
        expression=expr;
        tableSymParamsType =listTableParam;
        this.setLineNumber(row+1);
        this.setColumnNumber(column);
        this.setIsMethod(true);
        this.setIsExternInvk(false);
    }
    
    // ExternInvk constructor
    public MethodExpr(String meth, Type type,LinkedList<Expression> expr, boolean isExtInv,int row, int column){
        methodType = type;
        methodId = meth;
        expression=expr;
        this.setIsMethod(false);
        this.setIsExternInvk(isExtInv);
        this.setLineNumber(row+1);
        this.setColumnNumber(column);
    }
    
    // ExternInvk constructor
    
    // ExternInvk constructor
//    public MethodExpr(LinkedList<Expression> expr, boolean isExtInv,int row, int column){
//        StringLiteral meth = (StringLiteral) expr.get(0);
//        methodId = meth.getValue();
//        
//        StringLiteral type = (StringLiteral) expr.get(1);
//        String typeName = type.getValue();
//        Type t = null;
//        switch(typeName){
//            case "int":
//                t=Type.INT;
//            case "boolean":
//                t=Type.BOOLEAN;    
//            case "float":
//                t=Type.FLOAT;
//            case "string":
//                t=Type.STRING;
//        }
//        methodType = t;
//        
//        LinkedList<Expression> auxList = new LinkedList<>();
//        for(int i =2; i<expr.size(); i++){
//            auxList.add(expr.get(i));
//        }
//        expression=auxList;
//        
//        this.setIsExternInvk(isExtInv);
//        this.setLineNumber(row+1);
//        this.setColumnNumber(column);
//        this.setIsMethod(true);
//    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
    /*@Override
    public String toString() {
        String ret="";
        for (Expression e: expression){
            ret=ret+" "+e.toString();
        }
            return methodId + " " + ret + ":" + methodType.toString();
    }*/

    @Override
    public String getId(){
        return methodId;
    }
    
    public int getNumberOfParams(){
        int i = 0;
        Expression first=expression.getFirst();
        if(first.getIsMethod()){
            MethodExpr mExpr = (MethodExpr) first;
            i=i- mExpr.getNumberOfParams();
        }
        System.out.println("size esss: "+expression.size());
        i=i+expression.size();
        
        return i;
    }
    
    /**
     * @return the expression
     */
    public LinkedList<Expression> getExpression() {
        return expression;
    }
    
    public String toStringName(){
        String ret="(";
        for (Expression e: expression){
            ret=ret+e.getId()+" ";
        }
        ret=ret+")";
        return methodId + " " + ret + ":" + methodType.toString();
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
     * @return the tableSymParamsType
     */
    public LinkedList<Type> getTableSymParamsType() {
        return tableSymParamsType;
    }

    /**
     * @param tableSymParamsType the tableSymParamsType to set
     */
    public void setTableSymParamsType(LinkedList<Type> tableSymParamsType) {
        this.tableSymParamsType = tableSymParamsType;
    }
    
}
