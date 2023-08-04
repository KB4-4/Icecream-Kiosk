package app.mvc.controller;

import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
import app.mvc.service.MemberService;
import app.mvc.service.MemberServiceImpl;
import app.mvc.session.Session;
import app.mvc.view.FailView;
import app.mvc.view.MenuView;
import app.mvc.view.SuccessView;

import java.util.Scanner;

public class LoginController {
    static Session session;
    static Scanner sc = new Scanner(System.in);
    private static MemberService memberService = MemberServiceImpl.getInstance();

    public static void inputMemberInsert(String tempPhone){
    	try {
    		memberService.memberInsert(tempPhone);
    	} catch(DMLException e) {
    		FailView.errorMessage(e.getMessage());
    	}
    }

    public static void inputMemberLogin(String tempPhone){
    	try {
    		MemberDTO memberDTO = memberService.memberLogin(tempPhone);
    		Session.getInstance().setMember_no(memberDTO.getMemberNo());
			MenuView.printUserMenu(Session.getInstance().getMember_no());
    	} catch (SearchWrongException e) {
    		FailView.errorMessage(e.getMessage());
    	}

    }
}
