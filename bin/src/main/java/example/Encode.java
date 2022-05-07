package example;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * This is the Main class.
 */
public class Encode {

  private final Argon2 argon2 = Argon2Factory.create();

  public String hashpw(String plainText) {
      return encrypt(plainText);
  }

  public boolean verify(String plainText, String hashedStr) {
      return argon2.verify(hashedStr, plainText.toCharArray());
  }

  private String encrypt(String plainText)
  {
      char[] passwordChars = plainText.toCharArray();
      String hash = argon2.hash(22, 65536, 1, passwordChars);
      argon2.wipeArray(passwordChars);
      return hash;
  }
}
