package com.automation.pojos;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class Config {
    private Map<String, Environment> environments;

    public Map<String, Environment> getEnvironments() {
        return environments;
    }
}