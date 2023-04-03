package simwriting.Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import simwriting.Services.adminReadService;
import simwriting.Services.detectCardService;
import simwriting.Services.programCardService;
import simwriting.Services.readCardService;
import simwriting.Services.sqnService;


/**
 *
 * @author alec
 */
public class MainWindowController implements Initializable {
    
    @FXML
    private ImageView simCardImageView;

    @FXML
    private ComboBox readerCbox;

    @FXML
    private ImageView refreshBtn;
    
    @FXML
    private TextField admpinInput;

    @FXML
    private TextField iccidInput;

    @FXML
    private CheckBox iccidChk;

    @FXML
    private TextField ccInput;

    @FXML
    private CheckBox ccChk;

    @FXML
    private TextField nameInput;

    @FXML
    private CheckBox nameChk;

    @FXML
    private TextField typeInput;

    @FXML
    private CheckBox typeChk;

    @FXML
    private ComboBox baudrateCbox;

    @FXML
    private CheckBox baudrateChk;

    @FXML
    private TextField kiInput;

    @FXML
    private CheckBox kiChk;

    @FXML
    private TextField opcInput;

    @FXML
    private CheckBox opcChk;

    @FXML
    private TextField accInput;

    @FXML
    private CheckBox accChk;

    @FXML
    private TextField numInput;

    @FXML
    private CheckBox numChk;

    @FXML
    private RadioButton eraseTrueRad;

    @FXML
    private RadioButton eraseFalseRad;

    @FXML
    private CheckBox eraseChk;

    @FXML
    private TextField mccInput;

    @FXML
    private CheckBox mccChk;

    @FXML
    private TextField mncInput;

    @FXML
    private CheckBox mncChk;

    @FXML
    private TextField smscInput;

    @FXML
    private CheckBox smscChk;

    @FXML
    private TextField smspInput;

    @FXML
    private CheckBox smspChk;

    @FXML
    private TextField opInput;
    
    @FXML
    private CheckBox opChk;

    @FXML
    private TextField strInput;

    @FXML
    private CheckBox strChk;

    @FXML
    private TextField sqnInput;

    @FXML
    private CheckBox sqnChk;

    @FXML
    private RadioButton batchTrueRad;

    @FXML
    private RadioButton batchFalseRad;

    @FXML
    private CheckBox batchChk;

    @FXML
    private TextField imsiInput;

    @FXML
    private CheckBox imsiChk;
    
    @FXML
    private ToggleGroup batchTg;
    
    @FXML
    private ToggleGroup eraseTg;
    
    @FXML
    private ImageView readerError;

    @FXML
    private ImageView iccidError;

    @FXML
    private ImageView ccError;
    
    @FXML
    private ImageView nameError;
    
    @FXML
    private ImageView typeError;
    
    @FXML
    private ImageView BaudError;
    
    @FXML
    private ImageView kiError;
    
    @FXML
    private ImageView opcError;
    
    @FXML
    private ImageView accError;
        
    @FXML
    private ImageView mccError;
    
    @FXML
    private ImageView mncError;
    
    @FXML
    private ImageView smscError;
    
    @FXML
    private ImageView smspError;
    
    @FXML
    private ImageView opError;
    
    @FXML
    private ImageView strError;
    
    @FXML
    private ImageView sqnError;
    

    @FXML
    private ImageView imsiError;

    @FXML
    private ImageView AdmpinError;
    
    @FXML
    private ImageView numError;
    
    @FXML
    private HBox iccidHbox;
    
    @FXML
    private HBox ccHbox;
    
    @FXML
    private HBox nameHbox;
    
    @FXML
    private HBox typeHbox;
    
    @FXML
    private HBox BaudrateHbox;
    
    @FXML
    private HBox kiHbox;
    
    @FXML
    private HBox opcHbox;
    
    @FXML
    private HBox accHbox;
    
    @FXML
    private HBox mccHbox;
    
    @FXML
    private HBox mncHbox;
    
    @FXML
    private HBox smscHbox;
    
    @FXML
    private HBox smspHbox;
    
    @FXML
    private HBox strHbox;
    
    @FXML
    private HBox sqnHbox;
    
    @FXML
    private HBox imsiHbox;
    
    @FXML
    private HBox numHbox;
    
    @FXML
    private Circle fineTuningSwitch;
    
    @FXML
    private Label fineTuneValue;
    
    @FXML
    private Rectangle fineTuningRectangle;
        
    @FXML
    private Label ccLabel;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private Label typeLabel;

    @FXML
    private Label baudratelabel;

    @FXML
    private Label mccLabel;

    @FXML
    private Label mncLabel;

    @FXML
    private Label smscLabel;

    @FXML
    private Label smspLabel;

    @FXML
    private Label accLabel;

    @FXML
    private Label numLabel;

    @FXML
    private Label strLabel;
    
    @FXML
    private Label batchLabel;
    
    @FXML
    private Label batchLabel2;

    @FXML
    private Label eraseLabel;
    
    @FXML
    private Label eraseLabel2;
    
    @FXML
    private HBox opHbox;

    @FXML
    private HBox opHbox2;

    
    private Boolean validEntries = true;
    
    private Boolean fineTune = false;
    
    private ChangeListener opcListener;
    
    private ChangeListener opcFineTuneListener;
    
    private ChangeListener opListener;
    
    private ChangeListener opFineTuneListener;
    
