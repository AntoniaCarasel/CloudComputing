package com.project.trip_planner_safe.exceptions;

public class FieldEmptyException extends RuntimeException{
    public FieldEmptyException(String varName) {
        super("Variable " + varName + " can not be missing!");
    }
}
