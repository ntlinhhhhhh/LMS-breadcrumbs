module test.example.lib_db {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;

    //opens test.example.lib_db to javafx.fxml;
    //exports test.example.lib_db;
    //exports test.example.lib_db.database;
   // opens test.example.lib_db.database to javafx.fxml;
}