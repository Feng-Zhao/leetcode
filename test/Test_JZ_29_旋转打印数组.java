package test;

public class Test_JZ_29_旋转打印数组 {
    int upLimit;
    int rightLimit;
    int downLimit;
    int leftLimit;
    int direction = 0;
    int posX = 0, posY = 0;

    public int[] spiralOrder(int[][] matrix) {
        upLimit = 0;
        rightLimit = matrix[0].length - 1;
        downLimit = matrix.length - 1;
        leftLimit = 0;

        int cur = 0;
        int[] newNums = new int[matrix.length * matrix[0].length];
        while (inBound()){
            newNums[cur] = matrix[posX][posY];
            cur++;
            nextPos();
        }
        return newNums;
    }

    private boolean inBound(){
        if(upLimit <= downLimit && leftLimit <= rightLimit){
            return true;
        }
        return false;
    }

    private void nextPos(){
        boolean turnFlag = false;
        // 优化,用enum
        switch (direction){
            // 向右
            case 0:
                if(posY < rightLimit) posY++;
                else {
                    posX++;
                    upLimit++;
                    turnFlag = true;
                }
                break;
            // 向下
            case 1:
                if(posX < downLimit) posX++;
                else{
                    posY--;
                    rightLimit--;
                    turnFlag = true;
                }
                break;
            // 向左
            case 2:
                if(posY > leftLimit) posY--;
                else{
                    posX--;
                    downLimit--;
                    turnFlag = true;
                }
                break;
            // 向上
            case 3:
                if(posX > upLimit) posX--;
                else{
                    posY++;
                    leftLimit++;
                    turnFlag = true;
                }
                break;
        }
        if(turnFlag){
            direction = (direction + 1) % 4;
        }
    }
    
    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        int[] a = {1,2,3};
        int[] b = {4,5,6};
        int[] c = {7,8,9};
        nums[0] = a; nums[1] = b; nums[2] = c;

        Test_JZ_29_旋转打印数组 solution = new Test_JZ_29_旋转打印数组();
        int[] result = solution.spiralOrder(nums);
        for (int i : result) {
            System.out.format("%d,",i);
        }
    }
}
