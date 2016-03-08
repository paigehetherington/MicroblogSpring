package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by vajrayogini on 3/8/16.
 */
public interface MessageRepository extends CrudRepository<Message, Integer> {
}
