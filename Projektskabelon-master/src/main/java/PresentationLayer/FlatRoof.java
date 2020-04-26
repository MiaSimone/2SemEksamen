package PresentationLayer;

import FunctionLayer.*;
import sun.net.dns.ResolverConfiguration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class FlatRoof extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        Carport carportRequest = (Carport) session.getAttribute("carportRequest");


        int height = Integer.parseInt(request.getParameter("height"));
        int tilt = Integer.parseInt(request.getParameter("tilt"));

        RoofSizing roofSizing = new RoofSizing(carportRequest);

        int[] tiltOptions = roofSizing.pitchDegreesOptionsForCostumerToChoose();

        request.setAttribute("height", height);
        request.setAttribute("tilt", tilt);

        carportRequest.getRoof().setHeight(height);
        carportRequest.getRoof().setDegree(tilt);

        session.setAttribute("carportRequest", carportRequest);

        return "login";
    }
}
