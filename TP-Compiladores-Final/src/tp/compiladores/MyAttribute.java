/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores;

import java.util.LinkedList;
import tp.compiladores.ast.Type;

/**
 *
 * @author adrian
 */
public class MyAttribute {

    
    private String id;
    private Type type;
    private int length = -1;
    private int offset;
    private LinkedList<Type> list;
    
    // Constructor for variables
    public MyAttribute(String id, Type type, int offset, boolean param){
        this.list = new LinkedList<>();
        this.type = type;
        this.id=id;
        this.offset = offset;
    }
    
    // Constructor for arrays
    public MyAttribute(String id, Type type, int length){
        this.list = new LinkedList<>();
        this.type = type;
        this.length = length;
        this.id=id;
    }
    
    // Constructor for methods
    public MyAttribute(String id, Type returnType, LinkedList list){
        type = returnType;
        this.list = list == null ? new LinkedList<>() : list;
        this.id=id;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }
    
    /**
     * @return offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the list
     */
    public LinkedList getList() {
        return list;
    }
    
    public String whatAmI(){
        if (length != -1){
            return "array";
        }else{
            if (list != null){
                return "method";
            }else{
                return "variable";
            }
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }
    
    @Override
    public String toString(){
        String res = id+" "+type.toString();
        return res;
    }
}
