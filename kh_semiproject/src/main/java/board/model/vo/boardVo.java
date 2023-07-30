package board.model.vo;

public class boardVo {
//	number	IDX	No	"SEMI"."IDX_SEQUENCE"."NEXTVAL"
//	VARCHAR2(300 BYTE)	SUBJECT	No	
//	VARCHAR2(4000 BYTE)	CONTENT	No	
//	TIMESTAMP(6)	WDATE	No	"SYSTIMESTAMP	"
//	VARCHAR2(10 BYTE)	ID	No	
	private String idx;
    private String subject;
    private String content;
    private String wdate;
    private String id;
    
    
	public boardVo(String idx, String subject, String content, String wdate, String id) {
		super();
		this.idx = idx;
		this.subject = subject;
		this.content = content;
		this.wdate = wdate;
		this.id = id;
	}

	@Override
	public String toString() {
		return "boardVo [idx=" + idx + ", subject=" + subject + ", content=" + content + ", wdate=" + wdate
				+ ", id=" + id + "]";
	}

	public String getidx() {
		return idx;
	}

	public void setidx(String idx) {
		this.idx = idx;
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
