package com.example.springsecurity_Login.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    //expiration time is 10mins
    private static final int EXPIRATION_TIME = 10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private Date expirationDate;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
                nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFY_TOKEN")
    )
    private User user;

    public VerificationToken(User user, String token){
        super();
        this.token = token;
        this.user = user;
        this.expirationDate = calculateExpirationData(EXPIRATION_TIME);
    }
    public VerificationToken(String token){
        super();
        this.token = token;
        this.expirationDate = calculateExpirationData(EXPIRATION_TIME);
    }

    private Date calculateExpirationData(int expirationTime) {

        Calendar calender = Calendar.getInstance();
        calender.setTimeInMillis(new Date().getTime());
        calender.add(Calendar.MINUTE, EXPIRATION_TIME);
        return new Date(calender.getTime().getTime());
    }

}
