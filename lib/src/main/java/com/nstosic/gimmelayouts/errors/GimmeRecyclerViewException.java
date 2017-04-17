package com.nstosic.gimmelayouts.errors;

/**
 * Created by nstosic on 4/16/17.
 */

public class GimmeRecyclerViewException extends GimmeLayoutsException {
    private String message;

    public GimmeRecyclerViewException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
