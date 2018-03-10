package Controllers;

import Pojos.Comment;
import Pojos.Post;
import java.io.Serializable;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author alexf
 */
@ManagedBean(name = "genFace")
@RequestScoped
public class GenericFace implements Serializable {

    @ManagedProperty(value = "#{faceUser}")
    private FaceUser faceuser ; 

    @ManagedProperty(value = "#{facePost}")
    private FacePost facepost;

    @ManagedProperty(value = "#{faceComments}")
    private FaceComments facecomments;

    @ManagedProperty(value = "#{faceSubComments}")
    private FaceSubComments facesubcomments;    
    
    public FaceUser getFaceuser() {
        return faceuser;
    }

    public void setFaceuser(FaceUser faceuser) {
        this.faceuser = faceuser;
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

    public FacePost getFacepost() {
        return facepost;
    }

    public void setFacepost(FacePost facepost) {
        this.facepost = facepost;
    }
    
    @PostConstruct
    public void CargarTodo() {
        try {
            //cargar todo los Posts
            facepost.allpost = facepost.postdao.findPosts();

            //cargando todos los comentario       
            facecomments.allcomments
                    = facecomments.commentdao
                            .findComents(facepost.post.getId());

            //encntrando todos los subs comentarios que estan dentro de los comentarios
            facesubcomments.allsubcomments
                    = facesubcomments.subcommentdao
                            .findSubComents(facecomments.comment.getId());

        } catch (SQLException ex) {
            System.out.println("Error al cargar una de las listas en el GenericoBeans"+ex.getMessage());
        }finally{
            System.out.println("Todas las listas Cargadas");
        }

    }

        public void savePost() {

        try {
            
             //neseito el id del user que la guardo...
            facepost.post.setUser_Id(faceuser.loginOn.getId());
            
            facepost.postdao.savePost(this.facepost.post);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.facepost.post = new Post();
        }

    }
        
        
          public void saveComment(int postId) {

        try {
            facecomments.comment.setUserId(faceuser.loginOn.getId());
            facecomments.comment.setPostId(postId);
            
            System.out.println("Este es e contemifo"+facecomments.comment.getContent());
            
            facecomments.commentdao.saveComment(facecomments.comment);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            facecomments.comment = new Comment();
        }

    }
        
        
}
