package com.example.stream.eventhub.demoStreamEventhub.config;

import java.util.function.Supplier;

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
}
