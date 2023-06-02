package kh.kckass.oop.sample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestPolymophism {

	public static void main(String[] args) {
		List<Car> carList=new ArrayList<Car>();
		ArrayList<Car> carArrList=new ArrayList();
		Collection<Car> carCollection=new ArrayList<Car>();
		
		TestInterface kh=new Kh();
		((Kh)kh).khSpecial();
		
		Driver ej= new DriverSub();
		ej.setMoney(10000);
		ej.buy(new Avante());
		ej.buy(new Sonata());
	}
}
