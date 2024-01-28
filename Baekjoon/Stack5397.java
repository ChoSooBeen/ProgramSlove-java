package Baekjoon;

import java.io.*;
import java.util.Stack;

public class Stack5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t > 0) {
            t--;
            String s = br.readLine();
            bw.write(keyLogger(s) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static String keyLogger(String s) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '<' :
                    if(!left.isEmpty())
                        right.push(left.pop());
                    break;
                case '>' :
                    if(!right.isEmpty())
                        left.push(right.pop());
                    break;
                case '-' :
                    if(!left.isEmpty())
                        left.pop();
                    break;
                default :
                    left.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();
        while(!right.isEmpty()) {
            sb.append(right.pop());
        }

        return sb.toString();
    }
}
