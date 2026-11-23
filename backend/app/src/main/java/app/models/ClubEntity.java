package app.models;

import io.ebean.Model;
import io.ebean.annotation.DbArray;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import app.HttpInterface;

import java.util.List;
import java.util.ArrayList;

@Entity // tells ebean that this is a sql table
@Table(name = "clubs") // names the table "clubs"

// class is connected to ebeans model class
public class ClubEntity extends Model implements HttpInterface { // required class, file name
    public String createdAt;
    public String name;
    public String description;
    @DbArray
    public List<String> users;
    public String thumbnail;
    @Id // setting primary key to id (unique identifier for each club)
    public Long id; // defines id as a 64 bit int, ebean will auto generate for each club

    public ClubEntity() {} // empty construtor for this file needed by ebean

    // constructor we use to make clubs in java code
    public ClubEntity(String createdAt, String name, String description, List<String> users, String thumbnail) {
        this.createdAt = createdAt;
        this.name = name;
        this.description = description;
        this.users = users;
        this.thumbnail = thumbnail;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
