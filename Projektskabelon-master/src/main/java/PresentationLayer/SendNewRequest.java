package PresentationLayer;

import FunctionLayer.Construction;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SendNewRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        System.out.println("SendNewRequest");
        HttpSession session = request.getSession();
        Construction construction= (Construction) session.getAttribute("carportBase");
        String email = (String) session.getAttribute("email");
        LogicFacade.sendNewRequest(construction, email);
        request.setAttribute("newRequestMSG", "Dine forespørgelse er blevet sendt til validering");
        System.out.println("MSG on request");
        return "customerpage";
    }
}
