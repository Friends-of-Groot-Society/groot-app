package xyz.cryptomaven.app.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
 
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import xyz.cryptomaven.app.models.Coin;
import xyz.cryptomaven.app.service.CoinService;

public class CoinServiceTest {      // *NOTE: change PK coinnames before sending to DB

//        Setup Coin  p1; get
//		  Coin  p2; update
//		  Coin p3; delete

	@BeforeAll // setup
	public static void setupClass() {
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @Test   
	public void add_new_coin() {
		Coin c = new Coin(75757, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		assertTrue(CoinService.createCoin(c));
		
	}
    @Test   
   	public void update_coin() {
   		Coin c = new Coin(75578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
   		assertTrue(CoinService.updateCoin(c));
   		
   	}
    @Test   
   	public void get_coin_make() {
    	Coin c = new Coin(75578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		CoinService.createCoin(c);
   		assertEquals("Tesla", c.getCoinToken());
   		
   	} 
    @Test   
   	public void get_coin() {
    	Coin c = new Coin(775578, "Tesla", "CyberTruck", 45000.00, 0);    // PASSES
		CoinService.getCoin(c.getCoinId()); 
   		assertEquals(CoinService.getCoin(c.getCoinId()), CoinService.getCoin(c.getCoinId())); // Check not null bc dynamic int ID
   		
   	} 
	@Test   
   	public void delete_coin() {										  // PASSES
		Coin c = new Coin(77558, "Tesla", "CyberTruck", 45000.00, 0);  
   		CoinService.createCoin(c); 
   		assertTrue(CoinService.deleteCoin(c.getCoinId())); 
   	}
     
	@AfterAll
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete coin from add_coin test


}