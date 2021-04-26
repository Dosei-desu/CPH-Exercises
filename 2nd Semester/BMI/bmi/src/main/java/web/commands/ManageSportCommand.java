package web.commands;

import business.exceptions.UserException;
import business.services.BmiFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManageSportCommand extends CommandProtectedPage{
    BmiFacade bmiFacade;

    public ManageSportCommand(String pageToShow, String role) {
        super(pageToShow, role);
        this.bmiFacade = new BmiFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        String deleteId = request.getParameter("delete");
        String editId = request.getParameter("edit");
        String update = request.getParameter("update");

        if(deleteId != null){
            int rowsAffected = bmiFacade.deleteSport(Integer.parseInt(deleteId));
            if(rowsAffected > 0){
                request.getServletContext().setAttribute("sportList", bmiFacade.getAllSports());
            }else{
                request.setAttribute("error","Cannot delete a sports-type selected by users!");
            }
        }else if(editId != null){
            request.setAttribute("sportItem",bmiFacade.getSportsById(Integer.parseInt(editId)));
            return "editsportspage";
        }else if(update != null){
            String name = request.getParameter("name");
            int sport_id = Integer.parseInt(request.getParameter("sports_id"));
            int rowsInserted = bmiFacade.updateSport(sport_id,name);
            if(rowsInserted == 1){
                request.getServletContext().setAttribute("sportList", bmiFacade.getAllSports());
            }
        }

        return pageToShow;
    }
}
