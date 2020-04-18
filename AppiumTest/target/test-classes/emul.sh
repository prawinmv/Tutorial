#!/bin/sh
echo Kill adb:
killall adb &
wait

echo Start adb:
adb start-server &
wait

echo Kill Node:
killall node &
wait

echo Start Appium:
emulator -avd Android29T &
appium &
sleep 2m