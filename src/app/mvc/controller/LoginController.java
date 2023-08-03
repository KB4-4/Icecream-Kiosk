package app.mvc.controller;

import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.SearchWrongException;
import app.mvc.service.MemberService;
import app.mvc.service.MemberServiceImpl;
import app.mvc.session.Session;
import app.mvc.view.MainView;

import java.util.Scanner;

public class LoginController {

    static Scanner sc = new Scanner(System.in);

    private static MemberService memberService = MemberServiceImpl.getInstance();

    public static void main(String[] args){
        System.out.println("====== 프로그램 시작 ======");
        while(true){

            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            try{
                int a = Integer.parseInt(sc.nextLine());
                switch (a){
                    case 1 :
                        inputMemberInsert();
                        break;
                    case 2 :
                        inputMemberLogin();
                        break;
                    case 100 :
                        System.out.println("종료");
                        System.exit(0);
                    default:
                        System.out.println("다시 입력해주세요");

                }

            }catch(NumberFormatException e){
                System.out.println("숫자만 입력하세요");
            }
        }

    }

    public static void inputMemberInsert(){
        System.out.println("====== 회원가입 진행 ======");
        System.out.println("====== 가입할 전화번호를 입력하세요 ======");

        String tempPhone = sc.nextLine();
        memberService.memberInsert(tempPhone);
    }

    public static void inputMemberLogin(){
        System.out.println("로그인 할 전화번호 입력('-' 포함)");
        String tempPhone = sc.nextLine();
        try {
            MemberDTO memberDTO = memberService.memberLogin(tempPhone);
            Session.getInstance().setMember_no(memberDTO.getMemberNo());
            System.out.println("지금 뷰의 세션 : " + Session.getInstance().getMember_no());
        } catch(SearchWrongException e) {
            System.out.println("회원 정보가 없습니다.");
        }
    }
}
