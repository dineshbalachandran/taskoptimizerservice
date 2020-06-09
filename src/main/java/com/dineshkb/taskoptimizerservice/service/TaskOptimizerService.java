package com.dineshkb.taskoptimizerservice.service;

import com.dineshkb.taskoptimizerservice.model.Request;
import com.dineshkb.taskoptimizerservice.model.Solution;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskOptimizerService {

    public Optional<Request> getRequest(int id) {
        return Optional.of(new Request());
    }

    public int createRequest(Request r) {
        return r.id;
    }

    public List<Solution> getSolutions(int id) {
        Solution s = new Solution();
        s.id = 1;
        //s.result = TaskAssignScheduleApp.solve();
        List l = new ArrayList<>();
        l.add(s);

        return l;
    }
}
