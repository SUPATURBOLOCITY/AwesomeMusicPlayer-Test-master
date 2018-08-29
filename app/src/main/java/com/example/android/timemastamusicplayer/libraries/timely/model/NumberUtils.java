package com.example.android.timemastamusicplayer.libraries.timely.model;

import com.example.android.awesomemusicplayer.libraries.timely.model.number.*;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Eight;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Five;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Four;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Nine;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Null;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.One;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Seven;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Six;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Three;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Two;
import com.example.android.timemastamusicplayer.libraries.timely.model.number.Zero;

import java.security.InvalidParameterException;

public class NumberUtils {

    public static float[][] getControlPointsFor(int start) {
        switch (start) {
            case (-1):
                return Null.getInstance().getControlPoints();
            case 0:
                return Zero.getInstance().getControlPoints();
            case 1:
                return One.getInstance().getControlPoints();
            case 2:
                return Two.getInstance().getControlPoints();
            case 3:
                return Three.getInstance().getControlPoints();
            case 4:
                return Four.getInstance().getControlPoints();
            case 5:
                return Five.getInstance().getControlPoints();
            case 6:
                return Six.getInstance().getControlPoints();
            case 7:
                return Seven.getInstance().getControlPoints();
            case 8:
                return Eight.getInstance().getControlPoints();
            case 9:
                return Nine.getInstance().getControlPoints();
            default:
                throw new InvalidParameterException("Unsupported number requested");
        }
    }
}