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

    @Id // setting primary key to id (unique identifier for each club)
    public Long id; // defines id as a 64 bit int, ebean will auto generate for each club
    public String name; // name of user
    public String email; // user email
    public Integer grade; // user grade

    public UserEntity() {} // empty construtor for this file needed by ebean

    // constructor we use to make users in java code
    public UserEntity(String name, String email, Integer grade) {
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public void setId(Long id) {
        this.id = id;
    }
}