package SPOSL;
import java.util.*;
public class SJF {
    public static void main(String[] args){
        System.out.println("Shortest Job First");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the process number:");
        int n=sc.nextInt();
        float avg_TAT=0,avg_WT=0;
        int process[]=new int[n];
        int AT[]=new int[n];
        int BT[]=new int[n];
        int CT[]=new int[n];
        int TAT[]=new int[n];
        int WT[]=new int[n];
        for(int i=0;i<process.length;i++){
            System.out.println("Enter the process["+i+"]");
            process[i]=sc.nextInt();
            System.out.println("Enter the arrival time:");
            AT[i]=sc.nextInt();
            System.out.println("Enter the Burst time:");
            BT[i]=sc.nextInt();
        }
        for(int i=0;i<process.length;i++){
            for(int j=i+1;j<process.length;j++){
                if(BT[i]>BT[j]){
                    int tempBT=BT[i];
                    BT[i]=BT[j];
                    BT[j]=tempBT;
                    int tempP=process[i];
                    process[i]=process[j];
                    process[j]=tempP;
                    int tempAT=AT[i];
                    AT[i]=AT[j];
                    AT[j]=tempAT;
                }
            }
        }
        System.out.println("--------------------------------------------");
        System.out.println("process\t\tAT\tBT\tCT\tTAT\tWT");
        System.out.println("-------------------------------------------");
        for(int i=0;i<process.length;i++){
            if(i==0)
                CT[0]=AT[0]+CT[0];
            else
                CT[i]=Math.max(CT[i-1],AT[i])+BT[i];
            TAT[i]=CT[i]-AT[i];
            WT[i]=TAT[i]-BT[i];
            avg_TAT+=TAT[i];
            avg_WT+=WT[i];
            System.out.println(process[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Average of the TAT: "+avg_TAT/n);
        System.out.println("Average of the WT: "+avg_WT/n);


        sc.close();

    }
}
