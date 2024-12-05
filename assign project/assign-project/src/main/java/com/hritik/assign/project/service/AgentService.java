package com.hritik.assign.project.service;

import com.hritik.assign.project.model.Agent;

import java.util.List;

public interface AgentService {
    public List<Agent> getAllAgents();
    public Agent getAgentById(Integer id) throws Exception;
    public Agent createAgent(Agent agent);
    public Agent updateAgent(Agent agent , Integer id) throws Exception;
    public String deleteAgent(Integer id) throws Exception;
}
