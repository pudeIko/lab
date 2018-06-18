package zad3;
/*
 * Copyright (c) 2012, 2014 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class EmbeddedMediaPlayer extends Application {

    private static String MEDIA_URL = "http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv";

    String inFileName = " ";
    MediaPlayer mediaPlayer;
    MediaControl mediaControl;
    Group root;
    BorderPane borderPane;
    Button button;
    private Desktop desktop = Desktop.getDesktop();

    public void start(final Stage primaryStage) {
    	
        primaryStage.setTitle("Embedded Media Player");
        borderPane = new BorderPane();
        root = new Group();
        button = new Button("Choose file");
        final FileChooser fileChooser = new FileChooser();
        //Scene scene = new Scene(root, 500, 300);
        
        button.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {
                        File file = fileChooser.showOpenDialog(primaryStage);
                        if (file != null) {
                            //openFile(file);
                        	inFileName = file.toURI().toString();
                        	//Media media = new Media(inFileName);
                			System.out.println(inFileName);
                			Media media = new Media (inFileName);
                	        mediaPlayer = new MediaPlayer(media);
                	        mediaPlayer.setAutoPlay(true);
                	        mediaControl = new MediaControl(mediaPlayer);
                	        borderPane.setTop(button);
                	        borderPane.setCenter(mediaControl);
                	        Scene scene = new Scene (borderPane, 500, 300);
                	        //scene.setRoot(mediaControl);
                	        primaryStage.setScene(scene);
                	        primaryStage.sizeToScene();
                	        primaryStage.show();
                        }
                    }
                });

        //create media player
        /*Media media = new Media (MEDIA_URL);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaControl = new MediaControl(mediaPlayer);*/

        borderPane.setTop(button);
        //borderPane.setCenter(mediaControl);
        Scene scene = new Scene (borderPane, 500, 300);
        //scene.setRoot(mediaControl);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
        
    }
    /*private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
            		EmbeddedMediaPlayer.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}