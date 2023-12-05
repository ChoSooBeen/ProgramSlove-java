package Baekjoon;

import java.io.*;
import java.util.regex.Pattern; //정규표현식을 사용하기 위한 클래스 선언

public class String1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++) {
            String s = br.readLine();
            bw.write(isPattern(s) + "\n");
        }

        bw.flush();
        bw.close();
    }

    /**
     * 문제에서 주어진 패턴과 맞는지 확인하는 함수
     * @param s 확인할 문자열
     * @return 패턴에 일치하면 YES, 아니면 NO
     */
    public static String isPattern(String s) {
        String pattern = "^(100+1+|01)+$";

        if(Pattern.matches(pattern, s)) {
            return "YES";
        }
        return "NO";
    }
}
