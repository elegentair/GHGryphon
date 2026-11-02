package app.models;

import io.ebean.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // tells ebean that this is a sql table
@Table(name = "clubs") // names the table "clubs"

// class is connected to ebeans model class
public class ClubEntity extends Model { // required class, file name

    @Id // setting primary key to id (unique identifier for each club)
    public Long id; // defines id as a 64 bit int, ebean will auto generate for each club
    public String name; // club name
    public Integer memberCount; // member count

    public ClubEntity() {} // empty construtor for this file needed by ebean

    // constructor we use to make clubs in java code
    public ClubEntity(String name, Integer memberCount) {
        this.name = name;
        this.memberCount = memberCount;
    }
}