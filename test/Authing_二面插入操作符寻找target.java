package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class Authing_二面插入操作符寻找target {

    // 通用的话可以设计为静态码表;
    Map<Integer,String> map = new HashMap<>();
    {
        map.put(0, "");
        map.put(1, "+");
        map.put(2, "-");
        map.put(3, "*");
    }
    
    public List<String> find (String nums, int target){
        // 结果集
        List<String> result = new ArrayList<>();
        // 对 空str（无值） 和 长度为1（无法添加操作符） 的 str 做特殊处理
        if(nums == null || nums.length() == 0) return result;
        if(nums.length() == 1){
            if(Integer.valueOf(nums) == target){
                result.add(nums);
            }
            return result;
        }
        
        // 当前路径(表达式)
        String[] expreesion = new String[nums.length() + nums.length() - 1];
        
        int numCursor = 0;//初始化expression用到的游标
        // 初始化expression,填写操作符的位置留空
        for (int i = 0; i < expreesion.length; i++) {
            if(i % 2 == 0){
                expreesion[i] = String.valueOf(nums.charAt(numCursor)) ;
                numCursor++;
            }
            else if(i < expreesion.length){
                expreesion[i] = "";
            }
        }
        // 回溯填写结果集
        fill(result,expreesion,target,1,expreesion.length);

        return result;
    }

    // 主体的回溯操作
    private void fill(List<String> result, String[] expression, int target, int curOpPos, int len){
        // 操作符已填满， 需要检测并根据检测结果添加express到result
        if(curOpPos >= len){
            // 检测表达式值是否为target
            if(check(expression,target)){
                // 组装表达式 并 添加到结果集
                result.add(composeExpression(expression));
            }
            return;
        }

        for (int i = 0; i < map.size(); i++) {
            if(curOpPos < expression.length){
                // 当前选择填入当前位置
                expression[curOpPos] = map.get(i);
                // dfs curOpPos深度+2，表示填写下一个操作符位置
                fill(result,expression,target,curOpPos+2,len);
                // 不需要撤销， 会自动覆盖
            }
        }
    }

    // 表达式解析
    // 这一部分可能能用一个栈/队列 来做表达式解析
    private boolean check(String[] expression,int target){
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        Queue<Integer> nums = new LinkedList<>();
        Queue<String> ops = new LinkedList<>();
        // 将 nums 和 ops 用不同 list 记录
        while(cur < expression.length){
            if(cur % 2 == 0){
                sb.append(expression[cur]);
            }
            else if(expression[cur] != ""){
                // 取前一个数字
                int preNum = Integer.valueOf(sb.toString());
                // 加入 list
                nums.offer(preNum);
                // 重置 sb
                sb.setLength(0);
                // ops list 加入当前操作符
                ops.add(expression[cur]);
            }
            cur++;
        }
        // 最后一个 num 入队
        nums.offer(Integer.valueOf(sb.toString()));

        // 计算 sum
        int sum = nums.poll();
        while(!nums.isEmpty()){
            int curNum = nums.poll();
            switch(ops.poll()){
                case "+" : sum += curNum; break;
                case "-" : sum -= curNum; break;
                case "*" : sum *= curNum; break;
                // 添加 default 不在许可范围的操作符 抛出异常
            }
        }
        return sum == target;
    }

    // char[] to Strign
    private String composeExpression(String[] expression){
        StringBuilder sb = new StringBuilder();
        for (String string : expression) {
            sb.append(string);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Authing_二面插入操作符寻找target solution = new Authing_二面插入操作符寻找target();
        String str = "2687";
        int target = 113;
        List<String> result = solution.find(str, target);
        Iterator<String> i = result.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