    @FXML
    void refreshCardReader(MouseEvent event)
    {

        RotateTransition rotate = new RotateTransition();
        rotate.setNode(refreshBtn);
        rotate.setDuration(Duration.seconds(30));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setByAngle(36000);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.play();
   
        detectCardService detectCards = new detectCardService();
        detectCards.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                ArrayList<String> cards = (ArrayList<String>) event.getSource().getValue();
                readerCbox.setItems(FXCollections.observableArrayList(cards));
                rotate.stop();
               
                if(cards.isEmpty()){
                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon2.png")));
                }else{
                     simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png")));    
                }
            }
         });
        detectCards.start();
       
    }
    
    @FXML
    void read(ActionEvent event) throws IOException 
    {
        
        boolean readerSelected = true;
        
        // Validate if reader has been selected
        if(readerCbox.getValue() == null)
        {
            ObservableList<String> styleClass = readerCbox.getStyleClass();
            styleClass.add("error");
            
            readerError.setVisible(true);
            
            FadeTransition fade = new FadeTransition();
            fade.setNode(readerError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();
            
            readerSelected = false;
        }
        
        if(readerSelected)
        {
            
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("/simwriting/Views/LoadingView.fxml"));
            Parent parent1 = fxml.load();

            Scene scene1 = new Scene(parent1);
            Stage stage1 = new Stage();
            stage1.initModality(Modality.APPLICATION_MODAL); 
            stage1.initStyle(StageStyle.TRANSPARENT);
            scene1.setFill(Color.TRANSPARENT);
            stage1.setScene(scene1);
            stage1.setX(((Stage) simCardImageView.getScene().getWindow()).getX());       
            stage1.setY(((Stage) simCardImageView.getScene().getWindow()).getY());
            stage1.show();
            
            detectCardService detectCards = new detectCardService();
            detectCards.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    ArrayList<String> cards = (ArrayList<String>) event.getSource().getValue();

                    if(cards.isEmpty()){
                        stage1.close();
                        readerCbox.getItems().clear();
                        simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon2.png")));

                        ObservableList<String> styleClass = readerCbox.getStyleClass();
                        styleClass.add("error");
                        readerError.setVisible(true);
                        FadeTransition fade = new FadeTransition();
                        fade.setNode(readerError);
                        fade.setDuration(Duration.millis(500));
                        fade.setCycleCount(TranslateTransition.INDEFINITE);
                        fade.setInterpolator(Interpolator.LINEAR);
                        fade.setFromValue(1);
                        fade.setToValue(0.1);
                        fade.setCycleCount(16);
                        fade.setAutoReverse(true);
                        fade.play();
                       
                    }else{
                        simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png")));
                        
                        readCardService r = new readCardService(createCardReadingParameters());
                        r.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
                        {
                            @Override
                            public void handle(WorkerStateEvent event) 
                            {
                                try 
                                {
                                    stage1.close();
                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/simwriting/Views/ReadCardDialogView.fxml"));
                                    Parent parent = fxmlLoader.load();

                                    ReadCardDialogController readCardDialogController = fxmlLoader.getController();
                                    ArrayList<String> results = (ArrayList<String>) event.getSource().getValue();
                                    String arr = "";

                                    for(int i=0;i<results.size();++i){
                                        arr += results.get(i) +"\n";
                                        if(results.get(i).contains("ICCID:")){
                                            String[] readArr = results.get(i).split(" ");
                                            if(fineTune){
                                                iccidChk.setSelected(true);
                                                iccidInput.setText(readArr[1]);
                                            }else{
                                                iccidChk.setSelected(false);
                                                iccidInput.setText(readArr[1]);
                                            }
                                            
                                        }
                                        if(results.get(i).contains("IMSI:")){
                                            String[] readArr = results.get(i).split(" ");
                                            if(fineTune){
                                                imsiChk.setSelected(true);
                                                imsiInput.setText(readArr[1]);
                                            }else{
                                                imsiChk.setSelected(false);
                                                imsiInput.setText(readArr[1]);
                                            }
                                            
                                        }
                                        if(results.get(i).contains("SMSP:")  && !fineTune) {
                                            String[] readArr = results.get(i).split(" ");
                                            smspChk.setSelected(false);
                                            smspInput.setText(readArr[1]);
                                        }
                                        if(results.get(i).contains("ACC:") && !fineTune){
                                            String[] readArr = results.get(i).split(" ");
                                            accChk.setSelected(false);
                                            accInput.setText(readArr[1]);
                                        }
                                        
                                        if(results.get(i).contains("Autodetected card type:") && !fineTune){
                                            String[] readArr = results.get(i).split(" ");
                                            typeChk.setSelected(false);
                                            typeInput.setText(readArr[3]);
                                        }
                                        
                                        if(results.get(i).contains("SPN:") && !fineTune){
                                            String[] readArr = results.get(i).split(" ");
                                            nameChk.setSelected(false);
                                            nameInput.setText(readArr[1]);
                                        }
                                    }
                                    readCardDialogController.resultsText.setText(arr);

                                    Scene scene = new Scene(parent);
                                    Stage stage = new Stage();
                                    stage.initModality(Modality.APPLICATION_MODAL);
                                    stage.resizableProperty().setValue(Boolean.FALSE);
                                    stage.setScene(scene);
                                    stage.showAndWait();
                                } catch (IOException ex) 
                                {
                                    Logger.getLogger(ReadCardDialogController.class.getName()).log(Level.SEVERE, null, ex);

                                }  
                            }
                         });
                        r.start();
                    }
                }
             });
            detectCards.start();
        }
    }
    
    @FXML
    void adminRead(ActionEvent event) throws IOException{
        
        boolean readerSelected = true;
        
        // Validate if reader has been selected
        if(readerCbox.getValue() == null)
        {
            ObservableList<String> styleClass = readerCbox.getStyleClass();
            styleClass.add("error");
            
            readerError.setVisible(true);
            
            FadeTransition fade = new FadeTransition();
            fade.setNode(readerError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();
            
            readerSelected = false;
        }
        boolean validateADM = true;
        //Validate if ADM PIN has = 8 digits
        int admpinLength = admpinInput.getText().length();
        ObservableList<String> styleClassAdmpin = admpinInput.getStyleClass();
        if(admpinLength != 8)
        {
            styleClassAdmpin.add("error");
            AdmpinError.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setNode(AdmpinError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();
            validateADM = false;
        }
        
        if(readerSelected && validateADM)
        {
            FXMLLoader confirmFxml = new FXMLLoader(getClass().getResource("/simwriting/Views/ConfirmAdmPinView.fxml"));
            Parent confirmParent = confirmFxml.load();
            
            ConfirmAdmPinController confirmAdmPinController = confirmFxml.getController();
            Scene confirmScene = new Scene(confirmParent);
            Stage confirmStage = new Stage();
            confirmAdmPinController.cancelBtn.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent event) {
                    confirmStage.close();
                }
            });
            confirmAdmPinController.confirmBtn.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent event) 
                {
                    try 
                    {
                        confirmStage.close();
                        
                        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/simwriting/Views/LoadingView.fxml"));
                        Parent parent1 = fxml.load();

                        Scene scene1 = new Scene(parent1);
                        Stage stage1 = new Stage();
                        stage1.initModality(Modality.APPLICATION_MODAL); 
                        stage1.initStyle(StageStyle.TRANSPARENT);
                        scene1.setFill(Color.TRANSPARENT);
                        stage1.setScene(scene1);
                        stage1.setX(((Stage) simCardImageView.getScene().getWindow()).getX());       
                        stage1.setY(((Stage) simCardImageView.getScene().getWindow()).getY());
                        stage1.show();

                        detectCardService detectCards = new detectCardService();
                        detectCards.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                            @Override
                            public void handle(WorkerStateEvent event) {
                                ArrayList<String> cards = (ArrayList<String>) event.getSource().getValue();

                                if(cards.isEmpty()){
                                    stage1.close();
                                    readerCbox.getItems().clear();
                                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon2.png")));

                                    ObservableList<String> styleClass = readerCbox.getStyleClass();
                                    styleClass.add("error");
                                    readerError.setVisible(true);
                                    FadeTransition fade = new FadeTransition();
                                    fade.setNode(readerError);
                                    fade.setDuration(Duration.millis(500));
                                    fade.setCycleCount(TranslateTransition.INDEFINITE);
                                    fade.setInterpolator(Interpolator.LINEAR);
                                    fade.setFromValue(1);
                                    fade.setToValue(0.1);
                                    fade.setCycleCount(16);
                                    fade.setAutoReverse(true);
                                    fade.play();

                                }else{
                                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png")));

                                    adminReadService r = new adminReadService(createCardAdminReadingParameters());
                                    r.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
                                    {
                                        @Override
                                        public void handle(WorkerStateEvent event) 
                                        {
                                            try 
                                            {
//                                                stage1.close();
                                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/simwriting/Views/AdminReadCardDialog.fxml"));
                                                Parent parent = fxmlLoader.load();

                                                AdminReadCardDialogController adminReadCardDialogController = fxmlLoader.getController();
                                                ArrayList<String> results = (ArrayList<String>) event.getSource().getValue();
                                        
                                                String arr = "";

                                                boolean containsSuccess = false;
                                                for(int i=0;i<results.size();++i){
                                                    arr += results.get(i) +"\n";
                                                    if(results.get(i).contains("Authentication successful")){
                                                        containsSuccess = true;
                                                    }
                                                    if(results.get(i).contains("KI: ") && containsSuccess){
                                                        String[] readArr = results.get(i).split(" ");
                                                        if(fineTune){
                                                            kiChk.setSelected(true);
                                                            kiInput.setText(readArr[4]);
                                                        }else{
                                                            kiChk.setSelected(false);
                                                            kiInput.setText(readArr[4]);
                                                        }
                                                    }
                                                    if(results.get(i).contains("OPc: ") && containsSuccess){
                                                        String[] readArr = results.get(i).split(" ");
                                                        if(fineTune){
                                                            opcChk.setSelected(true);
                                                            opcInput.setText(readArr[3]);
                                                        }else{
                                                            opcChk.setSelected(false);
                                                            opcInput.setText(readArr[3]);
                                                        }
                                                    }
                                                }
                                                arr += "\n****************************************************************************************************\n\n";
                                                adminReadCardDialogController.adminReadResultsText.setText(arr);
                                                if(containsSuccess){
                                                   
                                                    readCardService r2 = new readCardService(createCardReadingParameters());
                                                    r2.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
                                                    {
                                                        @Override
                                                        public void handle(WorkerStateEvent event) 
                                                        {
                                                            stage1.close();
                                                            ArrayList<String> results = (ArrayList<String>) event.getSource().getValue();
                                                            String arr2 = "";
                                                            for(int i=0;i<results.size();++i){
                                                                arr2 += results.get(i) +"\n";
                                                                if(results.get(i).contains("ICCID:")){
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    if(fineTune){
                                                                        iccidChk.setSelected(true);
                                                                        iccidInput.setText(readArr[1]);
                                                                    }else{
                                                                        iccidChk.setSelected(false);
                                                                        iccidInput.setText(readArr[1]);
                                                                    }
                                                                    
                                                                }
                                                                if(results.get(i).contains("IMSI:")){
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    if(fineTune){
                                                                        imsiChk.setSelected(true);
                                                                        imsiInput.setText(readArr[1]);
                                                                    }else{
                                                                        imsiChk.setSelected(false);
                                                                        imsiInput.setText(readArr[1]);
                                                                    }

                                                                }
                                                                if(results.get(i).contains("SMSP:")  && !fineTune) {
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    smspChk.setSelected(false);
                                                                    smspInput.setText(readArr[1]);
                                                                }
                                                                if(results.get(i).contains("ACC:") && !fineTune){
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    accChk.setSelected(false);
                                                                    accInput.setText(readArr[1]);
                                                                }
                                                                
                                                                if(results.get(i).contains("Autodetected card type:") && !fineTune){  
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    typeChk.setSelected(false);
                                                                    typeInput.setText(readArr[3]);
                                                                }
                                                                
                                                                if(results.get(i).contains("SPN:") && !fineTune){
                                                                    String[] readArr = results.get(i).split(" ");
                                                                    nameChk.setSelected(false);
                                                                    nameInput.setText(readArr[1]);
                                                                }
                                                            }
                                                            adminReadCardDialogController.adminReadResultsText.appendText(arr2);
                                                            Scene scene = new Scene(parent);
                                                            Stage stage = new Stage();
                                                            stage.initModality(Modality.APPLICATION_MODAL);
                                                            stage.resizableProperty().setValue(Boolean.FALSE);
                                                            stage.setScene(scene);
                                                            stage.showAndWait();
                                                        }
                                                     });
                                                    r2.start();
                                                    
                                                }else{
                                                    stage1.close();
                                                    adminReadCardDialogController.adminReadResultsLabel.setText("Administration Read Failed");
                                                    adminReadCardDialogController.adminReadResultsImg.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon6.png")));
                                                    Scene scene = new Scene(parent);
                                                    Stage stage = new Stage();
                                                    stage.initModality(Modality.APPLICATION_MODAL);
                                                    stage.resizableProperty().setValue(Boolean.FALSE);
                                                    stage.setScene(scene);
                                                    stage.showAndWait();
                                                }
//
//            
//                                                
//
//                                                Scene scene = new Scene(parent);
//                                                Stage stage = new Stage();
//                                                stage.initModality(Modality.APPLICATION_MODAL);
//                                                stage.resizableProperty().setValue(Boolean.FALSE);
//                                                stage.setScene(scene);
//                                                stage.showAndWait();
                                            } catch (IOException ex) 
                                            {
                                                Logger.getLogger(ReadCardDialogController.class.getName()).log(Level.SEVERE, null, ex);

                                            }  
                                        }
                                     });
                                    r.start();
                                }
                            }
                         });
                        detectCards.start();


                    } catch (IOException ex) {
                        Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            confirmStage.initModality(Modality.APPLICATION_MODAL);
            confirmStage.resizableProperty().setValue(Boolean.FALSE);
            confirmStage.setScene(confirmScene);
            confirmStage.showAndWait();
            
            
        }
    }
    
    @FXML
    void write(ActionEvent event) throws IOException 
    {        
        validation();
        
        if(validEntries)
        {    
            FXMLLoader confirmFxml = new FXMLLoader(getClass().getResource("/simwriting/Views/ConfirmAdmPinView.fxml"));
            Parent confirmParent = confirmFxml.load();
            
            ConfirmAdmPinController confirmAdmPinController = confirmFxml.getController();
            Scene confirmScene = new Scene(confirmParent);
            Stage confirmStage = new Stage();
            confirmAdmPinController.cancelBtn.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent event) {
                    confirmStage.close();
                }
            });
            confirmAdmPinController.confirmBtn.setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent event) 
                {
                    try 
                    {
                        confirmStage.close();
                        
                        
                        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/simwriting/Views/LoadingView.fxml"));
                        Parent parent1 = fxml.load();
                        Scene scene1 = new Scene(parent1);
                        Stage stage1 = new Stage();
                        stage1.initModality(Modality.APPLICATION_MODAL);
                        stage1.initStyle(StageStyle.TRANSPARENT);
                        scene1.setFill(Color.TRANSPARENT);
                        stage1.setScene(scene1);
                        stage1.setX(((Stage) simCardImageView.getScene().getWindow()).getX());
                        stage1.setY(((Stage) simCardImageView.getScene().getWindow()).getY());
                        stage1.show();
                        
                        detectCardService detectCards = new detectCardService();
                        detectCards.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
                        {
                            @Override
                            public void handle(WorkerStateEvent event) 
                            {
                                ArrayList<String> cards = (ArrayList<String>) event.getSource().getValue();
                                readerCbox.setItems(FXCollections.observableArrayList(cards));             
                                if(cards.isEmpty())
                                {
                                    stage1.close();
                                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon2.png")));
                                    ObservableList<String> styleClass = readerCbox.getStyleClass();
                                    styleClass.add("error");
                                    readerError.setVisible(true);
                                    FadeTransition fade = new FadeTransition();
                                    fade.setNode(readerError);
                                    fade.setDuration(Duration.millis(500));
                                    fade.setCycleCount(TranslateTransition.INDEFINITE);
                                    fade.setInterpolator(Interpolator.LINEAR);
                                    fade.setFromValue(1);
                                    fade.setToValue(0.1);
                                    fade.setCycleCount(16);
                                    fade.setAutoReverse(true);
                                    fade.play();
                                }
                                else
                                {
                                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png"))); 
                                    
                                    if(!fineTune)
                                    {
                                        
//                                        print Command line that will be used for programming sim card
//                                        ArrayList<String> example = createCardProgrammingParameters();
//                                        for(int i=0;i<example.size();++i){
//                                            System.out.println(example.get(i)+" ");
//                                        }
                                        programCardService p = new programCardService(createCardProgrammingParameters());
                                        p.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
                                        {
                                            @Override 
                                            public void handle(WorkerStateEvent event)
                                            {
                                                try
                                                {
                                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/simwriting/Views/WritingResultsDialogView.fxml"));
                                                    Parent parent = fxmlLoader.load();
                                                    WritingResultsDialogController writingResultsDialogController = fxmlLoader.getController();
                                                    boolean successPysim = true;
                                                    ArrayList<String> results = (ArrayList<String>) event.getSource().getValue();
                                                    String arr = "";
                                                    for(int i=0;i<results.size();++i)
                                                    {
                                                        arr += results.get(i) +"\n";
                                                        if(successPysim)
                                                        {
                                                            if(results.get(i).toLowerCase().contains("programming failed")) 
                                                            {
                                                                successPysim = false;
                                                                writingResultsDialogController.resultsLabel.setText("Programming Failed");
                                                                writingResultsDialogController.resultsImg.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon6.png")));
                                                            }
                                                        }
                                                    }

                                                    writingResultsDialogController.resultsText.setText(arr);
                                                    if(!sqnChk.isSelected())
                                                    {
                                                        stage1.close();
                                                        Scene scene = new Scene(parent);
                                                        Stage stage = new Stage();
                                                        stage.initModality(Modality.APPLICATION_MODAL);
                                                        stage.resizableProperty().setValue(Boolean.FALSE);
                                                        stage.setScene(scene);
                                                        stage.showAndWait();
                                                    }
                                                    else
                                                    {
                                                        if(successPysim)
                                                        {
                                                            ArrayList<String> parameters = new ArrayList<>();
                                                            parameters.add("python3");
//                                                            String directory = System.getProperty("user.dir");
//                                                            parameters.add(directory+"/src/simwriting/programmingTools/sysmo-usim-tool/sysmo-usim-tool.sjs1.py");
                                                            
                                                            String directory = System.getProperty("user.home");
                                                            parameters.add(directory+"/sysmo-usim-tool/sysmo-usim-tool.sjs1.py");
                                                            parameters.add("-f");
                                                            parameters.add("--adm1");
                                                            parameters.add(admpinInput.getText());
                                                            parameters.add("-S");

                                                            String sqnValue = sqnInput.getText();
                                                            int loop = 12 - sqnValue.length();       
                                                            for(int j=0;j<loop;++j){
                                                                sqnValue = "0"+sqnValue;
                                                            }
                                                            parameters.add(sqnValue);

                                                            sqnService sqnservice = new sqnService(parameters);
                                                            sqnservice.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                                                            {
                                                                @Override
                                                                public void handle(WorkerStateEvent e)
                                                                {
                                                                    stage1.close();
                                                                    ArrayList<String> rslts = (ArrayList<String>) e.getSource().getValue();
                                                                    String arr2 = "****************************************************************************************************\n\n";
                                                                    for(int i=0;i<rslts.size();++i)
                                                                    {
                                                                        arr2 += rslts.get(i) +"\n";
                                                                    }
                                                                    writingResultsDialogController.resultsText.appendText(arr2);
                                                                    Scene scene = new Scene(parent);
                                                                    Stage stage = new Stage();
                                                                    stage.initModality(Modality.APPLICATION_MODAL);
                                                                    stage.resizableProperty().setValue(Boolean.FALSE);
                                                                    stage.setScene(scene);
                                                                    stage.showAndWait();
                                                                }
                                                            });
                                                            sqnservice.start();
                                                        }
                                                        else
                                                        {
                                                            stage1.close();
                                                            Scene scene = new Scene(parent);
                                                            Stage stage = new Stage();
                                                            stage.initModality(Modality.APPLICATION_MODAL);
                                                            stage.resizableProperty().setValue(Boolean.FALSE);
                                                            stage.setScene(scene);
                                                            stage.showAndWait();
                                                        }
                                                    }

                                                } catch (IOException ex)
                                                {
                                                    Logger.getLogger(WritingResultsDialogController.class.getName()).log(Level.SEVERE, null, ex);
                                                    System.out.println("Error : "+ ex);
                                                }
                                            }
                                        });
                                        p.start();
                                    }else
                                    {
//                                        print Command line that will be used for programming sim card
//                                        ArrayList<String> example = createCardProgrammingParameters();                                        
//                                        for(int i=0;i<example.size();++i){
//                                            System.out.println(example.get(i)+" ");
//                                        }
                                        
                                        sqnService sqnservice = new sqnService(createCardProgrammingParameters());
                                        sqnservice.setOnSucceeded(new EventHandler<WorkerStateEvent>()
                                        {
                                            @Override
                                            public void handle(WorkerStateEvent e)
                                            {
                                                try {
                                                    stage1.close();
                                                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/simwriting/Views/WritingResultsDialogView.fxml"));
                                                    Parent parent = fxmlLoader.load();
                                                    WritingResultsDialogController writingResultsDialogController = fxmlLoader.getController();
                                                    
                                                    ArrayList<String> rslts = (ArrayList<String>) e.getSource().getValue();
                                                    
                                                    boolean successPysim = true;
                                                    String arr2 = "";
                                                    for(int i=0;i<rslts.size();++i)
                                                    {
                                                        arr2 += rslts.get(i) +"\n";
                                                        if(successPysim)
                                                        {
                                                            if(rslts.get(i).toLowerCase().contains("authentication failed")) 
                                                            {
                                                                successPysim = false;
                                                                writingResultsDialogController.resultsLabel.setText("Programming Failed");
                                                                writingResultsDialogController.resultsImg.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon6.png")));
                                                            }
                                                        }
                                                    }
                                                    
                                                    writingResultsDialogController.resultsText.appendText(arr2);
                                               
                                                    Scene scene = new Scene(parent);
                                                    Stage stage = new Stage();
                                                    stage.initModality(Modality.APPLICATION_MODAL);
                                                    stage.resizableProperty().setValue(Boolean.FALSE);
                                                    stage.setScene(scene);
                                                    stage.showAndWait();
                                                } catch (IOException ex) {
                                                    Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        });
                                        sqnservice.start();
                                        
                                    }                                        
                                }
                            }
                        });
                        detectCards.start();
                    } catch (IOException ex) {
                        Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            confirmStage.initModality(Modality.APPLICATION_MODAL);
            confirmStage.resizableProperty().setValue(Boolean.FALSE);
            confirmStage.setScene(confirmScene);
            confirmStage.showAndWait();    
        }
    }
    
    @FXML
    void save(ActionEvent event) throws IOException 
    {      
        ArrayList<String> allValues = getAllValues();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        
        File file = fileChooser.showSaveDialog(readerCbox.getScene().getWindow());
        if(file != null)
        {
            
            if(!file.getName().endsWith(".txt")) {
                file = new File(file.getAbsolutePath() + ".txt");
            }
            PrintWriter printWriter = new PrintWriter(file);
            for(int i=0; i<allValues.size();++i)
            {
                 printWriter.write(allValues.get(i)+"\n");
            }
            printWriter.close();
        }
    }
    
    @FXML
    void load(ActionEvent event) throws FileNotFoundException 
    {
        ArrayList<String> parameters = new ArrayList<>();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(readerCbox.getScene().getWindow());       
        
        if(file != null)
        {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine())
            {
                parameters.add(scanner.nextLine());
            }
            for(int i=0;i<parameters.size();++i)
            {
                String[] parameterValue = parameters.get(i).split(":");

                if(parameterValue[0].equals("-a")) admpinInput.setText(parameterValue[1]);
                if(parameterValue[0].equals("-t") && !fineTune)
                {
                    typeChk.setSelected(false);                    
                    typeInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-n") && !fineTune)
                {
                    nameChk.setSelected(false);
                    nameInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-c") && !fineTune)
                {
                    ccChk.setSelected(false);
                    ccInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-x") && !fineTune)
                {
                    mccChk.setSelected(false);
                    mccInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-y") && !fineTune)
                {
                    mncChk.setSelected(false);
                    mncInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-m") && !fineTune) 
                {
                    smscChk.setSelected(false);
                    smscInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-M") && !fineTune) 
                {
                    smspChk.setSelected(false);
                    smspInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-n") && !fineTune) 
                {
                    nameChk.setSelected(false);
                    nameInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-s")) 
                {
                    if(!fineTune){
                        iccidChk.setSelected(false);
                        iccidInput.setText(parameterValue[1]); 
                    }else{
                        iccidChk.setSelected(true);
                        iccidInput.setText(parameterValue[1]); 
                    }    
                }
                if(parameterValue[0].equals("-i")) 
                {
                    if(!fineTune){
                        imsiChk.setSelected(false);
                        imsiInput.setText(parameterValue[1]);
                    }else{
                        imsiChk.setSelected(true);
                        imsiInput.setText(parameterValue[1]);
                    }         
                }
                if(parameterValue[0].equals("-k")) 
                {
                    if(!fineTune){
                        kiChk.setSelected(false);
                        kiInput.setText(parameterValue[1]); 
                    }else{
                        kiChk.setSelected(true);
                        kiInput.setText(parameterValue[1]);
                    }   
                }
                if(parameterValue[0].equals("-o")) 
                {
                    if(!fineTune){
                        opcChk.setSelected(false);
                        opcInput.setText(parameterValue[1]);
                    }else{
                        opcChk.setSelected(true);
                        opcInput.setText(parameterValue[1]);
                    }   
                }
                if(parameterValue[0].equals("-z") && !fineTune) 
                {
                    strChk.setSelected(true);
                    strInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-j") && !fineTune) 
                {
                    numChk.setSelected(true);
                    numInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-b") && !fineTune) {
                    baudrateChk.setSelected(false);
                    baudrateCbox.setValue(parameterValue[1]);
                }
//                if(parameterValue[0].equals("--op")){
//                    if(!fineTune){
//                       opInput.setText(parameterValue[1]); 
//                    }else{
//                        opChk.setSelected(true);
//                        opInput.setText(parameterValue[1]);
//                    }
//                }
                if(parameterValue[0].equals("--op")) 
                {
                    if(!fineTune){
                        opChk.setSelected(false);
                        opInput.setText(parameterValue[1]);
                    }else{
                        opChk.setSelected(true);
                        opInput.setText(parameterValue[1]);
                    }   
                }
                if(parameterValue[0].equals("--acc") && !fineTune) 
                {
                    accChk.setSelected(false);
                    accInput.setText(parameterValue[1]);
                }
                if(parameterValue[0].equals("-e") && !fineTune)
                {
                    if(parameterValue[1].equals("True"))
                    {
                        eraseChk.setSelected(false);
                        eraseTrueRad.setSelected(true);
                    }
                }
                if(parameterValue[0].equals("-sqn")) 
                {
                    sqnChk.setSelected(true);
                    sqnInput.setText(parameterValue[1]);
                }
            }
        }
    }
    
    @FXML
    void readerCboxChange(ActionEvent event) 
    {
        readerCbox.getStyleClass().removeAll(Collections.singleton("error")); 
        readerCbox.setTooltip(null);
        readerError.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {    
        initialiazeValues();
        
        detectCardService detectCards = new detectCardService();
        detectCards.setOnSucceeded(new EventHandler<WorkerStateEvent>() 
        {
            @Override
            public void handle(WorkerStateEvent event) 
            {
                ArrayList<String> cards = (ArrayList<String>) event.getSource().getValue();
                readerCbox.setItems(FXCollections.observableArrayList(cards));             
                if(cards.isEmpty())
                {
                    simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon2.png")));
                }
                else
                {
                     simCardImageView.setImage(new Image(getClass().getResourceAsStream("/simwriting/Icons/icon1.png")));        
                }
            }
        });
        detectCards.start();
    }    
    
    private void initialiazeValues()
    {
        
        //Add reader tooltip when hovering over reader selection field
        final Tooltip readerHintTooltip = new Tooltip("Select which reader to read/write. If no reader is available, please insert card & click the refresh icon.");
        readerHintTooltip.getStyleClass().add("tooltip-hint");
        readerCbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                readerHintTooltip.show(readerCbox, x+10, y+20);
            }
        });
        readerCbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                readerHintTooltip.hide();
            }
        });    

        //remove validation error notice everytime that textfield changes
        admpinInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {          
            admpinInput.getStyleClass().removeAll(Collections.singleton("error")); 
            admpinInput.setTooltip(null);
            AdmpinError.setVisible(false);
        });
        //Add iccid tooltip when hovering over input field
        final Tooltip admpinHintTooltip = new Tooltip("Administrative Unlock Key\n   - Is an administrative key that allows you to program or edit sim card parameters\n   - ADM PIN must be exactly 8 digits\n   - Card will block after 3 incorrect attempt");
        admpinHintTooltip.getStyleClass().add("tooltip-hint");
        admpinInput.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                admpinHintTooltip.show(admpinInput, x+10, y+20);
            }
        });
        admpinInput.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                admpinHintTooltip.hide();
            }
        });
        //restricting adm pin to number only
        admpinInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            admpinInput.getStyleClass().removeAll(Collections.singleton("error")); 
            admpinInput.setTooltip(null);
            AdmpinError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                admpinInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        
        iccidChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                iccidInput.getStyleClass().removeAll(Collections.singleton("error")); 
                iccidInput.setTooltip(null);
                iccidError.setVisible(false);
                if(newValue)
                {
                    iccidInput.setDisable(true);
                    iccidInput.setText("");
                }
                else
                {
                    iccidInput.setDisable(false);
                    iccidInput.setText("");
                }
            }
        });
        //restricting iccid to number only
        iccidInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            iccidInput.getStyleClass().removeAll(Collections.singleton("error")); 
            iccidInput.setTooltip(null);
            iccidError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                iccidInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add iccid tooltip when hovering over input field
        final Tooltip iccidHintTooltip = new Tooltip("Integrated Circuit Card Identifire (ICCID)\n   - Is a global unique serial number that identifies the sim card itself\n   - ICCID must be 19 or 20 digits!");
        iccidHintTooltip.getStyleClass().add("tooltip-hint");
        iccidHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                iccidHintTooltip.show(iccidInput, x+10, y+20);
            }
        });
        iccidHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                iccidHintTooltip.hide();
            }
        });    
        
        imsiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                imsiInput.getStyleClass().removeAll(Collections.singleton("error")); 
                imsiInput.setTooltip(null);
                imsiError.setVisible(false);
                if(newValue)
                {
                    imsiInput.setDisable(true);
                    imsiInput.setText("");
                }
                else
                {
                    imsiInput.setDisable(false);
                    imsiInput.setText("");
                }
            }
        });      
        //restricting imsi to number only
        imsiInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            imsiInput.getStyleClass().removeAll(Collections.singleton("error")); 
            imsiInput.setTooltip(null);
            imsiError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                imsiInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add imsi tooltip when hovering over input field
        final Tooltip imsiHintTooltip = new Tooltip("International Mobile Subscriber Identity (IMSI)\n   - Is a unique number used to identify a subscriber/user in a cellular network\n   - IMSI must be 15 digits\n");
        imsiHintTooltip.getStyleClass().add("tooltip-hint");
        imsiHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                imsiHintTooltip.show(imsiInput, x+10, y+20);
            }
        });
        imsiHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                imsiHintTooltip.hide();
            }
        });   
        
        
        nameInput.setText("Magic");
        nameInput.setDisable(true);
        nameChk.setSelected(true);
        nameChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                nameInput.getStyleClass().removeAll(Collections.singleton("error")); 
                nameInput.setTooltip(null);
                nameError.setVisible(false);
                if(newValue)
                {
                    nameInput.setText("Magic");
                    nameInput.setDisable(true);
                }
                else
                {
                    nameInput.setDisable(false);
                    nameInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        nameInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            nameInput.getStyleClass().removeAll(Collections.singleton("error")); 
            nameInput.setTooltip(null);
            nameError.setVisible(false);
        });
        //Add name tooltip when hovering over input field
        final Tooltip nameHintTooltip = new Tooltip("Service Provider Name (SPN)\n   - Name of the network operator\n   - Default name is Magic!\n");
        nameHintTooltip.getStyleClass().add("tooltip-hint");
        nameHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                nameHintTooltip.show(nameInput, x+10, y+20);
            }
        });
        nameHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                nameHintTooltip.hide();
            }
        });   
        
        ccInput.setText("1");
        ccInput.setDisable(true);
        ccChk.setSelected(true);
        ccChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                ccInput.getStyleClass().removeAll(Collections.singleton("error")); 
                ccInput.setTooltip(null);
                ccError.setVisible(false);
                if(newValue)
                {
                    ccInput.setText("1");
                    ccInput.setDisable(true);
                }
                else
                {
                    ccInput.setDisable(false);
                    ccInput.setText("");
                }
            }
        });
        //restricting cc to number only
        ccInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            ccInput.getStyleClass().removeAll(Collections.singleton("error")); 
            ccInput.setTooltip(null);
            ccError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                ccInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add CC tooltip when hovering over input field
        final Tooltip ccHintTooltip = new Tooltip("Country Code (CC)\n   - Identifies geographic region of the SIM card\n   - CC must be between 1-3 digits!\n");
        ccHintTooltip.getStyleClass().add("tooltip-hint");
        ccHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                ccHintTooltip.show(ccInput, x+10, y+20);
            }
        });
        ccHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ccHintTooltip.hide();
            }
        }); 
        
        typeInput.setDisable(true);
        typeChk.setSelected(true);
        typeChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                typeInput.getStyleClass().removeAll(Collections.singleton("error")); 
                typeInput.setTooltip(null);
                typeError.setVisible(false);
                if(newValue)
                {
                    typeInput.setText("");
                    typeInput.setDisable(true);
                }
                else
                {
                    typeInput.setDisable(false);
                    typeInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        typeInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            typeInput.getStyleClass().removeAll(Collections.singleton("error")); 
            typeInput.setTooltip(null);
            typeError.setVisible(false);
        });
        //Add type tooltip when hovering over input field
        final Tooltip typeHintTooltip = new Tooltip("Card type\n   - e.g sysmoUSIM-SJS1, magicsim, OpenCells-SIM, etc\n");
        typeHintTooltip.getStyleClass().add("tooltip-hint");
        typeHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                typeHintTooltip.show(typeInput, x+10, y+20);
            }
        });
        typeHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                typeHintTooltip.hide();
            }
        }); 
        
        mccInput.setText("901");
        mccInput.setDisable(true);
        mccChk.setSelected(true);
        mccChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                mccInput.getStyleClass().removeAll(Collections.singleton("error")); 
                mccInput.setTooltip(null);
                mccError.setVisible(false);
                if(newValue)
                {
                    mccInput.setText("901");
                    mccInput.setDisable(true);
                }
                else
                {
                    mccInput.setDisable(false);
                    mccInput.setText("");
                }
            }
        });
        //restricting mcc to number only
        mccInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            mccInput.getStyleClass().removeAll(Collections.singleton("error")); 
            mccInput.setTooltip(null);
            mccError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                mccInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add mcc tooltip when hovering over input field
        final Tooltip mccHintTooltip = new Tooltip("Mobile Country Code (MCC)\n   - Identifies geographic region of the SIM card\n   - MCC must be between 1-3 digits!\n");
        mccHintTooltip.getStyleClass().add("tooltip-hint");
        mccHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                mccHintTooltip.show(mccInput, x+10, y+20);
            }
        });
        mccHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mccHintTooltip.hide();
            }
        }); 
        
        ObservableList<Integer> baudrate = FXCollections.observableArrayList(50,75,110,134,150,200,300,600,1200,1800,2400,4800,9600,19200,28800,38400,57600,76800,115200,230400,460800,576000,921600);
        baudrateCbox.setItems(baudrate);
        baudrateCbox.getSelectionModel().select(12);
        baudrateCbox.setDisable(true);
        baudrateChk.setSelected(true);
        baudrateChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                if(newValue)
                {
                    baudrateCbox.getSelectionModel().select(12);
                    baudrateCbox.setDisable(true);
                }
                else
                {
                    baudrateCbox.setDisable(false);
                    baudrateCbox.getSelectionModel().select(12);
                }
            }
        });
        //Add baudrate tooltip when hovering over input field
        final Tooltip baudHintTooltip = new Tooltip("Baudrate\n   - Select baudrate used for SIM access!\n");
        baudHintTooltip.getStyleClass().add("tooltip-hint");
        BaudrateHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                baudHintTooltip.show(baudrateCbox, x+10, y+20);
            }
        });
        BaudrateHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                baudHintTooltip.hide();
            }
        }); 
        
        mncInput.setText("55");
        mncInput.setDisable(true);
        mncChk.setSelected(true);
        mncChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                mncInput.getStyleClass().removeAll(Collections.singleton("error")); 
                mncInput.setTooltip(null);
                mncError.setVisible(false);
                if(newValue)
                {
                    mncInput.setText("55");
                    mncInput.setDisable(true);
                }
                else
                {
                    mncInput.setDisable(false);
                    mncInput.setText("");
                }
            }
        });
        //restricting mnc to number only
        mncInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            mncInput.getStyleClass().removeAll(Collections.singleton("error")); 
            mncInput.setTooltip(null);
            mncError.setVisible(false);
            if (!newValue.matches("\\d*")) 
            {
                mncInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add mnc tooltip when hovering over input field
        final Tooltip mncHintTooltip = new Tooltip("Mobile Network Code (MNC)\n   - Identifies the operator\n   - MNC must be between 1-3 digits!\n");
        mncHintTooltip.getStyleClass().add("tooltip-hint");
        mncHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                mncHintTooltip.show(mncInput, x+10, y+20);
            }
        });
        mncHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mncHintTooltip.hide();
            }
        }); 
        
        kiInput.setDisable(true);
        kiChk.setSelected(true);
        kiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                kiInput.getStyleClass().removeAll(Collections.singleton("error")); 
                kiInput.setTooltip(null);
                kiError.setVisible(false);
                if(newValue)
                {
                    kiInput.setDisable(true);
                    kiInput.setText("");
                }
                else
                {
                    kiInput.setDisable(false);
                    kiInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        kiInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            kiInput.getStyleClass().removeAll(Collections.singleton("error")); 
            kiInput.setTooltip(null);
            kiError.setVisible(false);
        });
        //Add ki tooltip when hovering over input field
        final Tooltip kiHintTooltip = new Tooltip("Subscriber Authentication Key\n   - It is used in authenticating the SIM/subscriber on the mobile network\n   - KI must be hexadecimal digits only & must be exactly 128 bits(32 hexadecimal digits long)\n   - Check randomize to randomize KI\n");
        kiHintTooltip.getStyleClass().add("tooltip-hint");
        kiHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                kiHintTooltip.show(kiInput, x+10, y+20);
            }
        });
        kiHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                kiHintTooltip.hide();
            }
        }); 
        
        smscInput.setText("{00 + CC + 5555}");
        smscInput.setDisable(true);
        smscChk.setSelected(true);
        smscChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                smscInput.getStyleClass().removeAll(Collections.singleton("error")); 
                smscInput.setTooltip(null);
                smscError.setVisible(false);
                if(newValue)
                {
                    smscInput.setDisable(true);
                    smscInput.setText("{00 + CC + 5555}");
                }
                else
                {
                    smscInput.setDisable(false);
                    smscInput.setText("");
                }
            }
        });
        //restricting smsc to number only
        smscInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            smscInput.getStyleClass().removeAll(Collections.singleton("error")); 
            smscInput.setTooltip(null);
            smscError.setVisible(false);
        });
        //Add SMSC tooltip when hovering over input field
        final Tooltip smscHintTooltip = new Tooltip("SMSC\n   - It is used to provide SMS services to subscribers, It is responsible for receiving, storing, routing and forwarding SMS messages from mobile handsets\n   - SMSC must be digits only!\n   - Start with '+' for international numbers\n");
        smscHintTooltip.getStyleClass().add("tooltip-hint");
        smscHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                smscHintTooltip.show(smscInput, x+10, y+20);
            }
        });
        smscHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                smscHintTooltip.hide();
            }
        }); 
        
        smspInput.setDisable(true);
        smspChk.setSelected(true);
        smspChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                smspInput.getStyleClass().removeAll(Collections.singleton("error")); 
                smspInput.setTooltip(null);
                smspError.setVisible(false);
                if(newValue)
                {
                    smspInput.setDisable(true);
                    smspInput.setText("");
                }
                else
                {
                    smspInput.setDisable(false);
                    smspInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        smspInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            smspInput.getStyleClass().removeAll(Collections.singleton("error")); 
            smspInput.setTooltip(null);
            smspError.setVisible(false);
        });
        //Add SMSP tooltip when hovering over input field
        final Tooltip smspHintTooltip = new Tooltip("SMSP\n   -  Used for SMS purposes\n   - SMSP must be hexadecimal digits only & must be at least 28 bytes(56 hexadecimal digits long)\n   - Check Autogen for SMSP to be auto generated from SMSC");
        smspHintTooltip.getStyleClass().add("tooltip-hint");
        smspHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                smspHintTooltip.show(smspInput, x+10, y+20);
            }
        });
        smspHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                smspHintTooltip.hide();
            }
        }); 
        
        opInput.setDisable(true);
        opChk.setSelected(true);
       
