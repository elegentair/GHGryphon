package app;

import io.ebean.Database;
import io.ebean.datasource.DataSourceBuilder;
import io.javalin.Javalin;

import app.models.UserEntity;
import app.models.ClubEntity;

public class App extends Javalin {

    public void initializeApp() {
    //public static void main(String[] args) {
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

        HttpHandler<UserEntity> userHandler = new HttpHandler<>(database, UserEntity.class);
        HttpHandler<ClubEntity> clubHandler = new HttpHandler<>(database, ClubEntity.class);

        // return the Javalin app
        // if you are only running App.java, you can use `var app = ` instead of `return`
        // and restore the main function at the top rather than using the default constructor
        /*var app = */ return Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
            
            //  -------------------------get methods-------------------------
            config.routes.get("/api/users", ctx -> userHandler.get(ctx));
            config.routes.get("/api/clubs", ctx -> clubHandler.get(ctx));
            // -------------------------post methods-------------------------
            config.routes.post("/api/users", ctx -> userHandler.post(ctx));
            config.routes.post("/api/clubs", ctx -> clubHandler.post(ctx));
            // -------------------------put methods-------------------------
            config.routes.put("/api/users/{id}", ctx -> userHandler.put(ctx, "User"));
            config.routes.put("/api/clubs/{id}", ctx -> clubHandler.put(ctx, "Club"));
            
            // might add patch method as needed (may require lower-level implementation)
            
            // -------------------------delete methods-------------------------
            config.routes.delete("/api/users/{id}", ctx -> userHandler.delete(ctx, "User"));
            config.routes.delete("/api/clubs/{id}", ctx -> clubHandler.delete(ctx, "Club"));
        }).start(7070);
    }
}
