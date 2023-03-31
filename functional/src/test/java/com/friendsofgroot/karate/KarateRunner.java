package com.friendsofgroot.app.functional;

import com.intuit.karate.junit5.Karate;

class KarateRunner {

    @Karate.Test
    Karate testApis() {
        return Karate.run("apis").relativeTo(getClass());
    }

}
