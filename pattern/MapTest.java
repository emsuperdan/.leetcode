import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MapTest {
    

    public static void main(String[] args) throws Exception {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        // map1.put(20, 9);
        // map1.put(1, 10);
        // map1.put(3, 10);
        map1.put(2, 10);
        map1.put(123, 10);


        // map2.put(20, 1);
        // map2.put(2, 1);
        map2.put(4, 10);

        // map2.put(3, 10);

        System.out.println(mergeOnHoldMap(map1, map2));
    }

        //如果两个map中有相同onHoldType 需合并订单数value
        private static HashMap<Integer, Integer> mergeOnHoldMap(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
            if (map1.isEmpty() || map2.isEmpty()) {
                if (!map1.isEmpty()) {
                    return map1;
                } else if (!map2.isEmpty()) {
                    return map2;
                } else {
                    return new HashMap<>();
                }
            }
    
            HashMap<Integer, Integer> copyMap = new HashMap<>();
            copyMap.putAll(map2);
            
            Iterator<Map.Entry<Integer, Integer>> iterator2 = copyMap.entrySet().iterator();
            while (iterator2.hasNext()) {
                Map.Entry<Integer, Integer> entry2 = iterator2.next();
                if (map1.containsKey(entry2.getKey())) {
                    Integer value1 = map1.get(entry2.getKey());
                    Integer value2 = copyMap.get(entry2.getKey());
                    //防止value为空导致 unbox 空指针
                    int sum = (value1 == null ? 0 : value1) + (value2 == null ? 0 : value2);
    
                    map1.put(entry2.getKey(), sum);
                    iterator2.remove();
                }
            }

            Set<Integer> remainSet = copyMap.keySet();
            for (Integer onHoldReason : remainSet) {
                map1.put(onHoldReason, copyMap.get(onHoldReason));
            }

            return map1;
        }


public static class Bean{
    int age;
    int height;

    public Bean(int age, int height){
        this.age = age;
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Bean{" +
        ", age=" + age +
        ", height=" + height +
        '}';
    }
}


}


