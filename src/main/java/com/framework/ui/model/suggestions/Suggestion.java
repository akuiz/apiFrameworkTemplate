package com.framework.ui.model.suggestions;

import com.framework.ui.constants.Dates;
import com.framework.ui.model.campaign.CampaignSuggestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;

import java.util.Arrays;
import java.util.List;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Suggestion implements Dates{
    private DateTime startDate;
    private DateTime endDate;
    private List<CampaignSuggestion> campaigns;

    public static Suggestion firstSeptemberWeekSuggestion(){
        return new Suggestion().toBuilder()
                .startDate(firstSeptember)
                .endDate(middleSeptember)
                .campaigns(Arrays.asList(CampaignSuggestion.testCampaignSuggestion()))
                .build();
    }

    public static Suggestion noCampaignsSuggestion() {
        return new Suggestion().toBuilder()
                .startDate(firstDecember)
                .endDate(endDecember)
                .campaigns(Arrays.asList(CampaignSuggestion.testCampaignSuggestion()))
                .build();
    }
}
