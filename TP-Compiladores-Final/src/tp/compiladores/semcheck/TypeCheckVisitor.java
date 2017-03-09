package tp.compiladores.semcheck;

import java.util.LinkedList;
import java.util.List;
import tp.compiladores.ASTVisitor;
import tp.compiladores.SemError;
import tp.compiladores.ast.*;

// type checker, concrete visitor 
public class TypeCheckVisitor implements ASTVisitor<Type> {

    public List<SemError> errors = new LinkedList<SemError>();
    boolean allBlocksHaveReturn; // Used to check if all method blocks have return statement 
    boolean allBlocksWithSameMethodType; // Used to check if all method blocks have same method return type 
    Type visitedMethodType;

    @Override
    public Type visit(AssignStmt stmt) {
        Type locType;
        AssignOpType op = stmt.getOperator();
        Type exprType = stmt.getExpression().accept(this);
        if (stmt.getLocation().getIsArrayLocation()) {
            //System.out.println("ENTRAAAASDADSASDASD");
            locType = stmt.getLocation().getType();
            //System.out.println("Type= "+locType);
        } else {
            locType = stmt.getLocation().getType();
        }
//            System.out.print(locType.toString()+" ");
//            System.out.print(stmt.getLocation().toString()+" ");
//            System.out.print(op.toString()+" ");
//            System.out.print(stmt.getExpression().toString()+" ");
//            System.out.println(exprType.toString()+" ");
        //System.out.println("HOLAAAA");
        if (op.equals(AssignOpType.DECREMENT) || op.equals(AssignOpType.INCREMENT)) { //If the operator is Increment or Decrement
            if (exprType.equals(locType)) { //Check if Expr and Loc types are equals
                if (exprType.equals(Type.INT) || exprType.equals(Type.FLOAT)) { //Checks that both types are valid
                    //System.out.println("Assign stmt type: "+exprType.toString());
                    return exprType; //Returns Float or Int
                } else { //Else, if the types are other than Int or Float, returns an error
                    addError(stmt, "Wrong type assign, should be Int of Float");
                    //System.out.println("Assign stmt error");
                    return Type.ERROR;
                }
            } else { //If the types are different
                if ((exprType.equals(Type.INT) || exprType.equals(Type.FLOAT)) && (locType.equals(Type.INT) || locType.equals(Type.FLOAT))) { //Checks that both types are valid
                    //System.out.println("Assign stmt type: FLOAT");
                    return Type.FLOAT;
                } else { //Otherwise, returns an Error
                    addError(stmt, "Wrong type assignation, should be Int or Flaot");
                    //System.out.println("Assign stmt error");
                    return Type.ERROR;
                }
            }
        } else { //If the operator is an Assign
            //System.out.println(stmt.getExpression().toString()+" "+stmt.getExpression().accept(this));
            if (stmt.getExpression().accept(this).equals(stmt.getLocation().getType())) { //Checks that both types are the same
                //System.out.println("Assign stmt type: "+stmt.getExpression().getType().toString());
                return exprType; //Returns the type
            } else {
                addError(stmt, "Var and expression types are not the same");
                //System.out.println("Assign stmt error");
                return Type.ERROR; //Otherwise, error.
            }
        }
    }

