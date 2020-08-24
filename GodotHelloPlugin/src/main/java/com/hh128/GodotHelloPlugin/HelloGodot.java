package com.hh128.GodotHelloPlugin;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.collection.ArraySet;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.SignalInfo;

import java.util.Set;

public class HelloGodot extends GodotPlugin
{
    //游戏主activity
    private Activity activity=null;

    //Godot是继承自activity的类 从这里获得activity实例
    public HelloGodot(Godot godot)
    {
        super(godot);
        activity=godot;
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
    }

    @NonNull
    //返回安卓插件的名称
    @Override
    public String getPluginName()
    {
        return "HelloGodot";
    }
}
