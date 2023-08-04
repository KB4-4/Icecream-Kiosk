package app.mvc.exception;

/**
 * select에 결과가 오류가 있을때 발생시킬예외
 */
public class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotFoundException() {
	}

	public NotFoundException(String message) {
		super(message);
	}
}
