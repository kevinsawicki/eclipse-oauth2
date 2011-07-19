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

import java.io.IOException;

import org.eclipse.jface.action.Action;

/**
 * Action to get an OAuth2 access token for a client
 */
public class OAuth2RequestAction extends Action {

	private final OAuth2Client client;

	private final String scope;

	private String token;

	/**
	 * Create request for client and scope
	 * 
	 * @param client
	 * @param scope
	 */
	public OAuth2RequestAction(OAuth2Client client, String scope) {
		this.client = client;
		this.scope = scope;
	}

	@Override
	public void run() {
		String code = OAuth2BrowserDialog.getCode(client, scope);
		if (code != null)
			try {
				token = new AccessTokenClient(client).fetch(code);
			} catch (IOException ignored) {
				// Ignored
			}
	}

	/**
	 * Get token
	 * 
	 * @return token
	 */
	public String getAccessToken() {
		return token;
	}
}
