package app;

import io.ebean.Database;
import io.ebean.datasource.DataSourceBuilder;
import io.javalin.Javalin;

import app.models.UserEntity;
import app.models.ClubEntity;

public class App {

    public static void main(String[] args) {
        // database config:
        var dataSource = DataSourceBuilder.create()
            .username("sa")
            .password("")
            // store data in file (data/clubs)
            .url("jdbc:h2:./data/clubs;");

        Database database = Database.builder()
            .name("db")
            .dataSourceBuilder(dataSource)
            .ddlGenerate(true) // generate table if not already existing
            .ddlRun(true) // run table generation
            .build();

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
            //  -------------------------get methods-------------------------
            config.routes.get("/api/users", ctx -> {
                // finds UserEntity types (UserEntity is the file in models/ and puts them into a list)
                var users = database.find(UserEntity.class).findList();
                // export list to json
                ctx.json(users);
            });
            config.routes.get("/api/clubs", ctx -> {
                // same for clubs
                var clubs = database.find(ClubEntity.class).findList();
                ctx.json(clubs);
            });
            // -------------------------post methods-------------------------
            config.routes.post("/api/users",  ctx -> {
                UserEntity user = ctx.bodyAsClass(UserEntity.class);
                database.save(user);
                ctx.status(201).json(user);
            });
            config.routes.post("/api/clubs", ctx -> {
                ClubEntity club = ctx.bodyAsClass(ClubEntity.class);
                database.save(club);
                ctx.status(201).json(club);
            });
            // -------------------------put methods-------------------------
            config.routes.put("/api/users/{id}", ctx -> {
                // get and validate the id in the url
                long id = ctx.pathParamAsClass("id", Long.class).get();
                // check that the user actually exists
                if (database.find(UserEntity.class, id) == null) {
                    ctx.status(404).result("User not found");
                    return;
                }
                // fully replace the data at the provided id
                UserEntity updatedData = ctx.bodyAsClass(UserEntity.class);
                updatedData.setId(id);
                database.update(updatedData);
                ctx.status(200).json(updatedData);
            });
            config.routes.put("/api/clubs/{id}", ctx -> {
                // same deal as above with the user update
                long id = ctx.pathParamAsClass("id", Long.class).get();
                if (database.find(ClubEntity.class, id) == null) {
                    ctx.status(404).result("Club not found");
                    return;
                }
                ClubEntity updatedData = ctx.bodyAsClass(ClubEntity.class);
                updatedData.setId(id);
                database.update(updatedData);
                ctx.status(200).json(updatedData);
            });
            // may add patch method as needed (may require lower-level)
            // -------------------------delete methods-------------------------
            config.routes.delete("/api/users/{id}", ctx -> {
                // check if the user exists again
                long id = ctx.pathParamAsClass("id", Long.class).get();
                // existingUser is stored as a variable now since it is reused later
                UserEntity existingUser = database.find(UserEntity.class, id);
                if (existingUser == null) {
                    ctx.status(404).result("User not found");
                    return;
                }
                database.delete(existingUser);
                ctx.status(204); // 204 No Content
            });
            config.routes.delete("/api/clubs/{id}", ctx -> {
                // again, same implementation as with users
                long id = ctx.pathParamAsClass("id", Long.class).get();
                ClubEntity existingClub = database.find(ClubEntity.class, id);
                if (existingClub == null) {
                    ctx.status(404).result("Club not found");
                    return;
                }
                database.delete(existingClub);
                ctx.status(204); // 204 No Content
            });
        }).start(7070);
    }
}
