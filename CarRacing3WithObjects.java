/* Decompiler 64ms, total 125ms, lines 133 */
package carRacing;

import java.util.Random;
import java.util.Scanner;

public class CarRacing3WithObjects {
   public static void main(String[] args) {
      int SENTINEL = true;
      int SEED = true;
      int MAX_CARS = true;
      int MAX_SPEED = true;
      int MIN_SPEED = true;
      Car[] cars = new Car[200];
      Random randGen = new Random(20L);
      Scanner scnr = new Scanner(System.in);
      int[] score = new int[200];
      int noOfCars = 0;
      studentInfo();
      displayMenu();

      for(int option = getOption(scnr); option != 9; option = getOption(scnr)) {
         int carIndex;
         int minIndex;
         label74:
         switch(option) {
         case 1:
            System.out.print("Enter number of cars: ");
            noOfCars = scnr.nextInt();

            for(carIndex = 0; carIndex < noOfCars; ++carIndex) {
               minIndex = 1000 + carIndex;
               String SN = "SN" + minIndex;
               int year = randGen.nextInt(50) + 1970;
               cars[carIndex] = new Car(SN, year);
            }

            System.out.println("Cars are created!");
            break;
         case 2:
            if (noOfCars == 0) {
               System.out.println("\n***** Sorry, there are no cars to race! *****");
               break;
            }

            System.out.print("Enter race duration in minutes: ");
            int raceDuration = scnr.nextInt();
            System.out.println("\nRace Started...");

            for(minIndex = 1; minIndex <= raceDuration; ++minIndex) {
               for(carIndex = 0; carIndex < noOfCars; ++carIndex) {
                  int milesPerMinute = randGen.nextInt(4) + 1;
                  score[carIndex] += milesPerMinute;
                  cars[carIndex].setScore(score[carIndex]);
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
                     break label74;
                  }

                  System.out.println(carIndex + "\t" + cars[carIndex].getSN() + "\t\t" + cars[carIndex].getYear() + "\t" + cars[carIndex].getScore());
                  ++carIndex;
               }
            }

            System.out.println("\n***** Sorry, there are no cars to display! *****");
            break;
         case 4:
            if (noOfCars == 0) {
               System.out.println("\n***** Sorry, there are no cars to sort! *****");
               break;
            }

            for(carIndex = 0; carIndex < noOfCars; ++carIndex) {
               minIndex = carIndex;

               for(int j = carIndex + 1; j < noOfCars; ++j) {
                  if (cars[minIndex].getScore() < cars[j].getScore()) {
                     minIndex = j;
                  }
               }

               Car temp = cars[minIndex];
               cars[minIndex] = cars[carIndex];
               cars[carIndex] = temp;
            }

            System.out.println("Cars are sorted by their scores!");
            break;
         default:
            System.out.printf("\n***** Option %d is invalid *****\n", option);
         }

         displayMenu();
      }

      System.out.println("Have a nice day!");
   }

   public static void studentInfo() {
      System.out.println("************************************************");
      System.out.println("By Megan Byrd, CS1301-Summer 2019");
      System.out.println("************************************************\n");
      System.out.println("****** CAR RACING WITH OBJECTS ******\n");
   }

   private static void displayMenu() {
      System.out.println("\nAvailable operations:");
      System.out.println("1. Create the cars");
      System.out.println("2. Run a race");
      System.out.println("3. Display all the cars");
      System.out.println("4. Sort the cars by their scores");
      System.out.println("9. End the program");
   }

   private static int getOption(Scanner scan) {
      System.out.print("\nEnter your desired option: ");
      int option = scan.nextInt();
      System.out.println();
      return option;
   }
}
