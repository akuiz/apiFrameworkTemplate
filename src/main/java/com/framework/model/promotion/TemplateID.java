package com.framework.model.promotion;

import com.framework.model.Id;
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
