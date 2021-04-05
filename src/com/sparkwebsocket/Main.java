package com.sparkwebsocket;

import spark.ModelAndView;
import spark.Spark;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import java.util.HashMap;

import static spark.Spark.webSocket;

public class Main {

    public static void main(String[] args) {
        Spark.webSocket("/websocket/echo", EchoWebSocket.class);
        Spark.get("/", (request,response)->{
            return "Hello World";
        });

        Spark.get("/echo", (request,response)->{
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "echoview"));
        });

        Spark.get("/echo1", (request,response)->{
            HashMap<String, Object> model = new HashMap<>();
            return new ThymeleafTemplateEngine().render(new ModelAndView(model, "echoview1"));
        });

        Spark.init();
    }
}
