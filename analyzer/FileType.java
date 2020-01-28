package analyzer;
import java.io.*;
import java.lang.*;
import java.util.*;
public class FileType extends Thread{
    private String args[];
    public FileType(String[] args){
        this.args=args.clone();
    }

    @Override
    public void run(){
        try{
            FileInputStream fl=new FileInputStream(args[0]+"/"+args[3]);
            int ch;
            String s="";
            while((ch=fl.read())!=-1){
                s+=Character.toString((char)ch);
            }
            fl.close();
            if(s.contains(args[1])){
                System.out.println(args[3]+": "+args[2]);
            }else {
                System.out.println(args[3]+": Unknown file type");
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
