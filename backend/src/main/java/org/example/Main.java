package org.example;

import io.javalin.Javalin;
import io.javalin.util.FileUtil;

public class Main {
    public static void main(String[] args) {
        var app = Javalin
        .create(config -> {
            config.bundledPlugins.enableCors(cors -> {
                cors.addRule(it -> {
                    it.anyHost();
                });
            });
        }).start(7070);

        // retornar um objeto em formato json
        app.get("/user", ctx -> {
            ctx.json(new User("Paulo Henrique", "paulo@gmail.com", "31983078225"));
        });

        // gerenciar upload de arquivos
        app.post("/upload", ctx -> {
            int fileCount = ctx.uploadedFiles().size();

            System.out.printf("%d file uploaded%n", fileCount);

            for (int i = 0; i < fileCount; i++) {
                System.out.println("\"" + ctx.uploadedFiles().get(i).filename() + "\" uploaded");
            }

            ctx.uploadedFiles().forEach(uploadedFile ->
                FileUtil.streamToFile(uploadedFile.content(), "arquivos-recebidos-do-frontend/" + uploadedFile.filename()));
        });
    }
}