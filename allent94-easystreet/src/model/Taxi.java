package model;

import java.util.Map;

/**
 * 
 * @author allen tran
 * @version 4-20-2017
 *
 */

public class Taxi extends AbstractVehicle {
    
    /**
     * Make variable for death timer.
     */
    private final static int DEATHTIME = 10;
    
    /**
     * Make variable for myDirection.
     */
    
    private Direction myDirection;
    
    /**
     * 
     * @param theX X Coordinate. 
     * @param theY YX Coordinate.
     * @param theDir Direction 
     */
    
    public Taxi(final int theX, final int theY, final Direction theDir) {
    
    super(theX, theY, theDir, DEATHTIME);
    
        myDirection = theDir;
        
        
    }

    @Override
public boolean canPass(final Terrain theTerrain, final Light theLight) {

        boolean result = false;
        final int count = 3;
    
        if (theTerrain == Terrain.CROSSWALK
                        
                        && theLight == Light.RED) {

            if (theLight == Light.GREEN) {
                
                result = true;
            }
            
            if (theLight == Light.GREEN
                            && theTerrain == Terrain.CROSSWALK) {
                
                result = true;
            }
     
        
            for (int i = 0; i <= count; i++) {
                
                result = false;
                
                if (i == count) { 
                    
                    result = true;

                }
                
                
                
            } 
            

            
           
            
           
            
            
        
        } else if (theTerrain == Terrain.STREET 
                            || theLight == Light.YELLOW 
                            || theLight == Light.GREEN 
                            || theTerrain == Terrain.CROSSWALK) {
        
            result = true;
        
        } else if (theLight == Light.RED && theTerrain == Terrain.STREET) {
        
            result = false;
        }
    


        return result;




    }

/**
 * 
 * @param Direction
 * @param theNeighbors Terrains.
 * @return Direction of Taxi
 */
       
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
    
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                    || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection()) == Terrain.LIGHT))) {
        
        
            myDirection = getDirection();
    

        
        } else if (theNeighbors.get(getDirection().left()) == Terrain.STREET
                    || theNeighbors.get(getDirection().left()) == Terrain.LIGHT
                    || theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK) {
        
            myDirection = getDirection().left();
        
        
        } else if (theNeighbors.get(getDirection().right()) == Terrain.STREET
                    || theNeighbors.get(getDirection().right()) == Terrain.LIGHT
                    || theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK) {
        
            myDirection = getDirection().right();
        
        
        }  else if (theNeighbors.get(getDirection().reverse()) == Terrain.STREET
                    || theNeighbors.get(getDirection().reverse()) == Terrain.LIGHT
                    || theNeighbors.get(getDirection().reverse()) == Terrain.CROSSWALK) {
        
            myDirection = getDirection().reverse();
        
        
        }


        return myDirection;
   
            
    }

}
