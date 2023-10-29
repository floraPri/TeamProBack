package com.np.wearound.auctionDto;

public class MessageDTO {
    private String sender;
    private String text;

    // 생성자, getter 및 setter 메서드

    // 생성자
    public void Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
    }

    // getter 및 setter 메서드
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}