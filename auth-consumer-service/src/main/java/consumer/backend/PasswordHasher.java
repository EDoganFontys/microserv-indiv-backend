package consumer.backend;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordHasher {
    public static String hashPassword(String password){
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        return bcryptHashString;
    }
}
