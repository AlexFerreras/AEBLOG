
package Controllers;

import Models.UserDAO;
import Pojos.User;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "faceUser")
public class FaceUser {
    
     User user = new User();
    User loginOn = new User();
    User newuser = new User();
    UserDAO userdao = new UserDAO();
    
    
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
    public void newUser(){
        try {
            userdao.newUser(this.newuser);
        } catch (SQLException ex) {
            System.out.println( "Error al tratar de crear nuevo usuario"+ex.getMessage());
        }finally{
        //lo que quiero que haga despues que se registre
        }
    }
    
    public void login(){
    
        try {
             this.loginOn = userdao.Login(this.user);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al tratar de loguiarse "+ ex.getMessage());
        }finally{

        //lo que queremos que haga despues que se loguee

        
        }
    
    }
}
