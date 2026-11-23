package app.models;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import app.HttpInterface;

@Entity // tells ebean that this is a sql table
@Table(name = "users") // names the table "users"

// class is connected to ebeans model class
public class UserEntity extends Model implements HttpInterface { // required class, file name
    public String createdAt;
    public String name; // name of user
    public String avatar; // profile picture URL
    public String password; // user password (PLAIN TEXT FOR TESTING ONLY)
    public String email; // email
    public Integer grade; // user grade
    
    @Id // setting primary key to id (unique identifier for each club)
    public Long id; // defines id as a 64 bit int, ebean will auto generate for each club

    public UserEntity() {} // empty construtor for this file needed by ebean

    // constructor we use to make users in java code
    public UserEntity(String createdAt, String name, String avatar, String password, String email) {
        this.createdAt = createdAt;
        this.name = name;
        this.avatar = avatar;
        this.password = password;
        this.email = email;
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
