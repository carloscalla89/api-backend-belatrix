package com.pe.moneyxchange.dao.impl;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.pe.moneyxchange.dao.LoginDao;
import com.pe.moneyxchange.factory.mongo.MongoConnection;
import com.pe.moneyxchange.factory.mongo.MongoDaoFactory;
import com.pe.moneyxchange.util.exception.BadCredentialsException;
import org.bson.Document;
import java.util.Optional;

import static com.pe.moneyxchange.util.Constants.MONGO_DATABASE;
import static com.pe.moneyxchange.util.Constants.MONGO_USER_COLLECTION;

public class MongoLoginDao implements LoginDao {

  @Override
  public boolean login(String username, String password) throws Exception {

    MongoConnection connection = MongoDaoFactory.createConnection();

    MongoDatabase database = connection.getMongo().getDatabase(MONGO_DATABASE);
    MongoCollection<Document> mongoCollection = database.getCollection(MONGO_USER_COLLECTION);

    Document document = mongoCollection.find(Filters.and(Filters.eq("user",username),
                                  Filters.eq("password",password))).first();

    Optional.ofNullable(document).orElseThrow( () -> new BadCredentialsException(
                                String.format("User or Password incorrects",username)));

    return Boolean.TRUE;
  }
}
