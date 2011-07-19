/******************************************************************************
 *  Copyright (c) 2011 GitHub Inc.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *    Kevin Sawicki (GitHub Inc.) - initial API and implementation
 *****************************************************************************/
package org.github.oauth2;

/**
 * OAuth2 constants
 */
public interface IOAuth2Constants {

	/**
	 * PARAM_ACCESS_TOKEN
	 */
	String PARAM_ACCESS_TOKEN = "access_token"; //$NON-NLS-1$

	/**
	 * PARAM_CLIENT_ID
	 */
	String PARAM_CLIENT_ID = "client_id"; //$NON-NLS-1$

	/**
	 * PARAM_CLIENT_SECRET
	 */
	String PARAM_CLIENT_SECRET = "client_secret"; //$NON-NLS-1$

	/**
	 * PARAM_CODE
	 */
	String PARAM_CODE = "code"; //$NON-NLS-1$

	/**
	 * PARAM_REDIRECT_URI
	 */
	String PARAM_REDIRECT_URI = "redirect_uri"; //$NON-NLS-1$

	/**
	 * PARAM_SCOPE
	 */
	String PARAM_SCOPE = "scope"; //$NON-NLS-1$

	/**
	 * FAKE_REDIRECT
	 */
	String FAKE_REDIRECT = "http://internaleclipseoauth.com"; //$NON-NLS-1$
}
