package leetcode.backtrack;

import com.sun.org.apache.regexp.internal.RE;

import javax.sound.midi.Track;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: huhao
 * @time: 2020/9/5 13:58
 * @desc: https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> track = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, track, new ArrayList<Integer>(), target, 0);
        return track;
    }

    private void backtrack(int[] candidates, List<List<Integer>> track, ArrayList<Integer> tempList, int remain, int
            start) {
        if (remain < 0) {
            return;
        }else if(remain == 0) {
            track.add(new ArrayList<>(tempList));
        }else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(candidates, track, tempList, remain-candidates[i], i);
                tempList.remove(tempList.size()-1);
            }
        }
    }


}
