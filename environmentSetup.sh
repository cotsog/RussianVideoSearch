#!/bin/bash

# Fix the CircleCI path
function getAndroidSDK(){
  export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

  DEPS="$ANDROID_HOME/installed-dependencies"

  if [ ! -e $DEPS ]; then
    cp -r /usr/local/android-sdk-linux $ANDROID_HOME &&
    echo y | android update sdk -u -a -t android-22 &&
    echo y | android update sdk -u -a -t platform-tools &&
    echo y | android update sdk -u -a -t build-tools-22.0.1 &&
    echo y | android update sdk -u -a -t sys-img-x86-android-22 &&
    echo y | android update sdk -u -a -t addon-google_apis-google-22 &&
    echo no | android create avd -n testAVD -f -t android-22 --abi default/x86 &&
    touch $DEPS
  fi
}

function waitAVD() {
    local bootanim=""
    export PATH=$(dirname $(dirname $(which android)))/platform-tools:$PATH
    until [[ "$bootanim" =~ "stopped" ]]; do
      sleep 5
      bootanim=$(adb -e shell getprop init.svc.bootanim 2>&1)
      echo "emulator status=$bootanim"
    done
}