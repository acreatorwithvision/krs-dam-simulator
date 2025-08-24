import java.util.Random;

 public class DamSimulatorApp{
     public static void main(String[] args){
         Dam krsDam=new Dam(100.0);
         System.out.println("--- KRS Dam Water Management Simulation ---");
         System.out.println("Simulation Start. Inital Water Level: %.2f ft\n",krsDam.getCurrentWaterLevelFt());
         System.out.println("------------------------------------------------");

         //Create a random object for simulating rainfall
         Random random=new Random();

         //Run the simulation for 30 days.
         for(int day=1;day<=30;day++){
             //simulate a random inflow(from 0.0 to 0.5 ft per day)
             double dailyInflow=random.nextDouble()*0.5;
             krsDam.simulateDailyInflow(dailyInflow);

             //simulate a fixed release release for irrigation(eg., 0.25 ft per day)
             double dailyRelease=0.25;
             krsDam.releaseWaterForIrrigation(dailyRelease);

             //print the daily report
             System.ou.println("Day %d: Inflow: %.2fft, Release: %.2fft | Final level: %.2f ft\n",day,dailyInflow,dailyRelease,krsDam.getCurrentWaterLevelFt());

         }
         System.out.println("------------------------------------------------");
         System.out.println("30-Day Simulation Complete");
     }
 }
