package model;

import java.util.Map;

/**
 * 
 * @author allen tran
 *@version 4-20-2017
 */

public class Car extends AbstractVehicle {
    
    
    /**
     * Make death timer.
     */
    
    private final static int DEATHTIME = 10;
    
    /**
     * MakemyDirection.
     */
    
    private Direction myDirection;
    
    /**
     * 
     * @param theX Coordinate
     * @param theY Coordinate
     * @param theDir Coordinate
     */
    
    public Car(final int theX, final int theY, final Direction theDir) {
    
    
    
    super(theX, theY, theDir, DEATHTIME);
    
        myDirection = theDir;
    
    }
        
        
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
   
        boolean result = false;
        
        if (theTerrain == Terrain.STREET 
                        || theLight == Light.YELLOW 
                        || theLight == Light.GREEN 
                        || theTerrain == Terrain.CROSSWALK) {
            
            result = true;
            
        } else if (theLight == Light.RED && theTerrain == Terrain.STREET) {
            
            result = false;
        }
        

    
        return result;
   
    
    
    
    }


    @Override  
    public Direction chooseDirection(final Map<Direction , Terrain> theNeighbors) {
    
    
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
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
            
            
        }  else if (theNeighbors.get(getDirection().reverse()) == Terrain.STREET 
                        || (theNeighbors.get(getDirection().reverse()) == Terrain.CROSSWALK
                        || (theNeighbors.get(getDirection().reverse()) == Terrain.LIGHT))) {
            
            myDirection = getDirection().reverse();
            
            
        }
            




    
    
        return myDirection;
       
            
        
        
            
    }

}
