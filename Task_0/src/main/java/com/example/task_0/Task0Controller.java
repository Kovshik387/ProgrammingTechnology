package com.example.task_0;

import Model.Percent;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.Objects;

public class Task0Controller {

    public TextField MoneyTextArea;
    public Button BigMoneyButton;
    public Label BigMoneyLabel;
    public Button DefaultMoneyButton;
    public Label DefaultMoneyLabel;
    public Button SmallMoneyButton;
    public Label SmallMoneyLabel;

    private final Percent percent = new Percent();
    public Label ControlSum;
    public Button RoundButton;

    private int current_percent;

    public void BigMoneyCalculate(ActionEvent actionEvent) {
        if (Objects.equals(MoneyTextArea.getText(), "")) return;

        var sum = percent.countSum(Float.parseFloat(MoneyTextArea.getText()),15);
        current_percent = 15;
        this.ControlSum.setText("Итоговая сумма: " + sum);
        RoundButton.setVisible(true);
    }

    public void DefaultMoneyCalculate(ActionEvent actionEvent) {
        if (Objects.equals(MoneyTextArea.getText(), "")) return;
        // add some smiles
        var sum = percent.countSum(Float.parseFloat(MoneyTextArea.getText()),8);
        current_percent = 8;
        this.ControlSum.setText("Итоговая сумма: " + sum);
        RoundButton.setVisible(true);
    }

    public void SmallMoneyCalculate(ActionEvent actionEvent) {
        if (Objects.equals(MoneyTextArea.getText(), "")) return;

        var sum = percent.countSum(Float.parseFloat(MoneyTextArea.getText()),3);
        current_percent = 3;
        this.ControlSum.setText("Итоговая сумма: " + sum);
        RoundButton.setVisible(true);
    }

    public void MoneyCalculate(KeyEvent keyEvent) {
        try {
            percent.setSum(Float.parseFloat(MoneyTextArea.getText()));
            MoneyTextArea.setStyle("-fx-background-color:white;");
            SmallMoneyLabel.setText(Float.toString(percent.countPr(3)));
            DefaultMoneyLabel.setText(Float.toString(percent.countPr(9)));
            BigMoneyLabel.setText(Float.toString(percent.countPr(15)));
            this.ControlSum.setText("");

        } catch (Exception ex){
            MoneyTextArea.setStyle("-fx-background-color:red;");
            SmallMoneyLabel.setText("");
            DefaultMoneyLabel.setText("");
            BigMoneyLabel.setText("");
            this.ControlSum.setText("");
        }
        finally {
            RoundButton.setVisible(false);
        }
    }

    public void RoundCalculate(ActionEvent actionEvent) {
        this.ControlSum.setText("Округлённая итоговая сумма: " + percent.countSumRound(current_percent));
    }
}
