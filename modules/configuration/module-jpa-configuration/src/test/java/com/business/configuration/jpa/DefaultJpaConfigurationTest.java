package com.business.configuration.jpa;

import com.business.JpaTestApplication;
import com.business.configuration.repository.jpa.ProductRepository;
import com.business.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
/**
 * <b>  </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-06-24
 */
@Slf4j
@ActiveProfiles("test")
@SpringBootTest(classes = JpaTestApplication.class)
class DefaultJpaConfigurationTest {
    @Autowired
    private ProductRepository productRepository;


    @Test
    void testCreatReadDelete() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("This is a test product");
        product.setPrice(BigDecimal.valueOf(19.99));
        product.setCreatedAt(LocalDateTime.now());

        productRepository.save(product);

        List<Product> products = productRepository.findAll();
        assertNotNull(products);

        Product testProduct = productRepository.findById(product.getId()).orElse(null);
        assertThat(testProduct).isNotNull();
        assertThat(testProduct.getName()).isEqualTo(product.getName());



        productRepository.delete(product);
        assertThat(productRepository.findById(product.getId())).isNotPresent();

    }

}