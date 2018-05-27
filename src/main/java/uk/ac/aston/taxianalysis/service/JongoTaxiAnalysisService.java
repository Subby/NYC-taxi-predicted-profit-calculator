package uk.ac.aston.taxianalysis.service;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Aggregate;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import uk.ac.aston.taxianalysis.model.Profit;

public class JongoTaxiAnalysisService implements AbstractMongoTaxiAnalysisService {

    private String DB_NAME = "taxiAnalysis";
    private String AGGREGATED_DATA_COLLECTION = "aggregated_data";


    private MongoCollection aggregatedDataCollection;


    public JongoTaxiAnalysisService() {
        Jongo jongo = setupMongoConnection();
        aggregatedDataCollection = jongo.getCollection(AGGREGATED_DATA_COLLECTION);
    }

    private Jongo setupMongoConnection() {
        DB db = new MongoClient().getDB(DB_NAME);
        return new Jongo(db);
    }


    public Aggregate.ResultsIterator<Profit> calculateProfitForDistance(double distance) {
        final Aggregate.ResultsIterator<Profit> result = aggregatedDataCollection.aggregate("{$group:{_id:null, 'averageFareSum': {'$sum': '$averageFarePerMile'}, 'fuelCostSum': {'$sum': '$fuelCostPerMile'}}}")
                .and("{$project:{predictedProfit:{'$multiply':" +
                        "[{'$subtract': ['$averageFareSum', '$fuelCostSum']}, #]}}}", distance)
                .as(Profit.class);
        return result;
    }
}
