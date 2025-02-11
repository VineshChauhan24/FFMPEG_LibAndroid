package com.arthenica.ffmpegkit;

import com.arthenica.ffmpegkit.smartexception.java.Exceptions;


public class AsyncFFmpegExecuteTask implements Runnable {
    private final FFmpegSessionCompleteCallback completeCallback;
    private final FFmpegSession ffmpegSession;

    public AsyncFFmpegExecuteTask(FFmpegSession ffmpegSession) {
        this.ffmpegSession = ffmpegSession;
        this.completeCallback = ffmpegSession.getCompleteCallback();
    }

    @Override // java.lang.Runnable
    public void run() {
        FFmpegKitConfig.ffmpegExecute(this.ffmpegSession);
        if (this.completeCallback != null) {
            try {
                this.completeCallback.apply(this.ffmpegSession);
            } catch (Exception e) {
                android.util.Log.e("ffmpegkit-kit", String.format("Exception thrown inside session complete callback.%s", Exceptions.getStackTraceString(e)));
            }
        }
        FFmpegSessionCompleteCallback globalFFmpegSessionCompleteCallback = FFmpegKitConfig.getFFmpegSessionCompleteCallback();
        if (globalFFmpegSessionCompleteCallback != null) {
            try {
                globalFFmpegSessionCompleteCallback.apply(this.ffmpegSession);
            } catch (Exception e2) {
                android.util.Log.e("ffmpegkit-kit", String.format("Exception thrown inside global complete callback.%s", Exceptions.getStackTraceString(e2)));
            }
        }
    }
}
