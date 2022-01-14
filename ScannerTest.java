import java.nio.file.WatchService;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = Integer.valueOf(in.next("\\d+"));
            String op = in.next("\\d+");
            System.out.println("num:"+num);
            System.out.println("op:"+op);
        }
    }
}
