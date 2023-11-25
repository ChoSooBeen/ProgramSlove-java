package Programmers;

import java.util.Stack;

/**
 * 표 편집
 * https://school.programmers.co.kr/learn/courses/30/lessons/81303
 */
public class Kakao2021_03 {
    public static class Node { //연결리스트 노드
        Node pre, next;
        boolean isDelete;
    }
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(solution(n, k, cmd));
    }
    public static String solution(int n, int k, String[] cmd) {
        Node[] nodes = new Node[n];
        nodes[0] = new Node();
        for(int i = 1; i < n; i++) {
            nodes[i] = new Node();
            nodes[i].pre = nodes[i-1];
            nodes[i-1].next = nodes[i];
        }

        Node current = nodes[k];
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < cmd.length; i++) {
            String[] c = cmd[i].split(" ");
            switch (c[0]) {
                case "U" :
                    int up = Integer.parseInt(c[1]);
                    for(int j = 0; j < up; j++) {
                        current = current.pre;
                    }
                    break;
                case "D" :
                    int down = Integer.parseInt(c[1]);
                    for(int j = 0; j < down; j++) {
                        current = current.next;
                    }
                    break;
                case "C" :
                    current.isDelete = true;
                    stack.push(current);
                    if(current.pre != null) {
                        current.pre.next = current.next;
                    }
                    if(current.next != null) {
                        current.next.pre = current.pre;
                        current = current.next;
                    }
                    else {
                        current = current.pre;
                    }
                    break;
                case "Z" :
                    Node node = stack.pop();
                    node.isDelete = false;
                    if(node.pre != null) {
                        node.pre.next = node;
                    }
                    if(node.next != null) {
                        node.next.pre = node;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            if(nodes[i].isDelete) {
                sb.append("X");
            }
            else {
                sb.append("O");
            }
        }
        return sb.toString();
    }
}
