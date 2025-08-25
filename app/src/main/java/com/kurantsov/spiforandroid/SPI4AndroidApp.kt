package com.kurantsov.spiforandroid

import android.app.Application
import android.util.Log
import com.kurantsov.pushservice.PushServiceManager
import com.kurantsov.pushservice.PushToken

class SPI4AndroidApp : Application() {

    override fun onCreate() {
        super.onCreate()
        PushServiceManager.addOnPushTokenChangedListener(::uploadPushTokenToServer)
        PushServiceManager.addPushMessageListener(::handlePushMessage)
    }

    private fun uploadPushTokenToServer(pushToken: PushToken.Initialized) {
        // Make API request to BE to upload the token to the server
        Log.d(
            "WHAT",
            "Make API request to BE to upload the token to the server :: PushToken: $pushToken"
        )
    }

    private fun handlePushMessage(message: Map<String, String>, sender: String) {
        // Process push message
        Log.d("WHAT", "Process push message, $message :: Sender:$ $sender")
    }
}
