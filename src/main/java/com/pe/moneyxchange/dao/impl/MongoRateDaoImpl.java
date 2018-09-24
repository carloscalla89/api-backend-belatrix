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
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.Map;
import java.util.Optional;
@Slf4j
public class MongoRateDaoImpl implements RateDao<RateResponse> {

    @Override
    public RateResponse getRate(String base, String target, String amount) throws Exception {
        log.info("MongoRateDaoImpl");
        MongoConnection mongoConnection = MongoDaoFactory.createConnection();
        MongoDatabase database = mongoConnection.getMongo().getDatabase(MONGO_DATABASE);
        MongoCollection<Document> mongoCollection = database.getCollection(MONGO_EXCHANGE_COLLECTION);

        Document document = mongoCollection.find(Filters.and(Filters.eq("base", base),
                Filters.exists(String.format("rates.%s",target))))
                .first();

        return Optional.ofNullable(document).map(
                doc -> Optional.ofNullable(doc.get("rates",Map.class))
                        .map(r -> RateResponse.builder()
                                .setRates(Double.parseDouble((String)r.get(target)))
                                .setChangedAmount((Double.parseDouble((String)r.get(target)))*Double.parseDouble(amount.replace(",","")))
                                .build()).get()
        ).orElseThrow(() -> new DataNotFoundException("Not found results."));
    }
}
