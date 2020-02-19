package com.nsg.dtlibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//import com.nsg.nsgdtlibrary.Classes.OldCode.NSGIMainFragment;
import com.nsg.nsgdtlibrary.Classes.util.NSGIMapFragmentActivity;
import com.nsg.nsgdtlibrary.Classes.util.NSGTiledLayerOnMap;
import com.nsg.nsgdtlibrary.Classes.util.NavigationProperties;

import java.io.File;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Created by sailaja.ch NSGI on 27/09/2019
 */
public class NSGApiActivity extends FragmentActivity implements NSGIMapFragmentActivity.FragmentToActivity, View.OnClickListener {
    private int routeDeviationBuffer=10;
    private String charlsisNumber;
    private  Button Start,Stop;
    private String jobId="1",routeId;
    String SourcePosition="55.068072 24.979532";
    String DestinationPosition="55.068888 24.980723";
    private String  routeData="{\n" +
            "    \"$id\": \"1\",\n" +
            "    \"Message\": \"Sucess\",\n" +
            "    \"Status\": \"Success\",\n" +
            "    \"TotalDistance\": 0.01090310401,\n" +
            "    \"Route\": [\n" +
            "        {\n" +
            "            \"$id\": \"2\",\n" +
            "            \"EdgeNo\": \"102\",\n" +
            "            \"GeometryText\": \"Take Left at Shell Trading Middle East Private Limited\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"3\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.067823171000043,\n" +
            "                        24.979267360000051\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06771488000004,\n" +
            "                        24.979172996000045\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06736747900004,\n" +
            "                        24.978870483000037\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067020892000073,\n" +
            "                        24.978570495000042\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066790925000078,\n" +
            "                        24.978370131000077\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066620030000081,\n" +
            "                        24.978221328000075\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06650374700007,\n" +
            "                        24.97812037500006\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066452143000049,\n" +
            "                        24.978075252000053\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066388841000048,\n" +
            "                        24.978020054000069\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066216137000083,\n" +
            "                        24.977870199000051\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06598632500004,\n" +
            "                        24.97767018400009\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065755946000081,\n" +
            "                        24.977470103000087\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065526233000071,\n" +
            "                        24.977270178000083\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065312867000046,\n" +
            "                        24.977084458000036\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"$id\": \"4\",\n" +
            "            \"EdgeNo\": \"1334\",\n" +
            "            \"GeometryText\": \"Take Right at\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"5\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.065312867000046,\n" +
            "                        24.977084458000036\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065287629000068,\n" +
            "                        24.977076221000061\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065261227000065,\n" +
            "                        24.97707199000007\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065234420000081,\n" +
            "                        24.97707188600009\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065207979000036,\n" +
            "                        24.977075912000089\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065182665000066,\n" +
            "                        24.97708395300009\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065159206000033,\n" +
            "                        24.977095778000091\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065138276000084,\n" +
            "                        24.977111045000072\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"$id\": \"6\",\n" +
            "            \"EdgeNo\": \"369\",\n" +
            "            \"GeometryText\": \"Take Right at\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"7\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.065138276000084,\n" +
            "                        24.977111045000072\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065120166000042,\n" +
            "                        24.977128114000038\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064756250000073,\n" +
            "                        24.977475793000053\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064379641000073,\n" +
            "                        24.977835331000051\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064249201000052,\n" +
            "                        24.977960644000063\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"$id\": \"8\",\n" +
            "            \"EdgeNo\": \"383\",\n" +
            "            \"GeometryText\": \"Take Right at\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"9\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.064249201000052,\n" +
            "                        24.977960644000063\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064238539000087,\n" +
            "                        24.977972603000069\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064230288000033,\n" +
            "                        24.977986052000062\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064224693000085,\n" +
            "                        24.978000592000058\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064221918000044,\n" +
            "                        24.978015793000054\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064222048000033,\n" +
            "                        24.978031201000078\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064222048000033,\n" +
            "                        24.978031201000078\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064387059000069,\n" +
            "                        24.978174369000044\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064439134000054,\n" +
            "                        24.978219639000088\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064439134000054,\n" +
            "                        24.978219639000088\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064525820000085,\n" +
            "                        24.978294996000045\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064525820000085,\n" +
            "                        24.978294996000045\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.064649532000033,\n" +
            "                        24.978402540000047\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06498055600008,\n" +
            "                        24.978690915000072\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06498055600008,\n" +
            "                        24.978690915000072\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065164137000068,\n" +
            "                        24.978850842000043\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065338824000037,\n" +
            "                        24.979002188000038\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065338824000037,\n" +
            "                        24.979002188000038\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065422408000074,\n" +
            "                        24.979074604000061\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065573362000066,\n" +
            "                        24.979205705000084\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065573362000066,\n" +
            "                        24.979205705000084\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065666012000065,\n" +
            "                        24.979286171000069\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065666012000065,\n" +
            "                        24.979286171000069\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065681098000084,\n" +
            "                        24.979299272000048\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.065938324000058,\n" +
            "                        24.979522600000053\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066002768000033,\n" +
            "                        24.979578645000061\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066002768000033,\n" +
            "                        24.979578645000061\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066081442000041,\n" +
            "                        24.979647065000051\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066081442000041,\n" +
            "                        24.979647065000051\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066110416000072,\n" +
            "                        24.979672262000065\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066245676000051,\n" +
            "                        24.979789959000072\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066245676000051,\n" +
            "                        24.979789959000072\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06634370900008,\n" +
            "                        24.979875263000054\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06634370900008,\n" +
            "                        24.979875263000054\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066752725000072,\n" +
            "                        24.980231166000067\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066752725000072,\n" +
            "                        24.980231166000067\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066903568000043,\n" +
            "                        24.980362421000052\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.066903568000043,\n" +
            "                        24.980362421000052\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067100767000056,\n" +
            "                        24.980534010000042\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067353009000044,\n" +
            "                        24.980753335000088\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067353009000044,\n" +
            "                        24.980753335000088\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067379754000058,\n" +
            "                        24.980776590000062\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067413287000079,\n" +
            "                        24.98080574700009\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067413287000079,\n" +
            "                        24.98080574700009\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.06757228500004,\n" +
            "                        24.980943995000075\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067585055000052,\n" +
            "                        24.980955117000065\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067585055000052,\n" +
            "                        24.980955117000065\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067665108000085,\n" +
            "                        24.981024841000078\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.067665108000085,\n" +
            "                        24.981024841000078\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068015740000078,\n" +
            "                        24.981330228000047\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068015740000078,\n" +
            "                        24.981330228000047\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068028539000068,\n" +
            "                        24.981334935000064\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068041987000072,\n" +
            "                        24.981337770000039\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068055755000046,\n" +
            "                        24.981338662000041\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068069507000075,\n" +
            "                        24.981337589000077\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068082908000065,\n" +
            "                        24.981334579000077\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068095632000052,\n" +
            "                        24.981329704000075\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"$id\": \"10\",\n" +
            "            \"EdgeNo\": \"17\",\n" +
            "            \"GeometryText\": \"Take Left at\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"11\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.068095632000052,\n" +
            "                        24.981329704000075\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068300521000083,\n" +
            "                        24.981134717000089\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068517437000082,\n" +
            "                        24.980927170000086\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068574001000059,\n" +
            "                        24.980873147000068\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        },\n" +
            "        {\n" +
            "            \"$id\": \"12\",\n" +
            "            \"EdgeNo\": \"116\",\n" +
            "            \"GeometryText\": \"-\",\n" +
            "            \"Geometry\": {\n" +
            "                \"$id\": \"13\",\n" +
            "                \"type\": \"LineString\",\n" +
            "                \"coordinates\": [\n" +
            "                    [\n" +
            "                        55.068574001000059,\n" +
            "                        24.980873147000068\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068729909000069,\n" +
            "                        24.980724241000075\n" +
            "                    ],\n" +
            "                    [\n" +
            "                        55.068799897000076,\n" +
            "                        24.980658264000056\n" +
            "                    ]\n" +
            "                ]\n" +
            "            }\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    /*
    private String SourcePosition = "55.303934 25.259310";
    private String DestinationPosition = "55.303703 25.257474";
    String routeData="{\"$id\": \"1\",\"Message\": \"Sucess\",\"Status\": \"Success\",\"TotalDistance\": 0.04324998409,\"Route\": [{\"$id\": \"114\",\"EdgeNo\": \"1817\",\"GeometryText\": \"-\",\"Geometry\": {\n" +
            "        \"$id\": \"115\",\"type\": \"LineString\",\"coordinates\": [[55.303824,25.259174],[55.303507,25.258667],[55.303330,25.258393],[55.303132,25.258046],[55.303006,25.257828],[55.303360,25.257644]]}}]}";




