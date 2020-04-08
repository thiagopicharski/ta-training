package at;

import java.util.List;

import at.configuration.AbstractStoryConfiguration;
import at.configuration.ProjectConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import at.configuration.AbstractStoryConfiguration;
import at.configuration.ProjectConfiguration;

public class AllStories extends AbstractStoryConfiguration {

    @Override
    public ApplicationContext getAnnotatedApplicationContext() {
        return new AnnotationConfigApplicationContext(ProjectConfiguration.class);
    }

    @Override
    public List<String> storyPaths() {
        List<String> paths = new StoryFinder().findPaths(
                CodeLocations.codeLocationFromClass(this.getClass()), "**/stories/Store.story", "");
        return paths;
    }
}
