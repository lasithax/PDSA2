package com.example.pdsa.service;

import com.example.pdsa.logic.EightQueensGame;
import com.example.pdsa.model.eightqueens.EightQueens;
import com.example.pdsa.model.eightqueens.EightQueensResponse;
import com.example.pdsa.model.eightqueens.EightQueensSolution;
import com.example.pdsa.repository.EightQueensRepository;
import com.example.pdsa.repository.EightQueensSolutionsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EightQueensService {
//    Logger logger = LoggerFactory.getLogger(EightQueensService.class);
    @Autowired
    private EightQueensRepository eightQueensRepo;

    @Autowired
    private EightQueensSolutionsRepository eightQueensSolutionsRepo;

    EightQueensGame eightQueensGame;
    int numberOfSolutionsIdentified;

    public void start() {
        eightQueensSolutionsRepo.deleteAll();
        eightQueensGame = new EightQueensGame();
        List<List<String>> solutions = eightQueensGame.getSolutions();

        solutions.forEach(solution -> {
            int index = solutions.indexOf(solution) + 1;
            addNewSolution(index, solution);
        });

        numberOfSolutionsIdentified = 0;
    }

    public Map<String, String> checkResponse(EightQueensResponse eightQueensResponse) {
        String username = eightQueensResponse.getName();
        int[] response = eightQueensResponse.getResponse();
        int result = eightQueensGame.validate(response);

        if (result == 0) {
            return Map.of("result", "LOST", "message", "Solution is not valid");
        } else {
            if (eightQueensSolutionsRepo.findById(result).get().isIdentified()) {
                return Map.of("result", "-", "message", "Solution already identified. Try again!");
            } else {
                eightQueensSolutionsRepo.updateById(result, true);
                numberOfSolutionsIdentified++;
                addNewResponse(username, response);

                if (numberOfSolutionsIdentified == 92) {
                    return Map.of(
                            "result", "WON",
                            "message", "New solution identified!",
                            "count", String.valueOf(numberOfSolutionsIdentified),
                            "info", "All solutions have been identified!"
                    );
                }

                return Map.of(
                        "result", "WON",
                        "message", "New solution identified!",
                        "count", String.valueOf(numberOfSolutionsIdentified),
                        "info", numberOfSolutionsIdentified + " solution(s) have been identified!"
                );
            }
        }
    }

    public void addNewSolution(int index, List<String> solution) {
        eightQueensSolutionsRepo.save(new EightQueensSolution(index, solution, false));
    }

    public void addNewResponse(String name, int[] response) {
        List<String> responseList = List.of(
                "A" + response[0],
                "B" + response[1],
                "C" + response[2],
                "D" + response[3],
                "E" + response[4],
                "F" + response[5],
                "G" + response[6],
                "H" + response[7]
        );

        eightQueensRepo.save(new EightQueens(new ObjectId(), name, responseList));
    }


}
