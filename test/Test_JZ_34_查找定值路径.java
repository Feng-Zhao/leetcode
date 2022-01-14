package test;

import java.util.ArrayList;
import java.util.List;

public class Test_JZ_34_查找定值路径 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> road = new ArrayList<>();
        dfs(root,road,target,result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> road, int target, List<List<Integer>> result){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            if(node.val == target){
                List<Integer> oneResult = new ArrayList<>(road);
                oneResult.add(node.val);
                result.add(oneResult);
            }
            else{
                return;
            }
        }
        
        road.add(node.val);
        dfs(node.left, road, target-node.val, result);
        dfs(node.right,road, target-node.val, result);
        road.remove(road.size()-1);
    }
}
