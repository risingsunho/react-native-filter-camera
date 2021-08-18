import { UIManager, findNodeHandle } from 'react-native';
export function switchFlash(cameraRef) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    'switchFlash',
    []
  );
}
export function switchCameraDirection(cameraRef) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    'switchCameraDirection',
    []
  );
}
export function setContrast(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    'setContrast',
    value
  );
}
export function setBrightness(cameraRef, value) {
  UIManager.dispatchViewManagerCommand(
    findNodeHandle(cameraRef.current),
    'setBrightness',
    value
  );
}
