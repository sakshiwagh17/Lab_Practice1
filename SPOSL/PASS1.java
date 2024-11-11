package SPOSL;
import java.util.*;
class Assembler{
    ArrayList<ArrayList<String>> ic=null;
    ArrayList<ArrayList<String>> sym=null;
    ArrayList<ArrayList<String>> lit=null;
    ArrayList<ArrayList<String>> pol=null;
    public String[][] getLCfromSource(String[][] asm){
        int start_val=0;
        for(int i=0;i<asm.length;i++){
            for(int j=0;j<4;j++){
                if(asm[i][j].equals("START")){
                    start_val=Integer.parseInt(asm[i][j+1]);
                }
            }
            if(i==0){
                continue;
            }
            start_val=start_val+1;
            asm[i][0]=String.valueOf(start_val);
        }
        return asm;
    }
    public void printCode(String[][] asm){
        for(int i=0;i<asm.length;i++){
            for(int j=0;j<4;j++){
                System.out.print("         "+asm[i][j]);
            }
            System.out.println();
        }
    }
    public void generateOutput(String[][] asm,String[][] mot){
        ArrayList<ArrayList<String>> ic=new ArrayList(asm.length);
        ArrayList<ArrayList<String>> sym=new ArrayList(asm.length);
        ArrayList<ArrayList<String>> lit=new ArrayList(asm.length);
        ArrayList<ArrayList<String>> pol=new ArrayList(asm.length);
        for(int i=0;i<asm.length;i++){
            ic.add(new ArrayList());
            sym.add(new ArrayList());
            lit.add(new ArrayList());
            pol.add(new ArrayList());
        }
        for(int i=0;i<asm.length;i++){
            for(int j=0;j<4;j++){
                for(int m=0;m<mot.length;m++){
                    if(asm[i][j].equals(mot[m][0])){
                        String icStr="(" +mot[m][1]+","+mot[m][2] +")";
                        ic.get(i).add(icStr);
                    }
                    
                }
                if(asm[i][j].equals(mot[15][0])||asm[i][j].equals(mot[12][0])){
                    String polStr="("+asm[i][j]+","+asm[i][0]+")";
                    pol.get(i).add(polStr);
                }
                if(asm[i][j].matches("[a-zA-z]")){
                    String symStr="("+asm[i][j]+","+asm[i][0]+")";
                    sym.get(i).add(symStr);
                    String icStr = "(S" +"," + asm[i][j]+")";
					ic.get(i).add(icStr);
                }
                if(asm[i][j].matches("[0-9]+") && asm[i][j]!=asm[i][0]){
                    String litStr="("+asm[i][j]+","+asm[i][0]+")";
                    lit.get(i).add(litStr);
                }
                
            }
        }
        this.ic=ic;
        this.sym=sym;
        this.lit=lit;
        this.pol=pol;
    }
}
public class PASS1 {
    public static void main(String[] args){
        String asm_code[][]= {
            {"","","START","200",""},
            {"","","MOVER","AREG","X"},
            {"","","MOVEM","BREG","Y"},
            {"","X","DS","1",""},
            {"","","END","",""}
    };

        String[][] mot_table={
            {"STOP","IS","00"},
            {"ADD","IS","01"},
            {"SUB","IS","02"},
            {"MUILT","IS","03"},
            {"MOVER","IS","04"},
            {"MOVEM","IS","05"},
            {"COMP","IS","06"},
            {"BC","IS","07"},
            {"DIV","IS","08"},
            {"READ","IS","09"},
            {"PRINT","IS","10"},

            {"START","AD","01"},
            {"END","AD","02"},
            {"ORIGIN","AD","03"},
            {"EQU","AD","04"},
            {"LTROG","AD","05"},

            {"DS","DL","01"},
            {"DC","DL","02"},

            {"AREG","RG","01"},
            {"BREG","RG","02"},
            {"CREG","RG","03"},
        };
        Assembler assembler=new Assembler();
        String[][] get_ic;
        get_ic=assembler.getLCfromSource(asm_code);
        assembler.printCode(get_ic);
        assembler.generateOutput(get_ic, mot_table);
        System.out.println("Intermidiate code");
        for(ArrayList<String> str:assembler.ic){
            for(String st:str){
                System.out.print(st);
            }
            System.out.println();
        }
        System.out.println("Symbol table");
        for(ArrayList<String> str:assembler.sym){
            for(String st:str){
                System.out.print(st);
            }
            System.out.println();
        }
        System.out.println("Literal table");
        for(ArrayList<String> str:assembler.lit){
            for(String st:str){
                System.out.print(st);
            }
            System.out.println();
        }
        System.out.println("Pool table");
        for(ArrayList<String> str:assembler.pol){
            for(String st:str){
                System.out.print(st);
            }
            System.out.println();
        }
    }
}
