package board.model.vo;

public class boardVo {
//	NUMBER	IDX	No	"SEMI"."IDX_SEQUENCE"."NEXTVAL"
//	VARCHAR2(300 BYTE)	SUBJECT	No	
//	VARCHAR2(4000 BYTE)	CONTENT	No	
//	TIMESTAMP(6)	WDATE	No	"SYSTIMESTAMP	"
//	VARCHAR2(10 BYTE)	ID	No	
	private int number;
    private String subject;
    private String content;
    private String wdate;
    private String id;
    
    
	public boardVo(int number, String subject, String content, String wdate, String id) {
		super();
		this.number = number;
		this.subject = subject;
		this.content = content;
		this.wdate = wdate;
		this.id = id;
	}

	@Override
	public String toString() {
		return "boardVo [number=" + number + ", subject=" + subject + ", content=" + content + ", wdate=" + wdate
				+ ", id=" + id + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
    
    
}
