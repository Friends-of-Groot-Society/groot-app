package com.friendsofgroot.app.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.friendsofgroot.app.commands.MaPL;

import java.util.List;

class UtilitiesTest {
    public static final String THOMASM_1_MAESTAS_GMAIL_COM = "Thomasm1.maestas@gmail.com";

    public static final String INVALID_NO_ASTERISK_COM = "Thomasm1.maestasgmail.com";
    MaPL m = new MaPL();
    @BeforeEach
    void setUp() {
        String email = THOMASM_1_MAESTAS_GMAIL_COM;
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void isAValidEmailAddress() {
        String email = THOMASM_1_MAESTAS_GMAIL_COM;
        boolean isValid = Utilities.isAValidEmailAddress(email);
        assert(isValid);
    }
    @Test
    public void isAValidEmailAddressNoAsterisk() {
        String email = INVALID_NO_ASTERISK_COM;
        boolean isValid = Utilities.isAValidEmailAddress(email);
        assert(!isValid);
    }

    @Test
    void startupTime() {
    }

    @Test
    void getReflectionInfo_getName() {

    }

    @Test
    void getReflectionInfo_isInterface() {

    }

    @Test
    void getReflectionInfo_getInterfaces_length() {
    }

    @Test
    void getReflectionInfo_getSuperclass() {
    }

    @Test
    void _earlyQuit() {
    }
}