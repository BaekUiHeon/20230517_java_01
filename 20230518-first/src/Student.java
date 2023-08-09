
public abstract class Student {

		private String name;
		private int score;
		public static final String SCHOOL_NAME="서울대";
		
		public int sumScore() {
			int result=0;
			return result; //구현해야함
		}
		public double avgScore(int ... a) {
			double avg;
			int sum=0;
			for(int score : a)
				sum+=score;
			avg= sum/a.length;
			return avg; //구현해야함
		}
		
		public abstract void goToSchool();
}
