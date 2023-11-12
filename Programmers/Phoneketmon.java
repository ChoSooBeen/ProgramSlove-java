package Programmers;

import java.util.HashMap;

/**
 * 폰켓몬
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 */
public class Phoneketmon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }
    public static int solution(int[] nums) {
        int answer = 0;
        int length = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
                answer++;
            }
        }
        if(answer > (length / 2)) {
            answer = length / 2;
        }
        return answer;
    }
}
