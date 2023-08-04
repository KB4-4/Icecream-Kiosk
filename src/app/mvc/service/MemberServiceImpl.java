package app.mvc.service;

import app.mvc.dao.MemberDAO;
import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
import app.mvc.session.Session;

public class MemberServiceImpl implements MemberService {

	private static MemberService instance = new MemberServiceImpl();
	private MemberDAO memberDAO = MemberDAOImpl.getInstance();

	private MemberServiceImpl() {
	}

	public static MemberService getInstance() {
		return instance;
	}

	/**
	 * 회원가입
	 */
	@Override
	public void memberInsert(String phone) throws DMLException {
		int result = memberDAO.memberInsert(phone);
		if (result == 0)
			throw new DMLException("회원가입이 실패했습니다.");
		else
			System.out.println("회원가입 성공");
	}

	/**
	 * 로그인
	 */
	@Override
	public MemberDTO memberLogin(String phone) throws SearchWrongException {
		MemberDTO memberDTO = memberDAO.memberLogin(phone);
		if (memberDTO != null) {
			Session.getInstance().setMember_no(memberDTO.getMemberNo());
			return memberDTO;
		}
		throw new SearchWrongException(phone + "의 정보가 없습니다.");
	}

}
