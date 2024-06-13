package org.ltde.glowboard.service;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;

@Service
public class AuthenticationService {

    @Value("${GLOW_AWS_COGNITO_CLIENT_ID}")
    private String clientId;

    @Value("${GLOW_AWS_COGNITO_USERPOOL_ID}")
    private String userPoolId;

    @Autowired
    private AWSCognitoIdentityProvider cognitoClient;

    public void authenticateUser(String username, String password) {
        AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest()
                .withClientId(clientId)
                .withUserPoolId(userPoolId)
                .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                .withAuthParameters(new HashMap<>() {{
                    put("USERNAME", username);
                    put("PASSWORD", password);
                }});

        AdminInitiateAuthResult authResult = cognitoClient.adminInitiateAuth(authRequest);
        // Process authentication result
    }
}