package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BruteForce2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(solve(nums, m) + "");
        bw.flush();
        bw.close();
    }

    public static int solve(int[] nums, int m) {
        int count = 0;
        int sum = nums[0];
        int start = 0;
        int end = 0;
        while(start < nums.length && end < nums.length) {
            if(sum < m) {
                end++;
                if(end < nums.length) sum += nums[end];
            }
            else {
                if(sum == m) count++;
                sum -= nums[start];
                start++;
            }
        }
        return count;
    }
}
