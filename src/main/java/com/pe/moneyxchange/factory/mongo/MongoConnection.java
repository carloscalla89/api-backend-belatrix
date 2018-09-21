package com.pe.moneyxchange.factory.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import lombok.extern.slf4j.Slf4j;
import static com.pe.moneyxchange.util.Constants.MONGO_URI;

@Slf4j
public class MongoConnection {

  private static MongoConnection instance = new MongoConnection();

  private MongoClient mongo = null;

  private MongoConnection() {}

  public MongoClient getMongo() throws MongoException{
    if (mongo == null) {

      MongoClientOptions.Builder options = MongoClientOptions.builder()
        .connectionsPerHost(20)
        .maxConnectionIdleTime((60 * 1_000))
        .maxConnectionLifeTime((120 * 1_000));

      MongoClientURI uri = new MongoClientURI(MONGO_URI, options);

      try {
        mongo = new MongoClient(uri);
      } catch (MongoException me) {
        log.error("An error occoured", me);
        throw  me;
      }
    }
    return mongo;
  }


  protected static MongoConnection getInstance() {
    return instance;
  }
}
