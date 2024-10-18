## Principes de base de Spring Security

### 1. La sécurité est effectuée par des filtres.
- Lorsque la requête est envoyée, elle est interceptée par un filtre d'authentification: l'`AuthenticationFilter`
- Ensuite l'AuthenticationFilter délègue la responsabilité auprès d'un gestionnaire d'auth: l'`AuthenticationManager`
- L'AuthenticationManager implémente un `provider`, ie un fournisseur d'auth qui lui, utilise le `UserDetailsService`
- Le UserDetailsService est toujour associé à un `PasswordEncoder` pour crypter le mot de passe de l'utilisateur.
- Le UserDetailsService a une seule responsabilité, c'est retrouver l'utilisateur qui dans la bd par son username,
    son email, ou son code.