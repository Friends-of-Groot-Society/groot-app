package com.friendsofgroot.app.system;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.friendsofgroot.app.systemAdmin.AdminLotState;

//AdminLotState nov26 = new AdminLotState(date, carLotCount);
//nov26.getCoinCount(); 

public class AdminLotStateTest {

private AdminLotState als;

	@BeforeEach
	public void setup()  {
        als = new AdminLotState("11/28", 10);  
	}

    @Test
    public void getCoinCount() { 
		int carCount =  als.getCoinCount(); 
		System.out.println("nov 28 inventory ORIGINAL getCoinCount: " + carCount);
    }
    
    @Test
    public void addCoin() { 
		int carCount =  als.addCoin(2);  
		System.out.println("nov 28 inventory addCoin(2): " + carCount);
		
    }

    @Test
    public void removeCoin() { 
		int carCount =  als.removeCoin(3, true); // # if purchased
		System.out.println("nov 28 inventory removeCoin(3, true): " + carCount);
    }

    @Test
    public void dummyTestFail() {
//    	assertEquals(20,21);
    	assertEquals(20,20);
    }
}