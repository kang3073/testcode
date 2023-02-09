package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.MemberDAO;
import db.MemberDTO;

public class MemberInfo implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		
		MemberDAO dao=new MemberDAO();
		MemberDTO dto=dao.getMember(id);
		
		//dto 정보 들고 가기(request 정보를 담아가기)
		request.setAttribute("dto", dto);
		
		// Member/info.jsp 주소 변경없이(false) 이동
		ActionForward forward=new ActionForward();
		forward.setPath("member/info.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
