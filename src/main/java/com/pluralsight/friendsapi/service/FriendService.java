package com.pluralsight.friendsapi.service;

import com.pluralsight.friendsapi.model.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendService extends CrudRepository<Friend, Integer> {

    public Iterable<Friend> findByFirstNameAndLastName(String firstName, String lastName);

    public Iterable<Friend> findByFirstName(String firstName);

    public Iterable<Friend> findByLastName(String lastName);

}
