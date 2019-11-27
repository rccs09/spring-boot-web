package com.rccs.springboot.di;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:/properties/values-defect.properties")
})
public class ValuesPropertiesConfig {

}
