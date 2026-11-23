package app;

import io.ebean.Database;
import io.ebean.datasource.DataSourceBuilder;
import io.javalin.Javalin;

import app.models.UserEntity;
import app.models.ClubEntity;

public class LocalAppTest {
    // this line is not necessary if you are using this file to store a main function to run the app
    private Javalin appInstance;
    
    // this is a constructor instead of a main function for the purposes of JUnit Jupiter testing
    public void initializeApp() {
    //public static void main(String[] args) {
        // database config:
        Seeder.seed();

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

        // you do not need to store this as a variable if you are using this file to store a main function for the app
        // unless you need to store a reference to the Javalin instance to stop it later (currently not implemented)
        appInstance = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
            
            //  -------------------------get methods (entire db)-------------------------
            config.routes.get("/api/users", ctx -> userHandler.getDB(ctx));
            config.routes.get("/api/clubs", ctx -> clubHandler.getDB(ctx));
            //  -------------------------get methods (one entry)-------------------------
            config.routes.get("/api/users/{id}", ctx -> userHandler.getByID(ctx, "User"));
            config.routes.get("/api/clubs/{id}", ctx -> clubHandler.getByID(ctx, "Club"));
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
        });
    }

    // these functions are not necessary if you are using this file to store a main function
    public void startApp(int port) {
        appInstance.start(port);
    }

    public void stopApp() {
        appInstance.stop();
    }
}
