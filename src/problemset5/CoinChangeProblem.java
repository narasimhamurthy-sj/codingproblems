package problemset5;

import java.util.*;

/*Coin Change Problem**
    - Find the minimum number of coins needed to make an amount (e.g., coins `[1,2,5]`, amount `11` → `3`)
Example 1:
Coins available: [1, 2, 5]
Amount to make: 11

Possible ways:

5 + 5 + 1 = 11 → uses 3 coins

2 + 2 + 2 + 5 = 11 → uses 4 coins

1 + 1 + ... (11 times) → uses 11 coins

Best way: 3 coins (5 + 5 + 1)

Answer: 3
Coins available: [1, 2, 5, 3]
Amount to make: 11
Steps:
take elements one by one from arr

  check remainder=element mod amnt
      whether remainder is 0
      noOfCoins=amnt/element;
      msg=element
      resultMap.put(msg,noOfCoins)

      else if whether remainder contains in array
      noOfCoins=amnt/element;
      msg=element+"* "+noOfCoins+" +"+remainder;
      resultMap.put(msg,noOfCoins+1)



 2nd func:
 take elements one by one from arr
     check remainder=element mod amnt
     if remainder=0
     continue;
     for jth loop ->arr[j] , j=i+1
        if remainder=0
        continue;
        else
        num=amount-arr[j];
        if(num/arr[i]==0)
        noOfCoins=num/arr[i];
        msg=arr[i]+"* "+noOfCoins+ "+arr[j];
         resultMap.put(msg,noOfCoins+1)

3rd func:
ith loop -read num by num
sum=a[i];
 jth loop
  add  sum+=a[j]
  if(sum==amnt){
  }else if(sum>amnt){
  sum=sum-a[j]

  }
//end of jth loop
reset sum=0;


 */
public class CoinChangeProblem {


    public static int coinChange(int[] coins, int amount) {
        // Create a DP array where dp[i] represents the minimum coins needed for amount 'i'
        int[] dp = new int[amount + 1];

        // Initialize the DP array with a value larger than the maximum possible coins (amount + 1)
        Arrays.fill(dp, amount + 1);

        // Base case: 0 coins needed to make amount 0
        dp[0] = 0;

        // Fill the DP array
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still greater than 'amount', it means it's not possible
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeProblem coinObject = new CoinChangeProblem();
        ArrayList<Integer> amountList = new ArrayList<>();
        int[][] coinsArrays = {
                {1, 2, 5},
                {1, 5, 1, 3, 2},
                {1, 10, 2, 20, 5},
                {1, 1, 2, 0, 5},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {5, 7, 11, 13, 17},
                {1, 5, 10, 25},
                {1, 5, 2, 3, 4, 6, 10, 25, 0, 100},
                {1, 5, 2, 3, 4, 6, 7, 8, 9, 10, 20, 25, 0, 15, 1000}
        };
        amountList.add(11);
        amountList.add(11);
        amountList.add(8);
        amountList.add(8);
        amountList.add(53);
        amountList.add(22);
        amountList.add(24);
        amountList.add(12);
        amountList.add(14);
        amountList.add(17);
        amountList.add(13);
        amountList.add(0);
        amountList.add(30);
        amountList.add(100);
        amountList.add(1000000);

        for (int i = 0; i < coinsArrays.length; i++) {

            coinObject.findMinimumCoinsForAmount(coinsArrays[i], amountList.get(i));
            System.out.println("----------------------               ----------------------------------");
        }


        int[] coins = {1, 6, 2, 4};
        int amount = 4;
        System.out.println("Minimum coins needed: " + coinChange(coins, amount));
    }

    public HashMap<String, Integer> CheckWhetherAmountIsMultipleOfCoins(int[] coinsArray, int amount) {

        HashMap<String, Integer> coinsCountMap = new HashMap<>();
        int remainder = 0, noOfCoins;
        String msg = "";
        for (int coin : coinsArray) {
            if (coin <= 0) {
                continue;
            }
            remainder = amount % coin;

            if (remainder == 0) {
                noOfCoins = amount / coin;
                msg = coin + " *" + noOfCoins + " =" + amount;
                coinsCountMap.put(msg, noOfCoins);
            } else {
                int finalRemainder = remainder;
                if (Arrays.stream(coinsArray).anyMatch(element -> element == finalRemainder)) {
                    noOfCoins = amount / coin;
                    // System.out.println("Remainder:"+remainder);
                    msg = coin + "* " + noOfCoins + " +" + remainder + " =" + amount;
                    coinsCountMap.put(msg, noOfCoins + 1);
                }
            }
        }
       /* coinsCountMap.forEach((k,v)->System.out.println(k+"     "+v));
        System.out.println("-------------          ---------------------------");*/
        return coinsCountMap;
    }

