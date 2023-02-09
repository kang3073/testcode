package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MemberDAO;
import db.MemberDTO;

public class MemberUpdatePro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		//폼에서 입력한 내용이 서버에 전달 => request 내장객체 저장
		//request 한글처리
		request.setCharacterEncoding("utf-8");
		//request 태그이름에 해당하는 값을 가져오기 => 변수에 저장(id, pass, name)
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		String name=request.getParameter("name");
		// 수정할 내용을 바구니 객체생성 => 바구니에 저장
		MemberDTO updateDto=new MemberDTO();
		updateDto.setId(id);
		updateDto.setPass(pass);
		updateDto.setName(name);

		// MemberDAO 객체생성 
		MemberDAO dao=new MemberDAO();
		// MemberDTO dto = userCheck(id,pass) 메서드 호출
		MemberDTO dto=dao.userCheck(id, pass);
		// 아이디 비밀번호 일치 => 바구니 주소 가져오기
		// 아이디 비밀번호 틀림 => 빈 바구니 주소 가져오기
		ActionForward forward=null;
		if(dto!=null){
			// 리턴값없음 updateMember(MemberDTO updateDto) 메서드 정의 
			// dao.updateMember(updateDto) 메서드 호출
			dao.updateMember(updateDto);
			// => main.jsp 이동
			// response.sendRedirect("main.jsp");
			forward=new ActionForward();
			forward.setPath("MemberMain.me");
			forward.setRedirect(true);
		}else{
		//  데이터 없으면 false => 아이디 비밀번호 틀림
		//=> script   "아이디 비밀번호 틀림" 뒤로이동
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script type='text/javascript'>");
			out.println("alert('아이디 비밀번호 틀림');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			
//		    <script type="text/javascript">
//				alert("아이디 비밀번호 틀림");
//				history.back();
//		    </script>
			forward=null;
		}
		return forward;
	}
	
}
