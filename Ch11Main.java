/*
* Diane Lansinger
* CS 211
* HW03
* Building Java Programs, Reges & Stepp, 5th Edition
* Chapter 11, p. 758: Exercises 5, 11 and 15
* 07-12-20 
*
*/

import java.lang.reflect.Array;
import java.util.*;

public class Ch11Main {
    public static void main(String[] args){

        ArrayList<Integer> list5 = new ArrayList<Integer>(); //test set for Ex. 5 and Ex. 15
        list5.addAll(Arrays.asList(new Integer[] {7, 4, -9, 4, 15, 8, 27, 7, 11, -5, 32, -9, -9}));

        Set<Integer> list11A = new HashSet<Integer>(); //test set A for Ex. 11
        list11A.addAll(Arrays.asList(new Integer[] {1, 4, 7, 9}));

        Set<Integer> list11B = new HashSet<Integer>(); //test set B for Ex. 11
        list11B.addAll(Arrays.asList(new Integer[] {2, 4, 5, 6, 7}));

        ArrayList<Integer> list15 = new ArrayList<Integer>();  //test set for Ex. 15
        list15.addAll(Arrays.asList(new Integer[] {}));

        System.out.print("Exercise 5 sorted set with duplicates removed: ");
        sortAndRemoveDuplicates(list5);
        
        System.out.println("Exercise 11 symmetric set difference: " + symmetricSetDifference(list11A, list11B));

        System.out.println("Exercise 15 with a filled list: number of mode occurrences is " + maxOccurrences(list5));
        System.out.println("Exercise 15 with an empty list: number of mode occurrences is " + maxOccurrences(list15));
        
    }

    /*
    * Exercise 5: Method sortAndRemoveDuplicates accepts
    * a list of integers as its parameter and rearranges the
    * list's elements into sorted ascending order, as well as
    * removing all duplicate values from the list. Use a Set in 
    * your solution.
    *
    */
    public static void sortAndRemoveDuplicates(ArrayList<Integer> list5){
        Set<Integer> sorted = new TreeSet<Integer>(list5);
        System.out.println(sorted);
    }

    /*
    * Exercise 11: Method symmetricSetDifference accepts two Sets
    * as parameters and returns a Set containing their symmetric set
    * difference (the set of elements contained in either of the two sets
    * but not both).
    *
    */
    public static Set<Integer> symmetricSetDifference(Set<Integer> list11A, Set<Integer> list11B){
        Set<Integer> listA = new HashSet<Integer>(list11A);
        Set<Integer> listB = new HashSet<Integer>(list11B);
        Set<Integer> listC = new HashSet<Integer>(listA);
        Set<Integer> listD = new HashSet<Integer>(listB);
        listA.removeAll(listD);
        listB.removeAll(listC);
        listA.addAll(listB);
        return listA;
    }

    /* 
    * Exercise 15: Method maxOccurrences accepts a list of integers
    * as a parameter and returns the number of times the most frequently
    * occurring integer (the mode) occurs in the list. Use a map as
    * auxilliary storage. If list is empty, return "0".
    *
    */
    public static int maxOccurrences(ArrayList<Integer> list){
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        if (list == null){ 
            return 0;
        }
        
        Iterator<Integer> iterator = list.iterator();
        
        int maxValue = 0;
                      
            while (iterator.hasNext()){
                int key = iterator.next();
               
                if (map.containsKey(key)){
                    int value = map.get(key) + 1;
                    map.put(key, value);
                        if (value > maxValue){
                            maxValue = value;
                        }
                }
                else{
                    map.put(key, 1);
                }
            }                
        return maxValue; 
    }      
}