//        opChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//        {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//            {
////                opInput.getStyleClass().removeAll(Collections.singleton("error")); 
////                opInput.setTooltip(null);
////                opError.setVisible(false);
////                if(newValue)
////                {
////                    opInput.setText("");
////                    opInput.setDisable(true);
////                    opcInput.setText("");
////                    opcInput.setDisable(false);
////                    opcChk.setSelected(false);
////                }
////                else
////                {
////                    opInput.setDisable(false);
////                    opInput.setText("");
////                    opcInput.setText("");
////                    opcInput.setDisable(true);
////                    opcChk.setSelected(true);
////                }
//            }
//        });
        //remove validation error notice everytime that textfield changes
        opInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            opInput.getStyleClass().removeAll(Collections.singleton("error")); 
            opInput.setTooltip(null);
            opError.setVisible(false);
        });
        //Add OP tooltip when hovering over input field
        final Tooltip opHintTooltip = new Tooltip("Operator Code (OP)\n   - Is a unique number assigned to every telecommunication operator\n   - OP must be hexadecimal digits only & must be exactly 128 bits(32 hexadecimal digits long) \n");
        opHintTooltip.getStyleClass().add("tooltip-hint");
        opHbox2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                opHintTooltip.show(opHbox2, x+10, y+20);
            }
        });
        opHbox2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                opHintTooltip.hide();
            }
        });
        
