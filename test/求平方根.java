package test;

import java.text.NumberFormat;

public class 求平方根 {
    // 支持 n >= 1;
    public String sqrt(int num, int k){
        double result = 1;
        int bit = 0;
        double offset = 10;
        NumberFormat nf = NumberFormat.getNumberInstance();
        // nf.setRoundingMode(RoundingMode.HALF_UP);
        nf.setMaximumFractionDigits(k);
        nf.setMinimumFractionDigits(k);
        while(bit <= k){
            offset = offset / 10;
            
            while(result >= 1 && result <= num/2+1){

                if(result < (num / result)){
                    result += offset;
                }
                else if (result > (num / result)){
                    result -= offset;
                    break;
                }
                else{
                    return nf.format(result);
                }
            }
            bit++;
        }
        return nf.format(result);
    }

    public static void main(String[] args) {
        求平方根 solution = new 求平方根();
        System.out.println(solution.sqrt(4, 3));
    }
}
