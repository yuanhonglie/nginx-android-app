package org.screenshare.rtmp.android.nginx;

import java.io.File;

import org.screenshare.rtmp.android.nginx.utils.NginxConfigureTask;
import org.screenshare.rtmp.nginx.Nginx;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Nginx Application.
 */
public class NginxApplication extends Application {
	private static final String TAG = NginxApplication.class.getSimpleName();
	@Override
	public void onCreate() {
		super.onCreate();

		File root = getDir("nginx", Context.MODE_PRIVATE);
		Nginx.create().setPrefixPath(root);
		Log.i(TAG, "onCreate: sdcard = " + root);
		(new NginxConfigureTask(this, root)).execute(
				NginxConfigureTask.NGINX_CONF_FILENAME,
				NginxConfigureTask.NGINX_MIMETYPES_FILENAME,
				NginxConfigureTask.NGINX_HTTP_INDEX_FILENAME,
				NginxConfigureTask.NGINX_HTTP_50x_FILENAME);
		}

}
