package kh.lclass.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kh.lclass.oop.sample.Car;

public class TestCollection{
	
	
	
	public void testHashMap() {
		Map<String,Object> objMap= new HashMap<>();
		Map<String,Integer> objMap2= new HashMap<>();
		objMap.put("ej",35.0);
		objMap.put("jy","지영이네");
		objMap.put("hj",new Car(5000));
		System.out.println(objMap);
		System.out.println("jy"+":"+objMap.get("jy"));
		
		Set<String> keyset = objMap.keySet();
		System.out.println(keyset);
		System.out.println("==== Map: enhanced for ======");
		for(String item :keyset) {
			Object value=objMap.get(item);
			System.out.println(item+":"+value);
		}
		
		System.out.println("==== Map: Iterator for ======");
		Iterator<String> itr= keyset.iterator();
		while(itr.hasNext()) {
			String item=itr.next();
			Object value=objMap.get(item);
			System.out.println(item+":"+value);
		}
		
	}
	
	public void testHeashet() {
		Set<Integer> integerSet= new HashSet<Integer>();
		integerSet.add(11);
		integerSet.add(22);
		integerSet.add(33);
		integerSet.add(11); //저장안됨
		System.out.println(integerSet.toString());
		
		System.out.println("=== Set : enhanced for ====");
		for(Integer item: integerSet) {
			System.out.println(item);
		}
		
		System.out.println("=== Set : Iterator 사용 ====");
		Iterator<Integer> itr= integerSet.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());	
	}
	
	
	
	
	
	
	
	
	
	public void testArrayList() {
		String[] strArr1= new String[3];
		strArr1[0]="바나나";
		strArr1[1]="딸기";
		
		ArrayList<Integer> list2=new ArrayList<Integer>();
		ArrayList<Car> list3=new ArrayList<Car>();
		
		list3.add(new Car(3000));
		
		list2.add(25);
		list2.add(25);
		list2.add(null);
		list2.add(27);
		list2.add(55);
		System.out.println(list2.get(2));
		System.out.println(list2.get(3));
		System.out.println(list2);
		
		
		System.out.println("-------------------list2출력-----------------");
		for(int i=0;i<list2.size();i++) {
			Integer item=list2.get(i);
			System.out.println(item);
		}
		System.out.println("-------------------strArr배열출력-----------------");
		for(int i=0;i<strArr1.length;i++) {
			String item=strArr1[i];
			System.out.println(item);
		}
		
		System.out.println("===== enhanced for list2=====");
		for(Integer i:list2) {
			System.out.println(i);
		}
		
		List<String> list1=new ArrayList<String>();
		if(list1.add("7번"))
			System.out.println("list1에 추가 성공했습니다.");
		
		list1.add("2번");
		list1.add("1번");
		list1.add("2번");
		list1.add("3번");
		list1.remove("1번");
		System.out.println(list1);
		Collection<String> collection1=new ArrayList<>();
		collection1.add("2번");
		list1.removeAll(collection1);
		System.out.println("\n"+"removeAll(2번)한후");
		System.out.println(list1);
	}
}