package com.hh128.GodotHelloPlugin;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import com.simple.spiderman.SpiderMan;

public class spiderDebug extends Application
{
    Context ctx;
    @Override
    public void onCreate()
    {
        super.onCreate();
        SpiderMan.init(this);
        ctx=getApplicationContext();
        Toast.makeText(ctx,"test",Toast.LENGTH_LONG).show();
    }
}
