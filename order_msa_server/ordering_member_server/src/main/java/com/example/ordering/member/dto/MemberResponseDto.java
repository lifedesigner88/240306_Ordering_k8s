package com.example.ordering.member.dto;


import com.example.ordering.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {
    private Long id;
    private String name;
    private String email;
    private String city;
    private String street;
    private String zipcode;

    public static MemberResponseDto toMemberResponseDto(Member member) {

        MemberResponseDtoBuilder builder = MemberResponseDto.builder();
        builder
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail());

        if(member.getAddress() != null)
            builder
            .city(member.getAddress().getCity())
            .street(member.getAddress().getStreet())
            .zipcode(member.getAddress().getZipcode());

        return builder.build();
    }

}
