public class Dam{
    //defining constants of the physical properties of dam
    //using final keyword to make sure it is unchanged anywhere in the program

    public static final double MAX_LEVEL_FT=124.80;
    public static final double CREST_GATE_ALERT_LEVEL_FT=123.0;
    public static final double LOW_LEVEL_MARKING_FT=90.0;
    public static final double MIN_LEVEL_FT=0.0;//Dam can't have negative so set to zero

    //this core state will change during the simulation
    //its in private because to avoid incorrect changes from outside
    private double currentWaterLevelFt;

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

}