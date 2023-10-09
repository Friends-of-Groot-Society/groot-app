package karate.chains;

import com.intuit.karate.junit5.Karate;

public class ChainsRunner {

    @Karate.Test
    Karate testChains() {
        return Karate.run("karate/addresses").relativeTo(getClass());
    }
}
