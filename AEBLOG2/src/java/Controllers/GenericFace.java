package Controllers;

import Models.UserDAO;
import Pojos.User;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "genericface")
public class GenericFace {
    User user;
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
    
    
    
    
    
}
