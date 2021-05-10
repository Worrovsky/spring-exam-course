package com.example;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoProperties implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("prop-from-info-contributor", "hello from contributor");
        builder.withDetail("pro op", "hello from contributor");
    }
}
