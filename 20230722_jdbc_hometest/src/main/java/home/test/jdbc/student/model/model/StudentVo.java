package home.test.jdbc.student.model.model;

public class StudentVo {
//	STUDENT_NO	VARCHAR2(10 BYTE)
//	DEPARTMENT_NO	VARCHAR2(10 BYTE)
//	STUDENT_NAME	VARCHAR2(40 BYTE)
//	STUDENT_SSN	VARCHAR2(14 BYTE)
//	STUDENT_ADDRESS	VARCHAR2(200 BYTE)
//	ENTRANCE_DATE	DATE
//	ABSENCE_YN	CHAR(1 BYTE)
//	COACH_PROFESSOR_NO	VARCHAR2(20 BYTE)
	private String studentNo;
	private String departmentNo;
	private String StudentName;
	private String studentSSN;         
	private String studentAddress;
	private String entranceDate;       
	private String absenceYN;           
	private String coachProfessorNo;
	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", departmentNo=" + departmentNo + ", StudentName=" + StudentName
				+ ", studentSSN=" + studentSSN + ", studentAddress=" + studentAddress + ", entranceDate=" + entranceDate
				+ ", absenceYN=" + absenceYN + ", coachProfessorNo=" + coachProfessorNo + "]";
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentSSN() {
		return studentSSN;
	}
	public void setStudentSSN(String studentSSN) {
		this.studentSSN = studentSSN;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(String entranceDate) {
		this.entranceDate = entranceDate;
	}
	public String getAbsenceYN() {
		return absenceYN;
	}
	public void setAbsenceYN(String absenceYN) {
		this.absenceYN = absenceYN;
	}
	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}
	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}
	
	
}
