package Programmers;

import java.util.*;

public class BestAlbum {
    public static class Music {
        int idx;
        int play;
        public Music(int idx, int play) {
            this.idx = idx;
            this.play = play;
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<String> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList, ((o1, o2) -> map.get(o2) - map.get(o1)));

        ArrayList<Integer> result = new ArrayList<>();
        for(String g : keyList) {
            ArrayList<Music> list = new ArrayList<>();
            for(int i = 0; i < genres.length; i++) {
                if(genres[i].compareTo(g) == 0) {
                    list.add(new Music(i, plays[i]));
                }
            }
            Collections.sort(list, ((o1, o2) -> o2.play - o1.play));
            result.add(list.get(0).idx);
            if(list.size() != 1) {
                result.add(list.get(1).idx);
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}
