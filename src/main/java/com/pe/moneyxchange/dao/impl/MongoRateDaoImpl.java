package com.pe.moneyxchange.dao.impl;

import static com.pe.moneyxchange.util.Constants.MONGO_DATABASE;
import static com.pe.moneyxchange.util.Constants.MONGO_EXCHANGE_COLLECTION;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.pe.moneyxchange.dao.RateDao;

import com.pe.moneyxchange.factory.mongo.MongoConnection;
import com.pe.moneyxchange.factory.mongo.MongoDaoFactory;
import com.pe.moneyxchange.model.RateResponse;
import com.pe.moneyxchange.util.exception.DataNotFoundException;
import org.bson.Document;

import java.util.Optional;

public class MongoRateDaoImpl implements RateDao<RateResponse> {

    @Override
    public RateResponse getRate(String typeRate,double amount) throws Exception {

        MongoConnection mongoConnection = MongoDaoFactory.createConnection();
        MongoDatabase database = mongoConnection.getMongo().getDatabase(MONGO_DATABASE);
        MongoCollection<Document> mongoCollection = database.getCollection(MONGO_EXCHANGE_COLLECTION);

        Document document = mongoCollection.find(Filters.eq("rateType",typeRate)).first();

        return Optional.ofNullable(document).map(
                doc -> Optional.ofNullable(doc.getDouble("rateValue"))
                        .map(r -> RateResponse.builder()
                                .setRates(r)
                                .setChangedAmount(r*amount)
                                .build())).get()
                .orElseThrow(() -> new DataNotFoundException("No se encontró resultados."));



    }
}
