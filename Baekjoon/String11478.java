package Baekjoon;

import java.util.HashMap;
import java.util.Scanner;

public class String11478 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(solve(input));
    }
    public static int solve(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                String t = s.substring(i, j);
                if(!map.containsKey(t)) {
                    map.put(t, 1);
                }
            }
        }
        return map.size();
    }
}