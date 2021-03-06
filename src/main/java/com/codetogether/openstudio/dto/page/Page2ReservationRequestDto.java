package com.codetogether.openstudio.dto.page;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Page2ReservationRequestDto {
    private String subjectName;
    private String intraId;

    public Page2ReservationRequestDto(String subjectName, String intraId) {
        this.subjectName = subjectName;
        this.intraId = intraId;
    }
}
