package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author Allen Tran
 *@version 4-20-2017
 */

public class Truck extends AbstractVehicle {
    
    /**
     * Make variable for death timer.
     */
    
    private static int deathTime = 1;
    
    /**
     * Make variable for myDirectoin.
     */
    
    private Direction myDirection;
    
    
    /**
     * 
     * @param theX Coordinate
     * @param theY Coordinate
     * @param theDir Direction
     */
     

    public Truck(final int theX, final int theY, final Direction theDir) {
    
    super(theX, theY, theDir, deathTime);
    
        myDirection = theDir;
    
   
    }

    @Override
public boolean canPass(final Terrain theTerrain, final Light theLight) {
    
    
        boolean result = false;
    
        if (theTerrain == Terrain.STREET 
                        || theTerrain == Terrain.LIGHT 
                        || theTerrain == Terrain.CROSSWALK) {
        
            result = true;
        
        
        } 

        return result;


    
    }
    
    /**
     * Make method for Direction.
     * @paramtheNeighbors theNeighbor
     *
     */

    
    @Override  
public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
    
        final Random randomGenerator = new Random();
    
        final List<Direction> list = new ArrayList<Direction>();
   
    
        if (theNeighbors.get(getDirection()) == Terrain.STREET 
                    
                    || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection()) == Terrain.LIGHT))) {
        
        
            list.add(getDirection());
    

        
        } 
        
        if (theNeighbors.get(getDirection().left()) == Terrain.STREET 
                    || (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection().left()) == Terrain.LIGHT))) {
        
            list.add(getDirection().left());
        
        
        } 
        
        if (theNeighbors.get(getDirection().right()) == Terrain.STREET 
                    || (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK
                    || (theNeighbors.get(getDirection().right()) == Terrain.LIGHT))) {
        
            list.add(getDirection().right());
        
        
        } 
        
        if (list.isEmpty()) {
        
            myDirection = getDirection().reverse();
            
        
        } else {
        
            final int randomDir = randomGenerator.nextInt(list.size());
        
            myDirection = list.get(randomDir);
        

        
        }
    
    
        return myDirection;
   
        
    }



}
