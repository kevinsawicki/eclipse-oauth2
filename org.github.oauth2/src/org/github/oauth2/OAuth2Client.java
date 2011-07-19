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
 * OAuth2 client class.
 */
public class OAuth2Client {

	private String accessTokenUrl;

	private String authorizeUrl;

	private String id;

	private String redirectUri = IOAuth2Constants.FAKE_REDIRECT;

	private String secret;

	/**
	 * @return accessTokenUrl
	 */
	public String getAccessTokenUrl() {
		return accessTokenUrl;
	}

	/**
	 * @param accessTokenUrl
	 */
	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	/**
	 * @return authorizeUrl
	 */
	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	/**
	 * @param authorizeUrl
	 */
	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 * @return this client
	 */
	public OAuth2Client setId(String id) {
		this.id = id;
		return this;
	}

	/**
	 * @return redirectUri
	 */
	public String getRedirectUri() {
		return redirectUri;
	}

	/**
	 * @param redirectUri
	 * @return this client
	 */
	public OAuth2Client setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
		return this;
	}

	/**
	 * @return secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret
	 * @return this client
	 */
	public OAuth2Client setSecret(String secret) {
		this.secret = secret;
		return this;
	}
}
