package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author allen
 *@version 4-20-2017
 */

public class Human extends AbstractVehicle {
    
    /**
     *Make variable for death time.
     */
    
    private static final int DEATHTIME = 50;
    
    /**
     * Make Variable for myDirection.
     */

    private Direction myDirection;
    
    /**
     * 
     * @param theX X Coordinate for Human.
     * @param theY Y Coordinate for Human.
     * @param theDir Direction for Human.
     */
    
    public Human(final int theX , final int theY , final Direction theDir) {
    
    super(theX, theY, theDir, DEATHTIME);
    
        myDirection = theDir;
        
        
    }


    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        
        
        boolean result = false;

        if (theTerrain == Terrain.CROSSWALK
                        || theTerrain == Terrain.GRASS) {
    
            result = true;
        
        } 

        if (theLight == Light.GREEN && theTerrain == Terrain.CROSSWALK) {
    
            result = false;
    
    
        } 

        return result;


    }

/**
 * 
 * Make method chooseDirectoin. 
 * @param theNeighbors Terrain
 * @return Direction Directions
 */
    
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        
        
        final Random randomGenerator = new Random();
    
        final List<Direction> list = new ArrayList<Direction>();
   
    
        if (theNeighbors.get(getDirection()) == Terrain.CROSSWALK) {
        
        
            myDirection = getDirection();
    

        
        } else if (theNeighbors.get(getDirection().left()) 
                        == Terrain.CROSSWALK) {
        
        
            myDirection = getDirection().left();
        
        
        } else if (theNeighbors.get(getDirection().right()) 
                        == Terrain.CROSSWALK) {
        
        
            myDirection = getDirection().right();
        

        
        } else {
        
            if (theNeighbors.get(getDirection()) == Terrain.GRASS                
                        || (theNeighbors.get(getDirection()) == Terrain.CROSSWALK)) {
            
            
                list.add(getDirection());
        

            
            } 
            
            if (theNeighbors.get(getDirection().left()) == Terrain.GRASS
                        || (theNeighbors.get(getDirection().left()) == Terrain.CROSSWALK)) {
            
                list.add(getDirection().left());
            
            
            }
            
            if (theNeighbors.get(getDirection().right()) == Terrain.GRASS 
                        || (theNeighbors.get(getDirection().right()) == Terrain.CROSSWALK)) {
            
                list.add(getDirection().right());
            
            
            } 
            if (list.isEmpty()) {
            
                myDirection = getDirection().reverse();
                
            
            } else {
            
                final int randomDir = randomGenerator.nextInt(list.size());
            
                myDirection = list.get(randomDir);
            

            
            }
        
        }
    

  
    
    
        return myDirection;
            
            
    }

}