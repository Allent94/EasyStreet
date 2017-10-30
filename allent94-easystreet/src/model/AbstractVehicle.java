package model;

/**
 * 
 * @author Allen Tran
 *@version 04-15-2017
 */

public abstract class AbstractVehicle implements Vehicle {
    
    /**
     * Make variable myX for X coordinate. 
     */
    
    private int myX;
    
    /**
     * Make variable for initial myX for initial X coordinate.
     */
    
    private int myInitalX;
    
    
    /**
     * Make variable for myY for Y coordinate.
     */
    
    private int myY;
    
    /**
     * Make variable for initial myY for initial Y coordinate.
     */
    
    private int myInitalY;
    
    /**
     * Make variable for myDeath for death timer.
     */
    
    private int myDeathTimer;
    
    /**
     * Make variable for myStatus to check where if the vehicle is alive or dead.
     */
    
    private boolean myAlive;
    
    /**
     * Make variable for myDirection for direction of vehicle.
     */
    
    private Direction myDirection;
    
    /**
     * Make variable for initial myDirection for initial direction of vehicle.
     */
    
    private Direction myInitalDirection;
    
    /**
     * 
     * Make Variable for initial myPoke for pokes to be alive again.
     */
    
    private int myPoke;
    
    /**
     * 
     * @param theX x cord.
     * @param theY y cord.
     * @param theDirection direction of vec.
     * @param theDeathTimer Death timer.
     */
    
    
    public AbstractVehicle(final int theX , final int theY , final Direction theDirection 
                       , final int theDeathTimer) {
    
        myX = theX;
        myY = theY;
        myInitalX = theX;
        myInitalY = theY;
        myDirection = theDirection;
        myInitalDirection = theDirection;
        myDeathTimer = theDeathTimer;
        myAlive = true;
        
        
    }
    
    /**
     * Make method Collide.
     * @param theOther class
     */

    public void collide(final Vehicle theOther) {
    
        if (myDeathTimer > theOther.getDeathTime()) {
    
            myAlive = false;
    
    
        }
        
    }
    
    
    
    
    /**
     * Make method to get image file name for icon.
     * @return .gif or _dead.gif.
     */

    public String getImageFileName() {
    
    
        final StringBuilder builder = new StringBuilder(128);
    
        builder.append(getClass().getSimpleName().toLowerCase());
    
        if (isAlive()) {
        
            builder.append(".gif");
        
        } else {
        
            builder.append("_dead.gif");
        
        
        }
        return builder.toString();
    

    
    
    }
    
    /**
     * 
     * Make method to getDeathTime.
     * @return myDeathTimer
     */

    public int getDeathTime() {
    
    
        return myDeathTimer;
    
    
    }
    
    /**
     * 
     * Make method to get Direction.
     * @return myDirection
     */

    public Direction getDirection() {
    
    
        return myDirection;
    
    
    }
    
    /**
     * Make method to getX.
     * @return myX
     */

    public int getX() {
    
        return myX;
    
    
    
    }
    
    /**
     * 
     * Make method to getY.
     * @return myY.
     */
    public int getY() {
    
    
        return myY;
  
    }
    
    /**
     * Make method to return myAlive.
     * @return status of vehicle.
     */

    public boolean isAlive() {
    
        return myAlive;
    
    }
    
    /**
     * Make method Poke.
     */

    public void poke() {


        if (myAlive) {
        
            myAlive = true;
           
            
        } else if (myPoke < myDeathTimer) {

            myPoke++;

        } else if (myPoke == myDeathTimer) {
        
            myAlive = true;
            
            myDirection = Direction.random();

        }
    
    
    }
    
    /**
     * Make method to reset the program.
     */

    public void reset() {
    
        setX(myInitalX);
        setY(myInitalY);
        setDirection(myInitalDirection);
        myPoke = 0;
        myAlive = true;
        
    
    
    }
    
    /**
     * Make method to setDirection.
     * @param theDir the Direction.
     */

    public void setDirection(final Direction theDir) {
    
        myDirection = theDir;
    
    }
    
    /**
     * Make method to setX.
     * @param theX the X.
     */

    public void setX(final int theX) {
    
        myX = theX;
    
    
    }
    
    /**
     * Make method to setY.
     * @param theY the Y.
     */
    public void setY(final int theY) {
    
        myY = theY;
    
    }
    
    /**
     * Make method for toString for debuging.
     */
    
    
    @Override
    public String toString() {
        
        final  StringBuilder builder = new StringBuilder(128);
        
        builder.append(getClass().getName());
        
        builder.append(myDirection);
        
        builder.append(myPoke);
        
        return builder.toString();
        
        
        
        
    }
}