    public HashMap<String, Integer> CheckMultipleOfCoinsWhichDoesNotExistAsRemainder(HashMap<String, Integer> coinsCountMap, int[] coinsArray, int amount) {
        int remainder = 0, noOfCoins, num;
        String msg = "";
        for (int i = 0; i < coinsArray.length; i++) {

            if (coinsArray[i] <= 0 || coinsArray[i] > amount) {
                continue;
            }


            remainder = amount % coinsArray[i];

            if (remainder == 0) {
                continue;
            }
            for (int j = i + 1; j < coinsArray.length; j++) {

                if (coinsArray[j] <= 0 || coinsArray[j] > amount) {
                    continue;
                }

                remainder = amount % coinsArray[j];
                if (remainder != 0) {
                    num = amount - coinsArray[j];
                    if (num % coinsArray[i] == 0) {
                        noOfCoins = num / coinsArray[i];
                        msg = coinsArray[i] + " *" + noOfCoins + " +" + coinsArray[j] + " =" + amount;
                        coinsCountMap.put(msg, noOfCoins + 1);
                    }

                }
            }
        }
       /* coinsCountMap.forEach((k,v)->System.out.println(k+"     "+v));
        System.out.println("-------------          ---------------------------");*/
        return coinsCountMap;
    }

    public HashMap<String, Integer> CheckCoinsWhichAreInNonSequenceOrder(HashMap<String, Integer> coinsCountMap, int[] coinsArray, int amount) {
        String msg = "";
        int sum = 0, numOfCoins = 0;
        ArrayList<Integer> coinsList = new ArrayList<>();
        for (int i = 0; i < coinsArray.length; i++) {
            sum = coinsArray[i];
            numOfCoins++;
            for (int j = i + 1; j < coinsArray.length; j++) {

                coinsList.add(coinsArray[j]);
                sum += coinsArray[j];
                numOfCoins++;
                if (sum == amount) {
                    msg = coinsArray[i] + " + " + coinsList.toString() + " =" + amount;
                    coinsCountMap.put(msg, numOfCoins);
                    sum = coinsArray[i];
                    numOfCoins = 1;
                    coinsList.clear();


                } else if (sum > amount) {
                    sum = sum - coinsArray[j];
                    coinsList.remove(Integer.valueOf(coinsArray[j]));
                    numOfCoins--;

                }
            }//end of jth loop
            sum = 0;
            numOfCoins = 0;
            coinsList.clear();
        }
        return coinsCountMap;
    }

    public boolean findMinimumCoinsForAmount(int[] coinsArray, int amount) {

        if (amount < 0) {
            System.out.println("amount is less than zero");
            return false;
        }

        if (amount == 0) {
            if (Arrays.stream(coinsArray).anyMatch(elmnt -> elmnt == 0)) {
                System.out.println("amount is zero, min coin is 1");
                return true;
            } else {
                System.out.println("zero coin is not found in given array");
                return false;

            }
        }
        HashMap<String, Integer> coinsCountMap = CheckWhetherAmountIsMultipleOfCoins(coinsArray, amount);
        coinsCountMap = CheckMultipleOfCoinsWhichDoesNotExistAsRemainder(coinsCountMap, coinsArray, amount);
        coinsCountMap = CheckCoinsWhichAreInNonSequenceOrder(coinsCountMap, coinsArray, amount);

        if (coinsCountMap.isEmpty()) {
            return false;
        }

        coinsCountMap.forEach((k, v) -> System.out.println(k + "     " + v));
        Map.Entry<String, Integer> minEntry = Collections.min(coinsCountMap.entrySet(),
                Comparator.comparing(Map.Entry::getValue));

        System.out.println("Coins details: " + minEntry.getKey() + ". No of Coins: " + minEntry.getValue());

        return true;
    }
}
