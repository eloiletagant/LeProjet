package JUnit;

import game.Game;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;


/**
 * Created by ambie on 06/04/2017.
 */
public class GameTest {

    
    private Game game;

    @Before
    public void setUp() throws Exception {
        game = new Game();
    }

    @After
    public void tearDown() throws Exception {

    }


}