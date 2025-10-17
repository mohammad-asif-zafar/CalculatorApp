package com.hathway.kmm_basic_app

import platform.UIKit.UIDevice

actual class BatteryManager {
    actual fun getBatteryLevel(): Int {
        val device = UIDevice.currentDevice
        device.batteryMonitoringEnabled = true
        val batteryLevel = device.batteryLevel
        // batteryLevel is a float between 0.0 and 1.0; -1.0 if unavailable
        return if (batteryLevel < 0.0) {
            -1
        } else {
            (batteryLevel * 100).toInt()
        }
    }
}