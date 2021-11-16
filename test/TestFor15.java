package test;
import java.io.FileInputStream;

public class TestFor15 {


    public static void mian (String[] args){
        try{
            FileInputStream fis_answer = new FileInputStream("./15answer.txt");
            FileInputStream fis_exception = new FileInputStream("./15exception.txt");
            
            
            

            fis_answer.close();
            fis_exception.close();
        

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
