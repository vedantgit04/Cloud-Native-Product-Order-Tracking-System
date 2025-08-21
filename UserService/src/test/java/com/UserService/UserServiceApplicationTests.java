//package com.UserService;
//
//import com.UserService.Security.Repo.JpaRegisteredClientRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.OidcScopes;
//import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
//import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
//import org.springframework.test.annotation.Commit;
//
//import java.util.UUID;
//
////@SpringBootTest
//class UserServiceApplicationTests {
//	  @Autowired
//      private JpaRegisteredClientRepository jpaRegisteredClientRepository;
//	@Test
//	void contextLoads() {
//	}
////
////	@Test
////	@Commit // This ensures the transaction is committed to the database
////	void StoredRegisterdClientIntoDB() {
////		RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
////				.clientId("oidc-client")
////				.clientSecret("{noop}secret") // Use {noop} so 'secret' is stored as-is
////				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
////				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
////				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
////				.redirectUri("https://oauth.pstmn.io/v1/callback") // The Postman callback URL
////				.postLogoutRedirectUri("http://localhost:8080/")   // A sensible post-logout URL
////				.scope(OidcScopes.OPENID)
////				.scope(OidcScopes.PROFILE)
////				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
////				.build();
////
////		jpaRegisteredClientRepository.save(oidcClient);
////	}
//
//
//}
