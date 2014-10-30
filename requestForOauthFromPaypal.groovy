@Grapes(
        @Grab(group='com.paypal.sdk', module='paypal-core', version='1.6.4')
)
Map<String, String> configurationMap = new HashMap<String, String>();
        configurationMap.put("mode", "sandbox");

import com.paypal.core.ClientCredentials
import com.paypal.core.ConfigManager
import com.paypal.core.rest.APIContext
import com.paypal.core.rest.OAuthTokenCredential
import com.paypal.sdk.openidconnect.CreateFromAuthorizationCodeParameters
import com.paypal.sdk.openidconnect.Session
import com.paypal.sdk.openidconnect.Tokeninfo

//APIContext apiContext = new APIContext();
//
//apiContext.setConfigurationMap(configurationMap);
//
//List<String> scopelist = new ArrayList<String>();
//scopelist.add("openid");
//scopelist.add("email");
//String redirectURI = "https://devtools-paypal.com/";
//
//ClientCredentials clientCredentials = new ClientCredentials();
//clientCredentials.setClientID("AS1GgBA_7tDGfOz_U9XtZKTq7E2EnwusonjKyv2JG0XNm82FRlIj9lhtG0Qf");
//
//String redirectUrl = Session.getRedirectURL(redirectURI, scopelist, apiContext, clientCredentials);
//
//println redirectUrl

//Map<String, String> configurationMap = new HashMap<String, String>();
//configurationMap.put("mode", "sandbox");

APIContext apiContext = new APIContext();
apiContext.setConfigurationMap(configurationMap);

CreateFromAuthorizationCodeParameters param = new CreateFromAuthorizationCodeParameters();
param.setClientID("AS1GgBA_7tDGfOz_U9XtZKTq7E2EnwusonjKyv2JG0XNm82FRlIj9lhtG0Qf");
param.setClientSecret("EBNljhDt9vjWdnPFJJZP1UaYcMfITzq-gaHQYU6fGYlfxOd0ljgKxhXHq4y8");
param.setCode("TgDIC7-ChpHtpFVQ7IXlqXAzhg3pqxvEM2AkSFzH-qGcoNWiwey9c3G89aBeyxuyvLQcs7FwlxdFJ3cEwn3TB9-lqamqXmeIZTodxaGMeeLQvFw-l01zYSN8PK8d2kWieMfclKgb9M5Xw8plU3yhQbMGWpE5CG2a_qfpjcbeiAAwX761");

Tokeninfo info = Tokeninfo.createFromAuthorizationCode(apiContext, param);
String accessToken = info.getAccessToken();
print accessToken

