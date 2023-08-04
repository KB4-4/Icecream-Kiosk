package app.mvc.exception;

/**
 * 결제 실패할 경우 발생시킬 예외
 */
public class PayException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PayException() {
	}

	public PayException(String msg) {
		super(msg);
	}

}