//        opcInput.setDisable(true);
//        opcChk.setSelected(true);
        
//        opcChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//        {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//            {
//                opcInput.getStyleClass().removeAll(Collections.singleton("error")); 
//                opcInput.setTooltip(null);
//                opcError.setVisible(false);
//                if(newValue)
//                {
//                    opInput.setDisable(false);
//                    opInput.setText("");
//                    opChk.setSelected(false);
//                    opcInput.setText("");
//                    opcInput.setDisable(true);
//                }
//                else
//                {
//                    opcInput.setDisable(false);
//                    opcInput.setText("");
//                    opInput.setDisable(true);
//                    opInput.setText("");
//                    opChk.setSelected(true);
//                }
//            }
//        });
        //remove validation error notice everytime that textfield changes
        opcInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            opcInput.getStyleClass().removeAll(Collections.singleton("error")); 
            opcInput.setTooltip(null);
            opcError.setVisible(false);
        });
        //Add OPC tooltip when hovering over input field
        final Tooltip opcHintTooltip = new Tooltip("Encrypted Operator Code\n   - OPC must be hexadecimal digits only & must be exactly 128 bits(32 hexadecimal digits long)\n   - Check randomize to randomize OPC!\n");
        opcHintTooltip.getStyleClass().add("tooltip-hint");
        opcHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                opcHintTooltip.show(opcInput, x+10, y+20);
            }
        });
        opcHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                opcHintTooltip.hide();
            }
        }); 
        
        
        
        
        accInput.setDisable(true);
        accChk.setSelected(true);
        accChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                accInput.getStyleClass().removeAll(Collections.singleton("error")); 
                accInput.setTooltip(null);
                accError.setVisible(false);
                if(newValue)
                {
                    accInput.setText("");
                    accInput.setDisable(true);
                }
                else
                {
                    accInput.setDisable(false);
                    accInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        accInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            accInput.getStyleClass().removeAll(Collections.singleton("error")); 
            accInput.setTooltip(null);
            accError.setVisible(false);
        });
        //Add ACC tooltip when hovering over input field
        final Tooltip accHintTooltip = new Tooltip("Access Control Code (ACC)\n   - Determines the access control class of the subscriber.\n   - Must be hexadecimal digits only & must be exactly 2 bytes(4 hexadecimal digits long)");
        accHintTooltip.getStyleClass().add("tooltip-hint");
        accHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                accHintTooltip.show(accInput, x+10, y+20);
            }
        });
        accHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                accHintTooltip.hide();
            }
        }); 
        
        numInput.setDisable(true);
        numChk.setSelected(false);
        numChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                numInput.getStyleClass().removeAll(Collections.singleton("error")); 
                numInput.setTooltip(null);
                numError.setVisible(false);
                numInput.setPromptText("");
                if(!newValue)
                {
                    numInput.setText("");
                    numInput.setDisable(true);
                }
                else
                {
                    numInput.setDisable(false);
                    numInput.setText("");
                }
            }
        });
        //restricting num to number only
        numInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            numInput.getStyleClass().removeAll(Collections.singleton("error")); 
            numInput.setTooltip(null);
            numError.setVisible(false);
            numInput.setPromptText("");
            if (!newValue.matches("\\d*")) 
            {
                numInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add NUM tooltip when hovering over input field
        final Tooltip numHintTooltip = new Tooltip("NUM\n   - Card # used for ICCID/IMSI autogen\n   - If either IMSI or ICCID isn't specified, NUM is required!");
        numHintTooltip.getStyleClass().add("tooltip-hint");
        numHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                numHintTooltip.show(numInput, x+10, y+20);
            }
        });
        numHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                numHintTooltip.hide();
            }
        }); 

        strInput.setDisable(true);
        strChk.setSelected(false);
        strChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                strInput.getStyleClass().removeAll(Collections.singleton("error")); 
                strInput.setTooltip(null);
                strError.setVisible(false);
                if(!newValue)
                {
                    strInput.setText("");
                    strInput.setDisable(true);
                }
                else
                {
                    strInput.setDisable(false);
                    strInput.setText("");
                }
            }
        });
        //remove validation error notice everytime that textfield changes
        strInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            strInput.getStyleClass().removeAll(Collections.singleton("error")); 
            strInput.setTooltip(null);
            strError.setVisible(false);
        });
        //Add STR tooltip when hovering over input field
        final Tooltip strHintTooltip = new Tooltip("STR\n   - Secret used for ICCID/IMSI autogen\n");
        strHintTooltip.getStyleClass().add("tooltip-hint");
        strHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                strHintTooltip.show(strInput, x+10, y+20);
            }
        });
        strHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                strHintTooltip.hide();
            }
        }); 
        
        
        sqnInput.setDisable(true);
        sqnChk.setSelected(false);
        sqnChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
                sqnInput.setTooltip(null);
                sqnError.setVisible(false);
                if(!newValue)
                {
                    sqnInput.setText("");
                    sqnInput.setDisable(true);
                }
                else
                {
                    sqnInput.setDisable(false);
                    sqnInput.setText("");
                }
            }
        });
        //restricting sqn to number only
        sqnInput.textProperty().addListener((observable, oldValue, newValue) -> 
        {
            sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
            sqnInput.setTooltip(null);
            sqnError.setVisible(false);
            if (!newValue.matches("\\d*")) {
                sqnInput.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        //Add SQN tooltip when hovering over input field
        final Tooltip sqnHintTooltip = new Tooltip("Sequence Number (SQN)\n   - SQN must be between 1-12 digits!\n");
        sqnHintTooltip.getStyleClass().add("tooltip-hint");
        sqnHbox.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                com.sun.glass.ui.Robot robot = com.sun.glass.ui.Application.GetApplication().createRobot();
                int y = robot.getMouseY();
                int x = robot.getMouseX();
                sqnHintTooltip.show(sqnInput, x+10, y+20);
            }
        });
        sqnHbox.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sqnHintTooltip.hide();
            }
        }); 
        
        batchLabel.setDisable(true);
        batchLabel2.setDisable(true);
        batchTg.selectToggle(null);
        batchFalseRad.setDisable(true);
        batchTrueRad.setDisable(true);
        batchChk.setDisable(true);
