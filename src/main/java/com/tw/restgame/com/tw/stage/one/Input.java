package com.tw.restgame.com.tw.stage.one;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Input {
    private String encryptedMessage;
    private Integer key;

    public Input() {
        //for jackson
    }

    public Input(String encryptedMessage, Integer key) {
        this.encryptedMessage = encryptedMessage;
        this.key = key;
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public Integer getKey() {
        return key;
    }
}
