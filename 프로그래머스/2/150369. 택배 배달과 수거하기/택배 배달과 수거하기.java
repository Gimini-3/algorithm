import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        TreeMap<Integer,Integer> map1 = new TreeMap<>(Comparator.reverseOrder());
        TreeMap<Integer,Integer> map2 = new TreeMap<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++){
            if(deliveries[i]>0){
                map1.put(i+1,deliveries[i]);
            }
            if(pickups[i]>0){
                map2.put(i+1,pickups[i]);
            }
        }
       
        while(!map1.isEmpty()||!map2.isEmpty()){
            int dist1= 0;
            int dist2=0;
            if(!map1.isEmpty())dist1 = map1.firstKey();
            if(!map2.isEmpty())dist2 = map2.firstKey();
            if(dist2>dist1){
                answer+=dist2*2;
            }else{
                answer+=dist1*2;
            }
            int cap1= cap;
            while(!map1.isEmpty()){
                int value1= map1.get(dist1);
                if(value1>cap1){
                    map1.put(dist1,map1.get(dist1)-cap1);
                    break;
                }else if(value1==cap1){
                    map1.remove(dist1);
                    break;
                }else {
                    cap1-= map1.get(dist1);
        
                    map1.remove(dist1);
                    if(map1.isEmpty()){
                        break;
                    }
                    dist1= map1.firstKey();
                }
            }
            int cap2= cap;
            while(!map2.isEmpty()){
                int value2= map2.get(dist2);
                if(value2>cap2){
                    map2.put(dist2,map2.get(dist2)-cap2);
                    break;
                }else if(value2==cap2){
                    map2.remove(dist2);
                    break;
                }else {
                    cap2-= map2.get(dist2);
                    map2.remove(dist2);
                    if(map2.isEmpty())break;
                    dist2= map2.firstKey();
                }
            }
            
        }
        return answer;
    }
}