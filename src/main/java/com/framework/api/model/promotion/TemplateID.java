package com.framework.api.model.promotion;

import com.framework.api.model.other.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class TemplateID {
    private String templateID;

    public TemplateID(Id id){
        this.templateID = id.getId();
    }
}
