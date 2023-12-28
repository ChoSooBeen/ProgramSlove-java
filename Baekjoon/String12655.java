package Baekjoon;

import java.io.*;

public class String12655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int t = c + 13;
            if(c >= 'A' && c <= 'Z') {
                if(t > 'Z') t = t - 'Z' + 'A'-1;
                sb.append((char)t);
            }
            else if(c >= 'a' && c <= 'z') {
                if(t > 'z') t = t - 'z' + 'a'-1;
                sb.append((char)t);
            }
            else {
                sb.append(c);
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}