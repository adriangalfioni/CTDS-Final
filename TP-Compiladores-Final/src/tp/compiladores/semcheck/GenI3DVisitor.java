/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.semcheck;

import java.util.LinkedList;
import tp.compiladores.ASTVisitor;
import tp.compiladores.I3D;
import tp.compiladores.ast.ArrayLocation;
import tp.compiladores.ast.AssignStmt;
import tp.compiladores.ast.BinOpExpr;
import tp.compiladores.ast.Block;
import tp.compiladores.ast.BoolLiteral;
import tp.compiladores.ast.BreakStmt;
import tp.compiladores.ast.ContinueStmt;
import tp.compiladores.ast.Expression;
import tp.compiladores.ast.ExternInvkStmt;
import tp.compiladores.ast.FloatLiteral;
import tp.compiladores.ast.ForStmt;
import tp.compiladores.ast.IfStmt;
import tp.compiladores.ast.IntLiteral;
import tp.compiladores.ast.Location;
import tp.compiladores.ast.MethodDecl;
import tp.compiladores.ast.MethodExpr;
import tp.compiladores.ast.MethodStmt;
import tp.compiladores.ast.OpName;
import tp.compiladores.ast.PuntoYComaStmt;
import tp.compiladores.ast.ReturnStmt;
import tp.compiladores.ast.Statement;
import tp.compiladores.ast.StringLiteral;
import tp.compiladores.ast.Type;
import tp.compiladores.ast.UnaryOpExpr;
import tp.compiladores.ast.VarLocation;
import tp.compiladores.ast.WhileStmt;

/**
 *
 * @author Max
 */
public class GenI3DVisitor implements ASTVisitor<Object>  {
    //private LinkedList<LinkedList<I3D>> lists = new LinkedList();
    private final LinkedList<I3D> i3d = new LinkedList();
    private int index = 1;
    private int offset = 0;
    Object actual;
    private int orden = 1;
    
    
    @Override
    public Object visit(AssignStmt stmt) {
        I3D res;
        Object expr = stmt.getExpression().accept(this);
        Object varLoc = stmt.getLocation(); 
        System.out.println("VARLOC "+varLoc.getClass());
        switch (stmt.getOperator()){
            case ASSIGN: 
                res = new I3D(OpName.ASSIGN, expr, null, varLoc);
                getI3d().add(res);
                break;
            case INCREMENT:
                res = new I3D(OpName.INC, expr, null, varLoc);
                getI3d().add(res);
                break;
            case DECREMENT: 
                res = new I3D(OpName.DEC, expr, null, varLoc);
                getI3d().add(res);
                break;
        }
        return varLoc;
    }

    @Override
    public Object visit(ReturnStmt stmt) { 
        this.offset = this.offset + 8;
        Expression expression = stmt.getExpression();
        if(expression != null){
            expression.accept(this);
        }
        VarLocation rtrn = new VarLocation("LABELRETURN",offset);
        getI3d().add(new I3D(OpName.LABELRETURN,expression,null,rtrn));
        return rtrn;
    }

    @Override
    public Object visit(IfStmt stmt) {
        Object condition = stmt.getCondition().accept(this);
        VarLocation ifl = new VarLocation("IF"+index);
        VarLocation elseIf = new VarLocation("ELSEIF"+index);
        VarLocation endIf = new VarLocation("ENDIF"+index);        
        index++;
        getI3d().add(new I3D(OpName.LABELIF,condition,elseIf,ifl));
        Object ifBlock = stmt.getIfBlock().accept(this);
        getI3d().add(new I3D(OpName.GOTO,ifl,null,endIf));
        getI3d().add(new I3D(OpName.ELSEFLAG,ifl,null,elseIf));
        if (!(stmt.getElseBlock() == null)){
            Object elseBlock = stmt.getElseBlock().accept(this); 
        }
        getI3d().add(new I3D(OpName.ENDIF,ifl,null,endIf));
        return null;
    }

    @Override
    public Object visit(WhileStmt stmt) {
        VarLocation whileExpr = new VarLocation("WHILE"+index);
        VarLocation endWhile = new VarLocation("ENDWHILE"+index);
        index++;
        getI3d().add(new I3D(OpName.LABELWHILE,null,null,whileExpr));
        Object condition = stmt.getCondition().accept(this);
        getI3d().add(new I3D(OpName.CONDITIONWHILE,condition,null,endWhile));
        Object whileBlock = stmt.getWhileBlock().accept(this);
        getI3d().add(new I3D(OpName.GOTO,null,null,whileExpr));
        getI3d().add(new I3D(OpName.ENDWHILE,whileExpr,null,endWhile));
        return null;
    }

