package com.tasnim.trade.eshop.web.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ControllerBase {
    public static final Logger LOGGER = LoggerFactory.getLogger(ControllerBase.class);

    void printJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            LOGGER.info("{}", mapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
