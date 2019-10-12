package com.beatrizacbs.hack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tasks")
public class Task {

    @Id
    private String id;

    @NotNull
    private String title;
    private String description;

    @NotNull
    private String award;

    @NotNull
    private String parentId;

    @NotNull
    private int xpValue;
}
