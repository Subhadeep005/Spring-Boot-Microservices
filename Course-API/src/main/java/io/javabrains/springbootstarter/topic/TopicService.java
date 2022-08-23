package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<Topic>(
			Arrays.asList(new Topic("Spring", "Spring Framework", "Spring Framework Description"),
					new Topic("Java", "Core Java", "Core Java Description"),
					new Topic("Hibernate", "Hibernate Framework", "Hibernate Framework Description"),
					new Topic("Angular", "Anguler Framework", "Anguler Framework Description"),
					new Topic("Java Script", "Java Script Framework", "Java Script Framework Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {

		for (int i = 0; i < topics.size(); i++) {

			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}

		/*
		 * Topic topicFromList = topics.stream().filter(t ->
		 * t.getId().equals(id)).findFirst().get(); topicFromList.setId(topic.getId());
		 * topicFromList.setName(topic.getName());
		 * topicFromList.setDescription(topic.getDescription());
		 */

	}

	public void deleteTopic(String id) {

		topics.removeIf(t -> t.getId().equals(id));

		/*
		 * Topic topicFromList = topics.stream().filter(t ->
		 * t.getId().equals(id)).findFirst().get(); topics.remove(topicFromList);
		 */
	}
}
