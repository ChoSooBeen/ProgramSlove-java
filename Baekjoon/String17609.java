package Baekjoon;

import java.io.*;

public class String17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String s = br.readLine();
            bw.write(isPalindrome(s, 0, s.length()-1, false) + "\n");
        }
        bw.flush();
        bw.close();
    }

    /**
     * 팰린드롬 문자열인지 확인하는 함수
     * @param s 문자열
     * @param start 현재 탐색하고 있는 앞 인덱스
     * @param end 현재 탐색하고 있는 뒤 인덱스
     * @param remove 유사회문인지 구분하는 변수
     * @return 회문 0, 유사회문 1, 아닌 경우 2
     */
    public static int isPalindrome(String s, int start, int end, boolean remove) {
        boolean flag = false;
        while(start <= end) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            }
            else {
                flag = true;
                break;
            }
        }

        if(flag) {
            if (remove) {
                return 2;
            }
            int front = isPalindrome(s, start+1, end, true);
            int back = isPalindrome(s, start, end-1, true);
            if(front == 0 || back == 0) {
                return 1;
            }
            return 2;
        }
        return 0;
    }
}
