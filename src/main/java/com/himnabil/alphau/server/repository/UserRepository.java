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
@Repository public class UserRepository {
    private static final String COLLECTION_NAME = "user";
    private static final String USER_NAME = "user_name";
    private static final String APP_NAME = "app_name";
    private static final String PWD_HASH = "password_hash";
    private static final String ID = "_id";

    private  MongoCollection<Document> collection;

    public UserRepository (MongoDatabase database ){
         this.collection = database.getCollection(COLLECTION_NAME);
    }

    public User save (User user){
        Document userDocument = new Document()
                .append(USER_NAME, user.getUserName())
                .append(PWD_HASH, user.getHashedPassword())
                .append(APP_NAME, user.getAppName())
                ;
        collection.insertOne(userDocument);
        user.setId( userDocument.getObjectId(ID).toHexString());
        return user ;
    }

    public User find ( String appName , String userName ){
        Document userDocument = collection.find(and(eq(APP_NAME,appName), eq(USER_NAME, userName))).first();
        if (userDocument == null){
            return null;
        }
        User user = new User();

        user.setId(userDocument.getObjectId(ID).toHexString());
        user.setUserName(userDocument.getString(USER_NAME));
        user.setHashedPassword(userDocument.getString(PWD_HASH));
        user.setAppName(userDocument.getString(APP_NAME));

        return user;
    }
}

