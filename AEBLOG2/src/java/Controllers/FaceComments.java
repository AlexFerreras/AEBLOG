
package Controllers;

import Models.CommentsDAO;
import Pojos.Comment;
import Pojos.Post;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexf
 */
public class FaceComments {
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
    
    
}
