import java.util.Objects;


public class Dam{
    //defining constants of the physical properties of dam
    //using final keyword to make sure it is unchanged anywhere in the program

    public static final double MAX_LEVEL_FT=124.80;
    public static final double CREST_GATE_ALERT_LEVEL_FT=123.0;
    public static final double LOW_LEVEL_WARNING_FT=90.0;
    public static final double MIN_LEVEL_FT=0.0;//Dam can't have negative so set to zero

    //this core state will change during the simulation
    //its in private because to avoid incorrect changes from outside
    private double currentWaterLevelFt;
    private Damstatus status; //Field for enum status

    /**
     * Contructor to create a new Dam instance
     * @param initalWaterLevel. The water level in feet when the simulation begins
     */
    public Dam(double initialWaterLevel){
        // we ensure the initial level is within the valid physical bounds.
        if(initialWaterLevel>MAX_LEVEL_FT){
            this.currentWaterLevelFt=MAX_LEVEL_FT;
        }
        else if(initialWaterLevel<MIN_LEVEL_FT){
            this.currentWaterLevelFt=MIN_LEVEL_FT;
        }
        else{
            this.currentWaterLevelFt=initialWaterLevel;
        }
    }

    /**
     * A "getter" method to safely access the current water level from outside the class
     * @return current water level in feet
     */

    public double getCurrentWaterLevelFt(){

        return this.currentWaterLevelFt;

    }


    /**
     * simulates water flowing into the dam, like from rainfall.
     * @param inflowFt - the amount of water level increase in feet.
     */

    public void simulateDailyInflow(double inflowFt){
        if(inflowFt<0){
            System.out.println("INFO:- Inflow must be a positive value.");
            return; //Do nothing if inflow is negative
        }
        double newLevel=this.currentWaterLevelFt+inflowFt;
        //the new level cannot go above the max level.
        //Math.max chooses the smaller of the two values.

        this.currentWaterLevelFt=Math.min(newLevel,MAX_LEVEL_FT);
    }


    /**
     * Simulates releasing water for irrigation or city supply.
     * @param releaseFt - the amount of water level decrease in feet.
     */
    public void releaseWaterforIrrigation(double releaseFt){
        if(releaseFt<0){
            System.out.println("INFO: Release must be a positive value.");
            return; //Do nothing is release is negative
        }
        double newLevel=this.currentWaterLevelFt-releaseFt;
        //The new level cannot go below the minimum level(0)
        //Math.max chooses the larger of the two values
        this.currentWaterLevelFt=Math.max(newLevel,MIN_LEVEL_FT);
    }
}