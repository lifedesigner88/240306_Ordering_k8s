package com.example.ordering.member.domain;


import com.example.ordering.member.dto.MemberCreateReqDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Embedded
    private Address address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;




    public static Member toEntity(MemberCreateReqDto member, String Password){
        Address address = new Address(
                member.getCity(),
                member.getStreet(),
                member.getZipcode()
        );
        return Member.builder()
                .name(member.getName())
                .email(member.getEmail())
                .password(Password)
                .address(address)
                .role(Role.USER)
                .build();
    }

//    Time
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;
}
