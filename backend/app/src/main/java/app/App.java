package app;

import io.javalin.Javalin;
import java.util.ArrayList;

public class App {

    public record User (
        Integer id,
        String name,
        String email,
        Integer grade
    ) {}

    public record Club (
        Integer id,
        String name,
        Integer memberCount
    ) {}

    public static void main(String[] args) {
        // users dummy list
        var users = new ArrayList<User>();
        // Make dummy users:
        users.add(new User(1, "Samuel Locke", "s979920@student.knoxschools.org", 12));
        users.add(new User(2, "Hayden Hellsten", "s947970@student.knoxschools.org", 12));

        // clubs dummy list
        var clubs = new ArrayList<Club>();
        // Add dummmy clubs
        clubs.add(new Club(1, "CSHS", 23));
        clubs.add(new Club(2, "Equality Club", 19));

        var app = Javalin.create(config -> {
            config.routes.get("/", ctx -> ctx.result("Hello World"));
            config.routes.get("/api/users", ctx -> ctx.json(users));
            config.routes.get("/api/clubs", ctx -> ctx.json(clubs));
        }).start(7070);
    }
}
