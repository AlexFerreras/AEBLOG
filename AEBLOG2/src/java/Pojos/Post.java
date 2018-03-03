package Pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
     private int id;
     private int user_Id;
     private String topic;
     private String content; 
     private String creation_date; 
     Date date= new Date();
     DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    
     

    public Post() {
        this.creation_date= dateFormat.format(date);
    }

    public Post(int id, int userId, String topic, String content) {
        this.id = id;
        this.user_Id = userId;
        this.topic = topic;
        this.content = content;
        this.creation_date = dateFormat.format(date);
    }

    public Post(int id, int userId, String topic, String content, String creation_date) {
        this.id = id;
        this.user_Id = userId;
        this.topic = topic;
        this.content = content;
        this.creation_date = creation_date;
    }

    

    public int getId() {
        return id;
    }

    public String getFecha() {
        return creation_date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return user_Id;
    }

    public void setUserId(int userId) {
        this.user_Id = userId;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
 
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    } 
}
 