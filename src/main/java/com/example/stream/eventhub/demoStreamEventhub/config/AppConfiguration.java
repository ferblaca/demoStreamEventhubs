package com.example.stream.eventhub.demoStreamEventhub.config;

import java.util.function.Supplier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Configuration
public class AppConfiguration {

  private static final Logger LOGGER = LoggerFactory.getLogger(AppConfiguration.class);

  @Bean
  public Supplier<Message<String>> supply() {
    return () -> {
      try {
        return MessageBuilder.withPayload("Hello World!").build();
      } catch (Exception e) {
        LOGGER.error("Error sending message", e);
        return null;
      }
    };
  }

  // workaround - https://github.com/spring-cloud/spring-cloud-stream/issues/2794#issuecomment-1863279349
  @Bean
  public ObjectMapper objectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    return objectMapper;
  }
}
