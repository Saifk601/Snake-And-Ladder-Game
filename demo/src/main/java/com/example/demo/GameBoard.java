package com.example.demo;

import javafx.util.Pair;

import java.util.ArrayList;

public class GameBoard {
    static int tilesize = 40;
    static int height = 10;
    static int width = 10;

    static ArrayList<Pair<Integer,Integer>>positionCoordinates;
     static ArrayList<Integer>snakeLadderPosition;
    public GameBoard(){
        populatePositionCoordinates();
        setPositionCoordinates();

    }
     public int getXValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getKey();
     }
     public int getYValue(int piecePosition){
        return positionCoordinates.get(piecePosition).getValue();
     }
     public int PlayPositionSnakeOrLadder(int piecePosition){
        if(piecePosition != snakeLadderPosition.get(piecePosition)){
           return snakeLadderPosition.get(piecePosition);
        }
         return -1;
     }

     private void setPositionCoordinates(){
        snakeLadderPosition = new ArrayList<>();
         for (int i = 0; i < 101; i++) {
             snakeLadderPosition.add(i);
         }
         snakeLadderPosition.set(4 , 25);
         snakeLadderPosition.set(13 ,46);
         snakeLadderPosition.set(27 , 5);
         snakeLadderPosition.set(33 , 49);
         snakeLadderPosition.set(40 , 3);
         snakeLadderPosition.set(42 ,63);
         snakeLadderPosition.set(43 , 18);
         snakeLadderPosition.set(50 , 69);
         snakeLadderPosition.set(54 , 31);
         snakeLadderPosition.set(62 , 81);
         snakeLadderPosition.set(66 , 45);
         snakeLadderPosition.set(74 , 92);
         snakeLadderPosition.set(76 ,58);
         snakeLadderPosition.set(89, 53);
         snakeLadderPosition.set(99 , 41);
     }

    private static void populatePositionCoordinates(){
        positionCoordinates= new ArrayList<>();
        positionCoordinates.add(new Pair<Integer, Integer>(20,380));
          int xTilePos,yTilePos;
        for (int i = height-1; i >=0 ; i--) {
            for (int j = width-1; j >=0 ; j--) {
              if(i%2 != 0){
                  xTilePos = tilesize*width - (tilesize/2 + j*tilesize);
              }
              else{
                  xTilePos = tilesize/2 + j*tilesize;
              }
              yTilePos = tilesize/2 +i*tilesize;
              positionCoordinates.add(new Pair<Integer, Integer>(xTilePos,yTilePos));
            }

        }
        for (int i = 0; i < positionCoordinates.size(); i++) {
            System.out.println(i + " x: " + positionCoordinates.get(i).getKey() + " y: " + positionCoordinates.get(i).getValue());
        }

    }

    public static void main(String[] args) {
        populatePositionCoordinates();
    }
}