    @Override
    public Type visit(BinOpExpr expr) {
        BinOpType binOp = expr.getOperator(); //Gets the operator
        Type lExpType, rExpType; // Variables for the operands
        lExpType = expr.getLeftOperand().accept(this);
        rExpType = expr.getRightOperand().accept(this);
        System.out.println(expr.getLeftOperand().toString() + " LEXP Type: " + lExpType.toString());
        System.out.println("Operador: " + binOp.toString());
        System.out.println(expr.getRightOperand().toString() + " REXP Type: " + rExpType.toString());
        if (binOp.equals(BinOpType.OR) || binOp.equals(BinOpType.AND)) { //If the operator is Conditional 
            if (lExpType.equals(Type.BOOLEAN) && rExpType.equals(Type.BOOLEAN)) { // Checks that both values are Boolean
                return Type.BOOLEAN;
            } else { //Otherwise, error.
                addError(expr, "Both types should be boolean.");
                return Type.ERROR;
            }
        } else if (binOp.equals(BinOpType.NEQ) || binOp.equals(BinOpType.CEQ)) { //If the operator is Equal
            if (lExpType.equals(rExpType)) { // Checks that both types are the same
                return Type.BOOLEAN;
            } else { //Otherwise, error.
                addError(expr, "Both types should be the sames.");
                return Type.ERROR;
            }
        } else if (binOp.equals(BinOpType.GE) || binOp.equals(BinOpType.GEQ) || binOp.equals(BinOpType.LEQ) || binOp.equals(BinOpType.LE)) { //If the operator is Relational
            if ((lExpType.equals(Type.FLOAT) || lExpType.equals(Type.INT)) && (rExpType.equals(Type.FLOAT) || lExpType.equals(Type.INT))) { //If both operands ar either int or float
                return Type.BOOLEAN;
            } else { //Otherwise, error
                addError(expr, "Both types should be either float or int.");
                return Type.ERROR;
            }
        } else {  //If binOp it's an Arithmetic operator
            if (lExpType.equals(Type.INT) && rExpType.equals(lExpType)) { //if both operand types are INT
                if (binOp.equals(BinOpType.DIVIDE)) {
                    return Type.FLOAT;
                }
                return Type.INT;
            } else if (lExpType.equals(Type.FLOAT) && rExpType.equals(lExpType)) { //if both operand types are Float
                return Type.FLOAT;
            } else if ((lExpType.equals(Type.FLOAT) && rExpType.equals(Type.INT)) || (rExpType.equals(Type.FLOAT) && lExpType.equals(Type.INT))) { //if both operands ar either int or float
                return Type.FLOAT;
            } else { //Otherwise, error
                addError(expr, "Both types should be either floar or int.");
                return Type.ERROR;
            }
        }
    }

    @Override
    public Type visit(ReturnStmt stmt) {
        Expression expr = stmt.getExpression();
        if (expr != null) { //if the expression of the return is not null, checks the type
            return expr.accept(this);
        } else { //Else returns void.
            return Type.VOID;
        }
    }

    @Override
    public Type visit(IfStmt stmt) {
        System.out.println("Estoy visitando el if");
        Block ifBlock = stmt.getIfBlock();
        Block elseBlock = stmt.getElseBlock();

        ifBlock.accept(this);
        if (elseBlock != null) {
            elseBlock.accept(this);
        }

        if (stmt.getCondition().accept(this).equals(Type.BOOLEAN)) {
            return Type.BOOLEAN; //Checks that the condition is boolean
        }
        addError(stmt, "Wrong condition type. Should be a boolean condition.");
        return Type.ERROR; //Else error.
    }

    @Override
    public Type visit(IntLiteral lit) {
        return lit.getType();
    }

    @Override
    public Type visit(VarLocation loc) {
        return loc.getType();
    }

    @Override
    public Type visit(WhileStmt stmt) {
        if (stmt.getCondition().accept(this).equals(Type.BOOLEAN)) {
            return Type.BOOLEAN;
        }
        addError(stmt, "While condition should be boolean.");
        return Type.ERROR;
    }

    @Override
    public Type visit(UnaryOpExpr unaryExpr) {
        UnaryOpType unOp = unaryExpr.getOperator();
        Expression expr = unaryExpr.getOperand();
        Type exprType = expr.accept(this);
        //System.out.println("Unary operador "+unOp.toString());
        //System.out.println("Unary operando "+expr.toString());
        if (unOp.equals(UnaryOpType.MINUS) && (exprType.equals(Type.FLOAT) || exprType.equals(Type.INT))) {
            return expr.getType();
        } else if (unOp.equals(UnaryOpType.NOT) && (exprType.equals(Type.BOOLEAN))) {
            return Type.BOOLEAN;
        } else {
            addError(unaryExpr, "Wrong type for unary operator.");
            return Type.ERROR;
        }
    }

