import React, { createRef, useState } from 'react';
import { View, TouchableOpacity, Text } from 'react-native';

import { FilterCameraView } from 'react-native-filter-camera';
import * as script from './script';
import styles from './style';

export default function App() {
  const cameraRef = createRef();
  return (
    <View style={styles.cameraContainer}>
      <FilterCameraView ref={cameraRef} style={styles.cameraContainer} />
      <View
        style={{
          position: 'absolute',
        }}
      >
        <TouchableOpacity
          style={styles.menuButton}
          onPress={() => {
            script.switchCameraDirection(cameraRef);
          }}
        >
          <Text style={{ color: 'white' }}>switch</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={styles.menuButton}
          onPress={() => {
            script.setContrast(cameraRef, [2]);
          }}
        >
          <Text style={{ color: 'white' }}>contrast</Text>
        </TouchableOpacity>
        <TouchableOpacity
          style={styles.menuButton}
          onPress={() => {
            script.setBrightness(cameraRef, [2]);
          }}
        >
          <Text style={{ color: 'white' }}>bright</Text>
        </TouchableOpacity>
      </View>
    </View>
  );
}
