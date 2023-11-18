package Programmers;

import java.util.PriorityQueue;

/**
 * 더 맵게
 * https://school.programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Spicy {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //최소 우선순위 큐
        for(int s : scoville)
            heap.add(s);

        /**
         * peek() : 최솟값 보기
         * poll() : 최솟값 꺼내기
         *
         * 원소가 최소 2개 이상일 경우
         * 최솟값이 K보다 작을 경우
         */
        while(heap.peek() < K && heap.size() > 1) {
            heap.add(heap.poll() + heap.poll() * 2);
            answer++;
        }

        if(heap.peek() < K) //만들지 못할 경우
            answer = -1;
        return answer;
    }
}
