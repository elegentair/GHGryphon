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
        }).start(7070);
    }
}
