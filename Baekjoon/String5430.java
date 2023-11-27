package Baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class String5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        while(testcase > 0) {
            testcase--;

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String array = br.readLine();
            array = array.substring(1, array.length()-1);
            bw.write(acString(p, n, array.split(",")));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static String acString(String p, int n, String[] array) {
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(array));
        if(n == 0) {
            deque.poll();
        }
        boolean isFront = true;

        for(int i = 0; i < p.length(); i++) {
            char op = p.charAt(i);
            if(op == 'R') {
                isFront = !isFront;
            }
            else {
                if(deque.isEmpty()) {
                    return "error";
                }
                if(isFront) {
                    deque.pollFirst();
                }
                else {
                    deque.pollLast();
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append("[");
        if(isFront) {
            while(!deque.isEmpty()) {
                answer.append(deque.pollFirst());
                if(deque.size() != 0) {
                    answer.append(",");
                }
            }
        }
        else {
            while(!deque.isEmpty()) {
                answer.append(deque.pollLast());
                if(deque.size() != 0) {
                    answer.append(",");
                }
            }
        }
        answer.append("]");

        return answer.toString();
    }
}
