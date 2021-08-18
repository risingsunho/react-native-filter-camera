# react-native-filter-camera

Filtered camera for react-native android

This library is a bridge between CameraView (https://github.com/natario1/CameraView) 

and react-native.


## Installation

```sh
npm install react-native-filter-camera
```

## Usage
```script.js
import { UIManager, findNodeHandle } from "react-native";
export function switchFlash(cameraRef) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "switchFlash",
    []
  );
}
export function switchCameraDirection(cameraRef) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "switchCameraDirection",
    []
  );
}
export function setContrast(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "setContrast",
    value
  );
}
export function setBrightness(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "setBrightness",
    value
  );
}
export function takePicture(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "takePicture",
    value
  );
}
export function toggleVideo(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "toggleVideo",
    value
  );
}
export function setRatio(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "ratio",
    value
  );
}

export function setFilter(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    "setFilter",
    value
  );
}

```
```view.js
import { FilterCameraView } from "react-native-filter-camera";
import * as script from "./script";
// ...

const takePicture=()=>{
  var fileName = "id_" + new Date().getTime();
  script.takePicture(cameraRef, [fileName]);
}
// ...

<FilterCameraView
  ref={cameraRef}
  onPictureTaken={onPictureTaken}
  onVideoRecordingStart={onVideoRecordingStart}
  onVideoTaken={onVideoTaken}
  onVideoRecordingEnd={onVideoRecordingEnd}
  style={{ width: "100%", height: "100%" }}
/>

 ```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
