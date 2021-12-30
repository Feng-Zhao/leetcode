package test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Test_JZ_20 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("^\\s*[\\+|-]?[(\\d+)|(\\d*\\.\\d+)]([e|E]([\\+|-])?\\d+)?\\s*$");
        while(in.hasNextLine()){
            String s = in.nextLine();
            System.out.println(p.matcher(s).matches());
        }
        in.close();
    }
}
