/* Decompiler 77ms, total 140ms, lines 112 */
package carRacing;

import java.util.Random;
import java.util.Scanner;

public class CarRacing1 {
   public static void main(String[] args) {
      int SEED = true;
      int SENTINEL = true;
      int MIN_SPEED = true;
      int MAX_SPEED = true;
      int MIN_YEAR = true;
      int MAX_YEAR = true;
      int MIN_SERIAL_NO = true;
      int noOfCars = 0;
      String aSerialNo = "";
      String[] serialNo = new String[]{""};
      int[] year = new int[1];
      int[] score = new int[1];
      Scanner scan = new Scanner(System.in);
      Random gen = new Random(20L);
      System.out.println("************************************************");
      System.out.println("By Abi Salimi, CS1301-Summer 2019");
      System.out.println("************************************************\n");
      System.out.println("****** CAR RACING ******\n");
      System.out.println("\nAvailable operations:");
      System.out.println("1. Create the cars");
      System.out.println("2. Run a race");
      System.out.println("3. Display all the cars");
      System.out.println("9. End the program");
      System.out.print("\nEnter your desired option: ");
      int option = scan.nextInt();
      System.out.println();

      while(option != 9) {
         int carIndex;
         label49:
         switch(option) {
         case 1:
            System.out.print("Enter number of cars: ");
            noOfCars = scan.nextInt();
            serialNo = new String[noOfCars];
            year = new int[noOfCars];
            score = new int[noOfCars];

            for(carIndex = 0; carIndex < noOfCars; ++carIndex) {
               int serialNoSuffix = 1000 + carIndex;
               aSerialNo = "SN" + serialNoSuffix;
               int aYear = gen.nextInt(50) + 1970;
               serialNo[carIndex] = aSerialNo;
               year[carIndex] = aYear;
               score[carIndex] = 0;
            }

            System.out.println("\nCars are created!");
            break;
         case 2:
            if (noOfCars == 0) {
               System.out.println("\n***** Sorry, there are no cars to race! *****");
               break;
            }

            System.out.print("Enter race duration in minutes: ");
            int raceDuration = scan.nextInt();
            System.out.println("\nRace Started...");

            for(int duration = 1; duration <= raceDuration; ++duration) {
               for(carIndex = 0; carIndex < noOfCars; ++carIndex) {
                  int distanceTravelled = gen.nextInt(4) + 1;
                  score[carIndex] += distanceTravelled;
               }
            }

            System.out.println("Race Ended...");
            break;
         case 3:
            if (noOfCars != 0) {
               System.out.println();
               System.out.println("No.\tSerialNo\tYear\tScore");
               System.out.println("---\t--------\t----\t-----");
               carIndex = 0;

               while(true) {
                  if (carIndex >= noOfCars) {
                     break label49;
                  }

                  System.out.println(carIndex + "\t" + serialNo[carIndex] + "\t\t" + year[carIndex] + "\t" + score[carIndex]);
                  ++carIndex;
               }
            }

            System.out.println("\n***** Sorry, there are no cars to display! *****");
            break;
         default:
            System.out.printf("\n***** Option %d is invalid *****\n", option);
         }

         System.out.println("\nAvailable operations:");
         System.out.println("1. Create the cars");
         System.out.println("2. Run a race");
         System.out.println("3. Display all the cars");
         System.out.println("9. End the program");
         System.out.print("\nEnter your desired option: ");
         option = scan.nextInt();
         System.out.println();
      }

      System.out.println("\nHave a nice day!\n");
   }
}
