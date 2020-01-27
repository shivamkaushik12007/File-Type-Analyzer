package analyzer;
import java.io.*;
import java.lang.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        long start=System.nanoTime();
        try{
            FileInputStream fl=new FileInputStream(args[1]);
            int ch;
            String s="";
            while((ch=fl.read())!=-1){
                s+=Character.toString((char)ch);
            }
            fl.close();
            String p="%PDF-";
            Search check=new Search();
            int k=0;
            if(args[0].equals("--naive")){
                k=check.naive(s,p);
            }else if(args[0].equals("--KMP")){
                k=check.KMP(p,s);
            }
            if(k==1){
                System.out.println(args[3]);
            }else {
                System.out.println("Unknown file type");
            }
            long took=System.nanoTime()-start;
            System.out.println("It took "+took+" seconds");
        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
