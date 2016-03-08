package com.theironyard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vajrayogini on 3/7/16.
 */

@Entity
public class Message {
    @Id
    @GeneratedValue
    int id;
    String text;

    public Message(String text) {
        this.text = text;
    }

    public Message() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
