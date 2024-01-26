package Baekjoon;

import java.io.*;
import java.util.*;

public class HashMap7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String,Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String flag = st.nextToken();
            if(flag.charAt(0) == 'e') {
                map.put(name, 1);
            }
            else {
                map.remove(name);
            }
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for(int i = keyList.size()-1; i >= 0; i--) {
            bw.write(keyList.get(i)+"\n");
        }

        bw.flush();
        bw.close();
    }
}