    @Override
    public Object visit(ForStmt stmt) {
        VarLocation init = (VarLocation)stmt.getInitial().accept(this);
        VarLocation comparison = new VarLocation("CMP");
        getI3d().add(new I3D(OpName.ASSIGN,stmt.getInitial().accept(this),null,init));
        Object lfi = new VarLocation("FOR"+index);
        Object lff = new VarLocation("ENDFOR"+index);
        index++;
        getI3d().add(new I3D(OpName.LABELFOR,null,null,lfi));
        getI3d().add(new I3D(OpName.LESSER,init,stmt.getEnd().accept(this),comparison));
        getI3d().add(new I3D(OpName.GOTOF,comparison,null,lff));
        for (Statement st: stmt.getForBlock().getStatements()){
            st.accept(this);
        }
        getI3d().add(new I3D(OpName.INC,1,null,init));
        getI3d().add(new I3D(OpName.GOTO,null,null,lfi));
        getI3d().add(new I3D(OpName.LFF,null,null,lff));

        return null;
    }

    @Override
    public Object visit(BreakStmt stmt) {
        VarLocation brk = new VarLocation("LABELBREAK");
        getI3d().add(new I3D(OpName.LABELBREAK,null,null,brk));
        return null;
    }

    @Override
    public Object visit(ContinueStmt stmt) { 
        VarLocation cont = new VarLocation("LABELCONTINUE");
        getI3d().add(new I3D(OpName.LABELCONTINUE,null,null,cont));
        return null;
    }

    @Override
    public Object visit(PuntoYComaStmt stmt) { 
        return null;
    }

    @Override
    public Object visit(MethodStmt methStmt) {
          getI3d().add(new I3D(OpName.CALLMETHOD, null, null, methStmt.getMethodId()));
//        VarLocation varloc = new VarLocation(methStmt.getMethodId());
//        getI3d().add(new I3D(OpName.LABELMETHOD,null,null,varloc));
//        if (methStmt.getExpression() != null){
//            for(Expression e: methStmt.getExpression()){
//                e.accept(this);
//            }
//        }
//        getI3d().add(new I3D(OpName.GOTO,null,null,methStmt.getMethodId()));
        return null;
    }

    @Override
    public Object visit(Block block) {
        System.out.println("Entro a block!!!");
        
        for(VarLocation varL: block.getFields()){
            varL.accept(this);
        }
        
        for(Statement state: block.getStatements()){
            System.out.println("Statemens del block "+state.toString());
            state.accept(this);
        }
        
        return null;
    }

    @Override
    public Object visit(BinOpExpr expr) {
        I3D node;
        this.offset = this.offset + 8;
        Object op1 = expr.getLeftOperand().accept(this);
        Object op2 = expr.getRightOperand().accept(this);
        VarLocation res = new VarLocation("RES"+index, offset) ;
        switch (expr.getOperator()){
            case PLUS:
                node = new I3D(OpName.ADD,op1,op2,res);
                getI3d().add(node);
                break;
            case MINUS:
                node = new I3D(OpName.SUB,op1,op2,res);
                getI3d().add(node);
                break;
            case MULTIPLY:
                node = new I3D(OpName.MULT,op1,op2,res);
                getI3d().add(node);
                break;
            case DIVIDE:
                node = new I3D(OpName.DIV,op1,op2,res);
                getI3d().add(node);
                break;
            case MOD: 
                node = new I3D(OpName.MOD,op1,op2,res);
                getI3d().add(node);
                break;
            case LE:
                node = new I3D(OpName.LESSER,op1,op2,res);
                getI3d().add(node);
                break;
            case LEQ: 
                node = new I3D(OpName.LESSEREQ,op1,op2,res);
                getI3d().add(node);
                break;
            case GE:
                node = new I3D(OpName.GREATER,op1,op2,res);
                getI3d().add(node);
                break;
            case GEQ:
                node = new I3D(OpName.GREATEREQ,op1,op2,res);
                getI3d().add(node);
                break;
            case NEQ:
                node = new I3D(OpName.NOTEQ,op1,op2,res);
                getI3d().add(node);
                break;
            case CEQ:
                node = new I3D(OpName.EQ,op1,op2,res);
                getI3d().add(node);
                break;
            case AND:
                node = new I3D(OpName.AND,op1,op2,res);
                getI3d().add(node);
                break;
            case OR:
                node = new I3D(OpName.OR,op1,op2,res);
                getI3d().add(node);
                break;
        }
        index++;
        return res;
    }

