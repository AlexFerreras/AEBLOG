package Models;

import Conection.DBconnection;
import Pojos.Post;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO extends DBconnection {

    public void savePost(Post p) throws SQLException {
        try {
            Conectar();
            sql = "insert into post(userid, topic, content, fecha) values(?,?,?,?)";
            estado = con.prepareStatement(sql);

            estado.setInt(1, p.getUserId());
            estado.setString(2, p.getTopic());
            estado.setString(3, p.getContent());
            estado.setString(4, fecha);
            estado.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            
            Desconectar();
        }
    }

    public List<Post> findPosts() throws SQLException {
        ArrayList<Post> List = new ArrayList<>();
        try {
            Conectar();
            sql = "select * from post";
            estado = con.prepareStatement(sql);
            rs = estado.executeQuery();

            while (rs.next()) {

                Post p = new Post(rs.getInt("id"), rs.getInt("userid"), rs.getString("topic"), rs.getString("content"), rs.getString("fecha"));
                List.add(p);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
           
        }
        return List;
    }

    public void deletePost(int id) throws SQLException {
        sql="delete post where id = ?";
        
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
    
     public void updatePost(Post p) throws SQLException {
        try {
            Conectar();
            sql = "update post set topic=?, content=?, fecha=? ";
            estado = con.prepareStatement(sql);

            estado.setString(1, p.getTopic());
            estado.setString(2, p.getContent());
            estado.setString(3, fecha);
            estado.execute();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
        }
    }
    
    public List<Post> findUserPosts(int UserId) throws SQLException {
        ArrayList<Post> List = new ArrayList<>();
        try {
            Conectar();
            sql = "select * from post where user_id=?";
            estado = con.prepareStatement(sql);
            estado.setInt(1, UserId);
            rs = estado.executeQuery();

            while (rs.next()) {

                Post p = new Post(rs.getInt("id"), rs.getInt("userid"), rs.getString("topic"), rs.getString("content"), rs.getString("fecha"));
                List.add(p);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            Desconectar();
           
        }
        return List;
    } 
    
    
}
