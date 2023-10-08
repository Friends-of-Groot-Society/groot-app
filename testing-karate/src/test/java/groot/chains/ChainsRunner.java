package groot.chains;

import com.intuit.karate.junit5.Karate;

public class ChainsRunner {

    @Karate.Test
    Karate testChains() {
        return Karate.run("groot/addresses").relativeTo(getClass());
    }
}
