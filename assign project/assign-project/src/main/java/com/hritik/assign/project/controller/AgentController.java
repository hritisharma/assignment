package com.hritik.assign.project.controller;

import com.hritik.assign.project.model.Agent;
import com.hritik.assign.project.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AgentController {
    @Autowired
    private AgentService agentService;

    @PostMapping("/createagent")
    public Agent createAgent(@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    @GetMapping("/agents")
    public List<Agent> getAllAgents() {
        List<Agent> agents = agentService.getAllAgents();
        return agents;
    }


    @GetMapping("/agent/{id}")
    public Agent getAgentById(@PathVariable Integer id) throws Exception {
       return agentService.getAgentById(id);
    }

    @PutMapping("/agent/update/{id}")
    public Agent updateAgent(@RequestBody Agent agent , @PathVariable Integer id) throws Exception {
        return agentService.updateAgent(agent,id);
    }

    @DeleteMapping("/agent/delete/{id}")
    public String deleteAgent(@PathVariable Integer id) throws Exception {
     return agentService.deleteAgent(id);
    }
}
