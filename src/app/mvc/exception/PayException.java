package app.mvc.exception;

/**
 * 
 * @author 황혜령
 * 결제 실패할 경우 발생하는 예외
 */
public class PayException extends RuntimeException{
	public PayException() {}
	
	public PayException(String msg) {
		super(msg);
	}
	
}
