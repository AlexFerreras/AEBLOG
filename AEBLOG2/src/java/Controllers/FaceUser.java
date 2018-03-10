package Controllers;

import Models.UserDAO;
import Pojos.User;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "faceUser")
@SessionScoped
public class FaceUser implements Serializable{
 
    User user = new User();
    User loginOn = new User();
    User new_user = new User();
    UserDAO userdao = new UserDAO();
    public User getLoginOn() {
        return loginOn;
    }

    public void setLoginOn(User loginOn) {
        this.loginOn = loginOn;
    }

    public User getNew_user() {
        return new_user;
    }

    public void setNew_user(User new_user) {
        this.new_user = new_user;
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDAO getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDAO userdao) {
        this.userdao = userdao;
    }

    @SuppressWarnings("empty-statement")
    public void newUser() {
        try {
            userdao.newUser(this.new_user);
        } catch (SQLException ex) {
            System.out.println("Error al tratar de crear nuevo usuario" + ex.getMessage());
        } finally {
            this.new_user= new User();
        }
    }

    public String login() throws ClassNotFoundException, SQLException {

    
            this.loginOn = userdao.Login(this.user);
            
            if(this.loginOn.getId() > 0 ){
           
                return "home";
                
                
            }
            else {
               RequestContext.getCurrentInstance().update("groul");
               FacesContext context = FacesContext.getCurrentInstance();
               context.addMessage(this.loginOn.getEmail(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre De Usuario O Passwor Incorecto"));
               return "";
              }
       
        

    }
    
    
    public void logOut(){
        //cerrar la sesion activa
        
    try {
        FacesContext.getCurrentInstance()
            .getExternalContext().invalidateSession();
        }catch(Exception e){
         e.printStackTrace();
    }
    }
}
