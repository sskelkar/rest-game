package com.tw.restgame.com.tw.stage.one;

import com.tw.restgame.HttpCaller;

public class StageOne {
    private static final int A = 65;
    private static final int Z = 90;
    private static final int ALPHABET_COUNT = 26;
    private HttpCaller caller;


    public StageOne(HttpCaller caller) {
        this.caller = caller;
    }

    public void decryptMessage() {
        Input input = caller.getInput(Input.class);
        String message = input.getEncryptedMessage();
        StringBuilder result = new StringBuilder();

        for(int i = 0; i< message.length(); i++) {
            char c = message.charAt(i);
            if(c >= A && c<= Z) {
                int decrypted = (((c-A) + (ALPHABET_COUNT - input.getKey())) % ALPHABET_COUNT) + A;
                c = (char) decrypted;
            }
            result.append(c);
        }

        caller.sendOutput(new Output(result.toString()));
    }
}
