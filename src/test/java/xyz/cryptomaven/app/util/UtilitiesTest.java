package xyz.cryptomaven.app.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import xyz.cryptomaven.app.commands.MaPL;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {
    MaPL m = new MaPL();
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void startupTime() {
    }

    @Test
    void getReflectionInfo_getName() {
    List<String> info = Utilities.getReflectionNames(m);
    assert info.contains(String.valueOf("MaPL"));
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