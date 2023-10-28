package com.np.wearound.auctionEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AUCTIONBIDING")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuctionBidingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int auctionbidderno;

    private int auctionno;
    private String name;
}
