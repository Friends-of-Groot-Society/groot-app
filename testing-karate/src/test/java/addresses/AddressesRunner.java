package addresses;

import com.intuit.karate.junit5.Karate;

/**
 *
 */
public class AddressesRunner {

    @Karate.Test
    Karate testChains() {
        return Karate.run("addresses").relativeTo(getClass());
    }
}
