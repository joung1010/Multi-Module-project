package com.business.endpoint.member.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * <b> CoreMemberSearchApiControllerTest </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-04
 */

@SpringBootTest
class CoreMemberSearchApiControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Test
    void searchMemberInfo() throws Exception {
        // MockMvc 초기화
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        // Given
        String invalidMemberId = "1";

        // When & Then
        mockMvc.perform(get("/api/core/v1/member/{memberId}", invalidMemberId))
                .andExpect(status().isOk());
    }
}