package com.masai;
import java.util.*;

public class Main {

    public static int i = 1;
    public static int totalCount = 0;

    public static void main(String[] args) {

        int priceOfTShirt = 50;
        int priceOfJeans = 80;
        int priceOfJacket = 100;

        int sum = priceOfTShirt + priceOfJeans + priceOfJacket;
        int min_price = Math.min(priceOfJacket, Math.min(priceOfTShirt, priceOfJeans));

        System.out.println("Enter Your Amount");
        Scanner sc = new Scanner(System.in);
        int totalmoney = sc.nextInt();

        if (totalmoney >= sum) {
            System.out.println("Since the available budget exceeds the total cost of T-shirts, Jeans, and Jackets.");
            System.out.println("You can purchase each item only once.");
            System.out.println("The remaining amount now stands at " + (totalmoney - sum));
            if (totalmoney - sum < min_price) {
                System.out.println("Since you don't have enough money to buy any of the listed items.");
            } else {
                System.out.println("Now, please find below the available options. You can choose only one option with the remaining money.");
                int[] arr = {priceOfTShirt, priceOfJeans, priceOfJacket};
                ans(min_price, totalmoney - sum, new Stack<Integer>(), arr);
                System.out.println("Total possible option is " + totalCount + " and one set of each as required in the question. The total number of possible options is " + (totalCount + 1));
            }
        } else {
            System.out.println("You haven't enough money to buy any Items");
        }
    }

    public static void ans(int min, int price, Stack<Integer> stack, int[] arr) {
        if (price < 0) {
            return;
        }
        if (price < min) {
            totalCount++;
            show(stack);
            return;
        }
        if (price == 0) {
            totalCount++;
            show(stack);
            return;
        }
        for (int i = 0; i < 3; i++) {
            stack.push(arr[i]);
            ans(min, price - arr[i], stack, arr);
            stack.pop();
        }
    }

    public static void show(Stack<Integer> stack) {
        Map<String, Integer> map = new HashMap<>();
        for (int s : stack) {
            if (s == 50) {
                map.put("priceOfTShirt", map.getOrDefault("priceOfTShirt", 0) + 1);
            } else if (s == 80) {
                map.put("priceOfJeans", map.getOrDefault("priceOfJeans", 0) + 1);
            } else {
                map.put("priceOfJacket", map.getOrDefault("priceOfJacket", 0) + 1);
            }
        }
        System.out.println(i + ":-" + map);
        i++;
    }
}
/*
 Input:-
 Enter Your Amount
 600
 -----------
 Output:-
 Total possible option is 129 and one set of each as required in the question. 
 The total number of possible options is 130
 */

