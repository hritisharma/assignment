package com.hritik.assign.project.service;

import com.hritik.assign.project.model.Agent;
import com.hritik.assign.project.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentServiceImplementation implements AgentService{

    @Autowired
    AgentRepository agentRepository;

    @Override
    public List<Agent> getAllAgents() {
        List<Agent> list = agentRepository.findAll();
        return list;
    }

    @Override
    public Agent getAgentById(Integer id) throws Exception {
       Optional<Agent> find_agent = agentRepository.findById(id);
       if(find_agent.isPresent())
       {
           return find_agent.get();
       }

       throw new Exception("Agent not found with id : " + id);
    }

    @Override
    public Agent createAgent(Agent agent) {
        Agent new_agent = new Agent();
        new_agent.setName(agent.getName());
        new_agent.setLanguage(agent.getLanguage());
        new_agent.setVoiceId(agent.getVoiceId());
        new_agent.setUpdated(agent.getUpdated());

        Agent created_agent = agentRepository.save(new_agent);
        return created_agent;
    }

    @Override
    public Agent updateAgent(Agent agent, Integer id) throws Exception {
        Optional<Agent> find_agent = agentRepository.findById(id);
        if (find_agent.isEmpty()) {
            throw new Exception("Agent not found with id: " + id);
        }

        Agent agent1 = find_agent.get();
        if (agent.getName() != null) {
            agent1.setName(agent.getName());
        }
        if (agent.getLanguage() != null) {
            agent1.setLanguage(agent.getLanguage());
        }
        if (agent.getVoiceId() != null)
        {
            agent1.setVoiceId(agent.getVoiceId());
        }
        if(agent.getUpdated() != null)
        {
            agent1.setUpdated(agent.getUpdated());
        }

        Agent saved_agent = agentRepository.save(agent1);

        return saved_agent;

    }

    @Override
    public String deleteAgent(Integer id) throws Exception {
        Optional<Agent> find_agent = agentRepository.findById(id);
        if (find_agent.isEmpty()) {
            throw new Exception("Agent not found with id: " + id);
        }

        agentRepository.delete(find_agent.get());

        return "Agent Deleted Successfully";
    }
}
