package SPOSL;
public class ReaderWriter {
    static int read_count=0;
    static int mutex=1;
    static int database=1;
    static int wait(int mutex)
    {
        while(mutex<=0){
            break;
        }
        mutex=mutex-1;
        return mutex;
    }
    static int signal(int database)
    {
        database=database+1;
        return database;
    }
    static void Reader() throws Exception{
        while(true){
            mutex=wait(mutex);
            read_count=read_count+1;
            if(read_count==1){
                database=signal(database);
            }
            mutex=signal(mutex);
            System.out.println(read_count+" User is reading data... ");
            mutex=wait(mutex);
            read_count=read_count-1;
            if(read_count==0){
                database=signal(database);
            }
            mutex=signal(mutex);
            System.out.println("Reading is finshed!!!");
            break;
        }
    }
    static void Writer() throws Exception{
        while(true){
            database=wait(database);
            System.out.println("Writing the data....");
            database=signal(database);
            System.out.println("Writing is finished!!!");
            break;
        }
    }
    public static void main(String[] args) throws Exception{
        Writer();
        Reader();
        Reader();
    }
}
