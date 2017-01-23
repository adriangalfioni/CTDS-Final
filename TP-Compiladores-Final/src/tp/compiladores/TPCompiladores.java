/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp.compiladores;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader; 
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import tp.compiladores.ast.AST;
import tp.compiladores.semcheck.GenI3DVisitor;
import tp.compiladores.semcheck.TypeCheckVisitor;
import tp.compiladores.asm.asmGen;
import tp.compiladores.asm.asmNode;
/**
 *
 * @author joako
 */
public class TPCompiladores {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        //System.out.println("Nombre de archivo para compilar:");
        //BufferedReader r = new BufferedReader( new InputStreamReader(System.in));
        //String path = r.readLine();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/"+args[0]));
        Yylex lex = new Yylex(br);
        parser p = new parser(lex);
        p.parse();
        LinkedList<AST> lista = new LinkedList();
        lista = p.action_obj.getAST();
        TypeCheckVisitor astv = new TypeCheckVisitor();
        GenI3DVisitor gen3d = new GenI3DVisitor();
        asmGen asmG = new asmGen();
        //System.out.println("Size: "+lista.size());
        
        for (AST a: lista){
            a.accept(gen3d);
            a.accept(astv).toString();
        }
        PrintWriter writer = new PrintWriter("i3d.txt","UTF-8");
        for (I3D i: gen3d.getI3d()){
            writer.println(i.toString());
            asmG.check(i);
        }
        writer.close();
        
        PrintWriter asmWriter = new PrintWriter("asm.txt","UTF-8");
        for (asmNode n: asmG.getNodes()){
            asmWriter.println(n.toString());
        }
        asmWriter.close();
        
    }
    
}
