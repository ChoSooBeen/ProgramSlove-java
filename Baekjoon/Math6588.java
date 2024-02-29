package Baekjoon;

import java.io.*;

public class Math6588 {

    static int max = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] primes = new boolean[max];
        for(int i = 3; i < max; i += 2) {
            if(isPrime(i))
                primes[i] = true;
        }

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                break;
            }

            boolean flag = false;
            for(int i = 3; i < max; i += 2) {
                if(primes[i] && primes[n-i]) {
                    flag = true;
                    bw.write(n + " = " + i + " + " + (n-i) + "\n");
                    break;
                }
            }

            if(!flag) {
                bw.write("Goldbach's conjecture is wrong.\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static boolean isPrime(int target) {
        if (target < 2) return false;
        for(int i = 2; i <= Math.sqrt(target); i++) {
            if(target % i == 0)
                return false;
        }
        return true;
    }
}