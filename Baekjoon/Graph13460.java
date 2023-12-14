package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Graph13460 {
    public static class Node { //빨간 구슬의 x, y 좌표, 파란 구슬의 x, y 좌표, 이동 횟수
        int rx, ry, bx, by, count;
        public Node(int rx, int ry, int bx, int by, int count) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] graph = new char[n][m];
        int[] red = {0, 0};
        int[] blue = {0, 0};
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                graph[i][j] = input.charAt(j);
                if(graph[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
                else if (graph[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }

        System.out.println(BFS(graph, red, blue));
    }
    public static int BFS(char[][] graph, int[] red, int[] blue) {
        Queue<Node> queue = new LinkedList<>();
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //상하좌우
        int n = graph.length;
        int m = graph[0].length;
        boolean[][][][] visited = new boolean[n][m][n][m];

        queue.offer(new Node(red[0], red[1], blue[0], blue[1], 0));
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.count >= 10) { //10번 이상일 경우
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nrx = current.rx;
                int nry = current.ry;
                int nbx = current.bx;
                int nby = current.by;

                boolean rflag = false;
                boolean bflag = false;

                while(graph[nrx + dir[i][0]][nry + dir[i][1]] != '#') { //빨간 구슬이 벽을 만나기 전까지 움직인다.
                    nrx += dir[i][0];
                    nry += dir[i][1];
                    if(graph[nrx][nry] == 'O') {
                        rflag = true;
                        break;
                    }
                }

                while(graph[nbx + dir[i][0]][nby + dir[i][1]] != '#') { //파란 구슬이 벽을 만나기 전까지 움직인다.
                    nbx += dir[i][0];
                    nby += dir[i][1];
                    if(graph[nbx][nby] == 'O') {
                        bflag = true;
                        break;
                    }
                }

                if(bflag) { //파란 구슬이 구멍에 빠졌을 경우
                    continue;
                }
                if(rflag) { //빨간 구슬이 구멍에 빠졌을 경우
                    return current.count + 1;
                }

                if(nrx == nbx && nry == nby) { //둘의 위치가 같을 경우 -> 뒤에 있던 구슬 뒤로 이동
                    if(i == 0) { //상
                        if(current.rx > current.bx) nrx -= dir[i][0];
                        else nbx -= dir[i][0];
                    }
                    else if(i == 1) { //하
                        if(current.rx > current.bx) nbx -= dir[i][0];
                        else nrx -= dir[i][0];
                    }
                    else if(i == 2) { //좌
                        if(current.ry > current.by) nry -= dir[i][1];
                        else nby -= dir[i][1];
                    }
                    else { //우
                        if(current.ry > current.by) nby -= dir[i][1];
                        else nry -= dir[i][1];
                    }
                }

                if(!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    queue.offer(new Node(nrx, nry, nbx, nby, current.count+1));
                }
            }
        }
        return -1;
    }
}
