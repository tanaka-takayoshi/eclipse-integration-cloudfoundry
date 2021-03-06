/*******************************************************************************
 * Copyright (c) 2012 VMware, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     VMware, Inc. - initial API and implementation
 *******************************************************************************/
package org.cloudfoundry.ide.eclipse.internal.server.ui;

import org.cloudfoundry.ide.eclipse.internal.server.core.CloudFoundryServer;

public class CloudFoundryURLNavigation extends UIWebNavigationHelper {

	public static final CloudFoundryURLNavigation CF_SIGNUP_URL = new CloudFoundryURLNavigation(
			"http://cloudfoundry.com/signup?utm_source=sts&utm_medium=link&utm_campaign=cloudfoundry-signup");

	public static final CloudFoundryURLNavigation INSIGHT_URL = new CloudFoundryURLNavigation(
			"http://insight.cloudfoundry.com/");

	public CloudFoundryURLNavigation(String location) {
		super(location, "Opening " + location);
	}

	public static boolean canEnableCloudFoundryNavigation(String locationURL) {
		return locationURL != null && locationURL.contains("api.cloudfoundry.com");
	}

	public static boolean canEnableCloudFoundryNavigation(CloudFoundryServer server) {
		if (server == null) {
			return false;
		}
		String url = server.getUrl();
		return canEnableCloudFoundryNavigation(url);
	}

}
