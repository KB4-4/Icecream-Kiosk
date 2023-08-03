package app.mvc.service;

import app.mvc.controller.LoginController;
import app.mvc.dao.MemberDAO;
import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
import app.mvc.session.Session;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService{

    private static MemberService instance = new MemberServiceImpl();
    private MemberDAO memberDAO = MemberDAOImpl.getInstance();
    private MemberServiceImpl(){}
    public static MemberService getInstance(){
        return instance;
    }

    @Override
    public void memberInsert(String phone) throws DMLException{
        int result = memberDAO.memberInsert(phone);
        if(result == 0) throw new DMLException("회원가입이 실패했습니다.");
        else System.out.println("회원가입 성공");
    }

    @Override
    public MemberDTO memberLogin(String phone) throws SearchWrongException {
        MemberDTO memberDTO = memberDAO.memberLogin(phone);
        if(memberDTO != null) {
            System.out.println("회원 정보" + memberDTO);
            Session.getInstance().setMember_no(memberDTO.getMemberNo());
            System.out.println(Session.getInstance().getMember_no() + "세션 확인");
            return memberDTO;

//            System.out.println(phone + "의 정보가 없습니다.");
//            return null;
        }
//        else {
            //System.out.println("회원 정보" + memberDTO);
            //Session.getInstance().setMember_no(memberDTO.getMemberNo());
            //System.out.println(Session.getInstance().getMember_no() + "세션 확인");
//        }
        throw new SearchWrongException(phone + "의 정보가 없습니다.");

        }
}
