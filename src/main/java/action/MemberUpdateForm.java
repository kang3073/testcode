package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MemberDAO;
import db.MemberDTO;

public class MemberUpdateForm implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String id=(String)session.getAttribute("id");
		//MemberDAO 객체생성
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.getMember(id);
		
		request.setAttribute("dto", dto);
		
		ActionForward forward=new ActionForward();
		forward.setPath("member/updateForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
