package com.legalmatch.exam.repository.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SearchCriteria {

    private String key;
    private Object value;
    private SearchOperation operation;
}
