    import java.util.*;
    public class test {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<>();
            int n = in.nextInt();
            int m = in.nextInt();
            
            int highestDistinct = 0;
            Map<Integer, Integer> intMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num);
                int exisintCount = intMap.getOrDefault(num, 0);
                intMap.put(num, exisintCount + 1);
                if(i >= m) 
                {
                    int removed = deque.pop();
                    Integer remainingOfInt = intMap.get(removed) - 1;
                    if(remainingOfInt == 0) intMap.remove(removed);
                    else intMap.put(removed, remainingOfInt);
                }
                int distinct = intMap.size();
                if(distinct > highestDistinct) highestDistinct = distinct;
            }
            System.out.println(highestDistinct);
        }
    }



