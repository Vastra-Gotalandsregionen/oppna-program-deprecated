package se.vgregion.__REPLACE_SYSTEM_NAME__.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * @author Patrik Björk
 */
@Component(value = "myController")
@Scope(value = "view", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyController {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
