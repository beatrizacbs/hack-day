package com.beatrizacbs.hack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String name;

}
