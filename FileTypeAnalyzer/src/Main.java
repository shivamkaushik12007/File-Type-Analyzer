import java.io.*;
import java.lang.*;
import java.util.*;
public class Main{
    public static void main(String[] args) {
        ArrayList<String> arr=new ArrayList<>();
        try{
            BufferedReader br=new BufferedReader(new FileReader(args[1]));
            String line="";
            while((line=br.readLine())!=null){
                arr.add(line);
            }
            br.close();
            File file = new File(args[0]);
            File[] files = file.listFiles();
            for(File f: files){
                String s=f.getName();
                Thread ft=new Thread(new FileType(args[0],s,arr),s);
                ft.start();
                ft.join();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        Thread t=new Thread();
        t.start();
    }
}
