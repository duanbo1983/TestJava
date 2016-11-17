import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bod on 9/6/16.
 */
public class wiggle {

    static int max = 0;

    public static void main(String[] strings) {

        //[2, 100], [3, 200], [4, 300], [5, 200], [6, 360], [7, 380]
        int[][] envelopes = new int[][]{{2, 100}, {3, 200}, {4, 300}, {5, 500}, {5, 400}, {5, 250}, {6, 370}, {6, 360}, {7, 380}};
        System.out.println(maxEnvelopes(envelopes));
    }

    private static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        if (envelopes.length == 1) return 1;

        TreeMap<Integer, TreeMap<Integer, int[]>> wMap = new TreeMap<>();
        for (int[] envelop : envelopes) {
            int w = envelop[0];
            int h = envelop[1];
            TreeMap<Integer, int[]> hMap = wMap.get(w);
            if (hMap == null) {
                hMap = new TreeMap<>();
            }
            hMap.put(h, envelop);
            wMap.put(w, hMap);
        }

        List<TreeMap<Integer, int[]>> hList = new ArrayList<>();
        for (int key : wMap.keySet()) {
            hList.add(wMap.get(key));
        }

        backtracking(hList, 0, 0, 0);

//        int max = 0;
//        int h = 0;
//        final Set<Map.Entry<Integer, TreeMap<Integer, int[]>>> entries = wMap.entrySet();
//        for (Map.Entry<Integer, TreeMap<Integer, int[]>> wEntry : entries) {
//            TreeMap<Integer, int[]> hTree = wEntry.getValue();
//            final Map.Entry<Integer, int[]> hEntry = hTree.ceilingEntry(h + 1);
//            if (hEntry != null) {
//                max ++;
//                int[] newDoll = hEntry.getValue();
//                h = newDoll[1];
//            }
//        }
//
        return max;
    }

    static void backtracking(List<TreeMap<Integer, int[]>> hList, int index, int h, int currMax) {
        for (int i = index; i < hList.size(); i ++) {
            final TreeMap<Integer, int[]> hTree = hList.get(i);
            final Map.Entry<Integer, int[]> hEntry = hTree.ceilingEntry(h + 1);
            if (hEntry != null) {
                currMax ++;
                if (currMax > max) {
                    max = currMax;
                }
                h = hEntry.getValue()[1];
                backtracking(hList, i + 1, h, currMax);
            }
        }
    }
}
