package app.mvc.exception;

/**
 * insert, update, delete 에 결과가 오류가 있을때 발생시킬예외
 */
public class DMLException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DMLException() {
	}

	public DMLException(String message) {
		super(message);
	}

}
