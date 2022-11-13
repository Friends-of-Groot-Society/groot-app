package com.friendsofgroot.app.service;

import java.util.List;

import com.friendsofgroot.app.dao.ElectroLotDAO;
import com.friendsofgroot.app.dao.ElectroLotDAOImpl;
import com.friendsofgroot.app.models.ElectroLot;

public class ElectroLotService { // This is static version of DAO method

	public static ElectroLotDAO electro = new ElectroLotDAOImpl();

	public static ElectroLot getElectroLot(int el) {
		return electro.getElectroLot(el);

	}

	public static ElectroLot getElectroLot(String username) {
		return electro.getElectroLot(username);

	}

	public static List<ElectroLot> getAllElectroLot() {
		return electro.getAllElectroLot();
	}

	public static  List<ElectroLot>  getAllElectroLot(String username) {
		return electro.getAllElectroLot(username);
	}
	
	public static boolean addElectroLot(ElectroLot el) {
		return electro.addElectroLot(el);
	}

	public static boolean updateElectroLot(ElectroLot change) {
		return electro.updateElectroLot(change);
	}

	public static boolean deleteElectroLot(int el) {
		return electro.deleteElectroLot(el);
	}

}
