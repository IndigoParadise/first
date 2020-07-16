package learning.proyect.mongodb.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDBConfiguration {
	
	private Environment environmet;

	@Autowired
	public MongoDBConfiguration(Environment environmet) {
		super();
		this.environmet = environmet;
	}

  
	
}
