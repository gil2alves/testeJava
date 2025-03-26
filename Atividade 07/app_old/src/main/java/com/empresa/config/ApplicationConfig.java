package com.empresa.config;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    // Essa classe habilita os endpoints REST em /api/*
}
