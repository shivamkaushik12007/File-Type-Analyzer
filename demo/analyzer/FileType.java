// package analyzer;
// import java.io.*;
// import java.lang.*;
// import java.util.*;
// public class FileType extends Thread{
//     private String args[];
//     public FileType(String[] args){
//         this.args=args.clone();
//     }

//     @Override
//     public void run(){
//         try{
//             FileInputStream fl=new FileInputStream(args[0]+"/"+args[3]);
//             int ch;
//             String s="";
//             while((ch=fl.read())!=-1){
//                 s+=Character.toString((char)ch);
//             }
//             fl.close();
//             if(s.contains(args[1])){
//                 System.out.println(args[3]+": "+args[2]);
//             }else {
//                 System.out.println(args[3]+": Unknown file type");
//             }
//         }catch(IOException ex){
//             ex.printStackTrace();
//         }catch(Exception ex){
//             ex.printStackTrace();
//         }
//     }
// }
















package analyzer;
import java.io.*;
import java.lang.*;
import java.util.*;
public class FileType extends Thread{
    private String folder;
    private String file;
    private ArrayList<String> pattern;
    public FileType(String folder,String file,ArrayList<String> pattern){
        this.folder=folder;
        this.file=file;
        this.pattern=(ArrayList<String>)pattern.clone();
    }

    @Override
    public void run(){
        try{
            FileInputStream fl=new FileInputStream(folder+"/"+file);
            int ch;
            String s="";
            while((ch=fl.read())!=-1){
                s+=Character.toString((char)ch);
            }
            fl.close();
            int k=0;
            String res="";
            for(int i=0;i<pattern.size();i++){
                String test=pattern.get(i);
                int k1=test.indexOf(";");
                int k2=test.lastIndexOf(";");
                int temp=Integer.parseInt(pattern.get(i).substring(0,k1));
                if(s.contains(test.substring(k1+2,k2-1))&&(temp>k)){
                    k=temp;
                    res=test.substring(k2+2,pattern.get(i).length()-1);
                }
            }
            if(k>0){
                System.out.println(file+": "+res);
            }else {
                System.out.println(file+": Unknown file type");
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
