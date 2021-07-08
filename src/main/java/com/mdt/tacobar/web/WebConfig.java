package com.mdt.tacobar.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * when a controller is simple enough that it doesn't populate a model or process input, there's another
 * way that you can define the controller. it's called the view controller, a controller that does nothing
 * but forward the request to the view.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/abc").setViewName("home");
        registry.addViewController("/login");
    }
}
