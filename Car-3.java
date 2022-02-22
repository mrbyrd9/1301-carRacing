/* Decompiler 10ms, total 244ms, lines 52 */
package carRacing;

public class Car {
   private String serialNo;
   private int year;
   private int score;
   public final int MIN_YEAR = 1970;
   public final int MAX_YEAR = 2019;

   public String getSN() {
      return this.serialNo;
   }

   public int getYear() {
      return this.year;
   }

   public int getScore() {
      return this.score;
   }

   public void setSN(String SN) {
      this.serialNo = SN;
   }

   public void setYear(int aYear) {
      this.year = aYear;
   }

   public void setScore(int totalScore) {
      this.score = totalScore;
   }

   public Car() {
      this.serialNo = "DummyName";
      this.year = 0;
      this.score = 0;
   }

   public Car(String SN, int year2) {
      this.serialNo = SN;
      this.year = year2;
   }

   public String toString() {
      return "SN: " + this.serialNo + "\t year:" + this.year;
   }

   public static void main(String[] args) {
   }
}
