package app;

import io.ebean.Database;
import io.ebean.datasource.DataSourceBuilder;
import io.javalin.Javalin;
import io.javalin.http.Context;

import app.HttpInterface;
import app.models.UserEntity;
import app.models.ClubEntity;

public class HttpHandler<T extends HttpInterface> {
    public Database database;
    public Class<T> tClass;

    public HttpHandler(Database database, Class<T> tClass) {
        this.database = database;
        this.tClass = tClass;
    }
    
    public void get(Context ctx) {
        // finds instances of T (T is the file in models) and puts them into a list)
        var results = database.find(tClass).findList();
        // export list to json
        ctx.json(results);
    }
    public void post(Context ctx) {
        T newDatum = ctx.bodyAsClass(tClass);
        database.save(newDatum);
        ctx.status(201).json(newDatum); // HTTP 201 Created
    }
    public void put(Context ctx, String debugT) {
        // get and validate the id in the url
        long id = ctx.pathParamAsClass("id", Long.class).get();
        // check that the item actually exists
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
        // existingUser is stored as a variable now since it is reused later
        T existingUser = database.find(tClass, id);
        if (existingUser == null) {
            ctx.status(404).result(debugT + " not found");
            return;
        }
        database.delete(existingUser);
        ctx.status(204); // HTTP 204 No Content
    }
}