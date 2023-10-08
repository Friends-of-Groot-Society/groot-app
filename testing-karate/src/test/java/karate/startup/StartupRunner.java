package groot.startup;

import com.intuit.karate.junit5.Karate;

public class StartupRunner {

    @Karate.Test
    Karate testStartup() {
        return Karate.run( "startup").relativeTo(getClass());
    }
}
