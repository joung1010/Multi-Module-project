package com.business.configuration.jasypt;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static com.business.configuration.jasypt.JasyptConfig.BEAN_NAME;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-05-27
 */
@Slf4j
@SpringBootTest(classes = { JasyptConfig.class })
class JasyptConfigTest {

    @Qualifier(value = BEAN_NAME)
    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    void jasyptTest() {
        // given
        final String url  = "jdbc:mysql://localhost:3305/mydatabase";
        final String user = "root";
        final String password = "1q2w3e";

        String encryptedUrl = stringEncryptor.encrypt(url);
        String encryptedUser = stringEncryptor.encrypt(user);
        String encryptedPassword = stringEncryptor.encrypt(password);

        // then
        log.info("Encrypted URL: {}", encryptedUrl);
        log.info("Encrypted User: {}", encryptedUser);
        log.info("Encrypted Password: {}", encryptedPassword);

        // assertions (optional)
        assertNotNull(encryptedUrl);
        assertNotNull(encryptedUser);
        assertNotNull(encryptedPassword);
    }

}