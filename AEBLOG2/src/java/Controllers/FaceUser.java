package Controllers;

import Models.UserDAO;
import Pojos.User;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "faceUser")
@SessionScoped
public class FaceUser {
 
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

    public void login() {

        try {
            this.loginOn = userdao.Login(this.user);
            
            if(this.loginOn.getId() > 0 ){
           
                System.out.println(this.loginOn);
                
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al tratar de loguiarse " + ex.getMessage());
        } finally {

            //lo que queremos que haga despues que se loguee
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
