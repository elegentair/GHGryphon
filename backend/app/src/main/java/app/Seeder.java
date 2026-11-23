package app;
import io.ebean.DB;
import java.util.List;
import app.models.UserEntity;
import app.models.ClubEntity;

public class Seeder {
    public static void seed() {
        ClubEntity mockTrial = new ClubEntity("2026-11-14T19:53:18.053Z", "Mock Trial", "A legal club", List.of("1", "2"), "https://tse4.mm.bing.net/th/id/OIP.382uE2QZuF2FzSy8GzdpyQHaI3?r=0&pid=Api");
        ClubEntity eqc = new ClubEntity("2026-11-15T19:53:18.053Z", "Equality Club", "The gayest of them all", List.of("1", "2"), "https://static.vecteezy.com/system/resources/previews/002/753/354/large_2x/new-pride-flag-lgbtq-background-redesign-including-black-brown-and-trans-pride-stripes-flat-illustration-vector.jpg");
        UserEntity salsa = new UserEntity("2026-11-14T19:53:18.053Z", "Salsa Guac", "https://tse1.mm.bing.net/th/id/OIP.9iQefg3XEkHXvYb8fwE8mQHaLH?r=0&pid=Api", "1234", "salsaguac@example.com");
        UserEntity hou = new UserEntity("2026-11-15T19:53:18.03Z", "Hayden Houdini", "https://tse4.mm.bing.net/th/id/OIP.ZqvnIbhlbYkuBcGTzS42JAHaHa?r=0&pid=Api", "4321", "HaydenHou@example.com");
        DB.saveAll(List.of(salsa, hou));
        DB.saveAll(List.of(mockTrial, eqc));
        System.out.println("Seeded DB!");
    }
    
}
