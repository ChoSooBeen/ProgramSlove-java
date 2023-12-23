package Baekjoon;

import java.io.*;
import java.util.*;

public class String1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys); //key값 사전순 정렬
        Collections.sort(keys, (v1, v2) -> (map.get(v2).compareTo(map.get(v1)))); //value값이 큰 순으로 정렬
        System.out.println(keys.get(0));
    }
}
