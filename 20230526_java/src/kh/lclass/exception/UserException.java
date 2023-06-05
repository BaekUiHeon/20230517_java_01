package kh.lclass.exception;

public class UserException extends Throwable {
	
	public UserException() {
		super("UserException occured");
	}
	public UserException(String str) {
		super(str);
	}
}
