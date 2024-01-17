package Baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class Stack1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character, Double> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for(int i = 0; i < n; i++) {
            map.put((char)('A' + i), Double.parseDouble(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                stack.push(map.get(c));
            }
            else {
                double a = stack.pop();
                double b = stack.pop();
                switch (c) {
                    case '+' :
                        stack.push(b + a);
                        break;
                    case '-' :
                        stack.push(b - a);
                        break;
                    case '*' :
                        stack.push(b * a);
                        break;
                    default:
                        stack.push(b / a);
                }
            }
        }

        bw.write(String.format("%.2f", stack.pop()));
        bw.flush();
        bw.close();
    }
}
