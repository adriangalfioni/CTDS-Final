/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores;

/**
 *
 * @author adrian
 */
public class SemError {
    private final int line;
    private final int column;
    private final String description;

    public SemError(int lineNumber, int columnNumber, String desc) {
        line = lineNumber;
        column = columnNumber;
        description = desc;
    }
    
}
