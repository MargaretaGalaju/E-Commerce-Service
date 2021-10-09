package com.ecommerce.userservice.resources;

import com.ecommerce.userservice.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResource {

    @RequestMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {
        return new User("b390e573-8496-45cb-bee1-032db283c416", "Margareta Galaju");
    }
}
