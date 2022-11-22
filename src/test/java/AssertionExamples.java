import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AssertionExamples {

    @Test
    @Disabled
    public void foo(){

      //  String actual = "pepito";
      //  String expected = "pepito 2";
       // Assertions.assertTrue(actual.contains(expected),
        //        "the name is not the expected. Expected: " + expected + " Actual: " + actual);

        Assertions.assertEquals(2, 2);


    }
}
