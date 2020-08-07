import { NativeModules } from 'react-native';

type FilterCameraType = {
  multiply(a: number, b: number): Promise<number>;
};

const { FilterCamera } = NativeModules;

export default FilterCamera as FilterCameraType;
