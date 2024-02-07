import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxTime = attacks[attacks.length - 1][0];
        for (int i = 0; i < attacks.length; i++) {
            hm.put(attacks[i][0], attacks[i][1]);
        }
        
        int continuousHealthCnt = 0;
        int currentHealth = health;
        
        for (int i = 0; i <= maxTime; i++) {
            // check current time is attack time
            if (hm.containsKey(i)) {
                continuousHealthCnt = 0;
                currentHealth -= hm.get(i);
                if (currentHealth <= 0) return -1;
            } else {
                continuousHealthCnt += 1;
                currentHealth += bandage[1];
                if (continuousHealthCnt == bandage[0]) { 
                    currentHealth += bandage[2];
                    continuousHealthCnt = 0;
                }
                if (currentHealth > health) currentHealth = health;
            }
        }
        return currentHealth;
    }
}