
public class Run {

	public static void main(String[] args) {
		Student ej= new Student() {
			public void goToSchool() {
				System.out.println("d");
			}
		};
		ej.goToSchool();
	}
}
