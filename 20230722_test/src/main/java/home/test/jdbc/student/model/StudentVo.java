package home.test.jdbc.student.model;

import java.sql.Date;

public class StudentVo {
	private String studentNo;
	private String departmentNo; 
	private String studentName;
	private String studentSSN;
	private String studentAddress; 
	private Date entranceDate; 
	private String absenceYN; 
	private String coachProfessorNo;
	@Override
	public String toString() {
		return "StudentVo [studentNo=" + studentNo + ", departmentNo=" + departmentNo + ", studentName=" + studentName
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
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
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
	public Date getEntranceDate() {
		return entranceDate;
	}
	public void setEntranceDate(Date entranceDate) {
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


