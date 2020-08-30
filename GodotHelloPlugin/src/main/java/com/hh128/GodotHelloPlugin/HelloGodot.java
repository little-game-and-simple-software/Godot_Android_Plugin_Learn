package com.hh128.GodotHelloPlugin;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;


import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.SignalInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
public class HelloGodot extends GodotPlugin
{
    //游戏主activity
    public Activity activity=null;
    public FrameLayout layout=null;
    //Godot是继承自activity的类 从这里获得activity实例
    public HelloGodot(Godot godot)
    {
        super(godot);
        //判断godot是否为null
        if(godot==null)
        {
            activity = getActivity();
        }
        else
        {
            activity=getActivity();
        }

    }
    @Override
    public View onMainCreate(Activity activity2)
    {
        this.layout=new FrameLayout(activity);
        return this.layout;
    }

    //返回给godot调用的方法名称 用于映射和架桥
    @NonNull
    @Override
    public List<String> getPluginMethods()
    {

        return Arrays.asList(new String[]{"test","test2"});
       // return Collections.singletonList("helloWorld");
    }

    @NonNull
    @Override
    public Set<SignalInfo> getPluginSignals()
    {
        //信号集合 存自定义信号的地方 用于和godot信号系统交互
        Set<SignalInfo> signals = new ArraySet<SignalInfo>();

        signals.add(new SignalInfo("on_test"));

        return signals;
        //return super.getPluginSignals();
    }
    //自定义方法
    // var s=Engine.get_singleton("GodotAdMob")之后
    //s.test()可以直接调用这个方法 应该必须是public方法

    public void test()
    {
        Toast.makeText(activity,"我的测试",Toast.LENGTH_LONG).show();
     //   Toast.makeText(getActivity().getApplicationContext(),"test",Toast.LENGTH_LONG).show();
    }
    public String test2()
    {
        return "test2";
    }
    @NonNull
    //返回安卓插件的名称
    @Override
    public String getPluginName()
    {
        return "HelloGodot";
    }
}
