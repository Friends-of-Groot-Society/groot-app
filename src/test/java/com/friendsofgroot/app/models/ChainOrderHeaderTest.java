package com.friendsofgroot.app.models;

import org.junit.jupiter.api.Test;

class ChainOrderHeaderTest {

    @Test
    void testEquals() {
        ChainOrderHeader oh1 = new ChainOrderHeader();
        oh1.setId(1);

        ChainOrderHeader oh2 = new ChainOrderHeader();
        oh2.setId(1);

        assert oh1.equals(oh2);
    }

    @Test
    void testNotEquals() {
        ChainOrderHeader oh1 = new ChainOrderHeader();
        oh1.setId(1);

        ChainOrderHeader oh2 = new ChainOrderHeader();
        oh2.setId(3L);

        assertFalse( oh1.equals(oh2));
    }
}