    @Override
    public Type visit(ForStmt stmt) {
        //System.out.println(stmt.getInitial().accept(this).toString());
        //System.out.println(stmt.getEnd().accept(this).toString());
        if (!stmt.getInitial().accept(this).equals(Type.INT) || !stmt.getEnd().accept(this).equals(Type.INT)) {
            addError(stmt, "Expressions in for must be int");
            return Type.ERROR;
        }
        return Type.VOID;
    }

    @Override
    public Type visit(Block block) {
        System.out.println("Entro bloqueeee");
        System.out.println(block.toString());
        System.out.println(block.getStatements().size());
        boolean someIsReturn = false;
        for (Statement st : block.getStatements()) {
            System.out.println("Statement " + st.toString() + " es un return? " + st.getIsReturnStmt());
            Type stmtType = st.accept(this);
            if (st.getIsReturnStmt() == true) {
                someIsReturn = true;
                System.out.println("stmtType " + stmtType.toString());
                if (visitedMethodType != stmtType) {
                    allBlocksWithSameMethodType = false;
                }
            }
            if (stmtType.equals(Type.ERROR) || stmtType.equals(Type.UNDEFINED)) {
                addError(block, "Block error");
                return Type.ERROR;
            }
            if (st.getIsBreakStmt() || st.getIsContinueStmt()) {
                if (!block.isInCycleB()) {
                    addError(block, "Continue and Break only can be in a cycle");
                    return Type.ERROR;
                }
            }
        }
        // If block does not have return statement
        if (someIsReturn == false) {
            boolean allBlocksHaveReturn = false;
        }

        List<String> fields = block.getFields();
        if (fields != null) {
            for (int i = 0; i < fields.size(); i++) {
                for (int j = i + 1; j < fields.size(); j++) {
                    if (fields.get(i).equalsIgnoreCase(fields.get(j))) {
                        addError(block, "Identifier already defined");
                        return Type.ERROR;
                    }
                }
            }
        }

        return Type.VOID;
    }

