# eclipse-oauth2

Simple plug-in to get an [OAuth2](http://tools.ietf.org/html/draft-ietf-oauth-v2-18)
access token for a given site using the Eclipse browser widget in a dialog.

## Example

```java
OAuth2Client client = new OAuth2Client();
client.setId("00000000000000000000"); // client_id
client.setSecret("0000000000000000000000000000000000000000"); // client_secret
client.setAccessTokenUrl("https://github.com/login/oauth/access_token");
client.setAuthorizeUrl("https://github.com/login/oauth/authorize");

//Opens the dialog
OAuth2RequestAction request = new OAuth2RequestAction(client, "repo");
request.run();

String token = request.getAccessToken(); // access_token
```
