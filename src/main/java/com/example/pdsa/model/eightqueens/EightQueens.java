package com.example.pdsa.model.eightqueens;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "eight_queens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EightQueens {

    @Id
    private ObjectId _id;
    private String name;
    private List<String> response;

}
