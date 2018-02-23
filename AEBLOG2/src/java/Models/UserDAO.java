
package Models;

import Conection.DBconnection;
import Pojos.User;
import java.sql.SQLException;

public class UserDAO extends DBconnection{
    
    public void newUser(User user) throws SQLException 
    {
        try{
    Conectar();
    sql="insert into user (name, nickname,lastname, email, password)"+"values (?, ?, ?, ?, ?)";
    estado= con.prepareStatement(sql);
    estado.setString(1, user.getName());
    estado.setString(2, user.getNickname());
    estado.setString(3, user.getLastname());
    estado.setString(4, user.getEmail());
    estado.setString(5, user.getPassword());
    estado.execute();
    
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }finally{    
            Desconectar();
        }
    }
    
        public User Login(User user) throws  ClassNotFoundException, SQLException{
        User usuario= new User(0);
        Conectar();
        sql="select * from user where email=? and password=? limit 1";
        estado= con.prepareStatement(sql);
        estado.setString(1, user.getEmail());
        estado.setString(2, user.getPassword());
        rs= estado.executeQuery();
        try {
            while(rs.next())
            {
                usuario.setId(rs.getInt("id"));
                usuario.setName(rs.getString("name"));
                usuario.setLastname(rs.getString("lastname"));
                usuario.setNickname(rs.getString("nickname"));
                usuario.setEmail(rs.getString("email"));
            }
            Desconectar();
            return usuario;
        } catch (SQLException ex) {
            System.out.println("error usuario login:" + ex.getMessage());
             return null;
        }
    
    }
    
    
}
