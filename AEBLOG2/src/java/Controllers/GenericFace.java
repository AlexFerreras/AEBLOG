package Controllers;

import Models.UserDAO;
import Pojos.User;
import java.io.Serializable;
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

    @ManagedProperty(value="#{faceComments}")
    private FaceComments facecomments;
    
    @ManagedProperty(value="#{faceSubComments}")
    private FaceSubComments facesubcomments;
    
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

    public FacePost getFacepost() {
        return facepost;
    }

    public void setFacepost(FacePost facepost) {
        this.facepost = facepost;
    }

    public FaceComments getFacecomments() {
        return facecomments;
    }

    public void setFacecomments(FaceComments facecomments) {
        this.facecomments = facecomments;
    }

    public FaceSubComments getFacesubcomments() {
        return facesubcomments;
    }

    public void setFacesubcomments(FaceSubComments facesubcomments) {
        this.facesubcomments = facesubcomments;
    }
    
    
    
    
    
}
