package groot.springRest;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class SpringRestRunner {

    @Karate.Test
    Karate testREST() {
        return Karate.run("groot/springRest").relativeTo(getClass());
    }
}
