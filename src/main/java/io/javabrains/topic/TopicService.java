package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        // return topics;
    	List<Topic> topics = new ArrayList<>();
    	topicRepository.findAll().forEach(topics::add); // lambda method reference
    	return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic) {
        topicRepository.save(topic);
        
    }

    public void deleteTopic(String id) {
        topicRepository.delete(id);
    }
}
