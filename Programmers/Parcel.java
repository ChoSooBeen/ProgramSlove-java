package Programmers;

/**
 * 택배 배달과 수거하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 */
public class Parcel {
    public static void main(String[] args) {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};
        System.out.println(solution(cap, n, deliveries, pickups));
    }

    /**
     * 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
     * @param cap 트럭 용량
     * @param n 배달할 집의 개수
     * @param deliveries 각 집에 배달할 택배 상자의 개수
     * @param pickups 각 집에서 수거할 상자 개수
     * @return 최소 이동 거리
     */
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int d = 0; // 배달할 택배 개수 상태
        int p = 0; // 수거할 택배 개수 상태
        for(int i = n-1; i >= 0; i--) { //물류창고에서 가장 먼 곳의 작업부터 처리!
            // 음수인 경우 : 작업이 남아있다.
            d -= deliveries[i];
            p -= pickups[i];

            while(d < 0 || p < 0) {
                // 이동하는 동안 옮길 수 있는 용량 추가
                d += cap;
                p += cap;
                answer += (i+1) * 2; // 물류창고에서 (i+1)번째 집까지 이동거리
            }
        }
        return answer;
    }
}
