
package com.wipro.tutorial.at;


import com.wipro.tutorial.at.configuration.AbstractStoryConfiguration;
import com.wipro.tutorial.at.configuration.ProjectConfiguration;
import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;



@RunWith(JUnitReportingRunner.class)
public class AllStories extends AbstractStoryConfiguration {

	public AllStories() {
		configuredEmbedder().embedderControls().doGenerateViewAfterStories(true)
				.doIgnoreFailureInView(true).useThreads(2);
	}

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}
	
	@Override
	public List<String> storyPaths() {
		return new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()), "**/stories/Cart.story", "");

	}
}
