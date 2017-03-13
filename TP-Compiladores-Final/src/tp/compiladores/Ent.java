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
    
    //Tabla de símbolos
    private Hashtable table;
    //Entorno padre
    private Ent prev;
    //Identificador del entorno
    private String id;
    
    /*
    * Crea un nuevo entorno con su hashtable y un entorno padre
    * si es el primer entorno del programa, su padre es null.
    */
    public Ent(Ent parent) {
        table = new Hashtable();
        prev = parent;
    }
    
    public Ent(Ent parent, String name){
        table = new Hashtable();
        prev = parent;
        id = name;
    }
    
       
    /*
    Agrega una variable al entorno.
    name es el nombre de la variable
    type es el tipo de la variable
    */
    //String s es el nombre de la variable
    public void put(String name, Object type){
        //Crea un símbolo auxiliar que es agregado a la tabla de símbolos con su nombre como clave.
        Symbol sim = new Symbol(1, type);
        //Si ya existe una variable con el mismo nombre en la tabla de este entorno, comunicamos el error.
        if (table.containsKey(name)){
            throw new RuntimeException("Symbol already defined \""+name+"\"");
        //Sino, agrega la variable a la tabla con el nombre como clave y el símbolo como valor
        }else{
            table.put(name, sim);
        }
    }
    
    /**
     * Devuelve el símbolo asociado a la clave pasada como parámetro
     * @param key
     * @return el símbolo si es que existe en el entorno actual
     */
    public Symbol get(String key){
        for( Ent e = this; e != null; e = e.prev){
            Symbol found = (Symbol)(e.table.get(key));
            if(found != null){
                return found;
            }
        }
        
        return null;
    }
    
    
    public void show(){
        for( Ent e = this; e != null; e = e.prev){
            Enumeration enume = e.table.keys();
            System.out.println("tp.compiladores.Ent.show() -- Entorno "+ e.id);
            while(enume.hasMoreElements()){
                String key = (String) enume.nextElement();
                System.out.print(key+ " ");
            }
            System.out.println(" ");
        }
    }
    
    public void showCurrent(){
        System.out.println("tp.compiladores.Ent.show() -- Entorno "+ this.id);
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
        MyAttribute intAtr = new MyAttribute("y",Type.INT,0,true);
        MyAttribute asd = new MyAttribute("asd",Type.BOOLEAN,0,true);
        
        
        Ent one = new Ent(sup, "uno");
        
        one.put("y", intAtr);
        one.put("x", intAtr);
        

        
        Ent two = new Ent(one, "dos");

        two.put("x", intAtr);
        
        Ent three = new Ent(two, "tres");

        
        three.put("x", asd);
        three.put("x", intAtr);
        
        three.put("y", intAtr);
                
        three.put("asd", asd);
        
        
        //Andan:
        //show();
        //showCurrent();
        //get();
        //put();
        //Probar:
        two.show();
    }
}






