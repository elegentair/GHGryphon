import io.ebean.DB;
import java.util.List;
import app.models.UserEntity;
import app.models.ClubEntity;

public class Seeder {
    public static void seed() {
        ClubEntity mockTrial = new ClubEntity("Mock Trial", "https://tse4.mm.bing.net/th/id/OIP.382uE2QZuF2FzSy8GzdpyQHaI3?r=0&pid=Api", "A legal club", "2026-11-14T19:53:18.053Z", 12);
        ClubEntity eqc = new ClubEntity("Equality Club", "https://static.vecteezy.com/system/resources/previews/002/753/354/large_2x/new-pride-flag-lgbtq-background-redesign-including-black-brown-and-trans-pride-stripes-flat-illustration-vector.jpg", "The gayest of them all", "2026-11-15T19:53:18.053Z", 20);
        DB.saveAll(List.of(mockTrial, eqc));
        System.out.println("Seeded DB!");
    }
    
}
