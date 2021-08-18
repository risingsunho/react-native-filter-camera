package com.reactnativefiltercamera;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class FilterCameraPackage implements ReactPackage {
  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {    
    List<ViewManager> modules = new ArrayList<>();
    modules.add(new FilterCameraViewManager(reactContext));
    return modules;
  }

  @Override
  public List<NativeModule> createNativeModules(
                              ReactApplicationContext reactContext) {   
    List<NativeModule> modules = new ArrayList<>();
    return modules;
  }

}