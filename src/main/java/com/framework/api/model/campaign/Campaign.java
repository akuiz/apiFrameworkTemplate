package com.framework.api.model.campaign;

import com.framework.api.model.other.Id;
import com.framework.api.model.promotion.TemplateID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static com.framework.api.utils.CodeUtils.convertList;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    private String name;
    private Boolean test = true;
    private Boolean production = false;
    private Boolean deleted;
    private String start;
    private String end;
    private String id;
    private List<TemplateID> discounts;

    public static Campaign campaignWithPromotionIDS(String name, List<TemplateID> templateIDs){
        return new Campaign().toBuilder()
                .name(name)
                .start("2018-09-01")
                .end("2018-09-30")
                .discounts(templateIDs)
                .build();
    }

    public static Campaign campaignWithPromotionIDS(String name, String startDate, String endDate, List<TemplateID> templateIDs){
        return new Campaign().toBuilder()
                .name(name)
                .start(startDate)
                .end(endDate)
                .discounts(templateIDs)
                .build();
    }

    public EditedCampaign prepareCampaignToEditRequest(CreateCampaignResponse response){
        return new EditedCampaign().toBuilder()
                .name(name)
                .id(response.getId().getId())
                .discounts(convertList(response.getDiscountIDs(), discountID -> new Id(discountID)))
                .start(start)
                .end(end)
                .build();
    }

}
