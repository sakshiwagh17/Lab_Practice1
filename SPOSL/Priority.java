package SPOSL;
import java.util.*;
public class Priority {
    public static void main(String[] args){
        System.out.println("Priority Sheduling");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the process number:");
        int n=sc.nextInt();
        int sum=0;
        float avg_TAT=0,avg_WT=0;
        int process[] =new int[n];
        int pty[]=new int[n];
        int AT[]=new int[n];
        int BT[]=new int[n];
        int CT[]=new int[n];
        int TAT[] =new int[n];
        int WT[]=new int[n];
        for(int i=0;i<process.length;i++)
        {
            System.out.println("Enter the process["+i+"]");
            process[i]=sc.nextInt();
            System.out.println("Enter the priority:");
            pty[i]=sc.nextInt();
            System.out.println("Enter the Arrival time:");
            AT[i]=sc.nextInt();
            System.out.println("Enter the burst time:");
            BT[i]=sc.nextInt();
        }
        for(int i=0;i<process.length;i++){
            for(int j=i+1;j<process.length;j++){
                if(pty[i]>pty[j]){
                    int tempPR=pty[i];
                    pty[i]=pty[j];
                    pty[j]=tempPR;
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
        System.out.println("-----------------------------------------------");
        System.out.println("process\t\tpriority\tAT\tBT\tCT\tTAT\tWT\t");
        System.out.println("---------------------------------------------------");
        for(int i=0;i<process.length;i++){
            sum+=BT[i];
            CT[i]=sum;
            TAT[i]=CT[i]-AT[i];
            WT[i]=TAT[i]-BT[i];
            avg_TAT+=TAT[i];
            avg_WT+=WT[i];
            System.out.println(process[i]+"\t\t"+pty[i]+"\t\t"+AT[i]+"\t"+BT[i]+"\t"+CT[i]+"\t"+TAT[i]+"\t"+WT[i]);
        }
        System.out.println("Average of TAT: "+avg_TAT/n);
        System.out.println("Average of WT: "+avg_WT/n);
        sc.close();
    }
}
