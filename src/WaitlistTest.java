import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WaitlistTest {
  
  // TODO: Implement tests for removeStudents

  // Hints:
  // - removeStudents is an instance method, so your arrange will need to create an instance of Waitlist
  // - When comparing arrays you should use Arrays.equals instead of the equals instance method or ==
  //     java.util.Arrays is imported for you at the top of this file. 

  @Test
  public void testRemoveSomeStudents() {
    Waitlist w = new Waitlist(new String[]{"x", "r", "q", "m", "v"}, 7);
    w.removeStudents(new HashSet<>(Arrays.asList("r", "m")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{"x", "q", "v", null, null, null, null}));
  }

  @Test
  public void testRemoveNone() {
    Waitlist w = new Waitlist(new String[]{"a", "b", "c"}, 5);
    w.removeStudents(new HashSet<>());
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{"a", "b", "c", null, null}));
  }
  @Test
  public void testRemoveAll() {
    Waitlist w = new Waitlist(new String[]{"a", "b"}, 3);
    w.removeStudents(new HashSet<>(Arrays.asList("a", "b")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{null, null, null}));
  }

  @Test
  public void testRemoveWithNullsInMiddle() {
    Waitlist w = new Waitlist(new String[]{"a", "b", "c"}, 5);
    w.removeStudents(new HashSet<>(Arrays.asList("b")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{"a", "c", null, null, null}));
  }

  @Test
  public void testRemoveStudentNotInList() {
    Waitlist w = new Waitlist(new String[]{"a", "b", "c"}, 5);
    w.removeStudents(new HashSet<>(Arrays.asList("z")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{"a", "b", "c", null, null}));
  }

  @Test
  public void testRemoveFirstAndLast() {
    Waitlist w = new Waitlist(new String[]{"first", "mid", "last"}, 5);
    w.removeStudents(new HashSet<>(Arrays.asList("first", "last")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{"mid", null, null, null, null}));
  }
  @Test
  public void testEmptyWaitlist() {
    Waitlist w = new Waitlist(new String[]{}, 3);
    w.removeStudents(new HashSet<>(Arrays.asList("anything")));
    assertTrue(Arrays.equals(w.getWaitlist(), new String[]{null, null, null}));
  }
}