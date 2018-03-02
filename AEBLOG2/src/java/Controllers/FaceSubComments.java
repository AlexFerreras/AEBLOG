package Controllers;

import Models.SubCommentDAO;
import Pojos.SubComment;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "faceSubComments")
public class FaceSubComments  implements Serializable{

    SubComment subcomment =new SubComment();
    SubCommentDAO subcommentdao= new SubCommentDAO();
    List<SubComment> allsubcomments = new ArrayList<>();

    public SubComment getSubcomment() {
        return subcomment;
    }

    public void setSubcomment(SubComment subcomment) {
        this.subcomment = subcomment;
    }

    public SubCommentDAO getSubcommentdao() {
        return subcommentdao;
    }

    public void setSubcommentdao(SubCommentDAO subcommentdao) {
        this.subcommentdao = subcommentdao;
    }

    public List<SubComment> getAllsubcomments() {
        return allsubcomments;
    }

    public void setAllsubcomments(List<SubComment> allsubcomments) {
        this.allsubcomments = allsubcomments;
    }

    public void saveSubComment() {

        try {
            subcommentdao.saveSubComment(this.subcomment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.subcomment = new SubComment();
        }

    }

    public void deleteSubComment() {

        try {
            subcommentdao.deleteSubComment(this.subcomment.getId());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            System.err.println("se elimino el post");
        }
    }

    public void updateSubComment() {

        try {
            subcommentdao.updateSubComent(this.subcomment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.subcomment = new SubComment();
        }

    }

}
