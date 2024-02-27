package Baekjoon;

import java.io.*;

public class Math4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            bw.write(countPrime(n)+"\n");
        }
        bw.flush();
        bw.close();
    }

    static int countPrime(int n) {
        int count = 0;
        for(int i = n+1; i <= 2*n; i++) {
            if(isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
