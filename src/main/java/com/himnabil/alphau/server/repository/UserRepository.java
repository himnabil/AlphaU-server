package com.himnabil.alphau.server.repository;

import com.himnabil.alphau.server.model.User;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.*;

/**
 * Created by himna on 2/12/2017.
 */
@Repository
public class UserRepository {

    private  MongoCollection<Document> collection;

    public UserRepository (MongoDatabase database ){
         this.collection = database.getCollection("user");
    }

    public User save (User user){
        Document userDocument = new Document()
                .append("user_name", user.getUserName())
                .append("password_hash", user.getHashedPassword())
                .append("app_name", user.getAppName())
                ;
        collection.insertOne(userDocument);
        user.setId( userDocument.getObjectId("_id").toHexString());
        return user ;
    }

    public User find ( String appName , String userName ){
        Document userDocument = collection.find(and(eq("app_name",appName), eq("user_name", userName))).first();
        if (userDocument == null){
            return null;
        }
        User user = new User();

        user.setId(userDocument.getObjectId("_id").toHexString());
        user.setUserName(userDocument.getString("user_name"));
        user.setHashedPassword(userDocument.getString("password_hash"));
        user.setAppName(userDocument.getString("app_name"));

        return user;
    }
}

