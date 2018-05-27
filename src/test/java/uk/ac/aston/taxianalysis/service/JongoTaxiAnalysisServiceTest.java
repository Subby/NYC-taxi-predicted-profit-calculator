package uk.ac.aston.taxianalysis.service;

import org.jongo.Aggregate;
import org.junit.jupiter.api.Test;
import uk.ac.aston.taxianalysis.model.Profit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JongoTaxiAnalysisServiceTest {

    private Fixture fixture = new Fixture();

    @Test
    public void calculateProfitForDistance() {
        fixture.givenJongoTaxiAnalysisServiceIsSetup();
        final Aggregate.ResultsIterator<Profit> result = fixture.whenCalculateProfitForDistanceIsCalled(3);
        fixture.thenCorrectCorrectProfitIsReturned(result);
    }

    private class Fixture {

        private JongoTaxiAnalysisService jongoTaxiAnalysisService;

        private void givenJongoTaxiAnalysisServiceIsSetup() {
            jongoTaxiAnalysisService = new JongoTaxiAnalysisService();
        }

        private Aggregate.ResultsIterator<Profit> whenCalculateProfitForDistanceIsCalled(double distanceToCalculateFor) {
            return jongoTaxiAnalysisService.calculateProfitForDistance(distanceToCalculateFor);
        }

        public void thenCorrectCorrectProfitIsReturned(Aggregate.ResultsIterator<Profit> result) {
            Profit profit = result.next();
            assertEquals(profit.getProfit(), 16.83134017314288);
        }
    }
}
