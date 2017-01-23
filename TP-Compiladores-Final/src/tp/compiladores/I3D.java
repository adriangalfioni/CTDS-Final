/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores;

import tp.compiladores.ast.OpName;
/*
 * About I3D:
 *  Case OpName:
 *    LABELIF: {v1 = condicion del IF, v2 = null, result = Nombre del IF}
 *    ENDIF: {v1 = a que IF le corresponde, v2 = null, result = null}
 *    LABELWHILE: {v1 = condicion del WHILE, v2 = null, result = Nombre del WHILE}
 *    ENDWHILE: {v1 = a que WHILE le corresponde, v2 = null, result = null}
 *    GOTOF: {v1 = a que Statement le corresponde, v2 = null, result = null}
 *    GOTOT: {v1 = a que Statementle corresponde, v2 = null, result = null}
 *    GOTO: {v1 = a que Statement le corresponde, v2 = null, result = Adonde dirigirse}
 *    OperacionesBinarias: {v1 = 1er operando, v2 = segundo operando, result = Adonde se guarda el resultado}
 *    LABELMETHOD: {v1 = null, v2 = null, result = Nombre del metodo}
 */
/**
 *
 * @author Max
 */
public class I3D {
    
    private final OpName operation;
    private final Object v1;
    private final Object v2;
    private final Object result;
    
    public I3D(OpName operation, Object v1, Object v2, Object result) {
        this.operation = operation;
        this.v1 = v1;
        this.v2 = v2;
        this.result = result;
    }

    /**
     * @return the operation
     */
    public OpName getOperation() {
        return operation;
    }

    /**
     * @return the v1
     */
    public Object getV1() {
        return v1;
    }

    /**
     * @return the v2
     */
    public Object getV2() {
        return v2;
    }

    /**
     * @return the result
     */
    public Object getResult() {
        return result;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString(){
        String op = operation.toString();
        String val1 = "null";
        String val2 = "null";
        String res = "null";
        if (v1 != null)
            val1 = v1.toString();
        if (v2 != null)
            val2 = v2.toString();
        if (result != null)
            res = result.toString();
        return op +", "+val1+", "+val2+", "+res;
    }
}
