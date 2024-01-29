package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS16234 {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int n;
    static int l;
    static int r;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bw.write(getCount() + "");
        bw.flush();
        bw.close();
    }

    /**
     * 이동 횟수 구하기
     * @return
     */
    static int getCount() {
        int count = 0;
        while(true) {
            boolean flag = false;
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        if(bfs(new Node(i, j))) {
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) { //단 한번도 국경이 열리지 않았다면
                break;
            }
            count++;
        }
        return count;
    }

    /**
     * 국경 열리는지 탐색 후 이동
     * @param start 시작노드
     * @return 국경이 열리면 true, 아니면 false
     */
    static boolean bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();

        queue.offer(start);
        visited[start.x][start.y] = true;
        list.add(start);
        int sum = map[start.x][start.y];

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dir[i][0];
                int ny = current.y + dir[i][1];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(map[current.x][current.y] - map[nx][ny]);
                    if(diff >= l && diff <= r) {
                        queue.offer(new Node(nx, ny));
                        visited[nx][ny] = true;
                        list.add(new Node(nx, ny));
                        sum += map[nx][ny];
                    }
                }
            }
        }

        if(list.size() > 1) { //국경이 열린 곳이 존재하면
            move(list, sum);
            return true;
        }
        return false;
    }

    /**
     * 인구 이동
     * @param list 이동한 도시
     * @param sum 총 이동해야할 도시들의 인구수 합
     */
    static void move(ArrayList<Node> list, int sum) {
        int avg = sum / list.size();
        for(Node n : list) {
            map[n.x][n.y] = avg;
        }
    }
}
