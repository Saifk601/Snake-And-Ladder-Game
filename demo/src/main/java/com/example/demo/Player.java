package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle gamePiece;
    int xPosition;
    int yPosition;
    int currentPiecePosition;

    static GameBoard gameboard = new GameBoard();

    Player(int tilesize , Color pieceColor){
        this.currentPiecePosition = 1;
        this.xPosition = gameboard.getXValue(currentPiecePosition);
        this.yPosition = gameboard.getYValue(currentPiecePosition);

        gamePiece = new Circle(tilesize/2);
        gamePiece.setFill(pieceColor);
        gamePiece.setTranslateX(this.xPosition);
        gamePiece.setTranslateY(this.yPosition);
    }
      public void movePlayer(int diceValue){
        if(currentPiecePosition + diceValue <= 100){
            currentPiecePosition += diceValue;
            translatePlayer();
        }
      }
       private void translatePlayer(){
        this.xPosition = gameboard.getXValue(this.currentPiecePosition);
        this.yPosition = gameboard.getYValue(this.currentPiecePosition);

           TranslateTransition animate = new TranslateTransition(Duration.millis(1000),this.gamePiece);
           animate.setToX(this.xPosition);
           animate.setToY(this.yPosition);
           animate.setAutoReverse(false);
           animate.play();
       }

       public void playerAtSnakeOrLadder(){
        int newPosition = gameboard.PlayPositionSnakeOrLadder(this.currentPiecePosition);
        if(newPosition != -1){
            this.currentPiecePosition = newPosition;
            translatePlayer();
        }
       }

    public Circle getGamePiece() {
        return this.gamePiece;
    }
}
