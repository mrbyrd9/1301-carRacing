/* Decompiler 22ms, total 69ms, lines 116 */
package carRacing;

import java.util.Random;
import java.util.Scanner;

public class CarRacing2Methods {
   public static void main(String[] args) {
      int MAX_CARS = true;
      int noOfCars = 0;
      int SENTINEL = true;
      int SEED = true;
      String[] serialNo = new String[200];
      int[] year = new int[200];
      int[] score = new int[200];
      Scanner scan = new Scanner(System.in);
      Random gen = new Random(20L);
      studentInfo();
      displayMenu();

      for(int option = getOption(scan); option != 9; option = getOption(scan)) {
         switch(option) {
         case 1:
            noOfCars = createCars(serialNo, year, score, gen, scan);
            break;
         case 2:
            runRace(score, noOfCars, gen, scan);
            break;
         case 3:
            displayCars(serialNo, year, score, noOfCars);
            break;
         default:
            System.out.printf("\n***** Option %d is invalid *****\n", option);
         }

         displayMenu();
      }

      System.out.print("Have a nice day!\n");
   }

   public static void studentInfo() {
      System.out.println("************************************************");
      System.out.println("By Megan Byrd, CS1301-Summer 2019");
      System.out.println("************************************************\n");
      System.out.println("****** CAR RACING WITH METHODS ******\n");
   }

   private static int createCars(String[] serialNo, int[] year, int[] score, Random gen, Scanner scan) {
      int MAX_YEAR = true;
      int MIN_YEAR = true;
      System.out.print("Enter number of cars: ");
      int noOfCars = scan.nextInt();

      for(int carIndex = 0; carIndex < noOfCars; ++carIndex) {
         serialNo[carIndex] = "SN" + (1000 + carIndex);
         year[carIndex] = gen.nextInt(50) + 1970;
         score[carIndex] = 0;
      }

      System.out.print("Cars are created!");
      return noOfCars;
   }

   private static void displayCars(String[] serialNo, int[] year, int[] score, int noOfCars) {
      if (noOfCars != 0) {
         System.out.println();
         System.out.println("No.\tSerialNo\tYear\tScore");
         System.out.println("---\t--------\t----\t-----");

         for(int carIndex = 0; carIndex < noOfCars; ++carIndex) {
            System.out.println(carIndex + "\t" + serialNo[carIndex] + "\t\t" + year[carIndex] + "\t" + score[carIndex]);
         }
      } else {
         System.out.println("\n***** Sorry, there are no cars to display! *****");
      }

   }

   private static void displayMenu() {
      System.out.println("\nAvailable operations:");
      System.out.println("1. Create the cars");
      System.out.println("2. Run a race");
      System.out.println("3. Display all the cars");
      System.out.println("9. End the program");
   }

   private static int getOption(Scanner scan) {
      System.out.print("\nEnter your desired option: ");
      int option = scan.nextInt();
      System.out.println();
      return option;
   }

   private static void runRace(int[] score, int noOfCars, Random gen, Scanner scan) {
      int MIN_SPEED = true;
      int MAX_SPEED = true;
      if (noOfCars != 0) {
         System.out.print("Enter race duration in minutes: ");
         int raceDuration = scan.nextInt();
         System.out.println("\nRace Started...");

         for(int duration = 1; duration <= raceDuration; ++duration) {
            for(int carIndex = 0; carIndex < noOfCars; ++carIndex) {
               int distanceTravelled = gen.nextInt(4) + 1;
               score[carIndex] += distanceTravelled;
            }
         }

         System.out.println("Race Ended...");
      } else {
         System.out.println("\n***** Sorry, there are no cars to race! *****");
      }

   }
}
