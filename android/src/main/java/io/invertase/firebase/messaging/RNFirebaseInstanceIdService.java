package io.invertase.firebase.messaging;


import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceIdService;

public class RNFirebaseInstanceIdService extends FirebaseInstanceIdService {
  private static final String TAG = "RNFInstanceIdService";
  public static final String TOKEN_REFRESH_EVENT = "messaging-token-refresh";

  @Override
  public void onTokenRefresh() {
    Log.d(TAG, "onTokenRefresh event received");

    // Build an Intent to pass the token to the RN Application
    Intent tokenRefreshEvent = new Intent(TOKEN_REFRESH_EVENT);

    // Broadcast it so it is only available to the RN Application
    LocalBroadcastManager.getInstance(this).sendBroadcast(tokenRefreshEvent);
  }
}
