package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author allen Tran
 *@version 4-20-2017
 */

public class Atv extends AbstractVehicle {
    
    /**
     * Make variable for death timer.
     */
    
    final static int DEATHTIME = 20;
    
    /**
     * Make variable for myDirection.
     */
    
    private Direction myDirection;
    
    /**
     * 
     * @param theX X Coordinate 
     * @param theY Y Coordinate 
     * @param theDir Direction
     */


    public Atv(final int theX, final int theY, final Direction theDir) {
    
    super(theX , theY , theDir , DEATHTIME);
    
        myDirection = theDir;
    
        
    }

    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
   
        boolean result = false;
        
        if (theTerrain == Terrain.STREET 
                        || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.GRASS
                        || theTerrain == Terrain.TRAIL
                        || theTerrain == Terrain.CROSSWALK) {
            
            result = true;
            
            
        }

    
        return result;
   
    
    
    
    }


    @Override  
    public Direction chooseDirection(final Map<Direction , Terrain> theNeighbors) {
        
        final Random randomGenerator = new Random();
        
        final List<Direction> list = new ArrayList<Direction>();
        
        list.add(getDirection().left());
        list.add(getDirection().right());
        list.add(getDirection());
    
    
        if (theNeighbors.get(Direction.random()) == Terrain.STREET
                        || theNeighbors.get(Direction.random()) == Terrain.CROSSWALK
                        || theNeighbors.get(Direction.random()) == Terrain.TRAIL
                        || theNeighbors.get(Direction.random()) == Terrain.GRASS
                        || theNeighbors.get(Direction.random()) == Terrain.LIGHT) {
            
            final int randomDir = randomGenerator.nextInt(list.size());
            
            myDirection = list.get(randomDir);
            
        }

        return myDirection;
       
            
        
        
            
    }

}
