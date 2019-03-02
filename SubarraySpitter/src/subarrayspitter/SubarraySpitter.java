/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package subarrayspitter;

import java.util.ArrayList;

/**
 *
 * @author napuk
 */
public class SubarraySpitter {
    
    static int[] test = {1, 2, 3, 4, 5};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declare test cases
        ArrayList allVariations1 = splitArray(test, 1);
        ArrayList allVariations2 = splitArray(test, 2);
        ArrayList allVariations3 = splitArray(test, 3);
        
        //Print results
        System.out.println("Test 1: "+allVariations1.toString());
        System.out.println("Test 1: has "+allVariations1.size()+" combinations with a max of 1 odd number per array");
        System.out.println();
        
        System.out.println("Test 2: "+allVariations2.toString());
        System.out.println("Test 2: has "+allVariations2.size()+" combinations with a max of 2 odd number per array");
        System.out.println();
        
        System.out.println("Test 3: "+allVariations3.toString());
        System.out.println("Test 3: has "+allVariations3.size()+" combinations with a max of 3 odd number per array");
    }
    
    /**
     * Function returns an ArrayList of the all possible adjacent combinations, with a max amount of odd numbers per entry
     * @param passedValues The list of numbers the possibilities are based on
     * @param maxOdd The max amount of odd numbers per entry. -1 for no limit
     * @return The list of possibilities
     */
    private static ArrayList splitArray(int[] passedValues, int maxOdd){
        //Array we'll be returning at the end of this function
        ArrayList progressArrayList = new ArrayList();
        //For each number 
        for(int i = 0; i < passedValues.length; i++){
            //Run once for each remaining number 
            for(int j = 0; j < passedValues.length - i; j++){
                int oddCount = 0;
                ArrayList substringArrayList = new ArrayList();
                for(int l = 0; l < j+1; l++){
                    if(passedValues[i+l] % 2 == 0){
                        //System.out.println(i);
                        substringArrayList.add(passedValues[i+l]);
                    }else{
                        if(maxOdd == -1){
                            substringArrayList.add(passedValues[i+l]);
                        }else if(oddCount < maxOdd){               
                            oddCount++;
                            substringArrayList.add(passedValues[i+l]);
                        }
                    }
                }
                if(progressArrayList.isEmpty()){
                    progressArrayList.add(substringArrayList);
                }else if(!progressArrayList.get(progressArrayList.size()-1).toString().equals(substringArrayList.toString())) {
                    progressArrayList.add(substringArrayList);
                }
            }
        }
        return progressArrayList;
    }
    
}
