package com.beatrizacbs.hack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "levels")
public class Level {

    @Id
    private String id;

    @NotNull
    private Integer xpRequired;

    @NotNull
    private String levelDescription;

    @NotNull
    @Indexed(unique = true)
    private Integer levelNumber;

}
