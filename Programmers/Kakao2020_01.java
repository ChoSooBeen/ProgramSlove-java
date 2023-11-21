package Programmers;

/**
 * 키패드 누르기
 * https://school.programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Kakao2020_01 {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        System.out.println(solution(numbers, hand));
    }

    public static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        //0,1,2,3,4,5,6,7,8,9 의 좌표
        int[][] keypad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        int[] left = {3,0}; //왼손의 초기값 *의 좌표
        int[] right = {3,2}; //오른손의 초기값 #의 좌표
        for(int i = 0; i < numbers.length; i++) {
            boolean flag; //left = true, right = false
            if(numbers[i] % 3 == 1) { //1,4,7일 경우
                flag = true;
            }
            else if(numbers[i] % 3 == 0 && numbers[i] != 0) { //3,6,9일 경우
                flag = false;
            }
            else { //2,5,8,0일 경우
                int l = Math.abs(left[0] - keypad[numbers[i]][0]) + Math.abs(left[1] - keypad[numbers[i]][1]);
                int r = Math.abs(right[0] - keypad[numbers[i]][0]) + Math.abs(right[1] - keypad[numbers[i]][1]);
                if(l == r) {
                    flag = (hand.equals("left")) ? true : false;
                }
                else {
                    flag = (l > r) ? false : true;
                }
            }
            if(flag) {
                sb.append("L");
                left = keypad[numbers[i]];
            }
            else {
                sb.append("R");
                right = keypad[numbers[i]];
            }
        }
        return sb.toString();
    }
}
