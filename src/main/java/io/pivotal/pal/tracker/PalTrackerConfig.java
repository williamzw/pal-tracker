package io.pivotal.pal.tracker;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PalTrackerConfig {
    @Bean
    public TimeEntryRepository  timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }
}
