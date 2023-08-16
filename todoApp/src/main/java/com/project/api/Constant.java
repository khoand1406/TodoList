package com.project.api;

public class Constant {
    public static final String URI_API = "/api";

    public static final String URI_Todos = "/todos";

    public static final String URI_SubTodo = "/subtodos";

    private Constant() {
        throw new InstantiationError("Must not instantiate this class");
    }
}
