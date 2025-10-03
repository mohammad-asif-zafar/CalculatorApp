package com.hathway.kmm_basic_app.cal

import platform.UIKit.UIAlertAction
import platform.UIKit.UIAlertActionStyleDefault
import platform.UIKit.UIAlertController
import platform.UIKit.UIAlertControllerStyleAlert
import platform.UIKit.UIApplication

actual fun showToast(message: String) {
    val alert = UIAlertController.Companion.alertControllerWithTitle(
        title = null,
        message = message,
        preferredStyle = UIAlertControllerStyleAlert
    )
    alert.addAction(
        UIAlertAction.Companion.actionWithTitle(
        title = "OK",
        style = UIAlertActionStyleDefault,
        handler = null
    ))

    val rootVC = UIApplication.Companion.sharedApplication.keyWindow?.rootViewController
    rootVC?.presentViewController(alert, animated = true, completion = null)
}