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
public class MethodDecl extends Statement{

    private String id;
    private Type methType;
    private Block block;
    private LinkedList<Type> parmsType;
    
    public MethodDecl(String id, Type type, LinkedList<Type> parametersType, Block b,int row, int column){
        this.id=id;
        methType=type;
        block=b;
        parmsType=parametersType;
        
        this.setLineNumber(row);
        this.setColumnNumber(column);
    }
    
    @Override
    public <T> T accept(ASTVisitor<T> v) {
        return v.visit(this);
    }
    
    @Override
    public String toString() {
        return methType.toString()+" "+getId()+"(parameters){bloque}";
    }

    /**
     * @return the methType
     */
    public Type getMethType() {
        return methType;
    }

    /**
     * @return the block
     */
    public Block getBlock() {
        return block;
    }

    /**
     * @return the parmsType
     */
    public LinkedList<Type> getParmsType() {
        return parmsType;
    }

    /**
     * @param parmsType the parmsType to set
     */
    public void setParmsType(LinkedList<Type> parmsType) {
        this.parmsType = parmsType;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
}
