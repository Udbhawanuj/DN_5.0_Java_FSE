# Security Hands-on

## JWT
1. Start `auth-service` on 8501.
2. `POST http://localhost:8501/auth/token?username=udbhaw`.
3. Copy `access_token` and call `GET /secure/profile` with `Authorization: Bearer <token>`.
4. The same token works against `secure-resource-service` on port 8503 because both classroom modules share the demo HMAC secret.

## OAuth2/OIDC
Set `GOOGLE_CLIENT_ID` and `GOOGLE_CLIENT_SECRET`, run `oauth-client-demo`, then open `/oauth2/authorization/google`. Secrets are intentionally not committed.
