package com.lp.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lp.*")
public class E2EWebMvcAppConfig extends WebMvcConfigurerAdapter {

	@Bean	
	public ViewResolver getViewResolver() {
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		E2EJsonViewResolvers viewResolver2 = new E2EJsonViewResolvers();
		resolvers.add(viewResolver2);
		return resolver;
	}
		
	 @Override
	 public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	       configurer.enable();
	 }
	 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true).
		favorParameter(false).
	    parameterName("mediaType").
	    ignoreAcceptHeader(false).
	    useJaf(false).
	    defaultContentType(MediaType.APPLICATION_JSON).
	    mediaType("text", MediaType.TEXT_HTML). 
	    mediaType("xml", MediaType.APPLICATION_XML). 
	    mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	@Bean(name = "dozerBean")
	public DozerBeanMapperFactoryBean configDozer() throws IOException {
		DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources("classpath*:dozer-bean-mappings.xml");
		mapper.setMappingFiles(resources);
		return mapper;
	}
	
	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new E2ETimeBasedAccessInterceptor());
	}*/
	
	@Bean(name = "multiPartResolver")
	public CommonsMultipartResolver getMultiPartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		return resolver;
	}

	/*@Bean(name = "jacksonMessageTypeConverters")
	public FactoryBean<ObjectMapper> getConversionOfJacksonMessageconvert() {
		return new Jackson2ObjectMapperFactoryBean();
	}*/
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		GsonHttpMessageConverter msgConverter = new GsonHttpMessageConverter();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		msgConverter.setGson(gson);
		converters.add(msgConverter);
	}

	
}
