package Controllers;

import Models.CommentsDAO;
import Pojos.Comment;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "faceComments")
public class FaceComments implements Serializable{
    Comment comment;
    CommentsDAO commentdao;

    List<Comment> allcomments = new ArrayList<>();

    public FaceComments() {
   
        try {
            allcomments= commentdao.findComents();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public List<Comment> getAllcomments() {
        return allcomments;
    }

    public void setAllcomments(List<Comment> allcomments) {
        this.allcomments = allcomments;
    }
    
    
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CommentsDAO getCommentdao() {
        return commentdao;
    }

    public void setCommentdao(CommentsDAO commentdao) {
        this.commentdao = commentdao;
    }
    
     public void saveComment() {

        try {
            commentdao.saveComment(this.comment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.comment = new Comment();
        }

    }
     
     
      public void deleteComment(){
    try {commentdao.deleteComment(this.comment.getId());
    }catch(SQLException e){
     System.out.println(e.getMessage());
            e.printStackTrace();
    }finally{
        System.err.println("se elimino el post");
    }
    }
     
     public void updateComment() {

        try {
            commentdao.updateComent(this.comment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.comment = new Comment();
        }

    }
}
