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
import java.net.ProxySelector;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

/**
 * 
 */
public class AccessTokenClient {

	private final OAuth2Client client;

	/**
	 * Create access token client
	 * 
	 * @param client
	 */
	public AccessTokenClient(OAuth2Client client) {
		this.client = client;
	}

	/**
	 * Execute request and return response
	 * 
	 * @param target
	 * @param request
	 * @return response
	 * @throws IOException
	 */
	protected HttpResponse execute(HttpHost target, HttpRequest request)
			throws IOException {
		DefaultHttpClient client = new DefaultHttpClient();
		client.setRoutePlanner(new ProxySelectorRoutePlanner(client
				.getConnectionManager().getSchemeRegistry(), ProxySelector
				.getDefault()));
		return client.execute(target, request);
	}

	/**
	 * Get token from resposne entity
	 * 
	 * @param entity
	 * @return token or null if not present in given entity
	 * @throws IOException
	 */
	protected String getToken(HttpEntity entity) throws IOException {
		String content = EntityUtils.toString(entity, HTTP.ASCII);
		if (content == null || content.length() == 0)
			return null;
		List<NameValuePair> responseData = new ArrayList<NameValuePair>();
		URLEncodedUtils.parse(responseData, new Scanner(content), null);
		for (NameValuePair param : responseData)
			if (IOAuth2Constants.PARAM_ACCESS_TOKEN.equals(param.getName())) {
				String token = param.getValue();
				if (token != null && token.length() > 0)
					return token;
			}
		return null;
	}

	/**
	 * Get params for access token request
	 * 
	 * @param code
	 * @return list of params
	 */
	protected List<NameValuePair> getParams(String code) {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair(IOAuth2Constants.PARAM_CLIENT_ID,
				client.getId()));
		params.add(new BasicNameValuePair(IOAuth2Constants.PARAM_CLIENT_SECRET,
				client.getSecret()));
		params.add(new BasicNameValuePair(IOAuth2Constants.PARAM_CODE, code));
		return params;
	}

	/**
	 * Get access token using given code
	 * 
	 * @param code
	 * @return fetched token
	 * @throws IOException
	 */
	public String fetch(final String code) throws IOException {
		URI uri = URI.create(client.getAccessTokenUrl());
		HttpHost target = URIUtils.extractHost(uri);
		List<NameValuePair> params = getParams(code);
		HttpPost request = new HttpPost(uri.getRawPath());
		if (params != null && !params.isEmpty())
			request.setEntity(new UrlEncodedFormEntity(params));
		HttpResponse response = execute(target, request);
		String token = getToken(response.getEntity());
		if (token == null)
			throw new IOException("Access token not present in response"); //$NON-NLS-1$
		return token;
	}
}
