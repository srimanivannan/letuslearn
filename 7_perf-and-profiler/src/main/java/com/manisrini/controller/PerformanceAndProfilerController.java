package com.manisrini.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manisrini.domain.GreetMessage;


@RestController
@RequestMapping("/private/10001")
public class PerformanceAndProfilerController {

  @GetMapping("/message")
  public ResponseEntity<GreetMessage> getGreetMessage() {
    GreetMessage greetMessage = new GreetMessage();
    greetMessage.setMessageType("wish");
    greetMessage.setMessageDescription("happy mothers day");
    return ResponseEntity.ok(greetMessage);
  }

}