    @Override
    public Type visit(BreakStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(ContinueStmt stmt) {
        return Type.VOID;
    }

    @Override
    public Type visit(PuntoYComaStmt stmt) {
        return Type.UNDEFINED;
    }

    @Override
    public Type visit(MethodStmt methStmt) {
        MethodExpr methExpr = methStmt.getMethodExpr();
        if (methExpr.getIsExternInvk()) {
            if (methExpr.getExpression() != null) {
                for (Expression e : methExpr.getExpression()) {
                    // No debería ir este checkeo pero hay algún problema
                    // Para probar descomentar lo de arriba
                    if (e != null) {
                        e.accept(this);
                    }
                }
            }
            return Type.VOID;
        } else {
            Type methType = methExpr.getMethodType();
            LinkedList<Expression> methodParams = methExpr.getExpression();
            LinkedList<Type> tableParams = methExpr.getTableSymParamsType();

            if (tableParams != null) {
                if (methodParams.size() != tableParams.size()) {
                    addError(methExpr, "Wrong number of arguments");
                    return Type.ERROR;
                } else {
                    for (int i = 0; i < methodParams.size(); i++) {
                        Type mParamType = methodParams.get(i).accept(this);
                        Type tParamType = tableParams.get(i);
                        if (!mParamType.equals(tParamType)) {
                            addError(methExpr, "Wrong parameter type.");
                            return Type.ERROR;
                        }
                    }
                }
            }
            if (methType.equals(Type.BOOLEAN) || methType.equals(Type.INT) || methType.equals(Type.FLOAT) || methType.equals(Type.VOID)) {
                return methType;
            } else {
                addError(methExpr, "Wrong method type.");
                return Type.ERROR;
            }
        }
    }

    @Override
    public Type visit(MethodExpr methExpr) {
        if (methExpr.getIsExternInvk()) {
            return methExpr.getMethodType();
        } else {
            Type methType = methExpr.getMethodType();
            LinkedList<Expression> methodParams = methExpr.getExpression();
            LinkedList<Type> tableParams = methExpr.getTableSymParamsType();
            if (tableParams != null) {
                //if(methodParams.size() != tableParams.size()){
                if (methExpr.getNumberOfParams() != tableParams.size()) {
                    addError(methExpr, "Wrong number of arguments");
                    return Type.ERROR;
                } else {
                    for (int i = 0; i < methodParams.size(); i++) {
                        Type mParamType = methodParams.get(i).accept(this);
                        Type tParamType = tableParams.get(i);
                        if (!mParamType.equals(tParamType)) {
                            addError(methExpr, "Wrong parameter type.");
                            return Type.ERROR;
                        }
                    }
                }
            }
            if (methType.equals(Type.BOOLEAN) || methType.equals(Type.INT) || methType.equals(Type.FLOAT)) {
                return methType;
            } else {
                addError(methExpr, "Wrong method type.");
                return Type.ERROR;
            }
        }
    }

    @Override
    public Type visit(ArrayLocation arrLoc) {
//        System.out.println("ENTRAA?");
//        if (arrLoc.getExpr().getType().equals(Type.INT)){
//            IntLiteral intLit = (IntLiteral) arrLoc.getExpr();
//            if(intLit.getValue()>=0){ // Check if intLiteral in [] is >= 0
//                return Type.INTARRAY;
//            }else{
//                addError(arrLoc,"Wrong size in array declaration.");
//                System.out.println("Wrong size in array declaration.");
//                return Type.ERROR;
//            }
//        }else{
//            addError(arrLoc,"Wrong type in array declaration.");
//            System.out.println("Wrong type in array declaration.");
//            return Type.ERROR;
//        }
        return arrLoc.getType();
    }

    @Override
    public Type visit(BoolLiteral lit) {
        return lit.getType();
    }

    @Override
    public Type visit(FloatLiteral lit) {
        return lit.getType();
    }

    @Override
    public Type visit(StringLiteral lit) {
        return lit.getType();
    }

    private void addError(AST a, String desc) {
        //errors.add(new SemError(a.getLineNumber(), a.getColumnNumber(), desc));
        report_error(desc, a.getLineNumber(), a.getColumnNumber());
        //System.out.println(desc);
    }

    public List<SemError> getErrors() {
        return errors;
    }

    public void setErrors(List<SemError> errors) {
        this.errors = errors;
    }

    public void report_error(String message, int row, int column) {

        StringBuilder m = new StringBuilder("Error");

//            if (info instanceof java_cup.runtime.Symbol) {
//                java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
//
//                if (s.left >= 0) {                
//                    m.append(" in line "+(s.left+1));
//                    if (s.right >= 0)                    
//                        m.append(", column "+(s.right+1));
//                }
//            }
        if (row != 0 && column != 0) {
            m.append(" in row " + row + ", column " + column + " : " + message);
        } else {
            m.append(": " + message);
        }

        System.err.println(m);
    }

    @Override
    public Type visit(MethodDecl methD) {
        Type methType = methD.getMethType();
        Block methBlock = methD.getBlock();
        allBlocksHaveReturn = true;
        allBlocksWithSameMethodType = true;
        visitedMethodType = methType;

        boolean haveReturnStmt = false;
        Type returnType = null;

        for (Statement s : methBlock.getStatements()) {
            if (s.getIsReturnStmt() == true) {
                haveReturnStmt = true;
                returnType = s.accept(this);
                if (!returnType.equals(methType)) {
                    addError(methD, "Return and method type are different");
                    return Type.ERROR;
                }
            } else {
                s.accept(this);
            }
        }
        // If methodDecl block does not have a return statement
        // check if all blocks contained in methodDecl have
        // return statement
        if (haveReturnStmt == false) {
            haveReturnStmt = allBlocksHaveReturn;
        }
        if (allBlocksWithSameMethodType) {
            returnType = methType;
        } else {
            addError(methD, "Return statement inner block wrong type");
            return Type.ERROR;
        }

        if (!methType.equals(Type.VOID) && !haveReturnStmt) {
            addError(methD, "Return statement missing.");
            return Type.ERROR;
        }
        if (!methType.equals(Type.VOID) && haveReturnStmt) {
            if (methType.equals(returnType)) {
                return methType;
            } else {
                addError(methD, "Return statement wrong type.");
                return Type.ERROR;
            }
        }

        methBlock.accept(this);
        return Type.VOID;
    }

    public Type visit(ExternInvkStmt extInv) {
        return extInv.getType();
    }

}
