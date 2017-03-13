/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.asm;

/**
 *
 * @author joako
 */
public class asmNode {
    Object op;
    Object val1;
    Object val2;
    
    asmNode (Object o, Object v1, Object v2){
        this.op = o;
        this.val1 = v1;
        this.val2 = v2;
    }
    
    
    @Override
    public String toString(){
        Object val1S =  val1;
        Object val2S =  val2;
        Object opS =  op;
        if (val1S == null){
            val1S="";
        }
        if (val2S == null){
            val2S="";
        }
        if (opS == null){
            opS="";
        }
        return opS.toString()+val1S.toString()+val2S.toString();
    }
}
