package Baekjoon;

import java.io.*;
import java.util.Stack;

public class Stack3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i < n; i++) {
            String s = br.readLine().strip();
            if(isGood(s)) {
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }

    static boolean isGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
            }
            else if(stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        if(stack.isEmpty())
            return true;
        return false;
    }
}
