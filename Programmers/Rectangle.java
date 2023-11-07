package Programmers;

/**
 * 최소직사각형
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Rectangle {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
//        int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        System.out.println(solution(sizes));
    }

    /**
     * 주어진 사이즈의 명함이 전부 들어갈 수 있는 크기의 직사각형 구하기
     * @param sizes 명함의 크기가 들어있는 2차원 배열
     * @return 최소 직사각형 넓이
     */
    public static int solution(int[][] sizes) {
        int w = 0; //명함의 크기에서 큰 변의 길이 중 가장 긴 길이
        int h = 0; //명함의 크기에서 작은 변의 길이 중 가장 긴 길이
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                w = Math.max(w, sizes[i][1]);
                h = Math.max(h, sizes[i][0]);
            }
            else {
                w = Math.max(w, sizes[i][0]);
                h = Math.max(h, sizes[i][1]);
            }
        }
        int  answer = w * h;
        return answer;
    }
}
