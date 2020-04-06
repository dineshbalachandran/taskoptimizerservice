package com.infosys.taskoptimizerservice.controller;

import com.infosys.taskoptimizerservice.model.Request;
import com.infosys.taskoptimizerservice.model.Solution;
import com.infosys.taskoptimizerservice.service.TaskOptimizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskOptimizerController {

    @Autowired
    TaskOptimizerService taskOptimizerService;

    @GetMapping("/requests/{id}")
    public ResponseEntity<Request> getOptimizationRequest(@PathVariable int id) {
        Request r = taskOptimizerService.getRequest(id).orElseThrow(() -> {
            return new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("%d request not found", id));
        });
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @PostMapping("/requests")
    public ResponseEntity<Integer> createOptimizationRequest(Request r) {
        int id = taskOptimizerService.createRequest(r);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/solutions/{id}")
    public ResponseEntity<Iterable<Solution>> getOptimizationSolutions(@PathVariable int id) {
        List<Solution> solutions = taskOptimizerService.getSolutions(id);
        return new ResponseEntity<>(solutions, HttpStatus.OK);
    }
}
