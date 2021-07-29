import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'selectStock' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER saving
     *  2. INTEGER_ARRAY currentValue
     *  3. INTEGER_ARRAY futureValue
     *  
     *  
     *  currentValue = {200, 230, 123, 320}
     *  currentValue = {243, 254, 240, 329}
     *  saving = 400
     *  
     *  
     */

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
    // Write your code here
    
    Integer [] cur = currentValue.toArray(new Integer[0]);
    Integer [] fut = futureValue.toArray(new Integer[0]);
    int[] dp = new int[saving+1];
    
    
    
    int [] profit = new int[currentValue.size()];
    
    for (int i = 0; i< profit.length; i++){
        
        profit[i] = fut[i]-cur[i];
    }
    
    
    int [] temp = new int [profit.length];
    for (int i = 0; i< temp.length; i++){
        temp[i]=profit[i];
    }
    
    for (int i = 1; i<= cur.length; i++){
        int weight = currentValue.get(i-1);
        int profit1 = futureValue.get(i-1) - currentValue.get(i-1);
        //for (int j = 0; j < i; j++ ){
            for (int j = saving; j>= weight; j-- ){
            
            //if( cur[i]+cur[j]<= saving && temp[i]< temp[j]+profit[i]){
                //temp[i]= temp[j]+profit[i];
            //}
            dp[j] = Math.max(dp[j], dp[j-weight] + profit1);
        }
    }
    
   // int maxprofit = 0;
    
    //for (int i = 0; i< temp.length; i++){
      //  maxprofit = Math.max(temp[i], maxprofit);
    //}
    return dp[saving];
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int saving = Integer.parseInt(bufferedReader.readLine().trim());

        int currentValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> currentValue = IntStream.range(0, currentValueCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int futureValueCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> futureValue = IntStream.range(0, futureValueCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.selectStock(saving, currentValue, futureValue);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
