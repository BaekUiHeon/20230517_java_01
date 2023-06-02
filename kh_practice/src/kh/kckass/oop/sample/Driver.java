package kh.kckass.oop.sample;

public class Driver {
	private int license;
	private int money;
	
	
	
	public int getLicense() {
		return license;
	}



	public void setLicense(int license) {
		this.license = license;
	}



	public int getMoney() {
		return money;
	}



	public void setMoney(int money) {
		this.money = money;
	}
	
	//자동차를 구매 
	public void buy(Car c) {
		if(money>=c.getPrice()) {
				System.out.println("이벤트에 응모되셨습니다.");
			
			if(c instanceof Car) {
				System.out.println("Car이벤트에 응모되셨습니다.");
			}
			System.out.println(c.getPrice()+"원에구매확정");
			money=money-c.getPrice();
			c.moveCar();
		}
		else
			System.out.println("잔액부족!, 현재 잔액은"+money);
	}
}