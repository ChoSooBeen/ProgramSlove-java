package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoPointer1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] nums = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(minLength(nums, s));
    }

    public static int minLength(int[] nums, int target) {
        int answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int sum = 0;
        while(start < nums.length && end < nums.length) {
            if(sum >= target) {
                answer = Math.min(answer, end - start);
            }

            if(sum > target) {
                sum -= nums[start++];
            }
            else {
                sum += nums[end++];
            }
        }

        if(answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }
}
