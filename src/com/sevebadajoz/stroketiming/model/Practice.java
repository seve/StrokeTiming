package com.sevebadajoz.stroketiming.model;

import java.util.ArrayList;

public class Practice {
    ArrayList<WaterPiece> mWaterPieces;

    public Practice(ArrayList<WaterPiece> waterPieces) {
        mWaterPieces = waterPieces;
    }

    public ArrayList<WaterPiece> getWaterPieces() {
        return mWaterPieces;
    }

    public void setWaterPieces(ArrayList<WaterPiece> waterPieces) {
        mWaterPieces = waterPieces;
    }
}
