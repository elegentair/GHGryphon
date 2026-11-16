package app;

import io.ebean.Database;
import io.javalin.http.Context;

public class HttpHandler<T extends HttpInterface> {
    public Database database;
    public Class<T> tClass;

    public HttpHandler(Database database, Class<T> tClass) {
        this.database = database;
        this.tClass = tClass;
    }
    
    public void getDB(Context ctx) {
        // finds instances of T (T is the file in models) and puts them into a list)
        var results = database.find(tClass).findList();
        // export list to json
        ctx.json(results);
    }
    // debugT is included as an argument in some of these constructors to output a specific
    // 404 message if a resource is not found (removing it if it is unnecessary wont cause problems)
    public void getByID(Context ctx, String debugT) {
        // get and validate the id in the url
        long id = ctx.pathParamAsClass("id", Long.class).get();
        // search the database for the result by its id
        var result = database.find(tClass, id);
        // check that the result exists
        if (result == null) {
            ctx.status(404).result(debugT + " not found"); // HTTP 404 Not Found
            return;
        }
        // export singular result to json (same deal as before)
        ctx.json(result);
    }
    public void post(Context ctx) {
        T newDatum = ctx.bodyAsClass(tClass);
        database.save(newDatum);
        ctx.status(201).json(newDatum); // HTTP 201 Created
    }
    public void put(Context ctx, String debugT) {
        // same validation process of the id in the URL as in getByID
        long id = ctx.pathParamAsClass("id", Long.class).get();
        // the result of database.find() is no longer stored separately
        // since the get result is not needed anymore
        if (database.find(tClass, id) == null) {
            ctx.status(404).result(debugT + " not found"); // HTTP 404 Not Found
            return;
        }
        // fully replace the data at the provided id
        T updatedData = ctx.bodyAsClass(tClass);
        updatedData.setId(id);
        database.update(updatedData);
        ctx.status(200).json(updatedData); // HTTP 200 OK
    }
    public void delete(Context ctx, String debugT) {
        // check if the user exists again
        long id = ctx.pathParamAsClass("id", Long.class).get();
        // existingUser is stored as a variable (like in getByID) since it is reused later
        T existingUser = database.find(tClass, id);
        if (existingUser == null) {
            ctx.status(404).result(debugT + " not found");
            return;
        }
        database.delete(existingUser);
        ctx.status(204); // HTTP 204 No Content
    }
}
