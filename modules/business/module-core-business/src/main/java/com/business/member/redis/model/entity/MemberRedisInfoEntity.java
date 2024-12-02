package com.business.member.redis.model.entity;

import com.business.configuration.redis.utils.generator.RedisKeyGenerator;
import com.business.member.redis.model.MemberRedisAddressVo;
import com.business.member.redis.model.MemberRedisShippingAddressVo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * <b> MemberRedisInfoEntity </b>
 *
 * @author jh.park
 * @version 0.1.0
 * @since 2024-11-25
 */


@Getter
@RedisHash(value = MemberRedisInfoEntity.HASH_KEY)
public class MemberRedisInfoEntity implements Serializable {
    public static final String HASH_KEY = "MEMBER_INFO";
    private static final long serialVersionUID = -4605894674165584009L;

    private Long memberId;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private LocalDate birthdate;
    private List<MemberRedisAddressVo> memberAddress;
    private List<MemberRedisShippingAddressVo> shippingAddress;

    @Id
    @AccessType(value = AccessType.Type.PROPERTY)
    public String getId() {
        return RedisKeyGenerator.generateKey(HASH_KEY,String.valueOf(memberId));
    }

    public void setId(String id) {}

    public void setMemberAddressInfo(List<MemberRedisAddressVo> address
            , List<MemberRedisShippingAddressVo> shipAddress) {

    }


}
