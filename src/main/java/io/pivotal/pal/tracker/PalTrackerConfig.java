package io.pivotal.pal.tracker;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PalTrackerConfig {
    @Bean
    public TimeEntryRepository  timeEntryRepository(){
        return new InMemoryTimeEntryRepository();
    }

    @Bean
    public JdbcTimeEntryRepository jdbcTimeEntryRepository(DataSource dataSource){
        return new JdbcTimeEntryRepository(dataSource);
    }
}
