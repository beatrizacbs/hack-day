package com.beatrizacbs.hack.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@Document(collection = "dreams")
public class Dream {

    @Id
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private BigDecimal totalValue;

    @Builder.Default
    private BigDecimal currentValue = new BigDecimal("0");
}
