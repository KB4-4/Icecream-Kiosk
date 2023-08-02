package app.mvc.exception;


/**
 * 검색에 관련된 오류가 있을 때 발생시킬 예외
 * @author 장재은
 */

public class SearchWrongException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public SearchWrongException() {};
	public SearchWrongException(String message) {
		super(message);
	}
}
