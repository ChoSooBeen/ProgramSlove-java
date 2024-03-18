package Baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Stack10799 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else {
                stack.pop();
                if(s.charAt(i-1) == '(')
                    result += stack.size();
                else
                    result++;
            }
        }
        System.out.println(result);
    }
}
