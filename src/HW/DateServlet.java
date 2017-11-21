package HW;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*PrintWriter out = resp.getWriter();

        resp.setContentType("text/html");

        Calendar calendar = new GregorianCalendar();
        String am_pm;

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";

        String CT = hour+":"+ minute +":"+ second +" "+ am_pm;




        out.println("<body bgcolor = \"#f0f0f0\">\n" +
                "<p>Current Time is: " + CT + "</p>\n"
        );

        out.println("<p>"+
                req.getHeader("User-Agent")+
                "</p>\n"
        );*/

        Calendar calendar = new GregorianCalendar();
        String am_pm;

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        if(calendar.get(Calendar.AM_PM) == 0)
            am_pm = "AM";
        else
            am_pm = "PM";
        String CT = hour+":"+ minute +" "+ am_pm;
        String CD = day+"."+month+"."+year;

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "HTTP Get Date and User-Agent";

        out.println("<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor = \"#f0f0f0\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table width = \"100%\" border = \"1\" align = \"center\">\n" +
                "<tr bgcolor = \"#949494\">\n" +
                "<th>Name</th><th>Value</th>\n"+
                "</tr>\n"
        );


        out.print("<tr><td>" + "Current Date" + "</td>\n");
        out.println("<td> " + CD + "</td></tr>\n");

        out.print("<tr><td>" + "Current Time" + "</td>\n");
        out.println("<td> " + CT + "</td></tr>\n");

        out.print("<tr><td>" + "User-Agent" + "</td>\n");
        out.println("<td> " + req.getHeader("User-Agent") + "</td></tr>\n");

        out.println("</table>\n</body></html>");






    }
}
