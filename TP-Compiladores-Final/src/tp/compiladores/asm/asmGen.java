/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores.asm;

import java.util.LinkedList;
import tp.compiladores.I3D;
import tp.compiladores.ast.*;

/**
 *
 * @author joako
 */
public class asmGen {
   private LinkedList<asmNode> nodes;
   private int params;
   asmNode asm;
   
   
   public asmGen(){
       nodes = new LinkedList();
       nodes.add(new asmNode("  .code32",null,null));
       nodes.add(new asmNode("  .text", null, null));
       nodes.add(new asmNode("  .globl"," main", null));
       params = 0;
   }
   
   public void check(I3D node){
       System.out.println("NODE "+node.getOperation().toString());
       System.out.println(node.toString());
       switch (node.getOperation()){
           //This should be working, baby mc babe face
           //Addy McAddFace
           case ADD :
               if ((node.getV1() instanceof Literal) && (node.getV2() instanceof VarLocation)){
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV1() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV1() instanceof IntLiteral){
                        IntLiteral v1 = (IntLiteral) node.getV1();
                        asm = new asmNode("movl ", "-"+v2.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("addl ","$"+v1.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);    
                   }
               } else if ((node.getV2() instanceof Literal) && (node.getV1() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV2() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV2() instanceof IntLiteral){
                        IntLiteral v2 = (IntLiteral) node.getV2();
                        asm = new asmNode("movl ","-"+v1.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("addl ","$"+v2.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);    
                   }
               } else if (node.getV1() instanceof Literal && node.getV2() instanceof Literal) {
                   if (node.getV1() instanceof FloatLiteral || node.getV2() instanceof FloatLiteral) {
                       //Floaty McFloatFace
                   } else {
                       IntLiteral v1 = (IntLiteral) node.getV1();
                       IntLiteral v2 = (IntLiteral) node.getV2();
                       VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl ","$"+v2.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("addl ","$"+v1.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("movl ","%eax",", -"+(res.getOffset()+"(%ebp)"));
                       getNodes().add(asm);    
                   }
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   System.out.println("ASD "+node.getV1());
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("addl  ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+(res.getOffset()+"(%ebp)"));
                   getNodes().add(asm);
               }
               break;
           case SUB:
               if ((node.getV1() instanceof Literal) && (node.getV2() instanceof VarLocation)){
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV1() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV1() instanceof IntLiteral){
                        IntLiteral v1 = (IntLiteral) node.getV1();
                        asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("subl   ","$"+v1.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);    
                   }
               } else if ((node.getV2() instanceof Literal) && (node.getV1() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV2() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV2() instanceof IntLiteral){
                        IntLiteral v2 = (IntLiteral) node.getV2();
                        asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("subl   ","$"+v2.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);    
                   }
               } else if (node.getV1() instanceof Literal && node.getV2() instanceof Literal) {
                   if (node.getV1() instanceof FloatLiteral || node.getV2() instanceof FloatLiteral) {
                       //Floaty McFloatFace
                   } else {
                       IntLiteral v1 = (IntLiteral) node.getV1();
                       IntLiteral v2 = (IntLiteral) node.getV2();
                       VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl   ","$"+v2.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("subl   ","$"+v1.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","%eax",", -"+(res.getOffset())+"(%ebp)");
                       getNodes().add(asm);    
                   }
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("subl   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+(res.getOffset())+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case MULT:
               if ((node.getV1() instanceof Literal) && (node.getV2() instanceof VarLocation)){
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV1() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV1() instanceof IntLiteral){
                        IntLiteral v1 = (IntLiteral) node.getV1();
                        v2 = (VarLocation) node.getV2();
                        res = (VarLocation) node.getResult();
                        asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("imul   ","$"+v1.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+(res.getOffset())+"(%ebp)");
                        getNodes().add(asm);
                   }
               } else if ((node.getV2() instanceof Literal) && (node.getV1() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV2() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV2() instanceof IntLiteral){
                        IntLiteral v2 = (IntLiteral) node.getV2();
                        v1 = (VarLocation) node.getV1();
                        res = (VarLocation) node.getResult();
                        asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("imul   ","$"+v2.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+(res.getOffset())+"(%ebp)");
                        getNodes().add(asm);
                   }
               } else if (node.getV1() instanceof Literal && node.getV2() instanceof Literal) {
                   if (node.getV1() instanceof FloatLiteral || node.getV2() instanceof FloatLiteral) {
                       //Floaty McFloatFace
                   } else {
                       IntLiteral v1 = (IntLiteral) node.getV1();
                       IntLiteral v2 = (IntLiteral) node.getV2();
                       VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("imul   ","$"+v2.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                   }
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("imul   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+(res.getOffset())+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case DIV:
               if ((node.getV1() instanceof Literal) && (node.getV2() instanceof VarLocation)){
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV1() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV1() instanceof IntLiteral){
                        IntLiteral v1 = (IntLiteral) node.getV1();
                        asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("divl   ","$"+v1.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);
                   }
               } else if ((node.getV2() instanceof Literal) && (node.getV1() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV2() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV2() instanceof IntLiteral){
                       IntLiteral v2 = (IntLiteral) node.getV2();
                        asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("divl   ","$"+v2.getRawValue(),", %eax");
                        getNodes().add(asm);
                        asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                        getNodes().add(asm);
                   }
               } else if (node.getV1() instanceof Literal && node.getV2() instanceof Literal) {
                   if (node.getV1() instanceof FloatLiteral || node.getV2() instanceof FloatLiteral) {
                       //Floaty McFloatFace
                   } else {
                       IntLiteral v1 = (IntLiteral) node.getV1();
                       IntLiteral v2 = (IntLiteral) node.getV2();
                       VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl   ","$"+v2.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("divl   ","$"+v1.getRawValue(),", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","%eax",", -"+(res.getOffset())+"(%ebp)");
                       getNodes().add(asm); 
                   }
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("divl   ","%eax","%edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+(res.getOffset())+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case MOD:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("idivl   ","$"+v2.getRawValue(),null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("idivl   ","-"+v2.getOffset()+"(%ebp)",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("idivl   ","$"+v2.getRawValue(),null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("idivl   ","-"+v2.getOffset()+"(%ebp)",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case LESSER:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;
        case LESSEREQ:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;
           case GREATER:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %ebx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jg    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;
          case GREATEREQ:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jge    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;           
           case EQ:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;
           case NOTEQ:
               if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jne    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof IntLiteral) && (node.getV2() instanceof VarLocation)){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jne    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof IntLiteral)){
                   IntLiteral v2 = (IntLiteral) node.getV2();
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$"+v2.getRawValue(),", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jne    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("jne    ",".L1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".L2",null);
                   getNodes().add(asm);
                   asm = new asmNode(".L1:",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".L2:",null,null);
                   getNodes().add(asm);
               }
               break;
           case AND:
                if ((node.getV1() instanceof BoolLiteral) && (node.getV2() instanceof BoolLiteral)){
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   BoolLiteral v2 = (BoolLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (v1.getRawValue().equals("true") && v2.getRawValue().equals("true")){
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   } else {
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   }
                   getNodes().add(asm);
                   
                } else if ((node.getV1() instanceof BoolLiteral) && (node.getV2() instanceof VarLocation)){
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (v1.getRawValue().equals("true")){
                       asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("cmp   ","%eax",", $1");
                       getNodes().add(asm);
                       asm = new asmNode("je    ",".AND1",null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode("jmp   ",".ENDAND",null);
                       getNodes().add(asm);
                       asm = new asmNode(".AND1",null,null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode(".ENDAND",null,null);
                       getNodes().add(asm);
                   } else {
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                   }
                }   else if ((node.getV2() instanceof BoolLiteral) && (node.getV1() instanceof VarLocation)){
                    BoolLiteral v2 = (BoolLiteral) node.getV1();
                    VarLocation v1 = (VarLocation) node.getV2();
                    VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("cmp   ","%eax",", $1");
                       getNodes().add(asm);
                       asm = new asmNode("je    ",".AND1",null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode("jmp   ",".ENDAND",null);
                       getNodes().add(asm);
                       asm = new asmNode(".AND1",null,null);
                       getNodes().add(asm);
                       if (v2.getRawValue().equals("true")){
                            asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                            getNodes().add(asm);
                       } else {
                            asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                            getNodes().add(asm);
                       }
                       asm = new asmNode(".ENDAND",null,null);
                       getNodes().add(asm);  
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".AND1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".ENDAND",null);
                   getNodes().add(asm);
                   asm = new asmNode(".AND1",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%edx",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".AND2",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".ENDAND",null);
                   getNodes().add(asm);
                   asm = new asmNode(".AND2",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".ENDAND",null,null);
                   getNodes().add(asm); 
               }
               break;
           case OR:
               if ((node.getV1() instanceof BoolLiteral) && (node.getV2() instanceof BoolLiteral)){
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   BoolLiteral v2 = (BoolLiteral) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (v1.getRawValue().equals("true") || v2.getRawValue().equals("true")){
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   } else {
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   }
                   getNodes().add(asm);
                   
                } else if ((node.getV1() instanceof BoolLiteral) && (node.getV2() instanceof VarLocation)){
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (v1.getRawValue().equals("true")){
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                   } else {
                       asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("cmp   ","%eax",", $1");
                       getNodes().add(asm);
                       asm = new asmNode("je    ",".OR1",null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode("jmp   ",".ENDOR",null);
                       getNodes().add(asm);
                       asm = new asmNode(".OR1",null,null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode(".ENDOR",null,null);
                       getNodes().add(asm);
                   }
                }   else if ((node.getV2() instanceof BoolLiteral) && (node.getV1() instanceof VarLocation)){
                    BoolLiteral v2 = (BoolLiteral) node.getV1();
                    VarLocation v1 = (VarLocation) node.getV2();
                    VarLocation res = (VarLocation) node.getResult();
                       asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                       getNodes().add(asm);
                       asm = new asmNode("cmp   ","%eax",", $1");
                       getNodes().add(asm);
                       asm = new asmNode("je    ",".OR1",null);
                       getNodes().add(asm);
                       if (v2.getRawValue().equals("true")){
                            asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                            getNodes().add(asm);
                       } else {
                            asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                            getNodes().add(asm);
                       }
                       getNodes().add(asm);
                       asm = new asmNode("jmp   ",".ENDOR",null);
                       getNodes().add(asm);
                       asm = new asmNode(".OR1",null,null);
                       getNodes().add(asm);
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                       asm = new asmNode(".ENDOR",null,null);
                       getNodes().add(asm);  
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".or1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+v2.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%edx",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("je    ",".or1",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".endor",null);
                   getNodes().add(asm);
                   asm = new asmNode(".OR1",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".endor",null,null);
                   getNodes().add(asm); 
               }
               break;
           case NOT:
               if (node.getV1() instanceof BoolLiteral){
                   VarLocation res = (VarLocation) node.getResult();
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   if (v1.getRawValue().equals("true")){
                       asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   } else {
                       asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   }
                   getNodes().add(asm);
               } else if (node.getV1() instanceof VarLocation){
                   VarLocation res = (VarLocation) node.getResult();
                   VarLocation v1 = (VarLocation) node.getV1();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","$1",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("je   ",".nt",null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$1",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode("jmp   ",".endnot",null);
                   getNodes().add(asm);
                   asm = new asmNode(".nt",null,null);
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","$0",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
                   asm = new asmNode(".endnot",null,null);
                   getNodes().add(asm);
               }
               break;
           case MINUS:
               if (node.getV1() instanceof IntLiteral){
                   VarLocation res = (VarLocation) node.getResult();
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("imul  ","$-1",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl  ","%eax",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if(node.getV1() instanceof VarLocation) {
                   VarLocation res = (VarLocation) node.getResult();
                   VarLocation v1 = (VarLocation) node.getV1();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("imul  ","$-1",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%eax",", -"+res.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case ASSIGN:
               VarLocation res_location = (VarLocation) node.getResult();
               if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", -"+res_location.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if (node.getV1() instanceof BoolLiteral){
                   BoolLiteral v1 = (BoolLiteral) node.getV1();
                   if (v1.getValue() == true){
                       asm = new asmNode("movl   ","$1",", "+res_location.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                   } else if (v1.getValue() == false){
                       asm = new asmNode("movl   ","$0",", "+res_location.getOffset()+"(%ebp)");
                       getNodes().add(asm);
                   }
               } else if (node.getV1() instanceof IntLiteral){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   asm = new asmNode("movl   ","$"+v1,", "+res_location.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               } else if (node.getV1() instanceof FloatLiteral){
                   FloatLiteral v1 = (FloatLiteral) node.getV1();
                   asm = new asmNode("movl   ","$"+v1,", "+res_location.getOffset()+"(%ebp)");
                   getNodes().add(asm);
               }
               break;
           case INC:
                if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("add   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
               } else if (node.getV1() instanceof FloatLiteral){
                   FloatLiteral v1 = (FloatLiteral) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("add   ","%eax, ",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx, ",", -"+res.getOffset()+"(%ebp)");
               } else if (node.getV1() instanceof IntLiteral){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("add   ","%eax, ",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx, ",", -"+res.getOffset()+"(%ebp)");
               }
               break;
           case DEC:
              if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("subl   ","%eax",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx",", -"+res.getOffset()+"(%ebp)");
               } else if (node.getV1() instanceof FloatLiteral){
                   FloatLiteral v1 = (FloatLiteral) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("subl   ","%eax, ",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx, ",", -"+res.getOffset()+"(%ebp)");
               } else if (node.getV1() instanceof IntLiteral){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","-"+res.getOffset()+"(%ebp)",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("subl   ","%eax, ",", %edx");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%edx, ",", -"+res.getOffset()+"(%ebp)");
               }
               break;
           case LABELRETCALL:
               getNodes().add(new asmNode("     pop %ebp",null,null));
               getNodes().add(new asmNode("ret",null,null));
               break;
           case LABELRETURN:
               if (node.getV1() instanceof IntLiteral){
                   IntLiteral v1 = (IntLiteral) node.getV1();
                   asm = new asmNode("movl   ","$"+v1.getRawValue(),"%rax");
                   getNodes().add(asm);
               } else if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)","%eax");
                   getNodes().add(asm);
                   asm = new asmNode("movl   ","%eax","%rax");
                   getNodes().add(asm);
               }
               break;
           case LABELIF:
               if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("jne   ",v2.toString().toLowerCase(), null);
                   getNodes().add(asm);
               }
               break;
           case ENDIF:
               if (node.getResult() instanceof VarLocation){
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("."+res.toString().toLowerCase(),null,null);
                   getNodes().add(asm);
               }
               break;
           case ELSEFLAG:
               if (node.getResult() instanceof VarLocation){
                   asm = new asmNode("."+node.getResult().toString().toLowerCase(),null,null);
                   getNodes().add(asm);
               }
               break;
           case LABELWHILE:
               if (node.getV1() instanceof VarLocation){
                   asm = new asmNode("."+node.getV1().toString().toLowerCase(),null,null);
                   getNodes().add(asm);
               }
               break;
           case CONDITIONWHILE:
               if (node.getV1() instanceof VarLocation){
                   VarLocation v1 = (VarLocation) node.getV1();
                   asm = new asmNode("movl   ","-"+v1.getOffset()+"(%ebp)",", %eax");
                   getNodes().add(asm);
                   asm = new asmNode("cmp   ","%eax",", $1");
                   getNodes().add(asm);
                   asm = new asmNode("jne   ",node.getResult().toString().toLowerCase(),null);
                   getNodes().add(asm);
               }
           case ENDWHILE:
               if (node.getResult() instanceof VarLocation){
                   asm = new asmNode("."+node.getResult().toString().toLowerCase(),null,null);
                   getNodes().add(asm);
               }
               break;
           case LABELFOR:
               asm = new asmNode("."+node.getResult().toString(),null,null);
               getNodes().add(asm);
               break;
           case LFF:
               asm = new asmNode("."+node.getResult().toString(),null,null);
               getNodes().add(asm);
               break;
           case LABELBREAK:
               asm = new asmNode("jmp",null,null);
               getNodes().add(asm);
               break;
           case LABELCONTINUE:
               asm = new asmNode("jmp   ",node.getResult(),null);
               getNodes().add(asm);
               break;
           case LABELMETHOD:
               asm = new asmNode(node.getResult().toString().toLowerCase()+":",null,null);
               getNodes().add(asm);
               break;
           case OFFSET:
               int of = (int) node.getResult()/8;
               getNodes().add(new asmNode("pushl ", "%ebp", null));
               getNodes().add(new asmNode("movl ", "%esp, ", "%ebp"));
               getNodes().add(new asmNode("subl", " $"+node.getResult(),", %esp"));
               
           case LABELPARAMADD:
               if (node.getResult() instanceof VarLocation){
                   VarLocation res = (VarLocation) node.getResult();
                   asm = new asmNode("pushl  ","-"+res.getOffset()+"(%ebp)",null);
                   getNodes().add(asm);
               } else if (node.getResult() instanceof IntLiteral){
                   IntLiteral res = (IntLiteral) node.getResult();
                   asm = new asmNode("pushl  ","$"+res.toString(),null);
                   getNodes().add(asm);
               } else if (node.getResult() instanceof FloatLiteral){
                   FloatLiteral res = (FloatLiteral) node.getResult();
                   asm = new asmNode("pushl  ","$"+res.toString(),null);
                   getNodes().add(asm);
               }
               params++;
               break;
           case GOTO:
               if (node.getResult() instanceof VarLocation){   
                    asm = new asmNode("jmp   ",node.getResult().toString(),null);
                    getNodes().add(asm);
               }
               break;
           case CALLMETHOD:
               if (params >0){
                   int i = 1;
                   while (i<=params){
                       switch (i){
                               case 1:            
                                   asm = new asmNode("movl  ","%rdi",", -8(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                               case 2: 
                                   asm = new asmNode("movl  ","%rsi",", -16(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                               case 3:
                                   asm = new asmNode("movl   ","%rdx",", -24(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                               case 4:
                                   asm = new asmNode("movl   ","%rcx",", -32(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                               case 5:
                                   asm = new asmNode("movl   ","%r8",",  -40(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                               case 6:
                                   asm = new asmNode("movl   ","%r9",",  -48(%rbp)");
                                   getNodes().add(asm);
                                   i++;
                       } 
                   }
               }
               asm = new asmNode("call  ",node.getResult(),null);
               getNodes().add(asm);
               
       }
   }

    /**
     * @return the nodes
     */
    public LinkedList<asmNode> getNodes() {
        return nodes;
    }

}
/*
               if ((node.getV1() instanceof Literal) && (node.getV2() instanceof VarLocation)){
                   VarLocation v2 = (VarLocation) node.getV2();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV1() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV1() instanceof IntLiteral){
                           
                   }
               } else if ((node.getV2() instanceof Literal) && (node.getV1() instanceof VarLocation)){
                   VarLocation v1 = (VarLocation) node.getV1();
                   VarLocation res = (VarLocation) node.getResult();
                   if (node.getV2() instanceof FloatLiteral) {
                       //Do float stuff
                   } else if (node.getV2() instanceof IntLiteral){
                          
                   }
               } else if (node.getV1() instanceof Literal && node.getV2() instanceof Literal) {
                   if (node.getV1() instanceof FloatLiteral || node.getV2() instanceof FloatLiteral) {
                       //Floaty McFloatFace
                   } else {
                           
                   }
               } else if ((node.getV1() instanceof VarLocation) && (node.getV2() instanceof VarLocation)){
                   
               }
               break;
*/