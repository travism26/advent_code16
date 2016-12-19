//package src.org.travis.adventofcode;

//import java.util.ArrayList;
import java.util.*;

public class taxiecab 
{
    public ArrayList<String> pastLocals = new ArrayList<String>();
    public ArrayList<String> cardinalDirection = new ArrayList<String>() 
                                                 {{
                                                         add("north");
                                                         add("east");
                                                         add("south");
                                                         add("west");
                                                     }};
    int direction =0;
    public int [] currentLocation = {0,0};
	
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public int[] getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(int[] currentLocation) {
        this.currentLocation = currentLocation;
    }
    public ArrayList<String> getCardinalDirection() {
        return cardinalDirection;
    }
    public void setCardinalDirection(ArrayList<String> cardinalDirection) {
        this.cardinalDirection = cardinalDirection;
    }
	
    public int[][] changeDirection(int [][] currentLocation, String currCardinalDir, String movement)
    {
        // initial direction would start at north
        int [][] updateLocation = currentLocation;
        int movementVal =0;
        //if right? rotate the direction clockwise on the cardinalDirection.
        if(movement.equalsIgnoreCase("left"))
            {
                //we are going counter clockwise aka -1 in the cardinalDirection arraylist
                updateLocation = rotateCounterClock(updateLocation, movementVal);
            }
        else
            {
                //we are going clockwise or + in the cardinalDirection list.
            }
        return updateLocation;
    }
	
    private void start(String input)
    {
        //clean input
        input = input.replaceAll("\\s+","");
        //create an array of values,
        String[] moveVal = input.split("\\,");
        //starting direction is north.
        for (int i = 0; i < moveVal.length; i++) {
            int travelDistance = Integer.parseInt(moveVal[i].substring(1));
            if(moveVal[i].startsWith("L"))
                {
                    System.out.println("this is move left: " + travelDistance);
                    moveLeft(direction, currentLocation);
                } else
                {
                    System.out.println("this is move right: " + travelDistance);
                    moveRight(direction, currentLocation);
                }
            System.out.println(direction);

            //before we moves lets record our location!
            saveLocation();

            //lets move based off the current direction.
            travel(direction, travelDistance);
        }
    }
    
    private void saveLocation()
    {
        String local = getCurrentLocation()[0] + ","+getCurrentLocation()[1];
        
    }
    private void travel(int direction2, int travelDistance) {
        int[] myLocation = getCurrentLocation();
		
        // based off the direction add the distance on the x,y axis
        //north
        if(direction2 ==0){
            myLocation[1] +=travelDistance;
        } 
        //east
        else if (direction2 ==1) 
            {
                myLocation[0] +=travelDistance;
            } 
        //south
        else if (direction2 ==2)
            {
                myLocation[1] -=travelDistance;
            } 
        //west
        else
            {
                myLocation[0] -=travelDistance;
            }
		
    }
    private void moveRight(int direction, int[] currentLocation2) {
        //check edge cases end or beginning of the array?
        if(direction==3)
            {
                setDirection(0);
            }
        else
            setDirection(++direction);
    }
    private void moveLeft(int direction, int[] currentLocation2) {
        if(direction ==0){
            setDirection(3);
        }else
            setDirection(--direction);
		
		
    }
    private int[][] rotateCounterClock(int[][] updateLocation, int movementVal) {
		
        return null;
    }
    private int calDistance()
    {
        int x = Math.abs(getCurrentLocation()[0]);
        int y = Math.abs(getCurrentLocation()[1]);
        return x+y;
    }
    
    

    public static void main(String[] args) 
    {
        taxiecab obj = new taxiecab();
        String input = "L2, L3, L3, L4, R1, R2, L3, R3, R3, L1, L3, R2, R3, L3, R4, R3, R3, L1, L4, R4, L2, R5, R1, L5, R1, R3, L5, R2, L2, R2, R1, L1, L3, L3, R4, R5, R4, L1, L189, L2, R2, L5, R5, R45, L3, R4, R77, L1, R1, R194, R2, L5, L3, L2, L1, R5, L3, L3, L5, L5, L5, R2, L1, L2, L3, R2, R5, R4, L2, R3, R5, L2, L2, R3, L3, L2, L1, L3, R5, R4, R3, R2, L1, R2, L5, R4, L5, L4, R4, L2, R5, L3, L2, R4, L1, L2, R2, R3, L2, L5, R1, R1, R3, R4, R1, R2, R4, R5, L3, L5, L3, L3, R5, R4, R1, L3, R1, L3, R3, R3, R3, L1, R3, R4, L5, L3, L1, L5, L4, R4, R1, L4, R3, R3, R5, R4, R3, R3, L1, L2, R1, L4, L4, L3, L4, L3, L5, R2, R4, L2";
        String in2 = "L2,L3,L4,R4,L1,R10";
        String in3 = "R5, L5, R5, R3";
        obj.start(input);
		
        int[] ahhh = obj.getCurrentLocation();
                
        System.out.println(ahhh[0] + " " + ahhh[1]);
        System.out.println(obj.calDistance());
    }
}
