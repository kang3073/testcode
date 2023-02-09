package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MemberDAO;
import db.MemberDTO;

public class MemberDeletePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//request 태그이름에 해당하는 값을 가져오기 => 변수에 저장(id, pass)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");

		// MemberDAO 객체생성
		MemberDAO dao=new MemberDAO();
		// MemberDTO dto = userCheck(id,pass) 메서드 호출
		MemberDTO dto=dao.userCheck(id, pass);
		
		ActionForward forward=null;
		if(dto != null){
			// id,pass 일치
			// 리턴값없음 deleteMember(String id) 메서드 정의 
			// dao.deleteMember(id) 메서드 호출
			dao.deleteMember(id);
			// => 세션값 초기화
			HttpSession session=request.getSession();
			session.invalidate();		
			// => main.jsp 이동
			//response.sendRedirect("main.jsp");
			forward=new ActionForward();
			forward.setPath("MemberMain.me");
			forward.setRedirect(true);
		}else{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
	}

}
