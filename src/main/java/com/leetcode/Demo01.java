package com.leetcode;

import java.util.HashMap;

/*
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
* */
public class Demo01 {
    public static int[] twoSum(int[] nums, int target) {
        //时间复杂度过高
       /* for(int i = 0 ;i < nums.length;i++) {
            for(int j = i+1; j< nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    int[] news = new int[] {i,j};
                    return news;
                }
            }
        }
        return null;*/
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]),i};
            }
            map.put(target-nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
           int[] nums = {2, 7, 11, 15};
           int[] ints = twoSum(nums, 9);
            for (int i = 0; i < ints.length; i++) {
                System.out.println(ints[i]);
         }
    }

}
