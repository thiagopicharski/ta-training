
package com.wipro.tutorial.at;

import java.util.List;

import de.codecentric.jbehave.junit.monitoring.JUnitReportingRunner;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.tutorial.at.configuration.AbstractStoryConfiguration;
import com.wipro.tutorial.at.configuration.ProjectConfiguration;

@RunWith(JUnitReportingRunner.class)
public class AllStories extends AbstractStoryConfiguration {

	@Override
	public ApplicationContext getAnnotatedApplicationContext() {
		return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
	}
	
	@Override
	public List<String> storyPaths() {
		List<String> paths = new StoryFinder().findPaths(
				CodeLocations.codeLocationFromClass(this.getClass()), "**/searchMercadoLivre.story", "");
		return paths;
	}
}
