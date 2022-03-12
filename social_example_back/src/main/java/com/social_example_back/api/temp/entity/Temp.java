package com.social_example_back.api.temp.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.social_example_back.api.temp.dto.TempDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TEMP")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Temp {
	@JsonIgnore
    @Id
    @Column(name = "TEMP_SEQ")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tempSeq;

    @Column(name = "EMAIL", length = 512, unique = true)
    @NotNull
    @Size(max = 512)
    private String email;

    @Column(name = "TEMPNAME", length = 100)
    @NotNull
    @Size(max = 100)
    private String tempname;

    @Column(name = "CREATED_AT")
    @NotNull
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    @NotNull
    private LocalDateTime modifiedAt;

    public Temp(
            @NotNull @Size(max = 512) String email,
            @NotNull @Size(max = 100) String tempname,
            @NotNull LocalDateTime createdAt,
            @NotNull LocalDateTime modifiedAt
    ) {
        this.email = email != null ? email : "NO_EMAIL";
        this.tempname = tempname;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
    
	public TempDTO toDTO() {
		return new TempDTO(email,tempname);
	}
}