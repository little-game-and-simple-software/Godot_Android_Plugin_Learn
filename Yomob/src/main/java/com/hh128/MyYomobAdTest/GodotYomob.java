package com.hh128.MyYomobAdTest;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.soulgame.sgsdk.tgsdklib.TGSDK;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;

import java.util.Arrays;
import java.util.List;

public class GodotYomob extends GodotPlugin
{
    public FrameLayout layout;
    public String canShowAd="";
    public GodotYomob(Godot godot)
    {
        super(godot);
        // MyContext=getActivity();//.getApplicationContext();
    }
    @Override
    public View onMainCreate(Activity activity)
    {
        this.layout=new FrameLayout(activity);
        return this.layout;
    }
    @NonNull
    @Override
    public String getPluginName()
    {
        return "GodotYomob";
    }
    @NonNull
    @Override
    public List<String> getPluginMethods()
    {
        return Arrays.asList(new String[]{"init","showTestAd","showAd"});
        // return Collections.singletonList("helloWorld");
    }
    //广告联盟预加载
    public void preload()
    {
        TGSDK.preloadAd(getActivity());
    }
    //初始化
    public void init(String AppId)
    {
        TGSDK.initialize(getActivity(),AppId,null);
    }
    //测试广告 //必须在debug模式下,且preloadSuccess之后可以使用
    public void showTestAd(String SceneId)
    {
        TGSDK.showTestView(getActivity(),SceneId);

    }
    //开启Debug模式
    public void enableDebug()
    {
        TGSDK.setDebugModel(true);
    }
    //展示广告
    public String showAd(String sceneId)
    {
        if(TGSDK.couldShowAd(sceneId))
        {
            TGSDK.showAd(getActivity(),sceneId);
        }
        else
            {
                canShowAd="can't show ad!";
            }
        return  canShowAd;
    }
}