//        batchChk.setSelected(true);
//        batchChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//        {
//            @Override
//            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//            {
//                if(newValue)
//                {
//                   batchFalseRad.setDisable(true);
//                    batchTrueRad.setDisable(true);
//                    batchTg.selectToggle(batchFalseRad);
//                }else
//                {
//                    batchFalseRad.setDisable(false);
//                    batchTrueRad.setDisable(false);
//                }
//            }
//        });
        
        eraseTg.selectToggle(eraseFalseRad);
        eraseFalseRad.setDisable(true);
        eraseTrueRad.setDisable(true);
        eraseChk.setSelected(true);
        eraseChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
            {
                if(newValue)
                {
                    eraseFalseRad.setDisable(true);
                    eraseTrueRad.setDisable(true);
                    eraseTg.selectToggle(eraseFalseRad);
                }
                else
                {
                    eraseFalseRad.setDisable(false);
                    eraseTrueRad.setDisable(false);
                }
            }
        });
        
        opcListener = new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                opcInput.getStyleClass().removeAll(Collections.singleton("error")); 
                opcInput.setTooltip(null);
                opcError.setVisible(false);
                if(newValue)
                {
                    opInput.setDisable(false);
                    opInput.setText("");
                    opChk.setSelected(false);
                    opcInput.setText("");
                    opcInput.setDisable(true);
                }
                else
                {
                    opcInput.setDisable(false);
                    opcInput.setText("");
                    opInput.setDisable(true);
                    opInput.setText("");
                    opChk.setSelected(true);
                }
            }
        };
       opcChk.selectedProperty().addListener(opcListener);
        
        opcFineTuneListener = new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                    opcInput.setDisable(true);
                    opcInput.setText("");
                }
                else
                {
                    opcInput.setDisable(false);
                    opcInput.setText("");
                }
            }
        };
        
        opListener = new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                opInput.getStyleClass().removeAll(Collections.singleton("error")); 
                opInput.setTooltip(null);
                opError.setVisible(false);
                if(newValue)
                {
                    opInput.setText("");
                    opInput.setDisable(true);
                    opcInput.setText("");
                    opcInput.setDisable(false);
                    opcChk.setSelected(false);
                }
                else
                {
                    opInput.setDisable(false);
                    opInput.setText("");
                    opcInput.setText("");
                    opcInput.setDisable(true);
                    opcChk.setSelected(true);
                }
            }
        };
        opChk.selectedProperty().addListener(opListener);
        
        opFineTuneListener = new ChangeListener<Boolean>()
        {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue)
                {
                    opInput.setDisable(true);
                    opInput.setText("");
                }
                else
                {
                    opInput.setDisable(false);
                    opInput.setText("");
                }
            }
        };
        
    }
    
    private void validation()
    {
        validEntries = true;
        
        //Validate if reader is selected
        if(readerCbox.getValue() == null)
        {
            readerError.setVisible(true);
            
            FadeTransition fade = new FadeTransition();
            fade.setNode(readerError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();

            ObservableList<String> styleClass = readerCbox.getStyleClass();
            styleClass.add("error");
            validEntries = false;
        }
        
        //Validate if ADM PIN has = 8 digits
        int admpinLength = admpinInput.getText().length();
        ObservableList<String> styleClassAdmpin = admpinInput.getStyleClass();
        if(admpinLength != 8)
        {
            styleClassAdmpin.add("error");
            AdmpinError.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setNode(AdmpinError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();
            validEntries = false;
        }

        //Validate if ICCID has 19 or 20 digits
        if((!fineTune && !iccidChk.isSelected()) || (fineTune && iccidChk.isSelected()))
        {
            int iccidLength = iccidInput.getText().length();
            ObservableList<String> styleClass = iccidInput.getStyleClass();
            if(iccidLength != 19 && iccidLength != 20)
            {
                styleClass.add("error");
                iccidError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(iccidError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if IMSI has any digit
        if((!fineTune && !imsiChk.isSelected()) || (fineTune && imsiChk.isSelected()))
        {
            int imsiLength = imsiInput.getText().length();
            ObservableList<String> styleClass = imsiInput.getStyleClass();
            if(imsiLength != 15)
            {
                styleClass.add("error");
                imsiError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(imsiError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if CC has 1-3 digits
        if(!ccChk.isSelected() && !fineTune)
        {
            int ccLength = ccInput.getText().length();
            ObservableList<String> styleClass = ccInput.getStyleClass();
            if(ccLength < 1 || ccLength > 3)
            {
                styleClass.add("error");
                ccError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(ccError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if MCC has 1-3 digits
        if(!mccChk.isSelected() && !fineTune)
        {
            int mccLength = mccInput.getText().length();
            ObservableList<String> styleClass = mccInput.getStyleClass();
            if(mccLength < 1 || mccLength > 3)
            {
                styleClass.add("error");
                mccError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(mccError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if MNC has 1-3 digits
        if(!mncChk.isSelected() && !fineTune)
        {
            int mncLength = mncInput.getText().length();
            ObservableList<String> styleClass = mncInput.getStyleClass();
            if(mncLength < 1 || mncLength > 3)
            {
                styleClass.add("error");
                mncError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(mncError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if SMSC has digits only
        if(!smscChk.isSelected() && !fineTune)
        {
            int smscLength = smscInput.getText().length();
            ObservableList<String> styleClass = smscInput.getStyleClass();
            if(smscLength==0)
            {
                styleClass.add("error");
                smscError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(smscError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
            if(smscLength==1 && (smscInput.getText().equals("+") || smscInput.getText().equals("-")))
            {
                styleClass.add("error");
                smscError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(smscError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
            if(smscLength>1)
            {
                String temp =  smscInput.getText();
                if(smscInput.getText().charAt(0)=='+') temp = temp.substring(1);
                
                if(smscInput.getText().charAt(0)=='-')
                {
                    styleClass.add("error");
                    smscError.setVisible(true);
                    FadeTransition fade = new FadeTransition();
                    fade.setNode(smscError);
                    fade.setDuration(Duration.millis(500));
                    fade.setCycleCount(TranslateTransition.INDEFINITE);
                    fade.setInterpolator(Interpolator.LINEAR);
                    fade.setFromValue(1);
                    fade.setToValue(0.1);
                    fade.setCycleCount(16);
                    fade.setAutoReverse(true);
                    fade.play();
//                    smscInput.setTooltip(smscTooltip);
                    validEntries = false;
                }
                if(smscInput.getText().charAt(0)=='+' && (smscInput.getText().charAt(1)=='+' || smscInput.getText().charAt(1)=='-'))
                {
                    styleClass.add("error");
                    smscError.setVisible(true);
                    FadeTransition fade = new FadeTransition();
                    fade.setNode(smscError);
                    fade.setDuration(Duration.millis(500));
                    fade.setCycleCount(TranslateTransition.INDEFINITE);
                    fade.setInterpolator(Interpolator.LINEAR);
                    fade.setFromValue(1);
                    fade.setToValue(0.1);
                    fade.setCycleCount(16);
                    fade.setAutoReverse(true);
                    fade.play();
//                    smscInput.setTooltip(smscTooltip);
                    validEntries = false;                  
                }
                else
                {
                    try
                    {
                        BigInteger x = new BigInteger(temp);
                    }
                    catch(NumberFormatException e)
                    {
                        styleClass.add("error");
                        smscError.setVisible(true);
                        FadeTransition fade = new FadeTransition();
                        fade.setNode(smscError);
                        fade.setDuration(Duration.millis(500));
                        fade.setCycleCount(TranslateTransition.INDEFINITE);
                        fade.setInterpolator(Interpolator.LINEAR);
                        fade.setFromValue(1);
                        fade.setToValue(0.1);
                        fade.setCycleCount(16);
                        fade.setAutoReverse(true);
                        fade.play();
//                        smscInput.setTooltip(smscTooltip);
                        validEntries = false;
                        System.out.print("Error : "+e);
                    }
                }
            }
        }
        
        //Validate if SMSP is not empty if default checkbox is not ticked
        if(!smspChk.isSelected() && !fineTune)
        {
            int smspLength = smspInput.getText().length();
            ObservableList<String> styleClass = smspInput.getStyleClass();
            if(smspLength == 0)
            {
                styleClass.add("error");
                smspError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(smspError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if SMSP is in hex & is exactly 128 bits(32 characters) 
        if(!smspChk.isSelected() && !smspInput.getText().isEmpty() && !fineTune)
        {
            ObservableList<String> styleClass = smspInput.getStyleClass();
            int smspLength = smspInput.getText().length();
            if(!checkHex(smspInput.getText().toUpperCase()) || smspLength<56)
            {
                styleClass.add("error");
                smspError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(smspError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if OPC is not empty if default checkbox is not ticked
        if((!fineTune && !opcChk.isSelected()) || (fineTune && opcChk.isSelected()))
        {
            int opcLength = opcInput.getText().length();
            ObservableList<String> styleClass = opcInput.getStyleClass();
            if(opcLength == 0)
            {
                styleClass.add("error");
                opcError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(opcError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if OPC is in hex & is exactly 128 bits(32 characters) 
        if((!fineTune && !opcChk.isSelected() && !opcInput.getText().isEmpty()) || (fineTune && opcChk.isSelected() && !opcInput.getText().isEmpty()))
        {
            ObservableList<String> styleClass = opcInput.getStyleClass();
            int opcLength = opcInput.getText().length();
            if(!checkHex(opcInput.getText().toUpperCase()) || opcLength!=32)
            {
                styleClass.add("error");
                opcError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(opcError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        if((!fineTune && !opChk.isSelected()) || (fineTune && opChk.isSelected()))
        {
            //Validate if OP is not empty if default checkbox is not ticked    
            int opLength1 = opInput.getText().length();
            ObservableList<String> styleClass1 = opInput.getStyleClass();
            if(opLength1 == 0)
            {
                styleClass1.add("error");
                opError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(opError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }

            //Validate if OP is in hex & is exactly 128 bits(32 characters)       
            ObservableList<String> styleClass2 = opInput.getStyleClass();
            int opLength2 = opInput.getText().length();
            if(!checkHex(opInput.getText().toUpperCase()) || opLength2!=32)
            {
                styleClass2.add("error");
                opError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(opError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
            
        }
        
       
        
        //Validate if STR is not empty if default checkbox is not ticked
        if(strChk.isSelected() && !fineTune)
        {
            int strLength = strInput.getText().length();
            ObservableList<String> styleClass = strInput.getStyleClass();
            if(strLength == 0)
            {
                styleClass.add("error");
                strError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(strError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if NUM has any digit
        if(numChk.isSelected() && !fineTune)
        {
            int numLength = numInput.getText().length();
            ObservableList<String> styleClass = numInput.getStyleClass();
            if(numLength == 0)
            {
                styleClass.add("error");
                numError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(numError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //validate if NUM is not empty if imsi/iccid is not provided
        if(!numChk.isSelected() && (iccidChk.isSelected() || imsiChk.isSelected()) && !fineTune)
        {
            numInput.setDisable(false);
            numChk.setSelected(true);
            numInput.setPromptText("Required if IMSI or ICCID isn't specified");
            ObservableList<String> styleClass = numInput.getStyleClass();
            styleClass.add("error");
            numError.setVisible(true);
            FadeTransition fade = new FadeTransition();
            fade.setNode(numError);
            fade.setDuration(Duration.millis(500));
            fade.setCycleCount(TranslateTransition.INDEFINITE);
            fade.setInterpolator(Interpolator.LINEAR);
            fade.setFromValue(1);
            fade.setToValue(0.1);
            fade.setCycleCount(16);
            fade.setAutoReverse(true);
            fade.play();
            validEntries = false;
        }
        
        //Validate if Name is not empty if default checkbox is not ticked
        if(!nameChk.isSelected() && !fineTune)
        {
            int nameLength = nameInput.getText().length();
            ObservableList<String> styleClass = nameInput.getStyleClass();
            if(nameLength == 0)
            {
                styleClass.add("error");
                nameError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(nameError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if Type is not empty if default checkbox is not ticked
        if(!typeChk.isSelected() && !fineTune)
        {
            int typeLength = typeInput.getText().length();
            ObservableList<String> styleClass = typeInput.getStyleClass();
            if(typeLength == 0)
            {
                styleClass.add("error");
                typeError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(typeError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if KI is not empty if default checkbox is not ticked
        if((!fineTune && !kiChk.isSelected()) || (fineTune && kiChk.isSelected()) )
        {
            int kiLength = kiInput.getText().length();
            ObservableList<String> styleClass = kiInput.getStyleClass();
            if(kiLength == 0)
            {
                styleClass.add("error");
                kiError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(kiError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        //Validate if KI is in hex & is exactly 128 bits(32 characters) 
        if((!fineTune && !kiChk.isSelected() && !kiInput.getText().isEmpty()) || (fineTune && kiChk.isSelected() && !kiInput.getText().isEmpty())  )
        {
            ObservableList<String> styleClass = kiInput.getStyleClass();
            int kiLength = kiInput.getText().length();
            if(!checkHex(kiInput.getText().toUpperCase()) || kiLength!=32)
            {
                styleClass.add("error");
                kiError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(kiError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
       //Validate if acc is not empty if default checkbox is not ticked 
        if(!accChk.isSelected() && !fineTune)
        {
            int accLength = accInput.getText().length();
            ObservableList<String> styleClass = accInput.getStyleClass();
            if(accLength == 0)
            {
                styleClass.add("error");
                accError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(accError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        } 
        //Validate if acc is in hex & is exactly 2 bytes(4 characters) 
        if(!accChk.isSelected() && !accInput.getText().isEmpty() && !fineTune)
        {
            ObservableList<String> styleClass = accInput.getStyleClass();
            int accLength = accInput.getText().length();
            if(!checkHex(accInput.getText().toUpperCase()) || accLength!=4)
            {
                styleClass.add("error");
                accError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(accError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
        
        //Validate if sqn has 12 digits
        if(sqnChk.isSelected())
        {
            int sqnLength = sqnInput.getText().length();
            ObservableList<String> styleClass = sqnInput.getStyleClass();
            if(sqnLength < 1 || sqnLength > 12){
                styleClass.add("error");
                sqnError.setVisible(true);
                FadeTransition fade = new FadeTransition();
                fade.setNode(sqnError);
                fade.setDuration(Duration.millis(500));
                fade.setCycleCount(TranslateTransition.INDEFINITE);
                fade.setInterpolator(Interpolator.LINEAR);
                fade.setFromValue(1);
                fade.setToValue(0.1);
                fade.setCycleCount(16);
                fade.setAutoReverse(true);
                fade.play();
                validEntries = false;
            }
        }
    }
    
    public static Boolean checkHex(String s)
    {
        // Size of string
        int n = s.length();
        // Iterate over string
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // Check if the character
            // is invalid
            if ((ch < '0' || ch > '9') && (ch < 'A' || ch > 'F')) {
                return false;
            }
        }

        return true;
    }
    
    private ArrayList<String> createCardReadingParameters()
    {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("python3");
        String directory = System.getProperty("user.home");
        parameters.add(directory+"/pysim/pySim-read.py");

        //add which reader to use
        parameters.add("-p");
        String reader = readerCbox.getValue().toString();
        switch (reader) 
        {
            case "Reader 0":
                parameters.add("0");
                break;
            case "Reader 1":
                parameters.add("1");
                break;
            case "Reader 2":
                parameters.add("2");
                break;
        }
        
        return parameters;
    }
    
    private ArrayList<String> createCardAdminReadingParameters()
    {
        ArrayList<String> parameters = new ArrayList<>();
        parameters.add("python3");
        String directory = System.getProperty("user.home");
        parameters.add(directory+"/sysmo-usim-tool/sysmo-usim-tool.sjs1.py");
        
        parameters.add("-f");

        parameters.add("-a"); 
        parameters.add(admpinInput.getText());
        parameters.add("-k"); 
        parameters.add("-o");
        return parameters;
    }

    private ArrayList<String> createCardProgrammingParameters() 
    {
        
        ArrayList<String> parameters = new ArrayList<>();
               
        if(!fineTune)
        {
            parameters.add("python3");
            String directory = System.getProperty("user.home");
            parameters.add(directory+"/pysim/pySim-prog.py");
//            parameters.add("--dry-run");
            
            //add which reader to use
            parameters.add("-p");
            String reader = readerCbox.getValue().toString();
            switch (reader) 
            {
                case "Reader 0":
                    parameters.add("0");
                    break;
                case "Reader 1":
                    parameters.add("1");
                    break;
                case "Reader 2":
                    parameters.add("2");
                    break;
            }

            //add ADM PIN 
            parameters.add("-a"); 
            parameters.add(admpinInput.getText());

            //add ICCID
            if(!iccidChk.isSelected())
            {
               parameters.add("-s"); 
               parameters.add(iccidInput.getText());
            }

            //add Name
            if(!nameChk.isSelected())
            {
               parameters.add("-n"); 
               parameters.add(nameInput.getText());
            }

            //add IMSI
            if(!imsiChk.isSelected())
            {
               parameters.add("-i"); 
               parameters.add(imsiInput.getText());
            }

            //add Type
            if(!typeChk.isSelected())
            {
               parameters.add("-t"); 
               parameters.add(typeInput.getText());
            }

            //add CC
            if(!ccChk.isSelected())
            {
               parameters.add("-c"); 
               parameters.add(ccInput.getText());
            }

            //add Baud
            if(!baudrateChk.isSelected())
            {
               parameters.add("-b"); 
               parameters.add(baudrateCbox.getValue().toString());
            }

            //add MCC
            if(!mccChk.isSelected())
            {
               parameters.add("-x"); 
               parameters.add(mccInput.getText());
            }

            //add Ki
            if(!kiChk.isSelected())
            {
               parameters.add("-k"); 
               parameters.add(kiInput.getText());
            }

            //add MNC
            if(!mncChk.isSelected())
            {
               parameters.add("-y"); 
               parameters.add(mncInput.getText());
            }

            //add OPC
            if(!opcChk.isSelected())
            {
               parameters.add("-o"); 
               parameters.add(opcInput.getText());
            }

            //add SMSC
            if(!smscChk.isSelected())
            {
               parameters.add("-m"); 
               parameters.add(smscInput.getText());
            }

            //add ACC
            if(!accChk.isSelected())
            {
               parameters.add("--acc"); 
               parameters.add(accInput.getText());
            }

            //add SMSP
            if(!smspChk.isSelected())
            {
               parameters.add("-M"); 
               parameters.add(smspInput.getText());
            }

            //add NUM
            if(numChk.isSelected())
            {
               parameters.add("-j"); 
               parameters.add(numInput.getText());
            }

            //add OP
            if(!opChk.isSelected())
            {
               parameters.add("--op"); 
               parameters.add(opInput.getText());
            }

            //add STR
            if(strChk.isSelected())
            {
               parameters.add("-z"); 
               parameters.add(strInput.getText());
            }        

            //add Erase beforehand
            if(!eraseChk.isSelected())
            {
                RadioButton selectedRad = (RadioButton) eraseTg.getSelectedToggle();
                String selectedValue = selectedRad.getText();
                if(selectedValue.equals("True"))
                {
                    parameters.add("-e");
                }       
            }      
            
        }else
        {
            parameters.add("python3");
            String directory = System.getProperty("user.home");
            parameters.add(directory+"/sysmo-usim-tool/sysmo-usim-tool.sjs1.py");
            parameters.add("-f");
            
            //add ADM pin
            parameters.add("--adm1");
            parameters.add(admpinInput.getText());
            
            
            
            //add imsi
            if(imsiChk.isSelected())
            {
                parameters.add("-J");
                parameters.add(imsiInput.getText());
            }
            
            //add iccid
            if(iccidChk.isSelected())
            {
                parameters.add("-I");
                parameters.add(iccidInput.getText());
            }
            
            //add ki
            if(kiChk.isSelected())
            {
                parameters.add("-K");
                parameters.add(kiInput.getText());
            }
            
            //add OPC
            if(opcChk.isSelected())
            {
                parameters.add("-C");
                parameters.add(opcInput.getText());
            }
            
            //add OP
            if(opChk.isSelected())
            {
                parameters.add("-O");
                parameters.add(opInput.getText());
            }
            
            //add SQN
            if(sqnChk.isSelected())
            {
               parameters.add("-S");
                String sqnValue = sqnInput.getText();
                int loop = 12 - sqnValue.length();       
                for(int j=0;j<loop;++j){
                    sqnValue = "0"+sqnValue;
                }
                parameters.add(sqnValue); 
            }
            
        }
        
        return parameters;
    }

    private ArrayList<String> getAllValues() 
    {
        ArrayList<String> allValues = new ArrayList<>();
        
        if(!admpinInput.getText().isEmpty()) allValues.add("-a:"+admpinInput.getText());
        if(fineTune){
            if(iccidChk.isSelected()) allValues.add("-s:"+iccidInput.getText());
            if(imsiChk.isSelected()) allValues.add("-i:"+imsiInput.getText());
            if(kiChk.isSelected()) allValues.add("-k:"+kiInput.getText());
            if(opcChk.isSelected()) allValues.add("-o:"+opcInput.getText());
            if(opChk.isSelected()) allValues.add("--op:"+opInput.getText());
            if(sqnChk.isSelected()) allValues.add("-sqn:"+sqnInput.getText());
        }else{
            if(!baudrateChk.isSelected()) allValues.add("-b:"+baudrateCbox.getValue().toString());
            if(!typeChk.isSelected()) allValues.add("-t:"+typeInput.getText());
            if(!nameChk.isSelected()) allValues.add("-n:"+nameInput.getText());
            if(!ccChk.isSelected()) allValues.add("-c:"+ccInput.getText());
            if(!mccChk.isSelected()) allValues.add("-x:"+mccInput.getText());
            if(!mncChk.isSelected()) allValues.add("-y:"+mncInput.getText());
            if(!smscChk.isSelected()) allValues.add("-m:"+smscInput.getText());
            if(!smspChk.isSelected()) allValues.add("-M:"+smspInput.getText());
            if(!iccidChk.isSelected()) allValues.add("-s:"+iccidInput.getText());
            if(!imsiChk.isSelected()) allValues.add("-i:"+imsiInput.getText());
            if(!kiChk.isSelected()) allValues.add("-k:"+kiInput.getText());
            if(!opcChk.isSelected()) allValues.add("-o:"+opcInput.getText());
            if(!opChk.isSelected()) allValues.add("--op:"+opInput.getText());
            if(!accChk.isSelected()) allValues.add("--acc:"+accInput.getText());
            if(strChk.isSelected()) allValues.add("-z:"+strInput.getText());
            if(numChk.isSelected()) allValues.add("-j:"+numInput.getText());
            if(!eraseChk.isSelected())
            {
                RadioButton selectedRad = (RadioButton) eraseTg.getSelectedToggle();
                String selectedValue = selectedRad.getText();
                if(selectedValue.equals("True")) allValues.add("-e:"+"True");
            } 
            if(sqnChk.isSelected()) allValues.add("-sqn:"+sqnInput.getText());
        }
        return allValues;
    }
    
    @FXML
    void fineTuning(MouseEvent event) 
    {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(fineTuningSwitch);
        translateTransition.setDuration(Duration.seconds(0.25));
        
        
        
        if(!fineTune)
        {   translateTransition.setToX(28);
            translateTransition.play();
            fineTune = true;
            fineTuneValue.setText("ON");
            fineTuningRectangle.getStyleClass().add("fineTuneOn");
            
            admpinInput.getStyleClass().removeAll(Collections.singleton("error")); 
            admpinInput.setTooltip(null);
            AdmpinError.setVisible(false);
            
            readerCbox.getStyleClass().removeAll(Collections.singleton("error")); 
            readerCbox.setTooltip(null);
            readerError.setVisible(false);
            
            //disable all that cant be fine tuned
            typeLabel.setDisable(true);
            typeChk.setSelected(false);
            typeChk.setDisable(true);
            typeInput.setText("");
            typeInput.setDisable(true);
            typeInput.getStyleClass().removeAll(Collections.singleton("error")); 
            typeInput.setTooltip(null);
            typeError.setVisible(false);
            
            baudratelabel.setDisable(true);  
            baudrateCbox.setItems(null);
            baudrateChk.setSelected(false);
            baudrateCbox.setDisable(true);
            baudrateChk.setDisable(true);
            baudrateCbox.getStyleClass().removeAll(Collections.singleton("error")); 
            baudrateCbox.setTooltip(null);
            BaudError.setVisible(false);
            
            accLabel.setDisable(true);
            accChk.setDisable(true);
            accChk.setSelected(false);
            accInput.setText("");
            accInput.setDisable(true);
            accInput.getStyleClass().removeAll(Collections.singleton("error")); 
            accInput.setTooltip(null);
            accError.setVisible(false);
            
            nameLabel.setDisable(true);
            nameChk.setDisable(true);
            nameChk.setSelected(false);
            nameInput.setText("");
            nameInput.setDisable(true);
            nameInput.getStyleClass().removeAll(Collections.singleton("error")); 
            nameInput.setTooltip(null);
            nameError.setVisible(false);
            
            ccLabel.setDisable(true);   
            ccChk.setDisable(true);
            ccChk.setSelected(false);
            ccInput.setText("");
            ccInput.setDisable(true);
            ccInput.getStyleClass().removeAll(Collections.singleton("error")); 
            ccInput.setTooltip(null);
            ccError.setVisible(false);
            
            
            mccLabel.setDisable(true);
            mccChk.setDisable(true);
            mccChk.setSelected(false);
            mccInput.setText("");
            mccInput.setDisable(true);
            mccInput.getStyleClass().removeAll(Collections.singleton("error")); 
            mccInput.setTooltip(null);
            mccError.setVisible(false);
            
            mncLabel.setDisable(true);
            mncChk.setDisable(true);
            mncChk.setSelected(false);
            mncInput.setText("");
            mncInput.setDisable(true);
            mncInput.getStyleClass().removeAll(Collections.singleton("error")); 
            mncInput.setTooltip(null);
            mncError.setVisible(false);
            
            smscLabel.setDisable(true);
            smscChk.setSelected(false);
            smscChk.setDisable(true);
            smscInput.setText("");
            smscInput.setDisable(true);
            smscInput.getStyleClass().removeAll(Collections.singleton("error")); 
            smscInput.setTooltip(null);
            smscError.setVisible(false);
            
            smspLabel.setDisable(true);   
            smspChk.setSelected(false);
            smspChk.setDisable(true);
            smspInput.setText("");
            smspInput.setDisable(true);
            smspInput.getStyleClass().removeAll(Collections.singleton("error")); 
            smspInput.setTooltip(null);
            smspError.setVisible(false);
            
            numLabel.setDisable(true);
            numChk.setSelected(false);
            numChk.setDisable(true);
            numInput.setText("");
            numInput.setDisable(true);
            numInput.getStyleClass().removeAll(Collections.singleton("error")); 
            numInput.setTooltip(null);
            numError.setVisible(false);
            
            strLabel.setDisable(true);
            strChk.setSelected(false);
            strChk.setDisable(true);
            strInput.setText("");
            strInput.setDisable(true);
            strInput.getStyleClass().removeAll(Collections.singleton("error")); 
            strInput.setTooltip(null);
            strError.setVisible(false);
                    
            eraseLabel.setDisable(true);
            eraseLabel2.setDisable(true);
            eraseChk.setSelected(false);
            eraseChk.setDisable(true);
            eraseFalseRad.setDisable(true);
            eraseTrueRad.setDisable(true);
            eraseTg.selectToggle(null);
            
            
            
//            opChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//            {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//                {
//                    
//                    if(newValue)
//                    {
//                        opInput.setDisable(false);
//                        opInput.setText("");
//                    }
//                    else
//                    {
//                        opInput.setDisable(true);
//                        opInput.setText("");
//                    }
//                }
//            });
            
            // add fine tune check box to Op
//            opChk.setText("Fine-Tune");
//            String op = opInput.getText(); 
//            opChk.getStyleClass().add("chkBox");
//            opInput.getStyleClass().removeAll(Collections.singleton("error")); 
//            opInput.setTooltip(null);
//            opError.setVisible(false);
//            opChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//            {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//                {
//                    opInput.getStyleClass().removeAll(Collections.singleton("error")); 
//                    opInput.setTooltip(null);
//                    opError.setVisible(false);
//                    if(newValue)
//                    {
//                        opInput.setDisable(false);
//                        opInput.setText("");
//                    }
//                    else
//                    {
//                        opInput.setDisable(true);
//                        opInput.setText("");
//                    }
//                }
//            });
//            opChk.setSelected(true);
//            opHbox.getChildren().add(1,opChk);
//            opInput.setText(op);
//            
            
            //change checkbox to fine tune
            kiChk.setText("Fine-Tune");
            String ki = kiInput.getText();
            if(kiChk.isSelected()){
                kiChk.setSelected(false);
                kiInput.setDisable(true);
            }else{
                kiChk.setSelected(true);
                kiInput.setDisable(false);
            }
            kiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    if(newValue)
                    {
                        kiInput.setDisable(false);
                        kiInput.setText("");
                    }
                    else
                    {
                        kiInput.setDisable(true);
                        kiInput.setText("");
                    }
                }
            });
            kiInput.setText(ki);
            
            
            opChk.selectedProperty().removeListener(opListener);
            opChk.setText("Fine-Tune");
            String op = opInput.getText();
            if(opChk.isSelected()){
                opChk.setSelected(false);
                opInput.setDisable(true);
            }else{
                opChk.setSelected(true);
                opInput.setDisable(false);
                opInput.setText(op);
            }
            opChk.selectedProperty().addListener(opFineTuneListener);
            
            
            opcChk.selectedProperty().removeListener(opcListener);
            opcChk.setText("Fine-Tune");
            String opc = opcInput.getText();
            if(opcChk.isSelected()){
                opcChk.setSelected(false);
                opcInput.setDisable(true);
            }else{
                opcChk.setSelected(true);
                opcInput.setDisable(false);
                opcInput.setText(opc);
            }
            opcChk.selectedProperty().addListener(opcFineTuneListener);
//            opcChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
//            {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
//                {
//                    
//                    if(newValue)
//                    {
//                        opcInput.setDisable(false);
//                        opcInput.setText("");
//                    }
//                    else
//                    {
//                        opcInput.setDisable(true);
//                        opcInput.setText("");
//                    }
//                }
//            });
                    
            
            iccidChk.setText("Fine-Tune");
            String iccid = iccidInput.getText();
            if(iccidChk.isSelected()){
                iccidChk.setSelected(false);
                iccidInput.setDisable(true);
            }else{
                iccidChk.setSelected(true);
                iccidInput.setDisable(false);
            }
            iccidChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
             {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                        iccidInput.getStyleClass().removeAll(Collections.singleton("error")); 
                        iccidInput.setTooltip(null);
                        iccidError.setVisible(false);
                        if(newValue)
                        {
                            iccidInput.setDisable(false);
                            iccidInput.setText("");
                        }
                        else
                        {
                            iccidInput.setDisable(true);
                            iccidInput.setText("");
                        }
                    }
            });
            iccidInput.setText(iccid);
            
            imsiChk.setText("Fine-Tune");
            String imsi = imsiInput.getText();
            if(imsiChk.isSelected()){
                imsiChk.setSelected(false);
                imsiInput.setDisable(true);
            }else{
                imsiChk.setSelected(true);
                imsiInput.setDisable(false);
            }
            imsiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    imsiInput.getStyleClass().removeAll(Collections.singleton("error")); 
                    imsiInput.setTooltip(null);
                    imsiError.setVisible(false);
                    if(newValue)
                    {
                        imsiInput.setDisable(false);
                        imsiInput.setText("");
                    }
                    else
                    {
                        imsiInput.setDisable(true);
                        imsiInput.setText("");
                    }
                }
            });    
            imsiInput.setText(imsi);
            
            sqnChk.setText("Fine-Tune");
            sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
            sqnInput.setTooltip(null);
            sqnError.setVisible(false);
            String sqn = sqnInput.getText();
            if(sqnChk.isSelected()){
                sqnChk.setSelected(true);
                sqnInput.setDisable(false);
            }else{
                sqnChk.setSelected(false);
                sqnInput.setDisable(true); 
            }
            sqnChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
                    sqnInput.setTooltip(null);
                    sqnError.setVisible(false);
                    if(newValue)
                    {
                        sqnInput.setDisable(false);
                        sqnInput.setText("");
                    }
                    else
                    {
                        sqnInput.setDisable(true);
                        sqnInput.setText("");
                    }
                }
            });  
            sqnInput.setText(sqn);

        }else
        {
            admpinInput.getStyleClass().removeAll(Collections.singleton("error")); 
            admpinInput.setTooltip(null);
            AdmpinError.setVisible(false);
            
            readerCbox.getStyleClass().removeAll(Collections.singleton("error")); 
            readerCbox.setTooltip(null);
            readerError.setVisible(false);
            
            //remove op checkbox 
//            opHbox.getChildren().remove(1);
//            opInput.setDisable(false);
            
            translateTransition.setToX(0);
            translateTransition.play();
            fineTune = false;
            fineTuneValue.setText("OFF");
            fineTuningRectangle.getStyleClass().remove("fineTuneOn");
            
            //undo the disabled for fine tuning
            typeLabel.setDisable(false);
            typeInput.setDisable(true);
            typeChk.setDisable(false);
            typeChk.setSelected(true);
            
            baudratelabel.setDisable(false);
            baudrateCbox.setDisable(true);
            ObservableList<Integer> baudrate = FXCollections.observableArrayList(50,75,110,134,150,200,300,600,1200,1800,2400,4800,9600,19200,28800,38400,57600,76800,115200,230400,460800,576000,921600);
            baudrateCbox.setItems(baudrate);
            baudrateCbox.getSelectionModel().select(12);
            baudrateChk.setDisable(false);
            baudrateChk.setSelected(true);
            
            accLabel.setDisable(false);
            accInput.setDisable(true);
            accChk.setDisable(false);
            accChk.setSelected(true);
            
            nameLabel.setDisable(false);
            nameInput.setText("Magic");
            nameInput.setDisable(true);
            nameChk.setDisable(false);
            nameChk.setSelected(true);
            
            ccLabel.setDisable(false);
            ccInput.setDisable(true);
            ccInput.setText("1");
            ccChk.setDisable(false);
            ccChk.setSelected(true);
            
            mccLabel.setDisable(false);
            mccInput.setDisable(true);
            mccInput.setText("901");
            mccChk.setDisable(false);
            mccChk.setSelected(true);
            
            mncLabel.setDisable(false);
            mncInput.setDisable(true);
            mncInput.setText("55");
            mncChk.setDisable(false);
            mncChk.setSelected(true);
            
            smscLabel.setDisable(false);
            smscInput.setDisable(true);
            smscInput.setText("{00 + CC + 5555}");
            smscChk.setDisable(false);
            smscChk.setSelected(true);
            
            smspLabel.setDisable(false);
            smspInput.setDisable(true);
            smspChk.setDisable(false);
            smspChk.setSelected(true);
            
            numLabel.setDisable(false);
            numInput.setDisable(true);
            numChk.setDisable(false);
            
            strLabel.setDisable(false);
            strInput.setDisable(true);
            strChk.setDisable(false);

            eraseLabel.setDisable(false);
            eraseLabel2.setDisable(false);
            eraseChk.setSelected(true);
            eraseChk.setDisable(false);
            eraseFalseRad.setDisable(true);
            eraseTrueRad.setDisable(true);
            eraseTg.selectToggle(eraseFalseRad);
            
            
            //change checkbox to original names
            kiChk.setText("Randomize");
            String ki = kiInput.getText();
            if(kiChk.isSelected()){
                kiChk.setSelected(false);
                kiInput.setDisable(false);
            }else{
                kiChk.setSelected(true);
                kiInput.setDisable(true);
            }
            kiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    if(newValue)
                    {
                        kiInput.setDisable(true);
                        kiInput.setText("");
                    }
                    else
                    {
                        kiInput.setDisable(false);
                        kiInput.setText("");
                    }
                }
            });
            kiInput.setText(ki);
            
            
            opcChk.selectedProperty().removeListener(opcFineTuneListener);
            opcChk.setText("Randomize");
            opcInput.getStyleClass().removeAll(Collections.singleton("error")); 
            opcInput.setTooltip(null);
            opError.setVisible(false);
            String opc = opcInput.getText();
            opcChk.setSelected(false);
            opcInput.setDisable(false);
            opInput.setText(opc);
            opcChk.selectedProperty().addListener(opcListener);
            
            opChk.selectedProperty().removeListener(opFineTuneListener);
            opChk.setText("Randomize");
            opInput.getStyleClass().removeAll(Collections.singleton("error")); 
            opInput.setTooltip(null);
            opError.setVisible(false);

            opChk.setSelected(true);
            opInput.setDisable(true);
            opInput.setText("");

            opChk.selectedProperty().addListener(opListener);
                    
            iccidChk.setText("Autogen From NUM");
            String iccid = iccidInput.getText();
            if(iccidChk.isSelected()){
                iccidChk.setSelected(false);
                iccidInput.setDisable(false);
            }else{
                iccidChk.setSelected(true);
                iccidInput.setDisable(true);
            }
            iccidChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                        iccidInput.getStyleClass().removeAll(Collections.singleton("error")); 
                        iccidInput.setTooltip(null);
                        iccidError.setVisible(false);
                        if(newValue)
                        {
                            iccidInput.setDisable(true);
                            iccidInput.setText("");
                        }
                        else
                        {
                            iccidInput.setDisable(false);
                            iccidInput.setText("");
                        }
                    }
            });
            iccidInput.setText(iccid);
            
            imsiChk.setText("Autogen From NUM");
            String imsi = imsiInput.getText();
            if(imsiChk.isSelected()){
                imsiChk.setSelected(false);
                imsiInput.setDisable(false);
            }else{
                imsiChk.setSelected(true);
                imsiInput.setDisable(true);
            }
            imsiChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    imsiInput.getStyleClass().removeAll(Collections.singleton("error")); 
                    imsiInput.setTooltip(null);
                    imsiError.setVisible(false);
                    if(newValue)
                    {
                        imsiInput.setDisable(true);
                        imsiInput.setText("");
                    }
                    else
                    {
                        imsiInput.setDisable(false);
                        imsiInput.setText("");
                    }
                }
            });  
            imsiInput.setText(imsi);
            
            sqnChk.setText("Enable");
            sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
            sqnInput.setTooltip(null);
            sqnError.setVisible(false);
            String sqn = sqnInput.getText();
            if(sqnChk.isSelected()){
                sqnChk.setSelected(true);
                sqnInput.setDisable(false);
            }else{
                sqnChk.setSelected(false);
                sqnInput.setDisable(true);
            }
            sqnChk.selectedProperty().addListener(new ChangeListener<Boolean>() 
            {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) 
                {
                    sqnInput.getStyleClass().removeAll(Collections.singleton("error")); 
                    sqnInput.setTooltip(null);
                    sqnError.setVisible(false);
                    if(newValue)
                    {
                        sqnInput.setDisable(false);
                        sqnInput.setText("");
                    }
                    else
                    {
                        sqnInput.setDisable(true);
                        sqnInput.setText("");
                    }
                }
            });  
            sqnInput.setText(sqn);
        }
       
    }
}