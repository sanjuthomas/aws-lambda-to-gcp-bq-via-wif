package com.sanjuthomas.gcp;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler implements RequestHandler<Map<String, String>, String> {

  private static final Logger logger = LoggerFactory.getLogger(Handler.class);

  @Override
  public String handleRequest(Map<String, String> event, Context context) {
    try {
      WriteToDefaultStream.runWriteToDefaultStream();
    } catch (DescriptorValidationException e) {
      logger.error(e.getMessage(), e);
    } catch (InterruptedException e) {
      logger.error(e.getMessage(), e);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
    return "Life is good!";
  }
}