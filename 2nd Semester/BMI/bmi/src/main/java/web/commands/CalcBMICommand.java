package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.BmiFacade;
import business.services.BmiUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcBMICommand extends CommandUnprotectedPage{
    private BmiFacade bmiFacade;

    public CalcBMICommand(String pageToShow) {
        super(pageToShow);
        this.bmiFacade = new BmiFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        //user
        User user;
        int user_id;

        HttpSession session = request.getSession();

        if(session.getAttribute("user") != null) {
            user = (User)session.getAttribute("user");
            user_id = user.getId();
        }else{
            user_id = 1;
        }

        //height
        double height = 0.0;
        //weight
        double weight = 0.0;
        //bmi
        double bmi = 0.0;
        //category
        String category = "";
        //gender
        String gender = request.getParameter("gender");
        //sport
        int sport_id = Integer.parseInt(request.getParameter("sport"));
        //hobbies
        String[] hobbies = request.getParameterValues("hobby"); //turning string list
        List<Integer> hobbyList = new ArrayList<>(); //into integer list
        for (String hobby : hobbies) { //like so...
            hobbyList.add(Integer.parseInt(hobby));
        }

        try {
            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        }
        catch(NumberFormatException ex){
            request.setAttribute("error","Incorrect input!");
            return "index";
        }

        bmi = BmiUtil.calcBMI(height,weight);

        category = BmiUtil.getCategory(bmi);

        request.setAttribute("bmi",String.format("%.2f",bmi));
        request.setAttribute("height",String.format("%.0f",height));
        request.setAttribute("weight",String.format("%.0f",weight));
        request.setAttribute("category",category);
        request.setAttribute("gender",gender);
        request.setAttribute("sport_id",sport_id);
        request.setAttribute("hobbies",hobbyList);

        bmiFacade.insertBmiEntry(bmi,height,weight,category,gender,sport_id,user_id,hobbyList);

        return pageToShow;
    }
}
