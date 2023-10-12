package ru.buhhu8.sockets;

import lombok.Getter;

@Getter
public enum Error {

    EMPTY("Ошибка всего"),
    WRONG("ert"),
    OTHER("sdf");

    private String value;
    Error(String  value){
        this.value = value;
    }

    public static Error mapTo(String reason){
        if(reason.equals("Ошибка всего")){
            return Error.EMPTY;
        }
        if(reason.equals("ert")){
            return Error.WRONG;
        }
        return null;
    }
}
