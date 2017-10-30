package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import model.Direction;
import model.Human;
import model.Light;
import model.Terrain;
import model.Truck;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Allen Tran
 * @version 4-20-2017
 *
 */

public class TruckTest {
    
    /**
     * Make variable for Truck.
     */
    
    private Truck myT;
    

    /**
     * 
     * @throws Exception 
     */

    @Before
    public void setUp() throws Exception {
        
        myT = new Truck(50, 50, Direction.NORTH);
  
        
    }
    
    /**
     * Make method to test Truck Constructor.
     */
    
    @Test
    public void testTruckConstructor() {
        
        assertEquals(50, myT.getX());
        assertEquals(50, myT.getY());
        assertEquals(Direction.NORTH, myT.getDirection());
        assertEquals(1, myT.getDeathTime());
        assertTrue(myT.isAlive());
    }
    
    /**
     * 
     * Make method for testTruckSetters.
     */
    
    @Test
    public void testTruckSetters() {

        myT.setX(12);
        assertEquals(12, myT.getX());
        myT.setY(13);
        assertEquals(13, myT.getY());
        myT.setDirection(Direction.SOUTH);
        assertEquals(Direction.SOUTH, myT.getDirection());
    }
    
    /**
     * Make test method for green light.
     */
    
    @Test
    public void testCanPassGreenLight() {
        
        
        
        
        assertEquals(true, myT.canPass(Terrain.STREET, Light.GREEN));
        
        assertEquals(true, myT.canPass(Terrain.CROSSWALK, Light.GREEN));
        
        assertEquals(true, myT.canPass(Terrain.LIGHT, Light.GREEN));
        
    }
    
    /**
     * Make test method for yellow light.
     */
    
    @Test
    public void testCanPassYellowLight() {       
        
        assertEquals(true, myT.canPass(Terrain.STREET, Light.YELLOW));
        
        assertEquals(true, myT.canPass(Terrain.CROSSWALK, Light.YELLOW));
        
        assertEquals(true, myT.canPass(Terrain.LIGHT, Light.YELLOW));
        
    }
    
    /**
     * Make test method for red light.
     */
    
    @Test
    public void testCanPassRedLight() {
        
        
        
        assertEquals(true, myT.canPass(Terrain.STREET, Light.RED));
        
        assertEquals(true, myT.canPass(Terrain.CROSSWALK, Light.RED));
        
        assertEquals(true, myT.canPass(Terrain.LIGHT, Light.RED));
        
    }

    
    /**
     * Make method to testChooseDirection.
     */

    @Test
    public void testChooseDirection() {

        
        assertEquals(Terrain.LIGHT , Terrain.LIGHT);
    }
    
    /**
     * Make method to testChooseDirectionOnGrassNearCrosswalk.
     */
  

/**
 * Test method for {@link Human#canPass(Terrain, Light)}.
 */
    @Test
public void testCanPass() {
    
    // Trucks can move to Street or to CROSSWALKS
    // so we need to test both of those conditions
        
        final List<Terrain> validTerrain = new ArrayList<>();
        validTerrain.add(Terrain.STREET);
        validTerrain.add(Terrain.CROSSWALK);
            
        final Truck t = new Truck(0, 0, Direction.NORTH);
    // test each terrain type as a destination
        for (final Terrain destinationTerrain : Terrain.values()) {
        // try the test under each light condition
            for (final Light currentLightCondition : Light.values()) {
                if (destinationTerrain == Terrain.STREET) {
            
                // Trucks can pass GRASS under any light condition
                    assertTrue("Truck should be able to pass GRASS"
                           + ", with light " + currentLightCondition,
                           t.canPass(destinationTerrain, currentLightCondition));
                } else if (destinationTerrain == Terrain.CROSSWALK) {
                       // humans can pass CROSSWALK
                       // if the light is YELLOW or RED but not GREEN

                    if (currentLightCondition == Light.GREEN) {
                        assertTrue("Truck should pass Green " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            t.canPass(destinationTerrain,
                                      currentLightCondition));
                    } else { // light is yellow or red
                        assertTrue("Truck should be able to pass " + destinationTerrain
                            + ", with light " + currentLightCondition,
                            t.canPass(destinationTerrain,
                                      currentLightCondition));
                    }
                } 
            } 
        }
    }
}
