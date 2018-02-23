
package Models;

import Conection.DBconnection;
import Pojos.SubComment;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexf
 */
public class SubCommentDAO extends DBconnection{
    public void saveSubComment(SubComment s) throws SQLException {
        try {
            Conectar();
            sql = "insert into subComent(userid,commentid, content, fecha) values(?,?,?,?)";
            estado = con.prepareStatement(sql);

            estado.setInt(1, s.getUserId());
            estado.setInt(2,s.getComentId());
            estado.setString(3, s.getContent());
            estado.setString(4, fecha);
            estado.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            
            Desconectar();
        }
    }

    public List<SubComment> findSubComents() throws SQLException {
        ArrayList<SubComment> List = new ArrayList<>();
        try {
            Conectar();
            sql = "select * from subComment";
            estado = con.prepareStatement(sql);
            rs = estado.executeQuery();

            while (rs.next()) {

                SubComment subComment = new SubComment(rs.getInt("id"),rs.getInt("userid"), rs.getInt("postid"), rs.getString("content"), rs.getString("fecha"));
                List.add(subComment);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
           
        }
        return List;
    }

    public void deleteSubComment(int id) throws SQLException {
        sql="delete subComment where id = ?";
        
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
    
     public void updateSubComent(SubComment c) throws SQLException {
        try {
            Conectar();
            sql = "update subcomment set content=?, fecha=? ";
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
