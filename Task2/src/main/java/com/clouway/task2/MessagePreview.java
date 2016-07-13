package com.clouway.task2;

import com.clouway.task1.JSONCodecConverter;

public class MessagePreview {

    public static void main(String [] args){
        JSONCodecConverter jsonConverter = new JSONCodecConverter();

        if(args[0].equals("-type") && args[1].equals("json") && args[3].equals("--printAverageStats")){
            Users users = (Users) jsonConverter.unmarshal(Users.class, args[2]);
            users.printAverageStats();
        }
    }
}
