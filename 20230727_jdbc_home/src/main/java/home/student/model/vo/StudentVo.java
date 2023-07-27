package home.student.model.vo;

public class StudentVo {
//	STUDENT_NO	VARCHAR2(10 BYTE)	No		1	학생 번호
//	DEPARTMENT_NO	VARCHAR2(10 BYTE)	No		2	학과 번호
//	STUDENT_NAME	VARCHAR2(40 BYTE)	No		3	학생 이름
//	STUDENT_SSN	VARCHAR2(14 BYTE)	Yes		4	학생 주민번호
//	STUDENT_ADDRESS	VARCHAR2(200 BYTE)	Yes		5	학생 주소
//	ENTRANCE_DATE	DATE	Yes		6	입학 년도
//	ABSENCE_YN	CHAR(1 BYTE)	Yes		7	휴학 여부
//	COACH_PROFESSOR_NO	VARCHAR2(20 BYTE)	Yes		8	지도 교수 번호
	
	private String studentNo;           // 학생 번호
	private String departmentNo;        // 학과 번호
	private String studentName;         // 학생 이름
	private String studentSsn;          // 학생 주민번호
	private String studentAddress;      // 학생 주소
	private String entranceDate;          // 입학 년도
	private String absenceYn;             // 휴학 여부
	private String coachProfessorNo;    // 지도 교수 번호
	
	
	
	public StudentVo() {
		super();
	}
	public StudentVo(String studentNo, String departmentNo, String studentName, String studentSsn,
			String studentAddress, String entranceDate, String absenceYn, String coachProfessorNo) {
		super();
		this.studentNo = studentNo;
		this.departmentNo = departmentNo;
		this.studentName = studentName;
		this.studentSsn = studentSsn;
		this.studentAddress = studentAddress;
		this.entranceDate = entranceDate;
		this.absenceYn = absenceYn;
		this.coachProfessorNo = coachProfessorNo;
	}
	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", departmentNo=" + departmentNo + ", studentName=" + studentName
				+ ", studentSsn=" + studentSsn + ", studentAddress=" + studentAddress + ", entranceDate=" + entranceDate
				+ ", absenceYn=" + absenceYn + ", coachProfessorNo=" + coachProfessorNo + "]";
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
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSsn() {
		return studentSsn;
	}
	public void setStudentSsn(String studentSsn) {
		this.studentSsn = studentSsn;
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
	public String getAbsenceYn() {
		return absenceYn;
	}
	public void setAbsenceYn(String absenceYn) {
		this.absenceYn = absenceYn;
	}
	public String getCoachProfessorNo() {
		return coachProfessorNo;
	}
	public void setCoachProfessorNo(String coachProfessorNo) {
		this.coachProfessorNo = coachProfessorNo;
	}
	
	
}
