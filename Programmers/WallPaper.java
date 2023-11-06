package Programmers;

import java.util.Arrays;

/**
 * 바탕화면 정리
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
public class WallPaper {
    public static void main(String[] args) {
        String[] wallpaper = {"..", "#."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    /**
     * 모든 파일을 선택할 수 있는 좌표 구하기
     * @param wallpaper . # 으로 이루어진 문자열 배열
     * @return 시작점과 끝점 좌표 배열
     */
    public static int[] solution(String[] wallpaper) {
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        int[] answer = {row-1, col-1, 0, 0};
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], j+1);
                }
            }
        }
        return answer;
    }
}
