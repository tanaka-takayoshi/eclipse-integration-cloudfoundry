
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
package org.cloudfoundry.ide.eclipse.internal.server.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates whether a url name value.
 * <p/>
 * Valid url names should not include the protocol (e.g. http://www.google.com)
 * or queries in the name valid names are:
 * <p/>
 * www.google.com
 * <p/>
 * www$.google.com
 * <p/>
 * www.google.com4
 * <p/>
 * names with trailing or ending spaces, or spaces in between the name segments
 * are invalid.
 * 
 */
public class URLNameValidation {

	private final String value;

	public URLNameValidation(String value) {
		this.value = value;
	}

	private final Pattern VALID_CHARS = Pattern.compile("[A-Za-z\\$_0-9\\-.]+");

	public static boolean isEmpty(String value) {
		if (value == null) {
			return true;
		}
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isWhitespace(value.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean hasInvalidCharacters() {
		if (!isEmpty(value)) {
			Matcher matcher = VALID_CHARS.matcher(value);
			return !matcher.matches();
		}
		return true;
	}

}
