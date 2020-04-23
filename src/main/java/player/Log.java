package player;
import org.junit.*;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class Log {
    @Test
    public void profileTest() throws IOException {
        Profile profile =new Profile();
        profile.setProfile("example.txt");
        assertEquals("admin",profile.getName());
        assertEquals("admin00",profile.getPass());
        assertEquals("50",profile.getCoin());
    }

}
