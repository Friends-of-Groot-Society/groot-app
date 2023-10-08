package springActuator;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class SpringActuatorRunner {

    @Karate.Test
    Karate testActuator() {
        return Karate.run("groot/springActuator").relativeTo(getClass());
    }
}
