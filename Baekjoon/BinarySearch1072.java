package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BinarySearch1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = getPercent(x, y);

        int left = 0;
        int right = 1000000000;
        int answer = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(getPercent(x+mid, y+mid) != z) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        bw.write(answer + "");
        bw.flush();
        bw.close();
    }

    static int getPercent(int x, int y) {
        return (int)(((long)y*100) / x);
    }
}
