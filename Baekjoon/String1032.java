package Baekjoon;

import java.io.*;

public class String1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] s = new String[n];
        for(int i = 0; i < n; i++) {
            s[i] = br.readLine().strip();
        }

        for(int i = 0; i < s[0].length(); i++) {
            boolean flag = true;
            for(int j = 1; j < n; j++) {
                if(s[0].charAt(i) != s[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                bw.write(s[0].charAt(i));
            }
            else {
                bw.write("?");
            }
        }

        bw.flush();
        bw.close();
    }
}
