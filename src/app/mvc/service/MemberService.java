package app.mvc.service;

import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public interface MemberService {

	/**
	 * 1. 회원가입
	 * 
	 * @author 김철
	 * @param phone 회원가입시 입력할 정보
	 * @return int 회원가입 실패여부 판별(실패시=0)
	 * @throws 회원가입 실패할 때 ▶ DMLException
	 */
	void memberInsert(String phone) throws DMLException;

	/**
	 * 2. 로그인
	 * 
	 * @author 김철
	 * @param phone 로그인 시 입력할 정보(회원 여부 판별 정보)
	 * @return MemberDTO 회원 정보
	 * @throws 회원 정보가 없을 때 ▶ SearchWrongException
	 */
	MemberDTO memberLogin(String phone) throws SearchWrongException;
}
