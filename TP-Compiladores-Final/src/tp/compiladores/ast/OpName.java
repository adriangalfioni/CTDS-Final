/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.ast;

/**
 *
 * @author Max
 */
public enum OpName {
    //Binary Aritmethic Operations
        ADD,
        SUB,
        MULT,
        DIV,
        MOD,
    //Binary Logic Operations
        AND,
        OR,
    //Binary Relational Operations
        LESSER,
        LESSEREQ,
        GREATER,
        GREATEREQ,
        EQ,
        NOTEQ,
    //Unary Operations
        NOT,
        MINUS,
    //Assign Operations
        ASSIGN,
        INC,
        DEC,
    //Labels and GOTO
        LABELWHILE,
        ENDWHILE,
        ENDIF,
        LABELIF,
        LABELFOR,
        LABELRETURN,
        LABELRETCALL,
        LABELBREAK,
        LABELPYC,
        LABELMETHOD,
        LABELPARAMADD,
        LABELPARAMSUB,
        LABELCONTINUE,
        LFF,
        LFI,
        GOTOF,
        GOTOT,
        GOTO,
        ELSEFLAG,
        CONDITIONWHILE,
        CALLMETHOD,
        OFFSET,
        EXTINV;
        
        @Override
        public String toString(){
            switch(this) {
                   case ADD:
                       return "add";
                   case SUB:
                       return "sub";
                   case MULT:
                       return "mult";
                   case DIV:
                       return "div";
                   case MOD:
                       return "mod";
                   case AND:
                       return "and";
                   case OR:
                       return "or";
                   case LESSER:
                       return "lesser";
                   case LESSEREQ:
                       return "lessereq";
                   case GREATER:
                       return "greater";
                   case GREATEREQ:
                       return "greatereq";
                   case EQ:
                       return "eq";
                   case NOTEQ:
                       return "noteq";
                   case NOT:
                       return "not";
                   case MINUS:
                       return "minus";
                   case ASSIGN:
                       return "assign";
                   case INC:
                       return "inc";
                   case DEC:
                       return "dec";
                   case LABELWHILE:
                       return "lwhile";
                   case ENDWHILE:
                       return "ewhile";
                   case ENDIF:
                       return "endif";
                   case LABELIF:
                       return "labelif";
                   case LABELFOR:
                       return "labelfor";
                   case LABELRETURN:
                       return "return";
                   case LABELBREAK:
                       return "break";
                   case LABELPYC:
                       return "pyc";
                   case LABELMETHOD:
                       return "method";
                   case LABELPARAMADD:
                       return "paramAdd";
                   case LABELPARAMSUB:
                       return "paramSub";
                   case LABELCONTINUE:
                       return "continue";
                   case LFF:
                       return "lforfinal";
                   case LFI:
                       return "lforinitial";
                   case GOTOF:
                       return "gotof";
                   case GOTOT:
                       return "gotot";
                   case GOTO:
                       return "goto";
                   case ELSEFLAG:
                       return "else";
                   case CONDITIONWHILE:
                       return "condition";
                   case EXTINV:
                       return "extInvocation";
                   case LABELRETCALL:
                       return "ret";
                   case OFFSET:
                       return "offset";
                   case CALLMETHOD:
                       return "methodcall";
                    
                           
            }
            return "null";
            
        }
}
