package Controllers;

import Models.UserDAO;
import Pojos.User;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "genFace")
@RequestScoped
public class GenericFace  implements Serializable{
    
    @ManagedProperty(value="#{facePost}")
    private FacePost facepost;

    User user;
    User loginOn;
    User newuser;
    UserDAO userdao;
    
    
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

    public FacePost getFacepost() {
        return facepost;
    }

    public void setFacepost(FacePost facepost) {
        this.facepost = facepost;
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
            System.out.print(loginOn);
        
        }
    
    }
    
    
    
    
}
