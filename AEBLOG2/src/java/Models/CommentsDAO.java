
package Models;

import Conection.DBconnection;
import Pojos.Comment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alexf
 */
public class CommentsDAO extends DBconnection{
     public void saveComment(Comment c) throws SQLException {
        try {
            Conectar();
            sql = "insert into comment(userid,postid, content, fecha) values(?,?,?,?)";
            estado = con.prepareStatement(sql);

            estado.setInt(1, c.getUserId());
            estado.setInt(2,c.getPostId());
            estado.setString(3, c.getContent());
            estado.setString(4, fecha);
            estado.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            
            Desconectar();
        }
    }

    public List<Comment> findComents(int post_id) throws SQLException {
        ArrayList<Comment> List = new ArrayList<>();
        try {
            Conectar();
            sql = "select * from comments where article_id=? ";
            estado = con.prepareStatement(sql);
            estado.setInt(1, post_id);
            rs = estado.executeQuery();

            while (rs.next()) {

                Comment Comment = new Comment(rs.getInt("id"), rs.getInt("postid"),rs.getInt("userid"), rs.getString("content"), rs.getString("fecha"));
                List.add(Comment);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
           
        }
        return List;
    }

    public void deleteComment(int id) throws SQLException {
        sql="delete comment where id = ?";
        
        try{
            Conectar();
        estado= con.prepareStatement(sql);
        estado.setInt(1, id);
        estado.execute();
        
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }finally {
            Desconectar();
        }
        }
    
     public void updateComent(Comment c) throws SQLException {
        try {
            Conectar();
            sql = "update comment set content=?, fecha=? ";
            estado = con.prepareStatement(sql);

            estado.setString(2, c.getContent());
            estado.setString(3, fecha);
            estado.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
        }
    }
    
    
}
