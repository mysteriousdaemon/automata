/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;
import java.util.Scanner;

/**
 *
 * @author John Lawson
 */
public class GameOfLife {

    public static void displayCells(int[] data) {
        String[] printArr = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i] == 1) {
                printArr[i] = "#";
            }
            if (data[i] == 0) {
                printArr[i] = " ";
            }
            System.out.printf(printArr[i]);
            
        }    System.out.println(); 
    }

    public static void updateCells(int[] data) {
//        create temp array 
//        modify the temporary array when updating cells
//        and then copy the temporary to the data[] array before the method returns.
        
        int[] temp = new int[data.length];
        
        for (int i = 1; i < temp.length-1; i++) {      // leaves outside index's constant
            int left = data[i-1];
            int middle = data[i];
            int right = data[i+1];
            int update = rules(left, middle, right);
            temp[i] = update;
        }
        System.arraycopy(temp, 0, data, 0, data.length);
    }
    
    public static int rules(int l, int m, int r) {
            if  (l == 1 && m == 1 && r == 1) return ruleKeys[0];
        else if (l == 1 && m == 1 && r == 0) return ruleKeys[1];
        else if (l == 1 && m == 0 && r == 1) return ruleKeys[2];
        else if (l == 1 && m == 0 && r == 0) return ruleKeys[3];
        else if (l == 0 && m == 1 && r == 1) return ruleKeys[4];
        else if (l == 0 && m == 1 && r == 0) return ruleKeys[5];
        else if (l == 0 && m == 0 && r == 1) return ruleKeys[6];
        else if (l == 0 && m == 0 && r == 0) return ruleKeys[7];
        return 0;
    }
    
    
    static int[] ruleKeys = {0,1,1,0,1,1,1,0};
    public static void main(String[] args) {
        
        int numOfCells;
        int numOfGens;
        int[] data = {0};
        int[] arr;
        int index;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter number of cells (<= 80):");
        numOfCells = input.nextInt();
        data = new int[numOfCells];
        
        System.out.println("Enter number of generations:");
        numOfGens = input.nextInt();
        
        System.out.println("Enter index(s) of occupied cells (use -1 to end):");
           boolean pizza = false;
           while (!pizza) {
               index = input.nextInt();
               
               if (index == (-1)) {
                   displayCells(data);
                   pizza = true;
               }
               else if (index >= 0) {
                   data[index] = 1;
               }
           }
        for (int i = 1; i < numOfGens; i++) {
           updateCells(data);
           displayCells(data);
        }
    }
}
