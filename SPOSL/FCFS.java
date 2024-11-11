package SPOSL;
import java.util.*;
public class FCFS {
    //Here those process come first will Served first
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of process:");
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
            System.out.println("Enter the Arival time:");
            AT[i]=sc.nextInt();
            System.out.println("Enter the burst time:");
            BT[i]=sc.nextInt();
        }
        for(int i=0;i<process.length;i++){
            for(int j=i+1;j<process.length;j++){
                if(AT[i]>AT[j]){
                    int tempAT=AT[i];
                    AT[i]=AT[j];
                    AT[j]=tempAT;
                    int tempP=process[i];
                    process[i]=process[j];
                    process[j]=tempP;
                    int tempBT=BT[i];
                    BT[i]=BT[j];
                    BT[j]=tempBT;
                }
            }
        }
        CT[0]=AT[0]+BT[0];
        for(int i=1;i<process.length;i++){
            CT[i]=CT[i-1]+BT[i];
        }
        System.out.println("--------------------------------------------");
        System.out.println("process\t\tAT\tBT\tCT\tTAT\tWT");
        System.out.println("----------------------------------------");
        for(int i=0;i<process.length;i++){
            TAT[i]=CT[i]-AT[i]; //turnaround=completion-arrival
            WT[i]=TAT[i]-BT[i]; //waiting=turnaround-burst
            avg_TAT+=TAT[i];
            avg_WT+=WT[i];
            System.out.println(process[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        System.out.println("--------------------------------------");
        System.out.println("Average of TAT: "+avg_TAT/n);
        System.out.println("Average of WT: "+avg_WT/n);
        System.out.println("----------------------------------------");
        sc.close();
    }
}
