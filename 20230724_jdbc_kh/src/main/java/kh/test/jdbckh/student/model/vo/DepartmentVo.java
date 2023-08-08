package kh.test.jdbckh.student.model.vo;

public class DepartmentVo {
    private String departmentNo;     // DEPARTMENT_NO
    private String departmentName;   // DEPARTMENT_NAME
    private String category;         // CATEGORY
    private String openYN;             // OPEN_YN
    private int capacity;            // CAPACITY
	@Override
	public String toString() {
		return "DepartmentVo [departmentNo=" + departmentNo + ", departmentName=" + departmentName + ", category="
				+ category + ", openYN=" + openYN + ", capacity=" + capacity + "]";
	}
	public String getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(String departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getOpenYN() {
		return openYN;
	}
	public void setOpenYN(String openYN) {
		this.openYN = openYN;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
