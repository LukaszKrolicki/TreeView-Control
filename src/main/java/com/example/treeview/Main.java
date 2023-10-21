package com.example.treeview;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        TreeView<String> treeView = new TreeView<>();

        TreeItem<String> classes = new TreeItem<>("Classes");//adding root
        TreeItem<String> classOne = new TreeItem<>("Class One");//adding branch
        classOne.setExpanded(true);

        classOne.getChildren().addAll( //adding leafs
                new TreeItem<>("patryk"),
                new TreeItem<>("mIKUS"),
                new TreeItem<>("Jacob"));

        TreeItem<String> classTwo = new TreeItem<>("Class Two");
        classTwo.getChildren().addAll(
                new TreeItem<>("patryk1"),
                new TreeItem<>("mIKUS1"),
                new TreeItem<>("Jacob1"));

        classTwo.addEventHandler(TreeItem.branchExpandedEvent(),
                e-> System.out.println(e.getTreeItem().getValue()));

        classes.getChildren().addAll(classOne,classTwo);
        treeView.setRoot(classes);
        treeView.setShowRoot(false);
        treeView.setCellFactory(tCell->{
            TreeCell<String> cell = new TreeCell<>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    setText(null);
                    setGraphic(null);
                    if(!empty){
                        if(this.getTreeItem().getValue().equals("patryk")){
                            setText(item);
                            setGraphic(new Rectangle(15,15, Color.BLUE));
                        }
                        else{
                            setText(item);
                            setGraphic(new Rectangle(15,15, Color.VIOLET));
                        }
                    }
                }
            };
            return cell;
        });
        root.getChildren().addAll(treeView);
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}