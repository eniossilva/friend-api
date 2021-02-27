package com.pluralsight.friendsapi.controller;

import com.pluralsight.friendsapi.model.Friend;
import com.pluralsight.friendsapi.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping("/friend")
    public Friend create(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @GetMapping("/friend")
    public Iterable<Friend> read(){
        return friendService.findAll();
    }

    @PutMapping("/friend")
    public Friend update(@RequestBody Friend friend){
        return friendService.save(friend);
    }

    @DeleteMapping("/friend/{id}")
    public void delete(@PathVariable Integer id){
        friendService.deleteById(id);
    }

    @GetMapping("/friend/{id}")
    public Optional<Friend> findById(@PathVariable Integer id){
        return friendService.findById(id);
    }

    @GetMapping("/friend/search")
    public Iterable<Friend> findByQuery(
            @RequestParam(value="first", required = false) String firstName,
            @RequestParam(value="last", required = false) String lastName){

        if(firstName != null && lastName != null) {
            return friendService.findByFirstNameAndLastName(firstName, lastName);
        } else if(firstName != null){
            return friendService.findByFirstName(firstName);
        } else if(lastName != null){
            return friendService.findByLastName(lastName);
        } else {
            return friendService.findAll();
        }
    }
}
