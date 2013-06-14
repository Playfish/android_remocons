/*
 * Copyright (C) 2013 Yujin Robot.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.github.robotics_in_concert.rocon_android.robot_remocon.zeroconf;

import android.content.Context;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.github.ros_java.zeroconf_jmdns_suite.jmdns.Zeroconf;


/**
 * Configures the zeroconf class for discovery of services.
 */

public class DiscoverySetup extends AsyncTask<Zeroconf, String, Void> {

	private ProgressDialog commencing_dialog; 
	private final Context context;

	public DiscoverySetup(Context context) {
		this.context = context;
	}
	
    protected Void doInBackground(Zeroconf... zeroconfs) {
        if ( zeroconfs.length == 1 ) {
            Zeroconf zconf = zeroconfs[0];
            android.util.Log.i("zeroconf", "*********** Discovery Commencing **************");

            zconf.addListener("_ros-master._tcp","local");
            zconf.addListener("_ros-master._udp","local");

        } else {
        	android.util.Log.i("zeroconf", "Error - DiscoveryTask::doInBackground received #zeroconfs != 1");
        }
        return null;
    }
}