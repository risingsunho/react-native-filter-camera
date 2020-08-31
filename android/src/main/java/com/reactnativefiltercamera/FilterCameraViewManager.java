package com.reactnativefiltercamera;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;

import com.facebook.react.uimanager.ViewGroupManager ;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.SimpleViewManager;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;


import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraListener;
import com.otaliastudios.cameraview.CameraOptions;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.FileCallback;
import com.otaliastudios.cameraview.PictureResult;
import com.otaliastudios.cameraview.VideoResult;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.filter.Filter;
import com.otaliastudios.cameraview.filter.Filters;
import com.otaliastudios.cameraview.filter.MultiFilter;
import com.otaliastudios.cameraview.filters.BrightnessFilter;
import com.otaliastudios.cameraview.filters.ContrastFilter;


public class FilterCameraViewManager extends ViewGroupManager<CameraView> {

    public static final String REACT_CLASS = "FilterCameraView";
    ReactApplicationContext mCallerContext;


    private CameraView cameraView;

    private ContrastFilter contrastFilter;
    private BrightnessFilter brightnessFilter;
  
    public FilterCameraViewManager(ReactApplicationContext reactContext) {
      mCallerContext = reactContext;
      contrastFilter=new ContrastFilter();
      brightnessFilter=new BrightnessFilter();
    }
    
    @Override
    public String getName() {
      return REACT_CLASS;
    }

    @Override
    public CameraView createViewInstance(ThemedReactContext context) {
      if(cameraView!=null)
      {
        cameraView.destroy();
      }
      cameraView=new CameraView(context);      
      cameraView.setLifecycleOwner((AppCompatActivity)context.getCurrentActivity());                 
        return cameraView;
    }

    @Override
    public void receiveCommand(CameraView view, String commandId, @Nullable ReadableArray args) {
      super.receiveCommand(view, commandId, args);
      switch (commandId) {
        case "switchCameraDirection":
            switchCameraDirection(view);
          break;
        case "switchFlash":
            switchFlash(view);
          break;
        case "setContrast":
            if (args != null) {
              double value=args.getDouble(0);              
              setContrast(view,value);
            }            
        break;
        case "setBrightness":
            if (args != null) {
              double value=args.getDouble(0);              
              setBrightness(view,value);
            }            
        break;
        case "takePicture":
              takePicture(view);                
        break;
        case "toggleVideo": 
             takeVideo(view);          
                   
        break;
      }
    }

    private void takeVideo(CameraView view){
      if(view.isTakingVideo() == false){
          // view.takeVideoSnapshot(new File("/data/com.hello", "video.mp4"));
      }else if(view.isTakingVideo() == true){
          view.stopVideo();
      }
    }
    private void takePicture(CameraView view){
      view.takePictureSnapshot();
    }

    private void switchFlash(CameraView view){
          if(view.getFlash() == Flash.OFF){
            view.setFlash(Flash.TORCH);
        }else if(view.getFlash() == Flash.TORCH){
          view.setFlash(Flash.OFF);
        }
    }


    private void switchCameraDirection(CameraView view) {
        if(view.getFacing() == Facing.FRONT){
          view.setFacing(Facing.BACK);
        }else if(view.getFacing() == Facing.BACK){
          view.setFacing(Facing.FRONT);
        }
    }

    private void setContrast(CameraView view,double progress) {        
        contrastFilter.setContrast((float)progress);
        cameraView.setFilter(new MultiFilter(brightnessFilter, contrastFilter));
    }

    private void setBrightness(CameraView view,double progress) {
        brightnessFilter.setBrightness((float)progress);
        cameraView.setFilter(new MultiFilter(brightnessFilter, contrastFilter));
    }
}