package com.aslam.masterspringjpa.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Polymorphism(type = PolymorphismType.EXPLICIT)
//@PrimaryKeyJoinColumn(name = "video_id")
//@DiscriminatorValue(value = "V")
public class Video extends Resource {
    private int length;
}
