/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores;


import com.sun.java_cup.internal.runtime.Symbol;
import java.util.*;
import tp.compiladores.ast.Type;

/**
 *
 * @author adrian
 */
public class Ent {
  
    private Hashtable table;
    private Ent prev;
    //LinkedList<String> list = new LinkedList<String>();
    
    
    public Ent(Ent p) {
        table = new Hashtable();
        prev = p;
        
    }
    
    /*
    decl -> tipo id;
    {s=new Symbol;
    s.type=tipo.lexema
    sup.put(id.lexema,s)}
    */
    
    //String s es el nombre de la variable
    public void put(String s, Object info){
        Symbol sim = new Symbol(1, info);
        //System.out.println(this.table);
        if (table.containsKey(s)){
            //ERROR identificador definido en ese nivel
        }else{
            table.put(s, sim);
        }
    }
    
    public Symbol get(String s){
        for( Ent e = this; e != null; e = e.prev){
            Symbol found = (Symbol)(e.table.get(s));
            if(found != null){
                return found;
            }
        }
        return null;
    }
    
    
    public void show(){
        for( Ent e = this; e != null; e = e.prev){
            Enumeration enume = e.table.keys();
            while(enume.hasMoreElements()){
                String key = (String) enume.nextElement();
                System.out.print(key);
            }
        }
        for( Ent e = this; e != null; e = e.prev){
            Enumeration enumee = e.table.elements();
            while(enumee.hasMoreElements()){
                Symbol sim = (Symbol) enumee.nextElement();
                MyAttribute asd = (MyAttribute) sim.value;
                System.out.println(asd.toString());
            }
        }
    }
    
    public void showCurrent(){
        if (!table.isEmpty()){
            Enumeration enume = this.table.keys();
            while(enume.hasMoreElements()){
                String key = (String) enume.nextElement();
                System.out.println(key);
            }
        }
    }
    
    public Ent getPrev(){
        return prev;
    }
    
    public static void main(String[] args){
        Ent sup=null;
        MyAttribute intAtr = new MyAttribute("y",Type.INT);
        MyAttribute asd = new MyAttribute("asd",Type.BOOLEAN);
        
        
        Ent one = new Ent(sup);
        
        one.put("y", intAtr);
        one.put("x", intAtr);
        

        
        Ent two = new Ent(one);

        two.put("x", intAtr);
        
        Ent three = new Ent(two);

        
        three.put("x", asd);
        
        
        three.put("y", intAtr);
                
        three.put("asd", asd);
        
        
        
        three.show();
    }
}






