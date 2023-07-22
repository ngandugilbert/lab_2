import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EncryptTests {
    // test for encrytion
    @Test
    public void encryptTest() {
        // arrange
        var encrypt = new Encrypt();
        var expected = "0189";
        // act
        encrypt.encrypt("1234");
        var actual = encrypt.getEncrypted();
        // assert
        assertEquals(expected, actual);
    }

    // test for decryption
    @Test
    public void decryptTest() {
        // arrange
        var decrypt = new Decrypt();
        var expected = "1234";
        // act
        decrypt.decrypt("0189");
        var actual = decrypt.getKey();
        // assert
        assertEquals(expected, actual);
    }

}
