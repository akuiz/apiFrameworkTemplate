package com.framework.model.campaign;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = { "id" })
public class Campaign {
    private String name;
    private Boolean test = true;
    private Boolean production = false;
    private String start;
    private String end;
    private String id;
}
