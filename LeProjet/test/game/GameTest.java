/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class GameTest {

    private Game game;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of initialisation method, of class Game.
     */
    @Test
    public void testInitialisation() {
        System.out.println("initialisation");
        Game instance = new Game();
        instance.initialisation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of action method, of class Game.
     */
    @Test
    public void testAction() {
        System.out.println("action");
        int numJoueur = 0;
        int coup = 0;
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.action(numJoueur, coup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of status method, of class Game.
     */
    @Test
    public void testStatus() {
        System.out.println("status");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.status();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of vainqueur method, of class Game.
     */
    @Test
    public void testVainqueur() {
        System.out.println("vainqueur");
        Game instance = new Game();
        int result = instance.vainqueur();
        boolean acceptable = result <= 2 && result >=0;
        assertTrue(acceptable);
        fail("The method 'vainqueur' must return 0 when their is no winner, or 1 or 2 depending of the player");
    }

    /**
     * Test of derniereAction method, of class Game.
     */
    @Test
    public void testDerniereAction() {
        System.out.println("derniereAction");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.derniereAction();
        assertEquals(expResult, result);
        fail("After the initialisation, the method 'derniereAction' must return 0");
    }

    /**
     * Test of Affichage method, of class Game.
     */
    @Test
    public void testAffichage() {
        System.out.println("Affichage");
        Game instance = new Game();
        String expResult = "";
        String result = instance.Affichage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
     @Test
    public void valeurVainqueur() throws Exception{
        int i = game.vainqueur();
        assertTrue(i <=2 && i >=0);
    }
    
}