    @Override
    public Object visit(UnaryOpExpr unaryExpr) {
        I3D node;
        this.offset = this.offset + 8;
        Object operand = unaryExpr.getOperand().accept(this);
        VarLocation res = new VarLocation("RES"+index,offset);
        switch (unaryExpr.getOperator()){
            case NOT: 
                node = new I3D(OpName.NOT,operand,null,res);
                getI3d().add(node);
            case MINUS:
                node = new I3D(OpName.MINUS,operand,null,res);
                getI3d().add(node);
        }
        index++;
        return res;
    }

    @Override
    public Object visit(MethodExpr methExpr) { 
        if (methExpr.getIsMethod()){
            if (methExpr.getExpression() != null){
                for(Expression e: methExpr.getExpression()){
                    getI3d().add(new I3D(OpName.LABELPARAMADD,null,null,e.accept(this)));
                }
            }
            getI3d().add(new I3D(OpName.CALLMETHOD,null,null,methExpr.getMethodId()));
            return null;
        }else{ // Is an exterinvk
            if (methExpr.getExpression() != null){
                for(Expression e: methExpr.getExpression()){
                    getI3d().add(new I3D(OpName.LABELPARAMADD,null,null,e.accept(this)));
                }
            }
            getI3d().add(new I3D(OpName.GOTO,null,null,methExpr.getMethodId()));
            return null;
        }
        
    }

    @Override
    public Object visit(IntLiteral lit) {
        return lit;
    }

    @Override
    public Object visit(BoolLiteral lit) {
        System.out.println("Entro por acá?");
        return lit;
    }

    @Override
    public Object visit(FloatLiteral lit) {
        return lit;
    }

    @Override
    public Object visit(StringLiteral lit) {
        return lit;
    }

    @Override
    public Object visit(VarLocation loc) {
        //System.out.println("Orden: "+orden+ " varLoc");
        //orden++;
        /*if(!loc.getIsOnlyLocation()){
            this.offset = this.offset + 8;
            getI3d().add(new I3D(OpName.LOCALVAR,loc.getId(),null,loc.getOffset()));
        }*/
        return loc;
    }

    @Override
    public Object visit(ArrayLocation arrLoc) {
        return arrLoc;
    }

    /**
     * @return the i3d
     */
    public LinkedList<I3D> getI3d() {
        return i3d;
    }
    
    public void String(){
        for(I3D i: i3d){
            System.out.println(
            i.getOperation().toString()+" "+
            i.getV1().toString()+" "+
            i.getV2().toString()+" "+
            i.getResult().toString()+"/n"
            );
        }
    }

    @Override
    public Object visit(ExternInvkStmt extInvStmt) {
        VarLocation varloc = new VarLocation(extInvStmt.toString());
        getI3d().add(new I3D(OpName.EXTINV,null,null,varloc));
        LinkedList<Expression> param = new LinkedList();
        for( Expression e : extInvStmt.getParams()){
            param.add((Expression) e.accept(this));
        }
        ExternInvkStmt invo = new ExternInvkStmt(extInvStmt.getName(),extInvStmt.getType(),param);
        getI3d().add(new I3D(OpName.GOTO,invo,null,varloc));
        return null;
    }

    @Override
    public Object visit(MethodDecl methD) {
        System.out.println("Orden: "+orden+" mehtodDecl");
        orden++;
        int aux = this.offset;
        int i3dOffset;
        //VarLocation varloc = new VarLocation(methD.getId().toString());
        getI3d().add(new I3D(OpName.LABELMETHOD,null,null,methD.getId().toString()));
        i3dOffset = getI3d().size();
        this.offset = 0;
        if(methD.getParmsType() != null) this.offset = methD.getParmsType().size() * 8;
        Object block = methD.getBlock().accept(this);
        getI3d().add(i3dOffset, new I3D(OpName.OFFSET,null,null,this.offset));
        getI3d().add(new I3D(OpName.LABELRETCALL,null,null,"RET"));
        this.offset = aux;
        return null;
    }
        
}