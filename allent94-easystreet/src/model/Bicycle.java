
package model;

import java.util.Map;

/**
 * 
 * @author Allen Tran
 *@version 4-20-2017
 *
 */



public class Bicycle extends AbstractVehicle {
    
    /**
     * Make variable for death timer.
     */
    
    private final static int DEATHTIME = 30;
    
    /**
     * Make variable for myDirection.
     */
    
    private Direction myDirection;
    
    /**
     * 
     * @param theX X Coordinate.
     * @param theY Y Coordinate.
     * @param theDir Direction
     */

    public Bicycle(final int theX, final int theY, final Direction theDir) {
    
    super(theY, theY, theDir, DEATHTIME);
    
        myDirection = theDir;
        
        
    }


    @Override
public boolean canPass(final Terrain theTerrain, final Light theLight) {
    
    
        boolean result = false;
    
        if (theTerrain == Terrain.TRAIL) {
        
            result = true;
        } else if (theTerrain == Terrain.STREET || theLight == Light.GREEN 
                        || theTerrain == Terrain.CROSSWALK 
                    || theTerrain == Terrain.TRAIL) {
        
            result = true;
        
        
        } else if (theLight == Light.RED && theTerrain == Terrain.STREET 
                        || theLight == Light.YELLOW) {
        
            result = false;
        
        
        } 
        


        return result;


    }

    @Override
public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
    
        if (theNeighbors.get(getDirection()) == Terrain.TRAIL) {
        
            myDirection = getDirection();

        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.TRAIL) {
        
            myDirection = getDirection().left();

        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.TRAIL) {
        
            myDirection = getDirection().right();

        
        } else if (theNeighbors.get(getDirection()) == Terrain.STREET 
                    
                    || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection()) == Terrain.LIGHT))) {        
            myDirection = getDirection();

        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                    || (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT))) {
        
            myDirection = getDirection().left();

        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET  
                    || (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT))) {
        
            myDirection = getDirection().right();

        
        } else {
            
            myDirection = getDirection().reverse();
        }
    
    
        return myDirection;
            
            
    }

}