     private String SourcePosition = "55.067291 24.978782";
     private String DestinationPosition = "55.067205 24.979878";
    // 25.26886,55.33279   25.27078,55.3327
     String routeData="\n" +
            "\n" +
            "{\"$id\":\"1\",\"Message\":\"Sucess\",\"Status\":\"Success\",\"TotalDistance\":0.00884315523,\"Route\":[{\"$id\":\"2\",\"EdgeNo\":\"102\",\"GeometryText\":\"Take Right \n" +
            "at Shell Trading Middle East Private Limited\",\"Geometry\":{\"$id\":\"3\",\"type\":\"LineString\",\"coordinates\":[[55.06727997182,24.9787947412557],\n" +
            "[55.067020892000073,24.978570495000042],[55.066790925000078,24.978370131000077],[55.066620030000081,24.978221328000075],\n" +
            "[55.06650374700007,24.97812037500006],[55.066452143000049,24.978075252000053],[55.066388841000048,24.978020054000069],\n" +
            "[55.066216137000083,24.977870199000051],[55.06598632500004,24.97767018400009],[55.065755946000081,24.977470103000087],\n" +
            "[55.065526233000071,24.977270178000083],[55.065312867000046,24.977084458000036]]}},{\"$id\":\"4\",\"EdgeNo\":\"1334\",\"GeometryText\":\"Take Right \n" +
            "at\",\"Geometry\":{\"$id\":\"5\",\"type\":\"LineString\",\"coordinates\":[[55.065312867000046,24.977084458000036],[55.065287629000068,24.977076221000061],\n" +
            "[55.065261227000065,24.97707199000007],[55.065234420000081,24.97707188600009],[55.065207979000036,24.977075912000089],\n" +
            "[55.065182665000066,24.97708395300009],[55.065159206000033,24.977095778000091],[55.065138276000084,24.977111045000072],\n" +
            "[55.065138276000084,24.977111045000072],[55.065120166000042,24.977128114000038],[55.064756250000073,24.977475793000053],\n" +
            "[55.064379641000073,24.977835331000051],[55.064249201000052,24.977960644000063],[55.064249201000052,24.977960644000063],\n" +
            "[55.064238539000087,24.977972603000069],[55.064230288000033,24.977986052000062],[55.064224693000085,24.978000592000058],\n" +
            "[55.064221918000044,24.978015793000054],[55.064222048000033,24.978031201000078],[55.064222048000033,24.978031201000078],\n" +
            "[55.064387059000069,24.978174369000044],[55.064439134000054,24.978219639000088],[55.064439134000054,24.978219639000088],\n" +
            "[55.064525820000085,24.978294996000045],[55.064525820000085,24.978294996000045],[55.064649532000033,24.978402540000047],\n" +
            "[55.06498055600008,24.978690915000072],[55.06498055600008,24.978690915000072],[55.065164137000068,24.978850842000043],\n" +
            "[55.065338824000037,24.979002188000038],[55.065338824000037,24.979002188000038],[55.065422408000074,24.979074604000061],\n" +
            "[55.065573362000066,24.979205705000084],[55.065573362000066,24.979205705000084],[55.065666012000065,24.979286171000069],\n" +
            "[55.065666012000065,24.979286171000069],[55.065681098000084,24.979299272000048],[55.065938324000058,24.979522600000053],\n" +
            "[55.066002768000033,24.979578645000061],[55.066002768000033,24.979578645000061],[55.066081442000041,24.979647065000051],\n" +
            "[55.066081442000041,24.979647065000051],[55.066110416000072,24.979672262000065],[55.066245676000051,24.979789959000072],\n" +
            "[55.066245676000051,24.979789959000072],[55.06634370900008,24.979875263000054],[55.06634370900008,24.979875263000054],\n" +
            "[55.066752725000072,24.980231166000067],[55.066752725000072,24.980231166000067],[55.066772902000082,24.980240215000038],\n" +
            "[55.066794299000037,24.98024651500009],[55.066816470000049,24.980249936000064],[55.066838951000079,24.980250405000049],\n" +
            "[55.066861270000061,24.980247913000085]]}},{\"$id\":\"6\",\"EdgeNo\":\"443\",\"GeometryText\":\"-\",\"Geometry\":\n" +
            "{\"$id\":\"7\",\"type\":\"LineString\",\"coordinates\":[[55.066861270000061,24.980247913000085],[55.0672260238388,24.9799000715094]]}}]}";
*/

/*
     private String SourcePosition = "55.33279 25.26886";
     private String DestinationPosition = "55.3327 25.27078";
   // 25.26886,55.33279   25.27078,55.3327
    String routeData="{\"$id\": \"1\",\"Message\": \"Sucess\",\"Status\": \"Success\",\"TotalDistance\": 0.04324998409,\"Route\": [{\"$id\": \"114\",\"EdgeNo\": \"1817\",\"GeometryText\": \"-\",\"Geometry\": {\n"+
          "\"$id\": \"115\",\"type\": \"LineString\",\"coordinates\": [[55.33279,25.26886],[55.33314,25.26797],[55.33249,25.26771 ],[55.33196,25.26755],[55.33147,25.26733 ],[55.33089,25.26717],[55.33063,25.2672],[55.33064,25.26776],[55.33072,25.26849],[55.33071,25.26907],[55.33064,25.26961],[55.33066,25.27013 ],[55.33098,25.2704],[55.33156,25.27057],[55.33225,25.27069],[55.3327,25.27078]]}}]}";

    private String  routeData="{\"$id\":\"1\",\"Message\":\"Sucess\",\"Status\":\"Success\",\"TotalDistance\":0.00884315523,\"Route\":[{\"$id\":\"2\",\"EdgeNo\":\"102\",\"GeometryText\":\"-\",\"Geometry\":{\"$id\":\"3\",\"type\":\"LineString\",\"coordinates\":[[78.571275,17.473804],[78.571132,17.473587],[78.570936,17.473375],[78.570724,17.473250],[78.570370,17.473004],[78.569989,17.472763],[78.569373,17.472311],[78.568690,17.471816],[78.568026,17.471415],[78.566716,17.470434],[78.565718,17.469347],[78.564651,17.468051]]}}]}";
    String SourcePosition="78.571275 17.473804";
    String DestinationPosition="78.564651 17.468051";
*/
    private TextView tv;
    private String routeDeviatedDT_URL="http://202.53.11.74/dtnavigation/api/routing/routenavigate";
    String BASE_MAP_URL_FORMAT = Environment.getExternalStorageDirectory() + File.separator + "MBTILES" + File.separator + "DubaiBasemap"+".mbtiles";
    private String AuthorisationKey="b3TIz98wORn6daqmthiEu48TAW1ZEQjPuRLapxJPV6HJQiJtO9LsOErPexmDhbZtD76U2AbJ+jXarYr3gAqkkcTQdIZD2yB0yS0HxRBNZ0ZlzbqtIT8INzSTINlwuSvCMGHdvxLqGdNOjixagtRXuQ==";
    String CSVFile_Path= Environment.getExternalStorageDirectory() + File.separator + "MBTILES" + File.separator + "RouteSample"+".txt";
  //  com.nsg.dtlibrary.NavigationProperties properties=new com.nsg.dtlibrary.NavigationProperties();

