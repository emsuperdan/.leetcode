import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class One {
    public static void main(String[] args) {
        One one = new One();
        System.out.println(Arrays.toString(one.getResult(new int[]{1,2,3}, 4)));
    }

    private int[] getResult(int[] input, int num){
        for(int i = 0; i < input.length ; i++){
            for(int j = i+1; j<input.length ; j++){
                if(input[i]+input[j] == num){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    private int[] getResult2(int[] input, int num){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < input.length ; i++){
            if(map.containsKey(num - input[i])){
                return new int[]{map.get(num - input[i]), i};
            }
            map.put(input[i], i);
        }

        return new int[0];
        
    }


}
