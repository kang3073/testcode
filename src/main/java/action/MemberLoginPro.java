package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MemberDAO;
import db.MemberDTO;

public class MemberLoginPro implements Action{
	//추상메서드 무조건 재정의
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MemberLoginPro execute()");
		
		//폼에서 입력한 내용이 서버에 전달 => request 내장객체 저장
		//request 태그이름에 해당하는 값을 가져오기 => 변수에 저장
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		
		// MemberDAO 객체생성=> 기억장소 할당
		MemberDAO dao=new MemberDAO();
		// MemberDTO  dto  = 주소.userCheck(id,pass)메서드 호출
		MemberDTO dto=dao.userCheck(id, pass);
		
		ActionForward forward=null;
		if(dto !=null){
			// id, pass 일치하면 MemberDTO 바구니에 데이터 담아서 가져오기
			// => 세션값 생성 "id",id(페이지 상관없이 값을 유지) , main.jsp 이동
			HttpSession session=request.getSession();
			session.setAttribute("id", id);
			
//		    response.sendRedirect("main.jsp");
			//이동정보
			forward=new ActionForward();
			forward.setPath("MemberMain.me");
			forward.setRedirect(true);
		}else{
			// id, pass 틀리면 MemberDTO 빈(null) 바구니 가져오기
			// => script   "아이디 비밀번호 틀림" 뒤로이동
			// 자바에서 html(자바스크립트) 동작
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
//		    <script type='text/javascript'>
//				alert('아이디 비밀번호 틀림');
//				history.back();
//		    </script>
			//이동정보
			forward=null;
		}
		return forward;
	}

}
