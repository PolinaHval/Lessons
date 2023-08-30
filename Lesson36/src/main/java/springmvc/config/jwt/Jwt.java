//package springmvc.config.jwt;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.MalformedJwtException;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.UnsupportedJwtException;
//import org.springframework.beans.factory.annotation.Value;
//
//import io.jsonwebtoken.SignatureException;
//import org.springframework.stereotype.Component;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//@Component
//public class Jwt {
//
//  @Value("${jwtSecret}")
//  private String jwtSecret;
//
//
//  public String generateToken(String login) {
//    return Jwts.builder()
//        .setSubject(login)
//        .setExpiration(Date.from(Instant.now().plus(15, ChronoUnit.MINUTES)))
//        .signWith(SignatureAlgorithm.HS512, jwtSecret)
//        .compact();
//  }
//
//
//  public boolean validateToken(String token) {
//    try {
//      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
//      return true;
//    } catch (ExpiredJwtException expEx) {
//      System.out.println("Token expired");
//    } catch (UnsupportedJwtException unsEx) {
//      System.out.println("Unsupported jwt");
//    } catch (MalformedJwtException mjEx) {
//      System.out.println("Malformed jwt");
//    } catch (SignatureException sEx) {
//      System.out.println("Invalid signature");
//    } catch (Exception e) {
//      System.out.println("invalid token");
//    }
//    return false;
//  }
//
//
//  public String getLoginFromToken(String token) {
//    Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//    return claims.getSubject();
//  }
//}
