package com.raghava.springboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.raghava.springboot.model.Topic;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("java","core java and adv java","java 16 is updated java version"),
			new Topic("hibernate","hibernate annotation","hinernate update"),
			new Topic("spring","spring boot","spring bootstart")));
	
	public List<Topic> getAlltopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(l -> l.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic) {
		topics.add(topic);
	}
	
	public void updateTopic(Topic topic) {
		for(Topic t: topics) {
			if(t.getId().equals(topic.getId())) {
				topics.remove(t);
				topics.add(topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		for(Topic t: topics) {
			if(t.getId().equals(id)) {
				topics.remove(t);
				return;
			}
		}
	}
}
