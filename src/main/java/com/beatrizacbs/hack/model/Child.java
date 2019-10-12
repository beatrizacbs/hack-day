package com.beatrizacbs.hack.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "children")
public class Child extends User{

    private String type = "CHILD";
    private List<String> dreamIds;
    private String parentId;
    private String birth;
    private Integer experience = 0;
    private List<String> tasksConcluded;
    private List<String> todoTasks;

    public void addExperience(Integer experience){
        this.experience += experience;
    }


}