    NSGIMapFragmentActivity test = new NSGIMapFragmentActivity(BASE_MAP_URL_FORMAT,SourcePosition,DestinationPosition,routeData,routeDeviationBuffer,routeDeviatedDT_URL,AuthorisationKey);
  // NSGTiledLayerOnMap test = new NSGTiledLayerOnMap(BASE_MAP_URL_FORMAT);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_map);
        Start =(Button)findViewById(R.id.start);
        Start.setOnClickListener(this);
        Stop=(Button)findViewById(R.id.stop);
        Stop.setOnClickListener(this);


        Bundle NSGIBundle = getIntent().getExtras();
        charlsisNumber = NSGIBundle.getString("charlsisNumber");

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         if(charlsisNumber.equals("RD1")) {
              fragmentTransaction.add(R.id.map_container, test);
         }else if(charlsisNumber.equals("RD2")) {

        }
        fragmentTransaction.commit();

    }

   // @Override
  //  public String communicate(String comm) {
   //     return null;
  //  }

    @Override
    public String communicate(String comm, int alertType) {
        Log.d("received", " Recieved From ETA Listener---"+ comm + "alert type "+ alertType);
        if(alertType==MapEvents.ALERTTYPE_6){
            // if alert recieved you can start navigation here
           // test.startNavigation();
           // Log.e("Started","Started "+test.startNavigation());
        }else if(alertType==MapEvents.ALERTTYPE_1){

        }else if(alertType==MapEvents.ALERTTYPE_2){

        }else if(alertType==MapEvents.ALERTTYPE_3){

        }else if(alertType==MapEvents.ALERTTYPE_4){
            AlertDialog.Builder builder = new AlertDialog.Builder(NSGApiActivity.this, R.style.yourDialog);
            builder.setTitle("Alert");
            builder.setIcon(R.drawable.car_icon_32);
            builder.setMessage("Destination Reached")
                    .setCancelable(false)
                    .setPositiveButton("STOP", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                          //  you have to close the activity here  otherwise location will not stop and it leads to moving towards source position on "STOP" button
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();

        }else if(alertType==MapEvents.ALERTTYPE_5){

        }
        return comm;
    }
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onClick(View v) {
       if(v==Start){
           test.startNavigation();
           Log.e("Started","Started "+test.startNavigation());
       }else if(v==Stop){
           test.stopNavigation();
           Log.e("Stopped","Stopped "+test.stopNavigation());
       }
    }
}