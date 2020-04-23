package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Purpose is to read and save data chosen by Customer user on carportrequest.jsp as attributes of a Carport object
 * @author Magdalena
 */
public class MakeRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        String roofType = request.getParameter("roofType");
        int isShed = Integer.parseInt(request.getParameter("isShed"));
        Carport carportRequest= new Carport();

        carportRequest.setLength(length);
        carportRequest.setWidth(width);
        carportRequest.setRoof(new Roof(roofType));
        carportRequest.setShed(new Shed(0,0));

        HttpSession session = request.getSession();
        if(session.getAttribute("carportRequest")==null) {
            session.setAttribute("carportRequest", carportRequest);

        }

        String shedMsg="Der gik noget galt";
        int shedVersion=-1;
        if (length<560 && width<420){
            shedMsg="De mål du har valgt er for små for at bygge en skur. Den mindste længde for en carport er 440 cm " +
                    "og den mindste bredde er 300. Der skal beregnes mindst 120 cm for skur." +
                    "Du kan gå tilbage for at redigire, eller fortsætte med carport uden skur";
            shedVersion=0;

        } else if (length<560 && width>=420){
            shedMsg="Med de mål du har valgt kan du kun bygge din skur på siden af carport. " +
                    "Du kan gå tilbage for at redigire, eller vælge skurens mål. " +
                    "Vi anbefaler at skuren skal fylde hele længde af din carport.";
            shedVersion=1;
        } else if (length>=560 && width<420){
            shedMsg="Med de mål du har valgt kan du kun bygge din skur på bagsiden af carport. " +
                    "Du kan gå tilbage for at redigire, eller vælge skurens mål";
            shedVersion=2;
        } else {
            shedMsg="Din carport er ståre nok til at bygge skur på bagsiden eller på siden. ";
            shedVersion=3;
        }
        request.setAttribute("shedMsg", shedMsg);
        request.setAttribute("shedVersion", shedVersion);

        if (isShed != 0) {
            return "shedposition";
        } else {
            if (roofType.equals("pitched") && isShed == 0) {
                return "designpitchedroof";
            } else {
                return "designflatroof";
            }
        }
    }

}